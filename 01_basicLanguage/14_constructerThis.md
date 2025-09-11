//constructer
//this keyword
//new keyword
//wrapper class
//final keyword
//garbage collector


## what is the constructer in java and what is this key word and why we use it explain everything 

Let's learn Java Constructors and the this keyword from beginner to advanced — step by step with simple explanations and examples.

##  What is a Constructor in Java?
✅ Definition:
A constructor is a special method used to create and initialize objects in Java.

## 💡 Key Points:
It has the same name as the class.

It does not have a return type (not even void).

It is automatically called when you create an object using new.

🧪 Example 1: Basic Constructor

class Student {
    // Constructor
    Student() {
        System.out.println("Constructor called!");
    }

    void greet() {
        System.out.println("Welcome, student!");
    }

    public static void main(String[] args) {
        Student s1 = new Student();  // Constructor is automatically called here
        s1.greet();
    }
}
🟢 Output:
Constructor called!
Welcome, student!


## 🔄 Types of Constructors

## 1. Default Constructor
No parameters.

Java gives a default constructor if you don't write one.

java
class Dog {
    Dog() {
        System.out.println("Dog is created");
    }
}



## 2. No-argument Constructor (User-defined Default)

A constructor without parameters, but defined by you.

Used when you want to set initial values.

Example:

class Student {
    String name;
    int age;

    // No-argument constructor
    Student() {
        name = "Bhaskar";
        age = 23;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1.name + " " + s1.age);
    }
}


👉 Output:

Bhaskar 23


## 3. Parameterized Constructor
You pass values (parameters) to set data when creating the object.

class Dog {
    String name;

    Dog(String dogName) {
        name = dogName;
    }

    void display() {
        System.out.println("Dog's name is: " + name);
    }

    public static void main(String[] args) {
        Dog d1 = new Dog("Bruno");
        d1.display();  // Dog's name is: Bruno
    }
}


## 4🔹 What is a Copy Constructor in Java?

A Copy Constructor is a special type of constructor that is used to create a new object as a copy of an existing object.
In Java, it’s not provided by default (unlike C++), but we can create it manually.

🔹 Syntax of Copy Constructor
class ClassName {
    int x;
    
    // Copy Constructor
    ClassName(ClassName obj) {
        this.x = obj.x;  // copying value from existing object
    }
}

🔹 Example
class Student {
    int id;
    String name;

    // Parameterized constructor
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Copy constructor
    Student(Student s) {
        this.id = s.id;
        this.name = s.name;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

public class CopyConstructorExample {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Bhaskar");   // original object
        Student s2 = new Student(s1);               // copy constructor

        s1.display();  // ID: 101, Name: Bhaskar
        s2.display();  // ID: 101, Name: Bhaskar
    }
}

## 🔹 Key Points

Java doesn’t create a copy constructor automatically, we must define it explicitly.

Copy constructor is an alternative to clone() method (from Object class).

If the class has mutable objects (like arrays, lists, etc.), the copy constructor should handle deep copy to avoid shared references.



## 🔹 Summary (Interview Notes)

Default Constructor: Created by compiler if no constructor is defined.

No-arg Constructor: Written by programmer, takes no arguments.

Parameterized Constructor: Written by programmer, takes arguments to initialize objects.

📌 Important Points:

If no constructor is written → compiler gives default constructor.

If any constructor is written → compiler does not give default constructor.

Constructors can be overloaded (multiple constructors with different parameter lists).








## 🔁 What is the this Keyword?
✅ this refers to current object of the class.
We use this to:

Refer to instance variables (when parameter name and variable name are same)

Call other constructors

Pass current object as an argument

Return current object

🧪 Example 2: this to refer to instance variable
class Car {
    String model;

    Car(String model) {
        this.model = model;  // 'this.model' is the class variable, 'model' is the parameter
    }

    void show() {
        System.out.println("Model is: " + model);
    }

    public static void main(String[] args) {
        Car c1 = new Car("Swift");
        c1.show();
    }
}
📌 Without this.model, Java would be confused (both names are same). this.model refers to the class variable.

## 🧪 Example 3: this() to call another constructor

class Book {
    String name;
    int pages;

