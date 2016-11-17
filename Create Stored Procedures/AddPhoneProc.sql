create procedure PhoneProc
@phone int
as
begin

if(@phone>999999999 AND @phone < 100000000000) return 0;
else return 1;

end