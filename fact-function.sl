function fact(x) begin
    val := 1;
    while x > 1 do begin
        val := val * x;
        x := x - 1;
    end

    return val;
end

println(fact(4));

