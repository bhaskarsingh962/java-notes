## key = the identifier used to retrieve the value

## value - data assosiated with key

## bucket - where key value pair is store(think of bucket as cells in a list ( array ))



///////
## hashFunction - converts a key into an index (bucket location for storage)
A hash function is an algorithm that takes an input (or key) and return a fixed - size string of bytes, typically a numerical value. the output is known as a hash code, hash value , or simply hash. the primary purpose of a hash function is to map data of arbitrary size to data of fixed size .
 
# deterministicl - The same input always perduce same output
# fixed output size - regardless of the size , the hash code has a consistent size (eg, 32-bit, 64bit)
# Efficient Computation - the hash function should compute hash quickly



////////
## how data is store in hashmap 
# step1 - Hashing the key
first the key is passed through a hashfunction to generate aa unique hash code (an integer number). This hash code  helps determine where thekey - value pair will be store in the array (called a "bucket array")

# step2 - Calculating the index

the hash code is then used to calculate an index in the array (bucket location ) using
int index = hashcode % arraysize

the index decides which bucket will hold this key- value pair

for example , if the array size is 16, the key's hash code will be divided by 16, and the remainder will be the index.

# step3 - Storing in the Bucket 

The key value pair is stored in the bucket at the calculate index . Each bucket can hold multiple key-value pairs
(this is called a collision handling mechanism, dixcussed later)



//////
# collision -
collision is basically when two key have same hash code and then they will get same index in bucket this is collsion problem in hashmap


//////
## how Hashmap retrieves a Data
when we call get(key), the hashmap followes these steps:

# 1 - Hashing the key : 
similar to insertion, the key is hashing using the same hash function to calculate its hash code.

# 2 - finding the index :
The hash code is used to find the index of the bucket where the key- value pair is stored

# 3 - searching in the bucket :
once the correct bucket is found, it checks for the key in that bucket. if it findes the key, it returns the assoiciated value.

## handling collsion 
since different keys can generate the same index (called a collsion), hashmap uses a technique to handle this situation. java's hashmap uses - 
# linkedlist  - which take o(n) time colplaxity becouse of linear search 
key value pair stored in linked list inside the bucket
when key value pair is retrived, the hashmap traverse the linked list, checking each key untill it findes a match

it's get converted automatically after certain limit in - (blanace tree) after java 8 - becouse of higher complaxity.
# balanced tree after java 8 - it takes 0(log n) becouse of binary search

///////////////

## hashmap resizing (rehashing) -

hashmap has and internal array size, which by defoult is 16.
when the number of elements (key-value pairs) grows and exceed a certain load factor (defoult is 0.75), hashmap automatically resizes the array to hold more data. This process is called rehashing.

The default size of the array is 16, so when more than 12 elements (16*0.75) are inserted, the hashmap will resize.

you can manually and initialcapicity and loadfactor while making hashmap
HashMap<Integer, Integer> map = new HashMap<>(intialCapacity: 17, loadFactor: 0.5f);

# During rehashing
The array size is double 
1- all existing entries are rehashed (i.e their position are recalculated) and placed into the new array.
2- This ensures the hashmap continue to perform efficiently even as more data is added

////////////

## the complaxity
hashmap proviodes constent time o(1) performance for basic operations like put() and get() (assuming no collision)

# put, get, remove, containesKey
average o(1) 
worst case o(log n)
due to collision

# contiansValue
average o(1) 
worst case o(n)

# size - o(1)

in the caase of collsion using linked list o(n)
where n is the number of element in that bucket

but after java 8 , if there are too many elements in a bucket hashMap switches to a balance tree instead of a linded list to ensure better performance