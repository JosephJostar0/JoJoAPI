-- 接口信息表
use bearapi;

create table if not exists bearapi.`interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDeleted` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)',
    `apiName` varchar(256) not null comment 'api名称',
    `description` varchar(256) not null comment 'api描述',
    `url` varchar(512) not null comment '接口地址',
    `requestHeader` text not null comment '请求头',
    `requestParams` text not null comment '请求参数',
    `responseHeader` text not null comment '响应头',
    `status` int not null comment '接口状态(0-关闭,1-开启)',
    `method` varchar(256) not null comment '请求类型',
    `userId` bigint not null comment '创建人'
    ) comment '接口信息表';

insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('电源', 'Assembly', 'www.yang-barton.biz', '计算机科学与技术', 'diamond.ryan@yahoo.com', 0, '小学', 55348);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('主板', 'JavaScript', 'www.ciera-howe.biz', '计算机科学与技术', 'kenton.satterfield@hotmail.com', 1, '博士', 32070);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('网卡', 'Pascal', 'www.christoper-bechtelar.co', '软件工程', 'isaias.ankunding@yahoo.com', 1, '高中', 40004);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('键盘', 'D', 'www.keenan-conn.co', '大数据科学与技术', 'otis.hettinger@yahoo.com', 0, '专科', 7843481);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('光驱', 'Ruby', 'www.christian-hettinger.info', '计算机科学与技术', 'ernesto.vandervort@yahoo.com', 0, '研究生', 5276299);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('电源', 'Common Lisp', 'www.marcella-trantow.name', '计算机科学与技术', 'chance.hauck@yahoo.com', 0, '高中', 45067);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('机箱', 'Smalltalk', 'www.laine-stoltenberg.net', '计算机科学与技术', 'josue.bergnaum@gmail.com', 0, '本科', 6712813);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('CPU', 'C', 'www.lilia-crona.net', '大数据科学与技术', 'annika.hammes@yahoo.com', 1, '博士', 385);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('显卡', 'Common Lisp', 'www.zina-skiles.name', '软件工程', 'jacquelynn.bechtelar@hotmail.com', 1, '初中', 938);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('打印机', 'Groovy', 'www.faustino-auer.name', '计算机科学与技术', 'gina.hettinger@hotmail.com', 1, '小学', 5576198849);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('光驱', 'Tcl', 'www.phoebe-cruickshank.io', '大数据科学与技术', 'kimbra.harvey@yahoo.com', 1, '博士', 9681373609);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('光驱', 'Hack', 'www.arlean-batz.io', '计算机科学与技术', 'adolfo.hegmann@yahoo.com', 0, '本科', 719);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('鼠标', 'X++', 'www.hisako-yundt.name', '软件工程', 'markus.cassin@gmail.com', 1, '初中', 65);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('硬盘', 'Korn shell', 'www.ronnie-bahringer.biz', '计算机科学与技术', 'wilford.olson@hotmail.com', 0, '专科', 8309397707);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('键盘', 'ABAP', 'www.fredia-stark.co', '计算机科学与技术', 'irvin.jacobson@gmail.com', 1, '高中', 1527810472);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('硬盘', 'Smalltalk', 'www.ken-wuckert.biz', '软件工程', 'rodolfo.willms@hotmail.com', 0, '初中', 57997419);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('打印机', 'PHP', 'www.doyle-batz.name', '软件工程', 'jared.hills@hotmail.com', 0, '本科', 2866);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('电源', 'Common Lisp', 'www.ruthe-wiegand.name', '计算机科学与技术', 'milton.haley@hotmail.com', 1, '初中', 2846);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('内存', 'JavaScript', 'www.chrissy-lockman.org', '计算机科学与技术', 'monet.murphy@gmail.com', 1, '高中', 723115133);
insert into bearapi.`interface_info` (`apiName`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('网卡', 'Korn shell', 'www.tammi-hudson.com', '计算机科学与技术', 'pierre.gibson@hotmail.com', 0, '本科', 8565);

use bearapi;

-- 用户调用接口关系表
create table if not exists bearapi.`user_interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `userId` bigint not null comment '调用用户 id',
    `interfaceInfoId` bigint not null comment '接口 id',
    `totalNum` int default 0 not null comment '总调用次数',
    `leftNum` int default 0 not null comment '剩余调用次数',
    `status` int default 0 not null comment '0-正常，1-禁用',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDelete` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '用户调用接口关系';
