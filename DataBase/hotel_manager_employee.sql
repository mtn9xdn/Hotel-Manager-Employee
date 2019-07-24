-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel_manager
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `id` varchar(36) NOT NULL,
  `employee_group` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `birthday` datetime NOT NULL,
  `gender` varchar(45) NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  `CMND` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `employee_code` varchar(45) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('2e2e8e48-bfce-4238-b01a-5d395dc77ac9','Lễ tân','Nam','2019-05-31 00:00:00','Male','09857098709','111111','login9xdn.0nljn3@gmail.com','111111',NULL,_binary ''),('b7dcb4bd-35db-4379-aa43-2cf4d744f298','Lễ tân','Uyên','2000-10-05 00:00:00','Female','0906475010','201680350','mtn9xdn@gmail.com','Đà Lạt','2',_binary '\0'),('c18af250-1f0a-4599-a54e-537dfe72c062','Quản lý nhân sự','Nam','2019-05-16 00:00:00','Male','0783803025','201680350','login9xdn.0nljn3@gmail.com','Đà Nẵng','1',_binary '\0'),('d9423808-8b0c-420d-ae0d-b365961e4e26','Quản lý phòng','Bình','2019-05-22 00:00:00','Male','0783803025','201680350','mtn9xdn@gmail.com','K55/39 Thành Vinh 2 - Thọ Quang - Sơn Trà - Đà Nẵng','3',_binary '\0');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-20 17:19:47
