## polymorphism

## importent point in dyanmic method dispatch in c++ vs java
“In Java, when a method is called on an object, it first checks in the derived class (child).
If not found, it goes to the parent class.” ✅
That’s exactly correct — and it’s because in Java,
# all non-static, non-final, non-private methods are virtual by default.
That means Java always does dynamic (runtime) dispatch,
while C++ does it only if you mark a function as virtual.




## 1- compile time / Static polimorphishm - this achived by method overloading
 -- same name but type arguments or ordering or signature is diff example multiple constructer
 A a = new A();
 A a = new A(3, 4);


## 2- run time / Dynamic polymorphism - Achived by method overriding
 --when the same method is created in parent class and child class thats the MO . child method will override parent method. only body of the function can be different all other things will be same
Late binding in Java happens only when a parent reference variable refers to a child class object, and the child overrides the parent’s method.
The decision of which version of the method to call is made at runtime by the JVM, not by the compiler.


## when you create like this
 Shapes shape = new Shapes();
 Shapes circle = new Circle();
 Shapes square = new Square();

## this is also known as Dynamic method dispetch becouse java decide it which method has to run at run time 
## Parent p1 = new Parent();

Reference → Parent

Object → Parent

Executes Parent’s method.

## Parent p2 = new Child(); (Upcasting)

Reference → Parent

Object → Child

At compile time, Java only checks if Parent has a display() method (✅ it has).

At runtime, JVM looks at the object type (Child) → executes Child’s method.

## Child c1 = new Child();

Reference → Child

Object → Child

## 👉 This is why it’s called Dynamic Method Dispatch – because the method to execute is decided at runtime based on the actual object type, not reference type.


## for example when you direct print object that's called object.toString method which is already made but if you made your own toString method in that case your method will override previous one

## you can use @override before override any method this kind of structure still this will not create error



 ///////////final method//////////
## final method can not overrirde
## static method can not override becouse static method connected directly to classes not a object there fore parent static method will run always and overrride depends on object and static does'nt depends on object

///////instence variable////////////
## both method overriding and method overloading does'nt depends on instence variable

## /////////// late binding / Early binding//////////////
## 🔹 Early Binding (Compile-time Binding)

Happens at compile time.

The method call is decided by the compiler.

Usually happens with:

Method overloading

Static methods

Private methods

Final methods

👉 Because these cannot be overridden, the compiler already knows which method to call.

Example: Early Binding
class Test {
    void show(int a) {
        System.out.println("int method called");
    }

    void show(String s) {
        System.out.println("String method called");
    }

    static void display() {
        System.out.println("Static display method");
    }
}

public class EarlyBindingExample {
    public static void main(String[] args) {
        Test t = new Test();
        t.show(10);        // Compiler knows -> calls int method
        t.show("Hello");   // Compiler knows -> calls String method

        Test.display();    // Compiler knows it's static
    }
}


✅ Here, method selection is done at compile time, so this is Early Binding.

## 🔹 Late Binding (Run-time Binding / Dynamic Method Dispatch)

Happens at runtime.

The method to execute is decided by JVM depending on the actual object.

Always occurs with method overriding.

Example: Late Binding
class Parent {
    void show() {
        System.out.println("Parent show()");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child show()");
    }
}

public class LateBindingExample {
    public static void main(String[] args) {
        Parent p = new Child(); // reference type: Parent, object type: Child
        p.show();               // JVM decides at runtime -> Child show()
    }
}


✅ Even though reference is of Parent, the Child method executes at runtime.
That’s why this is Late Binding.





## ➕ Method Overloading (Compile-Time Polymorphism)
Definition: When multiple methods in the same class have the same name but different parameters (type, number, or order).

Happens at: Compile Time (Early Binding)

Use Case: Improves code readability and flexibility.

Example:

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


## 🔁 Method Overriding (Run-Time Polymorphism)
Definition: When a subclass provides a specific implementation of a method already defined in its parent class.
Happens at: Runtime (Late Binding)

Use Case: Achieves dynamic behavior and flexibility.

Example:

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


## 🔀 Dynamic Method Dispatch (Runtime Polymorphism)
Definition: Mechanism by which a call to an overridden method is resolved at runtime, not at compile time.

Key Rule: Happens when a superclass reference refers to a subclass object.

Example:

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

