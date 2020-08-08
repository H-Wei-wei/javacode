drop database if exists java_order_system;
create database java_order_system;

use java_order_system;

drop table if exists user;
create table user(
    UserId int primary key auto_increment,
    name varchar(10) unique,
    password varchar(10),
    isAdmin int   -- 是否是管理员，0 表示不是，1 表示是
);

drop table if exists dishes;
create table dishes(
    dishId int primary key auto_increment,
    name varchar(10),
    price int  -- 以分为单位
);

drop table if exists order_user;
create table order_user(
    orderId int primary key auto_increment,
    userId int, -- 用户 id 需要和 user表中的 id 有关联关系
    time datetime, -- 下单时间
    isDone int, -- 1 表示订单完结， 0 表示未完结
    foreign key(userId) references user(userId)
);

drop table if exists order_dish;
create table order_dish(
    orderId int,
    dishId int,
    foreign key(orderId) references order_user(orderId),
    foreign key(dishId) references dishes(dishId)
);
