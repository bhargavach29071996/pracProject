DROP SCHEMA IF EXISTS `rms_user_detail`;

CREATE SCHEMA `rms_user_detail`;

use `rms_user_detail`;

DROP TABLE IF EXISTS `user_detail`;

CREATE TABLE `user_detail` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(128) DEFAULT NULL,
  `last_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
