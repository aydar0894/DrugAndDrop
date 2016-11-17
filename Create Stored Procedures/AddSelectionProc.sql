create procedure selection
@capacity int,
@location varchar(35),
@fromDate datetime,
@toDate datetime
as

return

SELECT T1.name, T1.pictUrl, T2.id, T2.hId, T2.catNum, T2.price, T2.number
 
FROM (select * from dbo.Hotels where  dbo.Hotels.hotelLocation = @location) as T1

INNER JOIN 
  (select dbo.HotelNumbers.id, dbo.HotelNumbers.hId, dbo.HotelNumbers.catNum, 
      dbo.HotelNumbers.price, dbo.HotelNumbers.number, dbo.Category.capacity, 
      dbo.Category.numOfrooms 
   from dbo.HotelNumbers
  
   inner join dbo.Category 
   on dbo.HotelNumbers.catNum = dbo.Category.id 
   where dbo.Category.capacity >= @capacity) as T2
on T1.id = T2.hId

left outer JOIN 
  (select T11.id , T11.nId
   from (dbo.Rent as T11 left outer join dbo.HotelNumbers
   on dbo.HotelNumbers.id = T11.nId)
   where (T11.arrivalDate = NULL AND T11.dateOfDeparture = NULL) OR (NOT(@fromDate >= T11.arrivalDate AND @fromDate < T11.dateOfDeparture) 
AND NOT(@toDate >= T11.arrivalDate AND @toDate < T11.dateOfDeparture))) as T3
ON T2.id = T3.nId

Order by T2.price