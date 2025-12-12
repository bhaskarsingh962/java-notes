## 1. Procedural Programming

A style where you write step-by-step instructions (procedures) for the computer to follow. Focus is on functions, not data.
🔧 Key Idea:
Code is organized into functions (also called procedures).
Follows top-to-bottom execution.
No concept of classes/objects.
💻 Example (C Language):
c
Copy code
#include <stdio.h>

void greet() {
    printf("Hello, Bhaskar!\n");
}

int main() {
    greet();
    return 0;
}

✅ Used in: C, Pascal, BASIC



## "Do this, then that, then that..."
Focus: Functions + sequence of steps

📦 Real-World Analogy:
A recipe: step 1, step 2, step 3...

💻 Code Example (JavaScript):
js
Copy code
// Step-by-step process
let studentName = "Bhaskar";
let marks = 90;

function printReport(name, marks) {
    console.log(`${name} scored ${marks}`);
}

printReport(studentName, marks);



## 2. Functional Programming
Definition:
Programming using pure functions, where data is immutable and there's no shared state. Focus is on what to solve, not how.
🔧 Key Idea:
Avoids changing state.
Emphasizes function composition.
Often uses recursion instead of loops.
💻 Example (JavaScript):
const square = x => x * x;
const numbers = [1, 2, 3, 4];
const squares = numbers.map(square); // [1, 4, 9, 16]
console.log(squares);
✅ Used in: Haskell, Scala, JavaScript, Lisp, Python (partially)


## 3. Object-Oriented Programming (OOP)
Organizes code into objects, which are instances of classes. Emphasizes encapsulation, inheritance, and polymorphism.

Code is structured around objects and classes.
Encapsulates data + behavior together.
Encourages reusability and modularity.
💻 Example (Java):
java
Copy code
class Person {
    String name;
    Person(String name) {
        this.name = name;
    }
    void greet() {
        System.out.println("Hello, " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Bhaskar");
        p.greet();
    }
}






## static vss dynamic language

## What is a Static Language?
Definition:
A static language checks types at compile time — before the program runs.
Variable types are known and fixed before execution.
Errors are caught early during development.
📦 Real-World Analogy:
Imagine submitting a form that won’t let you proceed unless every field is perfectly filled and validated. That’s like static typing — strict but safe.
💻 Example: Java (Static Language)

int age = 25;       // Declaring a variable with a specific type
age = "twenty";     // ❌ Compile-time error: type mismatch
✅ Pros:
Early error detection (at compile time)
Better IDE support & auto-completion
Easier to optimize for performance

❌ Cons:
More boilerplate code
Slower prototyping

## ✅ What is a Dynamic Language?
A dynamic language checks types at runtime — when the program is running.
💡 Key Point:
Variable types are not declared explicitly.
Variables can change type dynamically.

📦 Real-World Analogy:
It’s like filling a form where you can enter anything, and only at submission time, it tells you what’s wrong. Flexible, but risky.

💻 Example: JavaScript (Dynamic Language)
js
Copy code
let age = 25;      // Number
age = "twenty";    // ✅ Allowed at runtime
console.log(age);  // "twenty"
✅ Pros:
Faster to write & test

Flexible and expressive

Great for rapid development

❌ Cons:
Type errors happen at runtime

Harder to maintain large codebases

