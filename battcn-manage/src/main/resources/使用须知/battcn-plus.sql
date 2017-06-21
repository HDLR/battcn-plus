
-- ----------------------------
-- 本SQL采用的是MYSQL5.6 如果版本不 < 5.6请去官方安装
-- 否则运行SQL会出现：[Err] 1067 - Invalid default value for 'gmt_create'
-- 如果真的想使用,请修改 
-- `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' (修改前)
-- `gmt_create` datetime DEFAULT NULL COMMENT '创建时间' (修改后)
-- ----------------------------


SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_sys_log
-- ----------------------------
DROP TABLE
IF EXISTS `t_sys_log`;

CREATE TABLE `t_sys_log` (
	`id` INT (11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
	`account` VARCHAR (50) DEFAULT NULL COMMENT '账号',
	`title` VARCHAR (40) DEFAULT NULL COMMENT '标题',
	`methods` VARCHAR (128) DEFAULT NULL COMMENT '执行的方法',
	`message` VARCHAR (255) DEFAULT NULL COMMENT '消息',
	`ip` VARCHAR (15) DEFAULT NULL COMMENT 'IP',
	`duration` SMALLINT (5) DEFAULT NULL COMMENT '执行时间',
	`params` LONGTEXT DEFAULT NULL COMMENT '请求参数',
	`url` VARCHAR (255) DEFAULT NULL COMMENT '请求地址',
	`gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;


-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE
IF EXISTS `t_sys_role`;

CREATE TABLE `t_sys_role` (
	`id` INT (8) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`name` VARCHAR(50) NOT NULL COMMENT '角色名',
	`code` VARCHAR(50) DEFAULT NULL COMMENT '编号',
	`remark` VARCHAR(200) DEFAULT NULL COMMENT '备注',
	`gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;


-- ----------------------------
-- Table structure for t_sys_manager
-- ----------------------------
DROP TABLE
IF EXISTS `t_sys_manager`;

CREATE TABLE `t_sys_manager` (
	`id` INT (11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
	`account` VARCHAR (50) NOT NULL COMMENT '账号',
	`password` VARCHAR (50) NOT NULL COMMENT '密码',
	`role_id` TINYINT (3) DEFAULT NULL COMMENT '角色',
	`name` VARCHAR (50) DEFAULT NULL COMMENT '姓名',
	`credential` VARCHAR (100) DEFAULT NULL COMMENT '验证凭证',
  `locked` bit(1) DEFAULT b'1' COMMENT '是否启用 0=禁用 1=启用',
	`email` VARCHAR (64) DEFAULT NULL COMMENT '邮箱',
	`phone` VARCHAR (64) DEFAULT NULL COMMENT '电话',
	`sex` VARCHAR (255) DEFAULT NULL COMMENT '性别',
	`type` VARCHAR (255) DEFAULT NULL COMMENT '类型',
	`photo` VARCHAR (266) DEFAULT NULL COMMENT '头像',
	`last_login_ip` VARCHAR (15) DEFAULT NULL COMMENT '登陆IP',
	`gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
	PRIMARY KEY (`id`),
	UNIQUE KEY `AK_ACCOUNT` (`account`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '用户管理表';





-- ----------------------------
-- Table structure for t_sys_menu
-- ----------------------------
DROP TABLE
IF EXISTS `t_sys_menu`;

CREATE TABLE `t_sys_menu` (
	`id` INT (8) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	`remark` VARCHAR (2000) DEFAULT NULL COMMENT '备注',
	`icon` VARCHAR (100) DEFAULT NULL COMMENT '图标',
	`channel` VARCHAR (100) DEFAULT NULL COMMENT '渠道',
	`param` VARCHAR (200) DEFAULT NULL COMMENT '',
  `locked` bit(1) DEFAULT b'1' COMMENT '是否启用 0=禁用 1=启用',
	`pater_id` INT (8) DEFAULT NULL COMMENT '父级编号',
	`ordno` INT (8) DEFAULT NULL COMMENT '排序编号',
	`n_level` INT (8) DEFAULT NULL COMMENT '级别',
	`scort` VARCHAR (100) DEFAULT NULL COMMENT 'tree所需',
	`gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
	PRIMARY KEY (`id`),
	KEY `FK_Reference` (`pater_id`),
	CONSTRAINT `t_sys_menu_ibfk_1` FOREIGN KEY (`pater_id`) REFERENCES `t_sys_menu` (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '菜单表';

-- ----------------------------
-- Table structure for t_sys_operate
-- ----------------------------
DROP TABLE
IF EXISTS `t_sys_operate`;

CREATE TABLE `t_sys_operate` (
	`id` INT (8) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`menu` INT (8) NOT NULL COMMENT '菜单ID',
	`op` VARCHAR (30) NOT NULL COMMENT '选项',
	`name` VARCHAR (64) NOT NULL COMMENT '名字',
	`icon` VARCHAR (50) DEFAULT NULL COMMENT '图标',
	`remark` VARCHAR (2000) DEFAULT NULL COMMENT '备注',
	`ordno` INT (11) DEFAULT NULL COMMENT '排序号',
	`display` INT (1) NOT NULL COMMENT '是否显示出来',
	`gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
	PRIMARY KEY (`id`),
	UNIQUE KEY `menu` (`menu`, `op`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '操作表';



-- ----------------------------
-- Table structure for t_sys_role_operate
-- ----------------------------
DROP TABLE
IF EXISTS `t_sys_role_operate`;

CREATE TABLE `t_sys_role_operate` (
	`role_id` INT (8) NOT NULL COMMENT '角色ID',
	`operate_id` INT (8) NOT NULL COMMENT '操作表ID',
	`gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
	PRIMARY KEY (`role_id`, `operate_id`),
	KEY `operate_id` (`operate_id`)
) ENGINE = INNODB CHARSET = utf8;

-- ----------------------------
-- Procedure structure for showTreeNodes_menu
-- ----------------------------
DROP PROCEDURE
IF EXISTS `refreshTreeNodes`;
DELIMITER ;;


CREATE DEFINER = `root`@`localhost` PROCEDURE `refreshTreeNodes` ()
BEGIN

DECLARE LEVEL INT ;
SET LEVEL = 0 ; UPDATE t_sys_menu a
INNER JOIN (
	SELECT
		id,
		LEVEL,
		concat(',', ID, ',') scort
	FROM
		t_sys_menu
	WHERE
		pid IS NULL
) b ON a.id = b.id
SET a.nlevel = b. LEVEL,
 a.scort = b.scort ;
WHILE FOUND_ROWS() > 0 DO

SET LEVEL = LEVEL + 1 ; UPDATE t_sys_menu a
INNER JOIN (
	SELECT
		ID,
		LEVEL,
		scort
	FROM
		t_sys_menu
	WHERE
		n_level = LEVEL - 1
) b ON a.pid = b.id
SET a.nlevel = b. LEVEL,
 a.scort = concat(b.scort, a.ID, ',') ;
END
WHILE ;
END;;
DELIMITER ;
