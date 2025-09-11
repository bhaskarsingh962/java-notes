## Java Generics, ArrayList, Comparable & Comparator – Notes with Examples


📘 1. What are Generics in Java?
➤ Definition:
Generics allow you to write type-safe and reusable code by specifying a type parameter (like <T>).
They prevent ClassCastException at runtime and provide compile-time type safety.

🔹 Syntax:
class Box<T> {
    T value;
    void set(T value) { this.value = value; }
    T get() { return value; }
}


## 📘 2. Why is ArrayList a Generic?
➤ Reason:
ArrayList is a generic class, defined as ArrayList<E>.
It allows you to store only specific data types and avoid casting.


## 🔹 Without Generics:
ArrayList list = new ArrayList(); 
list.add("hello");
String s = (String) list.get(0);  // Requires casting
🔹 With Generics:

ArrayList<String> list = new ArrayList<>();
list.add("hello");
String s = list.get(0); // No casting needed
📘 3. Why is Object used in ArrayList?
Before generics, ArrayList used Object type internally to support any type.
But this caused:

Risk of ClassCastException

No compile-time type checking

Generic ArrayList<T> solves this by restricting the type at compile time.

## 📘 4. What is compareTo()? (Comparable Interface)
➤ Purpose:
Used to define natural sorting order (e.g., ascending by name or age).

🔹 Interface:

public interface Comparable<T> {
    int compareTo(T o);
}
🔹 Example:

class Student implements Comparable<Student> {
    int marks;
    Student(int marks) { this.marks = marks; }

    public int compareTo(Student s) {
        return this.marks - s.marks; // Ascending order
    }
}


## 📘 5. Custom Comparator using Comparator Interface
➤ Purpose:
To customize sorting (by different fields, or reverse order).

🔹 Syntax:

Comparator<Student> byMarks = new Comparator<Student>() {
    public int compare(Student s1, Student s2) {
        return s2.marks - s1.marks; // Descending
    }
};


## 📘 6. Custom Comparator using Lambda Expression

List<Student> students = new ArrayList<>();
students.add(new Student("Bhaskar", 90));
students.add(new Student("Amit", 80));

## students.sort((s1, s2) -> s2.marks - s1.marks); // Descending sort by marks
## 7. Full Working Example

import java.util.*;

class Student {
    String name;
    int marks;
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    public String toString() {
        return name + " - " + marks;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Bhaskar", 92));
        list.add(new Student("Amit", 88));

        // Sort using Lambda - Descending marks
        list.sort((a, b) -> b.marks - a.marks);

        for (Student s : list)
            System.out.println(s);
    }
}
📘 8. Interview Questions & Answers
Question	Answer
What are generics in Java?	A feature to define classes, interfaces and methods with type parameters to ensure type safety.
Why use generics with ArrayList?	To avoid casting and ensure compile-time type checking.
Can you store different types in a generic ArrayList?	No, generics restrict to one type (e.g., ArrayList<String>).
What is the difference between Comparable and Comparator?	Comparable defines natural order inside class; Comparator defines custom order outside the class.
How to sort a list in descending order using lambda?	list.sort((a, b) -> b.value - a.value);
Why are generics not allowed with primitive types?	Because generics work with objects only. Use wrapper classes like Integer instead of int.

🔁 Summary Table
Concept	Purpose	Syntax
Generics	Type safety	class Box<T> {}
ArrayList<T>	Store only specific type	ArrayList<String>
Comparable	Natural sorting	compareTo()
Comparator	Custom sorting	Comparator<T>
Lambda	Short form comparator	(a, b) -> ...