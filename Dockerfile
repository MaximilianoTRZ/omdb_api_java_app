FROM openjdk:11

# Install Maven
RUN apt-get update && \
    apt-get install -y maven

WORKDIR /app

# Deletes downloaded package list files
RUN rm -rf /var/lib/apt/lists/*

COPY . .

# Create jar with dependencies
RUN mvn clean compile assembly:single

CMD ["java","-jar","target/omdbmovies-1.0-SNAPSHOT-jar-with-dependencies.jar"]
