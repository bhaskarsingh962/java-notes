## What is Type Casting in Java?
Type Casting is the process of converting one data type into another.

Java supports two types of casting:

## 1. Widening Casting (Automatic)
Converts a smaller type to a larger type size (safe conversion).

byte → short → int → long → float → double
🔸 Example:


int a = 10;
double b = a; // int to double (automatically casted)
System.out.println(b); // Output: 10.0
This is done implicitly by Java because there’s no risk of data loss.

## 2. Narrowing Casting (Manual)
Converts a larger type to a smaller type size (may lose data).


double → float → long → int → short → byte
🔸 Example:

double x = 10.99;
int y = (int) x; // double to int (explicit casting)
System.out.println(y); // Output: 10 (decimal truncated)
Here, you must cast manually using (type), because precision can be lost.

## 🧠 FAANG-Level Explanation (When Interviewer Asks):
You can answer like this:

## “Type casting in Java is converting a variable from one data type to another. Java supports both implicit (widening) and explicit (narrowing) type casting. Implicit casting happens safely when converting smaller to larger data types (e.g., int to double), while explicit casting is required when converting larger to smaller types (e.g., double to int), since data loss can occur. It's commonly used in scenarios involving arithmetic operations, collections with generics, and when working with APIs that accept different data types.”

## ✅ Casting Between Primitives vs Non-Primitives
Casting Type	Applies To	Safe?	Needs Manual Cast?
Widening	Primitive	Yes	No
Narrowing	Primitive	No	Yes
Upcasting	Objects	Yes	No
Downcasting	Objects	No	Yes

## ✅ Object Type Casting (Advanced)
🔹 Upcasting (Child → Parent) — Safe

class Animal {}
class Dog extends Animal {}

Animal a = new Dog(); // Upcasting
🔹 Downcasting (Parent → Child) — Risky, needs manual cast
java
Copy
Edit
Animal a = new Dog();
Dog d = (Dog) a; // Downcasting
🔥 Bonus FAANG Tip: Use Type Casting Smartly
Don’t overuse narrowing—it may cause data loss or runtime exceptions.

Use instanceof to avoid ClassCastException during object downcasting:


if (a instanceof Dog) {
    Dog d = (Dog) a;
}
Type casting is useful in generics, data parsing, custom serialization, and polymorphic behavior.

✅ Summary Table
Cast Type	Syntax	Safe?	Example
Widening	Automatic	✅	int → double
Narrowing	(type)	⚠️	(int) 10.5
Object Upcast	Automatic	✅	Dog → Animal
Object Downcast	(Child)	⚠️	(Dog) animalObj

