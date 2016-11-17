create trigger customersTrigger
on Customers
instead of insert
as
declare @name varchar(35)
declare @gender int
declare @paymentForm varchar(10)
declare @dateOfBirth datetime
declare @ageValid int
begin

select @dateOfBirth = (select dateOfBirth from inserted)
select @name = (select custName from inserted)
select @gender = (select gender from inserted)
select @paymentForm = (select paymentForm from inserted)

EXEC @ageValid =  dbo.AgeProc @dob = @dateOfBirth

if(@gender between 0 and 1 AND @ageValid = 1 ) 
begin
insert into dbo.Customers(custName,dateOfBirth,gender,paymentForm)
values (@name,@dateOfBirth,@gender,@paymentForm)
end

else 
begin
RAISERROR ('Invalid parameters',16,-1)
end

end