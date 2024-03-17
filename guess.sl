% set initial values for our variables
min := 1;
max := 100;
done := false;

while !done do begin
    % ask them if this is their number or not
    G := (max + min) / 2;
    print("Is your number " + G + "? ");
    answer := readString();

    % respond to their answer
    if answer == "yes" then
        done := true;
    else if answer == "low" then
        min := G + 1;
    else if answer == "high" then
        max := G - 1;
    else
        println("Answers are 'yes', 'low', or 'high'.");
end

% when we exit the loop, we have guessed the number
println("Got it!");

