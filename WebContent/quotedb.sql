-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Dec 15, 2018 at 03:25 PM
-- Server version: 5.7.23-0ubuntu0.16.04.1
-- PHP Version: 7.0.32-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cs3220stu79`
--

-- --------------------------------------------------------

--
-- Table structure for table `quotedb`
--

CREATE TABLE `quotedb` (
  `id` int(11) NOT NULL,
  `quote` varchar(8000) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quotedb`
--

INSERT INTO `quotedb` (`id`, `quote`, `author`) VALUES
(3, 'Optimism is the faith that leads to achievement. Nothing can be done without hope and confidence.', 'Helen Keller'),
(4, 'The past cannot be changed. The future is yet in power.', 'Unknown'),
(5, 'We should not giup up and we should not allow the problem to defeat us.', 'A.P.J. Abdul Kalam'),
(6, 'If you fell down yesterday, stand up today.', 'H.G. Wells'),
(7, 'Quality is not an act, it is a habit.', 'Aristotle'),
(8, 'Don\'t watch the clock; do what it does, keep going.', 'Sam Levenson'),
(9, 'There is beauty in simplicity.', 'Unknown'),
(10, 'Begin now to be what you will be hereafter.', 'Saint Jerome'),
(11, 'We have to do the best we are capable of. This is our sacred human responsibility.', 'Albert Einstein'),
(12, 'The brain is wider than the sky.', 'Emily Dickinson'),
(13, 'Great things never came from comfort zones.', 'Neil Strauss'),
(14, 'There is no great genius without a mixture of madness.', 'Aristotle'),
(15, 'Petit a petit, lâ??oiseau fait son nid.', 'French Proverb');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `quotedb`
--
ALTER TABLE `quotedb`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `quotedb`
--
ALTER TABLE `quotedb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
