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

Try this:
java
Copy
Edit
interface Test {
    int a = 100;
}
This is automatically treated as:

java
Copy
Edit
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

## nested interface can be made in java and fro that the first interface should be public or defualt and the implement can whatever


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

java
Copy
Edit
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

java
Copy
Edit
NiceCar car = new NiceCar();        // composed of Engine + Media
car.start();                        // delegates to Engine
car.startMusic();                   // delegates to Media
car.upgradeEngine(new ElectricEngine());
car.start();                        // now uses ElectricEngine
🧪 8. Nested Interface in Java
One interface can be declared inside another.

java
Copy
Edit
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

