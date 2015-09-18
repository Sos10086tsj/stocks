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

