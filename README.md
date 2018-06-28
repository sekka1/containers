Docker Containers
===================
A set of containers that are small and narrowly focused on one thing.  These are
useful for automated pipelines, as a tool box, or just experimenting with a tool.

## Supported tags and respective `Dockerfile` links

### aws-cli
- [`garland/aws-cli:1.11.185` (*1.11.185/Dockerfile*)](https://github.com/sekka1/containers/blob/master/releases/aws-cli/1.11.185/Dockerfile)
- [`garland/aws-cli:1.15.47` (*1.15.47/Dockerfile*)](https://github.com/sekka1/containers/blob/master/releases/aws-cli/1.15.47/Dockerfile)

### gradle
- [`garland/gradle:4.8.1` (*4.8.1/Dockerfile*)](https://github.com/sekka1/containers/blob/master/releases/gradle/4.8.1/Dockerfile)

### helm
- [`garland/helm:2.9.1` (*2.9.1/Dockerfile*)](https://github.com/sekka1/containers/blob/master/releases/helm/2.9.1/Dockerfile)

### kops
- [`garland/kops:1.9.1` (*1.9.1/Dockerfile*)](https://github.com/sekka1/containers/blob/master/releases/kops/1.9.1/Dockerfile)

### kubectl
- [`garland/kubectl:1.10.4` (*1.10.4/Dockerfile*)](https://github.com/sekka1/containers/blob/master/releases/kubectl/1.10.4/Dockerfile)

## Building and pushing a versioned container

1. Update the `env_make` file with the new version of what you are going to push
2. run the make push command

        make build-gradle
        make push-gradle

# Examples

## Using these utility/tools containers in a Jenkins Pipeline on Kubernetes
These containers can be useful when running the Jenkins Kubernetes plugin.  You can use these
containers to execute commands and/or help you deploy out your application.

Check out the example here: [Jenkins Pipeline on Kubernetes](https://github.com/sekka1/containers/blob/master/examples/jenkins-kubernetes-pipeline)
