-- liquibase formatted sql

-- changeset Arslan-Shamshidinov:create-category-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='youbuy.category';
CREATE TABLE `youbuy`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-product-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='youbuy.product';
CREATE TABLE `youbuy`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `price` DECIMAL NOT NULL,
  `category_id` INT NOT NULL,
  `image_url` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-order-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='youbuy.order';
CREATE TABLE `youbuy`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  `shipping_id` INT NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-order-item-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='youbuy.order_item';
CREATE TABLE `youbuy`.`order_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  `price` DECIMAL NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-order-items-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='youbuy.order_items';
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

-- changeset Arslan-Shamshidinov:create-shopping-cart-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='youbuy.shopping_cart';
CREATE TABLE `youbuy`.`shopping_cart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-shopping-cart-item-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='youbuy.shopping_cart_item';
CREATE TABLE `youbuy`.`shopping_cart_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-cart-items-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='youbuy.cart_items';
 CREATE TABLE `youbuy`.`cart_items` (
      `cart_item_id` INT NOT NULL,
      `cart_id` INT NOT NULL,
      PRIMARY KEY (`cart_item_id`, `cart_id`),
      INDEX `cart_id_idx` (`cart_id` ASC) VISIBLE,
      CONSTRAINT `cart_item_id`
        FOREIGN KEY (`cart_item_id`)
        REFERENCES `youbuy`.`shopping_cart_item` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
      CONSTRAINT `cart_id`
        FOREIGN KEY (`cart_id`)
        REFERENCES `youbuy`.`shopping_cart` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);

-- changeset Arslan-Shamshidinov:create-shipping-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='youbuy.shipping';
CREATE TABLE `youbuy`.`shipping` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `address` VARCHAR(255) NULL,
  `city` VARCHAR(255) NULL,
  `state` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-role-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='youbuy.role';
CREATE TABLE `youbuy`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

-- changeset Arslan-Shamshidinov:create-user-table
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='youbuy.user';
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
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.TABLES where TABLE_NAME='youbuy.user_roles';
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