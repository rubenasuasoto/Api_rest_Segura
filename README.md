# Aplicación de Reparación a Domicilio

### 1. Nombre del Proyecto:
   Aplicación de Reparación a Domicilio
   
   ----------

### 2. Idea del Proyecto:
 La aplicación permite a los usuarios programar citas con talleres mecánicos que ofrecen servicios a domicilio.

 - Los clientes pueden gestionar sus solicitudes de reparación.
 - Los mecánicos pueden organizar y administrar sus citas.
   
   -------------
  
### 3. Justificación del Proyecto:
  La aplicación resuelve problemas comunes como:

 - La falta de tiempo para llevar vehículos a talleres.
 - La dificultad de encontrar servicios mecánicos confiables.
  Con esta solución, los usuarios pueden recibir servicios mecánicos directamente en sus hogares de manera segura y eficiente.
---------------

### 4. Descripción Detallada de las Tablas
    
  Tabla: Usuarios

  Almacena la información de los usuarios, incluyendo clientes y mecánicos.

-   id_usuario: Identificador único (Primary Key).
   
-   nombre: Nombre completo del usuario.
   
-   email: Correo electrónico único.
   
-   password: Contraseña cifrada.
   
-   rol: Rol del usuario (cliente o mecánico).
   
   
--------------
  Tabla: Talleres
  Registra talleres mecánicos y su información básica.

-   id_taller: Identificador único (Primary Key).
   
-   nombre_taller: Nombre del taller.
   
-   direccion: Dirección del taller.
   
-   telefono: Número de contacto.
   
   
   
   --------------------
  Tabla: Citas_Taller
  
  Relaciona a los usuarios con los talleres y almacena las citas programadas.

-   id_cita: Identificador único (Primary Key).
   
-   id_usuario: Referencia al cliente (Foreign Key).
   
-   id_taller: Referencia al taller (Foreign Key).
   
-   fecha: Fecha y hora de la cita.
   
-   servicio: Servicio solicitado.
   
-   estado: Estado de la cita (pendiente, confirmada, cancelada, completada).
   
    --------------------
### 5. Endpoints a Desarrollar
    
  Tabla: Usuarios
  
-   GET /usuarios: Obtiene la lista de usuarios registrados.

-   POST /usuarios: Crea un nuevo usuario.
   
-   PUT /usuarios/{id}: Actualiza la información de un usuario existente.
   
-   DELETE /usuarios/{id}: Elimina un usuario.
   
   --------------------
  Tabla: Talleres
  
-   GET /talleres: Obtiene la lista de talleres.
   
-   POST /talleres: Crea un nuevo taller.
   
-   PUT /talleres/{id}: Actualiza la información de un taller existente.
   
-   DELETE /talleres/{id}: Elimina un taller.
   
 --------------------
  Tabla: Citas_Taller
  
-   GET /citas: Obtiene la lista de citas programadas.
   
-   POST /citas: Crea una nueva cita.
   
-   PUT /citas/{id}: Actualiza la información de una cita existente.
   
-   DELETE /citas/{id}: Cancela una cita.
   
---------
### 7. Lógica de Negocio
    
  Roles de usuario:

-Los clientes pueden crear y consultar sus citas.

-Los mecánicos pueden ver las citas asignadas a su taller.

Estado de las citas:

-Las citas pueden cambiar entre estados: pendiente, confirmada, cancelada, completada.

-----------

### 8. Excepciones y Códigos de Estado:
   
-404 Not Found: Cuando no se encuentra un usuario, taller o cita solicitada.
   
-400 Bad Request: Cuando la entrada proporcionada es inválida.

-401 Unauthorized: Cuando un usuario no tiene permisos para acceder a un recurso.

-500 Internal Server Error: Cuando ocurre un error inesperado en el servidor.

----------------
   
### 9. Restricciones de Seguridad
    
-Uso de JWT (JSON Web Tokens) para autenticar a los usuarios.

-Cifrado asimétrico con claves públicas y privadas para proteger la información sensible.

Restricciones de acceso basadas en roles:

-Solo los mecánicos pueden gestionar talleres y citas.

-Los clientes solo pueden acceder a sus propios datos y citas.

