-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 29, 2024 at 12:48 PM
-- Server version: 8.0.30
-- PHP Version: 8.2.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_healink`
--

-- --------------------------------------------------------

--
-- Table structure for table `t_dokter`
--

CREATE TABLE `t_dokter` (
  `idDokter` int NOT NULL,
  `namaDokter` varchar(100) NOT NULL,
  `spesialis` varchar(30) NOT NULL,
  `jenisKelamin` enum('Laki-laki','Perempuan') NOT NULL,
  `ruangan` varchar(30) NOT NULL,
  `username` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `t_dokter`
--

INSERT INTO `t_dokter` (`idDokter`, `namaDokter`, `spesialis`, `jenisKelamin`, `ruangan`, `username`) VALUES
(12, 'Blast', 'Ruang dan waktu', 'Laki-laki', 'Mad Universe', 'Number One Hero'),
(13, 'Raiden Bosenmori Mei', 'Kekosongan', 'Perempuan', 'Kehampaan', 'Acheron');

-- --------------------------------------------------------

--
-- Table structure for table `t_konsultasi`
--

CREATE TABLE `t_konsultasi` (
  `idKonsultasi` int NOT NULL,
  `idPasien` int NOT NULL,
  `idDokter` int NOT NULL,
  `waktuKonsultasi` varchar(100) DEFAULT NULL,
  `catatan` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `keperluanPasien` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `t_konsultasi`
--

INSERT INTO `t_konsultasi` (`idKonsultasi`, `idPasien`, `idDokter`, `waktuKonsultasi`, `catatan`, `keperluanPasien`) VALUES
(23, 13, 12, '29:00', 'Mamah Aku Takut', 'Anomali Telah Datang'),
(24, 14, 12, '20:00', 'Ayo Gas', 'Infokan Rematch'),
(25, 14, 13, '20:00', 'Perbanyak istirahat,dan jangan terlalu sering main hp', 'Panas');

-- --------------------------------------------------------

--
-- Table structure for table `t_pasien`
--

CREATE TABLE `t_pasien` (
  `idPasien` int NOT NULL,
  `namaPasien` varchar(100) NOT NULL,
  `jenisKelamin` enum('Laki-laki','Perempuan') NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `username` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `t_pasien`
--

INSERT INTO `t_pasien` (`idPasien`, `namaPasien`, `jenisKelamin`, `alamat`, `username`) VALUES
(13, 'Saitama', 'Laki-laki', 'BLOK A', 'onepunchman'),
(14, 'empty void', 'Laki-laki', 'Ninja Penjelajah Universe', 'EV');

-- --------------------------------------------------------

--
-- Table structure for table `t_user`
--

CREATE TABLE `t_user` (
  `username` varchar(40) NOT NULL,
  `password` varchar(100) NOT NULL,
  `level` int NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `t_user`
--

INSERT INTO `t_user` (`username`, `password`, `level`) VALUES
('Acheron', '123', 2),
('admin', '123', 3),
('EV', '123', 1),
('Number One Hero', '123', 2),
('onepunchman', '123', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_dokter`
--
ALTER TABLE `t_dokter`
  ADD PRIMARY KEY (`idDokter`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `t_konsultasi`
--
ALTER TABLE `t_konsultasi`
  ADD PRIMARY KEY (`idKonsultasi`),
  ADD KEY `idPasien` (`idPasien`),
  ADD KEY `idDokter` (`idDokter`);

--
-- Indexes for table `t_pasien`
--
ALTER TABLE `t_pasien`
  ADD PRIMARY KEY (`idPasien`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `t_user`
--
ALTER TABLE `t_user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `t_dokter`
--
ALTER TABLE `t_dokter`
  MODIFY `idDokter` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `t_konsultasi`
--
ALTER TABLE `t_konsultasi`
  MODIFY `idKonsultasi` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `t_pasien`
--
ALTER TABLE `t_pasien`
  MODIFY `idPasien` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `t_dokter`
--
ALTER TABLE `t_dokter`
  ADD CONSTRAINT `fk_username_dokter` FOREIGN KEY (`username`) REFERENCES `t_user` (`username`) ON DELETE CASCADE;

--
-- Constraints for table `t_konsultasi`
--
ALTER TABLE `t_konsultasi`
  ADD CONSTRAINT `t_konsultasi_ibfk_1` FOREIGN KEY (`idPasien`) REFERENCES `t_pasien` (`idPasien`) ON DELETE CASCADE,
  ADD CONSTRAINT `t_konsultasi_ibfk_2` FOREIGN KEY (`idDokter`) REFERENCES `t_dokter` (`idDokter`) ON DELETE CASCADE;

--
-- Constraints for table `t_pasien`
--
ALTER TABLE `t_pasien`
  ADD CONSTRAINT `fk_username_pasien` FOREIGN KEY (`username`) REFERENCES `t_user` (`username`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
