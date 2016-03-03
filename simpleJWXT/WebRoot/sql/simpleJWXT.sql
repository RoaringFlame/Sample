CREATE DATABASE  IF NOT EXISTS `db_simplejwxt` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `db_simplejwxt`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_simplejwxt
-- ------------------------------------------------------
-- Server version	5.6.11

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `ano` int(6) NOT NULL COMMENT '管理员账号',
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`aid`),
  UNIQUE KEY `idadmin_UNIQUE` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,201501,'2015','陈恒'),(2,201502,'2015','黎欣');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `cno` int(11) DEFAULT NULL COMMENT '课程号',
  `tid` int(11) DEFAULT NULL COMMENT '授课老师id',
  `cname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '课程名',
  `cMark` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '课程学分',
  `chooseMax` int(3) DEFAULT NULL COMMENT '最大选课数',
  `chooseCurNum` int(3) DEFAULT NULL COMMENT '已选课人数',
  `cTime` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '授课时间',
  `roomid` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '教室',
  PRIMARY KEY (`cid`),
  UNIQUE KEY `cid_UNIQUE` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='课程信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,150001,1,'软件系统建模','4',20,1,'周一，周五','10407'),(2,150002,1,'算法设计与分析','4',15,1,'周二','10407'),(3,150003,1,'数据库实用技术','2',10,1,'周四','报告厅7'),(4,150004,1,'Java应用开发','5',50,1,'周二，周三，周四','10407'),(6,150005,1,'Java web开发','5',1,0,'周一、周二、周三','阶梯教室7');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `score` (
  `sid` int(11) NOT NULL COMMENT '学生id',
  `cid` int(11) NOT NULL COMMENT '课程id',
  `score` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分数',
  PRIMARY KEY (`sid`,`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='成绩表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` VALUES (3,2,'20'),(4,3,NULL),(69,1,'55'),(69,4,'100');
