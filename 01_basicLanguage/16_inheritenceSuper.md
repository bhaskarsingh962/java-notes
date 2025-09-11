## inheritance 
## super keyword



## In inheritence child class can access property of parent clasess but parent class can not access property of child classess like using child constructer we can access parent varible (properties) but not vice versa 

## super keyword is used to use constructer of parent class in child class . and using this you can access only public proprties of parent classes

## object of parent class can not access properties of child class but object of child class can access property of parent class


## Prent p1 = new child(p1,p2,c1);
## parent can access only memebr of p1 not from child c1 becouse its just parent object is pointing to child object and object type are not same

## This line will give a compilation error, unless:
You have a constructor in Child that accepts three parameters (with types matching p1, p2, c1).

p1, p2, and c1 are already declared and initialized variables in scope.

The constructor signature in Child must match the argument types you're passing.

🔍 Let's Understand with Example:
Suppose you have:

public class Parent {
    public int p1;
    public int p2;

    public Parent(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}

public class Child extends Parent {
    public int c1;

    // constructor that takes p1, p2, and c1
    public Child(int p1, int p2, int c1) {
        super(p1, p2);  // call Parent's constructor
        this.c1 = c1;
    }
}
Now in Main.java, you can write:

public class Main {
    public static void main(String[] args) {
        int p1 = 10, p2 = 20, c1 = 30;
        Parent obj = new Child(p1, p2, c1);  // ✅ this works
    }
}
❌ If Child doesn’t have the required constructor: - than it will not work



## Child p1 = new Parent(p1,p2,c1);
## why this gives error becouse when you do this c1 is not initialized yet that's why child p1 does'nt have the property c1 therefore it makes error


Child obj = new Parent(p1, p2);
No, this is not allowed in Java.
You cannot assign a Parent object to a Child reference, because a Parent object does not have the extra properties of a Child.

## Upcasting (Child → Parent) → ✅ always safe.

## Downcasting (Parent → Child) → ❌ unsafe, only works if the object was actually created as a Child.

⚡ Quick analogy:

Dog extends Animal.

Every Dog is an Animal.

But not every Animal is a Dog.


//////////////super Keyword///////////////
## super keyword access constructer of instent parent class becouse there can be multiple inharitance there if we are using construter in below all the above class should have super method



## That's why this code gives an error:
## when use super keyword later
System.out.println(int weight);  // ❌ illega— super() not called yet
this.weight = weight;
super(l, h, w);  // ❌ ERROR 


## Why This Rule Exists?- you cant call super keyword later
When you create a subclass object, Java must initialize the parent (super) class first, before initializing the child class. So:

Java forces you to call the super constructor first (if you're calling it explicitly).

If you don’t, Java automatically inserts a call to super() (the no-arg constructor) — but only if you don’t write it yourself.


## type of inheritance
## 1 single inheritance
## 2 multi level inheritance

## multiple inheritance not allowed in java becouse if 2 or more parent classes have the same property child object will confused which one to access that's why java does'nt suppot multiple inheritance

class A {
    void show() {
        System.out.println("A");
    }
}

class B {
    void show() {
        System.out.println("B");
    }
}

// Error: class C cannot extend both A and B
class C extends A, B {
    // which show() should be inherited?
}

## Heirearichal Inheritance - same problem - one parent class access by multiple child clases

## hybrid inharitance - comination of single and multiple inheritance


## //////////////////////////// inharitence allowed in java //////////////////////////////////////////////

## ✅ Types of Inheritance Allowed in Java:

## Single Inheritance

One class inherits from one parent class.

class Parent {
    void show() { System.out.println("I am Parent"); }
}

class Child extends Parent {
    void display() { System.out.println("I am Child"); }
}


✅ Allowed.

## Multilevel Inheritance

A class inherits from a child class (which is itself derived from another parent).

class GrandParent {
    void g1() { System.out.println("I am Grandparent"); }
}

class Parent extends GrandParent {
    void p1() { System.out.println("I am Parent"); }
}

class Child extends Parent {
    void c1() { System.out.println("I am Child"); }
}


✅ Allowed. (Chain of inheritance)

## Hierarchical Inheritance

Multiple classes inherit from a single parent.

class Parent {
    void show() { System.out.println("I am Parent"); }
}

class Child1 extends Parent {
    void c1() { System.out.println("I am Child1"); }
}

class Child2 extends Parent {
    void c2() { System.out.println("I am Child2"); }
}


✅ Allowed.

## ❌ Types of Inheritance NOT Allowed in Java:

Multiple Inheritance (with classes)

One class inherits from more than one class.

class A { }
class B { }
class C extends A, B { } // ❌ NOT allowed


Reason: It leads to ambiguity (Diamond problem).

🔑 But Java solves this by allowing Multiple Inheritance with Interfaces:

interface A { void m1(); }
interface B { void m2(); }

class C implements A, B {
    public void m1() { System.out.println("From A"); }
    public void m2() { System.out.println("From B"); }
}


✅ This works because interfaces only have method declarations (no state/fields).

Hybrid Inheritance (mix of multiple + multilevel)

Example: Combination of multiple inheritance and hierarchical.

Not directly supported using classes.

✅ Achieved through interfaces.

📌 Final Answer:

Allowed: Single, Multilevel, Hierarchical

Not Allowed (with classes): Multiple, Hybrid

But via Interfaces: Multiple & Hybrid inheritance are possible.

## //////////////////////////////////////////////////////////////////////////////////////////////////////////





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










## kunal made notes
To inherit a class, you simply incorporate the definition of one class into another by using the extends keyword.

class subclass-name extends superclass-name { // body of class
}
You can only specify one superclass for any subclass that you create. Java does not support the inheritance of
multiple superclasses into a single subclass. You can, as stated, create a hierarchy of inheritance in which a subclass
becomes a superclass of another subclass. However, no class can be a superclass of itself.

Although a subclass includes all of the members of its superclass, it cannot access those members of the superclass
that have been declared as private.

A Superclass Variable Can Reference a Subclass Object:
It is important to understand that it is the type of the reference variable—not the type of the object that it refers
to—that determines what members can be accessed.
When a reference to a subclass object is assigned to a superclass reference variable, you will have access only to
those parts of the object defined by the superclass.

plainbox      =  weightbox;
(superclass)     (subclass)

SUPERCLASS ref = new SUBCLASS();    // HERE ref can only access methods which are available in SUPERCLASS

Using super:
Whenever a subclass needs to refer to its immediate superclass, it can do so by use of the keyword super.
super has two general forms. The first calls the superclass’ constructor.
The second is used to access a member of the superclass that has been hidden by a member of a subclass.

BoxWeight(double w, double h, double d, double m) {
    super(w, h, d); // call superclass constructor
    weight = m;
}

Here, BoxWeight( ) calls super( ) with the arguments w, h, and d. This causes the Box constructor to be called,
which initializes width, height, and depth using these values. BoxWeight no longer initializes these values itself.
It only needs to initialize the value unique to it: weight. This leaves Box free to make these values private if desired.

Thus, super( ) always refers to the superclass immediately above the calling class.
This is true even in a multileveled hierarchy.

class Box {
     private double width;
     private double height;
     private double depth;

     // construct clone of an object

     Box(Box ob) { // pass object to constructor
       width = ob.width;
       height = ob.height;
       depth = ob.depth;
     }
}

class BoxWeight extends Box {
     double weight; // weight of box

     // construct clone of an object

     BoxWeight(BoxWeight ob) { // pass object to constructor
        super(ob);
        weight = ob.weight;
     }
}

Notice that super() is passed an object of type BoxWeight—not of type Box.This still invokes the constructor Box(Box ob).
NOTE: A superclass variable can be used to reference any object derived from that class.
Thus, we are able to pass a BoxWeight object to the Box constructor.Of course,Box only has knowledge of its own members.

A Second Use for super
The second form of super acts somewhat like this, except that it always refers to the superclass of the subclass in
which it is used.

super.member

Here, member can be either a method or an instance variable. This second form of super is most applicable to situations
in which member names of a subclass hide members by the same name in the superclass.

super( ) always refers to the constructor in the closest superclass. The super( ) in BoxPrice calls the constructor in
BoxWeight. The super( ) in BoxWeight calls the constructor in Box. In a class hierarchy, if a superclass constructor
requires parameters, then all subclasses must pass those parameters “up the line.” This is true whether or not a
subclass needs parameters of its own.

If you think about it, it makes sense that constructors complete their execution in order of derivation.
Because a superclass has no knowledge of any subclass, any initialization it needs to perform is separate from and
possibly prerequisite to any initialization performed by the subclass. Therefore, it must complete its execution first.

NOTE: If super( ) is not used in subclass' constructor, then the default or parameterless constructor of each superclass
will be executed.


Using final with Inheritance:

The keyword final has three uses:

# First, it can be used to create the equivalent of a named constant.

# Using final to Prevent Overriding:
To disallow a method from being overridden, specify final as a modifier at the start of its declaration.
Methods declared as final cannot be overridden.
Methods declared as final can sometimes provide a performance enhancement: The compiler is free to inline calls to them
because it “knows” they will not be overridden by a subclass. When a small final method is called, often the Java
compiler can copy the bytecode for the subroutine directly inline with the compiled code of the calling method, thus
eliminating the costly overhead associated with a method call. Inlining is an option only with final methods.
Normally, Java resolves calls to methods dynamically, at run time. This is called late binding. However, since final
methods cannot be overridden, a call to one can be resolved at compile time. This is called early binding.

# Using final to Prevent Inheritance:
Sometimes you will want to prevent a class from being inherited. To do this, precede the class declaration with final.
NOTE: Declaring a class as final implicitly declares all of its methods as final, too.
As you might expect, it is illegal to declare a class as both abstract and final since an abstract class is incomplete
by itself & relies upon its subclasses to provide complete implementations.

# NOTE: Although static methods can be inherited ,there is no point in overriding them in child classes because the
method in parent class will run always no matter from which object you call it. That is why static interface methods
cannot be inherited because these method will run from the parent interface and no matter if we were allowed to
override them, they will always run the method in parent interface.
That is why static interface method must have a body.

NOTE : Polymorphism does not apply to instance variables.

