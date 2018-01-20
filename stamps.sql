/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50629
Source Host           : localhost:3306
Source Database       : stamp

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2018-01-20 17:09:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'crush', 'crush');
