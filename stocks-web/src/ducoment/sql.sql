CREATE SCHEMA `stocks` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `stocks`.`market` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC));
  
CREATE TABLE `stocks`.`market_index` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `date` TIMESTAMP NULL,
  `market_code` VARCHAR(45) NULL,
  `code` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `today_open_price` DECIMAL(10,5) NULL,
  `yestoday_close_price` DECIMAL(10,5) NULL,
  `now_price` DECIMAL(10,5) NULL,
  `max_price` DECIMAL(10,5) NULL,
  `min_price` DECIMAL(10,5) NULL,
  `trade_num` DECIMAL(20,5) NULL,
  `trade_amount` DECIMAL(20,5) NULL,
  PRIMARY KEY (`id`),
  INDEX `INDEX_MKT_INDEX_DATE` (`date` DESC),
  INDEX `INDEX_MKT_INDEX_CODE` (`code` ASC));

 
CREATE TABLE `stocks`.`stock` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `market_code` VARCHAR(45) NULL,
  `pinyin` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `INDEX_STK_CODE` (`code` ASC),
  INDEX `INDEX_STK_PINYIN` (`pinyin` ASC));

CREATE TABLE `stock_index` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `date` int(11) DEFAULT NULL,
  `stock_code` varchar(45) DEFAULT NULL,
  `market_code` varchar(45) DEFAULT NULL,
  `stock_name` varchar(45) DEFAULT NULL,
  `open_price` decimal(20,5) DEFAULT NULL,
  `close_price` decimal(20,5) DEFAULT NULL,
  `now_price` decimal(20,5) DEFAULT NULL,
  `today_max` decimal(20,5) DEFAULT NULL,
  `today_min` decimal(20,5) DEFAULT NULL,
  `compet_buy_price` decimal(20,5) DEFAULT NULL,
  `compet_sell_price` decimal(20,5) DEFAULT NULL,
  `trade_num` decimal(20,5) DEFAULT NULL,
  `trade_amount` decimal(20,5) DEFAULT NULL,
  `buy_1_num` decimal(20,5) DEFAULT NULL,
  `buy_1_price` decimal(20,5) DEFAULT NULL,
  `buy_2_num` decimal(20,5) DEFAULT NULL,
  `buy_2_price` decimal(20,5) DEFAULT NULL,
  `buy_3_num` decimal(20,5) DEFAULT NULL,
  `buy_3_price` decimal(20,5) DEFAULT NULL,
  `buy_4_num` decimal(20,5) DEFAULT NULL,
  `buy_4_price` decimal(20,5) DEFAULT NULL,
  `buy_5_num` decimal(20,5) DEFAULT NULL,
  `buy_5_price` decimal(20,5) DEFAULT NULL,
  `sell_1_num` decimal(20,5) DEFAULT NULL,
  `sell_1_price` decimal(20,5) DEFAULT NULL,
  `sell_2_num` decimal(20,5) DEFAULT NULL,
  `sell_2_price` decimal(20,5) DEFAULT NULL,
  `sell_3_num` decimal(20,5) DEFAULT NULL,
  `sell_3_price` decimal(20,5) DEFAULT NULL,
  `sell_4_num` decimal(20,5) DEFAULT NULL,
  `sell_4_price` decimal(20,5) DEFAULT NULL,
  `sell_5_num` decimal(20,5) DEFAULT NULL,
  `sell_5_price` decimal(20,5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `INDEX_STK_IDX_UN` (`date`,`stock_code`,`market_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `stocks`.`k_line` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `stock_id` BIGINT(20) NULL COMMENT '',
  `minute_url` VARCHAR(45) NULL COMMENT '',
  `day_url` VARCHAR(45) NULL COMMENT '',
  `week_url` VARCHAR(45) NULL COMMENT '',
  `month_url` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `stock_index_id_UNIQUE` (`stock_id` ASC)  COMMENT '',
  INDEX `IDX_K_LINE_STOCK_ID` (`stock_id` ASC)  COMMENT '');

CREATE TABLE `stocks`.`sys_config` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `property` VARCHAR(45) NULL COMMENT '',
  `property_value` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `property_UNIQUE` (`property` ASC)  COMMENT '');
ALTER TABLE `stocks`.`sys_config` 
ADD INDEX `INDX_SYS_CONFIG_PROP` (`property` ASC)  COMMENT '';

CREATE TABLE `stocks`.`user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `username` VARCHAR(45) NULL COMMENT '',
  `salt` VARCHAR(45) NULL COMMENT '',
  `password` VARCHAR(45) NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `username_UNIQUE` (`username` ASC)  COMMENT '',
  INDEX `IDX_USER_USERNAME` (`username` ASC)  COMMENT '');

CREATE TABLE `stocks`.`user_focus` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `user_id` BIGINT(20) NULL COMMENT '',
  `market_code` VARCHAR(45) NULL COMMENT '',
  `stock_code` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');

 ALTER TABLE `stocks`.`market_index` 
CHANGE COLUMN `date` `date` INT(11) NULL DEFAULT NULL COMMENT '' ;

INSERT INTO `stocks`.`sys_config` (`property`, `property_value`) VALUES ('SHOW_API_ID', '8855');
INSERT INTO `stocks`.`sys_config` (`property`, `property_value`) VALUES ('SHOW_API_SIGN', 'de775a2c637f4006b1327b13271c619d');
INSERT INTO `stocks`.`sys_config` (`property`, `property_value`) VALUES ('SHOW_API_STOCK_BASE_URL', 'http://route.showapi.com/131-43');
INSERT INTO `stocks`.`sys_config` (`property`, `property_value`) VALUES ('SHOW_API_BASE_STOCKS_URL', 'http://route.showapi.com/131-46');
INSERT INTO `stocks`.`sys_config` (`property`, `property_value`) VALUES ('SHOW_API_STOCKS_NEED_INDEX', '0');
INSERT INTO `stocks`.`sys_config` (`property`, `property_value`) VALUES ('SHOW_API_MARKET_INDEX_BASE_URL', 'http://route.showapi.com/131-45');

ALTER TABLE `stocks`.`stock_index` 
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '' ;

INSERT INTO `stocks`.`market` (`code`, `name`) VALUES ('sh000001', '上证指数');
INSERT INTO `stocks`.`market` (`code`, `name`) VALUES ('sz399001', '深证成指');
INSERT INTO `stocks`.`market` (`code`, `name`) VALUES ('sz399005', '中小板指');
INSERT INTO `stocks`.`market` (`code`, `name`) VALUES ('sz399006', '创业板指');

CREATE TABLE `stocks`.`kdj` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `date` INT(6) NULL COMMENT '',
  `type` INT NULL COMMENT '',
  `stock_code` VARCHAR(45) NULL COMMENT '',
  `k` DECIMAL(4,2) NULL COMMENT '',
  `d` DECIMAL(4,2) NULL COMMENT '',
  `j` DECIMAL(4,2) NULL COMMENT '',
  `rsv` DECIMAL(4,2) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');
