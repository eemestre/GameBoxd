CREATE DATABASE  IF NOT EXISTS `gameboxd` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gameboxd`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: gameboxd
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `avaliacoes`
--

DROP TABLE IF EXISTS `avaliacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avaliacoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `FK_usuario_username` varchar(255) NOT NULL,
  `FK_jogo_nome` varchar(255) NOT NULL,
  `Comentario` varchar(511) DEFAULT NULL,
  `Nota` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacoes`
--

LOCK TABLES `avaliacoes` WRITE;
/*!40000 ALTER TABLE `avaliacoes` DISABLE KEYS */;
INSERT INTO `avaliacoes` VALUES (2,'xX_BruninGamer69_Xx','Hollow Knight','Prefiro joaninhas...',6),(3,'jubeiroco','Hollow Knight','Meu jogo favorito depois de roblox :P',8.5),(4,'japo','Minecraft','Eu. vio rerobrain',8),(5,'adm','Minecraft','Meu filho amou o jogo!',10),(7,'menck','Hollow Knight','topissimo',10),(8,'xX_BruninGamer69_Xx','Minecraft','relamente so tem blocos',10),(13,'adm','Hollow Knight','Muito fera',10),(14,'adm','Hollow Knight','Odeio esse jogo',1),(15,'adm','Minecraft','mega ruim',1),(16,'adm','Hollow Knight','Prometo que é a ultima',1),(17,'Lucas Pelegrina','Hollow Knight','Adoro esse jogo, besouros sao meus insetos favoritos! hahahahahaha',10),(18,'Lucas Pelegrina','Minecraft','Eu amo jogar com mods, saudades do meu pai',10),(21,'adm','Grand Theft Auto V','Muito bom!',10),(22,'adm','Astro Bot','como q isso ganhou game of the year',1),(23,'Eduardo','Astro Bot','realmente pessimo',1),(24,'teste','Astro Bot','Pessimo',3),(25,'Eduardo','Candy Crush','Bom demais',10);
/*!40000 ALTER TABLE `avaliacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogos`
--

DROP TABLE IF EXISTS `jogos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jogos` (
  `Nome` varchar(255) NOT NULL,
  `Descr` varchar(255) NOT NULL,
  `img` varchar(1023) DEFAULT NULL,
  `Nota` float NOT NULL,
  PRIMARY KEY (`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogos`
--

LOCK TABLES `jogos` WRITE;
/*!40000 ALTER TABLE `jogos` DISABLE KEYS */;
INSERT INTO `jogos` VALUES ('Astro Bot','robo bem do sem graça','https://image.api.playstation.com/vulcan/ap/rnd/202406/0500/8f15268257b878597757fcc5f2c9545840867bc71fc863b1.png',1.66667),('Candy Crush','muita bala','https://upload.wikimedia.org/wikipedia/pt/a/a7/Candy_Crush_Saga_logo.png',10),('Dark Souls III','Muito dificil.','https://image.api.playstation.com/cdn/UP0700/CUSA03388_00/v8JlD8KcQUtTqaLBmpFnj1ESRR5zMkLk.png',0),('Donkey Kong ','Macaco que pula barril','https://upload.wikimedia.org/wikipedia/pt/d/d4/Donkey_Kong_character.png',0),('Grand Theft Auto V','Jogo de ladrões','https://maisplay.com/wp-content/uploads/2023/03/a-historia-completa-de-gta-v-resumida-1320x742.jpg',10),('Hollow Knight','Jogo de um besouro safado sem vergonha.','https://images.squarespace-cdn.com/content/v1/606d159a953867291018f801/1619987722169-VV6ZASHHZNRBJW9X0PLK/Key_Art_02_layeredjpg.jpg?format=1500w',6.64286),('Minecraft','Blocos e etc..','https://upload.wikimedia.org/wikipedia/pt/9/9c/Minecraft_capa.png',7.8),('Roblox','Tentou muito ser um novo mine','https://static.vecteezy.com/system/resources/previews/027/127/470/non_2x/roblox-logo-roblox-icon-transparent-free-png.png',0),('Subway Surfers','Vandalismo.','https://cdn-images.dzcdn.net/images/cover/a0a2784072361fda59c676ab5fd9794b/1900x1900-000000-80-0-0.jpg',0),('Super Mario Galaxy','Encanador no espaço. Yahoo!','https://upload.wikimedia.org/wikipedia/pt/b/b1/Super_Mario_Galaxy_capa.png',0),('teste','etstte','https://digest.med.br/wp-content/uploads/2024/07/no-image.jpg',0),('The Last Of Us','muito zumbi e muita coisa louca','https://upload.wikimedia.org/wikipedia/pt/b/be/The_Last_of_Us_capa.png',0),('Valorant','Tirinho e poderzinho','https://images.seeklogo.com/logo-png/37/1/valorant-logo-png_seeklogo-379976.png',0);
/*!40000 ALTER TABLE `jogos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_jogo`
--

DROP TABLE IF EXISTS `lista_jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lista_jogo` (
  `FK_id_lista` int NOT NULL,
  `FK_jogo_nome` varchar(255) NOT NULL,
  PRIMARY KEY (`FK_id_lista`,`FK_jogo_nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_jogo`
--

LOCK TABLES `lista_jogo` WRITE;
/*!40000 ALTER TABLE `lista_jogo` DISABLE KEYS */;
INSERT INTO `lista_jogo` VALUES (4,'Hollow Knight'),(11,'Hollow Knight'),(11,'Minecraft'),(12,'Hollow Knight'),(12,'Minecraft'),(13,'Minecraft'),(13,'Super Mario Galaxy');
/*!40000 ALTER TABLE `lista_jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listas`
--

DROP TABLE IF EXISTS `listas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nome` varchar(255) NOT NULL,
  `FK_usuario_username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listas`
--

LOCK TABLES `listas` WRITE;
/*!40000 ALTER TABLE `listas` DISABLE KEYS */;
INSERT INTO `listas` VALUES (11,'Lista teste!','a'),(12,'Lista teste 2 :O','a'),(13,'lista do adm','adm');
/*!40000 ALTER TABLE `listas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `Nome` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Senha` varchar(255) NOT NULL,
  PRIMARY KEY (`Username`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('a','a','a','a'),('adm','adm','adm','adm'),('Eduardo','eemestre','email','123'),('Victor Ehiti','japo','japones@japão.com','xingling'),('Julia Beiroco','jubeiroco','julia@gmail.com','julia'),('Lucas Pelegrina','luknhaWin_xx','pelegra@gmail.com','borabill'),('Vitor Menck','menck','vitor@menck.com','menck'),('teste','teste','teste','teste'),('Bruno Navarro','xX_BruninGamer69_Xx','bruningamer69@unect.com.br','borabill69');
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

-- Dump completed on 2025-02-07 16:27:38