    Book() {
        this("Unknown", 0);  // calling parameterized constructor
    }

    Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    void show() {
        System.out.println(name + " has " + pages + " pages.");
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("Java", 300);
        b1.show();  // Unknown has 0 pages.
        b2.show();  // Java has 300 pages.
    }
}


## 📌 Summary Table
Keyword / Concept	Use
Constructor	Initializes object when created
Default Constructor	No parameters
Parameterized Constructor	Takes parameters to initialize fields
this.variable	Refers to instance variable
this()	Calls another constructor
this	Refers to current object





## What is the new keyword in Java?
✅ Definition:
The new keyword in Java is used to:

🔧 Create objects (i.e., instances) of a class
📦 It also allocates memory for the object in the heap

## 🔁 Why do we use new?
Because in Java, classes are just blueprints. To actually use a class, you must create an object of it — and new helps with that.

📦 Example: Basic usage of new

class Student {
    String name;

    void sayHello() {
        System.out.println("Hello, my name is " + name);
    }

    public static void main(String[] args) {
        Student s1 = new Student();  // ← using `new` keyword
        s1.name = "Bhaskar";
        s1.sayHello();  // Hello, my name is Bhaskar
    }
}
👇 What's happening here?
Student is the class (just a design).

new Student() creates a real object in memory.

s1 is the reference pointing to that object.

You can now use s1 to access methods/variables of the object.

🔍 Behind the Scenes:
When you write:

Student s1 = new Student();
Java does this:

Allocates memory in the heap for the object.

Calls the constructor of the class.

Returns the reference (memory address) to the variable s1.

💡 Real-Life Analogy:
Think of a class like a car blueprint 🧾.

new is the factory that uses the blueprint to build a real car 🚗.

Now you can drive it (call methods, use variables).

🧠 Mini FAANG-Level Tip:
✅ Everything in Java is an object (almost).
So you’ll often see:

Scanner sc = new Scanner(System.in);
ArrayList<Integer> list = new ArrayList<>();
String s = new String("hello");  // not needed, but possible
They all use new to create real usable objects.

## ❗ Note:
For primitive types, you don’t use new:


int x = 10;        // no need for new
Integer y = new Integer(10);  // object version (rarely needed)
🚀 Interview-Ready Quick Recap:
Concept	Explanation
new keyword	Creates an object of a class
Memory	Allocates memory in heap
Constructor	Automatically calls the class constructor
Returns	A reference to the object
In Java, a constructor is called only when an object of the class is created using new.
If you don’t create any object, the constructor will not be called.








## wrapper class
wrapper Class in Java –
🔹 What is a Wrapper Class in Java?
In Java, wrapper classes are used to wrap (encapsulate) primitive data types (int, char, boolean, etc.) into objects. Java is an object-oriented language, but primitive types are not objects — so wrapper classes bridge that gap.

Each primitive type has a corresponding wrapper class in the java.lang package:

Primitive Type	Wrapper Class
byte	Byte
short	Short
int	Integer
long	Long
float	Float
double	Double
char	Character
boolean	Boolean

## 🔹 Why Do We Need Wrapper Classes?
✅ To use primitive data types as objects.

✅ For collection framework (ArrayList, HashMap, etc.) which works only with objects.

✅ To support object-oriented features like polymorphism and generics.

✅ To use utility methods provided by wrapper classes (e.g., Integer.parseInt()).

✅ For autoboxing and unboxing.

🔹 Simple Example
java
Copy code
public class WrapperExample {
    public static void main(String[] args) {
        int primitive = 10;

        // Manually converting primitive to wrapper object
        Integer wrapperObj = Integer.valueOf(primitive);  // Boxing

        // Automatically done in Java (Autoboxing)
        Integer autoBoxed = primitive;

        // Convert wrapper object back to primitive
        int unboxed = wrapperObj.intValue();  // Unboxing

        // Automatically done in Java (Auto-unboxing)
        int autoUnboxed = wrapperObj;

        System.out.println("Primitive: " + primitive);
        System.out.println("Wrapper: " + wrapperObj);
        System.out.println("Auto-unboxed: " + autoUnboxed);
    }
}
🔹 Autoboxing and Unboxing (Java 5 onwards)
Autoboxing: Java automatically converts a primitive to a wrapper object.


int x = 100;
Integer y = x; // autoboxing
Unboxing: Java automatically converts a wrapper object to a primitive.


Integer a = 50;
int b = a; // unboxing
🔹 Commonly Used Wrapper Class Methods
Integer.parseInt("123") → converts String to int

Double.parseDouble("12.3") → converts String to double

Boolean.parseBoolean("true") → converts String to boolean



## 🔹 Interview Point of View – Frequently Asked Questions
Question	Explanation
Q1: What is the difference between primitive and wrapper class?	Primitives are not objects, they consume less memory and are faster. Wrapper classes are objects, have methods, and are used with collections.
Q2: What is autoboxing and unboxing?	Automatic conversion between primitive types and wrapper objects.
Q3: Why does Java provide wrapper classes?	To use primitives in object-based features like collections and generics.
Q4: Can you store primitive types in an ArrayList?	No, ArrayList only stores objects. Java uses autoboxing to convert primitives to wrappers.
Q5: What is the default value of Integer vs int?	int default is 0, but Integer default is null if it's an object.

🔹 Real-life Usage Example:
java
Copy code
import java.util.ArrayList;

public class WrapperUse {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10); // autoboxing
        list.add(20);

