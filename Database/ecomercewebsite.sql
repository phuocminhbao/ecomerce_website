-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 22, 2021 at 08:19 AM
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
-- Table structure for table `colors`
--

CREATE TABLE `colors` (
  `id` int(11) NOT NULL,
  `id_product` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `colors`
--

INSERT INTO `colors` (`id`, `id_product`, `name`, `code`, `img`) VALUES
(1, 1001, 'White', 'ipxwhite', 'ipx.jpg'),
(2, 1002, 'Red', 'ip11red', 'ip11.jpg'),
(3, 1003, 'Black', 'ip12black', 'ip12.jpg'),
(4, 1004, 'Red', 'ip11red', 'ip11.jpg'),
(5, 1005, 'Red', 'ip11red', 'ip11.jpg'),
(6, 1006, 'Red', 'ip11red', 'ip11.jpg'),
(7, 1007, 'Red', 'ip11red', 'ip11.jpg'),
(8, 1008, 'Red', 'ip11red', 'ip11.jpg'),
(9, 1009, 'Red', 'ip11red', 'ip11.jpg'),
(10, 1010, 'Red', 'ip11red', 'ip11.jpg'),
(11, 1011, 'Red', 'asusa512', 'asusa512.jpg'),
(12, 1012, 'Black', 'msimordern14', 'msimordern14.jpg'),
(13, 1013, 'Black', 'hpg7', 'hpg7.jpg'),
(14, 1014, 'Red', 'asusa512', 'asusa512.jpg'),
(15, 1015, 'Black', 'msimordern14', 'msimordern14.jpg'),
(16, 1016, 'Black', 'hpg7', 'hpg7.jpg'),
(17, 1017, 'Red', 'asusa512', 'asusa512.jpg'),
(18, 1018, 'Black', 'msimordern14', 'msimordern14.jpg'),
(19, 1019, 'Black', 'hpg7', 'hpg7.jpg'),
(20, 1020, 'Red', 'asusa512', 'asusa512.jpg'),
(21, 1021, 'Black', 'msimordern14', 'msimordern14.jpg'),
(22, 1022, 'Black', 'hpg7', 'hpg7.jpg'),
(23, 1023, 'Black', 'Ipad 8', 'ipad8.jpg'),
(24, 1024, 'Black', 'Ipad Air 4', 'ipadair4.jpg'),
(25, 1025, 'Black', 'Ipad M1', 'ipadm1.jpg'),
(26, 1026, 'Black', 'Ipad 8', 'ipad8.jpg'),
(27, 1027, 'Black', 'Ipad Air 4', 'ipadair4.jpg'),
(28, 1028, 'Black', 'Ipad M1', 'ipadm1.jpg'),
(29, 1029, 'Black', 'Ipad 8', 'ipad8.jpg'),
(30, 1030, 'Black', 'Ipad Air 4', 'ipadair4.jpg'),
(31, 1031, 'Black', 'Ipad M1', 'ipadm1.jpg'),
(32, 1032, 'Black', 'Ipad 8', 'ipad8.jpg'),
(33, 1033, 'Black', 'Ipad Air 4', 'ipadair4.jpg'),
(34, 1034, 'Black', 'Ipad M1', 'ipadm1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `menus`
--

CREATE TABLE `menus` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menus`
--

INSERT INTO `menus` (`id`, `name`, `url`) VALUES
(1, 'home', ''),
(2, 'product', ''),
(3, 'cart', '');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `id_category` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `title` varchar(255) NOT NULL,
  `highlight` tinyint(1) NOT NULL,
  `new_product` tinyint(1) NOT NULL,
  `details` longtext NOT NULL,
  `created_at` date NOT NULL,
  `updated_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `id_category`, `name`, `price`, `title`, `highlight`, `new_product`, `details`, `created_at`, `updated_at`) VALUES
(1001, 1, 'iPhone X', 299, 'iPhone X - 64 GB', 0, 0, 'iPhone X is designed with the following features to reduce environmental impact: Arsenic-free display glass. Mercury-free LED-backlit display.', '2021-07-28', '2021-07-28'),
(1002, 1, 'iPhone 11', 399, 'iPhone 11 64GB', 1, 1, '1080p HD video recording at 25 fps, 30 fps, or 60 fps\r\nSlo‑mo video support for 1080p at 120 fps\r\nNext‑generation Smart HDR for photos\r\nExtended dynamic range for video at 30 fps\r\nCinematic video stabilization (4K, 1080p, and 720p)', '2021-07-28', '2021-07-28'),
(1003, 1, 'iPhone 12', 499, 'iPhone 12 128GB', 1, 1, '5G speed. A14 Bionic, the fastest chip in a smartphone.\r\nAn edge-to-edge OLED display. Ceramic Shield with four times better drop performance. And Night mode on every camera. iPhone 12 has it all — in two perfect sizes.', '2021-07-28', '2021-07-28'),
(1004, 1, 'iPhone 12 - test1', 499, 'iPhone 12 128GB', 1, 1, '5G speed. A14 Bionic, the fastest chip in a smartphone.\r\nAn edge-to-edge OLED display. Ceramic Shield with four times better drop performance. And Night mode on every camera. iPhone 12 has it all — in two perfect sizes.', '2021-07-28', '2021-07-28'),
(1005, 1, 'iPhone 12 - test2', 499, 'iPhone 12 128GB', 1, 1, '5G speed. A14 Bionic, the fastest chip in a smartphone.\r\nAn edge-to-edge OLED display. Ceramic Shield with four times better drop performance. And Night mode on every camera. iPhone 12 has it all — in two perfect sizes.', '2021-07-28', '2021-07-28'),
(1006, 1, 'iPhone 12 - test3', 499, 'iPhone 12 128GB', 1, 1, '5G speed. A14 Bionic, the fastest chip in a smartphone.\r\nAn edge-to-edge OLED display. Ceramic Shield with four times better drop performance. And Night mode on every camera. iPhone 12 has it all — in two perfect sizes.', '2021-07-28', '2021-07-28'),
(1007, 1, 'iPhone 12 - test4', 499, 'iPhone 12 128GB', 1, 1, '5G speed. A14 Bionic, the fastest chip in a smartphone.\r\nAn edge-to-edge OLED display. Ceramic Shield with four times better drop performance. And Night mode on every camera. iPhone 12 has it all — in two perfect sizes.', '2021-07-28', '2021-07-28'),
(1008, 1, 'iPhone 12 - test5', 499, 'iPhone 12 128GB', 1, 1, '5G speed. A14 Bionic, the fastest chip in a smartphone.\r\nAn edge-to-edge OLED display. Ceramic Shield with four times better drop performance. And Night mode on every camera. iPhone 12 has it all — in two perfect sizes.', '2021-07-28', '2021-07-28'),
(1009, 1, 'iPhone 12 - test6', 499, 'iPhone 12 128GB', 1, 1, '5G speed. A14 Bionic, the fastest chip in a smartphone.\r\nAn edge-to-edge OLED display. Ceramic Shield with four times better drop performance. And Night mode on every camera. iPhone 12 has it all — in two perfect sizes.', '2021-07-28', '2021-07-28'),
(1010, 1, 'iPhone 12 - test7', 499, 'iPhone 12 128GB', 1, 1, '5G speed. A14 Bionic, the fastest chip in a smartphone.\r\nAn edge-to-edge OLED display. Ceramic Shield with four times better drop performance. And Night mode on every camera. iPhone 12 has it all — in two perfect sizes.', '2021-07-28', '2021-07-28'),
(1011, 2, 'Asus vivobook a512 i7', 999, 'ASUS recommends Windows 10 Pro for business. The world’s smallest colorful 15” Ultrabook1', 1, 1, 'Whether at work or play, ASUS VivoBook 15 is the compact laptop that immerses you in whatever you set out to do. Its new frameless four-sided NanoEdge display boasts an ultraslim 5.7mm bezel, giving an amazing 88% screen-to-body ratio for supremely immersive visuals. The new ErgoLift hinge design also tilts the keyboard up for more comfortable typing. VivoBook 15 is powered by up to the latest AMD Ryzen™ 7 processor and dual storage drives to help you get things done with the least amount of fuss. What’s more, it’s available in four unique finishes to suit your style.', '2021-07-28', '2021-07-28'),
(1012, 2, 'MSI Modern 14 - B11S', 999, 'Modern 14 - B11S11th Gen Intel® Core™ processor', 1, 1, 'Let your passion keep up with your dynamic lifestyle. Whether you are exploring new chapter in life or pursuing your career, with the latest 11th Gen. Intel® Core™ i7 processors and up to NVIDIA® discrete graphics, you will breathtaking new wonders through the Modern series.', '2021-07-28', '2021-07-28'),
(1013, 2, 'HP ProBook 450 G7 Laptop', 599, 'HP ProBook 450 G7 Laptop – Core i5 1.6GHz 4GB 500GB Shared Win10 15.6inch HD Silver English Keyboard', 1, 1, 'Laptop Type: NotebookStandard design laptopScreen Size: 15.6 InchesProcessor: Intel Core i5RAM: 4 GBStorage Size: 500 GBStorage Type: HDDSpeed: 1.6 GHzColor: Silver Model: 9ZE38UT', '2021-07-28', '2021-07-28'),
(1014, 2, 'Asus vivobook a512 i7 - Test 1', 999, 'ASUS recommends Windows 10 Pro for business. The world’s smallest colorful 15” Ultrabook1', 1, 1, 'Whether at work or play, ASUS VivoBook 15 is the compact laptop that immerses you in whatever you set out to do. Its new frameless four-sided NanoEdge display boasts an ultraslim 5.7mm bezel, giving an amazing 88% screen-to-body ratio for supremely immersive visuals. The new ErgoLift hinge design also tilts the keyboard up for more comfortable typing. VivoBook 15 is powered by up to the latest AMD Ryzen™ 7 processor and dual storage drives to help you get things done with the least amount of fuss. What’s more, it’s available in four unique finishes to suit your style.', '2021-07-28', '2021-07-28'),
(1015, 2, 'MSI Modern 14 - B11S - Test 2', 999, 'Modern 14 - B11S11th Gen Intel® Core™ processor', 1, 1, 'Let your passion keep up with your dynamic lifestyle. Whether you are exploring new chapter in life or pursuing your career, with the latest 11th Gen. Intel® Core™ i7 processors and up to NVIDIA® discrete graphics, you will breathtaking new wonders through the Modern series.', '2021-07-28', '2021-07-28'),
(1016, 2, 'HP ProBook 450 G7 Laptop', 599, 'HP ProBook 450 G7 Laptop – Core i5 1.6GHz 4GB 500GB Shared Win10 15.6inch HD Silver English Keyboard', 1, 1, 'Laptop Type: NotebookStandard design laptopScreen Size: 15.6 InchesProcessor: Intel Core i5RAM: 4 GBStorage Size: 500 GBStorage Type: HDDSpeed: 1.6 GHzColor: Silver Model: 9ZE38UT', '2021-07-28', '2021-07-28'),
(1017, 2, 'Asus vivobook a512 i7 - test 2', 999, 'ASUS recommends Windows 10 Pro for business. The world’s smallest colorful 15” Ultrabook1', 1, 1, 'Whether at work or play, ASUS VivoBook 15 is the compact laptop that immerses you in whatever you set out to do. Its new frameless four-sided NanoEdge display boasts an ultraslim 5.7mm bezel, giving an amazing 88% screen-to-body ratio for supremely immersive visuals. The new ErgoLift hinge design also tilts the keyboard up for more comfortable typing. VivoBook 15 is powered by up to the latest AMD Ryzen™ 7 processor and dual storage drives to help you get things done with the least amount of fuss. What’s more, it’s available in four unique finishes to suit your style.', '2021-07-28', '2021-07-28'),
(1018, 2, 'MSI Modern 14 - B11S - test 3', 999, 'Modern 14 - B11S11th Gen Intel® Core™ processor', 1, 1, 'Let your passion keep up with your dynamic lifestyle. Whether you are exploring new chapter in life or pursuing your career, with the latest 11th Gen. Intel® Core™ i7 processors and up to NVIDIA® discrete graphics, you will breathtaking new wonders through the Modern series.', '2021-07-28', '2021-07-28'),
(1019, 2, 'HP ProBook 450 G7 Laptop Test 4', 599, 'HP ProBook 450 G7 Laptop – Core i5 1.6GHz 4GB 500GB Shared Win10 15.6inch HD Silver English Keyboard', 1, 1, 'Laptop Type: NotebookStandard design laptopScreen Size: 15.6 InchesProcessor: Intel Core i5RAM: 4 GBStorage Size: 500 GBStorage Type: HDDSpeed: 1.6 GHzColor: Silver Model: 9ZE38UT', '2021-07-28', '2021-07-28'),
(1020, 2, 'Asus vivobook a512 i7 - Test 6', 999, 'ASUS recommends Windows 10 Pro for business. The world’s smallest colorful 15” Ultrabook1', 1, 1, 'Whether at work or play, ASUS VivoBook 15 is the compact laptop that immerses you in whatever you set out to do. Its new frameless four-sided NanoEdge display boasts an ultraslim 5.7mm bezel, giving an amazing 88% screen-to-body ratio for supremely immersive visuals. The new ErgoLift hinge design also tilts the keyboard up for more comfortable typing. VivoBook 15 is powered by up to the latest AMD Ryzen™ 7 processor and dual storage drives to help you get things done with the least amount of fuss. What’s more, it’s available in four unique finishes to suit your style.', '2021-07-28', '2021-07-28'),
(1021, 2, 'MSI Modern 14 - B11S - Test 8', 999, 'Modern 14 - B11S11th Gen Intel® Core™ processor', 1, 1, 'Let your passion keep up with your dynamic lifestyle. Whether you are exploring new chapter in life or pursuing your career, with the latest 11th Gen. Intel® Core™ i7 processors and up to NVIDIA® discrete graphics, you will breathtaking new wonders through the Modern series.', '2021-07-28', '2021-07-28'),
(1022, 2, 'HP ProBook 450 G7 Laptop - test 9', 599, 'HP ProBook 450 G7 Laptop – Core i5 1.6GHz 4GB 500GB Shared Win10 15.6inch HD Silver English Keyboard', 1, 1, 'Laptop Type: NotebookStandard design laptopScreen Size: 15.6 InchesProcessor: Intel Core i5RAM: 4 GBStorage Size: 500 GBStorage Type: HDDSpeed: 1.6 GHzColor: Silver Model: 9ZE38UT', '2021-07-28', '2021-07-28'),
(1023, 3, 'Ipad 8', 599, 'iPad 8 Wifi 128GB (2020)', 0, 0, 'The iPad 8 Wifi 128GB (2020) is an affordable tablet model that is accessible to many. Although there are not too many changes, but thanks to the performance upgrade and smooth optimization from iPadOS, accompanied by an affordable price, it is enough to make Apple fans \"stand still\".', '2021-08-17', '2021-08-17'),
(1024, 3, 'iPad Air 4 Wifi 64GB (2020) ', 599, 'iPad Air 4 Wifi 64GB (2020) ', 1, 1, 'Apple has introduced the iPad Air 4 Wifi 64 GB tablet (2020). This is the company\'s first device equipped with the A14 Bionic chip - Apple\'s most powerful mobile chip (in 2020). And has a makeover thanks to the design inherited from the iPad Pro with a thin screen border that curves around the device.', '2021-08-17', '2021-08-17'),
(1025, 3, 'iPad Pro M1 11 inch WiFi 128GB (2021)', 599, 'iPad Pro M1 11 inch WiFi 128GB (2021)', 1, 1, 'The iPad Pro M1 11-inch Wifi 128GB tablet (2021) has been announced by Apple to become a very popular device because of its many advanced features, high applicability and is one of the most luxurious iPad models. important, bringing class to the owner.', '2021-08-17', '2021-08-17'),
(1026, 3, 'Ipad 8 - Test 1', 599, 'iPad 8 Wifi 128GB (2020)- Test 1', 0, 0, 'The iPad 8 Wifi 128GB (2020) is an affordable tablet model that is accessible to many. Although there are not too many changes, but thanks to the performance upgrade and smooth optimization from iPadOS, accompanied by an affordable price, it is enough to make Apple fans \"stand still\".', '2021-08-17', '2021-08-17'),
(1027, 3, 'iPad Air 4 Wifi 64GB (2020) - Test 1', 599, 'iPad Air 4 Wifi 64GB (2020) - Test 1', 1, 1, 'Apple has introduced the iPad Air 4 Wifi 64 GB tablet (2020). This is the company\'s first device equipped with the A14 Bionic chip - Apple\'s most powerful mobile chip (in 2020). And has a makeover thanks to the design inherited from the iPad Pro with a thin screen border that curves around the device.', '2021-08-17', '2021-08-17'),
(1028, 3, 'iPad Pro M1 11 inch WiFi 128GB (2021) - Test 1', 599, 'iPad Pro M1 11 inch WiFi 128GB (2021)- Test 1', 1, 1, 'The iPad Pro M1 11-inch Wifi 128GB tablet (2021) has been announced by Apple to become a very popular device because of its many advanced features, high applicability and is one of the most luxurious iPad models. important, bringing class to the owner.', '2021-08-17', '2021-08-17'),
(1029, 3, 'Ipad 8- Test 2', 599, 'iPad 8 Wifi 128GB (2020)- Test 2', 0, 0, 'The iPad 8 Wifi 128GB (2020) is an affordable tablet model that is accessible to many. Although there are not too many changes, but thanks to the performance upgrade and smooth optimization from iPadOS, accompanied by an affordable price, it is enough to make Apple fans \"stand still\".', '2021-08-17', '2021-08-17'),
(1030, 3, 'iPad Air 4 Wifi 64GB (2020) - Test 2', 599, 'iPad Air 4 Wifi 64GB (2020) - Test 2', 1, 1, 'Apple has introduced the iPad Air 4 Wifi 64 GB tablet (2020). This is the company\'s first device equipped with the A14 Bionic chip - Apple\'s most powerful mobile chip (in 2020). And has a makeover thanks to the design inherited from the iPad Pro with a thin screen border that curves around the device.', '2021-08-17', '2021-08-17'),
(1031, 3, 'iPad Pro M1 11 inch WiFi 128GB (2021) - Test 2', 599, 'iPad Pro M1 11 inch WiFi 128GB (2021)- Test 2', 1, 1, 'The iPad Pro M1 11-inch Wifi 128GB tablet (2021) has been announced by Apple to become a very popular device because of its many advanced features, high applicability and is one of the most luxurious iPad models. important, bringing class to the owner.', '2021-08-17', '2021-08-17'),
(1032, 3, 'Ipad 8 - Test 3', 599, 'iPad 8 Wifi 128GB (2020)- Test 3', 0, 0, 'The iPad 8 Wifi 128GB (2020) is an affordable tablet model that is accessible to many. Although there are not too many changes, but thanks to the performance upgrade and smooth optimization from iPadOS, accompanied by an affordable price, it is enough to make Apple fans \"stand still\".', '2021-08-17', '2021-08-17'),
(1033, 3, 'iPad Air 4 Wifi 64GB (2020) - Test 3', 599, 'iPad Air 4 Wifi 64GB (2020) - Test 3', 1, 1, 'Apple has introduced the iPad Air 4 Wifi 64 GB tablet (2020). This is the company\'s first device equipped with the A14 Bionic chip - Apple\'s most powerful mobile chip (in 2020). And has a makeover thanks to the design inherited from the iPad Pro with a thin screen border that curves around the device.', '2021-08-17', '2021-08-17'),
(1034, 3, 'iPad Pro M1 11 inch WiFi 128GB (2021) - Test 3', 599, 'iPad Pro M1 11 inch WiFi 128GB (2021)- Test 3', 1, 1, 'The iPad Pro M1 11-inch Wifi 128GB tablet (2021) has been announced by Apple to become a very popular device because of its many advanced features, high applicability and is one of the most luxurious iPad models. important, bringing class to the owner.', '2021-08-17', '2021-08-17');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(11) NOT NULL,
  `user` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `display_name` varchar(100) NOT NULL,
  `address` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `colors`
--
ALTER TABLE `colors`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menus`
--
ALTER TABLE `menus`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_category` (`id_category`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `colors`
--
ALTER TABLE `colors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `menus`
--
ALTER TABLE `menus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10011;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
