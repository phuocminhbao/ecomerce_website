-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 28, 2021 at 06:27 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecomercewebsite`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`, `description`) VALUES
(1, 'smartphone', 'iPhone, Vivo, Oppo...'),
(2, 'laptop', 'ASUS, MSI, HP...'),
(3, 'ipad', 'ipad pro, ipad mini...');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `id_category` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `title` varchar(255) NOT NULL,
  `highlight` tinyint(1) NOT NULL,
  `new_product` tinyint(1) NOT NULL,
  `details` longtext NOT NULL,
  `create_at` date NOT NULL,
  `update_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `id_category`, `name`, `price`, `title`, `highlight`, `new_product`, `details`, `create_at`, `update_at`) VALUES
(1001, 1, 'iPhone X', 299, 'iPhone X - 64 GB', 0, 0, 'iPhone X is designed with the following features to reduce environmental impact: Arsenic-free display glass. Mercury-free LED-backlit display.', '2021-07-28', '2021-07-28'),
(1002, 1, 'iPhone 11', 399, 'iPhone 11 64GB', 1, 1, '1080p HD video recording at 25 fps, 30 fps, or 60 fps\r\nSlo‑mo video support for 1080p at 120 fps\r\nNext‑generation Smart HDR for photos\r\nExtended dynamic range for video at 30 fps\r\nCinematic video stabilization (4K, 1080p, and 720p)', '2021-07-28', '2021-07-28'),
(1003, 1, 'iPhone 12', 499, 'iPhone 12 128GB', 1, 1, '5G speed. A14 Bionic, the fastest chip in a smartphone.\r\nAn edge-to-edge OLED display. Ceramic Shield with four times better drop performance. And Night mode on every camera. iPhone 12 has it all — in two perfect sizes.', '2021-07-28', '2021-07-28'),
(10001, 2, 'Asus vivobook a512 i7', 999, 'ASUS recommends Windows 10 Pro for business. The world’s smallest colorful 15” Ultrabook1', 1, 1, 'Whether at work or play, ASUS VivoBook 15 is the compact laptop that immerses you in whatever you set out to do. Its new frameless four-sided NanoEdge display boasts an ultraslim 5.7mm bezel, giving an amazing 88% screen-to-body ratio for supremely immersive visuals. The new ErgoLift hinge design also tilts the keyboard up for more comfortable typing. VivoBook 15 is powered by up to the latest AMD Ryzen™ 7 processor and dual storage drives to help you get things done with the least amount of fuss. What’s more, it’s available in four unique finishes to suit your style.', '2021-07-28', '2021-07-28'),
(10002, 2, 'MSI Modern 14 - B11S', 999, 'Modern 14 - B11S11th Gen Intel® Core™ processor', 1, 1, 'Let your passion keep up with your dynamic lifestyle. Whether you are exploring new chapter in life or pursuing your career, with the latest 11th Gen. Intel® Core™ i7 processors and up to NVIDIA® discrete graphics, you will breathtaking new wonders through the Modern series.', '2021-07-28', '2021-07-28'),
(10003, 2, 'HP ProBook 450 G7 Laptop', 599, 'HP ProBook 450 G7 Laptop – Core i5 1.6GHz 4GB 500GB Shared Win10 15.6inch HD Silver English Keyboard', 1, 1, 'Laptop Type: NotebookStandard design laptopScreen Size: 15.6 InchesProcessor: Intel Core i5RAM: 4 GBStorage Size: 500 GBStorage Type: HDDSpeed: 1.6 GHzColor: Silver Model: 9ZE38UT', '2021-07-28', '2021-07-28');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_category` (`id_category`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10004;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;