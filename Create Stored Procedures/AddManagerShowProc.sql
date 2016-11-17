create procedure ManagerShowNumbersInfo
@hotelId int
as

return
select dbo.HotelNumbers.number, dbo.HotelNumbers.price,  Category.name, Category.numOfrooms, NumberState.numState, NumberState.staffId
from dbo.HotelNumbers inner join dbo.NumberState on HotelNumbers.id = NumberState.numId inner join Category on HotelNumbers.catNum = Category.id
where hId = @hotelId