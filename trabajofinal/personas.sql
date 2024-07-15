-- create schema personas;

use `personas`;
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(255) NOT NULL UNIQUE,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `telefono` bigint,
  `email` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `usuarios` (`id`, `usuario`, `nombre`, `apellido`, `telefono`, `email`, `password`) VALUES
(1, 'aalvarez', 'Adolfo', 'Alvarez', '1551123456', 'adolfoalvarez@email.com', 'abc123'),
(2, 'agomez', 'Américo', 'Gómez', '1551123457', 'americogomez@email.com', 'def456'),
(3, 'fexposito', 'Felicia', 'Expósito', '1551123458', 'feliciaexposito@email.com', 'ghi789'),
(4, 'acortes', 'Agripina', 'Cortés', '1551123459', 'agripinacortes@email.com', 'jkl123'),
(5, 'ecabello', 'Elsa', 'Cabello', '1551123460', 'elsacabello@email.com', 'mno456');

-- UPDATE `personas`.`usuarios` SET `email` = 'agripinacortes@email.com' WHERE (`id` = '4');

-- DELETE FROM `personas`.`usuarios` WHERE (`id` = '7');

use `personas`;
SELECT * FROM usuarios;