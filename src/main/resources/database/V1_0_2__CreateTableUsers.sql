CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `pass_md5` text NOT NULL,
  `mail` varchar(50) NOT NULL,
  `contributions` int(11) NOT NULL,
  `status` varchar(50) DEFAULT 'users',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
