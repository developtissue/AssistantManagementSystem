/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : assistadmin

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 26/06/2019 18:42:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES (1, '小明', '123');
INSERT INTO `administrator` VALUES (2, '小李', '123');
INSERT INTO `administrator` VALUES (3, '小红', '123');
INSERT INTO `administrator` VALUES (4, '小林', '123');

-- ----------------------------
-- Table structure for applicationform
-- ----------------------------
DROP TABLE IF EXISTS `applicationform`;
CREATE TABLE `applicationform`  (
  `application_id` int(11) NOT NULL,
  `employ_txt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `employ_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`application_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of applicationform
-- ----------------------------
INSERT INTO `applicationform` VALUES (100, '助教', '周一上午');
INSERT INTO `applicationform` VALUES (101, '助教', '周二上午');
INSERT INTO `applicationform` VALUES (102, '助教', '周三上午');
INSERT INTO `applicationform` VALUES (104, '助教', '周四上午');

-- ----------------------------
-- Table structure for arrangeexperiment
-- ----------------------------
DROP TABLE IF EXISTS `arrangeexperiment`;
CREATE TABLE `arrangeexperiment`  (
  `t_id` int(11) NOT NULL,
  `e_id` int(11) NOT NULL,
  `ae_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`t_id`, `e_id`) USING BTREE,
  INDEX `e_id`(`e_id`) USING BTREE,
  CONSTRAINT `arrangeexperiment_ibfk_1` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `arrangeexperiment_ibfk_2` FOREIGN KEY (`e_id`) REFERENCES `experiment` (`e_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of arrangeexperiment
-- ----------------------------
INSERT INTO `arrangeexperiment` VALUES (1, 1, '周一上午');
INSERT INTO `arrangeexperiment` VALUES (3, 3, '周二上午');
INSERT INTO `arrangeexperiment` VALUES (4, 4, '周三上午');

-- ----------------------------
-- Table structure for arrangetask
-- ----------------------------
DROP TABLE IF EXISTS `arrangetask`;
CREATE TABLE `arrangetask`  (
  `t_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  `arrange_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`t_id`, `task_id`) USING BTREE,
  INDEX `task_id_idx`(`task_id`) USING BTREE,
  CONSTRAINT `t_id3` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `task_id` FOREIGN KEY (`task_id`) REFERENCES `task` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of arrangetask
-- ----------------------------
INSERT INTO `arrangetask` VALUES (1, 1, '周一下午');
INSERT INTO `arrangetask` VALUES (3, 3, '周二下午');
INSERT INTO `arrangetask` VALUES (4, 4, '周二上午');

-- ----------------------------
-- Table structure for assistant
-- ----------------------------
DROP TABLE IF EXISTS `assistant`;
CREATE TABLE `assistant`  (
  `assist_id` int(11) NOT NULL,
  `assist_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `assist_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`assist_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of assistant
-- ----------------------------
INSERT INTO `assistant` VALUES (1601, '方雅婷', '123');
INSERT INTO `assistant` VALUES (1602, '朱海宇', '123');
INSERT INTO `assistant` VALUES (1603, '王坤', '123');
INSERT INTO `assistant` VALUES (1604, '范昊阳', '123');

-- ----------------------------
-- Table structure for attendclasses
-- ----------------------------
DROP TABLE IF EXISTS `attendclasses`;
CREATE TABLE `attendclasses`  (
  `s_id` int(11) NOT NULL,
  `c_id` int(11) NOT NULL,
  `place` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`s_id`, `c_id`) USING BTREE,
  INDEX `c_id_idx`(`c_id`) USING BTREE,
  INDEX `c_id_1_idx`(`c_id`) USING BTREE,
  CONSTRAINT `c_id_1` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `s_id` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendclasses
-- ----------------------------
INSERT INTO `attendclasses` VALUES (16202101, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202102, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202103, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202104, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202105, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202106, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202107, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202108, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202109, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202110, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202111, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202112, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202113, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202114, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202115, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202116, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202117, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202118, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202119, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202120, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202121, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202122, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202123, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202124, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202125, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202126, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202127, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202128, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202129, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202130, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202131, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202132, 1, 'D101');
INSERT INTO `attendclasses` VALUES (16202133, 1, 'D101');

-- ----------------------------
-- Table structure for attendexperiment
-- ----------------------------
DROP TABLE IF EXISTS `attendexperiment`;
CREATE TABLE `attendexperiment`  (
  `s_id` int(11) NOT NULL,
  `e_id` int(11) NOT NULL,
  `ae_grade` double DEFAULT NULL,
  `ae_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`s_id`, `e_id`) USING BTREE,
  INDEX `e_id`(`e_id`) USING BTREE,
  CONSTRAINT `attendexperiment_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `attendexperiment_ibfk_2` FOREIGN KEY (`e_id`) REFERENCES `experiment` (`e_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendexperiment
-- ----------------------------
INSERT INTO `attendexperiment` VALUES (16202101, 1, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202101, 2, 30, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202101, 3, 40, '周一下午');
INSERT INTO `attendexperiment` VALUES (16202101, 4, 36, '周一下午');
INSERT INTO `attendexperiment` VALUES (16202101, 5, 70, '周二上午');
INSERT INTO `attendexperiment` VALUES (16202101, 6, 55, '周二上午');
INSERT INTO `attendexperiment` VALUES (16202101, 7, 90, '周二下午');
INSERT INTO `attendexperiment` VALUES (16202101, 8, 59, '周二下午');
INSERT INTO `attendexperiment` VALUES (16202101, 9, 60, '周三上午');
INSERT INTO `attendexperiment` VALUES (16202101, 10, 63, '周三上午');
INSERT INTO `attendexperiment` VALUES (16202101, 11, 86, '周三下午');
INSERT INTO `attendexperiment` VALUES (16202101, 12, 80, '周三下午');
INSERT INTO `attendexperiment` VALUES (16202101, 13, 30, '周四上午');
INSERT INTO `attendexperiment` VALUES (16202101, 14, 0, '周四上午');
INSERT INTO `attendexperiment` VALUES (16202101, 15, 76, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202101, 16, 66, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 1, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 2, 60, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 3, 50, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 4, 30, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 5, 20, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 6, 0, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 7, 0, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 8, 63, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 9, 46, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 10, 89, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 11, 90, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 12, 70, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 13, 76, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 14, 75, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 15, 77, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202102, 16, 31, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 1, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 2, 90, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 3, 56, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 4, 23, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 5, 22, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 6, 33, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 7, 55, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 8, 66, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 9, 88, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 10, 55, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 11, 11, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 12, 22, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 13, 33, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 14, 55, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 15, 99, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202103, 16, 11, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 1, 55, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 2, 66, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 3, 99, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 4, 77, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 5, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 6, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 7, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 8, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 9, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 10, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 11, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 12, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 13, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 14, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 15, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202104, 16, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 1, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 2, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 3, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 4, 55, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 5, 11, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 6, 22, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 7, 99, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 8, 77, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 9, 66, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 10, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 11, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 12, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 13, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 14, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 15, 80, '周一上午');
INSERT INTO `attendexperiment` VALUES (16202105, 16, 80, '周一上午');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `cls_id` int(11) NOT NULL AUTO_INCREMENT,
  `cls_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cls_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`cls_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 162032 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (162021, '162021班', 30);
INSERT INTO `class` VALUES (162022, '162022班', 30);
INSERT INTO `class` VALUES (162031, '162031班', 30);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'web');
INSERT INTO `course` VALUES (2, 'oracle');
INSERT INTO `course` VALUES (3, '软件项目管理');
INSERT INTO `course` VALUES (4, 'java网络编程');
INSERT INTO `course` VALUES (5, '软件设计建模');
INSERT INTO `course` VALUES (6, '专业英语');
INSERT INTO `course` VALUES (7, '就业指导');
INSERT INTO `course` VALUES (8, '数据结构');
INSERT INTO `course` VALUES (9, '操作系统');
INSERT INTO `course` VALUES (10, '计算机组成原理');
INSERT INTO `course` VALUES (11, '计算机网络');
INSERT INTO `course` VALUES (12, '安卓开发');
INSERT INTO `course` VALUES (13, 'web技术基础');
INSERT INTO `course` VALUES (14, 'sqlserver数据库');
INSERT INTO `course` VALUES (15, '软件工程');
INSERT INTO `course` VALUES (16, '软件测试');
INSERT INTO `course` VALUES (17, '高等数学');
INSERT INTO `course` VALUES (18, '线性代数');
INSERT INTO `course` VALUES (19, '概率论与数理统计');
INSERT INTO `course` VALUES (20, '大学英语');
INSERT INTO `course` VALUES (21, '大学物理');
INSERT INTO `course` VALUES (22, '大学体育');
INSERT INTO `course` VALUES (23, 'java技术基础');

-- ----------------------------
-- Table structure for dotask
-- ----------------------------
DROP TABLE IF EXISTS `dotask`;
CREATE TABLE `dotask`  (
  `s_id` int(11) NOT NULL,
  `t_id` int(11) NOT NULL,
  `t_grade` double DEFAULT NULL,
  PRIMARY KEY (`s_id`, `t_id`) USING BTREE,
  INDEX `t_id`(`t_id`) USING BTREE,
  CONSTRAINT `dotask_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `dotask_ibfk_2` FOREIGN KEY (`t_id`) REFERENCES `task` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dotask
-- ----------------------------
INSERT INTO `dotask` VALUES (16202101, 1, 80);
INSERT INTO `dotask` VALUES (16202102, 2, 75);
INSERT INTO `dotask` VALUES (16202103, 3, 80);
INSERT INTO `dotask` VALUES (16202104, 4, 95);

-- ----------------------------
-- Table structure for experiment
-- ----------------------------
DROP TABLE IF EXISTS `experiment`;
CREATE TABLE `experiment`  (
  `e_id` int(11) NOT NULL AUTO_INCREMENT,
  `e_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `e_content` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`e_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of experiment
-- ----------------------------
INSERT INTO `experiment` VALUES (1, '构建一个spring工程', '学习了解spring的相关知识');
INSERT INTO `experiment` VALUES (2, '使用Maven和Gradle创建工程', '学习使用Maven和Gradle创建sp');
INSERT INTO `experiment` VALUES (3, '使用Ajax程序设计', '学会使用Ajax进行设计功能');
INSERT INTO `experiment` VALUES (4, '分析用例及画用例图', '学习怎么分析一个需求中的用例');
INSERT INTO `experiment` VALUES (5, '画活动图及类图', '学习怎么分纤箱一个活动的过程');
INSERT INTO `experiment` VALUES (6, '画时序图和协作图', '学习怎么画一个用例涉及到的时序图并转化为');
INSERT INTO `experiment` VALUES (7, 'TCP程序设计', '学习使用TCP进行网络编程');
INSERT INTO `experiment` VALUES (8, 'UDP程序设计', '学习使用UDP进行网络编程');
INSERT INTO `experiment` VALUES (9, 'TCPUDP综合应用', '学习综合网络编程');
INSERT INTO `experiment` VALUES (10, 'java网络安全编程', '学习网络加密解密技术');
INSERT INTO `experiment` VALUES (11, 'javaFX程序设计', '学习Java中的可视化界面技术');
INSERT INTO `experiment` VALUES (12, 'IO网络程序设计', '学习IO操作技术');
INSERT INTO `experiment` VALUES (13, '多线程网络编程', '学习多线程在Java中的应用');
INSERT INTO `experiment` VALUES (14, 'oracle对象管理', '学习oracle的对象管理');
INSERT INTO `experiment` VALUES (15, 'oracle工具使用', '学习使用oracle的可视化界面工具');
INSERT INTO `experiment` VALUES (16, 'oracle变控件管理', '学习使用oracle创建数据库并进行管理');

-- ----------------------------
-- Table structure for markexperimentreport
-- ----------------------------
DROP TABLE IF EXISTS `markexperimentreport`;
CREATE TABLE `markexperimentreport`  (
  `assist_id` int(11) NOT NULL,
  `e_id` int(11) NOT NULL,
  `s_id` int(11) NOT NULL,
  `mer_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mer_grade` double DEFAULT NULL,
  `comment` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`assist_id`, `e_id`, `s_id`) USING BTREE,
  INDEX `e_id`(`e_id`) USING BTREE,
  INDEX `s_id`(`s_id`) USING BTREE,
  CONSTRAINT `markexperimentreport_ibfk_1` FOREIGN KEY (`assist_id`) REFERENCES `assistant` (`assist_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `markexperimentreport_ibfk_2` FOREIGN KEY (`e_id`) REFERENCES `experiment` (`e_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `markexperimentreport_ibfk_3` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of markexperimentreport
-- ----------------------------
INSERT INTO `markexperimentreport` VALUES (1601, 1, 16202101, '周六上午', 98, 'gdgf');
INSERT INTO `markexperimentreport` VALUES (1602, 2, 16202102, '周六下午', 80, '理解Spring 框架中组件的基本配置方法');
INSERT INTO `markexperimentreport` VALUES (1603, 3, 16202103, '周日上午', 80, '掌握Spring框架中mvc模块的使用方法');
INSERT INTO `markexperimentreport` VALUES (1604, 4, 16202104, '周日下午', 80, '掌握Spring框架中aop模块的使用方法');

-- ----------------------------
-- Table structure for marktask
-- ----------------------------
DROP TABLE IF EXISTS `marktask`;
CREATE TABLE `marktask`  (
  `assist_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  `s_id` int(11) NOT NULL,
  `mark_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `task_grade` double NOT NULL,
  `comment` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`assist_id`, `task_id`, `s_id`) USING BTREE,
  INDEX `s_id_idx`(`s_id`) USING BTREE,
  INDEX `st_id_idx`(`s_id`) USING BTREE,
  INDEX `t_id_idx`(`task_id`) USING BTREE,
  CONSTRAINT `assis_id` FOREIGN KEY (`assist_id`) REFERENCES `assistant` (`assist_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `s_id2` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_id2` FOREIGN KEY (`task_id`) REFERENCES `task` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of marktask
-- ----------------------------
INSERT INTO `marktask` VALUES (1601, 1, 16202101, '周一上午', 97, 'gfswgf');
INSERT INTO `marktask` VALUES (1602, 2, 16202102, '周二上午', 80, '理解Spring 框架中组件的基本配置方法');
INSERT INTO `marktask` VALUES (1603, 3, 16202103, '周三上午', 80, '掌握Spring框架中mvc模块的使用方法');
INSERT INTO `marktask` VALUES (1604, 4, 16202104, '周四上午', 80, '掌握Spring框架中aop模块的使用方法');

-- ----------------------------
-- Table structure for openexperiment
-- ----------------------------
DROP TABLE IF EXISTS `openexperiment`;
CREATE TABLE `openexperiment`  (
  `c_id` int(11) NOT NULL,
  `e_id` int(11) NOT NULL,
  `oe_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `oe_address` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`c_id`, `e_id`) USING BTREE,
  INDEX `e_id`(`e_id`) USING BTREE,
  CONSTRAINT `openexperiment_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `openexperiment_ibfk_2` FOREIGN KEY (`e_id`) REFERENCES `experiment` (`e_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of openexperiment
-- ----------------------------
INSERT INTO `openexperiment` VALUES (1, 1, '周二下午', 'd306');
INSERT INTO `openexperiment` VALUES (1, 2, '周一下午', 'e303');
INSERT INTO `openexperiment` VALUES (1, 3, '周二上午', 'e301');
INSERT INTO `openexperiment` VALUES (2, 14, '周一下午', 'd501');
INSERT INTO `openexperiment` VALUES (2, 15, '周六上午', 'd502');
INSERT INTO `openexperiment` VALUES (2, 16, '周一下午', 'd303');
INSERT INTO `openexperiment` VALUES (4, 7, '周二下午', 'd309');
INSERT INTO `openexperiment` VALUES (4, 8, '周一下午', 'd309');
INSERT INTO `openexperiment` VALUES (4, 9, '周四晚上', 'd309');
INSERT INTO `openexperiment` VALUES (4, 10, '周五下午', 'd310');
INSERT INTO `openexperiment` VALUES (4, 12, '周三上午', 'd401');
INSERT INTO `openexperiment` VALUES (4, 13, '周四晚上', 'd402');
INSERT INTO `openexperiment` VALUES (5, 4, '周六上午', 'g404');
INSERT INTO `openexperiment` VALUES (5, 5, '周日下午', 'd306');
INSERT INTO `openexperiment` VALUES (5, 6, '周四上午', 'd301');
INSERT INTO `openexperiment` VALUES (23, 11, '周日上午', 'd301');

-- ----------------------------
-- Table structure for ownassistant
-- ----------------------------
DROP TABLE IF EXISTS `ownassistant`;
CREATE TABLE `ownassistant`  (
  `t_id` int(11) NOT NULL,
  `assist_id` int(11) NOT NULL,
  `c_id` int(11) NOT NULL,
  `assist_grade` double DEFAULT NULL,
  `comment` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`t_id`, `assist_id`, `c_id`) USING BTREE,
  INDEX `assist_id_idx`(`assist_id`) USING BTREE,
  CONSTRAINT `assist_id` FOREIGN KEY (`assist_id`) REFERENCES `assistant` (`assist_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_id1` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ownassistant
-- ----------------------------
INSERT INTO `ownassistant` VALUES (1, 1601, 1, 98, 'gfdgs');
INSERT INTO `ownassistant` VALUES (3, 1603, 3, 80, '学习上进');
INSERT INTO `ownassistant` VALUES (4, 1604, 4, 80, '非常好');

-- ----------------------------
-- Table structure for publishapplication
-- ----------------------------
DROP TABLE IF EXISTS `publishapplication`;
CREATE TABLE `publishapplication`  (
  `t_id` int(11) NOT NULL,
  `application_id` int(11) NOT NULL,
  `c_id` int(11) NOT NULL,
  `publish_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `request` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`t_id`, `application_id`) USING BTREE,
  INDEX `employ_id_idx`(`application_id`) USING BTREE,
  CONSTRAINT `employ_id1` FOREIGN KEY (`application_id`) REFERENCES `applicationform` (`application_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_id` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of publishapplication
-- ----------------------------
INSERT INTO `publishapplication` VALUES (1, 100, 1, '周一上午', '细心');
INSERT INTO `publishapplication` VALUES (3, 102, 3, '周三上午', '细心');
INSERT INTO `publishapplication` VALUES (4, 104, 4, '周四上午', '细心');

-- ----------------------------
-- Table structure for reviewform
-- ----------------------------
DROP TABLE IF EXISTS `reviewform`;
CREATE TABLE `reviewform`  (
  `admin_id` int(11) NOT NULL,
  `application_id` int(11) NOT NULL,
  `result` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `review_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`admin_id`, `application_id`) USING BTREE,
  INDEX `employ_id_idx`(`application_id`) USING BTREE,
  CONSTRAINT `admin_id` FOREIGN KEY (`admin_id`) REFERENCES `administrator` (`admin_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employ_id` FOREIGN KEY (`application_id`) REFERENCES `applicationform` (`application_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reviewform
-- ----------------------------
INSERT INTO `reviewform` VALUES (1, 100, '完成', '周一上午');
INSERT INTO `reviewform` VALUES (2, 101, '完成', '周二上午');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cls_id` int(11) NOT NULL,
  `s_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`s_id`) USING BTREE,
  INDEX `cls_id`(`cls_id`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`cls_id`) REFERENCES `class` (`cls_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16202214 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (16202101, '方雅婷', 162021, '123');
INSERT INTO `student` VALUES (16202102, '朱海宇', 162021, '123');
INSERT INTO `student` VALUES (16202103, '王坤', 162021, '123');
INSERT INTO `student` VALUES (16202104, '范昊阳', 162021, '123');
INSERT INTO `student` VALUES (16202105, '王文光', 162021, '123');
INSERT INTO `student` VALUES (16202106, '周国帅', 162021, '123');
INSERT INTO `student` VALUES (16202107, '蔡艳平', 162021, '123');
INSERT INTO `student` VALUES (16202108, '陈旺', 162021, '123');
INSERT INTO `student` VALUES (16202109, '陈家瑞', 162021, '123');
INSERT INTO `student` VALUES (16202110, '郭凯', 162021, '123');
INSERT INTO `student` VALUES (16202111, '付思翔', 162021, '123');
INSERT INTO `student` VALUES (16202112, '黄路峰', 162021, '123');
INSERT INTO `student` VALUES (16202113, '崔琦', 162021, '123');
INSERT INTO `student` VALUES (16202114, '雷嘉威', 162021, '123');
INSERT INTO `student` VALUES (16202115, '李杰', 162021, '123');
INSERT INTO `student` VALUES (16202116, '刘天资', 162021, '123');
INSERT INTO `student` VALUES (16202117, '梁昌宇', 162021, '123');
INSERT INTO `student` VALUES (16202118, '齐汉卿', 162021, '123');
INSERT INTO `student` VALUES (16202119, '孙李', 162021, '123');
INSERT INTO `student` VALUES (16202120, '万文海', 162021, '123');
INSERT INTO `student` VALUES (16202121, '刘州', 162021, '123');
INSERT INTO `student` VALUES (16202122, '王红旗', 162021, '123');
INSERT INTO `student` VALUES (16202123, '吴俊雄', 162021, '123');
INSERT INTO `student` VALUES (16202124, '谢志波', 162021, '123');
INSERT INTO `student` VALUES (16202125, '杨磊刚', 162021, '123');
INSERT INTO `student` VALUES (16202126, '余超', 162021, '123');
INSERT INTO `student` VALUES (16202127, '张竞', 162021, '123');
INSERT INTO `student` VALUES (16202128, '周魁', 162021, '123');
INSERT INTO `student` VALUES (16202129, '曾鹤翔', 162021, '123');
INSERT INTO `student` VALUES (16202130, '韩晓健', 162021, '123');
INSERT INTO `student` VALUES (16202131, '朱天翔', 162021, '123');
INSERT INTO `student` VALUES (16202132, '周张俊', 162021, '123');
INSERT INTO `student` VALUES (16202133, '汪浩', 162021, '123');
INSERT INTO `student` VALUES (16202201, '甲', 162022, '123');
INSERT INTO `student` VALUES (16202202, '乙', 162022, '123');
INSERT INTO `student` VALUES (16202203, '丙', 162022, '123');
INSERT INTO `student` VALUES (16202204, '丁', 162022, '123');
INSERT INTO `student` VALUES (16202205, '戊', 162022, '123');
INSERT INTO `student` VALUES (16202206, '己', 162022, '123');
INSERT INTO `student` VALUES (16202207, '小明', 162022, '123');
INSERT INTO `student` VALUES (16202208, '小军', 162022, '123');
INSERT INTO `student` VALUES (16202209, '小飞', 162022, '123');
INSERT INTO `student` VALUES (16202210, '小李', 162022, '123');
INSERT INTO `student` VALUES (16202211, '小丽', 162022, '123');
INSERT INTO `student` VALUES (16202212, '小哥哥', 162022, '123');
INSERT INTO `student` VALUES (16202213, '小姐姐', 162022, '123');

-- ----------------------------
-- Table structure for studentandassistant
-- ----------------------------
DROP TABLE IF EXISTS `studentandassistant`;
CREATE TABLE `studentandassistant`  (
  `s_id` int(11) NOT NULL,
  `assist_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studentandassistant
-- ----------------------------
INSERT INTO `studentandassistant` VALUES (16202101, 1601);
INSERT INTO `studentandassistant` VALUES (16202102, 1602);
INSERT INTO `studentandassistant` VALUES (16202103, 1603);
INSERT INTO `studentandassistant` VALUES (16202104, 1604);

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `t_content` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES (1, '用java实现雨刷程序', '通过使用java来实现模拟汽车雨刷器的动');
INSERT INTO `task` VALUES (2, '模拟银行用例图', '分析银行ATM机并分析用例且画出用例图');
INSERT INTO `task` VALUES (3, 'ooracle项目子作业', '对教务系统进行需求分析并设计ER图');
INSERT INTO `task` VALUES (4, '策划一个项目', '对于各小组拿到的题目写一份项目策划书');
INSERT INTO `task` VALUES (5, 'security程序设计', '通过加密解密设计一个网络程序');
INSERT INTO `task` VALUES (6, '采用MVC模式进行程序设计', '基于web的MVC开发模式设计一个个人主');

-- ----------------------------
-- Table structure for teachclasses
-- ----------------------------
DROP TABLE IF EXISTS `teachclasses`;
CREATE TABLE `teachclasses`  (
  `t_id` int(11) NOT NULL,
  `c_id` int(11) NOT NULL,
  `tc_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`t_id`, `c_id`) USING BTREE,
  INDEX `c_id`(`c_id`) USING BTREE,
  CONSTRAINT `teachclasses_ibfk_1` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `teachclasses_ibfk_2` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teachclasses
-- ----------------------------
INSERT INTO `teachclasses` VALUES (1, 1, '周一上午');
INSERT INTO `teachclasses` VALUES (3, 3, '周三上午');
INSERT INTO `teachclasses` VALUES (4, 4, '周四上午');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `t_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '张恒峰', '123');
INSERT INTO `teacher` VALUES (3, '段喜龙', '123');
INSERT INTO `teacher` VALUES (4, '谭鹏柳', '123');
INSERT INTO `teacher` VALUES (5, '蔡珂', '123');
INSERT INTO `teacher` VALUES (6, '梁旗军', '123');
INSERT INTO `teacher` VALUES (7, '郑巍', '123');
INSERT INTO `teacher` VALUES (8, '刘忠民', '123');
INSERT INTO `teacher` VALUES (9, '苏曦', '123');
INSERT INTO `teacher` VALUES (10, '刘好斌', '123');
INSERT INTO `teacher` VALUES (11, '张宇', '123');
INSERT INTO `teacher` VALUES (12, '李永乐', '123');
INSERT INTO `teacher` VALUES (13, '汤家凤', '123');

-- ----------------------------
-- Table structure for writeapplicationform
-- ----------------------------
DROP TABLE IF EXISTS `writeapplicationform`;
CREATE TABLE `writeapplicationform`  (
  `s_id` int(11) NOT NULL,
  `application_id` int(11) NOT NULL,
  `c_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `application_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `comment` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`s_id`, `application_id`, `c_id`) USING BTREE,
  INDEX `application_id_idx`(`application_id`) USING BTREE,
  CONSTRAINT `s_id1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of writeapplicationform
-- ----------------------------
INSERT INTO `writeapplicationform` VALUES (16202101, 100, '5', '周一上午', '录取', '中午');
INSERT INTO `writeapplicationform` VALUES (16202128, 104, '3', '周一上午', '未录取', '');

SET FOREIGN_KEY_CHECKS = 1;
