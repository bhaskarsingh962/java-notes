## polymorphism

## 1- compile time / Static polimorphish - this achived by method overloading
 -- same name but type arguments or ordering or signature is diff example multiple constructer
 A a = new A();
 A a = new A(3, 4);


## 2- run time / Dynamic polymorphism - Achived by method overriding
 --when the same method is created in parent class and child class thats the MO . child method will override parent method. only body of the function can be different all other things will same

## when you create like this
 Shapes shape = new Shapes();
 Shapes circle = new Circle();
 Shapes square = new Square();

## this is also known as Dynamic method dispetch becouse java decide it which method has to run at run time 
 Parent p = new Child();
 p.method();
 in this parent class will create object refrence and the method  should be persent in parent class and child class also than the body of child class will executed


## for example when you direct print object that's called object.toString method which is already made but if you made your own toString method in that case your method will override previous one

## you can use @override before override any method this kind of structure still this will not create error



 ///////////final method//////////
## final method can not overrirde
## static method can not override becouse static method connected directly to classes not a object there fore parent static method will run always and overrride depends on object and static does'nt depends on object

///////instence variable////////////
## both method overriding and method overloading does'nt depends on instence variable

## /////////// late binding / Early binding//////////////
## overriding is take place at run time when everything is done that's why its know as late binding .however a called which is done in compile time only is know as early binding



## AI notes

# Java Inheritance: Complete Notes

---

## 📘 Types of Inheritance in Java

### 1. Single Inheritance

* **Definition**: One class inherits from another.
* **Example**:

  ```java
  class Animal {
      void sound() { System.out.println("Animal sound"); }
  }
  class Dog extends Animal {
      void bark() { System.out.println("Bark"); }
  }
  ```

### 2. Multilevel Inheritance

* **Definition**: A class is derived from another derived class.
* **Example**:

  ```java
  class Animal {
      void sound() { System.out.println("Animal sound"); }
  }
  class Dog extends Animal {
      void bark() { System.out.println("Bark"); }
  }
  class Puppy extends Dog {
      void weep() { System.out.println("Weep"); }
  }
  ```

### 3. Hierarchical Inheritance

* **Definition**: Multiple classes inherit from a single parent class.
* **Example**:

  ```java
  class Animal {
      void sound() { System.out.println("Animal sound"); }
  }
  class Dog extends Animal {
      void bark() { System.out.println("Bark"); }
  }
  class Cat extends Animal {
      void meow() { System.out.println("Meow"); }
  }
  ```

### 4. Multiple Inheritance (with classes) ❌ Not Supported

* **Java does not support multiple inheritance with classes** to avoid ambiguity.

#### Example Problem:

```java
class A {
    void show() { System.out.println("From A"); }
}
class B {
    void show() { System.out.println("From B"); }
}
// class C extends A, B { // Not allowed
```

### 5. Multiple Inheritance (with Interfaces) ✅ Supported

* **Java allows multiple inheritance using interfaces.**

#### Example:

```java
interface A {
    void show();
}
interface B {
    void show();
}
class C implements A, B {
    public void show() {
        System.out.println("Resolved show method");
    }
}
```

### 6. Hybrid Inheritance ✅ Supported via Interfaces

* **Combination of more than one type of inheritance** (e.g., Hierarchical + Multiple).
* **Only allowed via interfaces to avoid ambiguity.**

---

## 🔑 Key Points

* Java supports **Single**, **Multilevel**, and **Hierarchical** inheritance with classes.
* Java **does not support multiple inheritance with classes** to avoid ambiguity.
* **Interfaces** allow multiple and hybrid inheritance.
* If two interfaces have the same method signature, implementing class **must override** it.
* Helps maintain clear method resolution.

---

## ❓ Interview Questions & Answers

### Q1: Why doesn't Java support multiple inheritance with classes?

**Ans**: To avoid ambiguity caused when two superclasses have methods with the same signature. Java chooses simplicity and clarity by disallowing it.

### Q2: How does Java achieve multiple inheritance?

**Ans**: By using interfaces. A class can implement multiple interfaces, and if there's conflict, it must override the conflicting method.

### Q3: What is hierarchical inheritance?

**Ans**: When multiple classes inherit from a single parent class. Java supports it because it causes no ambiguity.

### Q4: Is hybrid inheritance supported in Java?

**Ans**: Yes, but only through interfaces. Java does not support hybrid inheritance using classes due to ambiguity.

### Q5: What is the difference between class inheritance and interface inheritance?

**Ans**:

* Class inheritance uses `extends`, only one superclass allowed.
* Interface inheritance uses `implements`, allows multiple interfaces.

---

> 📁 Save this as `java_inheritance.md` in your VS Code for best usage.


➕ Method Overloading (Compile-Time Polymorphism)
Definition: When multiple methods in the same class have the same name but different parameters (type, number, or order).

Happens at: Compile Time (Early Binding)

Use Case: Improves code readability and flexibility.

Example:
java
Copy
Edit
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {
        return a + b;
    }
    int add(int a, int b, int c) {
        return a + b + c;
    }
}
🔁 Method Overriding (Run-Time Polymorphism)
Definition: When a subclass provides a specific implementation of a method already defined in its parent class.

Happens at: Runtime (Late Binding)

Use Case: Achieves dynamic behavior and flexibility.

Example:
java
Copy
Edit
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
🔀 Dynamic Method Dispatch (Runtime Polymorphism)
Definition: Mechanism by which a call to an overridden method is resolved at runtime, not at compile time.

Key Rule: Happens when a superclass reference refers to a subclass object.

Example:
java
Copy
Edit
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}
class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}
class Cat extends Animal {
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Test {
    public static void main(String[] args) {
        Animal a;
        a = new Dog();
        a.sound(); // Output: Dog barks

        a = new Cat();
        a.sound(); // Output: Cat meows
    }
}
🕐 Early Binding vs Late Binding
Feature	Early Binding	Late Binding
Also Known As	Static Binding / Compile-Time	Dynamic Binding / Run-Time
When it Happens	During compilation	During runtime
Used in	Method overloading, private/static/final methods	Method overriding
Performance	Faster, as it is resolved early	Slower, resolved at runtime
Example	add(int, int) calls	animal.sound() resolved at runtime

📌 Interview Questions
Q: What is method overloading?
Ans: It allows multiple methods in the same class to have the same name but different parameters. It’s resolved at compile time.

Q: What is method overriding?
Ans: It means redefining a method in the child class that already exists in the parent class. It’s resolved at runtime.

Q: What is dynamic method dispatch?
Ans: It's a runtime mechanism in which overridden methods are called based on the object type that the reference variable points to.

Q: What’s the difference between early and late binding?
Ans: Early binding occurs during compilation (e.g., method overloading), while late binding occurs at runtime (e.g., method overriding).

