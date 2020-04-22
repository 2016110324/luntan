/*
 Navicat Premium Data Transfer

 Source Server         : liuyuping
 Source Server Type    : MySQL
 Source Server Version : 50626
 Source Host           : localhost:3306
 Source Schema         : experiment

 Target Server Type    : MySQL
 Target Server Version : 50626
 File Encoding         : 65001

 Date: 13/06/2019 11:26:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userid` int(255) NOT NULL AUTO_INCREMENT,
  `userimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userpwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `useremail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'head1.png', '123', '123', '1221@qq.com', '13618157038');
INSERT INTO `user` VALUES (2, 'head2.png', '112', '123', '123@qq.com', '13345678901');
INSERT INTO `user` VALUES (3, 'head3.png', 'test', '1123', '2908218@qq.com', '17761242389');
INSERT INTO `user` VALUES (4, 'head4.png', 'qwe', '1234', '123@qq.com', '13456789021');
INSERT INTO `user` VALUES (5, 'head5.png', 'efw', 'qwe', 'sdfsf@qq.com', '13245678901');
INSERT INTO `user` VALUES (6, 'head4.png', 'fjvsjv', 'dfsdd3244', '28947826@qq.com', '13572738572');
INSERT INTO `user` VALUES (7, 'head1.png', 'weuwidmnc', '32244353551', '38946hdsf47@xs.com', '17728463274');
INSERT INTO `user` VALUES (8, 'head3.png', 'd_3jewgh', '447yfh84g', '1276478@ssd.com', '13698324899');
INSERT INTO `user` VALUES (12, NULL, 'lp', '123456', '1252636452@qq.com', '13618157740');

SET FOREIGN_KEY_CHECKS = 1;
