CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `id` int NOT NULL AUTO_INCREMENT,
  `car_name` varchar(45) DEFAULT NULL,
  `car_model` varchar(45) DEFAULT NULL,
  `car_color` varchar(45) DEFAULT NULL,
  `car_imge` varchar(100) Default NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `car` VALUES 
	(1,'Bmw','2011','Red','/bmw.jpg'),
	(2,'Jeep','2015','black','/jeep.jpg'),
	(3,'kia','2017','white','kia.jpg'),
	(4,'Toyata','2020','slever','toyota.jpg'),
	(5,'MG','2022','yallow','mg.jpg');

