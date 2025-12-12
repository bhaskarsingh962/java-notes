## What is a Lambda Expression in Java?

A Lambda Expression is a short way to write anonymous methods (functions without a name).
It was introduced in Java 8 and is a key part of Functional Programming in Java.
Syntax:
(parameters) -> expression

(parameters) -> { statements }

✅ Example 1: Without Lambda
interface Greeting {
    void sayHello();
}

public class Main {
    public static void main(String[] args) {
        Greeting g = new Greeting() {
            public void sayHello() {
                System.out.println("Hello, Java!");
            }
        };
        g.sayHello();
    }
}

✅ Example 2: With Lambda
interface Greeting {
    void sayHello();
}

public class Main {
    public static void main(String[] args) {
        Greeting g = () -> System.out.println("Hello, Lambda!");
        g.sayHello();
    }
}


✅ Output:

Hello, Lambda!

## Functional Interface (Core concept)
A Functional Interface is an interface that has exactly one abstract method.

@FunctionalInterface
interface Operation {
    int perform(int a, int b);
}


## Syntax Variations
Type	             Example	                                       Description
No parameter	    () -> System.out.println("Hi")	                    No args
One parameter	    x -> x*x	                                       No parentheses needed if single param
Multiple params	    (a, b) -> a + b	                                    Use parentheses
Multi-statement	    (a, b) -> { int sum = a + b; return sum; }	        Use {} and return



##  What is a Functional Interface? Give examples.
Definition:
A Functional Interface is an interface that contains exactly one abstract method.
It can have any number of default or static methods, but only one abstract method.
Functional interfaces are the foundation of lambda expressions — a lambda can be used only when there’s a functional interface.

✅ Example:
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}


Usage:

Calculator c = (a, b) -> a + b;
System.out.println(c.add(10, 20)); // Output: 30

✅ Common      Built-in Functional Interfaces:
Interface	        Method	                              Example
Runnable	        run()	                           () -> System.out.println("Running")
Comparator<T>	  compare(T a, T b)	                     (a,b)->a-b
Consumer<T>	       accept(T t)	                       s -> System.out.println(s)
Predicate<T>	   test(T t)	                          n -> n>10
Function<T,R>	    apply(T t)	                           x -> x*x


## Lambda Expression:
list.forEach(name -> System.out.println(name));
list.forEach(System.out::println);
Both are same — second one is just cleaner and uses an existing method reference.

## Can Lambda Expression return a value?
✅ Yes, definitely.
A lambda expression can return a value — just like a regular method.

# Example 1 (Single line, implicit return)
interface Sum {
    int add(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        Sum s = (a, b) -> a + b;
        System.out.println(s.add(5, 10)); // Output: 15
    }
}

Example 2 (Multi-line, explicit return)
Sum s = (a, b) -> {
    int sum = a + b;
    return sum;
};


If the lambda body has multiple statements, you must use {} and return.

## How does a Lambda improve readability or performance?
Readability:
Removes boilerplate code like anonymous classes.
Code becomes cleaner and expressive.
// Before
new Thread(new Runnable() {
    public void run() {
        System.out.println("Running");
    }
}).start();

// After
new Thread(() -> System.out.println("Running")).start();

## Performance:
Internally, lambdas don’t create new anonymous class objects.
JVM uses invokedynamic (a bytecode instruction) to dynamically link the lambda at runtime.
So it’s memory efficient and faster than creating anonymous inner classes.

## Program: Sort a List of Employee Objects by Salary using Lambda
Example:
import java.util.*;

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return name + " - " + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Bhaskar", 60000));
        employees.add(new Employee("Amit", 55000));
        employees.add(new Employee("Riya", 70000));

        // Sort by salary using lambda
        employees.sort((e1, e2) -> Double.compare(e1.salary, e2.salary));

        employees.forEach(System.out::println);
    }
}


✅ Output:
Amit - 55000.0
Bhaskar - 60000.0
Riya - 70000.0

