CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `repository` varchar(45) NOT NULL,
  `horodatage` varchar(15) NOT NULL,
  `message` varchar(1024) NOT NULL,
  `domain` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
