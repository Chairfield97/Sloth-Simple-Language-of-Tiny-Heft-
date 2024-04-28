% a recursive merge sort program

% the merge function merges two sorted sub-arrays into one
function merge(array, start, last) begin
    middle := (start + last) / 2;
    temp := [];

    left := start;
    right := middle + 1;

    while (left <= middle) && (right <= last) do begin
        % if the left half value is less than right
        if array[left] < array[right] then begin
            temp := temp + [array[left]];
            left := left + 1;
        end else begin
            temp := temp + [array[right]];
            right := right + 1;
        end
    end

    % add the remaining elements from the left half
    while left <= middle do begin
        temp := temp + [array[left]];
        left := left + 1;
    end

    % add the remaining elements from the right half
    while right <= last do begin
        temp := temp + [array[right]];
        right := right + 1;
    end

    % move from temp array to the original array
    i := start;
    while i <= last do begin
        array[i] := temp[i - start];
        i := i + 1;
    end
end

% the actual merge sort method
function mergeSort(array, start, last) begin
    if start < last then begin
        middle := (start + last) / 2;

        % sort left half
        mergeSort(array, start, middle);

        % sort right half
        mergeSort(array, middle + 1, last);

        % merge the two halves
        merge(array, start, last);
    end
end


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

% sort them
mergeSort(nums, 0, size - 1);

println("After sorting: " + nums);



