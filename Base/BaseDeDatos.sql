CREATE DATABASE  IF NOT EXISTS `adn` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `adn`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: adn
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `afiliaciones`
--

DROP TABLE IF EXISTS `afiliaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `afiliaciones` (
  `fecha` date NOT NULL,
  `Afiliados_cedula` int NOT NULL,
  PRIMARY KEY (`fecha`,`Afiliados_cedula`),
  KEY `fk_Afiliaciones_Afiliados1_idx` (`Afiliados_cedula`),
  CONSTRAINT `fk_Afiliaciones_Afiliados1` FOREIGN KEY (`Afiliados_cedula`) REFERENCES `afiliados` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afiliaciones`
--

LOCK TABLES `afiliaciones` WRITE;
/*!40000 ALTER TABLE `afiliaciones` DISABLE KEYS */;
INSERT INTO `afiliaciones` VALUES ('2022-08-11',4),('2022-08-10',23658524),('2021-08-10',24528541),('2022-08-11',25632478),('2022-02-02',32565247),('2020-08-10',35268547),('1999-07-16',35268742),('2021-01-01',45826597),('2020-03-05',46302507);
/*!40000 ALTER TABLE `afiliaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `afiliados`
--

DROP TABLE IF EXISTS `afiliados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `afiliados` (
  `cedula` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `nacionalidad` varchar(45) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `nacimiento` date NOT NULL,
  `negocios_idNegocios` int DEFAULT NULL,
  `estado` varchar(20) NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  PRIMARY KEY (`cedula`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afiliados`
--

LOCK TABLES `afiliados` WRITE;
/*!40000 ALTER TABLE `afiliados` DISABLE KEYS */;
INSERT INTO `afiliados` VALUES (4,'Claudio','Gonzalez','Arg','Montevideo','098526356','claudito@gmail.com','1994-08-11',8,'inactivo',NULL),(23658524,'German','Diaz','Uru','Florida','097582369','german@hotmail.com','1985-01-05',5,'activo',NULL),(24528541,'Romina','Mendez','Bra','Montevideo','091526356','rmendez@gmail.com','1963-04-18',4,'activo',NULL),(25632478,'Lucia','Gonzalez','Uru','Durazno','097456789','luciag@yahoo.es','2002-08-09',1,'activo',NULL),(32565247,'Fernando','Martinez','Uru','Durazno','098523654','fernando@hotmail.com','1950-05-05',3,'activo',NULL),(35268547,'Felipe','Melo','Bra','Colonia','094526356','felipito@gmail.es','1980-05-19',12,'activo',NULL),(35268742,'Claudia','Garcia','Uru','Montevideo','091526324','claudia@gmail.com','1990-04-04',6,'activo',NULL),(45826597,'Ana','Perez','Bra','Montevideo','095236896','anaperez@hotmail.com','1998-06-18',2,'activo',NULL),(46302507,'Diego','Rodriguez','Uru','Florida','095015536','rodriguez@gmail.com','1997-08-22',1,'inactivo','2022-09-01');
/*!40000 ALTER TABLE `afiliados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturas` (
  `idfacturas` int NOT NULL AUTO_INCREMENT,
  `fecha_emision` date NOT NULL,
  `concepto` varchar(45) NOT NULL,
  `importe` double NOT NULL,
  `fecha_pago` date DEFAULT NULL,
  `afiliadoced` int NOT NULL,
  PRIMARY KEY (`idfacturas`),
  KEY `idafiliado_fk_idx` (`afiliadoced`),
  CONSTRAINT `idafiliado_fk` FOREIGN KEY (`afiliadoced`) REFERENCES `afiliados` (`cedula`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
INSERT INTO `facturas` VALUES (12,'2022-06-01','CUOTA',1500,NULL,46302507),(13,'2022-07-01','CUOTA',1500,NULL,23658524),(14,'2022-07-01','CUOTA',1500,NULL,24528541),(15,'2022-07-01','CUOTA',1500,NULL,25632478),(16,'2022-07-01','CUOTA',1500,NULL,32565247),(17,'2022-07-01','CUOTA',1500,NULL,35268547),(18,'2022-07-01','CUOTA',1500,NULL,35268742),(19,'2022-07-01','CUOTA',1500,NULL,45826597),(20,'2022-07-01','CUOTA',1500,NULL,46302507),(21,'2022-08-01','CUOTA',1500,NULL,23658524),(22,'2022-08-01','CUOTA',1500,NULL,24528541),(23,'2022-08-01','CUOTA',1500,NULL,25632478),(24,'2022-08-01','CUOTA',1500,NULL,32565247),(25,'2022-08-01','CUOTA',1500,NULL,35268547),(26,'2022-08-01','CUOTA',1500,NULL,35268742),(27,'2022-08-01','CUOTA',1500,NULL,45826597),(28,'2022-08-01','CUOTA',1500,NULL,46302507),(29,'2022-09-01','CUOTA',1500,NULL,23658524),(30,'2022-09-01','CUOTA',1500,NULL,24528541),(31,'2022-09-01','CUOTA',1500,NULL,25632478),(32,'2022-09-01','CUOTA',1500,NULL,32565247),(33,'2022-09-01','CUOTA',1500,NULL,35268547),(34,'2022-09-01','CUOTA',1500,NULL,35268742),(35,'2022-09-01','CUOTA',1500,NULL,45826597);
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `negocios`
--

DROP TABLE IF EXISTS `negocios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `negocios` (
  `idNegocios` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idNegocios`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `negocios`
--

LOCK TABLES `negocios` WRITE;
/*!40000 ALTER TABLE `negocios` DISABLE KEYS */;
INSERT INTO `negocios` VALUES (13,'BananaStore'),(2,'Burger King'),(4,'Farmacia Pasteur'),(3,'Ferrosur Florida'),(10,'Instituto Bios'),(9,'Kiosco El Trapesista'),(1,'Legacy'),(6,'Panaderia Pan Caliente'),(8,'Tienda iStore'),(12,'Tienda Ropa Fea');
/*!40000 ALTER TABLE `negocios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificaciones`
--

DROP TABLE IF EXISTS `notificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificaciones` (
  `idnotificaciones` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `afiliadoced` int NOT NULL,
  PRIMARY KEY (`idnotificaciones`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificaciones`
--

LOCK TABLES `notificaciones` WRITE;
/*!40000 ALTER TABLE `notificaciones` DISABLE KEYS */;
INSERT INTO `notificaciones` VALUES (1,'2022-08-11',46302507),(2,'2022-08-11',23658524),(3,'2022-08-11',24528541),(4,'2022-08-11',25632478),(5,'2022-08-11',32565247),(6,'2022-08-11',35268547),(7,'2022-08-11',35268742),(8,'2022-08-11',45826597),(9,'2022-08-11',46302507);
/*!40000 ALTER TABLE `notificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarifas`
--

DROP TABLE IF EXISTS `tarifas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarifas` (
  `fecha` date NOT NULL,
  `matricula` double NOT NULL,
  `cuota` double NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fecha_UNIQUE` (`fecha`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarifas`
--

LOCK TABLES `tarifas` WRITE;
/*!40000 ALTER TABLE `tarifas` DISABLE KEYS */;
INSERT INTO `tarifas` VALUES ('2021-05-01',4000,1200,1),('2022-05-01',5000,1500,2);
/*!40000 ALTER TABLE `tarifas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `usuario` varchar(45) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('diego','diego','Diego'),('lucas','lucas','Lucas'),('rina','rina','Rina');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-11 20:56:33
