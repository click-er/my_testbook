/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.23 : Database - testbook
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`testbook` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `testbook`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `adminID` varchar(255) NOT NULL DEFAULT 'null',
  `password` varchar(255) NOT NULL DEFAULT 'null',
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`adminID`,`password`) values 
('admin','123456');

/*Table structure for table `note` */

DROP TABLE IF EXISTS `note`;

CREATE TABLE `note` (
  `useID` varchar(255) NOT NULL DEFAULT 'null',
  `nickname` varchar(255) NOT NULL DEFAULT 'null',
  `title` varchar(255) NOT NULL DEFAULT 'null',
  `content` mediumtext,
  `isPrivate` int NOT NULL DEFAULT '0' COMMENT '0为非公开，1为公开',
  `ok` varchar(255) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `note` */

insert  into `note`(`useID`,`nickname`,`title`,`content`,`isPrivate`,`ok`) values 
('click','xing','我的第一篇笔记','今天是一个晴朗的日子，很高兴见到大家。',1,'0'),
('click2','niu','懒','我在变积极！',1,'0'),
('jiong','hong','懒2','我很懒什么也没有留下',1,'0');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userID` varchar(255) NOT NULL DEFAULT 'null',
  `password` varchar(255) NOT NULL DEFAULT 'null',
  `userNickname` varchar(255) NOT NULL DEFAULT 'null',
  `userSex` int DEFAULT '0' COMMENT '默认为0（男），1为女',
  `userIntroduction` varchar(255) DEFAULT 'null',
  `isBlack` int DEFAULT '0' COMMENT '0为非黑名单',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userID`,`password`,`userNickname`,`userSex`,`userIntroduction`,`isBlack`) values 
('click','123456','xing',1,'null',0),
('click2','123456','haha',1,'这个人很懒，什么也没有留下。',0),
('jiong','123456','hong',0,'大家好，我是小红！',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
