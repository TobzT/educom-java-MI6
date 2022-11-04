-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Gegenereerd op: 04 nov 2022 om 11:14
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
-- Tabelstructuur voor tabel `agents`
--

CREATE TABLE `agents` (
  `id` int(8) NOT NULL,
  `userNumber` varchar(8) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pw` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `active` tinyint(1) NOT NULL,
  `license_to_kill` tinyint(1) NOT NULL,
  `license_to_kill_expire` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Gegevens worden geëxporteerd voor tabel `agents`
--

INSERT INTO `agents` (`id`, `userNumber`, `pw`, `active`, `license_to_kill`, `license_to_kill_expire`) VALUES
(1, '002', 'whatever', 1, 1, '2025-01-01'),
(2, '005', 'adminadmin', 1, 1, '2022-08-27'),
(3, '007', 'adminadmin', 1, 1, '2026-04-13'),
(4, '777', 'adminadmin', 0, 1, '2023-01-11'),
(5, '030', 'adminadmin', 1, 0, NULL),
(6, '102', 'adminadmin', 1, 0, NULL);

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `agents`
--
ALTER TABLE `agents`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `agents`
--
ALTER TABLE `agents`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
