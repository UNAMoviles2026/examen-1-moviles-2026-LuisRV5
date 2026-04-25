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

1. **Entrada y Navegación**: La aplicación utiliza un `NavHost` centralizado que gestiona el flujo entre pantallas. Al iniciar, el usuario aterriza en la lista de espacios de coworking.
2. **Carga de Datos**: La pantalla (`SpacesScreen`) se comunica con el repositorio para obtener los datos (actualmente estáticos/mock) y los expone mediante un estado reactivo.
3. **Interacción del Usuario**: Cuando el usuario selecciona un elemento de la lista, se activa un evento de navegación que envía el identificador del espacio hacia la pantalla de detalle.
4. **Visualización de Detalles**: La pantalla de detalle (`SpaceDetailScreen`) recibe el parámetro, recupera la información específica y la muestra utilizando componentes modulares y reutilizables.
5. **Ciclo de Estado**: Cualquier acción (como presionar el botón de reserva) viaja de regreso desde la UI al ViewModel, manteniendo la lógica de negocio separada de la representación visual.
