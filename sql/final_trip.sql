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
  `email` VARCHAR(100) NOT NULL,
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
  `save` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_travel_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_travel_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `tripdb`.`user` (`id`) on delete cascade)
ENGINE = InnoDB
AUTO_INCREMENT = 1
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
AUTO_INCREMENT = 1
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
  `good` INT NULL DEFAULT '0',
  `write_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `writer_id` VARCHAR(20) NOT NULL,
  `sido_code` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_hotplace_user1_idx` (`writer_id` ASC) VISIBLE,
  INDEX `fk_hotplace_sido1_idx` (`sido_code` ASC) VISIBLE,
  CONSTRAINT `fk_hotplace_user1`
    FOREIGN KEY (`writer_id`)
    REFERENCES `tripdb`.`user` (`id`) on delete cascade,
  CONSTRAINT `fk_hotplace_sido1`
    FOREIGN KEY (`sido_code`)
    REFERENCES `tripdb`.`sido` (`sido_code`) on delete cascade)
ENGINE = InnoDB
AUTO_INCREMENT = 1
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
AUTO_INCREMENT = 1
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

-- -----------------------------------------------------
-- Table `tripdb`.`cartAtt`
-- -----------------------------------------------------
drop table if exists cartAtt;
CREATE TABLE IF NOT EXISTS `tripdb`.`cartAtt` (
  `attraction_id` INT NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  INDEX `fk_cartHot_attraction_info1_idx` (`attraction_id` ASC) VISIBLE,
  INDEX `fk_cartHot_user1_idx` (`user_id` ASC) VISIBLE,
  PRIMARY KEY (`attraction_id`, `user_id`),
  CONSTRAINT `fk_cartHot_attraction_info1`
    FOREIGN KEY (`attraction_id`)
    REFERENCES `tripdb`.`attraction_info` (`content_id`) on delete cascade,
  CONSTRAINT `fk_cartHot_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `tripdb`.`user` (`id`) on delete cascade)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tripdb`.`cartHot`
-- -----------------------------------------------------
drop table if exists cartHot;
CREATE TABLE IF NOT EXISTS `tripdb`.`cartHot` (
  `hotplace_id` INT NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  INDEX `fk_cartHot_hotplace1_idx` (`hotplace_id` ASC) VISIBLE,
  INDEX `fk_cartHot_user2_idx` (`user_id` ASC) VISIBLE,
  PRIMARY KEY (`hotplace_id`, `user_id`),
  CONSTRAINT `fk_cartHot_hotplace1`
    FOREIGN KEY (`hotplace_id`)
    REFERENCES `tripdb`.`hotplace` (`id`) on delete cascade,
  CONSTRAINT `fk_cartHot_user2`
    FOREIGN KEY (`user_id`)
    REFERENCES `tripdb`.`user` (`id`) on delete cascade)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tripdb`.`comment`
-- -----------------------------------------------------
drop table if exists comment;
CREATE TABLE IF NOT EXISTS `tripdb`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(1000) NOT NULL,
  `pr` TINYINT(1) NULL DEFAULT 0,
  `writer_id` VARCHAR(20) NOT NULL,
  `notice_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_user1_idx` (`writer_id` ASC) VISIBLE,
  INDEX `fk_comment_notice1_idx` (`notice_id` ASC) VISIBLE,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`writer_id`)
    REFERENCES `tripdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_notice1`
    FOREIGN KEY (`notice_id`)
    REFERENCES `tripdb`.`notice` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
AUTO_INCREMENT = 1
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- 유저 정보 더미 데이터
insert into user value ('관리자', 'admin', '86e41a3324104a4710f2a40ce65bee17a8a70082f3132e217effc01d49e6b046',
'VkUNVPcmvK0=', 'admin@admin.com', 0, 0);
insert into user value ('박정은', 'jungeun', '86e41a3324104a4710f2a40ce65bee17a8a70082f3132e217effc01d49e6b046',
'VkUNVPcmvK0=', 'evecomcom98@naver.com', 26, 0);
insert into user value ('김유진', 'yujin', '86e41a3324104a4710f2a40ce65bee17a8a70082f3132e217effc01d49e6b046',
'VkUNVPcmvK0=', 'rladbwls30@gmail.com', 25, 0);
insert into user value ('김싸피', 'ssafy', '86e41a3324104a4710f2a40ce65bee17a8a70082f3132e217effc01d49e6b046',
'VkUNVPcmvK0=', 'ssafy@ssafy.com', 30, 0);
insert into user value ('테스트', 'my', '86e41a3324104a4710f2a40ce65bee17a8a70082f3132e217effc01d49e6b046',
'VkUNVPcmvK0=', 'my@my.com', 20, 0);

-- 더미데이터 FOR 공지사항
-- 공지
insert into notice (title, content, writer_id) values ('공지사항입니다.', '공지사항을 전달드립니다.', 'admin');
insert into notice (title, content, writer_id) values ('이벤트 당첨자를 알려드립니다.', 'my님 축하드립니다.', 'admin');
-- QnA
insert into notice (title, content, writer_id) values ('질문이 있습니다~', '오늘 점심이 궁금해용.', 'jungeun');
insert into notice (title, content, writer_id) values ('이벤트 문의드려용', '누가 당첨인가요?', 'yujin');
-- 댓글
insert into comment (content, pr, writer_id, notice_id) value ('로제떡볶이입니다.', 1, 'yujin', 3);
insert into comment (content, pr, writer_id, notice_id) value ('언니 뭐 먹을거야?', 0, 'yujin', 3);
-- 더미데이터 FOR 여행
-- 여행
insert into travel (title, startdate, enddate, user_id) values ('즐거운 제주도 여행', '2023-01-01', '2023-01-03', 'jungeun');
-- 날짜별
insert into day (date, travel_id, weather) values ('2023-01-01',1, '맑음');
insert into day (date, travel_id, weather) values ('2023-01-02',1, '흐림');
insert into day (date, travel_id, weather) values ('2023-01-03',1, '맑음');
-- 날짜별 방문하는 곳
insert into dayattraction values (1, 125266);
insert into dayattraction values (1, 125405);
insert into dayattraction values (1, 125407);
insert into dayattraction values (2, 125413);
insert into dayattraction values (2, 125421);
insert into dayattraction values (3, 125432);
insert into dayattraction values (3, 125455);
-- 초대
insert into invite value (1, 'yujin');

-- 더미데이터 FOR 장바구니
insert into cartAtt(user_id, attraction_id)
values ('my', 125266);
insert into cartAtt(user_id, attraction_id)
values ('my', 125467);
insert into cartAtt(user_id, attraction_id)
values ('my', 125489);
insert into cartAtt(user_id, attraction_id)
values ('jungeun', 125266);
insert into cartAtt(user_id, attraction_id)
values ('jungeun', 125467);
insert into cartAtt(user_id, attraction_id)
values ('jungeun', 125489);