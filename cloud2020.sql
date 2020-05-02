/*
 Navicat Premium Data Transfer

 Source Server         : 本地库
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : cloud2020

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 02/05/2020 13:27:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `serial` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES (1, '腾讯');
INSERT INTO `payment` VALUES (2, 'alibaba');
INSERT INTO `payment` VALUES (3, '京东');
INSERT INTO `payment` VALUES (4, '头条');
INSERT INTO `payment` VALUES (5, '德玛西亚');
INSERT INTO `payment` VALUES (8, '提莫队长');

SET FOREIGN_KEY_CHECKS = 1;
