FROM alpine:3.7 as build

WORKDIR /opt

RUN apk add --update --no-cache ca-certificates

# Add Kops
# versions: https://github.com/kubernetes/kops/releases
ENV KOPS_VERSION=1.9.1
RUN wget https://github.com/kubernetes/kops/releases/download/${KOPS_VERSION}/kops-linux-amd64
RUN chmod +x kops-linux-amd64

# Final image
FROM alpine:3.7

WORKDIR /opt

RUN apk add --update --no-cache ca-certificates

COPY --from=build /opt/kops-linux-amd64 /usr/local/bin/kops
