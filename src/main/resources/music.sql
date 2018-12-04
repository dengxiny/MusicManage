/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.20 : Database - music
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`music` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `music`;

/*Table structure for table `music` */

DROP TABLE IF EXISTS `music`;

CREATE TABLE `music` (
  `song_id` varchar(500) DEFAULT NULL,
  `song_name` varchar(500) DEFAULT NULL,
  `song_extra` varchar(500) DEFAULT NULL,
  `playlist_id` varchar(500) DEFAULT NULL,
  `playlist_name` varchar(500) DEFAULT NULL,
  `playlist_extra` varchar(500) DEFAULT NULL,
  `singer_name` varchar(500) DEFAULT NULL,
  `singer_extra` varchar(500) DEFAULT NULL,
  `album_name` varchar(500) DEFAULT NULL,
  `origin` varchar(500) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `quality` varchar(500) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
