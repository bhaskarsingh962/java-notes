## type of function
call by value call by refrence in java 
mutable immmutable
premitive non premitive
scope
shadowing
var length args


## What is a Function in Java?
In Java, a function is technically called a method. It's a block of code that performs a specific task, defined inside a class.


return_type function_name(parameters) {
    // body
    return value;
}
🔸 Example:

public int add(int a, int b) {
    return a + b;
}


## 🔹 2. Static Function in Java
## ✅ What is a static function?
A static function belongs to the class, not to instances (objects).

You can call it without creating an object of the class.

✅ Syntax:

public class MyClass {
    static void sayHello() {
        System.out.println("Hello!");
    }
}
✅ Call:

MyClass.sayHello(); // No object needed
🔹 Where can static methods be accessed?
From	How
Same class	Directly: sayHello()
Other class	Using class name: MyClass.sayHello()

❗ Limitations:
Cannot access non-static variables/methods directly.

Can only access static data directly.

Cannot use this or super.

## 🔹 3. Call by Value vs Call by Reference
✅ Call by Value (Java default):
When you pass primitive data types, a copy of the value is passed.

Original value remains unchanged.


void change(int x) {
    x = 10;
}

int a = 5;
change(a); 
System.out.println(a); // Still 5


## ✅ Call by Reference (Not exactly in Java):
Java passes references by value when using objects.

Changes to the object inside the method affect the original.


void modifyArray(int[] arr) {
    arr[0] = 99;
}

int[] myArr = {1, 2, 3};
modifyArray(myArr);
System.out.println(myArr[0]); // 99


## 🔹 4. Scope in Java
✅ Scope means where a variable can be accessed.
Type	Defined in	Accessible in
Local	Inside method/loop	Only within that block
Instance	Non-static in class	Throughout the class via object
Class (static)	static variable in class	Accessible using class name
Parameter	Method definition	Only within that method

## 🔹 5. Shadowing in Java
Shadowing happens when a local variable has the same name as a class-level variable.


class Test {
    int x = 5;

    void show() {
        int x = 10;
        System.out.println(x); // prints 10, shadows class variable
    }
}
Use this.x to access the class-level variable.



## 🔹 6. Varargs (Variable Length Arguments)

Allows passing 0 or more arguments to a method.
✅ Syntax:

public void printNames(String... names) {
    for (String name : names) {
        System.out.println(name);
    }
}
✅ Call:

printNames("Ram", "Shyam", "Geeta");
⚠️ Rules:
You can only have one vararg parameter, and it must be last.

java
void example(int a, String... names) {}

// ❌ Error
// void example(String... names, int a) {}
🔥 FAANG-Level Insight:
Interviewers want you to:

Explain how memory works with methods (stack vs heap).

Show understanding of immutability vs mutability (e.g., primitives vs objects).

Know when to use static methods (e.g., utility functions).

Demonstrate safe handling of references (e.g., avoiding NullPointerException).

✅ Summary Table
Concept	Key Point
Function/Method	Block of code inside a class
Static Method	Belongs to class, not object
Call by Value	Primitives → value copied
Call by Reference	Objects → reference copied (affects original)
Scope	Where a variable is visible
Shadowing	Local var hides outer one with same name
Varargs	Accepts variable number 





## 1. Primitive in Java

These are the basic data types built into Java.

They are not objects.

They store actual values directly in memory.

✅ Example:

int a = 10;     // stores the value 10 directly
double b = 20.5;
char c = 'A';
boolean d = true;


👉 Java has 8 primitives: byte, short, int, long, float, double, char, boolean.

## 2. Non-Primitive in Java

These are objects (reference types).

They store the reference (memory address) of the object, not the value directly.

Examples: String, Arrays, Classes, Interfaces, Wrapper classes.

✅ Example:

String name = "Bhaskar";     // reference to a String object
int[] arr = {1, 2, 3};       // reference to an array object

## 3. Mutable in Java

Mutable means the object’s value can be changed after creation.

✅ Example: StringBuilder and ArrayList are mutable.

StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");  // changes the original object
System.out.println(sb); // Output: Hello World

## 4. Immutable in Java

Immutable means once the object is created, its value cannot be changed.

If you modify it, a new object is created instead.

✅ Example: String in Java is immutable.

String str = "Hello";
str = str.concat(" World"); // creates a new String object
System.out.println(str);    // Output: Hello World

📌 Quick Summary
Type	Definition	Example
Primitive	Basic data types (not objects), store value directly	int a = 10;
Non-Primitive	Objects or references	String s = "Hi";
Mutable	Can be changed after creation	StringBuilder, ArrayList
Immutable	Cannot be changed once created	String