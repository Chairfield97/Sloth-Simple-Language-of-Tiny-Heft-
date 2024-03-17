% program to calculate factorials

% get input
print("Please enter a number: ");
x := readInt();

counter := x;
fact := 1;

% a loop!
while counter > 1 do begin
    fact := fact * counter;
    counter := counter - 1;
end

% output
println(x + "! = " + fact);

