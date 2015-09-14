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

 