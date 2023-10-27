-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 27, 2023 at 01:15 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `viaje`
--

-- --------------------------------------------------------

--
-- Table structure for table `monopatin`
--

CREATE TABLE `monopatin` (
  `id_monopatin` int(11) NOT NULL,
  `tiempo_uso` time NOT NULL,
  `km_recorridos` int(11) NOT NULL,
  `monopatin_mantenimiento` tinyint(1) NOT NULL DEFAULT 0,
  `nro_parada` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `parada`
--

CREATE TABLE `parada` (
  `nro_parada` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `parada_permitida` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `viaje`
--

CREATE TABLE `viaje` (
  `nro_viaje` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `hora_inicio` time NOT NULL,
  `fecha_fin` date NOT NULL,
  `hora_fin` time NOT NULL,
  `km_recorridos` int(11) NOT NULL,
  `pausa` time NOT NULL,
  `precio` int(11) NOT NULL,
  `id_monopatin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `monopatin`
--
ALTER TABLE `monopatin`
  ADD PRIMARY KEY (`id_monopatin`),
  ADD KEY `nro_parada` (`nro_parada`);

--
-- Indexes for table `parada`
--
ALTER TABLE `parada`
  ADD PRIMARY KEY (`nro_parada`);

--
-- Indexes for table `viaje`
--
ALTER TABLE `viaje`
  ADD PRIMARY KEY (`nro_viaje`),
  ADD KEY `id_monopatin` (`id_monopatin`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `monopatin`
--
ALTER TABLE `monopatin`
  ADD CONSTRAINT `monopatin_ibfk_1` FOREIGN KEY (`nro_parada`) REFERENCES `parada` (`nro_parada`);

--
-- Constraints for table `viaje`
--
ALTER TABLE `viaje`
  ADD CONSTRAINT `viaje_ibfk_1` FOREIGN KEY (`id_monopatin`) REFERENCES `monopatin` (`id_monopatin`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
