create procedure addStaff
@hId int,
@name varchar(100),
@salary int,
@dateOfBirth datetime,
@position int,
@phone int

as

insert into dbo.Staff(hId,name,salary,dateOfBirth,position,phone)
values (@hId,@name,@salary,@dateOfBirth,@position,@phone)