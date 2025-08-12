## lemba Expression

## 1- lemda expression default type is interface it implements from interface

## 2- this one liner function

## Java Lambda Expressions – Complete Notes
🔹 What is a Lambda Expression?
Lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are used primarily to define the implementation of functional interfaces (an interface with only one abstract method).

Introduced in Java 8 to support functional programming.

🔹 Syntax of Lambda Expression
java
Copy
Edit
(parameter1, parameter2, ...) -> { body }
If the body has only one line, braces {} and return keyword can be omitted.

✅ Examples:
java
Copy
Edit
// 1. Without Lambda
Runnable r1 = new Runnable() {
    public void run() {
        System.out.println("Thread running...");
    }
};

// 2. With Lambda
Runnable r2 = () -> System.out.println("Thread running...");
java
Copy
Edit
// 3. Comparator using Lambda
List<String> list = Arrays.asList("Banana", "Apple", "Mango");

Collections.sort(list, (a, b) -> a.compareTo(b));
System.out.println(list);  // [Apple, Banana, Mango]
🔹 Functional Interface – Base for Lambda
A lambda expression can only be used where a functional interface is expected.

java
Copy
Edit
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

// Lambda implementing the interface
Greeting g = (name) -> System.out.println("Hello, " + name);
g.sayHello("Bhaskar");
🔹 Why Use Lambda?
Shorter syntax

Improves readability

No need of anonymous classes

Ideal for functional-style programming

🔹 Common Use-Cases
Threads

Sorting using Comparator

Collection traversal (Streams + forEach)

Functional interfaces like Predicate, Consumer, Function

🔹 Lambda with Collections (ForEach)
java
Copy
Edit
List<Integer> list = Arrays.asList(1, 2, 3, 4);
list.forEach(n -> System.out.println(n));
🔹 Lambda with Custom Comparator
java
Copy
Edit
List<String> names = Arrays.asList("John", "Alex", "Chris");

// Sort in reverse order using lambda
names.sort((a, b) -> b.compareTo(a));
System.out.println(names);  // [John, Chris, Alex]
🔹 Lambda vs Anonymous Class
Feature	Anonymous Class	Lambda Expression
Verbosity	More	Less
Readability	Less	More
Use-case	Any interface/class	Functional Interface only

💼 Interview Questions with Answers
❓ Q1: What is a lambda expression in Java?
Answer: Lambda expression is an anonymous function used to implement a functional interface in a concise and readable way.

❓ Q2: Can we use lambda without functional interfaces?
Answer: No. Lambda expressions can only be used with functional interfaces.

❓ Q3: What is a functional interface?
Answer: An interface with only one abstract method. Example: Runnable, Comparator, Predicate, etc.

❓ Q4: Can lambda expressions capture variables?
Answer: Yes. Lambda expressions can capture effectively final variables (i.e., variables not modified after initialization).

❓ Q5: What is the return type of a lambda expression?
Answer: It is inferred from the functional interface method the lambda is implementing.

❓ Q6: How is lambda different from anonymous class?
Answer:

Lambda is more concise and readable.

Lambda doesn’t have its own scope; it uses the scope of the enclosing method.

Anonymous classes can define multiple methods; lambdas can't.

🧪 Bonus: Lambda with Stream API
java
Copy
Edit
List<String> list = Arrays.asList("a", "bb", "ccc", "dddd");

list.stream()
    .filter(s -> s.length() > 2)
    .forEach(System.out::println); // Output: ccc, dddd
🔚 Conclusion
Lambda expressions allow Java to support functional-style programming. It makes code more concise, expressive, and readable.



## Java lambda expressions: what they are, how they work, simple examples, and interview tips
What is a lambda expression?
A lambda is a short, anonymous block of code that can take parameters and return a value, introduced in Java 8, and is used to implement a functional interface (an interface with a single abstract method).

Syntax: params -> expression or params -> { statements }.

The type of a lambda is a functional interface (SAM interface).

How it works (core ideas)
Lambdas provide an implementation for the single abstract method of a functional interface and can be passed as values to methods, stored in variables, or returned from methods.

Java infers parameter types in many cases; parentheses, braces, and return can be omitted for single-parameter/single-statement forms.

Common built-in functional interfaces: Predicate<T>, Function<T,R>, Supplier<T>, Consumer<T>, Comparator<T>.

Simple examples
Implementing a custom functional interface:

Interface:
@FunctionalInterface
interface MathOp { int apply(int a, int b); }

Usage:
MathOp add = (a, b) -> a + b;
MathOp mul = (a, b) -> a * b;
// add.apply(2,3) -> 5; mul.apply(2,3) -> 6.

Using a lambda with forEach (Consumer):
java.util.List<Integer> list = java.util.Arrays.asList(1,2,3,4);
list.forEach(n -> System.out.println(n)); // prints 1..4.

Runnable via lambda:
new Thread(() -> System.out.println("New thread created")).start();

Comparator with lambda:
java.util.Collections.sort(names, (a, b) -> a.compareToIgnoreCase(b));

Interview point of view
Definition and purpose:

A lambda is an anonymous function used to implement functional interfaces, enabling behavior to be passed around as data.

Functional Interface (SAM):

Exactly one abstract method; may have default/static methods; @FunctionalInterface is optional but enforces the contract at compile time.

Syntax characteristics:

params -> expression or params -> { block; return ...; }

Optional types (type inference), optional parentheses for single parameter, optional braces/return for single expression.

Method references:

Shorthand related to lambdas (e.g., String::length) that still target functional interfaces; be ready to explain when to use them.

Differences: lambda vs anonymous class:

Lambdas target a functional interface and capture effectively final variables, produce more concise bytecode, and have a different this-binding (this refers to the enclosing instance).

Common built-in interfaces and typical use:

Predicate<T> (test), Function<T,R> (map), Consumer<T> (accept), Supplier<T> (get), Comparator<T> (compare) — especially in Streams and collections operations.

Best practices/pitfalls:

Keep lambdas small and readable; prefer method references when clearer; avoid capturing mutable state; understand effectively final requirement; don’t overuse for complex logic.

Streams tie-in:

Lambdas are frequently used with the Stream API for map/filter/reduce operations; expect simple coding questions using Predicate/Function/Consumer.

Sample quick Q&A:

Q: Can a functional interface have multiple abstract methods? A: No; exactly one, but can have many default/static methods.

Q: What is the type of a lambda? A: A functional interface compatible with its signature.

Q: When can parentheses/types be omitted? A: Single parameter can omit parentheses; types often inferred; multiple parameters require parentheses