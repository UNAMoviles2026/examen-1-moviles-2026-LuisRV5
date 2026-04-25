### Tipo de aplicación (nativa, híbrida, etc.)
app nativa de andriod para ofrecer una mejor integracion con android, ademas de un mejor rendimiento 
### Patrón de arquitectura seleccionado
se usara MVVM porque es el estándar recomendado para trabajar aplicaciones nativas de android, ademas
MVVM permite separar la lógica de presentación de la UI, lo cual facilita el mantenimiento 
 
### Justificación técnica basada en el problema planteado
La idea planteada no es lo suficientemente grande como trabajar en arquitecturas pensadas en muchos
sistemas operativos o ambientes, seria una inversion enorme para algo tan sencillo, por lo
que trabajarlo a como lo planté es la forma mas eficiente y eficaz de resolver el problema sin invertir demasiado
en desarollar el sistema
### Diagrama de arquitectura del sistema

Se sigue una estructura de capas unidireccional para asegurar que cada componente tenga una única responsabilidad:

```mermaid

    UI_Layer [Capa de UI - Jetpack Compose]
        A[Screens / Composables]
    
    Presentation_Layer [Capa de Presentación]
        B[ViewModel]
    
    Data_Layer [Capa de Datos]
        C[Repository]
        D[Data Sources / Mock Data]
    

    A -->|Eventos de usuario| B
    B -->|Estado de UI| A
    B -->|Solicitud de datos| C
    C -->|Datos| B
    C -->|Acceso| D
```

### Explicación del flujo general del sistema

1. **Entrada y Navegación**: El usuario interactúa con la aplicación nativa, donde un `NavHost` gestiona el flujo entre las diferentes pantallas (`SpacesScreen`, `SpaceDetailScreen`).
2. **Petición del Cliente (Mobile)**: Al realizar una acción (ej. cargar espacios), la UI se comunica con el `ViewModel`, el cual utiliza el **Repositorio Móvil** para realizar una petición HTTP (usando DTOs para el transporte de datos) hacia el servidor.
3. **Recepción en Backend (Controller)**: El **Controller** del backend recibe la petición HTTP, actuando como orquestador y redirigiéndola hacia la capa de servicios.
4. **Lógica de Negocio (Service)**: El **Service** recibe los datos, aplica la lógica de negocio necesaria y realiza las validaciones pertinentes.5**Acceso a Datos y Persistencia (Repository & Mapper)**: El **Mapper** convierte el DTO en un objeto de **Dominio** para que el **Repository** pueda gestionar la persistencia en la base de datos.
5. **Respuesta al Cliente**: El flujo retorna en sentido inverso; el objeto persistido se mapea de nuevo a un DTO de respuesta, pasando por el Controller hasta llegar al Repositorio Móvil, que actualiza el estado reactivo en el ViewModel para refrescar la UI.
