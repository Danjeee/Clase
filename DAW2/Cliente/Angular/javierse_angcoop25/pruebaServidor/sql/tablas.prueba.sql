-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-11-2024 a las 06:41:30
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


--
-- Base de datos: `coop25`
--
use `prueba`;
drop table if exists `ventas`;
drop table if exists `articulos`;
drop table if exists `categorias`;
drop table if exists `socios`;



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulos`
--

CREATE TABLE `articulos` (
  `id` int(11) NOT NULL,
  `categoria` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` float NOT NULL,
  `imagen` varchar(255) NOT NULL,
  `vendedor` int(11) NOT NULL,
  `estado` char(1) NOT NULL DEFAULT 'D'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `articulos`
--

INSERT INTO `articulos` (`id`, `categoria`, `nombre`, `descripcion`, `precio`, `imagen`, `vendedor`, `estado`) VALUES
(1, 13, 'Mochila senderismo', 'Mochila senderismo 50 L, cubierta impermiable ', 33.99, 'mochilaSenderismo.png', 2, 'D'),
(2, 9, 'Auriculares de botón', 'Auriculares de botón inalámbricos umi. \nColor rojo ', 69.99, 'auriculares_boton_umi.jpg', 3, 'D'),
(3, 4, 'Patín eléctrico', 'Scooter eléctrico M365 ', 55, 'patinElectrico.png', 4, 'D'),
(4, 11, 'Moto eléctrica', 'Moto Eléctrica Infantil Coche Triciclo Vespa Scooter Eléctrico a Batería con Luz MP3 USB Bocina para Niños Más de 3 Años Carga 25kg ', 139.95, 'moto_electrica_infantil.jpg', 2, 'D'),
(6, 2, 'Casco Moto Joker', 'CASCO MT CASCO MT TARGO JOKER EDICIÓN LIMITADA FLUOR M ', 78.79, 'casco_moto.joker.jpg', 2, 'D'),
(7, 3, 'Tienda de campaña', 'Tienda campaña 4 plazas impermeable ', 133.53, 'tiendaCampanya.png', 2, 'D'),
(8, 5, 'Panel solar ', 'Panel solar de policristalino de 1,5 x 5 m. ', 109.9, 'panelSolar.png', 2, 'D'),
(9, 12, 'Pulsera actividad ', 'Pulsera actividad multifunción ', 11.22, 'pulseraActividad.png', 2, 'D'),
(11, 12, 'Bicicleta Indoor', 'Bicicleta estática Indoor. ', 189.99, 'bicicleta_Indoor.jpg', 2, 'D'),
(12, 13, 'Mochila senderismo', 'Mochila Senderismo Montaña Trekking Macutos de Viaje Acampada Marcha. 40 L ', 33, 'mochila_senderismo_azul.jpg', 2, 'D'),
(13, 13, 'Kit Supervivencia', 'Kit de Supervivencia 14 en 1 multifuncional Kits Tácticos con Navaja Linterna Manta de Emergencia y Pulsera de Paracord para Acampada Senderismo Excursión Montañismo Viaje al Aire Libre ', 49.95, 'kit_supervivencia.jpg', 2, 'D'),
(14, 1, 'Patín autoequilibrio', 'Patín auto-equilibrio rojo ', 300.99, 'patinAutoequilibrio.png', 2, 'D'),
(15, 7, 'Portatil Lenovo', 'Portatil táctil convertible 14 Intel core I-3, 4GB RAM, 128 GB SSD, Windows 10', 539.99, 'portatilLenovo.png', 2, 'D'),
(18, 3, 'Curso de PHP 8 y MySQL 8', 'Aprenda PHP y MySQL con ejemplos.', 25.5, 'php-mysql.jpg', 4, 'D'),
(19, 14, 'Arboleda en otoño', 'Arboleda en otoño al oleo', 39.99, 'variaciones2.jpg', 4, 'D'),
(20, 7, 'Medion Akoya e23403', 'Medion Akoya e23403 Intel Core i3', 1762, '1762-medion-akoya-e23403-intel-core-i3-1005g1-8gb-256gb-ssd-238.webp', 4, 'D'),
(21, 14, 'Un nuevo día', 'Un nuevo día', 350.5, 'unnuevodia.jpg', 4, 'D'),
(22, 3, 'Node JS', 'JavaScript en el lado del servidor.', 25, 'node.jpg', 4, 'D'),
(23, 14, 'Ajedrez Inca', 'Ajedrez Inca de madera', 40, 'ajedrez-inca.jpg', 4, 'D'),
(24, 7, 'Apple iMac i5', 'Apple iMac i5 3ghz 8gb 1tb ', 1538, '1538-apple-imac-i5-3ghz-8gb-1tb-fusion-radeon-pro-570x-4gb-27-5k-retina-comprar.webp', 3, 'D'),
(25, 14, 'Acordeón', 'Como nuevo', 70, 'acordeon.png', 3, 'D'),
(26, 9, 'Auriculares Blue', 'Auriculares Blue inalambricos', 35.5, 'auriculares-blue.webp', 3, 'D'),
(27, 3, 'HTML, CSS y JavaScript', 'HTML, CSS y JavaScript edición 2021', 6, 'html_js_css.jpg', 4, 'D'),
(28, 7, 'Apple iMac i5', 'Apple iMac i5 3ghz', 1000, '1538-apple-imac-i5-3ghz-8gb-1tb-fusion-radeon-pro-570x-4gb-27-5k-retina-comprar.webp', 4, 'D'),
(29, 8, 'Niña a la orilla del mar', 'Reproducción del cuadro de Joaquín Sorolla', 300, 'joaquin-sorolla-nina-orilla-de-valencia.jpg', 4, 'D'),
(30, 4, 'Aspide Blue', 'Aspide Blue', 349.99, 'Aspide_Blue.jpg', 4, 'D'),
(31, 5, 'Cojín Software engineeer', 'Cojín de 60 x 60', 9.99, 'cojinGamer.jpg', 4, 'D'),
(32, 3, 'JavaScript from Frontend to Backend', 'JavaScript from Frontend to Backend', 50, 'js_front_end.jpg', 5, 'D'),
(33, 8, 'Arboleda de Chopos', 'Cuadro al oleo', 555, 'klimt-arboleda-de-chopos.jpg', 6, 'D'),
(34, 7, 'Hub USB 7 3n 1 de Andrea', 'HUB USB en buen estado', 33.88, 'HubUsb7en1.png', 6, 'V'),
(35, 10, 'Ajedrez', 'Ajedrez de madera', 78, 'ajedrez-madera.jpg', 4, 'D'),
(36, 9, 'Batería azul de Alberto', 'Bateria profesional de Alberto', 1000.5, 'bateria.png', 7, 'D'),
(38, 8, 'Niños en la playa', 'Cuadro al oleo', 400, 'chicos-en-la-playa.jpg', 2, 'V'),
(39, 7, 'Medion akoya', 'Medion akoya asvdas', 2000.99, '1762-medion-akoya-e23403-intel-core-i3-1005g1-8gb-256gb-ssd-238.webp', 4, 'D'),
(40, 3, 'El libro del Hacker', 'El libro del hacker', 33.33, 'libro_hacker.jpg', 3, 'D'),
(41, 1, 'Acordeón', 'acordeón rojo', 120.5, 'acordeon.png', 2, 'D'),
(42, 9, 'Batería', 'Bateria a buen precio', 30000, 'bateria.png', 2, 'D');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `imagen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id`, `nombre`, `imagen`) VALUES
(1, 'Cine, TV y Música', 'musica.png'),
(2, 'Coche y motos', 'coche.png'),
(3, 'Libros', 'libros.png'),
(4, 'Movilidad urbana', 'movilidad-urbana.png'),
(5, 'Hogar, Jardín y Bricolaje', 'bricolaje.png'),
(6, 'Mascotas', 'mascotas.png'),
(7, 'Informática', 'informatic.png'),
(8, 'Arte y Pintura', '1715795511_arte.png'),
(9, 'Electrónica', 'electronica.png'),
(10, 'Juegos de mesa', 'juegosmesa.png'),
(11, 'Juguetes y Bebé', 'juguetes.png'),
(12, 'Deportes y aire libre', 'deportes-airelibre.png'),
(13, 'Acampada y senderismo', 'acampada.png'),
(14, 'Ofertas y Chollos', 'zapatillas.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socios`
--

CREATE TABLE `socios` (
  `id` int(11) NOT NULL,
  `rol` char(1) NOT NULL DEFAULT 'U',
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `foto` varchar(255) NOT NULL DEFAULT 'user.png',
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `socios`
--

INSERT INTO `socios` (`id`, `rol`, `nombre`, `apellidos`, `email`, `foto`, `password`) VALUES
(1, 'A', 'Admin', 'Administrador', 'admin.admin@iescamp.es', 'user.png', 'admin1'),
(2, 'U', 'Ada ', 'Lovelace', 'ada.lovelace@gmail.com', 'user.png', 'ada111'),
(3, 'U', 'Steve', 'Jobs', 'steve.jobs@gmail.com', 'user.png', 'steve1'),
(4, 'U', 'Tim', 'Berners-Lee', 'tim.berners.lee@gmail.com', 'user.png', 'tim111'),
(5, 'U', 'Dennis', 'Ritchie', 'dennis.ritchie@gmail.com', 'user.png', 'dennis1'),
(6, 'U', 'Jeff', 'Bezos', 'jeff.bezos@gmail.com', 'tres.png', 'jeff11'),
(7, 'U', 'Mark', 'Zuckerberg', 'mark.zuckerberg@gmail.com', 'user.png', 'mark11'),
(8, 'U', 'Prueba', 'Pru Prueba', 'prueba.pru@iescamp.es', 'prueba.png', 'prueba1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idventa` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `socio` int(11) NOT NULL,
  `articulo` int(11) NOT NULL,
  `precio` float NOT NULL,
  `comprador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`idventa`, `fecha`, `socio`, `articulo`, `precio`, `comprador`) VALUES
(1, '2024-11-14', 6, 34, 33.88, 3),
(2, '2024-11-14', 2, 38, 400, 6);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulos`
--
ALTER TABLE `articulos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categoria` (`categoria`),
  ADD KEY `vendedor` (`vendedor`);

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `socios`
--
ALTER TABLE `socios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `EMAIL_UNIQUE` (`email`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idventa`),
  ADD KEY `ventasocio` (`socio`),
  ADD KEY `ventaarticulo` (`articulo`),
  ADD KEY `ventacomprador` (`comprador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulos`
--
ALTER TABLE `articulos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `socios`
--
ALTER TABLE `socios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idventa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `articulos`
--
ALTER TABLE `articulos`
  ADD CONSTRAINT `FK_CATEGORIA` FOREIGN KEY (`categoria`) REFERENCES `categorias` (`id`),
  ADD CONSTRAINT `FK_VENDEDOR` FOREIGN KEY (`vendedor`) REFERENCES `socios` (`id`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventaarticulo` FOREIGN KEY (`articulo`) REFERENCES `articulos` (`id`),
  ADD CONSTRAINT `ventacomprador` FOREIGN KEY (`comprador`) REFERENCES `socios` (`id`),
  ADD CONSTRAINT `ventasocio` FOREIGN KEY (`socio`) REFERENCES `socios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
