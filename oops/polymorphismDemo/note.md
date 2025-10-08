# polymorphism - 
Polymorphism means "many forms".
In Java, it allows one object to take multiple forms — the same method name behaves differently based on the object that calls it.

# Type	                   When It Happens	   How It’s Achieved	   Also Known As
Compile-time Polymorphism	During compilation	Method overloading, operator overloading (not in Java)	Static binding / Early binding
Runtime Polymorphism	 During execution	Method overriding using inheritance	Dynamic binding / Late binding



# Upcasting → reference type = parent, object type = child.
➡️ At runtime, JVM checks the actual object type (Bmw),
and calls the overridden method from the child if it exists.


Parnt p = new Child();
using it you can access only those method in which is in parent only or override by child 
you can't access which only in child class
if you want access only child method in that case you need to do downcasting
Parnt p = new Child();
Child c = (Bmw)p;
now using downcasting you can access only child method also

Late binding in Java happens only when a parent reference variable refers to a child class object, and the child overrides the parent’s method.
The decision of which version of the method to call is made at runtime by the JVM, not by the compiler.




## Term	Meaning
# Method Overriding	Defining the same method in the child with the same signature as the parent. Enables runtime polymorphism.
# Upcasting	Assigning a child object to a parent reference — Parent ref = new Child(). Allows dynamic method dispatch.
# Dynamic Method Dispatch	The process by which the call to an overridden method is resolved at runtime, not compile time.
# Late Binding	Method resolution occurs at runtime, based on the actual object.
# Compile-time Type vs Runtime Type	Reference type (known at compile time) vs object type (known at runtime).
# Downcasting	Casting a parent reference back to a child reference (works only if object is actually a child).


# compile time - function overloading - when you make both variable and object from same class compiler already know which method to call in compile time

class Ambiguity {
    void show(int a, double b) {}
    void show(double a, int b) {}
}
Ambiguity a = new Ambiguity();
a.show(5, 5);
# Both show(int, double) and show(double, int) could match equally well with (int, int)
The compiler cannot decide which to pick → Ambiguity


# runtime - when you make parent object varible and child object in that case compiler decide at run time 

# parent c = new Child("tata"); // ❌ Parent object
chil b3 = (chil)c; // this is invalid dont try this will give exception 

# CarLatebinding c = new Bmw("BMW");  // ✅ Child object stored in parent ref
Bmw b3 = (Bmw)c;                    // ✅ Safe downcast
b3.race();       