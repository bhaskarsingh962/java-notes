## Interface - to Achive multiple inheritance we use inharitance for this we need to use implement keyword

NOTE-
## 1- All method of the interface should be abstract 
## 2-  Why Interface Variables Are Always public static final
1. public
Interface variables must be accessible to all implementing classes, so they are public.

2. static
They belong to the interface itself, not to the objects. This is because interfaces cannot be instantiated, so there's no "object" to hold instance variables.

3. final
They are constants. You are not allowed to change interface variables once initialized.

## 4 - Can You Declare Interface Variables Without public static final?
❌ No, you cannot.
Even if you don't write public static final, Java adds them by default.

try this 
interface Test {
    int a = 100;
}
This is automatically treated as public static final:


interface Test {
    public static final int a = 100;
}


You cannot make an interface variable:
non-static (i.e., instance variable)
non-final (i.e., changeable)
or private/protected (not allowed)


## 5 - for best prectice you need to immplement diff classess separatly becouse other wise wrong method will be execute for example Why is separating all the classes and interfaces GOOD design?
Modularity: Changing or adding new types of engines (e.g., ElectricEngine, PowerEngine) means only adding/changing that class, not everything.

Interface Segregation & Flexibility: Each class only implements interfaces relevant to it. For example, CDPlayer only handles media, not engine functions.

Loose Coupling: The NiceCar class can swap its engine or media player at runtime (demonstrated by upgradeEngine).

Extensibility: You can add new behaviors (e.g., a new media system or another engine type) without modifying existing code.

Polymorphism: The main application works with interfaces (Engine, Media, etc.) rather than concrete types, making the system more flexible and easier to maintain.

4. How does the code work, step-by-step?
a) Interfaces
Engine declares methods all engines must implement.

Media declares methods for media players.

Brake declares a brake contract.

b) Implementing Classes
Car can accelerate, start/stop engine, and default braking.

PowerEngine and ElectricEngine are separate, specialized engines implementing Engine.

CDPlayer implements Media for playing music.

c) NiceCar as a Composite/Facade
Holds an engine (which can be changed) and a media player.

Has methods to start/stop engine, start/stop music, upgrade engine, etc.

Demonstrates the use of Composition over Inheritance.

d) Main application
Creates a NiceCar.

Starts the car (delegates to current engine).

Starts music (delegates to media player).

Upgrades engine (switches to ElectricEngine) and starts again.

Key outcome: At any time, you can plug in a different engine (maybe even a JetEngine later!), demonstrating the power of interfaces and composition.

5. Example Analogy/Interview Explanation
"We separate each functionality (engine, media, brake) into its own interface and implementing class to keep responsibilities clear and maximize code modularity. This means, for example, we can change the engine in a car without having to rewrite car logic. NiceCar acts as a controller that delegates work to actual components via interfaces—which lets us easily extend, customize, and maintain the code. This is a classic OOP design recommended for scalable, maintainable Java applications."


## interface to interface - extendent
## classess to interface - implement

## nested interface can be made in java and for that the first interface should be public or defualt and the implement can whatever


 1. What is an Interface?
An interface in Java is a reference type, similar to a class, that can contain:

Abstract methods (implicitly).

Constants (variables that are public static final).

Used to achieve multiple inheritance in Java (which is not possible with classes alone).

Declared using the interface keyword.

🧠 2. Key Rules of Interface
All methods are implicitly public abstract.

All variables are implicitly public static final.

Interfaces cannot have constructors.

Interfaces cannot be instantiated(can not create new object).