/*!40000 ALTER TABLE `score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `sno` int(11) NOT NULL COMMENT '学号',
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '姓名',
  `sex` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '性别',
  `department` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学院',
  `nativePlace` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '籍贯',
  `mark` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学分',
  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `image` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '头像存储地址',
  `tel` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电话号码',
  `maxCourse` int(3) DEFAULT NULL COMMENT '最大选课数',
  PRIMARY KEY (`sid`),
  UNIQUE KEY `sid_UNIQUE` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='学生信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (3,1560330072,'2015','李小琴','女','计算机学院','湖北省','0','eduonou@edu.com','','13627190104',4),(4,1560330073,'2015','李丹','男','计算机学院','湖北省','0','','','15997375372',4),(5,1560330074,'2015','罗颖','女','计算机学院','湖北省','0','','','13451182294',4),(6,1560330075,'2015','朱鸣菲','女','计算机学院','湖北省','0','','','18772676515',4),(8,1560330077,'2015','张梓悦','男','计算机学院','湖北省','0','','','18771823501',4),(9,1560330078,'2015','袁金铃','女','计算机学院','湖北省','0','','','18307179744',4),(11,1560330080,'2015','晏彪','男','计算机学院','湖北省','0','','','15392895977',4),(12,1560330081,'2015','陈明','女','计算机学院','湖北省','0','','','15926914386',4),(15,1560330084,'2015','周海文','女','计算机学院','湖北省','0','','','13997644390',4),(16,1560330085,'2015','黄莹','女','计算机学院','湖北省','0','sder@qq.com','','13100600824',4),(17,1560330086,'2015','李帆','男','计算机学院','湖北省','0','','','13197201372',4),(18,1560330087,'2015','景丹','女','计算机学院','山西省','0','','','15172531706',4),(19,1560330088,'2015','周紫荆','女','计算机学院','湖北省','0','','','15171413668',4),(20,1560330089,'2015','杨雪','女','计算机学院','湖北省','0','','','15872373939',4),(21,1560330090,'2015','陈莹','女','计算机学院','湖北省','0','','','15549468542',4),(22,1560330091,'2015','殷铭','女','计算机学院','湖北省','0','','','15172373773',4),(23,1560330092,'2015','崔毅','男','计算机学院','湖北省','0','','','18871041949',4),(24,1560330093,'2015','樊启贤','男','计算机学院','湖北省','0','','','17786049379',4),(25,1560330094,'2015','易莎','女','计算机学院','湖北省','0','','','15271644193',4),(26,1560330095,'2015','梁兴欣','女','计算机学院','湖北省','0','','','15927956837',4),(27,1560330096,'2015','胥靖怡','女','计算机学院','湖北省','0','','','18507265775',4),(28,1560330097,'2015','李倩','女','计算机学院','湖北省','0','','','15172504486',4),(29,1560330098,'2015','黄雅琪','女','计算机学院','湖北省','0','','','17707161655',4),(30,1560330099,'2015','肖亮亮','男','计算机学院','湖北省','0','','','13042848835',4),(31,1560330100,'2015','黄梦繁','女','计算机学院','湖北省','0','','','15897746887',4),(33,1560330102,'2015','王娟','女','计算机学院','湖北省','0','','','15172333618',4),(34,1560330103,'2015','张婷珠','女','计算机学院','湖北省','0','','','18872463374',4),(35,1560330104,'2015','华周杰','男','计算机学院','湖北省','0','','','18772450543',4),(36,1560330105,'2015','杨姝慧','女','计算机学院','湖北省','0','','','15827889492',4),(37,1560330106,'2015','陈若晴','女','计算机学院','湖北省','0','','','13469905138',4),(38,1560330107,'2015','许曼','女','计算机学院','湖北省','0','','','15171412205',4),(39,1560330108,'2015','吴怡','女','计算机学院','湖北省','0','','','15027087354',4),(40,1560330109,'2015','胡敏','女','计算机学院','湖北省','0','','','13072728226',4),(41,1560330110,'2015','张继书','男','计算机学院','湖北省','0','','','13972200216',4),(42,1560330111,'2015','徐佳慧','男','计算机学院','湖北省','0','','','15172147483',4),(43,1560330112,'2015','余明','女','计算机学院','湖北省','0','','','15172323540',4),(44,1560330113,'2015','杜涵','女','计算机学院','湖北省','0','','','13128851559',4),(45,1560330114,'2015','吴芳','女','计算机学院','湖北省','0','hhhhhhhh@126.com','','13972817740',4),(47,1560330116,'2015','兰梦婷','女','计算机学院','湖北省','0','','','15971134589',4),(48,1560330117,'2015','杜边茜','女','计算机学院','湖北省','0','','','18972638413',4),(50,1560330119,'2015','胡燕','女','计算机学院','湖北省','0','','','15172435523',4),(51,1560330120,'2015','朱凡','女','计算机学院','湖北省','0','','','18271677494',4),(52,1560330121,'2015','韦昕','女','计算机学院','湖北省','0','','','18071832952',4),(53,1560330122,'2015','吴明娇','女','计算机学院','湖北省','0','','','15972746326',4),(54,1560330123,'2015','宋奔程','男','计算机学院','湖北省','0','','','18871240710',4),(55,1560330124,'2015','马文','女','计算机学院','湖北省','0','','','15071504424',4),(56,1560330125,'2015','姜锋','女','计算机学院','湖北省','0','','','15971669311',4),(57,1560330126,'2015','陈文悦','女','计算机学院','湖北省','0','','','13647281488',4),(58,1560330127,'2015','刘琦琳','女','计算机学院','湖北省','0','','','13669000787',4),(60,1560330129,'2015','陈诗','女','计算机学院','湖北省','0','','','13197407969',4),(61,1560330130,'2015','张凯','男','计算机学院','湖北省','0','','','15572110122',4),(62,1560330131,'2015','张吉威','男','计算机学院','湖北省','0','','','15307123416',4),(64,1560330133,'2015','潘慧杰','女','计算机学院','湖北省','0','','','13477442117',4),(66,1560330135,'2015','李波','男','计算机学院','湖北省','0','','','13986663409',4),(69,1350350020,'2015','陈恒','男','计算机学院','湖北省','0','chenheng120@126.com',NULL,'13260592767',6);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `tid` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师id',
  `tno` int(8) NOT NULL COMMENT '教室工号',
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `rank` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '职称',
  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `tel` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`tid`),
  UNIQUE KEY `tid_UNIQUE` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='教师信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,20150001,'2015','胡',44,'博士','huyy@edu.cn','15071372539'),(3,20150002,'2015','张',33,'本科','zhangrrr@qq.com','13510352201'),(4,20150003,'2015','陈',28,'硕士','chen@qq.com','13560592786');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-27 21:23:08
