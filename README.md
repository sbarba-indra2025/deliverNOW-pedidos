# deliverNOW - Backend Creación de Pedidos

## Descripción

Este repositorio contiene el servicio backend encargado de la **gestión de pedidos**. Permite a los usuarios crear pedidos, seleccionar categorías, proveedores y productos, y almacenar los datos del pedido en la base de datos.

### Funcionalidades principales:
- Crear nuevos pedidos con la selección de productos.
- Almacenar los pedidos en la base de datos.
- Proporcionar la información del pedido para su posterior pago o consulta.

## Flujo de usuario

1. El usuario crea un pedido seleccionando productos y el proveedor.
2. La solicitud se envía a este servicio para registrar el pedido en la base de datos.
3. El sistema devuelve una confirmación del pedido con sus detalles relevantes.
4. El pedido pasa a la siguiente fase del flujo (asignación de repartidor, pago, etc.).

## Cómo ejecutar el servicio de forma individual

Para ejecutar este backend de forma independiente, se pueden seguir estos pasos:

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/sbarba-indra2025/deliverNOW-pedidos.git
   cd deliverNOW-pedidos

2. **Construir la imagen Docker**:

   ```bash
   docker build -t deliverNOW-backend-pedidos .

3. **Ejecuta el contenedor**:

   ```bash
   docker run -p 8081:8080 deliverNOW-backend-pedidos

Esto expondrá el servicio en http://localhost:8081.

Nota: Para ejecutar todos los servicios de la aplicación (frontend + backend + base de datos) de forma conjunta, en el [repositorio de documentación](https://github.com/sbarba-indra2025/deliverNOW-docs/) se pueden encontrar instrucciones para usar docker-compose.

---

## Generar Maven Wrapper

1. **Instalar Maven** siguiendo las instrucciones en la [página oficial](https://maven.apache.org/install.html).
   
2. Abrir la terminal en la raíz del repositorio.

3. Ejecutar el siguiente comando:

   ```bash
   mvn -N io.takari:maven:wrapper

Este comando creará la carpeta .mvn y los archivos necesarios (mvnw, mvnw.cmd y los archivos dentro de .mvn/wrapper) para usar Maven Wrapper.

---

## Compilación del JAR

Para compilar el archivo `JAR` de forma independiente (sin depender de otros servicios), puede hacerse con **Maven** de la siguiente forma:

1. **Instalar Maven** siguiendo las instrucciones en la [página oficial](https://maven.apache.org/install.html).

2. **Compilar el proyecto**: Desde la raíz del repositorio, ejecutar el siguiente comando para compilar el archivo `JAR`:

   ```bash
   mvn clean package

Este comando descargará las dependencias necesarias y generará el archivo JAR en el directorio target/. El nombre del archivo será algo similar a deliverNOW-backend-pedidos-1.0.0.jar (el nombre variará dependiendo de la configuración en el pom.xml).

3. **Ejecutar el archivo JAR**: Una vez que se haya generado el archivo JAR, puede ejecutarse con el siguiente comando:

   ```bash
   java -jar target/*.jar
   
Esto iniciará el backend en el puerto predeterminado (por defecto, Spring Boot suele usar el puerto 8080).
