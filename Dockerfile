FROM openjdk:11
ADD target/atm-list.jar atm-list.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "atm-list.jar"]