## int[] arr = new int[7]
 this int show what kind of data you can store here

 arr refrence variable that contain new array object refrence which has type int

1. arr is a reference variable
arr is not the array itself — it is a reference (or pointer) to an object in memory.

In Java, arrays are objects, and variables like arr hold references to those objects.

✅ 2. It contains a new array object reference
new int[5] creates a new array object in heap memory that can store 5 integers.

arr holds the reference (memory address) of that new array object.

✅ 3. Which has type int
This means the array is of type int[], i.e., it stores integer values.

All 5 elements in the array are of int type, and by default, they are initialized to 0.



## other way
int[] arr = {3,5,6};
all value should have same data type


## int[] arr - 

here arr is decalring and creating the variable in stack memory
it happence in complile time

## new int[7]
here the arr is initializing in heap memory
run time


## diagram

## Java Memory Allocation (Stack vs Heap)

### Code
```java
int[] arr = new int[5];
```

### Stack and Heap Diagram

Stack Memory                  Heap Memory
--------------------------    ---------------------------
| arr (reference)        | →  |  new int[5]               |
|------------------------|    |---------------------------|
                             | [0] [0] [0] [0] [0]        |
                             |---------------------------|

<!-- ```

- `arr` is a reference variable stored in **Stack**.
- `new int[5]` creates an array object in **Heap** memory.
- The elements in the heap array are initialized to `0` by default. -->


## What is stored continuously?
Arrays (like int[], String[]) are stored contiguously in the heap.

But object instances (like new Student(), new Car()) may be stored in non-contiguous locations, based on memory availability and garbage collection.


##  Why Not Continuous for Objects?
Because:
Java uses heap fragmentation, where space is reused.

Memory might be scattered depending on what's already allocated or freed.

The JVM optimizes allocation for performance, not necessarily continuity.

## array is mutable but String is imutable 

whene we passs the arrray in any function it changes the value of main array

## you can change the contents (elements) of the array after it is created.
For example:

int[] arr = {1, 2, 3};
arr[0] = 100;  // ✅ You changed the value at index 0
System.out.println(arr[0]);  // Output: 100
So the reference to the array stays the same, but the data inside (the elements) can be modified. This is what makes arrays mutable.



///////////////// 2d ARRAY ////////////////////

int[][] arr = new int[4][]

## Why column size is not required?
Because Java allows jagged arrays.

✅ A 2D array in Java is not truly a table — it’s an array where each element is a 1D array. Each row can have a different number of columns.

So you're allowed to first declare the number of rows, and later define column size for each row individually, like this:

int[][] arr2D = {
    {1,2,4},
    {1,3},
    {3,4,5}
}

for 2d array for each loop can be used like that 
for(int[] a : arr){
  system.out.prinln(a);  
}

