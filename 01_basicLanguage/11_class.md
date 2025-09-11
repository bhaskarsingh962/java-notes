in java the first latter of the class must be capital 

class is kind of data structure which we can provoide properties or method according us also class is a blue print of object

## 📘 Java Class – Interview Notes
🔹 Definition of Class in Java

## A class in Java is a blueprint (template) for creating objects.

It defines the state (fields/variables) and behavior (methods) that the objects created from the class will have.

A class itself is not an object, but it is used to create objects.

In Java, everything revolves around classes and objects → this is the foundation of Object-Oriented Programming (OOP).

## 🔹 Key Points (Interview Perspective)

Class = Blueprint for Objects

Objects are the real entities; classes are the design.

Encapsulation

A class encapsulates data + methods into a single unit.

Reusability

Classes promote code reusability by allowing multiple objects to be created from the same class.

Access Modifiers

## Classes can have public, default (package-private) visibility.

Types of Classes

Concrete Class

Abstract Class

Final Class (cannot be extended)

Nested/Inner Class

🔹 Syntax of a Class
class ClassName {
    // Fields (variables)
    int age;
    String name;

    // Constructor
    ClassName(String n, int a) {
        name = n;
        age = a;
    }

    // Method
    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

🔹 Example: Class and Object
// Class Definition
class Student {
    // Properties (fields)
    String name;
    int age;

    // Constructor
    Student(String n, int a) {
        name = n;
        age = a;
    }

    // Method (behavior)
    void showDetails() {
        System.out.println("Student Name: " + name + ", Age: " + age);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        // Creating Objects (instances of the class)
        Student s1 = new Student("Rahul", 21);
        Student s2 = new Student("Priya", 22);

        // Calling methods
        s1.showDetails();
        s2.showDetails();
    }
}


Output:

Student Name: Rahul, Age: 21
Student Name: Priya, Age: 22

🔹 Interview Question Samples

## What is a class in Java?

A class is a blueprint from which objects are created. It encapsulates data (fields) and behavior (methods).

How is a class different from an object?

Class is a template, object is an instance. Multiple objects can be created from a single class.

Can a class exist without an object?

Yes, but its methods and variables can’t be accessed unless they are static.

What types of members can a class contain?

Fields, methods, constructors, blocks, inner classes, and interfaces.

## ✅ Summary:
A class is the backbone of OOP in Java. It organizes code into reusable, logical units that combine data and behavior. Objects bring classes to life



📘 Types of Classes in Java

A class in Java is a blueprint for creating objects. It can contain fields (variables), methods, constructors, blocks, and nested classes/interfaces.


## 🔹 1. Concrete Class

A normal class that is fully implemented.

Can be instantiated (i.e., we can create objects from it).

Contains methods with complete definitions.

✅ Example:

class Car {
    String brand;
    int speed;

    void drive() {
        System.out.println(brand + " is driving at " + speed + " km/h");
    }
}

public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        c.brand = "Tata";
        c.speed = 120;
        c.drive();
    }
}


## 🔹 2. Abstract Class

Declared with the keyword abstract.

Cannot be instantiated directly.

May contain abstract methods (without implementation) and concrete methods (with implementation).

Used for inheritance and defining a common template.

✅ Example:

abstract class Shape {
    abstract void draw();  // abstract method
    void info() {
        System.out.println("This is a shape");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape s = new Circle(); 
        s.draw(); 
        s.info();
    }
}


## 🔹 3. Interface (Special Kind of Class)

In Java, an interface is like a class with only abstract methods (before Java 8).

From Java 8, interfaces can have default and static methods.

Supports multiple inheritance.

✅ Example:

interface Animal {
    void sound();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.sound();
    }
}


## 🔹 4. Final Class

Declared with final keyword.

Cannot be extended (no inheritance).

Often used for security and immutability.

✅ Example:

final class Constants {
    static final double PI = 3.14159;
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Constants.PI);
    }
}

🔹 5. Nested / Inner Classes

Classes declared inside another class. Types:

Non-static Inner Class

Static Nested Class

Method-local Inner Class

Anonymous Inner Class

✅ Example (Anonymous Class):


## abstract class Greeting {
    abstract void sayHello();
}

public class Main {
    public static void main(String[] args) {
        Greeting g = new Greeting() {
            void sayHello() {
                System.out.println("Hello from Anonymous Class!");
            }
        };
        g.sayHello();
    }
}


## 🔹 6. POJO Class (Plain Old Java Object)

A simple class with private fields and public getters/setters.

Common in frameworks (like Hibernate, Spring).

✅ Example:

class Student {
    private String name;
    private int age;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}


## 🔹 7. Singleton Class

Only one object is created for the class.

Used in logging, DB connections, caching.

✅ Example:

class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {}  // private constructor

    public static Singleton getInstance() {
        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);  // true
    }
}

## 📌 Interview Notes (Summary)

Concrete class → Normal class, can create objects.

Abstract class → Contains abstract + concrete methods. Cannot instantiate.

Interface → 100% abstraction (before Java 8), supports multiple inheritance.

Final class → Cannot be inherited.

Inner/Nested class → Class inside another class.

POJO class → Plain old Java object, used for data storage.

Singleton class → Only one instance is created.