DROP DATABASE IF EXISTS andalucia_db;
CREATE DATABASE IF NOT EXISTS andalucia_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE andalucia_db;

-- Crear la tabla personas con estructura adecuada
CREATE TABLE personas (
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    sexo ENUM('M', 'H') NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    provincia VARCHAR(100) NOT NULL,
    municipio VARCHAR(150) NOT NULL,
    nivel_estudios VARCHAR(50),
    situacion_laboral VARCHAR(50),
    ingresos_anuales INT,
    estado_civil VARCHAR(20),
    num_hijos INT,
    nivel_socioeconomico VARCHAR(20),
    ocupacion VARCHAR(50)
);


LOAD DATA INFILE '/var/lib/mysql-files/andalucia.csv' INTO TABLE personas FIELDS TERMINATED BY ','  ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 ROWS;