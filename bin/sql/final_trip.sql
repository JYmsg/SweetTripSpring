-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tripdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tripdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tripdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `tripdb` ;

-- -----------------------------------------------------
-- Table `tripdb`.`user`
-- -----------------------------------------------------
drop table if exists user;
CREATE TABLE IF NOT EXISTS `tripdb`.`user` (
  `name` VARCHAR(20) NOT NULL,
  `id` VARCHAR(20) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `salt` VARCHAR(100) NOT NULL,
  `email` VARCHAR(20) NOT NULL,
  `age` INT NOT NULL,
  `writeArticle` INT NULL DEFAULT '0',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tripdb`.`travel`
-- -----------------------------------------------------
drop table if exists travel;
CREATE TABLE IF NOT EXISTS `tripdb`.`travel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `startdate` DATE NOT NULL,
  `enddate` DATE NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_travel_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_travel_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `tripdb`.`user` (`id`) on delete cascade)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tripdb`.`day`
-- -----------------------------------------------------
drop table if exists day;
CREATE TABLE IF NOT EXISTS `tripdb`.`day` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `weather` VARCHAR(45) NULL DEFAULT NULL,
  `travel_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_day_travel1_idx` (`travel_id` ASC) VISIBLE,
  CONSTRAINT `fk_day_travel1`
    FOREIGN KEY (`travel_id`)
    REFERENCES `tripdb`.`travel` (`id`) on delete cascade)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tripdb`.`dayattraction`
-- -----------------------------------------------------
drop table if exists dayattraction;
CREATE TABLE IF NOT EXISTS `tripdb`.`dayattraction` (
  `day_id` INT NOT NULL,
  `attraction_id` INT NOT NULL,
  PRIMARY KEY (`attraction_id`, `day_id`),
  INDEX `fk_dayattraction_day1_idx` (`day_id` ASC) VISIBLE,
  CONSTRAINT `fk_dayattraction_attraction_info1`
    FOREIGN KEY (`attraction_id`)
    REFERENCES `tripdb`.`attraction_info` (`content_id`) on delete cascade,
  CONSTRAINT `fk_dayattraction_day1`
    FOREIGN KEY (`day_id`)
    REFERENCES `tripdb`.`day` (`id`) on delete cascade)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tripdb`.`hotplace`
-- -----------------------------------------------------
drop table if exists hotplace;
CREATE TABLE IF NOT EXISTS `tripdb`.`hotplace` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `latitude` DECIMAL(20,17) NOT NULL,
  `longitude` DECIMAL(20,17) NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `img` VARCHAR(45) NOT NULL,
  `hit` INT NULL DEFAULT '0',
  `like` INT NULL DEFAULT '0',
  `write_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `writer_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_hotplace_user1_idx` (`writer_id` ASC) VISIBLE,
  CONSTRAINT `fk_hotplace_user1`
    FOREIGN KEY (`writer_id`)
    REFERENCES `tripdb`.`user` (`id`) on delete cascade)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tripdb`.`invite`
-- -----------------------------------------------------
drop table if exists invite;
CREATE TABLE IF NOT EXISTS `tripdb`.`invite` (
  `travel_id` INT NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`travel_id`, `user_id`),
  INDEX `fk_invite_travel1_idx` (`travel_id` ASC) VISIBLE,
  INDEX `fk_invite_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_invite_travel1`
    FOREIGN KEY (`travel_id`)
    REFERENCES `tripdb`.`travel` (`id`) on delete cascade,
  CONSTRAINT `fk_invite_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `tripdb`.`user` (`id`) on delete cascade)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tripdb`.`likehotplace`
-- -----------------------------------------------------
drop table if exists likehotplace;
CREATE TABLE IF NOT EXISTS `tripdb`.`likehotplace` (
  `user_id` VARCHAR(20) NOT NULL,
  `hotplace_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `hotplace_id`),
  INDEX `fk_likehotplace_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_likehotplace_hotplace1_idx` (`hotplace_id` ASC) VISIBLE,
  CONSTRAINT `fk_likehotplace_hotplace1`
    FOREIGN KEY (`hotplace_id`)
    REFERENCES `tripdb`.`hotplace` (`id`) on delete cascade,
  CONSTRAINT `fk_likehotplace_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `tripdb`.`user` (`id`) on delete cascade)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tripdb`.`notice`
-- -----------------------------------------------------
drop table if exists notice;
CREATE TABLE IF NOT EXISTS `tripdb`.`notice` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT '0',
  `write_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `writer_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_notice_user1_idx` (`writer_id` ASC) VISIBLE,
  CONSTRAINT `fk_notice_user1`
    FOREIGN KEY (`writer_id`)
    REFERENCES `tripdb`.`user` (`id`) on delete cascade)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tripdb`.`review`
-- -----------------------------------------------------
drop table if exists review;
CREATE TABLE IF NOT EXISTS `tripdb`.`review` (
  `title` VARCHAR(100) NOT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `img` VARCHAR(2000) NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT '0',
  `write_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `writer_id` VARCHAR(20) NOT NULL,
  `travel_id` INT NOT NULL,
  PRIMARY KEY (`writer_id`, `travel_id`),
  INDEX `fk_review_user1_idx` (`writer_id` ASC) VISIBLE,
  INDEX `fk_review_travel1_idx` (`travel_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_travel1`
    FOREIGN KEY (`travel_id`)
    REFERENCES `tripdb`.`travel` (`id`) on delete cascade,
  CONSTRAINT `fk_review_user1`
    FOREIGN KEY (`writer_id`)
    REFERENCES `tripdb`.`user` (`id`) on delete cascade)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

select * from travel;
select last_insert_id();
insert into user values ('토끼', 'ssafy', '1234', 'test', 'test@naver.com', 12, 0);
insert into notice (title, content, writer_id) values ('test', 'test', 'ssafy');
insert into travel (title, startdate, enddate, user_id) values ('test2', '2023-01-01', '2023-01-03', 'ssafy');
insert into review (title, content, writer_id, travel_id) values ('test1', 'test1', 'ssafy', 5);
insert into hotplace (title, content, writer_id, latitude, longitude, img) values ('test1', 'test1', 'ssafy', 2.12, 2.12, 'test.png');
insert into day (date, travel_id, weather) values ('2023-01-01',7, '맑음');
insert into dayattraction values (5, 125266);