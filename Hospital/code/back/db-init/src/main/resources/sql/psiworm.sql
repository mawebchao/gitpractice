/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 10.6.4-MariaDB : Database - psiworm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE  IF NOT EXISTS `psiworm` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;

USE `psiworm`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb3 NOT NULL,
  `level` tinyint(4) NOT NULL,
  `parent_id` int(11) NOT NULL DEFAULT -1,
  `route` varchar(20) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `category` */

insert  into `category`(`id`,`name`,`level`,`parent_id`,`route`) values 
(1,'挂号管理',0,-1,''),
(2,'挂号信息',1,1,'/registers'),
(6,'叫号管理',0,-1,''),
(7,'病人档案',0,0,'/patient/list'),
(8,'叫号信息',1,6,'/calls/outpatient'),
(9,'权限管理',0,0,'/permission');

/*Table structure for table `operation` */

DROP TABLE IF EXISTS `operation`;

CREATE TABLE `operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operations` varchar(150) NOT NULL,
  `roleId` int(11) NOT NULL,
  `catId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

/*Data for the table `operation` */

insert  into `operation`(`id`,`operations`,`roleId`,`catId`) values 
(4,'[submit,delete,save]',8,2);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb3 NOT NULL,
  `category_ids` varchar(100) CHARACTER SET utf8mb3 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`category_ids`) values 
(8,'系统管理员','[1,2,3,4,5,6,7,8,9]'),
(9,'前台护士','[1,2,7]'),
(10,'科室医生','[6,7,8]');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb3 NOT NULL,
  `password` varchar(200) NOT NULL,
  `role_ids` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`role_ids`) values 
(2,'admin','$2a$10$R.ZXvgB3YY3qLRMooBXS0uI2tP2chvKHxwHgbrkt3fwbHvTwG5iDq',''),
(4,'mawebchao','$2a$10$R.ZXvgB3YY3qLRMooBXS0uI2tP2chvKHxwHgbrkt3fwbHvTwG5iDq','[8]'),
(5,'zhs','$2a$10$R.ZXvgB3YY3qLRMooBXS0uI2tP2chvKHxwHgbrkt3fwbHvTwG5iDq','[9]'),
(6,'lhs','$2a$10$R.ZXvgB3YY3qLRMooBXS0uI2tP2chvKHxwHgbrkt3fwbHvTwG5iDq','[9]'),
(7,'mhs','$2a$10$R.ZXvgB3YY3qLRMooBXS0uI2tP2chvKHxwHgbrkt3fwbHvTwG5iDq','[9]'),
(8,'zys','$2a$10$R.ZXvgB3YY3qLRMooBXS0uI2tP2chvKHxwHgbrkt3fwbHvTwG5iDq','[10]'),
(9,'bys','$2a$10$R.ZXvgB3YY3qLRMooBXS0uI2tP2chvKHxwHgbrkt3fwbHvTwG5iDq','[10]'),
(10,'jys','$2a$10$R.ZXvgB3YY3qLRMooBXS0uI2tP2chvKHxwHgbrkt3fwbHvTwG5iDq','[10]');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
