/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : hotel_ai

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 25/03/2020 22:52:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for amounts
-- ----------------------------
DROP TABLE IF EXISTS `amounts`;
CREATE TABLE `amounts`  (
  `amount_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '账户ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `balance` decimal(10, 0) NOT NULL COMMENT '余额',
  `owe_money` decimal(10, 0) NULL DEFAULT NULL COMMENT '赊欠',
  PRIMARY KEY (`amount_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `amounts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of amounts
-- ----------------------------
INSERT INTO `amounts` VALUES (1, 1, 1000, 0);
INSERT INTO `amounts` VALUES (2, 1, 1110, 12);
INSERT INTO `amounts` VALUES (3, 1, 1110, 12);
INSERT INTO `amounts` VALUES (4, 1, 1110, 12);

-- ----------------------------
-- Table structure for cashiers
-- ----------------------------
DROP TABLE IF EXISTS `cashiers`;
CREATE TABLE `cashiers`  (
  `cashier_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收银设备ID',
  `cashier_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备名称',
  PRIMARY KEY (`cashier_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cashiers
-- ----------------------------
INSERT INTO `cashiers` VALUES (1, '设备1');

-- ----------------------------
-- Table structure for checkin_records
-- ----------------------------
DROP TABLE IF EXISTS `checkin_records`;
CREATE TABLE `checkin_records`  (
  `CI_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '入住ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `status` int(11) NOT NULL COMMENT '入住状态',
  `ci_time` timestamp(0) NULL DEFAULT NULL COMMENT '入住时间',
  `co_time` timestamp(0) NULL DEFAULT NULL COMMENT '离开时间',
  `description` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述信息',
  PRIMARY KEY (`CI_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `checkin_records_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of checkin_records
-- ----------------------------
INSERT INTO `checkin_records` VALUES ('sadfasdf', 1, 1, '2020-02-22 20:54:58', '2020-02-22 20:55:03', '正常');

-- ----------------------------
-- Table structure for faceinfo
-- ----------------------------
DROP TABLE IF EXISTS `faceinfo`;
CREATE TABLE `faceinfo`  (
  `faceInfo_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '面部信息ID',
  `imgName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '面部图像文件名称',
  `face_imgPath` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '面部图像文件路径',
  `face_feature` varchar(5300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '面部特征值(byte值字符串，以“.”隔开)',
  PRIMARY KEY (`faceInfo_id`) USING BTREE,
  INDEX `faceInfo_id`(`faceInfo_id`) USING BTREE,
  INDEX `faceInfo_id_2`(`faceInfo_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of faceinfo
-- ----------------------------
INSERT INTO `faceinfo` VALUES ('aaaa', '何旭东老家.jpg', 'F:\\AI酒店\\SDK的test图片\\系统人脸图片', '0.0.-6.68.0.0.116.67.-65.-50.-98.-70.-121.68.-33.60.114.1.-120.-67.-63.-11.115.61.96.-25.-63.-69.31.-70.-64.60.-14.-11.42.61.-35.55.6.-66.-10.37.-48.-67.-18.-43.3.-71.83.-33.17.-67.-76.-88.84.-69.-70.43.-117.-67.41.-94.99.-68.-4.13.-30.-68.85.-39.-43.-71.-41.67.93.-67.-17.2.-42.60.3.-91.-121.-69.-72.-78.-113.61.-113.-4.72.-67.1.53.-126.61.100.8.-119.-68.74.-50.4.-67.113.119.-83.-67.56.60.-15.-67.98.-15.10.62.-109.109.83.61.120.66.13.61.113.87.47.-67.-11.52.-95.-67.57.60.-44.61.76.-76.-109.61.-118.60.58.-67.-82.-13.56.-67.103.-21.58.-68.61.-45.2.-67.91.60.90.-67.-113.6.46.-67.-115.-43.9.61.-23.67.-29.-68.-103.100.2.-71.122.-61.58.61.-117.101.72.61.29.-120.24.62.-4.-25.98.61.-106.14.-84.-67.37.34.-13.-67.102.12.23.-66.-53.77.-113.61.71.114.-35.59.48.35.67.60.-64.107.-46.-68.-18.31.-70.-68.-118.-22.-35.-67.32.46.-100.-68.2.107.-24.60.-101.-7.99.61.-19.-68.-85.-67.58.70.-108.-67.-124.126.70.61.-94.12.68.60.-79.102.94.-67.-98.-18.-80.61.-25.55.-57.-67.-34.67.15.61.94.-47.44.60.48.21.-124.60.-25.27.-128.-68.46.107.-117.-67.-35.-55.-68.61.-53.7.-69.59.-90.-85.-57.-67.-51.114.-95.61.65.60.31.-67.-31.-24.26.-67.65.95.-35.59.-51.-99.121.61.-7.39.-23.60.-126.-85.42.-67.-59.14.-69.-67.95.73.127.61.89.76.-5.59.-68.-108.-18.-67.46.99.0.-67.-83.42.-125.-69.81.-40.-7.61.-3.114.-48.-67.-47.-120.-101.59.109.19.-1.60.-52.-7.54.-67.-106.17.-111.61.120.-38.-31.-67.-111.-103.-25.-68.-87.25.-109.-67.24.-1.-77.-67.-51.-31.-105.59.-84.110.59.-67.-45.41.53.-67.54.87.-27.61.-80.86.-128.61.-72.-3.-106.-68.113.87.-119.61.-8.-104.49.-67.113.32.-125.57.-40.66.79.61.74.-51.-13.-70.-100.-110.48.61.38.23.83.61.10.-24.24.61.-120.-49.-121.-67.-35.-62.-91.-67.20.23.-67.-68.42.3.-46.-70.54.40.-102.-67.-62.66.-66.-70.57.-23.5.-67.97.-86.78.-68.103.-16.16.61.-57.-20.-62.61.14.-107.-34.59.-56.-91.-13.-68.-12.-79.-125.61.-78.-45.-69.-67.31.-118.-68.-68.-98.-124.20.62.106.30.-48.-68.-6.2.81.-67.99.-81.-61.61.33.47.123.61.-70.-20.116.60.-117.-71.-50.60.-53.-127.41.60.112.26.67.61.76.-16.-48.58.70.67.-114.60.-128.-62.-43.-68.-91.-30.23.61.-10.-9.-74.60.-124.106.64.-67.-77.-100.-71.-69.4.54.-115.61.48.-102.-122.-67.-38.-37.40.-68.-111.104.-117.58.-71.77.-117.-67.26.36.-83.61.-4.106.-117.-67.46.-9.14.58.-97.-57.-72.-69.-32.-30.-39.-68.-117.9.-66.60.-28.-83.2.-66.26.-90.-82.61.27.77.82.61.-118.104.-32.60.-9.22.92.-67.102.-125.-121.61.104.-79.54.61.18.-31.116.-67.33.-111.21.-68.-33.113.-89.-69.-93.43.47.61.-109.13.-72.-67.41.-126.-48.-68.-43.93.-125.59.97.-2.90.-67.78.-116.-10.60.40.-30.-75.61.27.66.72.-68.42.-25.-121.-67.-30.11.47.-68.86.68.107.-68.122.34.-26.-67.-59.-37.-91.60.-100.44.-27.60.51.55.-77.60.31.41.-122.61.63.25.26.-67.-30.-47.-110.-68.55.-57.2.59.57.108.-105.-68.-100.-83.-3.-68.55.-107.8.61.46.-20.-3.-69.15.-98.-36.61.83.32.-91.-68.39.46.12.61.31.-46.-83.61.-124.48.31.57.-122.104.11.-68.62.57.103.-67.87.-33.35.-66.87.66.-30.-68.106.61.-114.61.-28.-120.9.61.12.127.75.-67.-52.-125.-26.61.-124.94.-32.-68.-91.-84.-64.61.-66.108.-117.-67.-66.-65.74.-67.62.-94.-93.61.70.92.-103.-67.102.-75.-82.61.100.-23.-75.61.-74.-19.114.-67.-20.43.-16.-68.51.6.-27.-68.-1.-55.99.61.-41.-117.-25.61.-84.12.-79.-68.106.-96.-114.60.94.-71.2.62.123.-89.22.-67.79.-32.-119.61.-63.96.100.60.-20.-123.-112.61.-34.115.87.61.-47.-24.-110.61.17.-29.-73.-68.-62.70.-6.-69.25.-42.7.61.60.72.53.-67.-99.-112.96.-68.127.72.69.61.-46.-36.81.-67.-4.91.105.-67.25.-39.10.-66.-57.-30.-78.61.-83.-101.6.61.-126.49.96.61.-107.-86.-67.-68.48.36.104.-67.-28.-42.-4.58.38.108.86.-67.-123.79.-34.-67.89.55.-85.-69.-102.42.-4.-68.-111.-17.-6.-67.-124.-21.93.62.-101.-83.-94.61.113.109.0.61.24.-3.41.-67.-126.-21.-68.-69.103.-49.-83.60.-68.-115.-29.61.-124.87.-75.60.33.49.99.61.-88.-80.31.61.54.-57.18.-67.119.35.-62.-67.-34.57.-114.-67.125.57.-17.-67.-117.-60.115.-67.13.-37.-52.61.');

-- ----------------------------
-- Table structure for pay_records
-- ----------------------------
DROP TABLE IF EXISTS `pay_records`;
CREATE TABLE `pay_records`  (
  `pay_record_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消费记录ID',
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `product_id` int(11) NOT NULL COMMENT '商品ID',
  `cashier_id` int(11) NOT NULL COMMENT '收银设备ID',
  `amount` int(11) NOT NULL COMMENT '账户ID',
  `money` decimal(10, 0) NOT NULL COMMENT '消费总金额',
  `pay_time` timestamp(0) NULL DEFAULT NULL COMMENT '支付时间',
  `description` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`pay_record_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  INDEX `cashier_id`(`cashier_id`) USING BTREE,
  CONSTRAINT `pay_records_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `pay_records_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `pay_records_ibfk_3` FOREIGN KEY (`cashier_id`) REFERENCES `cashiers` (`cashier_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay_records
-- ----------------------------
INSERT INTO `pay_records` VALUES ('khkjjkh4564', 1, 1, 1, 6, 229, '2020-02-21 21:18:37', '好吃');

-- ----------------------------
-- Table structure for product_classes
-- ----------------------------
DROP TABLE IF EXISTS `product_classes`;
CREATE TABLE `product_classes`  (
  `class_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品分类号',
  `class_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_classes
-- ----------------------------
INSERT INTO `product_classes` VALUES (1, '一次性消耗');

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `p_name` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `class_id` int(11) NOT NULL COMMENT '分类号',
  `sale` decimal(10, 0) NOT NULL COMMENT '单价',
  `p_surplus` int(11) NOT NULL COMMENT '商品剩余量',
  PRIMARY KEY (`product_id`) USING BTREE,
  INDEX `class_id`(`class_id`) USING BTREE,
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `product_classes` (`class_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES (1, '水煮鱼一份', 1, 39, 500);

-- ----------------------------
-- Table structure for room_orders
-- ----------------------------
DROP TABLE IF EXISTS `room_orders`;
CREATE TABLE `room_orders`  (
  `room_order_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客房订单ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `sale` decimal(10, 0) NOT NULL COMMENT '价格',
  `book_time` timestamp(0) NULL DEFAULT NULL COMMENT '预定时间',
  `start_time` timestamp(0) NULL DEFAULT NULL COMMENT '生效时间',
  `end_time` timestamp(0) NULL DEFAULT NULL COMMENT '截止时间',
  PRIMARY KEY (`room_order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `room_orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room_orders
-- ----------------------------
INSERT INTO `room_orders` VALUES ('asdfdadsfasd', 1, 26, '2020-02-28 22:30:15', '2020-02-29 22:30:19', '2020-03-26 19:30:27');

-- ----------------------------
-- Table structure for user_limits
-- ----------------------------
DROP TABLE IF EXISTS `user_limits`;
CREATE TABLE `user_limits`  (
  `limit_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限号',
  `role_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`limit_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_limits
-- ----------------------------
INSERT INTO `user_limits` VALUES (1, '系统管理员');
INSERT INTO `user_limits` VALUES (2, 'vip用户');
INSERT INTO `user_limits` VALUES (3, '普通用户');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `real_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `limit_id` int(11) NULL DEFAULT NULL COMMENT '权限号',
  `faceInfo_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '面部信息ID',
  `IDcard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证ID号',
  `phone` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号码',
  `address` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '居住地址',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `limit_id`(`limit_id`) USING BTREE,
  INDEX `faceInfo_id`(`faceInfo_id`) USING BTREE,
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`limit_id`) REFERENCES `user_limits` (`limit_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `users_ibfk_2` FOREIGN KEY (`faceInfo_id`) REFERENCES `faceinfo` (`faceinfo_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', 'aihotel', '何旭东', 22, 1, 'aaaa', '13213213212313', '1101321', '中国');

-- ----------------------------
-- Table structure for vip_info
-- ----------------------------
DROP TABLE IF EXISTS `vip_info`;
CREATE TABLE `vip_info`  (
  `vip_id` int(11) NOT NULL COMMENT 'vip信息ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `start_time` timestamp(0) NULL DEFAULT NULL COMMENT '生效时间',
  `end_time` timestamp(0) NULL DEFAULT NULL COMMENT '截止时间',
  PRIMARY KEY (`vip_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `vip_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
