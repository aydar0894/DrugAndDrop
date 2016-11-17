create procedure rentProc
@custName varchar(100),
@dateOfBirth datetime,
@gender int,
@paymentForm int,
@hId int,
@totalPrice float,
@nId int,
@arrivalDate datetime,
@dateOfDeparture datetime,
@username varchar(100)

as

declare @cId int
begin try

insert into Customers(custName,dateOfBirth,gender,paymentForm)
values (@custName,@dateOfBirth,@gender,@paymentForm)

set @cId = (select max(id) from Customers)

insert into Rent(hId,totalPrice,nId,cId,dateOfDeparture,arrivalDate)
values (@hId,@totalPrice,@nId,@cId,@dateOfDeparture,@arrivalDate)

update users
set cId = @cId where username = @username

end try

begin catch
raiserror('invalid Data!', 16,1)

end catch