♟️ BibliotecAP: Biblioteca de Aperturas de Ajedrez
BibliotecAP es una solución móvil robusta diseñada para que jugadores de ajedrez puedan consultar y estudiar aperturas de forma eficiente. El proyecto sigue los estándares más modernos de desarrollo en Android, garantizando una aplicación escalable, mantenible y con soporte nativo para funcionamiento sin conexión.


🚀 Características Principales
Sincronización en Tiempo Real: Consumo de datos dinámico desde Firebase Firestore.

Modo Offline (Persistencia): Implementación de Room Database para garantizar que las aperturas sigan disponibles sin acceso a internet (Single Source of Truth).

Interfaz Moderna: Uso de RecyclerView y CardView bajo los lineamientos de Material Design 3.

Visualización de Tableros: Integración de imágenes optimizadas mediante la librería Glide.

Canal de Contacto: Uso de Intents implícitos para envío de sugerencias y reportes vía correo electrónico.


🛠️ Stack Tecnológico
Lenguaje: Kotlin 1.9+

Arquitectura: MVVM (Model-View-ViewModel) con patrón Repository.

Base de Datos Local: SQLite mediante Room.

Base de Datos Remota: Firebase Firestore.

Concurrencia: Kotlin Coroutines.

Carga de Imágenes: Glide.

Testing: JUnit 4.


📂 Estructura del Proyecto

data: Modelos de datos y entidades de negocio (Apertura.kt).

db: Configuración de persistencia local (AppDatabase, AperturaDao).

repository: Gestión de datos y lógica de sincronización (AperturaRepository).

viewmodel: Gestión del estado de la UI y lógica de negocio (AperturaViewModel).

ui: Componentes visuales, actividades y adaptadores (MainActivity, DetalleActivity, AperturaAdapter).


🧪 Pruebas Unitarias
El proyecto incluye pruebas automatizadas para asegurar la integridad de la lógica de datos.

Archivo: AperturaTest.kt

Objetivo: Validar la correcta instanciación y consistencia de los modelos de datos.


🔐 Seguridad y Configuración
Para facilitar la revisión, el proyecto incluye las configuraciones necesarias:

Firebase: El archivo google-services.json ya se encuentra incluido en la carpeta /app.

Reglas de Acceso: La base de datos en Firestore está configurada en modo lectura y la API Key está restringida por SHA-1 para garantizar la integridad de los datos.


Instalación: * Clonar el repositorio.

Sincronizar con Gradle.

Ejecutar en un dispositivo o emulador con Android 8.0 (API 26) o superior.
