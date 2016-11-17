create procedure ManagerShowStaff
@hotelId int
as

return
select name,salary,dateOfBirth,position,phone
from Staff
where Staff.hId = @hotelId