## public = can access everywhere


## private can access only in same class but also we can use access it outside the class using getter and also we can set the value using setter

## default access modifier in the diff package it will not allowed but in same package it can access everywhere

## protected - can access everywhere except diff package of notSubclass 


## NOTE 
## 1- how the clssses are extending object class that will multiple inheritance (which java doesn't support) that implementaion is internally


## Java Access Modifiers
Access modifiers in Java determine the visibility (scope) of classes, variables, constructors, and methods. They are essential for encapsulation and security in object-oriented programming.

Types of Access Modifiers
Modifier	Same Class	Same Package	Subclass (Same Package)	Subclass (Diff Package)	World (Other Unrelated Classes)
public	✔	✔	✔	✔	✔
protected	✔	✔	✔	✔	
(no modifier)	✔	✔	✔		


private	✔				
1. public
Accessible from:
Anywhere (any other class, any package).

Example:

java
public class Person {
    public String name;
    public void sayHello() {
        System.out.println("Hello, my name is " + name);
    }
}
2. protected
Accessible from:

Same class

Same package (any class)

Subclass in same or different package

Example:

java
class Animal {
    protected void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        eat(); // Allowed: protected method accessed in subclass
    }
}
3. No Modifier (Package-Private / Default)
Accessible from:

Same class

Other classes in the same package only

Not accessible from subclasses in different packages or from unrelated classes in other packages.

Example:

java
class PackageExample {
    void show() { // no modifier = package-private
        System.out.println("Visible in the same package only");
    }
}
4. private
Accessible from:
Only within the same class.

Example:

java
public class Secret {
    private String pin;

    private void showPin() {
        System.out.println("PIN is: " + pin);
    }
}
Complete Example
java
package mypackage;

public class Demo {
    public int a = 1;
    protected int b = 2;
    int c = 3;          // package-private
    private int d = 4;

    public void testAccess() {
        // All accessible here
    }
}
java
package otherpackage;

import mypackage.Demo;

public class Test extends Demo {
    void test() {
        System.out.println(a); // public ✔
        System.out.println(b); // protected ✔ (subclass)
        // System.out.println(c); // package-private ✘ (different package)
        // System.out.println(d); // private ✘ (never accessible)
    }
}
Interview Questions & Answers
Q1: What are the four access modifiers in Java, and what are their differences?
A: The four access modifiers are public, protected, (default) package-private, and private.

public: Accessible everywhere.

protected: Accessible in the same package, and also in subclasses in other packages.

(no modifier): Accessible only within the same package.

private: Accessible only within the same class.

Q2: When would you use protected over private?
A: Use protected when you want to allow subclasses (even in other packages) to inherit or access a member, but do not want it accessible to the rest of the world. private is for complete encapsulation within the declaring class.

Q3: Is it possible for a subclass in a different package to access a superclass's package-private member?
A: No. Package-private (default) members are not visible to subclasses outside the package.

Q4: Can a subclass access private members of its superclass?
A: No. private members are never accessible outside their declaring class, not even by subclasses.

Q5: Write a code snippet where a protected member is accessed in a subclass in a different package.
A:

java
// In package animals
package animals;
public class Animal {
    protected int legs = 4;
}

// In package zoo
package zoo;
import animals.Animal;
public class Dog extends Animal {
    void printLegs() {
        System.out.println(legs); // Accessing protected member from superclass
    }
}
Summary Table (as per interview)
Modifier	Class	Package	Subclass (Same Pkg)	Subclass (Other Pkg)	Outside World
public	✔	✔	✔	✔	✔
protected	✔	✔	✔	✔	
no modifier	✔	✔	✔		
private	✔				