        int sum = list.get(0) + list.get(1); // auto-unboxing
        System.out.println("Sum = " + sum);
    }
}
✅ Summary (Best for Interviews):
Wrapper classes convert primitives into objects.

Useful for collections, generics, and utility methods.

Java provides autoboxing/unboxing to ease the conversion.

Integer, Double, Boolean, etc., are commonly used wrappers.

Be aware of null pointer exceptions when using wrapper objects (e.g., Integer x = null; int y = x; → will throw NullPointerException).

Let me know if you want a quick revision table or flashcards for this topic.





## final variable
final Keyword in Java – 
## 🔹 What is final in Java?
The final keyword in Java is used to restrict the user. It can be used with:

Variables → to make the value constant

Methods → to prevent overriding

Classes → to prevent inheritance

## 🔸 1. final Variable – Value cannot be changed after initialization.
java

public class FinalVariableExample {
    public static void main(String[] args) {
        final int x = 10;
        // x = 20; // ❌ Error: cannot assign a value to final variable x
        System.out.println("x = " + x);
    }
}
💡 Use Case: For constants like PI, tax rate, etc.
final double PI = 3.14159;


## 🔸 2. final Method – Cannot be overridden by subclass.

class Vehicle {
    final void run() {
        System.out.println("Vehicle is running");
    }
}

class Car extends Vehicle {
    // void run() { System.out.println("Car is running"); } ❌ Error: Cannot override final method
}

public class FinalMethodExample {
    public static void main(String[] args) {
        new Car().run();
    }
}


## 🔸 3. final Class – Cannot be extended (i.e., inherited).

final class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

// class Dog extends Animal {} ❌ Error: Cannot subclass the final class

public class FinalClassExample {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.sound();
    }
}



## 🧠 Interview Point of View – Must Know
Interview Question	Answer
Can a final variable be reassigned?	❌ No, once assigned, its value cannot be changed.
Can a final method be overridden?	❌ No, subclass can't override a final method.
Can a final class be inherited?	❌ No, you cannot extend a final class.
Can we initialize a final variable later?	✅ Yes, if it’s a blank final variable, it must be initialized in the constructor.
Can a final object’s internal data be changed?	✅ Yes, but you cannot reassign the reference.

## 🔸 Bonus: final with Objects

final Student s = new Student("Bhaskar");
// s = new Student("Amit"); ❌ Error: Cannot reassign final reference
s.name = "Amit"; // ✅ Allowed: modifying object state is fine
✅ Summary
Use of final	Prevents
final variable	Reassignment
final method	Overriding
final class	Inheritance





## ✅ What is a Blank Final Variable?
A blank final variable is a final variable that is declared but not initialized at the time of declaration.

➡️ You must initialize it later, typically inside the constructor — otherwise, the code won't compile.

