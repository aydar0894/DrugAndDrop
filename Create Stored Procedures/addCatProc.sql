create procedure AddCat
@capacity int,
@numOfrooms int,
@breakfast int,
@name varchar(15)
as

begin
insert into Category(capacity,numOfrooms,breakfast,name)
values (@capacity,@numOfrooms,@breakfast,@name)
end

