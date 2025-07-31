## In inheritence child class can access property of parent clasess but parent class can not access property of child classess like using child constructer we can access parent varible (properties) but not vice versa 

## super keyword is used to use constructer of parent class in child class . and using this you can access only public proprties of parent classes

## object of parent class can not access properties of child class but object of child class can access property of parent class


## Prent p1 = new child(p1,p2,c1);
## parent can access only memebr of p1 not from child c1 becouse its just parent object is pointing to child object and object type are not same

 This line will give a compilation error, unless:
You have a constructor in Child that accepts three parameters (with types matching p1, p2, c1).

p1, p2, and c1 are already declared and initialized variables in scope.

The constructor signature in Child must match the argument types you're passing.

🔍 Let's Understand with Example:
Suppose you have:
java
Copy code
public class Parent {
    public int p1;
    public int p2;

    public Parent(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}
java
Copy code
public class Child extends Parent {
    public int c1;

    // constructor that takes p1, p2, and c1
    public Child(int p1, int p2, int c1) {
        super(p1, p2);  // call Parent's constructor
        this.c1 = c1;
    }
}
Now in Main.java, you can write:
java
Copy code
public class Main {
    public static void main(String[] args) {
        int p1 = 10, p2 = 20, c1 = 30;
        Parent obj = new Child(p1, p2, c1);  // ✅ this works
    }
}
❌ If Child doesn’t have the required constructor:



## Child p1 = new Parent(p1,p2,c1);
## why this gives error becouse when you do this c1 is not initialized yet that's why child p1 does'nt have the property c1 therefore it makes error 


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

## Heirearichal Inheritance - smae problem - one parent class access by multiple child clases

## hybrid inharitance - comination of single and multiple inheritance