## 🔸 Why Do We Use Blank Final Variables?
When the value should remain constant once set

But that value depends on constructor input

## 🔹 Example of Blank Final Variable
public class Student {
    final String name; // 🔹 Blank final variable

    // Constructor to initialize the blank final variable
    Student(String name) {
        this.name = name; // ✅ Initialized here
    }

    void display() {
        System.out.println("Student name: " + name);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Bhaskar");
        s1.display();  // Output: Student name: Bhaskar

        Student s2 = new Student("Amit");
        s2.display();  // Output: Student name: Amit
    }
}
## 🔹 Key Points About final Variable:

final means once assigned, the variable cannot be changed.

So for each object of Student, once you set name, you cannot reassign it inside that object.

Here, name is a blank final variable (declared final but not initialized at the time of declaration).

Java requires that all blank final variables must be initialized in the constructor.

When you create an object like new Student("Bhaskar"):

The constructor runs.

this.name = name; assigns "Bhaskar" to that object’s name.

That particular Student object is forever locked with "Bhaskar".

When you create another object new Student("Amit"):

A new copy of the instance variable name exists for this new object.

Constructor assigns "Amit" to this copy.

That object is forever locked with "Amit".




## ❌ What if You Don’t Initialize It?

public class Student {
    final String name; // blank final

    Student() {
        // ❌ Error: name is not initialized
    }
}
❗ Compilation Error: variable name might not have been initialized

🧠 Interview Tip:
"Yes, we can initialize a final variable later if it's a blank final variable — but Java enforces that it must be initialized in the constructor before the object is used. This is useful when the value is object-specific and must remain constant after construction."




## grabaje collector

 Garbage Collector in Java –
🔹 What is Garbage Collection in Java?
Garbage Collection (GC) in Java is the process of automatically identifying and removing unused objects from memory (heap) to free up resources and avoid memory leaks.

✅ It helps manage memory automatically, so developers don’t need to manually free memory like in C or C++.

🔹 What is a Garbage Collector?
The Garbage Collector is a background thread in Java's JVM that:

Finds objects that are no longer referenced.

Deletes them from memory.

Reclaims that memory for future use.

🔹 When is an Object Eligible for Garbage Collection?
An object becomes eligible for garbage collection when no live thread can access it anymore — i.e., there are no references pointing to it.

🔹 Example:

public class GarbageDemo {
    public static void main(String[] args) {
        String str = new String("Bhaskar");
        str = null; // Now the "Bhaskar" object is eligible for GC

        // Suggesting GC to run
        System.gc();
    }

    @Override
    protected void finalize() {
        System.out.println("Garbage collected!");
    }
}
✅ System.gc(); is a request to the JVM to run garbage collector (not guaranteed).

🔹 How Garbage Collector Works (Simplified Steps)
JVM tracks all object references.

If an object has no references, it's marked as "unreachable".

GC cleans up these unreachable objects.

JVM may compact memory to avoid fragmentation.

🔹 Types of Garbage Collectors in Java (Modern JVM)
GC Name	Description
Serial GC	Single-threaded; best for small apps
Parallel GC	Uses multiple threads for GC; default in many JVMs
CMS (Concurrent Mark-Sweep)	Focused on low pause time
G1 GC (Garbage First)	Splits heap into regions; balances throughput and pause time
ZGC / Shenandoah	Low-latency, scalable collectors (Java 11+)

🔹 How to Trigger GC Manually (not recommended usually)

System.gc(); // Suggests JVM to run GC
But the JVM may ignore this call.

🔹 Interview-Oriented Questions
Question	Answer
What is garbage collection?	Automatic memory management to remove unused objects.
How does JVM know an object is unused?	If there are no active references to it.
Can we force garbage collection?	No, we can only suggest it using System.gc().
What is the finalize() method?	A method called before GC deletes the object. (Deprecated since Java 9)
Which memory area does GC clean up?	Heap memory.

✅ Summary
Java Garbage Collector automatically removes unused objects from heap memory.

Objects with no references are considered garbage.

Developers can suggest GC using System.gc() but cannot force it.

GC helps avoid memory leaks and makes Java more reliable and safe.