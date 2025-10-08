# interface
“Interfaces define behavior contracts, not implementation. Since interfaces cannot be instantiated, they cannot have constructors. Any initialization is done in the concrete class that implements the interface.”
Interfaces define behavior contracts. Properties in interfaces are constants (public static final) because interfaces don’t maintain state. Any class implementing the interface provides the actual implementation for the methods



# default method in interface can be override in child class(optional) other wise inteface method will call
Default methods provide a default implementation in the interface.
They can be overridden by the implementing class if you want custom behavior.
They cannot be static, because static methods belong to the interface itself and are not tied to the object.

# static method can be access direct using the the class 

# other unimplemented method can be override in child class

# Interfaces cannot have constructors
   Why interfaces cannot have constructors
  🔹 Reason 1: Interfaces cannot be instantiated
A constructor is used to create objects of a class.
Interfaces cannot be directly instantiated:
So a constructor in an interface would make no sense, because no object of the interface itself is ever created.

# property
String BRAND = "Tata";   // public static final by default
if you dont make  any propery public static final. it will be made by compiler automatically