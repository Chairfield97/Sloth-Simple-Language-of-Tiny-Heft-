function fact(x) begin
    if x == 0 then
        return 1;
    else
        return x * fact(x - 1);
end

println(fact(7));

