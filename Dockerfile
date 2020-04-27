FROM openjdk:8
MAINTAINER massire dia <diamasta@gmail.com>
EXPOSE 8080
ADD target/gestion-impot-flex.jar gestion-impot-flex.jar
ENTRYPOINT ["java", "-jar", "gestion-impot-flex.jar"]