CREATE TABLE `user` (
  `uid` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `loginId` varchar(20) NOT NULL DEFAULT '' COMMENT '登录ID',
  `uname` varchar(16) NOT NULL DEFAULT '' COMMENT '用户姓名',
  `password` varchar(16) NOT NULL DEFAULT '' COMMENT 'password',
  `email` varchar(20) DEFAULT '' COMMENT 'email',
  `phone` varchar(20) DEFAULT '' COMMENT 'phone',
  `valid` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1有效 0无效',
  `gmt_create` date DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `loginId` (`loginId`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8;

INSERT INTO `user` (`uid`, `loginId`, `uname`, `password`, `email`, `phone`, `valid`, `gmt_create`, `gmt_modified`)
VALUES
  (1001, 'admin', '管理员', '7A57A5A743894A0E', 'admin@demo.com', '+81 13877665544', 1, '2019-07-26', '2019-07-26');
