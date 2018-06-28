FROM ubuntu:18.04 as build

WORKDIR /opt

RUN apt-get update
RUN apt-get install -y zip wget

ENV GRADLE_VERSION=4.8.1

# Installing it manually: https://gradle.org/install#manually
RUN wget https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip
RUN unzip gradle-${GRADLE_VERSION}-bin.zip
RUN rm gradle-${GRADLE_VERSION}-bin.zip

# Final image
FROM ubuntu:18.04

WORKDIR /opt

RUN apt-get update && apt-get install -y openjdk-8-jdk

COPY --from=build /opt/* /opt/

ENV PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/opt/bin
