-- Host: localhost
-- Server version: 8.0.11 MySQL Community Server - GPL
-- 客户端: DataGrip 2020.2.2 x64
-- Date: 27/08/2020 10:05:34
-- ------------------------------------------------------

SET NAMES utf8mb4;

-- Create database:JavaWeb
DROP DATABASE IF EXISTS `JavaWeb`;
CREATE DATABASE JavaWeb;
USE JavaWeb;

-- ----------------------------
-- Table structure for nation_data
-- ----------------------------

DROP TABLE IF EXISTS `nation_data`;
CREATE TABLE `nation_data`  (
  `nation` varchar(20)  NOT NULL,
  `male_Population` int(11) NOT NULL,
  `male_Proportion` float(5,2) NOT NULL,
  `female_Population` int(11) NOT NULL,
  `female_Proportion` float(5,2) NOT NULL,
  `sex_ratio` float(5,2) NOT NULL

) AUTO_INCREMENT = 0 ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nation_data
-- ----------------------------
INSERT INTO `nation_data` (nation, male_Population, male_Proportion, female_Population, female_Proportion, sex_ratio) VALUES ('汉族',625032848,51.20,595811672,48.80,104.90);
INSERT INTO `nation_data` (nation, male_Population, male_Proportion, female_Population, female_Proportion, sex_ratio) VALUES ('壮族',8689488,51.34,8236893,48.66,105.49);
INSERT INTO `nation_data` (nation, male_Population, male_Proportion, female_Population, female_Proportion, sex_ratio) VALUES ('回族',5373741,50.76,5212346,49.24,103.10);
INSERT INTO `nation_data` (nation, male_Population, male_Proportion, female_Population, female_Proportion, sex_ratio) VALUES ('满族',5401812,52.00,4986146,48.00,108.34);
INSERT INTO `nation_data` (nation, male_Population, male_Proportion, female_Population, female_Proportion, sex_ratio) VALUES ('维吾尔族',5097594,50.62,4971752,49.38,102.53);
INSERT INTO `nation_data` (nation, male_Population, male_Proportion, female_Population, female_Proportion, sex_ratio) VALUES ('苗族',4870328,51.67,4555679,48.33,106.91);
INSERT INTO `nation_data` (nation, male_Population, male_Proportion, female_Population, female_Proportion, sex_ratio) VALUES ('彝族',4456382,51.14,4258011,48.86,104.66);
INSERT INTO `nation_data` (nation, male_Population, male_Proportion, female_Population, female_Proportion, sex_ratio) VALUES ('土家族',4307260,51.56,4046652,48.44,106.44);
INSERT INTO `nation_data` (nation, male_Population, male_Proportion, female_Population, female_Proportion, sex_ratio) VALUES ('藏族',3155625,50.23,3126562,49.77,100.93);
INSERT INTO `nation_data` (nation, male_Population, male_Proportion, female_Population, female_Proportion, sex_ratio) VALUES ('蒙古族',2999520,50.14,2982320,49.86,100.58);
INSERT INTO `nation_data` (nation, male_Population, male_Proportion, female_Population, female_Proportion, sex_ratio) VALUES ('侗族',1511959,52.50,1368015,47.50,110.52);

-- ----------------------------
-- Table structure for user
-- ----------------------------

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(20) NOT NULL,
  `password` int(11) NOT NULL,
  `identity` varchar(20) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('root', 123456, 'admin');
INSERT INTO `user` VALUES ('admin1', 234567, 'admin');
INSERT INTO `user` VALUES ('admin2', 345678, 'admin');
INSERT INTO `user` VALUES ('normal1', 456789, 'normal');
INSERT INTO `user` VALUES ('normal2', 567890, 'normal');


