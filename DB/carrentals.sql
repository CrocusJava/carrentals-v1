CREATE DATABASE  IF NOT EXISTS `carrentals` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `carrentals`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: carrentals
-- ------------------------------------------------------
-- Server version	5.5.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `idcar` int(11) NOT NULL AUTO_INCREMENT,
  `idplace` int(11) NOT NULL,
  `photo` varchar(35) NOT NULL,
  `price` int(11) NOT NULL,
  `carnumber` varchar(35) NOT NULL,
  `carbodytype` varchar(35) NOT NULL,
  `brand` varchar(35) NOT NULL,
  `model` varchar(35) NOT NULL,
  `color` varchar(35) NOT NULL,
  `class` char(1) NOT NULL,
  `transmission` varchar(35) NOT NULL,
  `quantityseats` int(11) NOT NULL,
  `quantitydoors` int(11) NOT NULL,
  `conditioner` tinyint(4) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `statecar` tinyint(4) NOT NULL,
  PRIMARY KEY (`idcar`),
  UNIQUE KEY `idcar_UNIQUE` (`idcar`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,3,'images/DaewooMatiz.jpg',25,'AA 1234 КВ','HATCHBACK','Daewoo','Matiz','white','E','manual',5,5,1,NULL,1),(2,2,'images/DaewooLanos.jpg',28,'AA 4331 КВ','SEDAN','Daewoo','Lanos','gray','H','manual',5,4,1,NULL,1),(3,1,'images/MitsubishiLancerX.jpg',47,'AA 3532 KB','SEDAN','Mitsubishi','LancerX','black','J','tiptronic',5,4,1,NULL,1),(4,5,'images/ToyotaCamry40.jpg',80,'AA 9252 KB','SEDAN','Toyota','Camry40','gray','U','tiptronic',5,4,1,NULL,1),(5,2,'images/MercedesBenzLorinser.jpg',300,'AA 4352 KB','SEDAN','MercedesBenz','Lorincer','black','L','tiptronic',5,4,1,NULL,1);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `idclient` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  `birthday` date NOT NULL,
  `passportseries` varchar(35) NOT NULL,
  `passportnumber` int(11) NOT NULL,
  `phonenumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`idclient`),
  UNIQUE KEY `idClient_UNIQUE` (`idclient`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,2,'1986-12-10','HK',436352,971111111),(2,3,'1988-09-01','BM',647255,972223334),(3,4,'1988-09-01','НЕ',547326,970101011),(4,5,'1990-09-01','TH',555999,63546576),(5,7,'1980-01-01','TE',111555,987654321),(6,17,'1990-01-08','AE',987789,989898988),(7,8,'1983-11-20','OP',908890,509877887),(8,9,'1983-11-23','EE',978654,639907856),(9,18,'1978-11-19','PO',988900,509876556),(10,19,'1990-08-30','HO',989898,658909732);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `place`
--

DROP TABLE IF EXISTS `place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `place` (
  `idplace` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(45) NOT NULL,
  `descriptionplace` varchar(45) NOT NULL,
  PRIMARY KEY (`idplace`),
  UNIQUE KEY `idplace_UNIQUE` (`idplace`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `place`
--

LOCK TABLES `place` WRITE;
/*!40000 ALTER TABLE `place` DISABLE KEYS */;
INSERT INTO `place` VALUES (1,'Kiev','Aeroport Shulani'),(2,'Kiev','Aeroport Borispol'),(3,'Kiev','Railway Station Centralniy'),(4,'Lviv','Aeroport'),(5,'Harkiv','Aeroport');
/*!40000 ALTER TABLE `place` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `middlename` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','admin@gmail.com','Ruslan','Tkachuk','Vasilevich','admin'),(2,'user','user','user@gmail.com','Taras','Vlasenko','Petrovich','user'),(3,'user2','user2','user2@gmail.com','Irina','Ustemuk','Anatolivna','user'),(4,'user10','user10','user10@gmail.com','user10','user10','user10','user'),(5,'user3','user3','user3@gmil.com','user3','user3','user3','user'),(7,'user4','user4','user4@gmail.com','user4','user4','user4','user'),(8,'user5','user5','user5@gamil.com','user5','user5','user5','user'),(9,'user6','user6','user6@gmail.com','user6','user6','user6','user'),(10,'user7','user7','user7@gmail.com','user7','user7','user7','user'),(11,'user8','user8','user8@gmail.com','user8','user8','user8','user'),(12,'user9','user9','user9@gmail.com','user9','user9','user9','user'),(13,'user15','user15','user15@gmail.com','user15','user15','user15','user'),(14,'user16','user16','user16@gmail.com','user16','user16','user16','user'),(15,'user17','user17','user17@gmail.com','user17','user17','user17','user'),(16,'user77','user77','user17@gmail.com','user17','user17','user17','user'),(17,'user100','user100','user100@gmail.com','user100','user100','user100','user'),(18,'user55','user55','user55@gmail.com','user55','user55','user55','user'),(19,'user18','user18','user18@gmail.com','user18','user18','user18','user');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderlist`
--

DROP TABLE IF EXISTS `orderlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderlist` (
  `idorder` int(11) NOT NULL AUTO_INCREMENT,
  `idclient` int(11) NOT NULL,
  `idcar` int(11) NOT NULL,
  `idplaceget` int(11) NOT NULL,
  `idplacereturn` int(11) NOT NULL,
  `dateget` date NOT NULL,
  `datereturn` date NOT NULL,
  `stateorder` tinyint(4) DEFAULT '0',
  `description` varchar(200) DEFAULT NULL,
  `orderexecuted` tinyint(4) DEFAULT '0',
  `descriptiondamage` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idorder`),
  UNIQUE KEY `idorder_UNIQUE` (`idorder`),
  KEY `idclient_idx` (`idclient`),
  KEY `idcar_idx` (`idcar`),
  KEY `idplaceget_idx` (`idplaceget`),
  KEY `idplacereturn_idx` (`idplacereturn`),
  CONSTRAINT `idcar` FOREIGN KEY (`idcar`) REFERENCES `car` (`idcar`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idclient` FOREIGN KEY (`idclient`) REFERENCES `client` (`idclient`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idplaceget` FOREIGN KEY (`idplaceget`) REFERENCES `place` (`idplace`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idplacereturn` FOREIGN KEY (`idplacereturn`) REFERENCES `place` (`idplace`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderlist`
--

LOCK TABLES `orderlist` WRITE;
/*!40000 ALTER TABLE `orderlist` DISABLE KEYS */;
INSERT INTO `orderlist` VALUES (1,2,2,1,4,'2013-01-10','2013-01-15',1,'    ',1,'    '),(2,2,2,1,2,'2013-01-01','2013-01-15',1,'was many car damages',1,'      '),(3,3,1,1,2,'2013-01-01','2013-01-15',1,'     ',1,'     '),(4,6,3,1,3,'2013-01-01','2013-01-01',0,NULL,0,NULL),(5,7,1,3,5,'2013-01-08','2013-01-08',0,NULL,0,NULL),(6,9,3,1,5,'2013-02-10','2013-03-02',0,NULL,0,NULL),(7,10,1,3,5,'2013-01-10','2013-01-23',1,' ',0,' ');
/*!40000 ALTER TABLE `orderlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-01-10 17:30:07
