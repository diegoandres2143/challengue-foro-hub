# ForoHub

ForoHub es una plataforma de foros desarrollada en Java con Spring Boot, diseñada para facilitar la discusión, el aprendizaje y la colaboración entre usuarios a través de tópicos, cursos y respuestas. Este proyecto es el resultado del desafío final de Alura Latam y representa una API robusta, segura y lista para producción.

## Tabla de Contenidos
- [ForoHub](#forohub)
  - [Tabla de Contenidos](#tabla-de-contenidos)
  - [Descripción General](#descripción-general)
  - [Características Principales](#características-principales)
  - [Arquitectura y Tecnologías](#arquitectura-y-tecnologías)
  - [Instalación y Ejecución](#instalación-y-ejecución)
  - [Uso de la API](#uso-de-la-api)

## Descripción General
ForoHub es una API RESTful que permite la gestión de usuarios, cursos, tópicos y respuestas en un entorno seguro y escalable. Incluye autenticación basada en JWT, migraciones automáticas de base de datos y documentación interactiva con Swagger.

## Características Principales
- **Gestión de Usuarios:** Registro, login y autenticación JWT. Solo usuarios autenticados pueden interactuar con el foro.
- **Gestión de Cursos:** Creación y organización de cursos en categorías.
- **Gestión de Tópicos:** CRUD completo de tópicos de discusión, con visualización de respuestas asociadas.
- **Gestión de Respuestas:** Los usuarios pueden responder y gestionar respuestas en los tópicos.
- **Seguridad:** Endpoints protegidos con Spring Security y JWT.
- **Migraciones:** Versionado de base de datos con Flyway.
- **Documentación:** Swagger UI para explorar y probar la API.

## Arquitectura y Tecnologías
- **Lenguaje:** Java 17
- **Framework:** Spring Boot 3
- **ORM:** Hibernate (JPA)
- **Seguridad:** Spring Security, JWT
- **Base de Datos:** MySQL
- **Migraciones:** Flyway
- **Gestión de dependencias:** Maven

## Instalación y Ejecución
1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/forohub.git
   cd forohub
   ```
2. **Configurar la base de datos:**
   - Edita `src/main/resources/application.properties` con tus credenciales de MySQL.
3. **Ejecutar migraciones:**
   - Flyway ejecutará automáticamente las migraciones al iniciar la app.
4. **Compilar y ejecutar:**
   ```bash
   ./mvnw spring-boot:run
   ```
5. **Acceder a la API:**
   - Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Uso de la API
1. **Registro y Login:**
   - Regístrate y obtén un token JWT.
2. **Autenticación:**
   - Incluye el token en el header `Authorization: Bearer <token>` para acceder a los endpoints protegidos.
3. **Explora los endpoints:**
   - Utiliza Swagger UI para probar todas las funcionalidades.

