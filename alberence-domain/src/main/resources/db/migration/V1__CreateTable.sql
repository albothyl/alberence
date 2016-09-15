USE alberence;

CREATE TABLE `apple` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '사과의 id',
  `name` varchar(45) NOT NULL COMMENT '사과 이름',
  `color` varchar(45) NOT NULL COMMENT '사과 색깔',
  `weight` int(11) NOT NULL COMMENT '사과 무게',
  `area` varchar(45) NOT NULL COMMENT '사과 생산지',
  `price` bigint(10) NOT NULL COMMENT '사과 단가',
  `updatedBy` varchar(45) NOT NULL COMMENT '수정자',
  `updatedAt` datetime NOT NULL COMMENT '수정 일시',
  `createdBy` varchar(45) NOT NULL COMMENT '생성자',
  `createdAt` datetime NOT NULL COMMENT '생성 일시',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT = 'java 연습용 테이블';
