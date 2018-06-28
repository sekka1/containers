FROM alpine:3.7 as build

WORKDIR /opt

RUN apk add --update --no-cache ca-certificates

ENV KUBECTL_VERSION 1.10.4

RUN wget https://storage.googleapis.com/kubernetes-release/release/v${KUBECTL_VERSION}/bin/linux/amd64/kubectl
RUN chmod +x kubectl

# Final image
FROM alpine:3.7

WORKDIR /opt

RUN apk add --update --no-cache ca-certificates

COPY --from=build /opt/kubectl /usr/local/bin/
