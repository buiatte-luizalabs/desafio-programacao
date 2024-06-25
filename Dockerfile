FROM amazoncorretto:17

LABEL MANTAINER="Priscila Rosa"

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} DesafioProgramacaoApplication.jar

RUN rm -f /etc/localtime && ln -s /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime

CMD apt-get update -y

ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/DesafioProgramacaoApplication.jar"]

EXPOSE 8080
