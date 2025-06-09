FROM openjdk:17-alpine

# directorio de trabajo
WORKDIR /app

# copia los archivos del proyecto
COPY . .

# instala Maven si no está presente
RUN apk add --no-cache maven

# si no existe el archivo de Maven Wrapper, lo crea
RUN if [ ! -f "./mvnw" ]; then mvn -N io.takari:maven:wrapper; fi

# si no existe el directorio 'target' o el JAR, compila el proyecto
RUN if [ ! -d "target" ] || [ ! -f "target/*.jar" ]; then ./mvnw clean package; fi

# expone el puerto
EXPOSE 8080

# inicia el proyecto de spring boot
ENTRYPOINT ["java", "-jar", "target/*.jar"]
