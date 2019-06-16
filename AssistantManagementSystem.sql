CREATE DATABASE  IF NOT EXISTS `assistadmin` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `assistadmin`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: assistadmin
-- ------------------------------------------------------
-- Server version	5.5.62

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
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrator` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(20) NOT NULL,
  `admin_password` varchar(20) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (1,'小明','123'),(2,'小李','123'),(3,'小红','123'),(4,'小林','123');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applicationform`
--

DROP TABLE IF EXISTS `applicationform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applicationform` (
  `application_id` int(11) NOT NULL,
  `employ_txt` varchar(20) NOT NULL,
  `employ_time` varchar(20) NOT NULL,
  PRIMARY KEY (`application_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicationform`
--

LOCK TABLES `applicationform` WRITE;
/*!40000 ALTER TABLE `applicationform` DISABLE KEYS */;
INSERT INTO `applicationform` VALUES (100,'助教','周一上午'),(101,'助教','周二上午'),(102,'助教','周三上午'),(104,'助教','周四上午');
/*!40000 ALTER TABLE `applicationform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arrangeexperiment`
--

DROP TABLE IF EXISTS `arrangeexperiment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arrangeexperiment` (
  `t_id` int(11) NOT NULL,
  `e_id` int(11) NOT NULL,
  `ae_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`t_id`,`e_id`),
  KEY `e_id` (`e_id`),
  CONSTRAINT `arrangeexperiment_ibfk_1` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`),
  CONSTRAINT `arrangeexperiment_ibfk_2` FOREIGN KEY (`e_id`) REFERENCES `experiment` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arrangeexperiment`
--

LOCK TABLES `arrangeexperiment` WRITE;
/*!40000 ALTER TABLE `arrangeexperiment` DISABLE KEYS */;
INSERT INTO `arrangeexperiment` VALUES (1,1,NULL),(3,3,NULL),(4,4,NULL);
/*!40000 ALTER TABLE `arrangeexperiment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arrangetask`
--

DROP TABLE IF EXISTS `arrangetask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arrangetask` (
  `t_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  `arrange_time` varchar(20) NOT NULL,
  PRIMARY KEY (`t_id`,`task_id`),
  KEY `task_id_idx` (`task_id`),
  CONSTRAINT `t_id3` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`),
  CONSTRAINT `task_id` FOREIGN KEY (`task_id`) REFERENCES `task` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arrangetask`
--

LOCK TABLES `arrangetask` WRITE;
/*!40000 ALTER TABLE `arrangetask` DISABLE KEYS */;
INSERT INTO `arrangetask` VALUES (1,1,'周一下午'),(3,3,'周二下午'),(4,4,'周二上午');
/*!40000 ALTER TABLE `arrangetask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assistant`
--

DROP TABLE IF EXISTS `assistant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assistant` (
  `assist_id` int(11) NOT NULL,
  `assist_name` varchar(20) DEFAULT NULL,
  `assist_password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`assist_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assistant`
--

LOCK TABLES `assistant` WRITE;
/*!40000 ALTER TABLE `assistant` DISABLE KEYS */;
INSERT INTO `assistant` VALUES (1601,'田长青','123'),(1602,'徐紫嫣','123'),(1603,'黄洋达','123'),(1604,'张歆艺','123');
/*!40000 ALTER TABLE `assistant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendclasses`
--

DROP TABLE IF EXISTS `attendclasses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendclasses` (
  `s_id` int(11) NOT NULL,
  `c_id` int(11) NOT NULL,
  `place` varchar(20) NOT NULL,
  PRIMARY KEY (`s_id`,`c_id`),
  KEY `c_id_idx` (`c_id`),
  KEY `c_id_1_idx` (`c_id`),
  CONSTRAINT `c_id_1` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`),
  CONSTRAINT `s_id` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendclasses`
--

LOCK TABLES `attendclasses` WRITE;
/*!40000 ALTER TABLE `attendclasses` DISABLE KEYS */;
INSERT INTO `attendclasses` VALUES (16202101,1,'D101'),(16202102,1,'D101'),(16202103,1,'D101'),(16202104,1,'D101'),(16202105,1,'D101'),(16202106,1,'D101'),(16202107,1,'D101'),(16202108,1,'D101'),(16202109,1,'D101'),(16202110,1,'D101'),(16202111,1,'D101'),(16202112,1,'D101'),(16202113,1,'D101'),(16202114,1,'D101'),(16202115,1,'D101'),(16202116,1,'D101'),(16202117,1,'D101'),(16202118,1,'D101'),(16202119,1,'D101'),(16202120,1,'D101'),(16202121,1,'D101'),(16202122,1,'D101'),(16202123,1,'D101'),(16202124,1,'D101'),(16202125,1,'D101'),(16202126,1,'D101'),(16202127,1,'D101'),(16202128,1,'D101'),(16202129,1,'D101'),(16202130,1,'D101'),(16202131,1,'D101'),(16202132,1,'D101'),(16202133,1,'D101');
/*!40000 ALTER TABLE `attendclasses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendexperiment`
--

DROP TABLE IF EXISTS `attendexperiment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendexperiment` (
  `s_id` int(11) NOT NULL,
  `e_id` int(11) NOT NULL,
  `ae_grade` double DEFAULT NULL,
  `ae_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`s_id`,`e_id`),
  KEY `e_id` (`e_id`),
  CONSTRAINT `attendexperiment_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`),
  CONSTRAINT `attendexperiment_ibfk_2` FOREIGN KEY (`e_id`) REFERENCES `experiment` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendexperiment`
--

LOCK TABLES `attendexperiment` WRITE;
/*!40000 ALTER TABLE `attendexperiment` DISABLE KEYS */;
INSERT INTO `attendexperiment` VALUES (16202101,1,NULL,NULL),(16202101,2,NULL,NULL),(16202101,3,NULL,NULL),(16202101,4,NULL,NULL),(16202101,5,NULL,NULL),(16202101,6,NULL,NULL),(16202101,7,NULL,NULL),(16202101,8,NULL,NULL),(16202101,9,NULL,NULL),(16202101,10,NULL,NULL),(16202101,11,NULL,NULL),(16202101,12,NULL,NULL),(16202101,13,NULL,NULL),(16202101,14,NULL,NULL),(16202101,15,NULL,NULL),(16202101,16,NULL,NULL),(16202102,1,NULL,NULL),(16202102,2,NULL,NULL),(16202102,3,NULL,NULL),(16202102,4,NULL,NULL),(16202102,5,NULL,NULL),(16202102,6,NULL,NULL),(16202102,7,NULL,NULL),(16202102,8,NULL,NULL),(16202102,9,NULL,NULL),(16202102,10,NULL,NULL),(16202102,11,NULL,NULL),(16202102,12,NULL,NULL),(16202102,13,NULL,NULL),(16202102,14,NULL,NULL),(16202102,15,NULL,NULL),(16202102,16,NULL,NULL),(16202103,1,NULL,NULL),(16202103,2,NULL,NULL),(16202103,3,NULL,NULL),(16202103,4,NULL,NULL),(16202103,5,NULL,NULL),(16202103,6,NULL,NULL),(16202103,7,NULL,NULL),(16202103,8,NULL,NULL),(16202103,9,NULL,NULL),(16202103,10,NULL,NULL),(16202103,11,NULL,NULL),(16202103,12,NULL,NULL),(16202103,13,NULL,NULL),(16202103,14,NULL,NULL),(16202103,15,NULL,NULL),(16202103,16,NULL,NULL),(16202104,1,NULL,NULL),(16202104,2,NULL,NULL),(16202104,3,NULL,NULL),(16202104,4,NULL,NULL),(16202104,5,NULL,NULL),(16202104,6,NULL,NULL),(16202104,7,NULL,NULL),(16202104,8,NULL,NULL),(16202104,9,NULL,NULL),(16202104,10,NULL,NULL),(16202104,11,NULL,NULL),(16202104,12,NULL,NULL),(16202104,13,NULL,NULL),(16202104,14,NULL,NULL),(16202104,15,NULL,NULL),(16202104,16,NULL,NULL),(16202105,1,NULL,NULL),(16202105,2,NULL,NULL),(16202105,3,NULL,NULL),(16202105,4,NULL,NULL),(16202105,5,NULL,NULL),(16202105,6,NULL,NULL),(16202105,7,NULL,NULL),(16202105,8,NULL,NULL),(16202105,9,NULL,NULL),(16202105,10,NULL,NULL),(16202105,11,NULL,NULL),(16202105,12,NULL,NULL),(16202105,13,NULL,NULL),(16202105,14,NULL,NULL),(16202105,15,NULL,NULL),(16202105,16,NULL,NULL);
/*!40000 ALTER TABLE `attendexperiment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `cls_id` int(11) NOT NULL AUTO_INCREMENT,
  `cls_name` varchar(20) DEFAULT NULL,
  `cls_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`cls_id`)
) ENGINE=InnoDB AUTO_INCREMENT=162032 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (162021,'162021班',30),(162022,'162022班',30),(162031,'162031班',30);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'web高级编程'),(2,'oracle大型数据库'),(3,'软件项目管理'),(4,'java网络编程'),(5,'软件设计建模'),(6,'专业英语'),(7,'就业指导'),(8,'数据结构'),(9,'操作系统'),(10,'计算机组成原理'),(11,'计算机网络'),(12,'安卓开发'),(13,'web技术基础'),(14,'sqlserver数据库'),(15,'软件工程'),(16,'软件测试'),(17,'高等数学'),(18,'线性代数'),(19,'概率论与数理统计'),(20,'大学英语'),(21,'大学物理'),(22,'大学体育'),(23,'java技术基础');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dotask`
--

DROP TABLE IF EXISTS `dotask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dotask` (
  `s_id` int(11) NOT NULL,
  `t_id` int(11) NOT NULL,
  `t_grade` double DEFAULT NULL,
  PRIMARY KEY (`s_id`,`t_id`),
  KEY `t_id` (`t_id`),
  CONSTRAINT `dotask_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`),
  CONSTRAINT `dotask_ibfk_2` FOREIGN KEY (`t_id`) REFERENCES `task` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dotask`
--

LOCK TABLES `dotask` WRITE;
/*!40000 ALTER TABLE `dotask` DISABLE KEYS */;
INSERT INTO `dotask` VALUES (16202101,1,NULL),(16202102,2,NULL),(16202103,3,NULL),(16202104,4,NULL);
/*!40000 ALTER TABLE `dotask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experiment`
--

DROP TABLE IF EXISTS `experiment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experiment` (
  `e_id` int(11) NOT NULL AUTO_INCREMENT,
  `e_name` varchar(20) NOT NULL,
  `e_content` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiment`
--

LOCK TABLES `experiment` WRITE;
/*!40000 ALTER TABLE `experiment` DISABLE KEYS */;
INSERT INTO `experiment` VALUES (1,'构建一个spring工程','学习了解spring的相关知识'),(2,'使用Maven和Gradle创建工程','学习使用Maven和Gradle创建sp'),(3,'使用Ajax程序设计','学会使用Ajax进行设计功能'),(4,'分析用例及画用例图','学习怎么分析一个需求中的用例'),(5,'画活动图及类图','学习怎么分纤箱一个活动的过程'),(6,'画时序图和协作图','学习怎么画一个用例涉及到的时序图并转化为'),(7,'TCP程序设计','学习使用TCP进行网络编程'),(8,'UDP程序设计','学习使用UDP进行网络编程'),(9,'TCPUDP综合应用','学习综合网络编程'),(10,'java网络安全编程','学习网络加密解密技术'),(11,'javaFX程序设计','学习Java中的可视化界面技术'),(12,'IO网络程序设计','学习IO操作技术'),(13,'多线程网络编程','学习多线程在Java中的应用'),(14,'oracle对象管理','学习oracle的对象管理'),(15,'oracle工具使用','学习使用oracle的可视化界面工具'),(16,'oracle变控件管理','学习使用oracle创建数据库并进行管理');
/*!40000 ALTER TABLE `experiment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `markexperimentreport`
--

DROP TABLE IF EXISTS `markexperimentreport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `markexperimentreport` (
  `assist_id` int(11) NOT NULL,
  `e_id` int(11) NOT NULL,
  `s_id` int(11) NOT NULL,
  `mer_time` varchar(20) DEFAULT NULL,
  `mer_grade` double DEFAULT NULL,
  `comment` varchar(50) NOT NULL,
  PRIMARY KEY (`assist_id`,`e_id`,`s_id`),
  KEY `e_id` (`e_id`),
  KEY `s_id` (`s_id`),
  CONSTRAINT `markexperimentreport_ibfk_1` FOREIGN KEY (`assist_id`) REFERENCES `assistant` (`assist_id`),
  CONSTRAINT `markexperimentreport_ibfk_2` FOREIGN KEY (`e_id`) REFERENCES `experiment` (`e_id`),
  CONSTRAINT `markexperimentreport_ibfk_3` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `markexperimentreport`
--

LOCK TABLES `markexperimentreport` WRITE;
/*!40000 ALTER TABLE `markexperimentreport` DISABLE KEYS */;
INSERT INTO `markexperimentreport` VALUES (1601,1,16202101,NULL,NULL,'理解Spring框架的工作原理'),(1602,2,16202102,NULL,NULL,'理解Spring 框架中组件的基本配置方法'),(1603,3,16202103,NULL,NULL,'掌握Spring框架中mvc模块的使用方法'),(1604,4,16202104,NULL,NULL,'掌握Spring框架中aop模块的使用方法');
/*!40000 ALTER TABLE `markexperimentreport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marktask`
--

DROP TABLE IF EXISTS `marktask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marktask` (
  `assist_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  `s_id` int(11) NOT NULL,
  `mark_time` varchar(20) NOT NULL,
  `task_grade` double NOT NULL,
  `comment` varchar(50) NOT NULL,
  PRIMARY KEY (`assist_id`,`task_id`,`s_id`),
  KEY `s_id_idx` (`s_id`),
  KEY `st_id_idx` (`s_id`),
  KEY `t_id_idx` (`task_id`),
  CONSTRAINT `assis_id` FOREIGN KEY (`assist_id`) REFERENCES `assistant` (`assist_id`),
  CONSTRAINT `s_id2` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`),
  CONSTRAINT `t_id2` FOREIGN KEY (`task_id`) REFERENCES `task` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marktask`
--

LOCK TABLES `marktask` WRITE;
/*!40000 ALTER TABLE `marktask` DISABLE KEYS */;
INSERT INTO `marktask` VALUES (1601,1,16202101,'周一上午',80,'理解Spring框架的工作原理'),(1602,2,16202102,'周二上午',80,'理解Spring 框架中组件的基本配置方法'),(1603,3,16202103,'周三上午',80,'掌握Spring框架中mvc模块的使用方法'),(1604,4,16202104,'周四上午',80,'掌握Spring框架中aop模块的使用方法');
/*!40000 ALTER TABLE `marktask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `openexperiment`
--

DROP TABLE IF EXISTS `openexperiment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `openexperiment` (
  `c_id` int(11) NOT NULL,
  `e_id` int(11) NOT NULL,
  `oe_time` varchar(20) DEFAULT NULL,
  `oe_address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`c_id`,`e_id`),
  KEY `e_id` (`e_id`),
  CONSTRAINT `openexperiment_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`),
  CONSTRAINT `openexperiment_ibfk_2` FOREIGN KEY (`e_id`) REFERENCES `experiment` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `openexperiment`
--

LOCK TABLES `openexperiment` WRITE;
/*!40000 ALTER TABLE `openexperiment` DISABLE KEYS */;
INSERT INTO `openexperiment` VALUES (1,1,'周二下午','d306'),(1,2,'周一下午','e303'),(1,3,'周二上午','e301'),(2,14,'周一下午','d501'),(2,15,'周六上午','d502'),(2,16,'周一下午','d303'),(4,7,'周二下午','d309'),(4,8,'周一下午','d309'),(4,9,'周四晚上','d309'),(4,10,'周五下午','d310'),(4,12,'周三上午','d401'),(4,13,'周四晚上','d402'),(5,4,'周六上午','g404'),(5,5,'周日下午','d306'),(5,6,'周四上午','d301'),(23,11,'周日上午','d301');
/*!40000 ALTER TABLE `openexperiment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ownassistant`
--

DROP TABLE IF EXISTS `ownassistant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ownassistant` (
  `t_id` int(11) NOT NULL,
  `assist_id` int(11) NOT NULL,
  `assist_grade` double NOT NULL,
  `comment` varchar(50) NOT NULL,
  PRIMARY KEY (`t_id`,`assist_id`),
  KEY `assist_id_idx` (`assist_id`),
  CONSTRAINT `assist_id` FOREIGN KEY (`assist_id`) REFERENCES `assistant` (`assist_id`),
  CONSTRAINT `t_id1` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ownassistant`
--

LOCK TABLES `ownassistant` WRITE;
/*!40000 ALTER TABLE `ownassistant` DISABLE KEYS */;
INSERT INTO `ownassistant` VALUES (1,1601,80,'理解Spring框架的工作原理'),(3,1603,80,'掌握Spring框架中mvc模块的使用方法'),(4,1604,80,'掌握Spring框架中aop模块的使用方法');
/*!40000 ALTER TABLE `ownassistant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publishapplication`
--

DROP TABLE IF EXISTS `publishapplication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publishapplication` (
  `t_id` int(11) NOT NULL,
  `application_id` int(11) NOT NULL,
  `c_id` int(11) NOT NULL,
  `publish_time` varchar(20) NOT NULL,
  `request` varchar(20) NOT NULL,
  PRIMARY KEY (`t_id`,`application_id`),
  KEY `employ_id_idx` (`application_id`),
  CONSTRAINT `employ_id1` FOREIGN KEY (`application_id`) REFERENCES `applicationform` (`application_id`),
  CONSTRAINT `t_id` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publishapplication`
--

LOCK TABLES `publishapplication` WRITE;
/*!40000 ALTER TABLE `publishapplication` DISABLE KEYS */;
INSERT INTO `publishapplication` VALUES (1,100,1,'周一上午','完成'),(3,102,3,'周三上午','完成'),(4,104,4,'周四上午','完成');
/*!40000 ALTER TABLE `publishapplication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviewform`
--

DROP TABLE IF EXISTS `reviewform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviewform` (
  `admin_id` int(11) NOT NULL,
  `application_id` int(11) NOT NULL,
  `result` varchar(20) NOT NULL,
  `review_time` varchar(20) NOT NULL,
  PRIMARY KEY (`admin_id`,`application_id`),
  KEY `employ_id_idx` (`application_id`),
  CONSTRAINT `admin_id` FOREIGN KEY (`admin_id`) REFERENCES `administrator` (`admin_id`),
  CONSTRAINT `employ_id` FOREIGN KEY (`application_id`) REFERENCES `applicationform` (`application_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviewform`
--

LOCK TABLES `reviewform` WRITE;
/*!40000 ALTER TABLE `reviewform` DISABLE KEYS */;
INSERT INTO `reviewform` VALUES (1,100,'完成','周一上午'),(2,101,'完成','周二上午');
/*!40000 ALTER TABLE `reviewform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(20) NOT NULL,
  `cls_id` int(11) NOT NULL,
  `s_password` varchar(20) NOT NULL,
  PRIMARY KEY (`s_id`),
  KEY `cls_id` (`cls_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`cls_id`) REFERENCES `class` (`cls_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16202214 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (16202101,'方雅婷',162021,'123'),(16202102,'朱海宇',162021,'123'),(16202103,'王坤',162021,'123'),(16202104,'范昊阳',162021,'123'),(16202105,'王文光',162021,'123'),(16202106,'周国帅',162021,'123'),(16202107,'蔡艳平',162021,'123'),(16202108,'陈旺',162021,'123'),(16202109,'陈家瑞',162021,'123'),(16202110,'郭凯',162021,'123'),(16202111,'付思翔',162021,'123'),(16202112,'黄路峰',162021,'123'),(16202113,'崔琦',162021,'123'),(16202114,'雷嘉威',162021,'123'),(16202115,'李杰',162021,'123'),(16202116,'刘天资',162021,'123'),(16202117,'梁昌宇',162021,'123'),(16202118,'齐汉卿',162021,'123'),(16202119,'孙李',162021,'123'),(16202120,'万文海',162021,'123'),(16202121,'刘州',162021,'123'),(16202122,'王红旗',162021,'123'),(16202123,'吴俊雄',162021,'123'),(16202124,'谢志波',162021,'123'),(16202125,'杨磊刚',162021,'123'),(16202126,'余超',162021,'123'),(16202127,'张竞',162021,'123'),(16202128,'周魁',162021,'123'),(16202129,'曾鹤翔',162021,'123'),(16202130,'韩晓健',162021,'123'),(16202131,'朱天翔',162021,'123'),(16202132,'周张俊',162021,'123'),(16202133,'汪浩',162021,'123'),(16202201,'甲',162022,'123'),(16202202,'乙',162022,'123'),(16202203,'丙',162022,'123'),(16202204,'丁',162022,'123'),(16202205,'戊',162022,'123'),(16202206,'己',162022,'123'),(16202207,'小明',162022,'123'),(16202208,'小军',162022,'123'),(16202209,'小飞',162022,'123'),(16202210,'小李',162022,'123'),(16202211,'小丽',162022,'123'),(16202212,'小哥哥',162022,'123'),(16202213,'小姐姐',162022,'123');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(20) DEFAULT NULL,
  `t_content` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'用java实现雨刷程序','通过使用java来实现模拟汽车雨刷器的动'),(2,'模拟银行用例图','分析银行ATM机并分析用例且画出用例图'),(3,'ooracle项目子作业','对教务系统进行需求分析并设计ER图'),(4,'策划一个项目','对于各小组拿到的题目写一份项目策划书'),(5,'security程序设计','通过加密解密设计一个网络程序'),(6,'采用MVC模式进行程序设计','基于web的MVC开发模式设计一个个人主');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachclasses`
--

DROP TABLE IF EXISTS `teachclasses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachclasses` (
  `t_id` int(11) NOT NULL,
  `c_id` int(11) NOT NULL,
  `tc_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`t_id`,`c_id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `teachclasses_ibfk_1` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`),
  CONSTRAINT `teachclasses_ibfk_2` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachclasses`
--

LOCK TABLES `teachclasses` WRITE;
/*!40000 ALTER TABLE `teachclasses` DISABLE KEYS */;
INSERT INTO `teachclasses` VALUES (1,1,'周一上午'),(3,3,'周三上午'),(4,4,'周四上午');
/*!40000 ALTER TABLE `teachclasses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(20) NOT NULL,
  `t_password` varchar(20) NOT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'张恒峰','123'),(3,'段喜龙','123'),(4,'谭鹏柳','123'),(5,'蔡珂','123'),(6,'梁旗军','123'),(7,'郑巍','123'),(8,'刘忠民','123'),(9,'苏曦','123'),(10,'刘好斌','123'),(11,'张宇','123'),(12,'李永乐','123'),(13,'汤家凤','123');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `writeapplicationform`
--

DROP TABLE IF EXISTS `writeapplicationform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `writeapplicationform` (
  `s_id` int(11) NOT NULL,
  `application_id` int(11) NOT NULL,
  `application_time` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL,
  `comment` varchar(50) NOT NULL,
  PRIMARY KEY (`s_id`,`application_id`),
  KEY `application_id_idx` (`application_id`),
  CONSTRAINT `s_id1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `writeapplicationform`
--

LOCK TABLES `writeapplicationform` WRITE;
/*!40000 ALTER TABLE `writeapplicationform` DISABLE KEYS */;
INSERT INTO `writeapplicationform` VALUES (16202101,100,'周一上午','录取','完美'),(16202102,101,'周二上午','录取','完美'),(16202103,102,'周三上午','录取','完美');
/*!40000 ALTER TABLE `writeapplicationform` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-16  8:55:09
