-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 01, 2023 at 09:00 PM
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
-- Database: `seguimiento`
--

-- --------------------------------------------------------

--
-- Table structure for table `monopatin`
--

CREATE TABLE `monopatin` (
  `id_monopatin` int(11) NOT NULL,
  `tiempo_uso` time NOT NULL,
  `km_recorridos` double NOT NULL,
  `monopatin_mantenimiento` tinyint(1) NOT NULL DEFAULT 0,
  `nro_parada` int(11) NOT NULL,
  `x` int(11) NOT NULL,
  `y` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `monopatin`
--

INSERT INTO `monopatin` (`id_monopatin`, `tiempo_uso`, `km_recorridos`, `monopatin_mantenimiento`, `nro_parada`, `x`, `y`) VALUES
(1, '12:55:00', 33, 1, 1, 50, 20),
(2, '02:46:00', 42, 0, 2, 50, 0),
(3, '08:26:00', 7, 1, 3, 100, 50),
(4, '03:47:00', 59, 0, 4, 0, 0),
(5, '11:51:00', 3, 1, 5, 0, 0),
(6, '10:45:00', 5, 0, 6, 0, 0),
(7, '09:26:00', 33, 1, 7, 0, 0),
(8, '11:39:00', 66, 0, 8, 0, 0),
(9, '11:33:00', 45, 1, 9, 0, 0),
(10, '04:48:00', 46, 1, 10, 0, 0),
(11, '01:10:00', 82, 1, 11, 0, 0),
(12, '06:06:00', 18, 1, 12, 0, 0),
(13, '01:21:00', 21, 1, 13, 70, 20),
(14, '01:46:00', 28, 1, 14, 0, 0),
(15, '01:22:00', 50, 1, 15, 0, 0),
(16, '02:44:00', 10, 0, 16, 0, 0),
(17, '05:31:00', 89, 0, 17, 0, 0),
(18, '08:42:00', 47, 0, 18, 0, 0),
(19, '06:43:00', 69, 0, 19, 0, 0),
(20, '11:38:00', 50, 0, 20, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `parada`
--

CREATE TABLE `parada` (
  `nro_parada` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `parada_permitida` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `parada`
--

INSERT INTO `parada` (`nro_parada`, `nombre`, `parada_permitida`) VALUES
(1, 'Fort Pierce', 0),
(2, 'Shlissel’burg', 1),
(3, 'Ouégoa', 0),
(4, 'Jeruk', 0),
(5, 'Trelleborg', 0),
(6, 'Kameyama', 1),
(7, 'Wuxi', 0),
(8, 'Wulan Haye', 0),
(9, 'Wenfang', 0),
(10, 'Calaba', 1),
(11, 'Żernica', 1),
(12, 'Lugovskoy', 0),
(13, 'Hermanus', 0),
(14, 'Shypyntsi', 0),
(15, 'Tanamiting', 1),
(16, 'Buea', 1),
(17, 'Geji', 0),
(18, 'Bol’shaya Setun’', 0),
(19, 'Nyrkiv', 0),
(20, 'Torbeyevo', 1);

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
  `km_recorridos` double NOT NULL,
  `pausa` time NOT NULL,
  `precio` int(11) NOT NULL,
  `id_monopatin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `viaje`
--

INSERT INTO `viaje` (`nro_viaje`, `fecha_inicio`, `hora_inicio`, `fecha_fin`, `hora_fin`, `km_recorridos`, `pausa`, `precio`, `id_monopatin`) VALUES
(1, '2023-02-21', '05:06:00', '2023-04-20', '05:11:00', 74, '00:00:12', 1, 1),
(2, '2023-02-24', '03:52:00', '2023-04-29', '01:00:00', 72, '00:00:01', 2, 2),
(3, '2023-10-06', '08:19:00', '2022-11-19', '06:59:00', 95, '00:00:05', 3, 3),
(4, '2023-02-04', '02:31:00', '2023-04-23', '08:23:00', 21, '00:00:08', 4, 4),
(5, '2023-08-21', '09:36:00', '2023-08-01', '03:24:00', 38, '00:00:11', 5, 5),
(6, '2023-03-21', '11:21:00', '2023-08-07', '01:11:00', 93, '00:00:10', 6, 6),
(7, '2022-12-20', '08:56:00', '2023-07-20', '10:05:00', 73, '00:00:12', 7, 7),
(8, '2023-10-10', '10:29:00', '2023-08-10', '01:08:00', 38, '00:00:08', 8, 8),
(9, '2022-12-01', '11:23:00', '2023-08-18', '12:58:00', 58, '00:00:12', 9, 9),
(10, '2023-01-02', '07:13:00', '2023-08-03', '09:19:00', 85, '00:00:05', 10, 10),
(11, '2022-12-03', '04:59:00', '2023-01-31', '07:43:00', 27, '00:00:02', 11, 11),
(12, '2023-06-20', '07:02:00', '2022-12-21', '08:44:00', 96, '00:00:01', 12, 12),
(13, '2023-10-02', '03:39:00', '2023-03-26', '05:39:00', 75, '00:00:03', 13, 13),
(14, '2023-07-10', '10:50:00', '2023-09-19', '03:31:00', 41, '00:00:06', 14, 14),
(15, '2023-01-01', '05:11:00', '2023-05-27', '07:46:00', 62, '00:00:12', 15, 15),
(16, '2023-08-06', '06:14:00', '2022-11-06', '08:32:00', 22, '00:00:09', 16, 16),
(17, '2023-02-04', '10:33:00', '2023-09-08', '09:17:00', 27, '00:00:03', 17, 17),
(18, '2023-03-04', '07:36:00', '2023-08-20', '08:10:00', 52, '00:00:05', 18, 18),
(19, '2022-10-27', '08:09:00', '2022-12-26', '03:18:00', 5, '00:00:11', 19, 19),
(20, '2023-05-30', '02:58:00', '2023-01-25', '03:17:00', 31, '00:00:11', 20, 20),
(21, '2023-10-05', '18:34:27', '2023-10-10', '18:34:27', 12, '00:00:05', 22, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `monopatin`
--
ALTER TABLE `monopatin`
  ADD PRIMARY KEY (`id_monopatin`),
  ADD KEY `monopatin_ibfk_1` (`nro_parada`);

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
  ADD KEY `viaje_ibfk_1` (`id_monopatin`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `monopatin`
--
ALTER TABLE `monopatin`
  MODIFY `id_monopatin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `parada`
--
ALTER TABLE `parada`
  MODIFY `nro_parada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `viaje`
--
ALTER TABLE `viaje`
  MODIFY `nro_viaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

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
