FROM openjdk:17-alpine

# directorio de trabajo
WORKDIR /app

# copia los archivos del proyecto
COPY target/*.jar app.jar

# expone el puerto para nginx
EXPOSE 8080

# inicia spring boot
ENTRYPOINT ["java", "-jar", "app.jar"]
