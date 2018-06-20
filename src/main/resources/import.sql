insert into sys_user (ID, AVATAR, EMAIL, NAME, PASSWORD, USERNAME)
values (4, null, 'zongxingh@163.com', '黄宗兴', '$2a$10$sKy37yyDfQtt65nT0sPr/u/ShXJdt.D.h4oWCtw60CuyLhx2tQ8cG', 'zongxingh');

insert into sys_user (ID, AVATAR, EMAIL, NAME, PASSWORD, USERNAME)
values (1, null, 'zongxing.haung@wisdragon.com', '大黄', '$2a$10$sKy37yyDfQtt65nT0sPr/u/ShXJdt.D.h4oWCtw60CuyLhx2tQ8cG', 'admin');

insert into sys_user (ID, AVATAR, EMAIL, NAME, PASSWORD, USERNAME)
values (2, null, 'zongxingh@126.com', '大哈', '$2a$10$sKy37yyDfQtt65nT0sPr/u/ShXJdt.D.h4oWCtw60CuyLhx2tQ8cG', 'huang.zongxing');


insert into sys_auth (ID, NAME)
values (1, 'ROLE_ADMIN');

insert into sys_auth (ID, NAME)
values (2, 'ROLE_USER');


insert into sys_user_auth (USER_ID, AUTH_ID)
values (4, 2);

insert into sys_user_auth (USER_ID, AUTH_ID)
values (1, 1);

insert into sys_user_auth (USER_ID, AUTH_ID)
values (2, 2);


insert into blog_catalog (ID, NAME, USER_ID)
values (22, '数据库', 4);

insert into blog_catalog (ID, NAME, USER_ID)
values (23, 'Java开发', 4);

insert into blog_catalog (ID, NAME, USER_ID)
values (24, 'C/C++开发', 4);

insert into blog_catalog (ID, NAME, USER_ID)
values (25, '运维', 4);


