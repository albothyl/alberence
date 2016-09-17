USE alberence;

CREATE TABLE `apples` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '사과의 id',
  `name` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '사과 이름',
  `color` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '사과 색깔',
  `weight` int(11) NOT NULL COMMENT '사과 무게',
  `area` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '사과 생산지',
  `price` bigint(10) NOT NULL COMMENT '사과 단가',
  `updatedBy` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '수정자',
  `updatedAt` datetime NOT NULL COMMENT '수정 일시',
  `createdBy` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '생성자',
  `createdAt` datetime NOT NULL COMMENT '생성 일시',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='java 연습용 테이블';

CREATE TABLE `members` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '회원 시퀀스',
  `email` varchar(50) NOT NULL COMMENT '회원 이메일',
  `password` varchar(100) NOT NULL COMMENT '회원 계정 비밀번호',
  `name` varchar(45) NOT NULL COMMENT '회원 이름',
  `secession` tinyint(1) NOT NULL DEFAULT '0' COMMENT '탈퇴여부 default : 0',
  `updatedBy` varchar(45) NOT NULL COMMENT '수정자',
  `updatedAt` datetime NOT NULL COMMENT '수정일시',
  `createdBy` varchar(45) NOT NULL COMMENT '생성자',
  `createdAt` datetime NOT NULL COMMENT '생성일시',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '역할 시퀀스',
  `name` varchar(45) NOT NULL COMMENT '역할명',
  `used` tinyint(1) NOT NULL DEFAULT '1' COMMENT '역할 사용여부 default : 1',
  `description` varchar(150) DEFAULT NULL COMMENT '역할 설명',
  `updatedBy` varchar(45) NOT NULL COMMENT '수정자',
  `updatedAt` datetime NOT NULL COMMENT '수정일시',
  `createdBy` varchar(45) NOT NULL COMMENT '생성자',
  `createdAt` datetime NOT NULL COMMENT '생성일시',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `memberAuth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '회원 역할 시퀀스',
  `memberId` bigint(20) NOT NULL COMMENT '회원 시퀀스',
  `roleId` bigint(20) NOT NULL COMMENT '역할 시퀀스',
  `updatedBy` varchar(45) NOT NULL,
  `updatedAt` datetime NOT NULL,
  `createdBy` varchar(45) NOT NULL,
  `createdAt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
