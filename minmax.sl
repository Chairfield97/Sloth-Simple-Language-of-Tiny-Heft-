% find the smallest and largest of a set of numbers

% get the amount of numbers to input
print("How many numbers? ");
N := readInt();
min := 99999999;
max := -99999999;

while N > 0 do begin
    % get the next number
    print("Next: ");
    x := readInt();

    % check if it's the min
    if x < min then
        min := x;   % set it

    % check if it's the max
    if x > max then
        max := x;   % set it

    % keep counting
    N := N - 1;
end

% print the min and max
println("Smallest is " + min);
println("Biggest is " + max);

