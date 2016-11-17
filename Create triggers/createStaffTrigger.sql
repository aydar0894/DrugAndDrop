create trigger staffTrigger
on Staff
instead of insert
as
declare @dateOfBirth datetime
declare @phone int
declare @name varchar(35)
declare @hid int
declare @salary varchar(35)
declare @position int
declare @numValid int
declare @ageValid int

begin 

select @dateOfBirth = (select dateOfBirth from inserted)
select @phone = (select phone from inserted)
select @salary = (select salary from inserted)
select @position = (select position from inserted)
select @name = (select name from inserted)
select @hid = (select hid from inserted)

EXEC @ageValid =  dbo.AgeProc @dob = @dateOfBirth
EXEC @numValid =  dbo.PhoneProc @phone = @phone
if(@ageValid = 1 AND @numValid = 1)
insert into dbo.Staff(hid,name,salary,dateOfBirth,position,phone)
values (@hid,@name,@salary,@dateOfBirth,@position,@phone)

end


