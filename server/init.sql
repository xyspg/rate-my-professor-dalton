/*
 Navicat Premium Data Transfer

 Source Server         : 我的舍曲林
 Source Server Type    : MySQL
 Source Server Version : 80300 (8.3.0)
 Source Host           : localhost:3306
 Source Schema         : ratemyprofessor

 Target Server Type    : MySQL
 Target Server Version : 80300 (8.3.0)
 File Encoding         : 65001

 Date: 18/05/2024 15:58:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for professors
-- ----------------------------
DROP TABLE IF EXISTS `professors`;
CREATE TABLE `professors` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
                              `department` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
                              `rating` decimal(3,2) DEFAULT '0.00',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of professors
-- ----------------------------
BEGIN;
INSERT INTO `professors` (`id`, `name`, `department`, `rating`) VALUES (1, '舍曲林', 'Chemistry', 0.00);
INSERT INTO `professors` (`id`, `name`, `department`, `rating`) VALUES (2, '劳拉西泮', 'Chemistry', 0.00);
INSERT INTO `professors` (`id`, `name`, `department`, `rating`) VALUES (3, '哌甲酯', 'Chemistry', 0.00);
INSERT INTO `professors` (`id`, `name`, `department`, `rating`) VALUES (4, '阿立哌唑', 'Physics', 0.00);
INSERT INTO `professors` (`id`, `name`, `department`, `rating`) VALUES (5, '右美沙芬', 'ELA', 0.00);
INSERT INTO `professors` (`id`, `name`, `department`, `rating`) VALUES (6, '普瑞巴林', 'ELA', 0.00);
INSERT INTO `professors` (`id`, `name`, `department`, `rating`) VALUES (7, '金刚烷胺', 'ELA', 0.00);
INSERT INTO `professors` (`id`, `name`, `department`, `rating`) VALUES (8, '托莫西汀', 'ELA', 0.00);
INSERT INTO `professors` (`id`, `name`, `department`, `rating`) VALUES (9, '曲马多', 'CLA', 0.00);
INSERT INTO `professors` (`id`, `name`, `department`, `rating`) VALUES (10, '西酞普兰', 'Math', 0.00);
INSERT INTO `professors` (`id`, `name`, `department`, `rating`) VALUES (11, '板蓝根', 'WCC', 0.00);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
