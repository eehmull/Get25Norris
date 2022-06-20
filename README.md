# testCode

La aplicación de TestCode, utiliza el lenguaje JAVA con Dropwizard
para facilidad de crear el endpoint necesario, este contiene un endpoint
que obtiene de una API una lista de 25 elementos únicos. 
Utilizando hilos para obtener la data con mayor rapidez.

El Main del proyecto se encuentra en `src/main/java/com/eehmull/testCode/testCodeApplication.java`

El Main hace un llamado a un resource, que es donde se encuentra
la mayor parte del código, ubicado en `src/main/java/com/eehmull/testCode/resources/ChuckNorrisResource.java`

Como iniciar la aplicación del testCode
---
1. Descargar el repositorio. En el root del proyecto viene un archivo Dockerfile para ejecutar el proyecto.
2. Adentro del Root del proyecto ejecutar `docker build -t test-code`
3. Ejecutar la imagen del docker con `docker run -p 8080:8080 -it test-code`

El proyecto debería de empezar a ejecutarse. Adentro del proyecto viene un endpoint que obtiene una lista de 25 elementos únicos, proporcionada por la API: `https://api.chucknorris.io/`.
Para obtener los 25 elementos se puede utilizar una herramienta como POSTMAN
para hacer el consumo del endpoint. Al tener corriendo el proyecto, utilizar la 
siguiente ruta, para obtener la información siendo una petición de tipo GET:

`http://localhost:8080/get-25`

