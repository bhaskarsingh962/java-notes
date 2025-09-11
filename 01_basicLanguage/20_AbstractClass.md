## Abstarction - hiding unneccesary details and showing esential information - like you are use collectionlibrary or you are using method from that but that time you just using those function but implementation of those is hidden when you do ctr + click on method then you can see that method
-- design issue
-- gaining information


## Abstract class can use -
1- final and non final method 
2- static and non method also 
3- absract and non abstract method also

## Note - 
## 1 - for abstract class you cant create object
## 2- if you are making abstract class you need to use keyword abstract
## 3- you cant create abstract constructor
## 4- you can make static method in abstract classes becouse static method can be call using class.
## 5- using abstract class you need extends keyword 
## 6- what about you make class final - you cant make class final
  🔹 What does abstract mean in Java?
An abstract class is meant to be inherited by other classes.
It can have:
abstract methods (no body → must be implemented in child)
concrete methods (normal methods with body → inherited directly)

## 7- here also multiple inheritance is not allowed




## 🔹 Why abstract classes don’t have constructors?

You cannot instantiate an abstract class directly, so writing new AbstractClass() is not allowed.

But an abstract class can still have a constructor, it’s just that you can’t use it directly for creating objects.
Instead, it is used when a child class extends the abstract class.

🔹 How do we access implemented methods of an abstract class?

There are two cases:

Abstract class has implemented (concrete) methods

These methods are inherited by the child class like normal inheritance.

You can create an object of the child class and call them.

abstract class Animal {
    Animal() {
        System.out.println("Animal constructor called");
    }

    // Concrete (implemented) method
    void eat() {
        System.out.println("Animal eats food");
    }

    // Abstract method
    abstract void sound();
}

class Dog extends Animal {
    Dog() {
        System.out.println("Dog constructor called");
    }

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();    // Calls both constructors
        d.eat();              // Access implemented method
        d.sound();            // Access abstract method (overridden in Dog)
    }
}


✅ Output:

Animal constructor called
Dog constructor called
Animal eats food
Dog barks


👉 Notice:

## note - Animal (abstract class) constructor was called first, even though we didn’t create new Animal().

## That’s because when you make a new Dog(), the parent constructor (Animal) is also executed.

🔹 So the rule is:

You can’t directly create an abstract class object → so no standalone instantiation.

But abstract classes can (and usually do) have constructors, which get called indirectly when a subclass object is created.

Concrete methods of the abstract class can be accessed via the child class object.