CREATE TABLE IF NOT EXISTS Usuarios(
    dtype VARCHAR(31) NOT NULL,
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    contraseña VARCHAR(255),
    email VARCHAR(255),
    nombre VARCHAR(255),
    tipoUsuario INTEGER,
    userID VARCHAR(255),
    grupos VARCHAR(255),
    materias VARCHAR(255),
    curso VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Pruebas(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255),
    enlace VARCHAR(255),
    materia VARCHAR(255),
    Docente_id BIGINT,
    FOREIGN KEY (Docente_id) REFERENCES Usuarios(id)
);

CREATE TABLE IF NOT EXISTS Preguntas(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    imagen VARCHAR(255),
    peso DOUBLE,
    pregunta VARCHAR(255),
    respuesta VARCHAR(255),
    Prueba_ID BIGINT, 
    FOREIGN KEY(Prueba_ID) REFERENCES Pruebas(id)
);

CREATE TABLE IF NOT EXISTS Notas(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    materia VARCHAR(255),
    nota DOUBLE,
    Prueba_ID BIGINT, 
    FOREIGN KEY(Prueba_ID) REFERENCES Pruebas(id),
    Estudiante_id BIGINT,
    FOREIGN KEY (Estudiante_id) REFERENCES Usuarios(id)
);

CREATE TABLE IF NOT EXISTS Respuestas(
    dtype VARCHAR(31) NOT NULL,
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    Respuestas_abiertas VARCHAR(255),
    Respuestas_Multiples INTEGER,
    Respuestas_Unica INTEGER,
    Estudiante_id BIGINT,
    FOREIGN KEY (Estudiante_id) REFERENCES usuarios(id),
    Prueba_id BIGINT
);




