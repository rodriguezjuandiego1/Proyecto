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
INSERT INTO `afiliaciones` VALUES ('2022-07-28',232);
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
  PRIMARY KEY (`cedula`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afiliados`
--

LOCK TABLES `afiliados` WRITE;
/*!40000 ALTER TABLE `afiliados` DISABLE KEYS */;
INSERT INTO `afiliados` VALUES (123,'Pepe','Gonzalez','Uru','xxxxx','555','pepe@gmail.com','1970-05-21',1,'activo'),(232,'OOOOOOOOOO','GGGGGGGGG','GGGGGGGGGGGGGGG','GGGGGGGGGGGG','66666','GGGGGGGGGG','2022-07-01',5,'activo'),(478,'Jorge','Martinez','Bra','rrrrrr','444','jor@vera.com','2000-01-05',4,'activo'),(568,'Ana','Perez','Arg','yyyyy','888','ana@mail.com','1980-06-25',2,'activo'),(874,'Luis','Garcia','Uru','ppppp','777','luis@hhh.com','1997-07-08',3,'activo'),(999,'Maria','Lopez','Uru','tttttt','333','mar@gmail.com','1998-08-31',5,'activo');
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
INSERT INTO `facturas` VALUES (6,'2022-07-01','CUOTA',1500,NULL,478),(7,'2022-07-01','CUOTA',1500,NULL,999),(8,'2022-08-01','CUOTA',1500,NULL,478),(9,'2022-08-01','CUOTA',1500,NULL,999),(10,'2022-10-01','CUOTA',1500,NULL,478),(11,'2022-10-01','CUOTA',1500,NULL,999);
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locales`
--

DROP TABLE IF EXISTS `locales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locales` (
  `idLocales` int NOT NULL AUTO_INCREMENT,
  `direccion` varchar(45) NOT NULL,
  `encargado` varchar(45) NOT NULL,
  `Negocios_idNegocios` int NOT NULL,
  PRIMARY KEY (`idLocales`,`Negocios_idNegocios`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locales`
--

LOCK TABLES `locales` WRITE;
/*!40000 ALTER TABLE `locales` DISABLE KEYS */;
INSERT INTO `locales` VALUES (1,'18 de Julio 589','Pepito',1),(2,'Ventura 569','Fulano',1),(3,'Av Artigas 458','Menganito',1),(4,'Gral Flores','Sultanito',2),(5,'Sarandi','Cacho',2);
/*!40000 ALTER TABLE `locales` ENABLE KEYS */;
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
  `Rubros_idRubros` int NOT NULL,
  PRIMARY KEY (`idNegocios`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `negocios`
--

LOCK TABLES `negocios` WRITE;
/*!40000 ALTER TABLE `negocios` DISABLE KEYS */;
INSERT INTO `negocios` VALUES (1,'Legacy',1),(2,'Burger King',2),(3,'Ferrosur',3),(4,'Pasteur',4),(5,'Lolita',1);
/*!40000 ALTER TABLE `negocios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificaciones`
--

DROP TABLE IF EXISTS `notificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificaciones` (
  `idnotificaciones` int NOT NULL,
  `fecha` date NOT NULL,
  `id_afiliado` int NOT NULL,
  PRIMARY KEY (`idnotificaciones`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificaciones`
--

LOCK TABLES `notificaciones` WRITE;
/*!40000 ALTER TABLE `notificaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rubros`
--

DROP TABLE IF EXISTS `rubros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rubros` (
  `idRubros` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idRubros`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rubros`
--

LOCK TABLES `rubros` WRITE;
/*!40000 ALTER TABLE `rubros` DISABLE KEYS */;
INSERT INTO `rubros` VALUES (1,'Vestimenta'),(2,'Alimentacion'),(3,'Ferreteria'),(4,'Farmacia');
/*!40000 ALTER TABLE `rubros` ENABLE KEYS */;
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
INSERT INTO `usuarios` VALUES ('ana','ana','Ana'),('diego','diego','Diego'),('pepe','pepe','Pepe');
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

-- Dump completed on 2022-07-29 22:36:45
