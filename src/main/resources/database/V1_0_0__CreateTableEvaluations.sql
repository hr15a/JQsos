CREATE TABLE `evaluations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qsosappfamily` varchar(50) NOT NULL COMMENT 'software family',
  `qsosspecificformat` varchar(5) NOT NULL,
  `qsosappname` varchar(50) NOT NULL DEFAULT 'noname' COMMENT 'Short application name',
  `releasenumber` varchar(15) NOT NULL DEFAULT '0',
  `appname` varchar(80) DEFAULT 'noname' COMMENT 'Long application name',
  `language` varchar(5) NOT NULL COMMENT 'Language on two characters',
  `filename` varchar(100) NOT NULL,
  `licensedesc` varchar(50) NOT NULL COMMENT 'License name',
  `creation` varchar(15) CHARACTER SET latin1 DEFAULT NULL,
  `validation` varchar(15) CHARACTER SET latin1 DEFAULT NULL,
  `sections` tinyint(4) DEFAULT NULL COMMENT 'Number of sections',
  `criteria` tinyint(4) DEFAULT NULL COMMENT 'Total number of criteria',
  `criteria_scorable` tinyint(4) DEFAULT NULL COMMENT 'Number of scorable criteria',
  `criteria_scored` tinyint(4) DEFAULT NULL COMMENT 'Number of criteria actually scored',
  `criteria_notscored` tinyint(4) DEFAULT NULL COMMENT 'Number of criteria not yet scored',
  `comments` tinyint(4) DEFAULT NULL COMMENT 'Number of criteria that could be commented',
  `criteria_commented` tinyint(4) DEFAULT NULL COMMENT 'Number of commented criteria',
  `criteria_notcommented` tinyint(4) DEFAULT NULL,
  `uploader` varchar(50) DEFAULT NULL,
  `repo` varchar(20) DEFAULT NULL,
  `filecontent` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;