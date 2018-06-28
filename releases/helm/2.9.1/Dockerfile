FROM alpine:3.7 as build

WORKDIR /opt

RUN apk add --update --no-cache ca-certificates

# Installing helm
# versions: https://github.com/kubernetes/helm#install
ENV HELM_VERSION 2.9.1

RUN wget https://kubernetes-helm.storage.googleapis.com/helm-v${HELM_VERSION}-linux-amd64.tar.gz
RUN tar -zxvf helm-v${HELM_VERSION}-linux-amd64.tar.gz

# Final image
FROM alpine:3.7

WORKDIR /opt

RUN apk add --update --no-cache ca-certificates

COPY --from=build /opt/linux-amd64/helm /usr/local/bin/
