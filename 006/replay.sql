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

 Date: 13/06/2019 11:26:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for replay
-- ----------------------------
DROP TABLE IF EXISTS `replay`;
CREATE TABLE `replay`  (
  `replayid` int(255) NOT NULL AUTO_INCREMENT,
  `userid` int(255) NOT NULL,
  `postid` int(255) NOT NULL,
  `replaytitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `replaycontent` varchar(21000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `replaytime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`replayid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of replay
-- ----------------------------
INSERT INTO `replay` VALUES (1, 1, 1, '为何学习it', '对于当前的学生来说，不论是否是计算机相关专业，选择学习IT技术都能够在一定程度上提升自身的岗位竞争力，因为目前广大传统领域的网络化和信息化已经越来越完善了。随着大数据逐渐落地到传统行业，未来众多工作岗位都需要具备一定的数据处理（分析）能力，这是一个比较明显的发展趋势。', '2017-05-12 23:31:33');
INSERT INTO `replay` VALUES (2, 2, 1, 'J职场人学习it原因', '对于当前的职场人来说，通过学习IT技术来完成岗位升级是一个重要的途径。目前互联网企业已经逐渐完成了数据驱动运营的改造，逐渐向智能化运营方向发展，目的是从快速的迭代中逐渐解放出来。而对于传统企业来说，数据驱动式改造才刚刚开始，通过数据来驱动产品的设计、生产、推广和服务将是未来大数据落地应用的重要方式，所以未来职场人掌握IT技术将是产业结构升级的必然要求，通过学习IT技术也能够为自己赢来更多的发展机会。', '2018-02-13 09:45:03');
INSERT INTO `replay` VALUES (3, 3, 2, 'it转行', '女孩子确实感觉不太适合，我打算转行，可是没有接触过别的行业，认识的人也少，所以不知道换什么，这个就是最大问题！', '2018-03-07 10:35:29');
INSERT INTO `replay` VALUES (4, 4, 3, 'it投资', '云服务、机器人过程自动化(RPA)和认知技术(如人工智能和机器学习)可以提高性能并促进运营，而成本只是传统技术和人工的一小部分。人工智能机器学习正迅速成为当今首席信息官的重要投资项目，这一点也不奇怪', '2019-01-25 16:27:56');
INSERT INTO `replay` VALUES (5, 5, 4, 'python', 'Python作为一种十分简单但功能又很强大的编程语言，自由度高开放性好，易于扩展，且具有跨平台优势，面向对象和函数式编程模式兼具，无数的开源库可以供调用，标准库规模十分庞大。正因为Python拥有这些强大功能，在全国各个地区的职位需求量也是很大，Python的前景可以说是一片光明。', '2018-06-23 13:24:46');
INSERT INTO `replay` VALUES (6, 12, 2, '女生做it好吗', '：程序员的工作特点大家都知道：大多数都要加班，有的公司也会出差，工作压力也较大。女生晋升空间也小，至少在我所在的公司还没有从程序员做上去的女领导。女生后面成家后面临生孩子等问题也是阻碍职业发展的因素。所以，从长远考虑来说，你真的准备好了吗？', '2019-05-27 23:59:06');

SET FOREIGN_KEY_CHECKS = 1;
