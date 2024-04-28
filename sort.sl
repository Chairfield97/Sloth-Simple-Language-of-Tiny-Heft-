% see how many numbers we want
print("How many numbers? ");
size := readInt();

% read in the array of numbers
i := 0;
nums := [];
while i < size do begin
    print("Next: ");
    nums := nums + readInt();
    i := i + 1;
end

println("Before sorting: " + nums);

% bubble sort algorithm
sorted := false;
while !sorted do begin
    sorted := true;

    i := 0;
    while i < (length(nums) - 1) do begin
        % println(nums);
        % println("length: " + length(nums));
        if nums[i] > nums[i + 1] then begin
            temp := nums[i];
            nums[i] := nums[i + 1];
            nums[i + 1] := temp;
            sorted := false;
            % println(sorted);
        end
        i := i + 1;
        % println(i);
    end
end


println("After sorting: " + nums);

