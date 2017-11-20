/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50629
Source Host           : localhost:3306
Source Database       : battcn-plus

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2017-11-20 18:13:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `index_product`
-- ----------------------------
DROP TABLE IF EXISTS `index_product`;
CREATE TABLE `index_product` (
  `index_product_id` varchar(50) NOT NULL,
  `index_product_name` varchar(50) DEFAULT NULL,
  `product_sort` int(11) DEFAULT NULL,
  `product_img_url` varchar(200) DEFAULT NULL,
  `product_short_href` varchar(200) DEFAULT NULL,
  `product_full_href` varchar(200) DEFAULT NULL,
  `flag` int(11) NOT NULL DEFAULT '1',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`index_product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of index_product
-- ----------------------------
INSERT INTO `index_product` VALUES ('1', '产品1', '1', '/imgs/b1.jpg', '#', '#', '1', '2017-11-09 09:30:30', '2017-11-08 17:27:16', '2');
INSERT INTO `index_product` VALUES ('2', '产品2', '2', '/imgs/b2.jpg', '#', '#', '1', '2017-11-09 09:30:31', '2017-11-08 17:27:16', '2');
INSERT INTO `index_product` VALUES ('3', '产品1', '3', '/imgs/b3.jpg', '#', '#', '1', '2017-11-09 09:30:32', '2017-11-08 17:27:16', '2');
INSERT INTO `index_product` VALUES ('4', '产品2', '4', '/imgs/b4.jpg', '#', '#', '1', '2017-11-09 09:30:34', '2017-11-08 17:27:16', '2');
INSERT INTO `index_product` VALUES ('5', '产品1', '1', '/imgs/1.jpg', '#', '#', '1', '2017-11-09 09:30:30', '2017-11-08 17:27:16', '1');
INSERT INTO `index_product` VALUES ('6', '产品2', '2', '/imgs/2.jpg', '#', '#', '1', '2017-11-09 09:30:31', '2017-11-08 17:27:16', '1');
INSERT INTO `index_product` VALUES ('7', '产品1', '3', '/imgs/3.jpg', '#', '#', '1', '2017-11-09 09:30:32', '2017-11-08 17:27:16', '1');
INSERT INTO `index_product` VALUES ('8', '产品2', '4', '/imgs/4.jpg', '#', '#', '1', '2017-11-09 09:30:34', '2017-11-08 17:27:16', '1');

-- ----------------------------
-- Table structure for `products`
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `pro_id` int(5) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(200) DEFAULT NULL,
  `img_url` varchar(200) DEFAULT NULL,
  `parent_id` int(4) DEFAULT NULL,
  `sub_id` int(4) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `gmt_create` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `locked` int(1) DEFAULT '0',
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', 'BL-W1210 1200M五口全千兆智能路由', '/imgs/pro/list1_1.jpg', '1', '2', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('2', 'BL-AC1200D 1200M光纤级双频智能路由HIWiFi版', '/imgs/pro/list1_1.jpg', '1', '2', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('3', 'AC1200U 1200Mbps必联云双频千兆智能路由器', '/imgs/pro/list1_1.jpg', '1', '2', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('4', '必联BL-F300 金属壳高增益智能路由器 HIWiFi版', '/imgs/pro/list1_1.jpg', '1', '3', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('5', '必联BL-D9109 京东微联智能无线路由器', '/imgs/pro/list1_1.jpg', '1', '3', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('6', 'BL-WR316 手机APP管控 WIFI轻松穿墙 无线路由器', '/imgs/pro/list1_1.jpg', '1', '3', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('7', 'BL-AC1200D 1200Mbps 双频智能光纤级路由HIWiFi版', '/imgs/pro/list1_1.jpg', '1', '3', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('8', 'BL-AC1200 双频千兆光纤路由器', '/imgs/pro/list1_1.jpg', '1', '3', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('9', 'BL-360 阿里智能A+WiFi穿墙无线路由器', '/imgs/pro/list1_1.jpg', '1', '3', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('10', 'BL-WR4000 必联云APP智能无线路由器穿墙王', '/imgs/pro/list1_1.jpg', '1', '3', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('11', 'BL-WR361 必联阿里智能新品儿童路由器', '/imgs/pro/list1_1.jpg', '1', '3', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('12', 'BL-AC886M 阿里智能A+安全|稳定|智能云路由', '/imgs/pro/list1_1.jpg', '1', '3', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('13', 'BL-WR4000 阿里智能A+无线路由穿墙王', '/imgs/pro/list1_1.jpg', '1', '3', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('14', 'BL-D9103 V2.0 阿里智能A+安全|稳定|穿墙云路由', '/imgs/pro/list1_1.jpg', '1', '3', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('15', 'BL-855R 稳定智能无线路由器 HIWIFI智能云系统', '/imgs/pro/list1_1.jpg', '1', '3', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('16', 'WiFi信号放大器 BL-WR325', '/imgs/pro/list1_1.jpg', '1', '4', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('17', 'B-LINK RE300 信号放大器/中继器', '/imgs/pro/list1_1.jpg', '1', '4', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('18', 'BL-WR4000 必联微云智能路由器wifi穿墙王', '/imgs/pro/list1_1.jpg', '1', '4', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('19', 'BL-AC450M 穿墙无线路由器', '/imgs/pro/list1_1.jpg', '1', '4', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('20', 'BL-WR9000 300M穿墙无线路由器', '/imgs/pro/list1_1.jpg', '1', '4', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('21', 'BL-D9103 300M无线路由器', '/imgs/pro/list1_1.jpg', '1', '4', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('22', 'BL-AC150 无线AC控制器 营销路由广告WIFI组网专用', '/imgs/pro/list1_1.jpg', '6', '7', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('23', 'BL-AC1500 工业级全千兆 无线AC控制器', '/imgs/pro/list1_1.jpg', '6', '7', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('24', 'BL-AC800 无线AC控制器 AP管理 核心路由器', '/imgs/pro/list1_1.jpg', '6', '7', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('25', 'BL-D7803 AC+AP自适应广告路由器', '/imgs/pro/list1_1.jpg', '6', '7', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('26', 'BL-D7801 300M广告营销路由器', '/imgs/pro/list1_1.jpg', '6', '7', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('27', 'BL-D9101 广告营销路由器 支持微信认证', '/imgs/pro/list1_1.jpg', '6', '7', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('28', 'BL-H750AC AC+AP广告营销路由器', '/imgs/pro/list1_1.jpg', '6', '7', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('29', 'BL-W365AP 工程组网吸顶AP', '/imgs/pro/list1_1.jpg', '6', '8', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('30', 'BL-W360AP POE供电吸顶式无线AP', '/imgs/pro/list1_1.jpg', '6', '8', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('31', 'BL-W362 工程级300M入墙式无线AP', '/imgs/pro/list1_1.jpg', '6', '10', '', '2017-11-20 16:01:52', '2017-11-20 16:01:52', '1');
INSERT INTO `products` VALUES ('33', '1111', null, '11', '12', '1111', '2017-11-20 16:17:08', '2017-11-20 16:17:06', '1');

-- ----------------------------
-- Table structure for `product_type`
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `type_id` int(4) NOT NULL,
  `type_name` varchar(50) DEFAULT NULL,
  `parent_id` int(4) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `sort` int(3) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES ('-2', 'WIFI模块', '0', null, null);
INSERT INTO `product_type` VALUES ('-1', '产品中心', '0', null, null);
INSERT INTO `product_type` VALUES ('1', '无线路由', '-1', '', '1');
INSERT INTO `product_type` VALUES ('2', '双频无线路由', '1', '', '1');
INSERT INTO `product_type` VALUES ('3', '智能无线路由', '1', '', '2');
INSERT INTO `product_type` VALUES ('4', '300M无线路由', '1', '', '3');
INSERT INTO `product_type` VALUES ('5', '高功率无线路由', '1', '', '4');
INSERT INTO `product_type` VALUES ('6', '企业路由', '-1', '', '2');
INSERT INTO `product_type` VALUES ('7', '桌面式', '6', '', '1');
INSERT INTO `product_type` VALUES ('8', '吸顶式', '6', '', '2');
INSERT INTO `product_type` VALUES ('9', '户外型', '6', '', '3');
INSERT INTO `product_type` VALUES ('10', '入墙式', '6', '', '4');
INSERT INTO `product_type` VALUES ('11', '无线网卡', '-1', '', '3');
INSERT INTO `product_type` VALUES ('12', '双频网卡', '11', '', '1');
INSERT INTO `product_type` VALUES ('13', '高速300M', '11', '', '2');
INSERT INTO `product_type` VALUES ('14', '智能免驱', '11', '', '3');
INSERT INTO `product_type` VALUES ('15', '普通150M', '11', '', '4');
INSERT INTO `product_type` VALUES ('16', '交换机', '-1', '', '4');
INSERT INTO `product_type` VALUES ('17', '普通百兆', '16', '', '1');
INSERT INTO `product_type` VALUES ('18', '普通千兆', '16', '', '2');
INSERT INTO `product_type` VALUES ('19', '千兆管理型', '16', '', '3');
INSERT INTO `product_type` VALUES ('20', '其他', '-1', '', '5');
INSERT INTO `product_type` VALUES ('21', '路由模块', '-2', '', '1');
INSERT INTO `product_type` VALUES ('22', '2T2R', '21', '', '1');
INSERT INTO `product_type` VALUES ('23', '1T1R', '21', '', '2');
INSERT INTO `product_type` VALUES ('24', '网卡模块', '-2', '', '2');
INSERT INTO `product_type` VALUES ('25', 'USB接口（2T2R）', '24', '', '1');
INSERT INTO `product_type` VALUES ('26', 'USB接口（1T1R）', '24', '', '2');
INSERT INTO `product_type` VALUES ('27', 'SDIO接口（IT1R）', '24', '', '3');
INSERT INTO `product_type` VALUES ('28', 'MiNi PCI-E接口', '24', '', '4');
INSERT INTO `product_type` VALUES ('29', 'IOT模块', '-2', '', '3');

-- ----------------------------
-- Table structure for `t_sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_log`;
CREATE TABLE `t_sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `account` varchar(50) DEFAULT NULL COMMENT '账号',
  `title` varchar(40) DEFAULT NULL COMMENT '标题',
  `methods` varchar(128) DEFAULT NULL COMMENT '执行的方法',
  `message` varchar(255) DEFAULT NULL COMMENT '消息',
  `ip` varchar(15) DEFAULT NULL COMMENT 'IP',
  `duration` smallint(5) DEFAULT NULL COMMENT '执行时间',
  `params` longtext COMMENT '请求参数',
  `url` varchar(255) DEFAULT NULL COMMENT '请求地址',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_log
-- ----------------------------
INSERT INTO `t_sys_log` VALUES ('1', 'memmsc', '日志模块', '日志list', '进入日志查询的页面', '192.168.19.1', '4', null, '/sys/log/list', '2017-11-17 09:29:28', '2017-11-17 09:29:28');
INSERT INTO `t_sys_log` VALUES ('2', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '199', null, '/sys/menu/save', '2017-11-17 10:33:35', '2017-11-17 10:33:35');
INSERT INTO `t_sys_log` VALUES ('3', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '77', null, '/sys/menu/save', '2017-11-17 10:36:00', '2017-11-17 10:36:00');
INSERT INTO `t_sys_log` VALUES ('4', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '65', null, '/sys/menu/save', '2017-11-17 10:36:11', '2017-11-17 10:36:11');
INSERT INTO `t_sys_log` VALUES ('5', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '53', null, '/sys/menu/save', '2017-11-17 10:36:33', '2017-11-17 10:36:33');
INSERT INTO `t_sys_log` VALUES ('6', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '32', null, '/sys/menu/save', '2017-11-17 10:36:49', '2017-11-17 10:36:49');
INSERT INTO `t_sys_log` VALUES ('7', 'memmsc', '菜单管理', '移除菜单', '删除菜单信息', '192.168.19.1', '108', null, '/sys/menu/remove', '2017-11-17 10:36:53', '2017-11-17 10:36:53');
INSERT INTO `t_sys_log` VALUES ('8', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '40', null, '/sys/menu/save', '2017-11-17 10:37:28', '2017-11-17 10:37:28');
INSERT INTO `t_sys_log` VALUES ('9', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '71', null, '/sys/menu/save', '2017-11-17 10:37:43', '2017-11-17 10:37:43');
INSERT INTO `t_sys_log` VALUES ('10', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '68', null, '/sys/menu/save', '2017-11-17 10:37:58', '2017-11-17 10:37:58');
INSERT INTO `t_sys_log` VALUES ('11', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '104', null, '/sys/menu/save', '2017-11-17 10:38:08', '2017-11-17 10:38:08');
INSERT INTO `t_sys_log` VALUES ('12', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '78', null, '/sys/menu/save', '2017-11-17 10:38:28', '2017-11-17 10:38:28');
INSERT INTO `t_sys_log` VALUES ('13', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '76', null, '/sys/menu/save', '2017-11-17 10:38:39', '2017-11-17 10:38:39');
INSERT INTO `t_sys_log` VALUES ('14', 'memmsc', '菜单管理', '移除菜单', '删除菜单信息', '192.168.19.1', '66', null, '/sys/menu/remove', '2017-11-17 10:38:47', '2017-11-17 10:38:47');
INSERT INTO `t_sys_log` VALUES ('15', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '75', null, '/sys/menu/save', '2017-11-17 10:39:15', '2017-11-17 10:39:15');
INSERT INTO `t_sys_log` VALUES ('16', 'memmsc', '菜单管理', '移除菜单', '删除菜单信息', '192.168.19.1', '0', null, '/sys/menu/remove', '2017-11-17 10:39:58', '2017-11-17 10:39:58');
INSERT INTO `t_sys_log` VALUES ('17', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '95', null, '/sys/menu/save', '2017-11-17 10:45:35', '2017-11-17 10:45:35');
INSERT INTO `t_sys_log` VALUES ('18', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '64', null, '/sys/menu/save', '2017-11-17 10:46:22', '2017-11-17 10:46:22');
INSERT INTO `t_sys_log` VALUES ('19', 'memmsc', '操作管理', '保存操作', '添加/修改操作信息', '192.168.19.1', '66', null, '/sys/operate/save', '2017-11-17 10:49:51', '2017-11-17 10:49:51');
INSERT INTO `t_sys_log` VALUES ('20', 'memmsc', '操作管理', '保存操作', '添加/修改操作信息', '192.168.19.1', '67', null, '/sys/operate/save', '2017-11-17 10:50:18', '2017-11-17 10:50:18');
INSERT INTO `t_sys_log` VALUES ('21', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '68', null, '/sys/menu/save', '2017-11-17 10:52:09', '2017-11-17 10:52:09');
INSERT INTO `t_sys_log` VALUES ('22', 'memmsc', '操作管理', '保存操作', '添加/修改操作信息', '192.168.19.1', '36', null, '/sys/operate/save', '2017-11-17 10:54:08', '2017-11-17 10:54:08');
INSERT INTO `t_sys_log` VALUES ('23', 'memmsc', '操作管理', '保存操作', '添加/修改操作信息', '192.168.19.1', '26', null, '/sys/operate/save', '2017-11-17 10:54:50', '2017-11-17 10:54:50');
INSERT INTO `t_sys_log` VALUES ('24', 'memmsc', '日志模块', '日志list', '进入日志查询的页面', '192.168.19.1', '7', null, '/sys/log/list', '2017-11-17 10:55:00', '2017-11-17 10:55:00');
INSERT INTO `t_sys_log` VALUES ('25', 'memmsc', '操作管理', '保存操作', '添加/修改操作信息', '192.168.19.1', '67', null, '/sys/operate/save', '2017-11-17 11:05:38', '2017-11-17 11:05:38');
INSERT INTO `t_sys_log` VALUES ('26', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '90', null, '/sys/menu/save', '2017-11-17 11:12:23', '2017-11-17 11:12:23');
INSERT INTO `t_sys_log` VALUES ('27', 'memmsc', '操作管理', '保存操作', '添加/修改操作信息', '192.168.19.1', '30', null, '/sys/operate/save', '2017-11-17 11:13:09', '2017-11-17 11:13:09');
INSERT INTO `t_sys_log` VALUES ('28', 'memmsc', '菜单管理', '保存菜单', '添加/修改菜单信息', '192.168.19.1', '81', null, '/sys/menu/save', '2017-11-17 15:01:29', '2017-11-17 15:01:29');
INSERT INTO `t_sys_log` VALUES ('29', 'memmsc', '操作管理', '保存操作', '添加/修改操作信息', '192.168.19.1', '35', null, '/sys/operate/save', '2017-11-17 15:01:53', '2017-11-17 15:01:53');
INSERT INTO `t_sys_log` VALUES ('30', 'memmsc', '操作管理', '移除操作', '删除操作信息', '192.168.19.1', '104', null, '/sys/operate/remove', '2017-11-17 15:02:26', '2017-11-17 15:02:26');
INSERT INTO `t_sys_log` VALUES ('31', 'memmsc', '操作管理', '保存操作', '添加/修改操作信息', '192.168.19.1', '64', null, '/sys/operate/save', '2017-11-17 15:03:23', '2017-11-17 15:03:23');
INSERT INTO `t_sys_log` VALUES ('32', 'memmsc', '操作管理', '保存操作', '添加/修改操作信息', '192.168.19.1', '0', null, '/sys/operate/save', '2017-11-17 16:25:13', '2017-11-17 16:25:13');
INSERT INTO `t_sys_log` VALUES ('33', 'memmsc', '操作管理', '保存操作', '添加/修改操作信息', '192.168.19.1', '66', null, '/sys/operate/save', '2017-11-17 16:35:22', '2017-11-17 16:35:22');
INSERT INTO `t_sys_log` VALUES ('34', 'memmsc', '日志模块', '日志list', '进入日志查询的页面', '192.168.19.1', '5', null, '/sys/log/list', '2017-11-20 14:14:08', '2017-11-20 14:14:08');
INSERT INTO `t_sys_log` VALUES ('35', 'memmsc', '角色管理', '保存角色', '添加/修改角色信息', '192.168.19.1', '83', null, '/sys/role/save', '2017-11-20 16:12:11', '2017-11-20 16:12:11');
INSERT INTO `t_sys_log` VALUES ('36', 'memmsc', '日志模块', '日志list', '进入日志查询的页面', '192.168.19.1', '7', null, '/sys/log/list', '2017-11-20 16:38:18', '2017-11-20 16:38:18');

-- ----------------------------
-- Table structure for `t_sys_manager`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_manager`;
CREATE TABLE `t_sys_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `account` varchar(50) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `role_id` tinyint(3) DEFAULT NULL COMMENT '角色',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `credential` varchar(100) DEFAULT NULL COMMENT '验证凭证',
  `locked` bit(1) DEFAULT b'1' COMMENT '是否启用 0=禁用 1=启用',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(64) DEFAULT NULL COMMENT '电话',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `photo` varchar(266) DEFAULT NULL COMMENT '头像',
  `last_login_ip` varchar(15) DEFAULT NULL COMMENT '登陆IP',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_ACCOUNT` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户管理表';

-- ----------------------------
-- Records of t_sys_manager
-- ----------------------------
INSERT INTO `t_sys_manager` VALUES ('1', 'admin', '123456', '1', '秋殇', '9c6c9e22ae8c773c8f07a75b28563152', '', null, null, null, null, null, null, '2017-06-16 08:59:01', '2017-06-16 08:59:01');
INSERT INTO `t_sys_manager` VALUES ('2', 'battcn', 'battcn', '2', '11333', null, '', null, null, null, null, null, null, '2017-06-19 09:20:14', '2017-06-21 13:49:37');

-- ----------------------------
-- Table structure for `t_sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `channel` varchar(100) DEFAULT NULL COMMENT '渠道',
  `param` varchar(200) DEFAULT NULL,
  `locked` bit(1) DEFAULT b'1' COMMENT '是否启用 0=禁用 1=启用',
  `pater_id` int(8) DEFAULT NULL COMMENT '父级编号',
  `ordno` int(8) DEFAULT NULL COMMENT '排序编号',
  `n_level` int(8) DEFAULT NULL COMMENT '级别',
  `scort` varchar(100) DEFAULT NULL COMMENT 'tree所需',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  KEY `FK_Reference` (`pater_id`),
  CONSTRAINT `t_sys_menu_ibfk_1` FOREIGN KEY (`pater_id`) REFERENCES `t_sys_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of t_sys_menu
-- ----------------------------
INSERT INTO `t_sys_menu` VALUES ('1', '系统管理', '系统管理', 'fa fa fa-home', '/sys/sys', 'sys', '', null, '6', '0', ',1,', '2017-06-16 09:00:09', '2017-06-20 18:57:17');
INSERT INTO `t_sys_menu` VALUES ('2', '菜单管理', '菜单管理', 'fa fa-server', '/sys/menu', 'sys:menu', '', '1', '2', '0', ',1,2,', '2017-06-16 09:00:09', '2017-11-17 10:33:35');
INSERT INTO `t_sys_menu` VALUES ('3', '操作管理', '操作管理', 'fa fa-hand-lizard-o', '/sys/operate', 'sys:operate', '', '1', '3', '0', ',1,3,', '2017-06-16 09:00:09', '2017-11-17 10:33:35');
INSERT INTO `t_sys_menu` VALUES ('4', '角色管理', '角色管理', 'fa fa-sitemap', '/sys/role', 'sys:role', '', '1', '4', '0', ',1,4,', '2017-06-16 09:00:09', '2017-11-17 10:33:35');
INSERT INTO `t_sys_menu` VALUES ('5', '帐号管理', '帐号管理', 'fa fa-sun-o', '/sys/manager', 'sys:manager', '', '1', '1', '0', ',1,5,', '2017-06-16 09:00:09', '2017-11-17 10:33:35');
INSERT INTO `t_sys_menu` VALUES ('6', '日志管理', '日志管理', 'fa fa-comments-o', '/sys/log', 'sys:logs', '', '1', '7', '0', ',1,6,', '2017-06-16 09:00:09', '2017-11-17 10:33:35');
INSERT INTO `t_sys_menu` VALUES ('7', '字典管理', '字典管理', 'fa fa-newspaper-o', '/sys/dict', 'sys:dict', '', '1', '5', '0', ',1,7,', '2017-06-16 09:00:09', '2017-11-17 10:33:35');
INSERT INTO `t_sys_menu` VALUES ('8', '鏖战工具', '鏖战工具', 'fa fa-cogs', '/battcn/utils', 'battcn:utils', '', null, '1', '0', ',8,', '2017-06-16 09:00:09', '2017-06-21 11:44:19');
INSERT INTO `t_sys_menu` VALUES ('9', '测试', null, null, null, null, '', '8', null, '0', ',8,9,', '2017-06-20 19:05:47', '2017-11-17 10:33:35');
INSERT INTO `t_sys_menu` VALUES ('13', '产品管理', '', 'fa fa fa-home', '/pro/pro', 'pro', '', null, '9', '0', ',13,', '2017-11-17 10:45:35', '2017-11-17 10:47:05');
INSERT INTO `t_sys_menu` VALUES ('14', '产品数据', '', 'fa fa-sitemap', '/pro/data', 'pro:data', '', '13', '10', '0', ',13,14,', '2017-11-17 10:46:22', '2017-11-17 10:52:09');
INSERT INTO `t_sys_menu` VALUES ('15', '产品类别', '', 'fa fa-align-justify', '/pro/type', 'pro:type', '', '13', '11', '0', ',13,15,', '2017-11-17 11:12:23', '2017-11-17 11:12:23');
INSERT INTO `t_sys_menu` VALUES ('16', '评论管理', '', 'fa fa fa-home', '/pro/commemt', 'pro:commemt', '', '13', '3', '0', ',13,16,', '2017-11-17 15:01:29', '2017-11-17 15:01:29');

-- ----------------------------
-- Table structure for `t_sys_operate`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_operate`;
CREATE TABLE `t_sys_operate` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_id` int(8) NOT NULL COMMENT '菜单ID',
  `op` varchar(30) NOT NULL COMMENT '选项',
  `name` varchar(64) NOT NULL COMMENT '名字',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  `ordno` int(11) DEFAULT NULL COMMENT '排序号',
  `display` int(1) NOT NULL COMMENT '是否显示出来',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `menu_op` (`menu_id`,`op`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='操作表';

-- ----------------------------
-- Records of t_sys_operate
-- ----------------------------
INSERT INTO `t_sys_operate` VALUES ('1', '1', 'list', '查看', 'list', null, '1', '0', '2017-06-20 18:52:32', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('2', '2', 'edit', '编辑', 'edit', null, '3', '1', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('3', '2', 'list', '查看', 'list', null, '1', '0', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('4', '2', 'remove', '删除', 'remove', null, '4', '1', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('5', '2', 'save', '保存', 'save', null, '5', '0', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('6', '2', 'add', '新增', 'plus', null, '2', '1', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('7', '3', 'edit', '编辑', 'edit', null, '3', '1', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('8', '3', 'list', '查看', 'list', null, '1', '0', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('9', '3', 'remove', '删除', 'remove', null, '4', '1', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('10', '3', 'save', '保存', 'save', null, '5', '1', '2017-06-16 09:01:08', '2017-11-17 11:06:15');
INSERT INTO `t_sys_operate` VALUES ('11', '3', 'add', '新增', 'plus', null, '2', '1', '2017-06-16 09:01:08', '2017-06-21 10:15:01');
INSERT INTO `t_sys_operate` VALUES ('12', '4', 'edit', '编辑', 'edit', null, '3', '1', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('13', '4', 'list', '查看', 'list', null, '1', '0', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('14', '4', 'remove', '删除', 'remove', null, '4', '1', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('15', '4', 'save', '保存', 'save', null, '5', '0', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('16', '4', 'add', '新增', 'plus', null, '2', '1', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('17', '5', 'edit', '编辑', 'edit', null, '3', '1', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('18', '5', 'list', '查看', 'list', null, '1', '0', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('19', '5', 'remove', '删除', 'remove', null, '4', '1', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('20', '5', 'save', '保存', 'save', null, '5', '0', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('21', '5', 'add', '新增', 'plus', null, '2', '1', '2017-06-16 09:01:08', '2017-06-20 19:09:41');
INSERT INTO `t_sys_operate` VALUES ('22', '6', 'list', '查看', 'list', null, '1', '0', '2017-06-16 09:01:08', '2017-06-21 09:29:01');
INSERT INTO `t_sys_operate` VALUES ('23', '7', 'edit', '编辑', 'edit', null, '2', '1', '2017-06-16 09:01:08', '2017-06-21 09:29:09');
INSERT INTO `t_sys_operate` VALUES ('24', '7', 'list', '查看', 'list', null, '2', '0', '2017-06-16 09:01:08', '2017-06-21 09:29:10');
INSERT INTO `t_sys_operate` VALUES ('25', '7', 'remove', '删除', 'remove', null, '1', '1', '2017-06-16 09:01:08', '2017-06-21 09:29:12');
INSERT INTO `t_sys_operate` VALUES ('26', '7', 'save', '保存', 'save', null, '3', '0', '2017-06-16 09:01:08', '2017-06-21 09:29:13');
INSERT INTO `t_sys_operate` VALUES ('27', '4', 'permissions', '分配权限', 'permissions', null, '1', '1', '2017-06-20 13:38:21', '2017-06-21 09:29:14');
INSERT INTO `t_sys_operate` VALUES ('28', '8', 'list', '查看', 'list', null, '1', '0', '2017-06-16 09:01:08', '2017-06-21 10:09:23');
INSERT INTO `t_sys_operate` VALUES ('29', '14', 'add', '新增', 'save', '', '1', '1', '2017-11-17 10:49:51', '2017-11-17 10:49:51');
INSERT INTO `t_sys_operate` VALUES ('30', '14', 'edit', '编辑', 'edit', '', '2', '1', '2017-11-17 10:50:18', '2017-11-17 10:50:18');
INSERT INTO `t_sys_operate` VALUES ('31', '14', 'list', '查看', 'list', '', '3', '0', '2017-11-17 10:54:08', '2017-11-17 10:56:48');
INSERT INTO `t_sys_operate` VALUES ('32', '13', 'list', '查看', 'list', '', '1', '0', '2017-11-17 11:05:38', '2017-11-17 11:05:38');
INSERT INTO `t_sys_operate` VALUES ('33', '15', 'list', '查看', 'list', '', '1', '0', '2017-11-17 11:13:09', '2017-11-17 11:13:09');
INSERT INTO `t_sys_operate` VALUES ('35', '16', 'list', '查看', 'list', '', '1', '1', '2017-11-17 15:03:23', '2017-11-17 15:03:23');
INSERT INTO `t_sys_operate` VALUES ('37', '14', 'save', '保存', 'save', '', '4', '0', '2017-11-17 16:35:22', '2017-11-17 16:35:22');

-- ----------------------------
-- Table structure for `t_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '角色名',
  `code` varchar(50) DEFAULT NULL COMMENT '编号',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', '超级管理员', 'manager', '超级管理员,不听话就封号', '2017-06-16 09:01:23', '2017-06-16 09:01:23');
INSERT INTO `t_sys_role` VALUES ('2', '测试管理员', 'test', '专门测试没有权限的时候1', '2017-06-16 09:01:23', '2017-06-16 09:01:23');
INSERT INTO `t_sys_role` VALUES ('3', '开发管理员', 'code', '我是开发不服删数据库', '2017-06-16 09:01:23', '2017-11-20 16:12:11');

-- ----------------------------
-- Table structure for `t_sys_role_operate`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_operate`;
CREATE TABLE `t_sys_role_operate` (
  `role_id` int(8) NOT NULL COMMENT '角色ID',
  `operate_id` int(8) NOT NULL COMMENT '操作表ID',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`role_id`,`operate_id`),
  KEY `operate_id` (`operate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role_operate
-- ----------------------------
INSERT INTO `t_sys_role_operate` VALUES ('1', '1', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '2', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '3', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '4', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '5', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '6', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '7', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '8', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '9', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '10', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '11', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '12', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '13', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '14', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '15', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '16', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '17', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '18', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '19', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '20', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '21', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '22', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '23', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '24', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '25', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '26', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '27', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '28', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '29', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '30', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '31', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '32', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '33', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('1', '35', '2017-11-17 15:04:28', '2017-11-17 15:04:28');
INSERT INTO `t_sys_role_operate` VALUES ('2', '1', '2017-06-16 09:01:39', '2017-06-16 09:01:39');
INSERT INTO `t_sys_role_operate` VALUES ('2', '2', '2017-06-16 09:01:39', '2017-06-16 09:01:39');
INSERT INTO `t_sys_role_operate` VALUES ('2', '3', '2017-06-16 09:01:39', '2017-06-16 09:01:39');
INSERT INTO `t_sys_role_operate` VALUES ('2', '4', '2017-06-16 09:01:39', '2017-06-16 09:01:39');
INSERT INTO `t_sys_role_operate` VALUES ('2', '5', '2017-06-16 09:01:39', '2017-06-16 09:01:39');

-- ----------------------------
-- Procedure structure for `refreshTreeNodes`
-- ----------------------------
DROP PROCEDURE IF EXISTS `refreshTreeNodes`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `refreshTreeNodes`()
BEGIN

DECLARE LEVEL INT ;
SET LEVEL = 0 ; UPDATE t_sys_menu a
INNER JOIN (
	SELECT
		id,
		n_level,
		concat(',', ID, ',') scort
	FROM
		t_sys_menu
	WHERE
		pater_id IS NULL
) b ON a.id = b.id
SET a.n_level = b.n_level,
 a.scort = b.scort ;
WHILE FOUND_ROWS() > 0 DO
SET LEVEL = LEVEL + 1 ; UPDATE t_sys_menu a
INNER JOIN (
	SELECT
		ID,
		n_level,
		scort
	FROM
		t_sys_menu
	WHERE
		n_level = LEVEL - 1
) b ON a.pater_id = b.id
SET a.n_level = b.n_level,
 a.scort = concat(b.scort, a.ID, ',') ;
END
WHILE ;
END
;;
DELIMITER ;
