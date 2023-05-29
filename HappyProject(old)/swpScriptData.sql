Drop database SWP391
GO
Create database SWP391
GO
Use SWP391
GO

Create table [Role](
role_id int identity(1,1) primary key,
role_name Nvarchar(100) not null)

insert into [Role] values('Mentee' ),( 'Mentor' ),('Admin')


Create table Skills(
skill_id int identity(1,1) primary key,
Skill_name Nvarchar(100) not null)

Create Table [User](
[uid] int identity(1,1) primary key,
username nvarchar(100) not null,
[password] nvarchar(100) not null,
fullname nvarchar(150) ,
dob date,
sdt nvarchar(150),
[address] nvarchar(240),
[role] int foreign key references [Role](role_id),
user_status bit  default 1 , -- de active user hoac deactive (block user)
mentor_status bit  default 1 , -- de mentor co the chinh trang thai active nhan request hoac deactive ko nhan request
avg_rate int default 0,
create_time datetime not null
)


Create table Tbl_cv(
cv_id int identity(1,1) primary key,
contact nvarchar(3000), -- link facebook ....
professional_summary nvarchar(3000),
education nvarchar(1000),
work_experience  nvarchar(3000),
achievements nvarchar(3000),
cv_status bit  default 1 , -- de an hoac hien cv
)

Create table Cv_of_mentor( -- bang trung gian giua cv va user
cv_id int foreign key references tbl_CV(cv_id),
mentor_id int foreign key references [User]([uid])
Primary key (cv_id,mentor_id)
)

Create table skill_of_cv( -- bang trung gian giua skill va user 
cv_id int foreign key references Tbl_cv(cv_id), 
skill_id int foreign key references Skills(skill_id)
Primary key (cv_id,skill_id)

)

Create table Request_status(
status_id int identity(1,1) primary key,
[Name] nvarchar(100) not null,
)

insert into Request_status values('UnCheck') ,( 'Processing') ,('Finish' ), ('Rejected') -- trang thai cua request


Create table Request(
mentee_id int foreign key references [User]([uid]),
mentor_id int foreign key references [User]([uid]), 
skill_id int foreign key references Skills(skill_id), 
Request_status int foreign key references Request_status(status_id),
created_date date,
finish_date date,
Primary key (mentee_id,mentor_id,skill_id,created_date)

)

Create table Comment(
comment_id int identity(1,1) primary key,
mentee_id int foreign key references [User]([uid]),
mentor_id int foreign key references [User]([uid]), 
comment_content nvarchar(3000) not null,
)
Create Table Rate(
mentee_id int foreign key references [User]([uid]),
mentor_id int foreign key references [User]([uid]), 
Rated_point int not null,
Primary key (mentee_id,mentor_id)
)