🛠 3. Why Interface Variables Are public static final?
Modifier	Reason
public	So that they are accessible to all implementing classes.
static	Belong to the interface itself, not to instances (interfaces can't be instantiated).
final	Value cannot be changed; constants are needed to maintain integrity.

💡 Even if you don’t write public static final, Java adds them automatically.

interface Test {
    int a = 100;  // automatically treated as public static final
}
❌ 4. Can You Declare Interface Variables Without public static final?
❌ No, you cannot have:

Non-static variables.

Non-final (changeable) variables.

Private or protected variables.

🤝 5. Interface Inheritance
Relationship	Syntax	Description
Interface to Interface	interface B extends A	One interface can inherit another.
Class to Interface	class C implements A	A class implements one or more interfaces.

🧩 6. Why Use Separate Interface Implementations? (Design Best Practices)
✅ Benefits:
Modularity: Change/extend features (e.g., new engine) without touching main code.

Loose Coupling: Components interact via interfaces, not implementations.

Flexibility: Swap components at runtime (Engine, Media).

Interface Segregation Principle (ISP): Classes implement only needed functionality.

Composition Over Inheritance: Easier to maintain and extend.

🚗 7. Real-World Analogy: NiceCar Example
Components:
Engine → interface

PowerEngine, ElectricEngine → implementations

Media, CDPlayer → media player via interface

NiceCar → main class using composition (engine + media)

NiceCar car = new NiceCar();        // composed of Engine + Media
car.start();                        // delegates to Engine
car.startMusic();                   // delegates to Media
car.upgradeEngine(new ElectricEngine());
car.start();                        // now uses ElectricEngine
🧪 8. Nested Interface in Java
One interface can be declared inside another.

interface Outer {
    interface Inner {
        void show();
    }
}
Implementing class:

java
Copy
Edit
class Demo implements Outer.Inner {
    public void show() {
        System.out.println("Nested interface implementation");
    }
}
🔸 Outer interface should be public or package-private (default).
🔸 Inner interface can have any access specifier.

📚 9. Common Interface Examples in Java
Comparable, Runnable, Serializable, Cloneable, etc.

🎯 10. Final Takeaways for Interviews
Use interfaces to achieve multiple inheritance and abstraction.

All variables are public static final → constants.

Interfaces promote clean architecture and modular design.

Favor composition (HAS-A) over inheritance (IS-A).

Interface-driven design leads to scalable and testable systems.





## kunal notes
Multiple inheritance is not available in java.
(Same functions in 2 classes it will skip that hence no multiple inheritance)

Instead we have java interfaces. they have abstract functions (no body of functions)

Interface is like class but not completely. it is like an abstract class.
By default functions are public and abstract in interface.
variables are final and static by default in interface.

Interfaces specify only what the class is doing, not how it is doing it.
The problem with MULTIPLE INHERITANCE is that two classes may define different ways of doing the same thing,
and the subclass can't choose which one to pick.

Key difference between a class and an interface: a class can maintain state information
(especially through the use of instance variables), but an interface cannot.

Using interface, you can specify a set of methods that can be implemented by one or more classes.
Although they are similar to abstract classes, interfaces have an additional capability:
A class can implement more than one interface. By contrast, a class can only inherit a single superclass
(abstract or otherwise).

Using the keyword interface, you can fully abstract a class’ interface from its implementation.
That is, using interface, you can specify what a class must do, but not how it does it.

Interfaces are syntactically similar to classes, but they lack instance variables, and, as a general rule,
their methods are declared without any body.

By providing the interface keyword, Java allows you to fully utilize the “one interface, multiple methods”
aspect of polymorphism.

NOTE: Interfaces are designed to support dynamic method resolution at run time.
Normally, in order for a method to be called from one class to another, both classes need to be present at compile time
so the Java compiler can check to ensure that the method signatures are compatible. This requirement by itself makes for
a static and nonextensible classing environment. Inevitably in a system like this, functionality gets pushed up higher
and higher in the class hierarchy so that the mechanisms will be available to more and more subclasses. Interfaces are
designed to avoid this problem. They disconnect the definition of a method or set of methods from the inheritance
hierarchy. Since interfaces are in a different hierarchy from classes, it is possible for classes that are unrelated
in terms of the class hierarchy to implement the same interface. This is where the real power of interfaces is realized.

Beginning with JDK 8, it is possible to add a default implementation to an interface method.
Thus, it is now possible for interface to specify some behavior.However, default methods constitute what is, in essence,
a special-use feature, and the original intent behind interface still remains.

Variables can be declared inside of interface declarations.
NOTE: They are implicitly final and static, meaning they cannot be changed by the implementing class.
They must also be initialized. All methods and variables are implicitly public.

NOTE: The methods that implement an interface must be declared public. Also, the type signature of the implementing
method must match exactly the type signature specified in the interface definition.

It is both permissible and common for classes that implement interfaces to define additional members of their own.

NOTE:
You can declare variables as object references that use an interface rather than a class type.
This process is similar to using a superclass reference to access a subclass object.
Any instance of any class that implements the declared interface can be referred to by such a variable.
When you call a method through one of these references, the correct version will be called based on the actual instance
of the interface being referred to. Called at run time by the type of object it refers to.
The method to be executed is looked up dynamically at run time, allowing classes to be created later than the code which
calls methods on them.
The calling code can dispatch through an interface without having to know anything about the “callee.”

CAUTION: Because dynamic lookup of a method at run time incurs a significant overhead when compared with the normal
method invocation in Java, you should be careful not to use interfaces casually in performance-critical code.


Nested Interfaces:

An interface can be declared a member of a class or another interface. Such an interface
is called a member interface or a nested interface. A nested interface can be declared as public, private, or protected.
This differs from a top-level interface, which must either be declared as public or use the default access level.

// This class contains a member interface.
class A {
  // this is a nested interface
  public interface NestedIF {
    boolean isNotNegative(int x);
  }
}
// B implements the nested interface.
class B implements A.NestedIF {
  public boolean isNotNegative(int x) {
    return x < 0 ? false: true;
  }
}
class NestedIFDemo {
  public static void main(String args[]) {
    // use a nested interface reference
    A.NestedIF nif = new B();
    if(nif.isNotNegative(10))
      System.out.println("10 is not negative");
    if(nif.isNotNegative(-12))
      System.out.println("this won't be displayed");
  }
}

Interfaces Can Be Extended:
One interface can inherit another by use of the keyword extends. The syntax is the same as for inheriting classes.
Any class that implements an interface must implement all methods required by that interface, including any that are
inherited from other interfaces.


Default Interface Methods (aka extension method) :
A primary motivation for the default method was to provide a means by which interfaces could be expanded without breaking existing code.
i.e. suppose you add another method without body in an interface. Then you will have to provide the body of that method
in all the classes that implement that interface.
Ex:
 default String getString() {
    return "Default String";
 }

For example, you might have a class that implements two interfaces.
If each of these interfaces provides default methods, then some behavior is inherited from both.
# In all cases, a class implementation takes priority over an interface default implementation.
# In cases in which a class implements two interfaces that both have the same default method, but the class does not
override that method, then an error will result.
# In cases in which one interface inherits another, with both defining a common default method, the inheriting
interface’s version of the method takes precedence.

NOTE: static interface methods are not inherited by either an implementing class or a subinterface.
i.e. static interface methods should have a body! They cannot be abstract. 

NOTE : when overriding methods, the access modifier should be same or better i.e. if in Parent Class it was protected, then then overridden should be either protected or public.

