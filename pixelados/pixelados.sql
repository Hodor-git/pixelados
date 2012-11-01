/*
Navicat MySQL Data Transfer

Source Server         : Probando
Source Server Version : 50136
Source Host           : localhost:3306
Source Database       : pixelados

Target Server Type    : MYSQL
Target Server Version : 50136
File Encoding         : 65001

Date: 2012-10-29 20:06:13
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `analisis_sistema_informatico`
-- ----------------------------
DROP TABLE IF EXISTS `analisis_sistema_informatico`;
CREATE TABLE `analisis_sistema_informatico` (
  `id` int(11) unsigned NOT NULL,
  `usuarioID` int(11) unsigned NOT NULL,
  `fecha_publicacion` date NOT NULL,
  `introduccion` text COLLATE utf8_spanish_ci NOT NULL,
  `tecnicamente_hablando` text COLLATE utf8_spanish_ci NOT NULL,
  `que_nos_aporto` text COLLATE utf8_spanish_ci NOT NULL,
  `recordando_experiencias` text COLLATE utf8_spanish_ci NOT NULL,
  `conclusiones_nostalgicas` text COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_analisis_sistema_informatico_usuarios1` (`usuarioID`),
  CONSTRAINT `fk_analisis_sistema_informatico_usuarios1` FOREIGN KEY (`usuarioID`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Análisis de los diferentes sistemas informáticos.';

-- ----------------------------
-- Records of analisis_sistema_informatico
-- ----------------------------
INSERT INTO `analisis_sistema_informatico` VALUES ('54', '52', '2012-09-27', 'Esta es la introducción', 'Datos técnicos van aquí', 'Lo que nos ha aportado esta cosa', 'Recordando que es gerundio', 'Las conclusiones antes de irnos');
INSERT INTO `analisis_sistema_informatico` VALUES ('55', '52', '2012-10-10', 'Intro Vic-20', 'Datos del Vic-20', 'Aportaciones del Commodore Vic-20', 'Experiencias del Commodore pequeñito', 'Concluyendo cositas del Vic-20');

-- ----------------------------
-- Table structure for `categoria`
-- ----------------------------
DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_categoria` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of categoria
-- ----------------------------
INSERT INTO `categoria` VALUES ('58', 'arcade');

-- ----------------------------
-- Table structure for `comentarios`
-- ----------------------------
DROP TABLE IF EXISTS `comentarios`;
CREATE TABLE `comentarios` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `usuarioID` int(11) unsigned NOT NULL,
  `fecha_publicacion` date NOT NULL,
  `seccionID` bigint(3) NOT NULL,
  `comentario` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `seccionwebID` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comentarios_usuarios1` (`usuarioID`),
  KEY `fk_comentarios_seccion_web1` (`seccionwebID`),
  KEY `fecha_publicacion_UNIQUE` (`fecha_publicacion`) USING BTREE,
  KEY `usuarioID_UNIQUE` (`usuarioID`) USING BTREE,
  KEY `seccionID_UNIQUE` (`seccionID`) USING BTREE,
  CONSTRAINT `fk_comentarios_seccion_web1` FOREIGN KEY (`seccionwebID`) REFERENCES `seccion_web` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comentarios_usuarios1` FOREIGN KEY (`usuarioID`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Almacén de los comentarios de secciones.';

-- ----------------------------
-- Records of comentarios
-- ----------------------------
INSERT INTO `comentarios` VALUES ('95', '53', '2012-10-26', '54', 'nuevo para commodore 64', '0000000001');
INSERT INTO `comentarios` VALUES ('98', '53', '2012-10-26', '54', 'ajax commodore 64', '0000000001');
INSERT INTO `comentarios` VALUES ('99', '53', '2012-10-26', '55', 'ajax vic20', '0000000001');
INSERT INTO `comentarios` VALUES ('103', '53', '2012-10-28', '1', 'probando', '0000000002');
INSERT INTO `comentarios` VALUES ('104', '53', '2012-10-28', '2', 'probando segundo artículo', '0000000002');

-- ----------------------------
-- Table structure for `contenido_web`
-- ----------------------------
DROP TABLE IF EXISTS `contenido_web`;
CREATE TABLE `contenido_web` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `usuarioID` int(11) unsigned NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_publicacion` date NOT NULL,
  `contenido` text COLLATE utf8_spanish_ci NOT NULL,
  `tipocontenidoID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `fk_contenido_web_usuarios1` (`usuarioID`),
  KEY `fk_contenido_web_tipo_contenido1` (`tipocontenidoID`),
  CONSTRAINT `fk_contenido_web_tipo_contenido1` FOREIGN KEY (`tipocontenidoID`) REFERENCES `tipo_contenido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contenido_web_usuarios1` FOREIGN KEY (`usuarioID`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Almacén de los artículos, guías y retroanálisis.';

-- ----------------------------
-- Records of contenido_web
-- ----------------------------
INSERT INTO `contenido_web` VALUES ('1', '52', 'Artículo de prueba.', '2012-10-17', 'En este artículo simplemente ponemos a prueba la web.', '1');
INSERT INTO `contenido_web` VALUES ('2', '53', 'Otro articulillo más.', '2012-10-25', 'Más contenido para probar si todo funciona como debiera.', '1');

-- ----------------------------
-- Table structure for `creadores`
-- ----------------------------
DROP TABLE IF EXISTS `creadores`;
CREATE TABLE `creadores` (
  `id` int(9) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipo_creadorID` int(10) unsigned NOT NULL,
  `paisID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_creadores_tipo_creador1` (`tipo_creadorID`),
  KEY `fk_creadores_pais1` (`paisID`),
  CONSTRAINT `fk_creadores_pais1` FOREIGN KEY (`paisID`) REFERENCES `pais` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_creadores_tipo_creador1` FOREIGN KEY (`tipo_creadorID`) REFERENCES `tipo_creador` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Almacena la información de fabricantes y desarrolladores';

-- ----------------------------
-- Records of creadores
-- ----------------------------
INSERT INTO `creadores` VALUES ('50', 'Ultimate', 'Programó titulos míticos', '49', '48');

-- ----------------------------
-- Table structure for `el_joystick`
-- ----------------------------
DROP TABLE IF EXISTS `el_joystick`;
CREATE TABLE `el_joystick` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `usuarioID` int(11) unsigned NOT NULL,
  `fecha_publicacion` date NOT NULL,
  `introduccion` text COLLATE utf8_spanish_ci NOT NULL,
  `como_lucia` text COLLATE utf8_spanish_ci NOT NULL,
  `como_sonaba` text COLLATE utf8_spanish_ci NOT NULL,
  `jugabilidad` text COLLATE utf8_spanish_ci NOT NULL,
  `conclusiones_nostalgicas` text COLLATE utf8_spanish_ci NOT NULL,
  `puntuacion` double NOT NULL,
  `pendiente_moderacion` tinyint(1) NOT NULL DEFAULT '1',
  `sistemaID` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_el_joystick_usuarios1` (`usuarioID`),
  KEY `fk_el_joystick_sistema_informatico1` (`sistemaID`),
  CONSTRAINT `fk_el_joystick_sistema_informatico1` FOREIGN KEY (`sistemaID`) REFERENCES `sistema_informatico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_el_joystick_usuarios1` FOREIGN KEY (`usuarioID`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Tabla para los analisis de juegos: sección "El Joystick"';

-- ----------------------------
-- Records of el_joystick
-- ----------------------------
INSERT INTO `el_joystick` VALUES ('56', '52', '2012-09-27', 'Esta es la intro', 'Esto es como lucía', 'Esto es cómo sonaba', 'Aquí viene la jugabilidad', 'Las conclusiones del asunto', '8', '0', '55');

-- ----------------------------
-- Table structure for `el_joystick_por_juego`
-- ----------------------------
DROP TABLE IF EXISTS `el_joystick_por_juego`;
CREATE TABLE `el_joystick_por_juego` (
  `juegoID` int(11) unsigned NOT NULL,
  `analisisID` int(11) unsigned NOT NULL,
  PRIMARY KEY (`juegoID`,`analisisID`),
  KEY `fk_el_joystick_por_juego_juegos1` (`juegoID`),
  KEY `fk_el_joystick_por_juego_el_joystick1` (`analisisID`),
  CONSTRAINT `fk_el_joystick_por_juego_el_joystick1` FOREIGN KEY (`analisisID`) REFERENCES `el_joystick` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_el_joystick_por_juego_juegos1` FOREIGN KEY (`juegoID`) REFERENCES `juegos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of el_joystick_por_juego
-- ----------------------------
INSERT INTO `el_joystick_por_juego` VALUES ('57', '56');

-- ----------------------------
-- Table structure for `fotos`
-- ----------------------------
DROP TABLE IF EXISTS `fotos`;
CREATE TABLE `fotos` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `ruta_enlace` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Lugar donde almacenar las fotos de juegos y sistemas';

-- ----------------------------
-- Records of fotos
-- ----------------------------

-- ----------------------------
-- Table structure for `fotos_por_juego`
-- ----------------------------
DROP TABLE IF EXISTS `fotos_por_juego`;
CREATE TABLE `fotos_por_juego` (
  `juegoID` int(11) unsigned NOT NULL,
  `fotoID` int(11) unsigned NOT NULL,
  PRIMARY KEY (`juegoID`,`fotoID`),
  KEY `fk_fotos_por_juego_juegos1` (`juegoID`),
  KEY `fk_fotos_por_juego_fotos1` (`fotoID`),
  CONSTRAINT `fk_fotos_por_juego_fotos1` FOREIGN KEY (`fotoID`) REFERENCES `fotos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fotos_por_juego_juegos1` FOREIGN KEY (`juegoID`) REFERENCES `juegos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of fotos_por_juego
-- ----------------------------

-- ----------------------------
-- Table structure for `fotos_por_sistema`
-- ----------------------------
DROP TABLE IF EXISTS `fotos_por_sistema`;
CREATE TABLE `fotos_por_sistema` (
  `fotoID` int(11) unsigned NOT NULL,
  `sistemaID` int(11) unsigned NOT NULL,
  PRIMARY KEY (`fotoID`,`sistemaID`),
  KEY `fk_fotos_por_sistema_fotos1` (`fotoID`),
  KEY `fk_fotos_por_sistema_sistemas_informaticos1` (`sistemaID`),
  CONSTRAINT `fk_fotos_por_sistema_fotos1` FOREIGN KEY (`fotoID`) REFERENCES `fotos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fotos_por_sistema_sistemas_informaticos1` FOREIGN KEY (`sistemaID`) REFERENCES `sistema_informatico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of fotos_por_sistema
-- ----------------------------

-- ----------------------------
-- Table structure for `genero`
-- ----------------------------
DROP TABLE IF EXISTS `genero`;
CREATE TABLE `genero` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Almacen de genero y nombre';

-- ----------------------------
-- Records of genero
-- ----------------------------

-- ----------------------------
-- Table structure for `genero_por_juego`
-- ----------------------------
DROP TABLE IF EXISTS `genero_por_juego`;
CREATE TABLE `genero_por_juego` (
  `juegoID` int(11) unsigned NOT NULL,
  `generoID` int(11) unsigned NOT NULL,
  PRIMARY KEY (`juegoID`,`generoID`),
  KEY `fk_genero_por_juego_juegos2` (`juegoID`),
  KEY `fk_genero_por_juego_genero1` (`generoID`),
  CONSTRAINT `fk_genero_por_juego_genero1` FOREIGN KEY (`generoID`) REFERENCES `genero` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_genero_por_juego_juegos2` FOREIGN KEY (`juegoID`) REFERENCES `juegos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Cada juego puede tener más de un género.';

-- ----------------------------
-- Records of genero_por_juego
-- ----------------------------

-- ----------------------------
-- Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('108');

-- ----------------------------
-- Table structure for `juegos`
-- ----------------------------
DROP TABLE IF EXISTS `juegos`;
CREATE TABLE `juegos` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(70) NOT NULL,
  `fecha_lanzamiento` date NOT NULL,
  `creadorID` int(9) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_juegos_creadores1` (`creadorID`),
  CONSTRAINT `fk_juegos_creadores1` FOREIGN KEY (`creadorID`) REFERENCES `creadores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1 COMMENT='Tabla donde almacenar los juegos de la web';

-- ----------------------------
-- Records of juegos
-- ----------------------------
INSERT INTO `juegos` VALUES ('57', 'Uridium', '2012-09-27', '50');

-- ----------------------------
-- Table structure for `juegos_por_sistema`
-- ----------------------------
DROP TABLE IF EXISTS `juegos_por_sistema`;
CREATE TABLE `juegos_por_sistema` (
  `juegoID` int(11) unsigned NOT NULL,
  `sistemaID` int(11) unsigned NOT NULL,
  PRIMARY KEY (`juegoID`,`sistemaID`),
  KEY `fk_juegos_por_sistema_juegos1` (`juegoID`),
  KEY `fk_juegos_por_sistema_sistemas_informaticos1` (`sistemaID`),
  CONSTRAINT `fk_juegos_por_sistema_juegos1` FOREIGN KEY (`juegoID`) REFERENCES `juegos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_juegos_por_sistema_sistemas_informaticos1` FOREIGN KEY (`sistemaID`) REFERENCES `sistema_informatico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of juegos_por_sistema
-- ----------------------------
INSERT INTO `juegos_por_sistema` VALUES ('57', '55');

-- ----------------------------
-- Table structure for `pais`
-- ----------------------------
DROP TABLE IF EXISTS `pais`;
CREATE TABLE `pais` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `foto_bandera` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of pais
-- ----------------------------
INSERT INTO `pais` VALUES ('48', 'Reino Unido', '/banderas/uk.png');

-- ----------------------------
-- Table structure for `portada`
-- ----------------------------
DROP TABLE IF EXISTS `portada`;
CREATE TABLE `portada` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `contenido` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `enlace_web` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `enlace_foto` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha` date NOT NULL,
  `categoriaID` int(3) unsigned NOT NULL,
  `seccionID` int(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_portada_categoria1` (`categoriaID`),
  KEY `fk_portada_seccion1` (`seccionID`),
  CONSTRAINT `fk_portada_categoria1` FOREIGN KEY (`categoriaID`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_portada_seccion1` FOREIGN KEY (`seccionID`) REFERENCES `seccion` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Tabla donde almacenar "Hoy presentamos" y "Noticias"';

-- ----------------------------
-- Records of portada
-- ----------------------------
INSERT INTO `portada` VALUES ('60', 'Contenido prueba', 'Enlace web prueba', 'Enlace foto prueba', '2012-10-04', '58', '59');

-- ----------------------------
-- Table structure for `seccion`
-- ----------------------------
DROP TABLE IF EXISTS `seccion`;
CREATE TABLE `seccion` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_seccion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='"Hoy presentamos", "Noticias"';

-- ----------------------------
-- Records of seccion
-- ----------------------------
INSERT INTO `seccion` VALUES ('59', 'noticias');

-- ----------------------------
-- Table structure for `seccion_web`
-- ----------------------------
DROP TABLE IF EXISTS `seccion_web`;
CREATE TABLE `seccion_web` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of seccion_web
-- ----------------------------
INSERT INTO `seccion_web` VALUES ('0000000001', 'analisis');
INSERT INTO `seccion_web` VALUES ('0000000002', 'articulo');
INSERT INTO `seccion_web` VALUES ('0000000003', 'entrevista');
INSERT INTO `seccion_web` VALUES ('0000000004', 'eljoystick');
INSERT INTO `seccion_web` VALUES ('0000000005', 'tutorial');

-- ----------------------------
-- Table structure for `sistema_informatico`
-- ----------------------------
DROP TABLE IF EXISTS `sistema_informatico`;
CREATE TABLE `sistema_informatico` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_lanzamiento` date NOT NULL,
  `creadorID` int(9) unsigned NOT NULL,
  `tiposistemaID` int(10) unsigned NOT NULL,
  `datos_tecnicos` text COLLATE utf8_spanish_ci NOT NULL,
  `emulacion` text COLLATE utf8_spanish_ci,
  `analisisID` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fk_sistema_informatico_analisis_sistema_informatico1` (`analisisID`),
  KEY `fk_sistemas_informaticos_creadores1` (`creadorID`),
  KEY `fk_sistemas_informaticos_tipo_sistema1` (`tiposistemaID`),
  CONSTRAINT `fk_sistemas_informaticos_creadores1` FOREIGN KEY (`creadorID`) REFERENCES `creadores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sistemas_informaticos_tipo_sistema1` FOREIGN KEY (`tiposistemaID`) REFERENCES `tipo_sistema` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sistema_informatico_analisis_sistema_informatico1` FOREIGN KEY (`analisisID`) REFERENCES `analisis_sistema_informatico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Tabla donde almacenar los sistemas';

-- ----------------------------
-- Records of sistema_informatico
-- ----------------------------
INSERT INTO `sistema_informatico` VALUES ('55', 'commodore64', '2012-09-27', '50', '53', 'Datos técnicos', 'Texto para hablar de la emulación', '54');
INSERT INTO `sistema_informatico` VALUES ('60', 'commodorevic20', '2012-10-10', '50', '53', 'Datos del Vic-20', 'Emulación del ordenador Vic-20', '55');

-- ----------------------------
-- Table structure for `soporte`
-- ----------------------------
DROP TABLE IF EXISTS `soporte`;
CREATE TABLE `soporte` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `soporte_nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Tabla donde guardar los distintos soportes';

-- ----------------------------
-- Records of soporte
-- ----------------------------

-- ----------------------------
-- Table structure for `soporte_por_juego`
-- ----------------------------
DROP TABLE IF EXISTS `soporte_por_juego`;
CREATE TABLE `soporte_por_juego` (
  `juegoID` int(11) unsigned NOT NULL,
  `soporteID` int(3) unsigned NOT NULL,
  PRIMARY KEY (`juegoID`,`soporteID`),
  KEY `fk_soporte_por_juego_juegos1` (`juegoID`),
  KEY `fk_soporte_por_juego_soporte1` (`soporteID`),
  CONSTRAINT `fk_soporte_por_juego_juegos1` FOREIGN KEY (`juegoID`) REFERENCES `juegos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_soporte_por_juego_soporte1` FOREIGN KEY (`soporteID`) REFERENCES `soporte` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Tabla de soportes por cada juego';

-- ----------------------------
-- Records of soporte_por_juego
-- ----------------------------

-- ----------------------------
-- Table structure for `tipo_contenido`
-- ----------------------------
DROP TABLE IF EXISTS `tipo_contenido`;
CREATE TABLE `tipo_contenido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='articulo'',''guiastutoriales'',''retroanalisis'', ''entrevistas';

-- ----------------------------
-- Records of tipo_contenido
-- ----------------------------
INSERT INTO `tipo_contenido` VALUES ('1', 'articulo');
INSERT INTO `tipo_contenido` VALUES ('2', 'guiastutoriales');
INSERT INTO `tipo_contenido` VALUES ('3', 'entrevista');

-- ----------------------------
-- Table structure for `tipo_creador`
-- ----------------------------
DROP TABLE IF EXISTS `tipo_creador`;
CREATE TABLE `tipo_creador` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Diferencia entre fabricante y desarrollador';

-- ----------------------------
-- Records of tipo_creador
-- ----------------------------
INSERT INTO `tipo_creador` VALUES ('49', 'Desarrollador');

-- ----------------------------
-- Table structure for `tipo_permiso`
-- ----------------------------
DROP TABLE IF EXISTS `tipo_permiso`;
CREATE TABLE `tipo_permiso` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_permiso` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='admin'',''invitado'',''registrado'',''colaborador'',''baneado''';

-- ----------------------------
-- Records of tipo_permiso
-- ----------------------------
INSERT INTO `tipo_permiso` VALUES ('51', 'administrador');
INSERT INTO `tipo_permiso` VALUES ('52', 'usuario');

-- ----------------------------
-- Table structure for `tipo_sistema`
-- ----------------------------
DROP TABLE IF EXISTS `tipo_sistema`;
CREATE TABLE `tipo_sistema` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of tipo_sistema
-- ----------------------------
INSERT INTO `tipo_sistema` VALUES ('53', 'Consola 16bits');

-- ----------------------------
-- Table structure for `usuarios`
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `fechaRegistro` date NOT NULL,
  `salt` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `avatar` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `tipopermisoID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usuarios_tipo_permiso1` (`tipopermisoID`),
  CONSTRAINT `fk_usuarios_tipo_permiso1` FOREIGN KEY (`tipopermisoID`) REFERENCES `tipo_permiso` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Tabla para almacenar los usuarios registrados.';

-- ----------------------------
-- Records of usuarios
-- ----------------------------
INSERT INTO `usuarios` VALUES ('52', 'fulanito', 'gafotas', 'fulanito@fulano.com', '2012-09-27', '434lkj34kjhjhjkh', '/la que sea', '51');
INSERT INTO `usuarios` VALUES ('53', 'pepito', 'piscinas', 'pepito@hjhk.com', '2012-10-01', 'sdwerwrs34', '/la que sea', '52');
