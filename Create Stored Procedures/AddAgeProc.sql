create procedure AgeProc
@dob datetime
as


if((Convert ( datetime,GetDate()) - Convert ( datetime, @dob)) > Convert  ( datetime, '19180101' ) ) return 1;
else return 0;
