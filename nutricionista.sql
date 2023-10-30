-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-10-2023 a las 19:30:33
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nutricionista`
--
CREATE DATABASE IF NOT EXISTS `nutricionista` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `nutricionista`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comida`
--

CREATE TABLE `comida` (
  `idComida` int(11) NOT NULL,
  `nombreComida` varchar(50) NOT NULL,
  `detalle` varchar(100) NOT NULL,
  `cantCalorias` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `comida`
--

INSERT INTO `comida` (`idComida`, `nombreComida`, `detalle`, `cantCalorias`) VALUES
(20, 'Guiso Arroz', 'Es un plato unico que se sirve para la cena', 200),
(21, 'Licuado de frutas', 'Es un licuado super saludable y super\nrecomendado para el desayuno', 150),
(22, 'lomito', 'tiene bife y verduras como lechuga, tomate, tambien tiene saborizantes etc.', 2000),
(23, 'Guiso con arroz', 'Guiso de albañil, damian no se calla', 2000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `idDieta` int(11) NOT NULL,
  `nombreDieta` varchar(50) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `fechaInicial` date NOT NULL,
  `fechaFinal` date NOT NULL,
  `pesoInicial` double NOT NULL,
  `pesoFinal` double NOT NULL,
  `dietaTerminada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `dieta`
--

INSERT INTO `dieta` (`idDieta`, `nombreDieta`, `idPaciente`, `fechaInicial`, `fechaFinal`, `pesoInicial`, `pesoFinal`, `dietaTerminada`) VALUES
(18, 'p1', 49, '2023-10-01', '2023-10-31', 12, 0, 0),
(19, 'nombredieta', 49, '2023-10-01', '2023-10-31', 12, 0, 0),
(20, 'dawd', 49, '2023-10-01', '2023-10-31', 12, 0, 0),
(21, 'dawd', 49, '2023-10-08', '2023-10-31', 12, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dietacomida`
--

CREATE TABLE `dietacomida` (
  `idDietaComida` int(11) NOT NULL,
  `idComida` int(11) NOT NULL,
  `idDieta` int(11) NOT NULL,
  `horario` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `dietacomida`
--

INSERT INTO `dietacomida` (`idDietaComida`, `idComida`, `idDieta`, `horario`) VALUES
(16, 20, 18, 'DESAYUNO'),
(17, 21, 18, 'ALMUERZO'),
(18, 22, 18, 'MERIENDA'),
(19, 23, 18, 'CENA'),
(20, 20, 18, 'SNACK'),
(21, 21, 19, 'DESAYUNO'),
(22, 21, 19, 'ALMUERZO'),
(23, 21, 19, 'MERIENDA'),
(24, 21, 19, 'CENA'),
(25, 20, 19, 'SNACK'),
(26, 20, 20, 'DESAYUNO'),
(27, 22, 20, 'ALMUERZO'),
(28, 22, 20, 'MERIENDA'),
(29, 21, 20, 'CENA'),
(30, 21, 20, 'SNACK'),
(31, 21, 21, 'DESAYUNO'),
(32, 21, 21, 'ALMUERZO'),
(33, 22, 21, 'MERIENDA'),
(34, 21, 21, 'CENA'),
(35, 21, 21, 'SNACK');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL,
  `nombrePaciente` varchar(50) NOT NULL,
  `dni` int(10) NOT NULL,
  `domicilio` varchar(15) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `pesoActual` double NOT NULL,
  `pesoDeseado` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `nombrePaciente`, `dni`, `domicilio`, `telefono`, `pesoActual`, `pesoDeseado`) VALUES
(49, 'Nico Ruiz', 32321, 'Ddwd', '323212', 12, 23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_peso`
--

CREATE TABLE `registro_peso` (
  `idRegistro_peso` int(11) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `pesoA` double NOT NULL,
  `pesoD` double NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comida`
--
ALTER TABLE `comida`
  ADD PRIMARY KEY (`idComida`);

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`idDieta`),
  ADD KEY `idPaciente` (`idPaciente`);

--
-- Indices de la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  ADD PRIMARY KEY (`idDietaComida`),
  ADD KEY `idComida` (`idComida`),
  ADD KEY `idDieta` (`idDieta`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idPaciente`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `registro_peso`
--
ALTER TABLE `registro_peso`
  ADD PRIMARY KEY (`idRegistro_peso`),
  ADD KEY `idPaciente` (`idPaciente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comida`
--
ALTER TABLE `comida`
  MODIFY `idComida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `idDieta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  MODIFY `idDietaComida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT de la tabla `registro_peso`
--
ALTER TABLE `registro_peso`
  MODIFY `idRegistro_peso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`);

--
-- Filtros para la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  ADD CONSTRAINT `dietacomida_ibfk_1` FOREIGN KEY (`idComida`) REFERENCES `comida` (`idComida`),
  ADD CONSTRAINT `dietacomida_ibfk_2` FOREIGN KEY (`idDieta`) REFERENCES `dieta` (`idDieta`);

--
-- Filtros para la tabla `registro_peso`
--
ALTER TABLE `registro_peso`
  ADD CONSTRAINT `registro_peso_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
