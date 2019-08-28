FROM openjdk:8-jdk-alpine


ENTRYPOINT [ "sh", "-c", "cd /opt/ && chmod 777 gradlew && ./gradlew   gatlingRun-simulations.EventReservationFilters" ]

WORKDIR  /opt

COPY /  /opt/

RUN wget -q https://services.gradle.org/distributions/gradle-3.3-bin.zip  \
    && unzip gradle-3.3-bin.zip -d /opt \
        && rm gradle-3.3-bin.zip

RUN echo "$PWD"

RUN apk add git


RUN pwd  \
   && find /opt

RUN cd /opt/  \
   &&  chmod 777 gradlew

ENV GRADLE_HOME /opt/gradle-3.3
ENV PATH $PATH:/opt/gradle-3.3/bin
