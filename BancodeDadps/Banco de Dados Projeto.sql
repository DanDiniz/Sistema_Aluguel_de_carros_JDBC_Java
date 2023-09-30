CREATE DATABASE  IF NOT EXISTS `locadoracarrosma` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `locadoracarrosma`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: locadoracarrosma
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Cpf` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'João Lukas','joao@gmail.com','123456789'),(2,'MOTTA MARCOS','motta@gmail.com','65367812390'),(3,'Ana vitoria','Ana@gmail.com','87698745815'),(4,'Daniel Silva','Daniel@gmail.com','45625963725'),(5,'Joana Lima','Joana@gmail.com','28561894329'),(6,'Manoel gomes blue pen','bluepen@gmail.com','16897524630');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emprestimo`
--

DROP TABLE IF EXISTS `emprestimo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emprestimo` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `cliente` int NOT NULL,
  `veiculo` int NOT NULL,
  `multa` double NOT NULL,
  `data emprestimo` date NOT NULL,
  `previsao entrega` date NOT NULL,
  `data devolucao` date DEFAULT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `cliente_idx` (`cliente`),
  KEY `veiculo_idx` (`veiculo`),
  CONSTRAINT `cliente` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`Id`),
  CONSTRAINT `veiculo` FOREIGN KEY (`veiculo`) REFERENCES `veiculo` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emprestimo`
--

LOCK TABLES `emprestimo` WRITE;
/*!40000 ALTER TABLE `emprestimo` DISABLE KEYS */;
INSERT INTO `emprestimo` VALUES (1,1,1,0,'2023-05-23','2023-07-21','2023-07-21',1200),(2,3,2,500,'2023-08-09','2023-09-02',NULL,1700);
/*!40000 ALTER TABLE `emprestimo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca_veiculo`
--

DROP TABLE IF EXISTS `marca_veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marca_veiculo` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca_veiculo`
--

LOCK TABLES `marca_veiculo` WRITE;
/*!40000 ALTER TABLE `marca_veiculo` DISABLE KEYS */;
INSERT INTO `marca_veiculo` VALUES (1,'FIAT'),(2,'CHEVROLET'),(3,'VOLKSWAGEN');
/*!40000 ALTER TABLE `marca_veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veiculo` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `modelo` varchar(45) NOT NULL,
  `marca` int NOT NULL,
  `km` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `marca_idx` (`marca`),
  CONSTRAINT `marca` FOREIGN KEY (`marca`) REFERENCES `marca_veiculo` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
INSERT INTO `veiculo` VALUES (1,'POLO',3,3000),(2,'GOL',3,2000),(3,'CLASSIC',2,10000),(4,'ONIX',2,15000),(5,'UNO',1,25000),(6,'MOBI',1,60000);
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendendor`
--

DROP TABLE IF EXISTS `vendendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendendor` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendendor`
--

LOCK TABLES `vendendor` WRITE;
/*!40000 ALTER TABLE `vendendor` DISABLE KEYS */;
INSERT INTO `vendendor` VALUES (1,'Pericles serra','78245316785'),(2,'Vitoria nunes','78245316785'),(3,'Pericles serra','78245316785');
/*!40000 ALTER TABLE `vendendor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-29 20:42:43
