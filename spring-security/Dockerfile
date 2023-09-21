FROM openjdk:17-jdk
EXPOSE 8080
# check for the jar file in the folder
ARG JAR_FILE=build/libs/*.jar
# copy the jar file into the docker rename it to application.jar
COPY  ${JAR_FILE}   app.jar
ENTRYPOINT [ "java","-jar","app.jar" ]