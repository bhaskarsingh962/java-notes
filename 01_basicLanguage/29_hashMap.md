## if we have any array like - a[] = {"bhaskar", "ravi", "jay"};
now hashfunction wil hash the values
hash("bhaskar") -- 57473 - now to make it btw 1 to 10  it applies modulo 
but in that case multiple string can have same value that means collision will occures

## if collision occures ib that case hash map store value as a linked list like for any index
 0-> bhaskar -> ravi -> jay worst case all the value generate same value