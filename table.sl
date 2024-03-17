% read the size of the table
print("What size table would you like? ");
size := readInt();

% loop through each row
row := 1;
while row <= size do begin
    col := 1;
    while col <= size do begin
        print((row * col) + "    ");
        col := col + 1;
    end
    row := row + 1;
    println("");
end
    
