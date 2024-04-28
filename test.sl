nums := [1, 3, 2, 5, 4];
i := 0;
println(nums);
while i < (length(nums) - 1) do begin
    % println("length: " + length(nums));
    % println(nums);
    if nums[i] > nums[i + 1] then begin
        println(i);
        temp := nums[i];
        println(nums[i]);
        nums[i] := nums[i + 1];
        println(nums[i]);
        println(nums[i+1]);
        nums[i + 1] := temp;
        println(nums[i+1]);
        %sorted := false;
        % println(temp);

        % println(nums[i+1]);
    end
    i := i + 1;
end
println(nums);