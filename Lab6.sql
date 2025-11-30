create database Lab6

use Lab6

create table Users(
    Id nvarchar(50) primary key,
    Password nvarchar(50) not null,
    Fullname nvarchar(100) not null,
    Email nvarchar(100) not null,
    Admin bit default 0
)

insert into Users(id, password, fullname, email, admin) values
(N'admin', N'123', N'Anh A', N'admin@fpt.edu.vn', 1),
(N'user', N'123', N'Anh B', N'user@fpt.edu.vn', 0);

select * from Users