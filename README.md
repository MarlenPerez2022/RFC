<h1> Descripción</h1>

Este proyecto consiste en una aplicación de escritorio en Java para buscar y verificar la existencia de RFCs (Registro Federal de Contribuyentes). 

### Funcionalidades Principales:
- **Búsqueda de RFC:** Permite a los usuarios ingresar un RFC y verificar su existencia en un archivo de texto.
- **Creación de RFC:** Facilita la creación de nuevos RFCs a través de un diálogo interactivo.
- **Interfaz de Usuario Intuitiva:** Ofrece una interfaz sencilla y fácil de usar, con campos de texto y botones claramente identificados.

### Características:
1. **Interfaz gráfica de usuario (GUI):** El código incluye la creación y configuración de una interfaz gráfica de usuario utilizando Swing, una biblioteca de Java para crear aplicaciones de escritorio.
2. **Manejo de eventos de usuario:** Se implementan manejadores de eventos de usuario, como clics de mouse y pérdida de foco, para realizar acciones específicas en respuesta a las interacciones del usuario con los componentes de la interfaz gráfica.
3. **Lectura de archivos:** El código lee datos desde un archivo de texto llamado "datos.txt" ubicado en una ruta específica del sistema de archivos. Utiliza la clase BufferedReader para leer líneas del archivo y buscar coincidencias con un RFC ingresado por el usuario.
4. **Diálogos emergentes:** Se utilizan diálogos emergentes de JOptionPane para mostrar mensajes informativos al usuario, como confirmaciones de búsqueda exitosa o mensajes de error en caso de que no se encuentre el RFC en el archivo.
5. **Gestión de errores:** Se manejan errores mediante el uso de bloques try-catch para capturar excepciones que puedan ocurrir durante la lectura del archivo. En caso de error, se imprime un mensaje de error en la consola.
6. **Separación de componentes:** El código separa la lógica de la interfaz de usuario de la lógica de negocio al mantener la funcionalidad de búsqueda de RFC en un método separado del manejo de eventos de la interfaz de usuario.
7. **Reutilización de componentes:** Se reutilizan componentes de interfaz de usuario, como botones y campos de texto, en diferentes partes de la aplicación para mantener la coherencia visual y reducir la duplicación de código.
8. **Encapsulamiento:** Se utiliza encapsulamiento para acceder y modificar los datos de la interfaz de usuario a través de métodos getter y setter en lugar de acceder directamente a los componentes desde otras partes del código.

| Proyecto       | GestorDeRFC                                              |
|----------------|----------------------------------------------------------|
| Descripción    | La clase GestorDeRFC es responsable de manejar la generación y búsqueda de RFC (Registro Federal de Contribuyentes) en un archivo de datos. Proporciona métodos para buscar un RFC existente y para crear uno nuevo en caso de que no se encuentre en el archivo. |
| Campos         |                                                              |
| - RUTA_ARCHIVO | Contiene la ruta del archivo de datos donde se almacenan los RFC. |
| Métodos        |                                                              |
| + buscarRFC(String rfcBuscado) | Busca un RFC específico en el archivo de datos y devuelve true si se encuentra, false en caso contrario. |
| + crearRFC(String nuevoRFC)     | Crea un nuevo RFC y lo agrega al archivo de datos.         |
| + getRutaArchivo()              | Devuelve la ruta del archivo de datos.                     |
| + setRutaArchivo(String ruta)   | Establece la ruta del archivo de datos.                    |

### Tecnologías Utilizadas:
- Java
- Swing (para la interfaz de usuario)

### Cómo Usar:
1. Descarga el proyecto desde GitHub.
2. Importa el proyecto a tu entorno de desarrollo Java.
3. Ejecuta la aplicación y utiliza la interfaz de usuario para buscar o crear RFCs.


### Colaboradores: 
Marlen Citlalli Pérez Gómez
Edith Esmeralda Pérez Martinez

