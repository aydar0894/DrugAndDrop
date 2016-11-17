create procedure DatesProc
@arDate datetime,
@depDate datetime
as
begin
if(@arDate>@depDate) return 1;
else return 0;

end