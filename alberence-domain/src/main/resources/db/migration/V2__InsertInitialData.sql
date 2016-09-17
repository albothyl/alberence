USE alberence;

INSERT INTO `alberence`.`member` (`id`, `email`, `password`, `name`, `secession`, `updatedBy`, `updateAt`, `createdBy`, `createdAt`)
VALUES ('1', 'jjhwqqq@naver.com', '17b3e131f7959fb543506f59554ef7ca93254b7911a575e56abaae90a00ad785', '전형원', '0', 'system', now(), 'system', now());

INSERT INTO `alberence`.`roles` (`id`, `name`, `used`, `description`, `updatedBy`, `updatedAt`, `createdBy`, `createdAt`)
VALUES ('1', 'ROLE_ADMIN', '1', '관리자', 'system', now(), 'system', now());

INSERT INTO `alberence`.`memberAuth` (`id`, `memberId`, `roleId`, `updatedBy`, `updatedAt`, `createdBy`, `createdAt`)
VALUES ('1', '1', '1', 'system', now(), 'system', now());