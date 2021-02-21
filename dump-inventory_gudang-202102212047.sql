-- MariaDB dump 10.18  Distrib 10.4.17-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: inventory_gudang
-- ------------------------------------------------------
-- Server version	10.4.17-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `courier`
--

DROP TABLE IF EXISTS `courier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courier` (
  `idCourier` varchar(100) NOT NULL,
  `nameCourier` varchar(100) DEFAULT NULL,
  `usernameCourier` varchar(100) DEFAULT NULL,
  `idVehicle` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idCourier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courier`
--

LOCK TABLES `courier` WRITE;
/*!40000 ALTER TABLE `courier` DISABLE KEYS */;
INSERT INTO `courier` VALUES ('01815c8a-a711-4b1a-bf52-1006e6997da5','Ahmad','ahmad','B 3021 CR'),('0b4f028b-55a7-477b-9b74-dd45db7dcd1c','Bambang','bambang','T 9090 JUK'),('1898de1f-96d6-4ed5-abb6-8738849536c5','JOHN','john','W 1209 RS'),('42f80b2a-7de1-4164-88cd-a0025ba59df2','Lucy','lucy','P 9001 INK'),('430f81f4-7bbb-49e3-8c0f-1f851639f529','Herman','herman','N 4054 KK'),('568b1543-97bc-42bf-8111-da789434af1b','samanta','samanta','Y 3333 N'),('64b9b29d-0a7b-4a2e-acb6-26c87a7e7d4e','Dodit','dodit','G 4432 HN'),('78e9decd-938a-4dc9-aa52-98191dba3eee','Lukman','lukman','W 1234 SD'),('845f64d9-47d6-4aa4-9376-ccb22f5ba22f','Jean','jean','K 3434 ERN'),('9278d9aa-07ae-47e7-be10-44b6bd6766f0','Luka','luka','N 6767 IJ'),('9b709e64-248e-453e-9d6b-9ed443da6c62','Romi','romi','N 3121 NH'),('c5187601-aaaf-4b40-8b67-4d10cebc74d5','Gerard','gerard','E 1010 OO'),('d16f1df5-bd3a-4792-9bab-408ee76d5661','Cika','cika','H 7766 POP'),('e968ca09-0570-482e-a64c-1c6cdf9b84ac','Amin','amin','A 2189 AS'),('f5e553a6-9d3b-42fc-81b0-f2dc840bec40','Geisha','gege','N 6534 MN'),('f75c6f67-7695-4dfc-9ed5-c0381080f21b','JOSH','josh','U 8767 IK');
/*!40000 ALTER TABLE `courier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_transaction`
--

DROP TABLE IF EXISTS `detail_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detail_transaction` (
  `idTransaction` varchar(100) NOT NULL,
  `idItemTrx` varchar(100) DEFAULT NULL,
  `idItem` varchar(100) DEFAULT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY (`idTransaction`),
  KEY `detail_transaction_FK` (`idItemTrx`),
  KEY `detail_transaction_FK_1` (`idItem`),
  CONSTRAINT `detail_transaction_FK` FOREIGN KEY (`idItemTrx`) REFERENCES `transaction` (`idItemTrx`),
  CONSTRAINT `detail_transaction_FK_1` FOREIGN KEY (`idItem`) REFERENCES `item` (`idItem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_transaction`
--

LOCK TABLES `detail_transaction` WRITE;
/*!40000 ALTER TABLE `detail_transaction` DISABLE KEYS */;
INSERT INTO `detail_transaction` VALUES ('09aa1716-26af-454f-90e0-ca30130d175b','647eb36f-805f-47da-b7b5-0ed2d22face3','0313ac52-e139-44c6-8a96-173f51e9ee73',1),('18066a93-d6fd-48fc-bbd3-5ea60e6d75a4','3622f276-2071-4fec-9d28-529be6ca3d4a','2b783f1e-e567-486a-aace-a89ac2d9fa1f',12),('9f1be2db-2740-4ecc-b7ac-b3bce80d42d3','2bbcca4d-fc7a-4a5b-bdbe-27e01aec653f','532e2b89-43c9-4d16-90c7-020992ee15e8',9);
/*!40000 ALTER TABLE `detail_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `idItem` varchar(100) NOT NULL,
  `nameItem` varchar(100) NOT NULL,
  `idCategory` varchar(100) NOT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`idItem`),
  KEY `item_FK` (`idCategory`),
  CONSTRAINT `item_FK` FOREIGN KEY (`idCategory`) REFERENCES `item_category` (`idCategory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES ('0313ac52-e139-44c6-8a96-173f51e9ee73','Salmon','e32eb3bc-2f4c-4782-afca-cb8aeddb15c7',11),('1f814831-ff14-411d-af56-f6607ff0fb6e','piring','9c98d6a5-39fc-412c-8d14-e7bc7c2ae8d5',0),('2b783f1e-e567-486a-aace-a89ac2d9fa1f','TV','bb29da52-0014-4d8b-b34e-8b2e5466e41c',1),('4c7d9bf1-e5cd-4628-9c5c-dba6a4986c7e','Komputer','bb29da52-0014-4d8b-b34e-8b2e5466e41c',0),('532e2b89-43c9-4d16-90c7-020992ee15e8','beras','e32eb3bc-2f4c-4782-afca-cb8aeddb15c7',9),('7e79797b-a26d-4435-a456-1e3350882971','Kipas angin','bb29da52-0014-4d8b-b34e-8b2e5466e41c',0),('8350bdeb-cf3e-43c8-bdfc-272098ed4aaf','Acid','d160d4e2-8895-45fc-861c-cf00b84054f2',0),('94cff904-0285-4be3-97da-ff815edd0985','jagung','e32eb3bc-2f4c-4782-afca-cb8aeddb15c7',0),('beaf80f9-02d3-4979-8cff-bc57688db810','sepatu','6a15922c-6db3-4ebb-94aa-eaec5f4ea7a5',0),('cb9a3753-ddac-49c3-93cb-1227a152d6f4','Pakaian','6a15922c-6db3-4ebb-94aa-eaec5f4ea7a5',0),('ceee8a11-d76d-4098-9ab5-2e13a1c21515','Natrium','d160d4e2-8895-45fc-861c-cf00b84054f2',0),('cfd1a062-c98d-4409-90f0-59aeb0f12661','Aqua','e32eb3bc-2f4c-4782-afca-cb8aeddb15c7',0),('d96113a8-16aa-4fb5-9229-fbb2cffed733','Sulfat','d160d4e2-8895-45fc-861c-cf00b84054f2',0),('daebfdbc-88f2-496f-ad6d-fab6ec8673f0','Kaca','9c98d6a5-39fc-412c-8d14-e7bc7c2ae8d5',0),('f22f0777-1c48-4891-b1f5-a16ed239ef6d','sepeda','6a15922c-6db3-4ebb-94aa-eaec5f4ea7a5',0),('ff63fb34-0697-4426-bc6b-68f2adbc16c6','Laptop','bb29da52-0014-4d8b-b34e-8b2e5466e41c',0);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_category`
--

DROP TABLE IF EXISTS `item_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_category` (
  `idCategory` varchar(100) NOT NULL,
  `nameCategory` varchar(100) NOT NULL,
  PRIMARY KEY (`idCategory`),
  UNIQUE KEY `item_category_un` (`nameCategory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_category`
--

LOCK TABLES `item_category` WRITE;
/*!40000 ALTER TABLE `item_category` DISABLE KEYS */;
INSERT INTO `item_category` VALUES ('d160d4e2-8895-45fc-861c-cf00b84054f2','chemicals'),('bb29da52-0014-4d8b-b34e-8b2e5466e41c','electronics'),('e32eb3bc-2f4c-4782-afca-cb8aeddb15c7','foods'),('9c98d6a5-39fc-412c-8d14-e7bc7c2ae8d5','fragile'),('6a15922c-6db3-4ebb-94aa-eaec5f4ea7a5','others');
/*!40000 ALTER TABLE `item_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `idItemTrx` varchar(100) NOT NULL,
  `nameItemTrx` varchar(100) DEFAULT NULL,
  `dateTimeCreated` datetime DEFAULT NULL,
  `idCourier` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idItemTrx`),
  KEY `transaction_FK` (`idCourier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES ('2bbcca4d-fc7a-4a5b-bdbe-27e01aec653f','IN202102-002','2021-02-21 17:48:38','0b4f028b-55a7-477b-9b74-dd45db7dcd1c','IN'),('3622f276-2071-4fec-9d28-529be6ca3d4a','OUT202102-002','2021-02-21 00:00:00','568b1543-97bc-42bf-8111-da789434af1b','OUT'),('647eb36f-805f-47da-b7b5-0ed2d22face3','OUT202102-001','2021-02-21 00:00:00','42f80b2a-7de1-4164-88cd-a0025ba59df2','OUT');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'inventory_gudang'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-21 20:47:40
