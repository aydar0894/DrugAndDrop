create trigger RentTrigger
on Rent
instead of insert
as
declare @arrivalDate datetime
declare @dateOfDeparture datetime
declare @hId int
declare @totalPrice float
declare @nId int
declare @cId int
declare @validDates int
begin 

select @arrivalDate = (select arrivalDate from inserted)
select @dateOfDeparture = (select dateOfDeparture from inserted)
select @hId = (select hId from inserted)
select @totalPrice = (select totalPrice from inserted)
select @nId = (select nId from inserted)
select @cId = (select cId from inserted)

EXEC @validDates = dbo.DatesProc @arDate =  @arrivalDate,@depDate = @dateOfDeparture

if(@validDates = 1)
begin

insert into dbo.Rent(hId,totalPrice,nId,cId,dateOfDeparture,arrivalDate)
values (@hId,@totalPrice,@nId,@cId,@dateOfDeparture,@arrivalDate)
end
else 
raiserror('invalid dates',16,-1)

end