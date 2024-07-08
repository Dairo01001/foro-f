## API FORO-HUB

### Requerimentos

- Java 22
- PostgreSQL 15

### Configuración

1. Crear un usuario en PostgreSQL con permisos de superusuario
2. Crear una base de datos en PostgreSQL
3. Reemplazar las variables de entorno en el archivo properties.yml por las correspondientes con las credenciales de la base de datos y jwt secret
4. Ejcutar el proyecto


### API

#### GET [/v1/docs/swagger.html index.html](http://localhost:8080/swagger-ui/index.html)

##### DESCRIPCION

Retorna la documentación de la API

##### REQUUEST

#### POST /auth/sign-in

##### DESCRIPCION

Realiza una autenticación en el sistema

##### REQUUEST

```json
{
    "email": "email@email.com",
    "password": "password"
}

```

##### RESPONSE

```json
{
    "user": "user",
    "email": "email@email.com",
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
}

```

#### POST /auth/sign-up

##### DESCRIPCION

Realiza un registro en el sistema

##### REQUUEST

```json
{
    "user": "user",
    "email": "email@email.com",
    "password": "password"
}

```

##### RESPONSE

```json
{
    "user": "user",
    "email": "email@email.com",
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
}


