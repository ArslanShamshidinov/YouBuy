-- liquibase formatted sql

-- changeset Arslan-Shamshidinov:create-category-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'youbuy' AND TABLE_NAME='category';
CREATE TABLE `youbuy`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-product-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'youbuy' AND TABLE_NAME='product';
CREATE TABLE `youbuy`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `price` DECIMAL NOT NULL,
  `category_id` INT NOT NULL,
  `image_url` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-order-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'youbuy' AND TABLE_NAME='order';
CREATE TABLE `youbuy`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  `shipping_id` INT NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-order-item-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'youbuy' AND TABLE_NAME='order_item';
CREATE TABLE `youbuy`.`order_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  `price` DECIMAL NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-order-items-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'youbuy' AND TABLE_NAME='order_items';
 CREATE TABLE `youbuy`.`order_items` (
      `item_id` INT NOT NULL,
      `order_id` INT NOT NULL,
      PRIMARY KEY (`item_id`, `order_id`),
      INDEX `order_id_idx` (`order_id` ASC) VISIBLE,
      CONSTRAINT `item_id`
        FOREIGN KEY (`item_id`)
        REFERENCES `youbuy`.`order_item` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
      CONSTRAINT `order_id`
        FOREIGN KEY (`order_id`)
        REFERENCES `youbuy`.`order` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);

-- changeset Arslan-Shamshidinov:create-cart-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'youbuy' AND TABLE_NAME='cart';
CREATE TABLE `youbuy`.`cart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created` DATETIME NOT NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-cart-item-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'youbuy' AND TABLE_NAME='cart_item';
CREATE TABLE `youbuy`.`cart_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-cart-items-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'youbuy' AND TABLE_NAME='cart_cart_items';
 CREATE TABLE `youbuy`.`cart_cart_items` (
      `cart_id` INT NOT NULL,
      `cart_item_id` INT NOT NULL,
      PRIMARY KEY (`cart_id`, `cart_item_id`),
      INDEX `cart_id_idx` (`cart_id` ASC) VISIBLE,
      CONSTRAINT `cart_id`
        FOREIGN KEY (`cart_id`)
        REFERENCES `youbuy`.`cart` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
      CONSTRAINT `cart_item_id`
        FOREIGN KEY (`cart_item_id`)
        REFERENCES `youbuy`.`cart_item` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);

-- changeset Arslan-Shamshidinov:create-shipping-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'youbuy' AND TABLE_NAME='shipping';
CREATE TABLE `youbuy`.`shipping` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `address` VARCHAR(255) NULL,
  `city` VARCHAR(255) NULL,
  `state` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-role-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'youbuy' AND TABLE_NAME='role';
CREATE TABLE `youbuy`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-user-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'youbuy' AND TABLE_NAME='user';
CREATE TABLE `youbuy`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created` DATETIME NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) UNIQUE NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-user_roles-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES WHERE TABLE_SCHEMA = 'youbuy' AND TABLE_NAME='user_roles';
 CREATE TABLE `youbuy`.`user_roles` (
      `user_id` INT NOT NULL,
      `role_id` INT NOT NULL,
      PRIMARY KEY (`user_id`, `role_id`),
      INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
      CONSTRAINT `user_id`
        FOREIGN KEY (`user_id`)
        REFERENCES `youbuy`.`user` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
      CONSTRAINT `role_id`
        FOREIGN KEY (`role_id`)
        REFERENCES `youbuy`.`role` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);