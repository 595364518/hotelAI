/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : hotelai

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 07/04/2020 12:09:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts`  (
  `account_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `balance` decimal(10, 0) NOT NULL,
  `owe_money` decimal(10, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`account_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `accounts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cashiers
-- ----------------------------
DROP TABLE IF EXISTS `cashiers`;
CREATE TABLE `cashiers`  (
  `cashier_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cashier_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`cashier_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for checkin_records
-- ----------------------------
DROP TABLE IF EXISTS `checkin_records`;
CREATE TABLE `checkin_records`  (
  `CI_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NOT NULL,
  `ci_time` timestamp(0) NULL DEFAULT NULL,
  `co_time` timestamp(0) NULL DEFAULT NULL,
  `description` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`CI_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `checkin_records_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for faceinfo
-- ----------------------------
DROP TABLE IF EXISTS `faceinfo`;
CREATE TABLE `faceinfo`  (
  `faceInfo_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `imgName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `face_imgPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `face_feature` varchar(5300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`faceInfo_id`) USING BTREE,
  INDEX `faceInfo_id`(`faceInfo_id`) USING BTREE,
  INDEX `faceInfo_id_2`(`faceInfo_id`) USING BTREE,
  INDEX `faceInfo_id_3`(`faceInfo_id`) USING BTREE,
  INDEX `faceInfo_id_4`(`faceInfo_id`) USING BTREE,
  INDEX `faceInfo_id_5`(`faceInfo_id`) USING BTREE,
  INDEX `faceInfo_id_6`(`faceInfo_id`) USING BTREE,
  INDEX `faceInfo_id_7`(`faceInfo_id`) USING BTREE,
  INDEX `faceInfo_id_8`(`faceInfo_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of faceinfo
-- ----------------------------
INSERT INTO `faceinfo` VALUES ('aaaa', '何旭东老家.jpg', 'F:\\AI酒店\\SDK的test图片\\系统人脸图片', '0.0.-6.68.0.0.116.67.-65.-50.-98.-70.-121.68.-33.60.114.1.-120.-67.-63.-11.115.61.96.-25.-63.-69.31.-70.-64.60.-14.-11.42.61.-35.55.6.-66.-10.37.-48.-67.-18.-43.3.-71.83.-33.17.-67.-76.-88.84.-69.-70.43.-117.-67.41.-94.99.-68.-4.13.-30.-68.85.-39.-43.-71.-41.67.93.-67.-17.2.-42.60.3.-91.-121.-69.-72.-78.-113.61.-113.-4.72.-67.1.53.-126.61.100.8.-119.-68.74.-50.4.-67.113.119.-83.-67.56.60.-15.-67.98.-15.10.62.-109.109.83.61.120.66.13.61.113.87.47.-67.-11.52.-95.-67.57.60.-44.61.76.-76.-109.61.-118.60.58.-67.-82.-13.56.-67.103.-21.58.-68.61.-45.2.-67.91.60.90.-67.-113.6.46.-67.-115.-43.9.61.-23.67.-29.-68.-103.100.2.-71.122.-61.58.61.-117.101.72.61.29.-120.24.62.-4.-25.98.61.-106.14.-84.-67.37.34.-13.-67.102.12.23.-66.-53.77.-113.61.71.114.-35.59.48.35.67.60.-64.107.-46.-68.-18.31.-70.-68.-118.-22.-35.-67.32.46.-100.-68.2.107.-24.60.-101.-7.99.61.-19.-68.-85.-67.58.70.-108.-67.-124.126.70.61.-94.12.68.60.-79.102.94.-67.-98.-18.-80.61.-25.55.-57.-67.-34.67.15.61.94.-47.44.60.48.21.-124.60.-25.27.-128.-68.46.107.-117.-67.-35.-55.-68.61.-53.7.-69.59.-90.-85.-57.-67.-51.114.-95.61.65.60.31.-67.-31.-24.26.-67.65.95.-35.59.-51.-99.121.61.-7.39.-23.60.-126.-85.42.-67.-59.14.-69.-67.95.73.127.61.89.76.-5.59.-68.-108.-18.-67.46.99.0.-67.-83.42.-125.-69.81.-40.-7.61.-3.114.-48.-67.-47.-120.-101.59.109.19.-1.60.-52.-7.54.-67.-106.17.-111.61.120.-38.-31.-67.-111.-103.-25.-68.-87.25.-109.-67.24.-1.-77.-67.-51.-31.-105.59.-84.110.59.-67.-45.41.53.-67.54.87.-27.61.-80.86.-128.61.-72.-3.-106.-68.113.87.-119.61.-8.-104.49.-67.113.32.-125.57.-40.66.79.61.74.-51.-13.-70.-100.-110.48.61.38.23.83.61.10.-24.24.61.-120.-49.-121.-67.-35.-62.-91.-67.20.23.-67.-68.42.3.-46.-70.54.40.-102.-67.-62.66.-66.-70.57.-23.5.-67.97.-86.78.-68.103.-16.16.61.-57.-20.-62.61.14.-107.-34.59.-56.-91.-13.-68.-12.-79.-125.61.-78.-45.-69.-67.31.-118.-68.-68.-98.-124.20.62.106.30.-48.-68.-6.2.81.-67.99.-81.-61.61.33.47.123.61.-70.-20.116.60.-117.-71.-50.60.-53.-127.41.60.112.26.67.61.76.-16.-48.58.70.67.-114.60.-128.-62.-43.-68.-91.-30.23.61.-10.-9.-74.60.-124.106.64.-67.-77.-100.-71.-69.4.54.-115.61.48.-102.-122.-67.-38.-37.40.-68.-111.104.-117.58.-71.77.-117.-67.26.36.-83.61.-4.106.-117.-67.46.-9.14.58.-97.-57.-72.-69.-32.-30.-39.-68.-117.9.-66.60.-28.-83.2.-66.26.-90.-82.61.27.77.82.61.-118.104.-32.60.-9.22.92.-67.102.-125.-121.61.104.-79.54.61.18.-31.116.-67.33.-111.21.-68.-33.113.-89.-69.-93.43.47.61.-109.13.-72.-67.41.-126.-48.-68.-43.93.-125.59.97.-2.90.-67.78.-116.-10.60.40.-30.-75.61.27.66.72.-68.42.-25.-121.-67.-30.11.47.-68.86.68.107.-68.122.34.-26.-67.-59.-37.-91.60.-100.44.-27.60.51.55.-77.60.31.41.-122.61.63.25.26.-67.-30.-47.-110.-68.55.-57.2.59.57.108.-105.-68.-100.-83.-3.-68.55.-107.8.61.46.-20.-3.-69.15.-98.-36.61.83.32.-91.-68.39.46.12.61.31.-46.-83.61.-124.48.31.57.-122.104.11.-68.62.57.103.-67.87.-33.35.-66.87.66.-30.-68.106.61.-114.61.-28.-120.9.61.12.127.75.-67.-52.-125.-26.61.-124.94.-32.-68.-91.-84.-64.61.-66.108.-117.-67.-66.-65.74.-67.62.-94.-93.61.70.92.-103.-67.102.-75.-82.61.100.-23.-75.61.-74.-19.114.-67.-20.43.-16.-68.51.6.-27.-68.-1.-55.99.61.-41.-117.-25.61.-84.12.-79.-68.106.-96.-114.60.94.-71.2.62.123.-89.22.-67.79.-32.-119.61.-63.96.100.60.-20.-123.-112.61.-34.115.87.61.-47.-24.-110.61.17.-29.-73.-68.-62.70.-6.-69.25.-42.7.61.60.72.53.-67.-99.-112.96.-68.127.72.69.61.-46.-36.81.-67.-4.91.105.-67.25.-39.10.-66.-57.-30.-78.61.-83.-101.6.61.-126.49.96.61.-107.-86.-67.-68.48.36.104.-67.-28.-42.-4.58.38.108.86.-67.-123.79.-34.-67.89.55.-85.-69.-102.42.-4.-68.-111.-17.-6.-67.-124.-21.93.62.-101.-83.-94.61.113.109.0.61.24.-3.41.-67.-126.-21.-68.-69.103.-49.-83.60.-68.-115.-29.61.-124.87.-75.60.33.49.99.61.-88.-80.31.61.54.-57.18.-67.119.35.-62.-67.-34.57.-114.-67.125.57.-17.-67.-117.-60.115.-67.13.-37.-52.61.');
INSERT INTO `faceinfo` VALUES ('bbbb', '梁海彬.jpg', 'F:\\AI酒店\\SDK的test图片\\系统人脸图片', '0.0.-6.68.0.0.116.67.-108.-107.-123.61.-94.73.-10.60.117.108.-25.59.45.74.40.61.107.63.-110.-67.35.-74.-123.61.-120.4.23.-68.35.2.43.-67.-74.107.-67.57.89.-97.-95.-68.84.9.-82.-68.76.25.-87.-67.2.46.-38.-68.68.-78.-93.61.70.-38.-102.-68.82.90.27.61.113.-115.31.60.-14.-87.71.-67.83.-60.9.62.-85.66.52.-69.-14.-73.-37.61.120.-88.100.61.-42.29.-68.-67.-37.50.-99.-69.48.-23.-117.61.77.124.-32.-68.80.-23.-91.61.-101.-14.-19.60.-5.-73.91.-67.-92.-42.93.61.-105.33.52.61.-106.16.1.-68.-127.-90.58.-67.73.-69.-66.-68.-86.42.-23.60.-6.-106.-45.-67.-26.-118.-69.60.109.87.-115.-67.48.-81.-58.-71.21.-61.-87.-68.11.58.-49.-67.-5.-99.66.61.63.-73.9.61.109.80.74.-68.-102.95.51.61.-91.-13.-35.-67.-57.115.10.-66.44.-45.118.-67.-15.95.-127.-67.32.-64.-109.-67.-58.111.47.61.115.72.82.-68.-33.-15.-112.61.30.44.39.-66.2.-11.-70.59.123.-44.42.-68.98.110.32.60.109.-11.-45.60.30.-61.-76.-67.-108.3.98.-68.-7.74.15.-67.-27.58.-20.61.-117.-39.46.-67.-123.-66.113.-67.114.24.-92.59.-33.27.15.-67.118.-11.52.61.-44.21.83.61.-8.-5.-13.-67.-17.36.-127.-67.20.87.-97.-68.12.-101.-103.-67.-94.96.14.-68.87.17.-98.-67.86.-66.-47.59.123.52.-82.61.125.-56.53.61.103.57.107.61.-124.-64.126.58.-83.7.26.-67.-111.54.-115.-68.-71.89.-62.61.-23.71.-112.-67.126.-127.38.62.-108.34.71.-67.-39.12.-37.-67.-121.89.-86.61.-84.104.-66.61.-105.-26.-104.61.42.11.-124.-72.9.-29.80.-67.15.0.-57.-67.2.-1.-118.61.62.-45.-28.-68.120.-86.127.61.17.-39.-45.60.-78.60.-91.61.120.-87.-8.-68.76.115.27.61.-6.-76.-104.61.48.-31.-71.-67.-5.-10.-77.60.-74.50.-35.-68.-64.-4.45.-68.40.51.-93.60.-61.-62.79.-67.-30.-81.97.61.14.69.87.61.67.-67.-110.61.58.-53.69.61.-89.85.-100.-67.-117.-71.-22.60.97.-124.-76.61.54.-122.-88.61.89.-87.-74.60.-1.87.34.62.12.-119.37.-67.73.-22.-30.-68.-70.-56.69.61.-23.59.-57.60.-100.102.-119.-67.-80.-70.-32.60.-26.-119.80.61.115.-21.59.-68.-35.20.-128.61.-48.89.83.-67.97.-71.-20.-67.27.-38.87.-67.-5.73.87.-67.27.-9.98.60.-61.78.125.60.87.21.43.-67.40.-77.-117.59.-47.-46.102.-67.43.-80.30.61.80.-11.-86.-68.49.1.61.-69.11.78.50.-68.124.51.-58.60.42.-1.101.61.-81.55.-73.61.2.122.41.-69.21.-104.-124.-68.-2.104.15.61.-12.-88.107.61.-78.-25.28.62.100.85.-82.-68.-35.-17.20.62.62.-49.-40.61.2.-31.98.58.20.-66.65.-67.-51.-55.12.-68.-75.70.2.-68.82.-39.-111.-67.103.5.78.-67.-73.6.70.-67.100.-127.-57.-67.-21.52.-80.61.-106.-108.-117.-67.-68.34.-82.60.116.119.18.-67.-36.118.86.61.46.100.-123.-68.-82.84.34.61.-23.2.23.-68.51.-110.-128.-67.56.-105.-107.61.65.-13.27.60.97.15.72.61.76.-35.-60.-67.-83.17.-78.61.42.80.-113.61.91.103.84.-67.120.44.100.60.95.-26.-27.-67.23.-96.-44.60.-3.125.85.61.86.-96.-120.60.-108.-51.-119.-67.-122.-123.49.-67.-19.44.55.-67.52.33.48.61.86.124.3.61.-123.113.56.61.36.114.11.-67.47.-101.-54.61.-115.36.48.61.-27.-11.66.60.-18.-85.-54.58.-96.74.-85.-71.-61.101.22.61.52.2.75.61.-42.41.10.61.-11.125.1.61.-18.102.64.-67.98.109.-20.60.53.-36.109.61.17.-76.-81.61.-72.105.8.60.12.-64.117.60.-82.121.-38.60.90.-90.-82.61.0.123.55.-67.-118.65.2.-66.95.-20.-128.-69.-115.82.-22.59.-17.110.32.-69.-2.-17.-30.-69.-58.-82.19.59.-48.-101.-96.61.36.58.-26.-67.58.50.-3.61.-3.-6.124.-67.61.94.-111.-67.-71.54.22.59.58.79.49.61.-42.-106.40.61.21.8.-5.61.-126.9.-126.-67.119.120.-97.-67.-8.-9.6.61.-73.61.-6.60.86.7.-118.61.-111.-10.69.61.9.-31.-1.-68.-126.-52.63.-67.-111.106.-92.61.126.-19.-33.-67.-2.-95.-108.-68.56.-37.-81.-67.-64.-5.52.-67.56.27.92.60.-24.71.-17.-67.73.88.-123.61.-45.95.-60.-68.-96.-55.27.60.5.-109.38.-67.-121.110.-5.-68.77.23.115.-67.85.-86.94.-67.-43.64.2.-66.33.55.-114.61.-45.-35.19.61.13.-108.-72.-67.19.-29.-127.-69.-18.71.112.-68.9.-99.90.61.-75.-68.-85.60.106.4.-43.-68.-47.38.93.61.68.-8.126.61.68.32.-102.-67.123.19.61.62.-35.39.-90.-67.-8.-105.-77.61.72.-71.-65.61.');
INSERT INTO `faceinfo` VALUES ('FACE_Om0WO0QHGd', 'face_img392741c1-14ea-473c-a33f-6eda0411dd79.png', 'C:\\ai\\face\\', '0.0.-6.68.0.0.116.67.32.-33.19.61.26.40.-102.-67.-42.-115.-112.60.-68.67.-24.-67.1.-128.-117.-67.7.-72.-7.60.38.-35.-92.60.-59.61.-55.-68.-94.-76.-110.61.-41.44.26.-67.-84.-113.71.61.83.-21.0.62.-106.-127.-120.-67.96.13.-98.60.-95.-124.-90.61.-104.101.-74.60.69.-83.-20.-68.2.-69.-41.61.85.-98.56.61.112.-97.-57.-67.45.-106.54.61.73.87.107.-68.-14.-43.111.61.47.41.-56.-67.8.66.84.-67.-89.58.60.-68.-14.-75.-86.61.41.2.93.61.112.96.18.61.35.-15.-103.61.93.-120.15.-68.-19.101.80.61.17.115.-99.-67.8.33.-98.61.14.-71.4.-68.-71.-45.-117.61.-12.90.55.-67.86.55.-123.60.-24.-74.107.60.73.-44.-120.61.-6.-91.-73.-67.-108.35.-48.60.-71.40.66.61.69.101.87.-67.99.-66.114.61.54.-68.-116.-67.11.104.101.60.-84.57.-7.-67.125.-64.-76.-67.-82.-58.124.-68.-17.26.-73.60.12.62.101.60.4.-45.12.61.-111.50.119.58.-61.114.-83.-67.112.0.-128.61.-63.77.-120.60.125.-98.-95.59.-27.58.-100.60.-32.65.-124.-67.-94.66.-45.60.-39.89.39.-67.26.-83.121.-68.-38.1.-97.58.-113.-105.95.59.23.103.28.-68.76.-116.7.62.102.23.-114.61.7.-109.-30.60.70.-41.-72.-67.37.-116.-35.-68.6.82.100.60.-48.14.35.61.-27.34.-128.61.95.126.-96.61.-90.-103.82.61.45.-67.-83.-68.21.-4.-43.-68.95.103.-66.60.6.30.-5.61.81.30.1.-66.-54.93.-89.61.-102.45.51.-67.112.-128.56.-67.104.26.-68.-68.-24.111.-83.-68.-126.-2.-16.-67.-13.124.-34.-67.124.91.84.61.23.9.22.-66.-126.-97.28.61.-32.25.-75.61.-56.-115.-95.61.124.-9.69.60.-101.-27.-8.56.121.61.-46.-68.75.70.80.60.-11.16.84.60.-58.112.-112.59.1.25.-107.61.-107.14.-128.-67.68.34.60.61.96.117.-34.-69.21.106.-88.61.-54.-80.-76.60.-29.17.-13.60.26.104.-44.60.87.21.16.-67.17.-25.8.-66.15.52.-10.-68.19.-109.-124.-67.-116.-59.58.-67.107.-32.104.-67.-32.95.40.-67.-101.25.-40.56.-96.60.11.-66.-77.65.-36.58.54.53.-56.60.27.108.70.61.58.47.-37.60.78.67.-47.-67.-108.-28.-3.-69.-30.61.-89.-67.124.-103.-104.61.-44.-120.94.60.19.5.-105.60.-70.25.16.61.-107.122.-84.59.44.-103.-44.-68.72.-93.-31.-67.11.-47.97.-67.-54.92.-91.-67.-74.-119.-35.-67.55.1.-111.61.-6.-29.80.61.-36.0.13.-68.-25.-118.8.-68.102.26.19.-66.-27.57.33.-67.6.-82.48.60.-14.92.-119.-67.-78.34.56.60.-103.9.9.62.-49.4.-8.-68.40.47.58.61.-55.-97.-73.60.83.-13.20.-67.-122.22.4.60.107.121.-88.-67.-77.-30.-58.-68.60.84.-48.60.74.-103.-48.-68.-56.-74.-114.60.-109.-106.-64.60.-120.25.-126.57.-77.99.-65.-68.-35.37.23.61.-80.-51.-76.59.-101.-95.-35.59.-115.-58.-100.60.-78.80.-69.-67.19.109.93.57.57.115.-80.61.-18.28.47.-68.-48.24.43.-68.-72.-128.54.61.-89.101.17.-66.9.-39.-127.61.-105.-8.-35.-68.62.-31.15.-69.95.-121.98.-68.-75.11.103.61.101.126.9.57.118.107.-115.-68.107.-115.74.-67.-79.34.-31.-67.48.6.8.61.-73.4.-111.-67.112.-3.-79.-72.-41.54.-56.-67.42.-56.8.62.-19.-82.-14.-67.25.64.-120.-67.-27.88.-86.-67.121.-16.-50.-67.30.-104.-85.-67.-99.-72.-79.60.-6.2.-92.60.89.-91.54.60.-2.99.-103.-69.3.100.-44.-67.44.-42.65.-67.91.24.1.60.69.33.3.61.60.12.-80.59.115.10.-47.-67.-87.-32.104.-69.51.9.-69.-67.-5.11.49.-68.-65.-59.81.60.-126.-22.-12.-68.-9.126.-75.-67.-63.-97.-72.-68.-113.-5.-65.61.-29.56.11.-66.25.61.66.-67.-29.-4.-101.61.68.45.-82.-67.30.-96.108.-69.58.-11.53.-67.124.-122.5.62.68.25.12.61.75.-99.60.-67.-65.8.84.59.-26.38.-9.61.-89.95.83.61.-121.68.111.-70.48.-71.59.-67.15.28.96.60.118.112.-58.-68.-117.100.-102.-67.80.66.-55.-67.39.-55.-92.-67.-124.-30.3.62.76.-51.110.-68.-23.67.68.-68.125.28.84.61.19.-91.59.-69.-91.-102.-85.-68.93.-21.-95.-67.-108.-35.113.-67.-29.-83.-79.61.5.-120.3.-67.38.18.12.61.-101.122.39.-67.99.-113.75.-67.-125.-93.93.61.-73.25.-10.59.-22.86.-81.61.-10.86.-30.-67.105.120.-30.-67.8.-57.74.-67.-110.82.-82.-67.-103.-31.55.61.-57.37.-125.61.76.16.-123.-67.73.115.96.-67.121.-114.-13.61.-40.-14.-86.61.-124.-29.-105.-68.96.-31.-5.-69.69.-45.63.61.102.-54.6.61.82.26.-79.60.-125.-9.-45.-68.61.-16.-16.-67.');
INSERT INTO `faceinfo` VALUES ('FACE_vOvESAQwmj', 'face_imgf9725418-6ff9-4c50-b520-afd834ccb4c2.jpg', 'C:\\ai\\face\\', '0.0.-6.68.0.0.116.67.-8.-83.21.-67.-33.-24.109.58.82.103.-105.-68.-98.3.-37.61.-28.-110.-76.61.13.-77.-97.-67.-2.60.26.-68.13.0.27.-66.-123.109.-124.-67.-100.-95.110.-67.-57.123.-47.-67.56.21.26.61.-100.-65.-95.-67.111.96.9.61.122.70.31.-67.-107.-102.12.61.126.-70.-108.-68.73.-25.-12.60.2.-5.-3.60.4.-32.-86.61.-73.-59.16.-69.-103.43.77.61.-77.-125.76.-67.23.95.-121.-69.75.-56.-127.-67.42.-107.0.-66.20.-17.-74.61.-125.59.-101.-68.-18.-76.-114.60.112.74.-31.-67.42.-53.-74.-68.-57.85.-11.60.-61.-58.-122.60.9.-101.-78.59.124.123.38.-67.-81.-96.45.-68.-68.53.-107.-68.89.-56.69.60.-28.0.58.-67.48.-31.-108.-67.13.-126.-95.-67.88.-103.59.-67.8.125.9.61.26.6.-55.61.111.-36.-47.61.-19.9.-74.60.-115.-19.-52.59.-74.122.-73.-67.-68.-65.-102.-67.-13.-42.46.61.-66.-45.89.61.-85.-53.-27.60.9.-6.-79.59.38.44.-110.60.-58.-61.-90.-67.-22.87.3.61.-72.105.-121.60.15.-69.50.-68.-62.-118.8.-67.45.55.31.61.60.60.96.-68.98.-53.87.61.-11.40.8.60.-65.-101.121.61.121.-111.-122.-68.-90.86.-13.-68.-81.-47.-69.-68.-6.-36.7.61.79.49.2.59.-110.117.28.-67.44.-43.28.61.21.39.-87.-69.-107.-94.1.-68.34.64.16.61.19.-98.-107.61.-63.-61.77.-67.48.10.-49.60.-21.-120.-84.-68.45.52.-113.-68.-126.-69.-10.-67.-18.18.39.-66.-7.9.59.-67.-27.1.-111.60.-128.58.28.-66.115.78.-92.-67.-18.107.-99.-68.38.-17.-121.61.-15.-45.4.-68.25.98.36.-68.45.22.39.-70.116.-27.18.-67.27.86.2.60.-100.-117.119.-68.5.83.100.-67.81.115.-44.-67.-16.32.-128.60.20.-14.19.-67.103.-109.15.59.31.124.-32.-69.-32.7.-68.60.-98.-121.25.61.-38.66.-8.-68.78.113.-81.60.51.126.-81.60.-121.92.94.60.55.-55.-28.-68.20.86.-14.-70.83.-120.19.62.-83.87.-52.-68.78.-126.31.-67.-110.12.114.-67.-111.101.-100.58.22.-47.13.-67.-62.73.-100.60.111.64.-105.60.-55.-93.-101.61.-102.52.93.61.-35.58.20.-67.81.76.-87.61.-56.10.75.-69.-100.-61.-80.59.-85.-117.-83.-67.96.38.-109.61.44.21.39.-67.48.68.-104.61.16.90.-121.61.91.6.46.-67.-98.46.31.60.-104.8.103.61.-82.13.10.59.-121.120.115.61.84.7.-58.61.89.11.32.-67.72.-62.-35.-72.-14.-45.-124.60.-57.-12.3.60.2.4.17.-67.18.102.-51.61.-2.49.-59.60.54.88.-65.-72.-57.-89.-120.61.8.98.2.62.-2.-110.-1.-67.-97.87.-6.-68.-96.68.-7.59.-27.71.-112.-67.-107.-81.-79.61.-103.75.-123.-67.-84.-21.-109.-68.-128.78.113.60.-76.-120.12.-67.109.112.-15.59.-8.-64.-54.-67.-105.103.-47.-69.35.100.-34.61.6.-73.-127.61.-91.48.20.-67.55.1.-108.60.5.29.-102.60.45.-39.95.-67.-50.-112.-46.-67.99.5.23.-67.-13.47.-85.61.-60.-87.95.60.-123.23.121.60.30.39.-52.61.-35.91.-19.-67.-109.89.86.-69.-41.7.11.61.-25.17.93.-68.14.24.106.-67.-81.-111.5.-67.-63.-37.100.-67.71.59.85.-67.-116.-58.-96.-69.117.20.26.-68.46.-34.75.61.-35.-100.-7.60.35.93.67.-68.-105.11.-71.-68.60.82.-23.-67.-54.-121.10.62.45.33.-70.-69.-103.83.12.-68.22.-63.-52.-68.73.-12.-110.61.-105.5.-127.59.25.-55.48.61.-126.-56.-65.61.-46.49.-115.61.-122.-2.23.-68.-13.48.-12.-67.-66.3.19.-66.-118.115.-79.-67.55.-10.-107.61.-48.-15.25.61.86.-88.-67.60.-60.65.-128.61.-111.-66.-81.-67.114.98.-104.61.-78.74.41.-67.-55.-88.-36.-68.41.-21.-95.61.15.81.-117.-67.-76.38.44.62.28.-19.112.60.4.-34.-101.-67.-67.-54.31.-67.-103.104.12.61.-94.99.-15.-68.30.44.15.62.-80.-45.111.-68.119.-47.0.-67.102.-123.62.62.2.5.113.-67.-54.-103.-125.61.-121.2.-3.61.51.-110.108.61.28.-104.-18.59.-59.-55.-121.-67.-93.101.52.-67.58.-38.-80.61.-54.-127.-19.59.-110.-76.-12.-67.38.67.63.-67.25.113.-88.61.109.-72.-109.-67.-38.-46.106.-68.71.59.-67.-67.-70.7.-101.61.48.-115.11.-68.50.-91.86.61.118.37.-91.-68.97.-98.77.-67.8.-52.90.-67.57.-62.20.-67.-79.54.-11.-67.26.44.46.-67.-41.88.6.-67.-64.-115.-124.-67.125.-34.5.62.75.-102.-105.-68.55.26.82.61.-35.-85.-31.-67.24.13.112.60.-39.50.108.-69.-4.12.12.-67.-94.-31.-50.60.-121.-51.-81.61.78.79.76.61.-15.64.-107.60.-24.-70.109.-67.-3.101.-22.-67.66.63.23.-66.-55.22.121.-67.-108.-126.-89.59.');

-- ----------------------------
-- Table structure for pay_records
-- ----------------------------
DROP TABLE IF EXISTS `pay_records`;
CREATE TABLE `pay_records`  (
  `pay_record_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cashier_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `amount` int(11) NOT NULL,
  `money` decimal(10, 0) NOT NULL,
  `pay_time` timestamp(0) NULL DEFAULT NULL,
  `description` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pay_record_id`) USING BTREE,
  INDEX `cashier_id`(`cashier_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `pay_records_ibfk_1` FOREIGN KEY (`cashier_id`) REFERENCES `cashiers` (`cashier_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `pay_records_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `pay_records_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_classes
-- ----------------------------
DROP TABLE IF EXISTS `product_classes`;
CREATE TABLE `product_classes`  (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `product_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `p_name` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `class_id` int(11) NOT NULL,
  `sale` decimal(10, 0) NOT NULL,
  `p_surplus` int(11) NOT NULL,
  PRIMARY KEY (`product_id`) USING BTREE,
  INDEX `class_id`(`class_id`) USING BTREE,
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `product_classes` (`class_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for room_orders
-- ----------------------------
DROP TABLE IF EXISTS `room_orders`;
CREATE TABLE `room_orders`  (
  `room_order_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sale` decimal(10, 0) NOT NULL,
  `book_time` timestamp(0) NULL DEFAULT NULL,
  `start_time` timestamp(0) NULL DEFAULT NULL,
  `end_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`room_order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `room_orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_permissions`;
CREATE TABLE `sys_permissions`  (
  `permission_id` int(11) NOT NULL,
  `available` int(11) NOT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `permission` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource_type` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permissions
-- ----------------------------
INSERT INTO `sys_permissions` VALUES (1, 1, '超级管理', 'admin:supervise', 'menu', '/text/**');
INSERT INTO `sys_permissions` VALUES (2, 1, '用户管理', 'user:all', 'menu', 'text/user/**');
INSERT INTO `sys_permissions` VALUES (3, 1, '识别摄像', 'user:detectFace', 'menu', 'text/v/cap');
INSERT INTO `sys_permissions` VALUES (5, 1, '用户删除', 'user:del', 'menu', 'text/user/del');
INSERT INTO `sys_permissions` VALUES (6, 1, '用户修改', 'user:update', 'menu', 'text/user/update');
INSERT INTO `sys_permissions` VALUES (7, 1, '用户查询', 'user:del', 'menu', 'text/user/select');
INSERT INTO `sys_permissions` VALUES (8, 1, '用户增加', 'user:add', 'menu', 'text/user/add');
INSERT INTO `sys_permissions` VALUES (9, 1, '删除账单', 'vip:bill:del', 'menu', 'text/v/bill/del');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` int(11) NOT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  `permission_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `permission_id`(`permission_id`) USING BTREE,
  CONSTRAINT `sys_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_roles` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sys_role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `sys_permissions` (`permission_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, 1, 2);
INSERT INTO `sys_role_permission` VALUES (2, 2, 2);
INSERT INTO `sys_role_permission` VALUES (3, 3, 5);
INSERT INTO `sys_role_permission` VALUES (4, 3, 6);
INSERT INTO `sys_role_permission` VALUES (5, 3, 7);
INSERT INTO `sys_role_permission` VALUES (6, 3, 8);
INSERT INTO `sys_role_permission` VALUES (7, 2, 9);

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles`  (
  `role_id` int(11) NOT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `available` int(11) NOT NULL,
  `description` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
INSERT INTO `sys_roles` VALUES (1, 'admin', 1, '管理员');
INSERT INTO `sys_roles` VALUES (2, 'vip', 1, '贵宾用户');
INSERT INTO `sys_roles` VALUES (3, 'user', 1, '普通用户');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  `user_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_roles` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('7bBtdX2jO', 3, 'USER6mX3dlE5rM');
INSERT INTO `sys_user_role` VALUES ('kNABf4kzB', 3, 'USERkCsVr53q7Y');
INSERT INTO `sys_user_role` VALUES ('RU002', 1, 'USER0001');
INSERT INTO `sys_user_role` VALUES ('RU0023', 2, 'USER0001');
INSERT INTO `sys_user_role` VALUES ('RU9934', 3, 'USER00002');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `real_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` int(11) NULL DEFAULT NULL,
  `head_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `faceInfo_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birth_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IDcard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(240) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `signature` varchar(260) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `faceInfo_id`(`faceInfo_id`) USING BTREE,
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`faceInfo_id`) REFERENCES `faceinfo` (`faceinfo_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('USER00002', 'lhb', '0dc86c0e8ad07ffc4120ac72f6e68898', '96e7313f-525b-4f98-9fc3-6b62a7d83500', '梁海彬', 1, NULL, 21, 'bbbb', '1998-07-30', '165153153', '15123512', '', '四川遂宁', '无');
INSERT INTO `users` VALUES ('USER0001', 'hxd', '2b8c00a9663b669235ac28e1cb1fcfb6', '001a6a01-f38e-4752-8a48-f153e755b5f2', '何旭东', 1, 'F://asdf', 22, 'aaaa', '1997-06-13', '1313113', '1321321', '', '四川巴中', '无');
INSERT INTO `users` VALUES ('USER6mX3dlE5rM', 'lisi', '2888edf03e07ba73d6d44a8944f5c0ef', 'fg3imph', '李四', 0, 'C:\\ai\\head\\head_img1a61d408-26bf-4efb-9f36-1136ecf10054.jpg', 0, 'FACE_vOvESAQwmj', NULL, '513723162354627748', '13069994834', '737382837@qq.com', '美国洛杉矶好莱坞', '');
INSERT INTO `users` VALUES ('USERkCsVr53q7Y', 'zhangsan ', '53c7003993321cb8f79a2ebff2cf728b', 'wpjUwPP', '张三', 0, 'C:\\ai\\head\\head_imgbb843d59-a1cc-4676-9bb2-a65d093a42db.jpg', 0, 'FACE_Om0WO0QHGd', NULL, '513723162354627748', '13069994834', '737382837@qq.com', '日本东京', '');

-- ----------------------------
-- Table structure for vip_info
-- ----------------------------
DROP TABLE IF EXISTS `vip_info`;
CREATE TABLE `vip_info`  (
  `vip_id` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` timestamp(0) NULL DEFAULT NULL,
  `end_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`vip_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `vip_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
