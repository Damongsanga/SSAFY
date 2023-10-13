-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ssafit
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ssafit
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssafit` DEFAULT CHARACTER SET utf8 ;
USE `ssafit` ;

-- -----------------------------------------------------
-- Table `ssafit`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`User` (
  `user_id` VARCHAR(30) NOT NULL,
  `user_password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafit`.`Video`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`Video` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `fit_part_name` VARCHAR(45) NOT NULL,
  `channel_name` VARCHAR(45) NOT NULL,
  `view_cnt` INT NOT NULL DEFAULT 0,
  `youtube_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafit`.`Review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`Review` (
  `review_id` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(45) NOT NULL,
  `writer` VARCHAR(30) NOT NULL,
  `video_id` INT NOT NULL,
  PRIMARY KEY (`review_id`),
  UNIQUE INDEX `review_id_UNIQUE` (`review_id` ASC) VISIBLE,
  INDEX `fk_Review_User_idx` (`writer` ASC) VISIBLE,
  INDEX `fk_Review_Video1_idx` (`video_id` ASC) VISIBLE,
  CONSTRAINT `fk_Review_User`
    FOREIGN KEY (`writer`)
    REFERENCES `ssafit`.`User` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Review_Video1`
    FOREIGN KEY (`video_id`)
    REFERENCES `ssafit`.`Video` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
