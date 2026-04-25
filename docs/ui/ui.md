### Estructura de la interfaz implementada

La interfaz se basa en una arquitectura de **Contenedores de Alto Nivel (Scaffolding)**, donde cada pantalla principal sigue un patrón consistente:
- **Top Bar**: Un `CenterAlignedTopAppBar` que proporciona contexto y navegación hacia atrás.
- **Content Area**: Uso de `LazyColumn` para listas eficientes y `Column` con scroll para vistas de detalle.
- **Bottom Bar**: Una barra de navegación persistente (`AppBottomBar`) que permite el cambio rápido entre las secciones principales de la app.

### Lista de composables creados

- **Pantallas (Screens)**:
    - `SpacesScreen`: Lista principal de espacios disponibles.
    - `SpaceDetailScreen`: Vista detallada de un espacio individual.
- **Componentes de UI**:
    - `CoworkingSpaceCard`: Representación visual de un espacio en la lista.
    - `SpaceDetailHeader`: Cabecera de la sección de detalles.
    - `SpaceDetailInfo`: Contenedor de información técnica del espacio.

### Identificación de componentes reutilizables

Para maximizar la eficiencia y consistencia, se han extraído los siguientes componentes:
1.  **`AppBottomBar`**: Centraliza la navegación inferior, evitando duplicación de código en cada pantalla.
2.  **`AppButton`**: Un botón personalizado con los estilos del tema global (`AppPrimary`).
3.  **`AvailabilityBadge`**: Indicador visual de estado (disponible/no disponible) que se usa tanto en la lista como en el detalle.
4.  **`SpaceDetailInfoRow`**: Un componente genérico para mostrar pares de Icono-Etiqueta-Valor, facilitando la expansión de información en el futuro.

### Justificación de la organización de la interfaz

- **Modularidad**: Al separar los componentes (en la carpeta `ui/components`) de las pantallas (en `ui/screens`), facilitamos la realización de pruebas unitarias de UI y el mantenimiento.
- **Consistencia Visual**: El uso de un tema centralizado (`ExamenMovilesTheme`) y componentes compartidos asegura que los colores, tipografías y espaciados sean uniformes en toda la aplicación.
- **Experiencia de Usuario (UX)**: Se priorizó la claridad visual mediante el uso de iconos descriptivos y etiquetas de estado llamativas, permitiendo que el usuario identifique rápidamente la disponibilidad y el precio de los espacios.
