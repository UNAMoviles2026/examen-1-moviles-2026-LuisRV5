### Definir la arquitectura backend basada en capas
Se seguiran las siguientes capas:
Controller, Service y Repository.
Las anteriores son las mas importantes, pero tambien estan los DTOs: response/request, el mapper 
y por supuesto el domain.

### Explicar el rol de cada capa
- Controller: actua como orquestador de las peticiones HTTP, gestione las peticiones y las respuestas
- Service: se encarga de aplicar la logica de negocio y la validacion de los datos
- Repository: se encarga de la persistencia de los datos
- DTOs: son objetos que se usan para transportar datos entre capas (por seguridad)
- Mapper: se encarga de convertir los objetos DTO a objetos de la capa de dominio
- Domain: es donde se definen los objetos que se usan en el sistema
### Describir el flujo de una petición desde el cliente hasta la base de datos
El controller o endpoint recibe una peticion http esta la redirige a la capa de servicios
para que sea validada y se le aplique la logica de negocio, despues el mapper convierte
el request en un objeto para que este pueda ser enviado al repositorio el se encarga de la
persistencia de los datos(es la capa que se comunica con la base de datos)
despues de que el repositorio de una respuesta, el objeto que devolvio se mapea a una
response para que sea retornada a la controlladora y este la devuelva al cliente.

### Justificar las decisiones tomadas

Se seguira la anterior arquitectura porque es de las mas eficientes, cumple con su
proposito sin volver el desarollo del backend demasiado complejo, lo cual retrasaria
la implementacion del sistema, y lo vuelve sencillo de mantaner.