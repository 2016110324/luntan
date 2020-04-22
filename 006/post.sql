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

 Date: 13/06/2019 11:26:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `postid` int(255) NOT NULL AUTO_INCREMENT,
  `userid` int(255) DEFAULT NULL,
  `postinfotype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `posttitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `postcontent` varchar(21000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `postlastreplayname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `postlastrepalytime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `postreplaycount` int(255) DEFAULT NULL,
  PRIMARY KEY (`postid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, 1, 'it技术', '为何越来越多的人开始学习IT技术', '首先，IT行业的快速发展是导致其产业生态逐渐庞大的重要原因，尤其是互联网和移动互联网的发展，逐渐构建了一个庞大的消费互联网体系，岗位需求量也越来越大。随着IT产业生态的不断完善和发展，对于人才结构的需求也越来越丰富，可以说当前大量具备各种能力的人才都能够在IT行业内找到自己的位置，这也是IT行业从业人数越来越多的一个重要原因。', '一叶', '2019-05-20 10：10', 2);
INSERT INTO `post` VALUES (2, 2, '找工作', '女生做IT技术两年，裸辞两个月找不到工作，很迷茫，应该怎么办？', '作为女生，在职场上做IT技术这个岗位，一般能做多长时间？有朋友毕业两年，做了两年的IT技术岗位工作，裸辞之后找不到工作，于是感到迷茫了，网上求助说：25岁，女，毕业两年，之前做IT的，不过是初级的，技术含量不高，现在裸辞两个月，找工作找到绝望，前途一片迷茫，不知道接下来干什么，想稳定下来，求各位给点意见参考。', '之秋', '2019-05-18 06:26', 2);
INSERT INTO `post` VALUES (3, 3, 'it投资', '最新的IT投资趋势?削减成本的技术也同样在发生变革', '\r\n　企业正在投资数字解决方案，这些方案有助于节省基础设施和其他成本，同时使它们能够对业务进行变革。德勤(Deloitte)和Gartner的专家对此作出了解释。', '啦啦啦', '2分钟前', 1);
INSERT INTO `post` VALUES (4, 4, 'python', '必不可少的IT技术语言是什么？Python！', '说起Python，可能大家都听过——“人生苦短，我用Python”这句行业经典。调侃的同时，也点明了Python语言在当前人工智能环境下的火热，现在不学习Python就像井底之蛙不知道天有多大一样。学完之后还能干很多事，比如：web开发、应用开发、大数据、数据挖掘、科学计算、机器学习、人工智能、运维、自然语言处理等等。', 'efw', '8分钟前', 1);
INSERT INTO `post` VALUES (5, 12, 'av与it', 'ATEN宏正 AV与IT融合技术助力酒店业体验升级', '随着生活水平的提高，人们对精神方面的追求也越来越高。在此背景下，酒店的业态从单一的住宿休息到了集餐饮、会议、休闲度假于一身的服务综合体。技术上，ATEN宏正VS1814T支持的HDBaseT技术可通过一条Cat 6e线缆将丰富的多媒体内容从HDMI来源设备实时传送至HDMI显示设备。并支持高达4K分辨率及提供EDID选择模式确保HDMI来源端设备稳定可靠的EDID数据以有效优化视频分辨率。', '暂无信息', '', 0);

SET FOREIGN_KEY_CHECKS = 1;
