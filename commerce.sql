create database commerce;
use commerce;
show tables;
create table usertable(
emailId varchar(225) PRIMARY KEY,
userName varchar(225),
pass varchar(225),
userType varchar(225));
use usertable;
select * from usertable;
Insert Into usertable values("abhi@gmail.com", "Abhishak", "1234", "Buyer");
Insert Into usertable values("sam@gmail.com", "samuel", "1234", "Buyer");
Insert Into usertable values("stark@gmail.com", "Stark", "1234", "Seller");
Insert Into usertable values("tony@gmail.com", "tony", "1234", "Seller");
select * from usertable;
create table Product(
ProductId int PRIMARY KEY,
ProductName varchar(225),
Price float,
sellerId varchar(225),
foreign key(sellerId) references usertable(emailId));
use product;
Insert into product values(1, "Car", 800000, "tony@gmail.com");
Insert into product values(2, "Bike", 50000, "stark@gmail.com");
Insert into product values(3, "Laptop", 16000, "tony@gmail.com");
Insert into product values(4, "Mobile", 25000, "stark@gmail.com");
select * from product;
create table orders(
OrderId int PRIMARY KEY,
ProductID int,
userId varchar(225),
foreign key(ProductID) references product(ProductId),
foreign key(userId) references usertable(emailId));
select * from orders;
use commerce;
show tables;

