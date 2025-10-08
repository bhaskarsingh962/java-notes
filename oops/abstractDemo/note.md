# abstract class
Abstract class can have both abstract and concrete methods.
Abstract class is partially implemented, used for code reusability and providing a template for subclasses.
Normal class is fully implemented, can be instantiated directly.

# Fields in abstract class
Can have instance variables (non-final)
Can have static variables
Can have constants (final static)


# Subclassing
Any subclass of an abstract class must:
Implement all abstract methods
OR declare itself abstract
abstract class Vehicle {
    abstract void start();
}
abstract class Bike extends Vehicle {
    // Not required to implement start() because Bike is still abstract
}
class Pulsar extends Bike {
    void start() { System.out.println("Pulsar started"); }
}


# Real-Life Examples
Vehicle Example
Abstract class: Vehicle (abstract method: start())
Subclasses: Car, Bike, Truck
Bank Example
Abstract class: BankAccount (abstract method: calculateInterest())
Subclasses: SavingsAccount, FixedDepositAccount
Employee Example
Abstract class: Employee (abstract method: calculateSalary())
Subclasses: Manager, Developer, Intern



                        +----------------------+
                        |      Class           |
                        +----------------------+
                        | - Can have fields    |
                        | - Can have methods   |
                        | - Can be instantiated|
                        +----------------------+
                                  ^
                                  |
                  ----------------+-----------------
                  |                                |
      +----------------------+           +----------------------+
      | Abstract Class       |           | Normal Class         |
      +----------------------+           +----------------------+
      | - Cannot instantiate |           | - Can instantiate    |
      | - Can have abstract  |           | - Fully implemented |
      |   methods (0..n)     |           | - Concrete only     |
      | - Can have concrete  |           +----------------------+
      |   methods            |
      | - Can have fields    |
      | - Can have constructors|
      +----------------------+
                  ^
                  |
          ----------------
          |
+----------------------+
| Interface            |
+----------------------+
| - Cannot instantiate |
| - Only constants     |
| - Abstract methods   |
| - Default methods    |
| - Static methods     |
| - Multiple inheritance|
+----------------------+
          ^
          |
+----------------------+
| Default Method       |
+----------------------+
| - Belongs to object  |
| - Can be overridden  |
| - Provides optional  |
|   behavior           |
+----------------------+


4️⃣ Final Key Points to Remember (Quick Summary)
Concept	Remember This
Definition	Blueprint for other classes, may or may not contain abstract methods
Instantiation	               Cannot instantiate directly
Constructor	                  ✅ Allowed, used for common initialization
Abstract Method	              Declared with abstract, no body
Concrete Method	Fully defined (has body)
Static Method            	✅ Allowed, cannot be overridden (only hidden)
Final Method	            ✅ Allowed, cannot be overridden
Private Method	            ✅ Allowed (used internally, not inherited)
Field Types	Instance, static, final — all allowed
Subclass	               Must implement all abstract methods or itself be abstract
Access Modifier for Abstract Method	Must be public or protected, never private
Multiple Inheritance	❌ Not allowed for classes
Polymorphism	    ✅ Supported (dynamic method dispatch)

💡 5️⃣ When To Use Abstract Class vs Interface
Use Abstract Class When	Use Interface When
You need shared code or fields	You need pure behavior contract
You want partial implementation	You want multiple inheritance
You expect subclasses to share state or logic	You want classes to just agree on methods
You might change base class implementation later	You need flexibility across unrelated classes 



🏁 7️⃣ Quick Interview Question Hints

✅ Can abstract class have constructor? → Yes.
✅ Can abstract method be static or final? → No.
✅ Can abstract class have static/final methods? → Yes.
✅ Can abstract class have variables? → Yes.
✅ Can abstract class be instantiated? → No.
✅ Can abstract class implement interface? → Yes.
✅ Can abstract class extend another class? → Yes.




# //kunal
Sometimes you will want to create a superclass that only defines a generalized form that will be shared by all of its
subclasses, leaving it to each subclass to fill in the details. Such a class determines the nature of the methods that
the subclasses must implement.
You may have methods that must be overridden by the subclass in order for the subclass to have any meaning.
In this case, you want some way to ensure that a subclass does, indeed, override all necessary methods. Java’s solution
to this problem is the abstract method.
You can require that certain methods be overridden by subclasses by specifying the abstract type modifier.

        abstract type name(parameter-list);

These methods are sometimes referred to as subclass's responsibility because they have no implementation specified in
the superclass.
Thus, a subclass must override them—it cannot simply use the version defined in the superclass.

Any class that contains one or more abstract methods must also be declared abstract.
# There can be no objects of an abstract class.
# You cannot declare abstract constructors, or abstract static methods.
# You can declare static methods in abstract class.
Because there can be no objects for abstract class. If they had allowed to call abstract static methods,
it would that mean we are calling an empty method (abstract) through classname because it is static.
Any subclass of an abstract class must either implement all of the abstract methods in the superclass,
or be declared abstract itself.
Abstract classes can include as much implementation as they see fit i.e.there can be concrete methods(methods with body)
in abstract class.

Although abstract classes cannot be used to instantiate objects, they can be used to create object references,
because Java’s approach to run-time polymorphism is implemented through the use of superclass references.

A public constructor on an abstract class doesn't make any sense because you can't instantiate an abstract class directly 
(can only instantiate through a derived type that itself is not marked as abstract)
Check: https://stackoverflow.com/questions/260666/can-an-abstract-class-have-a-constructor


Abstract class vs Interface:

Type of methods:
Interface can have only abstract methods.
Abstract class can have abstract and non-abstract methods. From Java 8, it can have default and static methods also.

Final Variables:
Variables declared in a Java interface are by default final.
An abstract class may contain non-final variables.

Type of variables:
Abstract class can have final, non-final, static and non-static variables.
Interface has only static and final variables.

Implementation:
Abstract class can provide the implementation of interface.
Interface can’t provide the implementation of abstract class.

Inheritance vs Abstraction:
A Java interface can be implemented using keyword “implements”
and abstract class can be extended using keyword “extends”.

Multiple implementation:
An interface can extend another Java interface only,
an abstract class can extend another Java class and implement multiple Java interfaces.

Accessibility of Data Members:
Members of a Java interface are public by default.
A Java abstract class can have class members like private, protected, etc.