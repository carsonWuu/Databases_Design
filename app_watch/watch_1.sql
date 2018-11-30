/*
 Navicat MySQL Data Transfer

 Source Server         : 120.78.221.142
 Source Server Type    : MySQL
 Source Server Version : 50614
 Source Host           : 120.78.221.142:3306
 Source Schema         : watch

 Target Server Type    : MySQL
 Target Server Version : 50614
 File Encoding         : 65001

 Date: 30/11/2018 15:28:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for APP_information
-- ----------------------------
DROP TABLE IF EXISTS `APP_information`;
CREATE TABLE `APP_information`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `C_password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `C_Phone_number` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `c_Profilephoto` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像url',
  `C_Nickname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `N_Sex` tinyint(4) NULL DEFAULT NULL COMMENT '性别：男/女/未知',
  `c_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最新的坐标经纬度',
  `date_birthday` datetime(0) NULL DEFAULT NULL COMMENT '出生日期',
  PRIMARY KEY (`n_id`) USING BTREE,
  UNIQUE INDEX `ukey`(`c_userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Bind
-- ----------------------------
DROP TABLE IF EXISTS `Bind`;
CREATE TABLE `Bind`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_watch_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备用户ID',
  `c_app_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'app用户ID',
  PRIMARY KEY (`n_id`) USING BTREE,
  UNIQUE INDEX `relation`(`c_watch_userID`, `c_app_userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Command
-- ----------------------------
DROP TABLE IF EXISTS `Command`;
CREATE TABLE `Command`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指令发起者ID',
  `c_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指令具体内容',
  `n_time` int(15) NULL DEFAULT NULL COMMENT '指令发起时间(时间戳)',
  PRIMARY KEY (`n_id`) USING BTREE,
  UNIQUE INDEX `ukey`(`c_userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Friends
-- ----------------------------
DROP TABLE IF EXISTS `Friends`;
CREATE TABLE `Friends`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_userID1` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '好友关系人1',
  `c_userID2` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '好友关系人2',
  `c_alias` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'userID1存储的别称',
  PRIMARY KEY (`n_id`) USING BTREE,
  UNIQUE INDEX `ukey`(`c_userID1`, `c_userID2`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Group_chat
-- ----------------------------
DROP TABLE IF EXISTS `Group_chat`;
CREATE TABLE `Group_chat`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_groupOwner` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '群主ID',
  `c_groupID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '群组ID',
  `c_groupNAME` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '群组名称',
  PRIMARY KEY (`n_id`) USING BTREE,
  UNIQUE INDEX `group_index`(`c_groupID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Group_member
-- ----------------------------
DROP TABLE IF EXISTS `Group_member`;
CREATE TABLE `Group_member`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_groupID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '群组ID',
  `c_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '群成员ID',
  `n_type` tinyint(4) NULL DEFAULT NULL COMMENT '标识群成员设备',
  PRIMARY KEY (`n_id`) USING BTREE,
  UNIQUE INDEX `group_index`(`c_groupID`, `c_userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Location_readable
-- ----------------------------
DROP TABLE IF EXISTS `Location_readable`;
CREATE TABLE `Location_readable`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手表ID',
  `n_loctype` tinyint(4) NULL DEFAULT NULL COMMENT '定位类型：1.GPS，2.WiFi，3.模糊定位，4.a-gps定位，5.加速传感器定位',
  `n_lng` double NULL DEFAULT NULL COMMENT '经度',
  `n_lat` double NULL DEFAULT NULL COMMENT '纬度',
  `n_time` int(15) NULL DEFAULT NULL COMMENT '坐标上传时间(时间戳)',
  PRIMARY KEY (`n_id`) USING BTREE,
  UNIQUE INDEX `ukey`(`c_userID`, `n_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Location_unreadable
-- ----------------------------
DROP TABLE IF EXISTS `Location_unreadable`;
CREATE TABLE `Location_unreadable`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手表ID',
  `n_loctype` tinyint(4) NULL DEFAULT NULL COMMENT '定位类型：1.GPS，2.WiFi，3.模糊定位，4.a-gps定位，5.加速传感器定位',
  `c_lng_lat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原始数据，待转换为标准经纬度',
  `n_time` int(15) NULL DEFAULT NULL COMMENT '坐标上传时间(时间戳)',
  PRIMARY KEY (`n_id`) USING BTREE,
  INDEX `ukey`(`c_userID`, `n_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Login
-- ----------------------------
DROP TABLE IF EXISTS `Login`;
CREATE TABLE `Login`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `n_type` tinyint(4) NULL DEFAULT NULL COMMENT '设备类型：1APP、2watch',
  PRIMARY KEY (`n_id`) USING BTREE,
  UNIQUE INDEX `ukey`(`c_userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Message
-- ----------------------------
DROP TABLE IF EXISTS `Message`;
CREATE TABLE `Message`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_fromID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送消息的ID',
  `n_from_type` tinyint(4) NULL DEFAULT NULL COMMENT '标识发送方的设备，1手机APP 、2手表watch',
  `n_type` tinyint(4) NULL DEFAULT NULL COMMENT '消息类型：1为文字，2为语音，3为表情包',
  `c_toID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收消息的ID',
  `c_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  `c_voiceurl` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '语音文件地址',
  `n_createtime` int(15) NULL DEFAULT NULL COMMENT '消息时间(时间戳)',
  `n_to_type` tinyint(4) NULL DEFAULT NULL COMMENT '标识接收方的设备，1手机APP 、2手表watch',
  PRIMARY KEY (`n_id`) USING BTREE,
  INDEX `index_message`(`c_toID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Phone_address
-- ----------------------------
DROP TABLE IF EXISTS `Phone_address`;
CREATE TABLE `Phone_address`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'watch用户ID',
  `c_familyID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通讯录家人ID',
  `c_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注名称',
  `c_photourl` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通讯录家人头像地址',
  `n_open` tinyint(4) NULL DEFAULT NULL COMMENT '自动接通设置：1为自动接通,0为不自动接通',
  `n_shortcode` int(15) NULL DEFAULT NULL COMMENT '设备与通讯录家人之间的短号',
  PRIMARY KEY (`n_id`) USING BTREE,
  UNIQUE INDEX `ukey`(`c_userID`, `c_familyID`) USING BTREE,
  UNIQUE INDEX `ukey2`(`c_userID`, `n_shortcode`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Shortcode
-- ----------------------------
DROP TABLE IF EXISTS `Shortcode`;
CREATE TABLE `Shortcode`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'watch用户ID',
  `text_shortcode` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '手表短号：{number:userID,number2:userID2,..,}:{662:18011221133,}',
  PRIMARY KEY (`n_id`) USING BTREE,
  UNIQUE INDEX `relation`(`c_userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Stranger
-- ----------------------------
DROP TABLE IF EXISTS `Stranger`;
CREATE TABLE `Stranger`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'watch用户ID',
  `c_stranger` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '陌生人手机号码',
  `text_detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '来电详情',
  `n_time` int(15) NULL DEFAULT NULL COMMENT '最近来电(时间戳)',
  PRIMARY KEY (`n_id`) USING BTREE,
  INDEX `ukey`(`c_userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Suggestion
-- ----------------------------
DROP TABLE IF EXISTS `Suggestion`;
CREATE TABLE `Suggestion`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `c_suggest` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户反馈的意见，限制255个汉字',
  `n_suggest` int(15) NULL DEFAULT NULL COMMENT '反馈时间(时间戳)',
  PRIMARY KEY (`n_id`) USING BTREE,
  INDEX `relation`(`c_userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Verification
-- ----------------------------
DROP TABLE IF EXISTS `Verification`;
CREATE TABLE `Verification`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `c_verifyCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机验证码',
  `n_time` int(15) NULL DEFAULT NULL COMMENT '验证时间(时间戳)',
  PRIMARY KEY (`n_id`) USING BTREE,
  UNIQUE INDEX `ukey`(`c_userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for Watch_history
-- ----------------------------
DROP TABLE IF EXISTS `Watch_history`;
CREATE TABLE `Watch_history`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'watch用户ID',
  `c_title` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息标题，如：充电完成、设置变更、紧急求助、上课禁用、上学守护、陌生来电等',
  `c_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  `t_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '手表消息时间',
  PRIMARY KEY (`n_id`) USING BTREE,
  INDEX `ukey`(`c_userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for White_list
-- ----------------------------
DROP TABLE IF EXISTS `White_list`;
CREATE TABLE `White_list`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `c_white_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '白名单用户',
  PRIMARY KEY (`n_id`) USING BTREE,
  INDEX `relation`(`c_userID`, `c_white_userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for watch_device
-- ----------------------------
DROP TABLE IF EXISTS `watch_device`;
CREATE TABLE `watch_device`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增变量',
  `c_userID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'watch用户ID',
  `C_password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'watch用户密码',
  `C_Phone_number` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `C_deviceIMEI` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备IMEI',
  `C_phoneIMSI` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'SIM卡IMSI',
  `n_devicetype` tinyint(4) NULL DEFAULT NULL COMMENT '设备类型：1为手表，2为功能机，3为其他',
  `C_version` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '固件版本',
  `c_Profilephoto` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像url',
  `C_Nickname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `N_Sex` tinyint(4) NULL DEFAULT NULL COMMENT '性别：男/女',
  `date_birthday` datetime(0) NULL DEFAULT NULL COMMENT '出生日期',
  `C_grade` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年级',
  `n_height` double NULL DEFAULT NULL COMMENT '身高cm',
  `n_weight` double NULL DEFAULT NULL COMMENT '体重kg',
  `c_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最新的坐标经纬度',
  `C_homeAddress` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭地址',
  `C_homedetail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭地址描述',
  `C_home_location` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭地址坐标',
  `C_home_range` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭地址定位范围',
  `C_schoolAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校地址',
  `C_schooldetail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校地址描述',
  `C_school_location` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校地址坐标',
  `C_school_range` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校地址定位范围',
  `n_cometime` int(15) NULL DEFAULT NULL COMMENT '上学时间(时间戳)',
  `n_leavetime` int(15) NULL DEFAULT NULL COMMENT '放学时间(时间戳)',
  `text_device` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '设置的开关：1通话位置、2设置变更、3手表电量（预留电量）、4通讯录\r\r\n消息、5紧急求助、6守护记录、7安全提醒、8手表话费、9定时开关机（是否启用,具体开关机时间）',
  `text_manage` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '管理开关：1上课禁用、2拒接陌生人、3安全守护、4通话位置、5作息提醒\r\r\n、6代收短信、7自动接通、8定时开关机、9接触绑定、10固件版本、11计步开关,上课禁用、安全守护、\r\r\n作息提醒、定时开关机等设置有设置参数',
  `c_sport` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运动计步：将每天的步数记录',
  `text_watch` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '手表设置：1铃声音量、2屏幕亮度、3时间格式、4体感接听、5定位模式、6\r\r\n手表短号',
  PRIMARY KEY (`n_id`) USING BTREE,
  UNIQUE INDEX `ukey`(`c_userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of watch_device
-- ----------------------------
INSERT INTO `watch_device` VALUES (1, 'userID', NULL, 'gf', 'dfg', 'fgd', 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '中南海花园', '北京市xx路163号', '116.46,39.92', '200m,1000m', '中南海小学', '深圳市xx路163号', '116.46,39.92', '100m,200m', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `watch_device` VALUES (2, 's', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `watch_device` VALUES (4, 'ss', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Procedure structure for App_friends_add
-- ----------------------------
DROP PROCEDURE IF EXISTS `App_friends_add`;
delimiter ;;
CREATE PROCEDURE `App_friends_add`(in userid1 varchar(40),
	in userid2 varchar(40),
	in alias varchar(40))
  SQL SECURITY INVOKER
begin 
insert into Friends(c_userID1,c_userID2,c_alias) values(userid1,userid2,alias);
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for App_friends_show
-- ----------------------------
DROP PROCEDURE IF EXISTS `App_friends_show`;
delimiter ;;
CREATE PROCEDURE `App_friends_show`(in  userID1 varchar(40))
  SQL SECURITY INVOKER
begin 
select c_userID2,c_alias from Friends where c_userID1 = userID1 ;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for App_info
-- ----------------------------
DROP PROCEDURE IF EXISTS `App_info`;
delimiter ;;
CREATE PROCEDURE `App_info`(in  idin varchar(40),
	out phone varchar(15),
	out Profilephoto varchar(200),	
	out Nickname Varchar(40) ,
	out Sex tinyint ,
	out birthday datetime ,
	out location varchar(255))
  SQL SECURITY INVOKER
begin  
select 
C_Phone_number
,c_Profilephoto
,C_Nickname
,N_Sex
,date_birthday
,c_location


  
from APP_information where c_userID = idin  
into    
	phone,
	Profilephoto,
	Nickname,
	Sex,
	birthday,
	location;
	

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for App_update_birth
-- ----------------------------
DROP PROCEDURE IF EXISTS `App_update_birth`;
delimiter ;;
CREATE PROCEDURE `App_update_birth`(in  idin varchar(40),
	
	in birth datetime)
  SQL SECURITY INVOKER
begin  
update APP_information set date_birthday  = birth where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for App_update_location
-- ----------------------------
DROP PROCEDURE IF EXISTS `App_update_location`;
delimiter ;;
CREATE PROCEDURE `App_update_location`(in  idin varchar(40),
	
	in location  varchar(255))
  SQL SECURITY INVOKER
begin  
update APP_information set c_location  = location  where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for App_update_nickname
-- ----------------------------
DROP PROCEDURE IF EXISTS `App_update_nickname`;
delimiter ;;
CREATE PROCEDURE `App_update_nickname`(in  idin varchar(40),
	
	in name varchar(40))
  SQL SECURITY INVOKER
begin  
update APP_information set C_Nickname = name  where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for App_update_password
-- ----------------------------
DROP PROCEDURE IF EXISTS `App_update_password`;
delimiter ;;
CREATE PROCEDURE `App_update_password`(in  idin varchar(40),
	
	in passw varchar(40))
  SQL SECURITY INVOKER
begin  
update APP_information set C_password =passw where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for App_update_phone
-- ----------------------------
DROP PROCEDURE IF EXISTS `App_update_phone`;
delimiter ;;
CREATE PROCEDURE `App_update_phone`(in  idin varchar(40),
	
	in phone varchar(15))
  SQL SECURITY INVOKER
begin  
update APP_information set C_Phone_number  = phone  where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for App_update_profilephoto
-- ----------------------------
DROP PROCEDURE IF EXISTS `App_update_profilephoto`;
delimiter ;;
CREATE PROCEDURE `App_update_profilephoto`(in  idin varchar(40),
	
	in photo varchar(40))
  SQL SECURITY INVOKER
begin  
update APP_information set c_Profilephoto =photo where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for App_update_sex
-- ----------------------------
DROP PROCEDURE IF EXISTS `App_update_sex`;
delimiter ;;
CREATE PROCEDURE `App_update_sex`(in  idin varchar(40),
	
	in sex tinyint)
  SQL SECURITY INVOKER
begin  
update APP_information set N_Sex = sex where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Bind_add
-- ----------------------------
DROP PROCEDURE IF EXISTS `Bind_add`;
delimiter ;;
CREATE PROCEDURE `Bind_add`(in  watch_userid varchar(40),
	in  app_user varchar(40))
  SQL SECURITY INVOKER
begin  
insert into Bind(c_watch_userID,c_app_userID) values(watch_userid ,app_user);

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Bind_App_find
-- ----------------------------
DROP PROCEDURE IF EXISTS `Bind_App_find`;
delimiter ;;
CREATE PROCEDURE `Bind_App_find`(in  app_user varchar(40))
  SQL SECURITY INVOKER
begin  
select  c_watch_userID   from Bind  where c_app_userID  = app_user;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Bind_delete
-- ----------------------------
DROP PROCEDURE IF EXISTS `Bind_delete`;
delimiter ;;
CREATE PROCEDURE `Bind_delete`(in  watch_userid varchar(40),
	in  app_user varchar(40))
  SQL SECURITY INVOKER
begin  
delete from  Bind where c_watch_userID = watch_userid and c_app_userID = app_user;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Bind_Device_find
-- ----------------------------
DROP PROCEDURE IF EXISTS `Bind_Device_find`;
delimiter ;;
CREATE PROCEDURE `Bind_Device_find`(in  userid varchar(40))
  SQL SECURITY INVOKER
begin  
select  c_app_userID   from Bind  where c_watch_userID  = userid;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_address_add
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_address_add`;
delimiter ;;
CREATE PROCEDURE `Device_address_add`(in  userid varchar(40),
	in familyid varchar(40),
	in name varchar(40),
	in photourl varchar(200))
  SQL SECURITY INVOKER
begin  
insert into Phone_address( c_userID,c_familyID,c_name,c_photourl)  values( userid,familyid,name,photourl);

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_address_autorecv_update
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_address_autorecv_update`;
delimiter ;;
CREATE PROCEDURE `Device_address_autorecv_update`(in  userid varchar(40),
	in  familyid varchar(40),
	in  open tinyint)
  SQL SECURITY INVOKER
begin  
update Phone_address set n_open = open where c_userID  = userid and c_familyID = familyid;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_address_delete
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_address_delete`;
delimiter ;;
CREATE PROCEDURE `Device_address_delete`(in  userid varchar(40),
	in  familyid varchar(40))
  SQL SECURITY INVOKER
begin  
delete from  Phone_address where c_userID  = userid and   c_familyID  = familyid ;   

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_address_exist
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_address_exist`;
delimiter ;;
CREATE PROCEDURE `Device_address_exist`(in  userid varchar(40),
	in  familyid varchar(40),
	out id varchar(40),
	out name varchar(40))
  SQL SECURITY INVOKER
begin  
select c_familyID,c_name from  phone_address  where c_userID  = userid and c_familyID=familyid 
 into id,name;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_address_shortcode_update
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_address_shortcode_update`;
delimiter ;;
CREATE PROCEDURE `Device_address_shortcode_update`(in  userid varchar(40),
	in  familyid varchar(40),
	in  shortcode int(15))
  SQL SECURITY INVOKER
begin  
update  Phone_address set n_shortcode = shortcode  where c_userID  = userid and   c_familyID  = familyid ;   

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_address_show
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_address_show`;
delimiter ;;
CREATE PROCEDURE `Device_address_show`(in  userid varchar(40))
  SQL SECURITY INVOKER
begin  
select c_familyID,c_name,c_photourl ,n_open, n_shortcode from  Phone_address  where c_userID  = userid ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_info
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_info`;
delimiter ;;
CREATE PROCEDURE `Device_info`(in  idIn varchar(40),
	
	out phone varchar(15),
	out deviceIMEI varchar(20),	
	out phoneIMSI varchar(20),	
	out devicetype tinyint,
	out version Varchar(40),
	out Profilephoto varchar(200),
	out Nickname Varchar(40) ,
	out Sex tinyint ,
	out birthday datetime ,
	out grade Varchar(15) ,
	out height double ,
	out weight double ,
	out location varchar(255) ,

	out homeAddress varchar(255) ,
	out homedetail varchar(255) ,
	out home_location varchar(255) ,
	out home_range varchar(255) ,

	out schoolAddress varchar(255) ,
	out schooldetail varchar(255) ,
	out school_location varchar(255) ,
	out school_range varchar(255) ,

	out cometime int(15) ,
	out leavetime int(15))
  SQL SECURITY INVOKER
begin  
select 	

C_Phone_number
,C_deviceIMEI
,C_phoneIMSI
,n_devicetype
,C_version
,c_Profilephoto
,C_Nickname
,N_Sex
,date_birthday
,C_grade
,n_height
,n_weight
,c_location

,C_homeAddress
,homedetail
,home_location
,home_range

,C_schoolAddress
,schooldetail
,school_location
,school_range

,n_cometime
,n_leavetime 
  
from watch_device where c_userID=idIn  
into    
	phone,
	deviceIMEI,
	phoneIMSI, 	
	devicetype,
	version,
	Profilephoto,
	Nickname,
	Sex,
	birthday,
	grade,
	height,
	weight,
	location,

	homeAddress,
	homedetail,
	home_location,
	home_range,

	schoolAddress,
	schooldetail,
	school_location,
	school_range,
	
	cometime,
	leavetime;
	

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_location_add
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_location_add`;
delimiter ;;
CREATE PROCEDURE `Device_location_add`(in  idin varchar(40),
	in loctype tinyint,
	in lng double ,
	in lat double ,
	in time int(15))
  SQL SECURITY INVOKER
begin  
insert into  Location_readable(c_userID ,n_loctype,n_lng,n_lat,n_time) values(idin,loctype , lng, lat ,time) ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_location_latest
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_location_latest`;
delimiter ;;
CREATE PROCEDURE `Device_location_latest`(in  idin varchar(40),
	
	out loctype tinyint,
	out lng double ,
	out lat double ,
	out time int(15))
  SQL SECURITY INVOKER
begin  
select  n_loctype,n_lng,n_lat,n_time  from Location_readable where  c_userID=idin  order by n_id desc limit 1 
into loctype , lng, lat ,time ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_location_origin_add
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_location_origin_add`;
delimiter ;;
CREATE PROCEDURE `Device_location_origin_add`(in  idin varchar(40),
	in loctype tinyint,
	in lng_lat varchar(255) ,
	in time int(15))
  SQL SECURITY INVOKER
begin  
insert into  Location_unreadable(c_userID ,n_loctype,c_lng_lat,n_time) values(idin,loctype , lng_lat ,time) ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_location_origin_latest
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_location_origin_latest`;
delimiter ;;
CREATE PROCEDURE `Device_location_origin_latest`(in  idin varchar(40),
	
	out loctype tinyint,
	out lng_lat varchar(255) ,
	out time int(15))
  SQL SECURITY INVOKER
begin  
select  n_loctype,c_lng_lat,n_time  from Location_unreadable where  c_userID=idin  order by n_id desc limit 1 
into loctype , lng_lat ,time ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_location_origin_period
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_location_origin_period`;
delimiter ;;
CREATE PROCEDURE `Device_location_origin_period`(in  idin varchar(40),
	in start_time int(15),
	in end_time int(15))
  SQL SECURITY INVOKER
begin  
select  n_loctype,c_lng_lat,n_time  from Location_unreadable where  c_userID=idin and n_time>= start_time and n_time<= end_time   ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_location_period
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_location_period`;
delimiter ;;
CREATE PROCEDURE `Device_location_period`(in  idin varchar(40),
	in start_time int(15),
	in end_time int(15))
  SQL SECURITY INVOKER
begin  
select  n_loctype,n_lng,n_lat,n_time  from Location_readable where  c_userID=idin and n_time>= start_time and n_time<= end_time ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_login_islogin
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_login_islogin`;
delimiter ;;
CREATE PROCEDURE `Device_login_islogin`(in idin varchar(40),
	out id varchar(40))
  SQL SECURITY INVOKER
begin  
select  c_userID from Login where  c_userID=idin 
 into id;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_login_off
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_login_off`;
delimiter ;;
CREATE PROCEDURE `Device_login_off`(in  idin varchar(40))
  SQL SECURITY INVOKER
begin  
delete  from Login where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_login_on
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_login_on`;
delimiter ;;
CREATE PROCEDURE `Device_login_on`(in  idin varchar(40),
	
	in type tinyint)
  SQL SECURITY INVOKER
begin  
insert into Login (c_userID,n_type) values(idin,type);

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_manage
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_manage`;
delimiter ;;
CREATE PROCEDURE `Device_manage`(in  idin varchar(40),
	
	out settingout text)
  SQL SECURITY INVOKER
begin  
select text_manage 
  
from watch_device where c_userID=idin  
into    settingout	;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_setting
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_setting`;
delimiter ;;
CREATE PROCEDURE `Device_setting`(in  idin varchar(40),
	out location varchar(255),
	out settingout text)
  SQL SECURITY INVOKER
begin  
select c_location,text_device
  
from watch_device where c_userID=idin  
into   location, settingout	;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_stranger_add
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_stranger_add`;
delimiter ;;
CREATE PROCEDURE `Device_stranger_add`(in  userid varchar(40),
	in  stranger varchar(15),
	in  time int(15),
	in  detail text)
  SQL SECURITY INVOKER
begin  
insert into Stranger(c_userID , c_stranger,n_time,text_detail) values( userid ,stranger,time,detail);

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_stranger_show
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_stranger_show`;
delimiter ;;
CREATE PROCEDURE `Device_stranger_show`(in  userid varchar(40),
	in  starttime int(15),
	in  endtime int(15))
  SQL SECURITY INVOKER
begin  
select c_stranger,n_time,text_detail from  Stranger  where c_userID  = userid and n_time>=starttime and n_time<=endtime;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_stranger_show_latest
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_stranger_show_latest`;
delimiter ;;
CREATE PROCEDURE `Device_stranger_show_latest`(in  userid varchar(40),
	out stranger varchar(15),
	out time int(15),
	out detail text)
  SQL SECURITY INVOKER
begin  
select c_stranger,n_time,text_detail from  Stranger  where c_userID  = userid order by n_id desc limit 1 
into stranger,time,detail;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_birth
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_birth`;
delimiter ;;
CREATE PROCEDURE `Device_update_birth`(in  idin varchar(40),
	
	in birth datetime)
  SQL SECURITY INVOKER
begin  
update watch_device set date_birthday  = birth where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_goschool
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_goschool`;
delimiter ;;
CREATE PROCEDURE `Device_update_goschool`(in  idin varchar(40),
	
	in cometime int(15))
  SQL SECURITY INVOKER
begin  
update watch_device set n_cometime = cometime  where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_grade
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_grade`;
delimiter ;;
CREATE PROCEDURE `Device_update_grade`(in  idin varchar(40),
	
	in grade Varchar(15))
  SQL SECURITY INVOKER
begin  
update watch_device set C_grade = grade  where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_height
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_height`;
delimiter ;;
CREATE PROCEDURE `Device_update_height`(in  idin varchar(40),
	
	in height double)
  SQL SECURITY INVOKER
begin  
update watch_device set n_height = height  where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_homeAddr
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_homeAddr`;
delimiter ;;
CREATE PROCEDURE `Device_update_homeAddr`(in  idin varchar(40),
	
	in homeAddress varchar(40),
	in homedetail  varchar(255),
	in home_location varchar(40),
	in home_range varchar(40))
  SQL SECURITY INVOKER
begin  
update watch_device set C_homeAddress = homeAddress ,C_homedetail=homedetail,C_home_location=home_location,C_home_range=home_range
	 where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_leaveschool
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_leaveschool`;
delimiter ;;
CREATE PROCEDURE `Device_update_leaveschool`(in  idin varchar(40),
	
	in leavetime int(15))
  SQL SECURITY INVOKER
begin  
update watch_device set n_leavetime = leavetime where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_location
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_location`;
delimiter ;;
CREATE PROCEDURE `Device_update_location`(in  idin varchar(40),
	
	in location varchar(255))
  SQL SECURITY INVOKER
begin  
update watch_device set c_location = location  where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_manage
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_manage`;
delimiter ;;
CREATE PROCEDURE `Device_update_manage`(in  idin varchar(40),
	
	in manage text)
  SQL SECURITY INVOKER
begin  
update watch_device set text_manage  = manage where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_nickname
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_nickname`;
delimiter ;;
CREATE PROCEDURE `Device_update_nickname`(in  idin varchar(40),
	
	in name varchar(40))
  SQL SECURITY INVOKER
begin  
update watch_device set C_Nickname = name  where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_password
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_password`;
delimiter ;;
CREATE PROCEDURE `Device_update_password`(in  idin varchar(40),
	
	in passw varchar(40))
  SQL SECURITY INVOKER
begin  
update watch_device set C_password =passw where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_profilephoto
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_profilephoto`;
delimiter ;;
CREATE PROCEDURE `Device_update_profilephoto`(in  idin varchar(40),
	
	in photo varchar(40))
  SQL SECURITY INVOKER
begin  
update watch_device set c_Profilephoto =photo where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_schoolAddr
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_schoolAddr`;
delimiter ;;
CREATE PROCEDURE `Device_update_schoolAddr`(in  idin varchar(40),
	
	in schoolAddress varchar(40),
	in schooldetail  varchar(255),
	in school_location varchar(40),
	in school_range varchar(40))
  SQL SECURITY INVOKER
begin  
update watch_device set C_schoolAddress = schoolAddress ,C_schooldetail=schooldetail,C_school_location=school_location,C_school_range=school_range
	 where  c_userID=idin  ;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_setting
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_setting`;
delimiter ;;
CREATE PROCEDURE `Device_update_setting`(in  idin varchar(40),
	
	in setting text)
  SQL SECURITY INVOKER
begin  
update watch_device set text_device = setting where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_sex
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_sex`;
delimiter ;;
CREATE PROCEDURE `Device_update_sex`(in  idin varchar(40),
	
	in sex tinyint)
  SQL SECURITY INVOKER
begin  
update watch_device set N_Sex = sex where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_watch
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_watch`;
delimiter ;;
CREATE PROCEDURE `Device_update_watch`(in  idin varchar(40),
	
	in watch text)
  SQL SECURITY INVOKER
begin  
update watch_device set text_watch  = watch where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_update_weight
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_update_weight`;
delimiter ;;
CREATE PROCEDURE `Device_update_weight`(in  idin varchar(40),
	
	in weight double)
  SQL SECURITY INVOKER
begin  
update watch_device set n_weight = weight  where  c_userID=idin  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_watch
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_watch`;
delimiter ;;
CREATE PROCEDURE `Device_watch`(in  idin varchar(40),
	
	out settingout text)
  SQL SECURITY INVOKER
begin  
select text_watch 
  
from watch_device where c_userID=idin  
into    settingout	;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_watch_history_add
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_watch_history_add`;
delimiter ;;
CREATE PROCEDURE `Device_watch_history_add`(in  userid varchar(40),
	in  title varchar(40),
	in  message varchar(255))
  SQL SECURITY INVOKER
begin  
insert into Watch_history(c_userID,c_title,c_message) values(userid,title ,message);

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Device_watch_history_show
-- ----------------------------
DROP PROCEDURE IF EXISTS `Device_watch_history_show`;
delimiter ;;
CREATE PROCEDURE `Device_watch_history_show`(in  userid varchar(40))
  SQL SECURITY INVOKER
begin  
select  c_title,c_message,t_time from Watch_history where c_userID  = userid ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for GroupMember_add
-- ----------------------------
DROP PROCEDURE IF EXISTS `GroupMember_add`;
delimiter ;;
CREATE PROCEDURE `GroupMember_add`(in  groupid varchar(40),
	in  userid varchar(40),
	in  type tinyint)
  SQL SECURITY INVOKER
begin  
insert into  Group_member(c_groupID ,c_userID ,n_type) values(groupid,userid ,type ); 

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for GroupMember_exist
-- ----------------------------
DROP PROCEDURE IF EXISTS `GroupMember_exist`;
delimiter ;;
CREATE PROCEDURE `GroupMember_exist`(in  groupid varchar(40),
	in  userid varchar(40),
	out id varchar(40))
  SQL SECURITY INVOKER
begin  
select c_groupID from  Group_member where c_groupID = groupid and   c_userID = userid into id; 

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for GroupMember_find
-- ----------------------------
DROP PROCEDURE IF EXISTS `GroupMember_find`;
delimiter ;;
CREATE PROCEDURE `GroupMember_find`(in  groupid varchar(40),
	out userid varchar(40),
	out type tinyint)
  SQL SECURITY INVOKER
begin  
select c_userID ,n_type   from Group_member   
	where c_groupID = groupid into userid ,type ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for GroupMember_kick
-- ----------------------------
DROP PROCEDURE IF EXISTS `GroupMember_kick`;
delimiter ;;
CREATE PROCEDURE `GroupMember_kick`(in  groupid varchar(40),
	in  userid varchar(40))
  SQL SECURITY INVOKER
begin  
delete from  Group_member where c_groupID = groupid and   c_userID = userid ; 

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Group_create
-- ----------------------------
DROP PROCEDURE IF EXISTS `Group_create`;
delimiter ;;
CREATE PROCEDURE `Group_create`(in  groupowner varchar(40),
	in  groupid varchar(40),
	in groupname varchar(40))
  SQL SECURITY INVOKER
begin  
insert into Group_chat(c_groupOwner ,c_groupID ,c_groupNAME ) values(groupowner  ,groupid,groupname );

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Group_delete
-- ----------------------------
DROP PROCEDURE IF EXISTS `Group_delete`;
delimiter ;;
CREATE PROCEDURE `Group_delete`(in  groupowner varchar(40),
	in  groupid varchar(40))
  SQL SECURITY INVOKER
begin  
delete from  Group_chat where c_groupOwner = groupowner  and c_groupID = groupid ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Group_find
-- ----------------------------
DROP PROCEDURE IF EXISTS `Group_find`;
delimiter ;;
CREATE PROCEDURE `Group_find`(in  groupid varchar(40),
	out groupname varchar(40),
	out id varchar(40),
	out groupowner varchar(40))
  SQL SECURITY INVOKER
begin  
select c_groupOwner ,c_groupID ,c_groupNAME from Group_chat  
	where c_groupID = groupid into groupowner,id,groupname;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Message_add
-- ----------------------------
DROP PROCEDURE IF EXISTS `Message_add`;
delimiter ;;
CREATE PROCEDURE `Message_add`(in fromID varchar(40),
	in from_type tinyint,
	in toID varchar(40),
	in to_type tinyint,
	in type tinyint ,
	in content varchar(500),
	in url varchar(200),
	in time int(15))
  SQL SECURITY INVOKER
begin  
insert into  Message(c_fromID ,n_from_type,c_toID,n_to_type,n_type,c_content,c_voiceurl,n_createtime) values
(fromID,from_type , toID ,to_type,type,content,url,time) ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Message_delete_receive
-- ----------------------------
DROP PROCEDURE IF EXISTS `Message_delete_receive`;
delimiter ;;
CREATE PROCEDURE `Message_delete_receive`(in toID varchar(40))
  SQL SECURITY INVOKER
begin 
delete  from Message where  c_toID = toID  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Message_find
-- ----------------------------
DROP PROCEDURE IF EXISTS `Message_find`;
delimiter ;;
CREATE PROCEDURE `Message_find`(in fromID varchar(40),
	in toID varchar(40))
  SQL SECURITY INVOKER
begin 
select  c_content,n_type,c_voiceurl  from Message where  c_fromID = fromID and c_toID = toID;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Message_find_receive
-- ----------------------------
DROP PROCEDURE IF EXISTS `Message_find_receive`;
delimiter ;;
CREATE PROCEDURE `Message_find_receive`(in toID varchar(40))
  SQL SECURITY INVOKER
begin 
select  c_fromID,c_content,n_type,c_voiceurl  from Message where  c_toID = toID   ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Shortcode_show
-- ----------------------------
DROP PROCEDURE IF EXISTS `Shortcode_show`;
delimiter ;;
CREATE PROCEDURE `Shortcode_show`(in  userid varchar(40),
	out shortcode text)
  SQL SECURITY INVOKER
begin  
select text_shortcode from  Shortcode where  c_userID = userid into shortcode ; 

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Shortcode_update
-- ----------------------------
DROP PROCEDURE IF EXISTS `Shortcode_update`;
delimiter ;;
CREATE PROCEDURE `Shortcode_update`(in  userid varchar(40),
	in  shortcode text)
  SQL SECURITY INVOKER
begin  
update Shortcode set text_shortcode  = shortcode  where  c_userID=userid  ;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Suggestion_add
-- ----------------------------
DROP PROCEDURE IF EXISTS `Suggestion_add`;
delimiter ;;
CREATE PROCEDURE `Suggestion_add`(in  userid varchar(40),
	in  suggest varchar(255),
	in  time int(15))
  SQL SECURITY INVOKER
begin  
insert into Suggestion(c_userID,c_suggest,n_suggest) values(userid,suggest ,time);

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Suggestion_find
-- ----------------------------
DROP PROCEDURE IF EXISTS `Suggestion_find`;
delimiter ;;
CREATE PROCEDURE `Suggestion_find`(in  userid varchar(40))
  SQL SECURITY INVOKER
begin  
select  c_suggest,n_suggest from Suggestion where c_userID  = userid;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Suggestion_find_latest
-- ----------------------------
DROP PROCEDURE IF EXISTS `Suggestion_find_latest`;
delimiter ;;
CREATE PROCEDURE `Suggestion_find_latest`(in  userid varchar(40),
	out suggest varchar(255),
	out time int(15))
  SQL SECURITY INVOKER
begin  
select  c_suggest,n_suggest from Suggestion where c_userID  = userid order by n_id desc limit 1 
into suggest,time;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Verification_add
-- ----------------------------
DROP PROCEDURE IF EXISTS `Verification_add`;
delimiter ;;
CREATE PROCEDURE `Verification_add`(in  idin varchar(40),
	in  verifycode varchar(20),
	in  time int(15))
  SQL SECURITY INVOKER
begin  
insert into Verification(c_userID ,c_verifyCode,n_time) values(idin ,verifycode,time);

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Verification_find
-- ----------------------------
DROP PROCEDURE IF EXISTS `Verification_find`;
delimiter ;;
CREATE PROCEDURE `Verification_find`(in  idin varchar(40),
	out code varchar(20))
  SQL SECURITY INVOKER
begin  
select c_verifyCode  from Verification where c_userID=idin 
into code;

end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
