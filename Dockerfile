# Use an official GraalVM image as a parent image
FROM ghcr.io/graalvm/jdk-community:21

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/odoo-combat.jar /app/odoo-combat.jar

# Copy the entire project directory into the container
COPY . /app

# Expose the port the app runs on
EXPOSE 8080

# Set environment variables for database configuration
ENV SPRING_DATASOURCE_URL=${SPRING_DATASOURCE_URL}
ENV SPRING_DATASOURCE_USERNAME=${SPRING_DATASOURCE_USERNAME}
ENV SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD}

# Specify the command to run on container start
CMD ["java", "-jar", "odoo-combat.jar"]