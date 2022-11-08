-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Gegenereerd op: 08 nov 2022 om 12:48
-- Serverversie: 10.4.25-MariaDB
-- PHP-versie: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mi6`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `userNumber` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
  `time` datetime NOT NULL DEFAULT current_timestamp(),
  `success` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Gegevens worden geëxporteerd voor tabel `login`
--

INSERT INTO `login` (`id`, `userNumber`, `time`, `success`) VALUES
(1, '007', '2022-11-08 00:00:00', 1),
(2, '007', '2022-11-08 00:00:00', 0),
(3, '007', '2022-11-08 09:17:55', 0),
(4, '007', '2022-11-08 10:33:33', 1),
(5, '007', '2022-11-08 10:34:52', 1),
(6, '007', '2022-11-08 10:37:40', 1),
(7, '007', '2022-11-08 10:45:47', 1),
(8, '007', '2022-11-08 10:46:14', 1),
(9, '007', '2022-11-08 10:47:08', 1),
(10, '007', '2022-11-08 10:48:03', 1),
(11, '007', '2022-11-08 11:31:10', 1),
(12, '007', '2022-11-08 11:31:16', 0),
(13, '007', '2022-11-08 11:32:33', 0),
(14, '007', '2022-11-08 11:52:28', 0),
(15, '777', '2022-11-08 12:37:06', 0),
(16, '005', '2022-11-08 12:38:02', 1),
(17, '007', '2022-11-08 12:40:52', 1),
(18, '007', '2022-11-08 12:40:58', 0),
(19, '007', '2022-11-08 12:41:24', 1),
(20, '007', '2022-11-08 12:41:33', 0),
(21, '005', '2022-11-08 13:43:05', 1),
(22, '007', '2022-11-08 13:44:09', 1);

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