## How do Lambdas work internally in the JVM?
Behind the scenes, lambdas are implemented using invokedynamic instruction (added in Java 7).
JVM doesn’t create an anonymous inner class for every lambda.
Instead, it creates a synthetic method (a hidden method) for the lambda code.
Then, it dynamically creates a functional interface instance only once, linking it to that synthetic method.
In simple terms:
“Lambdas are compiled as lightweight methods, not full-fledged classes — making them faster and memory efficient.”

## What happens if you capture a non-final variable inside a Lambda?
In Java, a lambda can only capture variables that are final or effectively final.
Example (Invalid):
int x = 10;
Runnable r = () -> System.out.println(x);
x = 20; // ❌ compile-time error

✅ Example (Valid):
int x = 10;
Runnable r = () -> System.out.println(x);
r.run(); // Output: 10


“Effectively final” means:
You don’t mark it as final, but you never modify it after initialization.
Bonus: Short Interview Summary
Question	Quick Answer
What is a functional interface?	Interface with one abstract method (e.g., Runnable, Predicate).
Lambda vs Method Reference	Lambda defines logic, method ref reuses existing method.
Can Lambda return value?	Yes, using expression or return.
Improves readability/performance?	Less code, faster execution, no extra classes.
Sort Employees	Use (e1, e2) -> Double.compare(e1.salary, e2.salary).
How works internally?	Uses invokedynamic, not anonymous classes.
Capturing non-final vars?	Only final or effectively final allowed.




## Can we use Lambda Expression in a Non-Functional Interface?

❌ No, you cannot directly use a lambda expression with a non-functional interface.
Lambdas in Java are designed to work only with Functional Interfaces, i.e., interfaces that have exactly one abstract method.

# Why?
When you write a lambda expression, like:
() -> System.out.println("Hello");
👉 Java needs to know which abstract method this lambda is implementing.
If the interface has multiple abstract methods, then Java cannot decide which one to map your lambda to — that’s why it gives a compile-time error.

⚠️ Example — Non-functional Interface
interface Demo {
    void method1();
    void method2();
}

public class Main {
    public static void main(String[] args) {
        // ❌ Compile-time error: Demo is not a functional interface
        Demo d = () -> System.out.println("Hello");
    }
}


Output:
error: incompatible types: bad return type in lambda expression
Demo is not a functional interface

# But Wait — There is a Trick 😉
You can still use lambda expressions with part of a non-functional interface —
but only when you convert or wrap that logic through a functional interface reference.
Let’s see how 👇
🧩 Example 1: Use functional interface inside non-functional interface
interface NonFunctional {
    void method1();
    void method2();
}

@FunctionalInterface
interface Operation {
    void perform();
}

class Main implements NonFunctional {
    public void method1() {
        // ✅ Using lambda inside method1
        Operation op = () -> System.out.println("Lambda inside non-functional interface");
        op.perform();
    }
    public void method2() {
        System.out.println("Normal method");
    }

    public static void main(String[] args) {
        new Main().method1();
        new Main().method2();
    }
}


✅ Output:

Lambda inside non-functional interface
Normal method


So — you can’t assign a lambda to a non-functional interface,
but you can use lambdas inside its methods if they work with another functional interface.

🧩 Example 2: Anonymous class alternative (old way)

Before Lambdas, we did:

Runnable r = new Runnable() {
    public void run() {
        System.out.println("Old way");
    }
};


After Lambda (Runnable is functional interface):

Runnable r = () -> System.out.println("New way with lambda");


But if you try this with an interface having 2 abstract methods, Java can’t guess which one to map.

✅ Summary Table
Interface Type	Can use Lambda?	Why / Why Not
Functional Interface (1 abstract method)	✅ Yes	Java knows which method lambda represents
Non-Functional Interface (≥2 abstract methods)	❌ No	Ambiguous — compiler can’t decide target method
Inside a method of a non-functional interface	✅ Indirectly	You can use lambda with another functional interface inside
💬 Interview-ready Answer

"No, a lambda expression in Java can only be used with functional interfaces — those having exactly one abstract method.
If an interface has multiple abstract methods, the compiler can’t determine which one the lambda should implement.
However, we can still use lambdas inside the methods of non-functional interfaces by referring to other functional interfaces."