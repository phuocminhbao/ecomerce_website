FROM openjdk:8
ADD target/EcomerceWebsite-1.0.war EcomerceWebsite-1.0.war
ENTRYPOINT ["java", "-war", "EcomerceWebsite-1.0.war"]