FROM openjdk:11
ADD target/blog-docker.jar blog-docker.jar
ENTRYPOINT ["java","-jar", "blog-docker.jar"]
