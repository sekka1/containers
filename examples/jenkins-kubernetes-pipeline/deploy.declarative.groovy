pipeline {
  agent {
    kubernetes {
      label 'jenkins-worker'
      defaultContainer 'jnlp'
      yaml """
apiVersion: v1
kind: Pod
metadata:
  labels:
    app: jenkins-worker
spec:
  containers:
  - name: kubectl
    image: garland/kubectl:1.10.4
    command:
    - cat
    tty: true
  - name: helm
    image: garland/helm:2.9.1
    command:
    - cat
    tty: true
"""
    }
  }

  parameters {
    string(name: 'KUBE_NAMESPACE', defaultValue: 'none', description: 'What kube namespace should this be deployed to.')
  }

  environment {
    KUBE_NAMESPACE = "${params.KUBE_NAMESPACE}"
  }

  stages {
    stage('run-in-kubectl-container') {
      steps {
        container('kubectl') {

          script {

            // Get the Jenkins credential named CREDENTIAL_KUBE_CONFIG and set it to the
            // the "KUBECONFIG" environment parameter.  kubectl will look for this parameter
            // and use the kube config here.
            withCredentials([file(credentialsId: "CREDENTIAL_KUBE_CONFIG", variable: 'KUBECONFIG')]) {

              try {
                sh """
                  kubectl get pods
                """
              }
              catch (exc) {
                println "Failed to run successfully - ${currentBuild.fullDisplayName}"
                throw (exc)
              }
            }

          }

        }
      }
    }
    stage('run-in-helm-container') {
      steps {
        container('helm') {

          script {

            // Get the Jenkins credential named CREDENTIAL_KUBE_CONFIG and set it to the
            // the "KUBECONFIG" environment parameter.  helm will look for this parameter
            // and use the kube config here.
            withCredentials([file(credentialsId: "CREDENTIAL_KUBE_CONFIG", variable: 'KUBECONFIG')]) {

              try {
                sh """
                  helm list
                """
              }
              catch (exc) {
                println "Failed to run successfully - ${currentBuild.fullDisplayName}"
                throw (exc)
              }
            }

          }

        }
      }
    }

  }
}
