## encapsulation - wrpping up the implementaion of the data member and method in class. binding all the method and properties and hiding from outside the world
--implementation level isssue
--containing information

example when you make any property private to access that you use can getter method by using getter method you can access that peroperty in main class this is example  .
and also you can set value by setter method 

## Abstarction - hiding unneccesary details and showing esential information - like you are use collectionlibrary or you are using method from that but that time you just using those function but implementation of those is hidden when you do ctr + click on method then you can see that method
-- design issue
-- gaining information


📌 Definition:
Encapsulation is the process of wrapping data (variables) and code (methods) into a single unit (class), and restricting direct access to some of the object's components.

🔐 Key Points:
It hides the internal state of the object from the outside world.

Achieved using private fields and public getters/setters.

Improves security and maintainability of code.

Ensures controlled access to fields.


## Problem here:

Anyone can directly change name to anything, even an invalid value (like null, empty string, or "1234").

No control over the data.

Breaks security and data integrity.

encapsulation solve all these issue

## 🧠 Example:

class Student {
    private String name;  // private -> hidden from outside

    // Setter with validation
    public void setName(String name) {
        if (name != null && !name.isEmpty()){
            this.name = name;
        }else {
            System.out.println("❌ Invalid name!");
        }
    }

    // Getter
    public String getName() {
        return name;
    }
}

public class Test {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Bhaskar");   // ✅ controlled access
        System.out.println(s.getName());
        s.setName("");          // ❌ won't allow invalid input
    }
}



📒 Summary:
Feature	Encapsulation
Focus	Internal implementation
Access control	Yes (private + getters/setters)
Design type	Implementation-level
Real-world example	ATM machine: card/pin is hidden




## ✅ Abstraction in Java
📌 Definition:
Abstraction is the process of hiding unnecessary details and showing only essential information to the user.

🔍 Key Points:
Helps focus on what an object does instead of how.

Achieved using:

Abstract classes

Interfaces

🧠 Example:

abstract class Animal {
    abstract void makeSound();  // only declaration, not implementation

    void sleep() {
        System.out.println("Sleeping...");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal d = new Dog(); // reference of abstract class
        d.makeSound();        // "Bark!"
        d.sleep();            // "Sleeping..."
    }
}
📒 Summary:
Feature	Abstraction
Focus	Only essential information
Access control	No (it's about design)
Design type	Design-level
Real-world example	Driving a car: only use steering, brake, etc., not know engine internals



## 🔄 Difference Between Encapsulation and Abstraction
Feature	                      Encapsulation	                                Abstraction
Definition	        Wrapping code and data into a single unit	     Hiding unnecessary details
Level	            Implementation level	                         Design level
Goal	            Data hiding and security	Reduce complexity,   focus on "what" not "how"
How it’s achieved	Using access modifiers (private, public)	     Using abstract classes and interfaces
Focus	            How to protect data	What to expose
    
Example	Private fields + getter/setter	Abstract class/interface

🎯 Interview Questions & Answers:
Q1. What is encapsulation in Java?
Encapsulation is the practice of bundling the data (variables) and code (methods) that operate on the data into a single unit (class), and restricting access to the inner workings of that class. It’s achieved using private fields and public getter/setter methods.

Q2. What is abstraction in Java?
Abstraction is the concept of hiding internal implementation details and showing only functionality. In Java, it is achieved using abstract classes and interfaces.

Q3. What’s the difference between abstraction and encapsulation?
## imp - Encapsulation hides the data; abstraction hides the implementation.

Encapsulation is about access control (private/protected); abstraction is about design and what functionality to expose.

Q4. How does Java support abstraction?
Java supports abstraction using:

Abstract classes (with abstract and concrete methods)

Interfaces (100% abstraction before Java 8, default methods allowed after Java 8)