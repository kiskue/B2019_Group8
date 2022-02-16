-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 16, 2022 at 11:23 PM
-- Server version: 10.5.12-MariaDB
-- PHP Version: 7.3.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id18112890_registerdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Emergency`
--

CREATE TABLE `Emergency` (
  `id` int(11) NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `fire` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `floods` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `robbery` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `earthquake` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `bomb_threat` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `need_ambulance` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `lost_family` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `personal_threat` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `confirm_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `NotEmergency`
--

CREATE TABLE `NotEmergency` (
  `num_of_notemergency` int(11) NOT NULL,
  `name` varchar(225) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(225) COLLATE utf8_unicode_ci NOT NULL,
  `Concern` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `Needforconcern` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `confirm_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `NotEmergency`
--

INSERT INTO `NotEmergency` (`num_of_notemergency`, `name`, `address`, `Concern`, `Needforconcern`, `confirm_at`) VALUES
(4, 'maria rezeil baldivicio', 'chico ext.north signal, taguig city', 'paano po ung basura sa likod ng tubig', 'garbage bag', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(225) COLLATE utf8_unicode_ci NOT NULL,
  `fullname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `age` int(11) NOT NULL,
  `address` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `fullname`, `age`, `address`, `phone`, `created_at`, `updated_at`) VALUES
(29, 'aljanecompuesto@gmail.com', 'c50102d11534de12f5406650b08dc0f7', 'aljane', 25, 'Taguig', 9612916155, '2022-02-08 08:27:04', '2022-02-08 08:27:04'),
(30, 'mariarezeilb@gmail.com', 'e11a2d33e0921ad13be8ab49c73b9fca', 'Maria Rezeil Baldivicio', 10, '69 Chico St. Ext. Brgy. North Signal, Taguig City', 9393195952, '2022-02-08 11:04:45', '2022-02-08 11:04:45'),
(31, 'jerson060401@gmail.com', '7cf63b317a1be4658ece90b242f2c759', 'Jerson B. Cargo', 20, 'blk 12 lot 6 dreamland taguig', 9615794622, '2022-02-08 11:32:51', '2022-02-08 11:32:51'),
(37, 'gerricmeasco360@gmail.com', '418f020ce8009a31e8794dd780d2c14c', 'Measco, Gerric T.', 20, 'Taguig City ', 9253421547, '2022-02-16 16:16:55', '2022-02-16 16:16:55');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Emergency`
--
ALTER TABLE `Emergency`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `NotEmergency`
--
ALTER TABLE `NotEmergency`
  ADD PRIMARY KEY (`num_of_notemergency`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Emergency`
--
ALTER TABLE `Emergency`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `NotEmergency`
--
ALTER TABLE `NotEmergency`
  MODIFY `num_of_notemergency` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
