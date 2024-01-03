-- liquibase formatted sql

-- changeset Arslan-Shamshidinov:populate-category-table
INSERT INTO `youbuy`.`category` (name) VALUES
('fruits'),
('food'),
('clothes');