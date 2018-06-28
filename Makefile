include env_make
NS = garland

#
# kubectl
#
build-kubectl:
	$(call build_docker_container,./kubectl/Dockerfile,kubectl,$(VERSION_KUBECTL))

push-kubeclt:
	$(call push_docker_container,kubectl,$(VERSION_KUBECTL))

#
# helm
#
build-helm:
	$(call build_docker_container,./helm/Dockerfile,helm,$(VERSION_HELM))

push-helm:
	$(call push_docker_container,helm,$(VERSION_HELM))

#
# helm
#
build-kops:
	$(call build_docker_container,./kops/Dockerfile,kops,$(VERSION_KOPS))

push-kops:
	$(call push_docker_container,kops,$(VERSION_KOPS))

#
# gradle
#
build-gradle:
	$(call build_docker_container,./gradle/Dockerfile,gradle,$(VERSION_GRADLE))

push-gradle:
	$(call push_docker_container,gradle,$(VERSION_GRADLE))

#
# aws cli
#
build-aws-cli:
	$(call build_docker_container,./aws-cli/Dockerfile,aws-cli,$(VERSION_AWS_CLI))

push-aws-cli:
	$(call push_docker_container,aws-cli,$(VERSION_AWS_CLI))


#
# Docker build def
#
define build_docker_container
		#
		# Builds a container
		#
		# $(1) - Dockerfile location
		# $(2) - container name postfix
		# $(3) - docker tag
		#
    docker build -f $(1) -t $(NS)/$(2):$(3) .
endef

#
# Docker push def
#
define push_docker_container
		#
		# Push a container to the registry
		#
		# $(1) - container name postfix
		# $(2) - docker tag
		#
    docker push $(NS)/$(1):$(2)
endef
