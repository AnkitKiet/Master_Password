-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2017 at 06:18 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `masterpassword`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`) VALUES
(10, 'ankit', 'ankit@gmail.com', '37+ou6UTtqf432QO6nTkRw=='),
(8, 'pr', 'pg@gmail.com', 'UlQiIs/K0EwcSKbWMjcT1g=='),
(11, 'svs', 'ankit@gmail.com', '/oZgOqI1XnGlSLG9eX+xoQ=='),
(12, 'dqd', 'a@gmail.com', 'KMC1YVRP7KlCW2JnWQrVNw=='),
(13, 'cdc', 'p@gmail.com', 'KMC1YVRP7KlCW2JnWQrVNw=='),
(14, 'a', 'a@a.com', 'rt9cp/YULRZZVRv0zi/SFQ==');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
