CREATE TABLE `templates` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qsosappfamily` varchar(50) NOT NULL COMMENT 'Template''s domain name',
  `qsosspecificformat` varchar(5) NOT NULL COMMENT 'Template''s version',
  `language` varchar(5) NOT NULL,
  `filename` varchar(100) NOT NULL,
  `creation` varchar(15) DEFAULT NULL,
  `updatedate` varchar(15) DEFAULT NULL,
  `uploader` varchar(50) DEFAULT NULL,
  `repo` varchar(20) NOT NULL,
  `filecontent` longblob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
