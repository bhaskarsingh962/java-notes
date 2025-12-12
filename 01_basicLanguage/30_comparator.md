## What is a Comparator in Java?
A Comparator is a functional interface in java.util package used to define custom sorting logic for objects.
It allows you to compare two objects manually instead of relying on Java’s default (natural) order.
Syntax
public interface Comparator<T> {
    int compare(T o1, T o2);
}
Negative → if o1 < o2
Zero → if o1 == o2
Positive → if o1 > o2

##  Why Do We Need Comparator?
Sometimes, your class (like Employee, Student, etc.) does not implement Comparable
or you want different sorting logics (e.g., by name, by salary, by age).
In that case, we use a Comparator.

##  Example 1 — Sorting Strings by Length
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Bhaskar", "Amit", "Rohan", "Zoya");

        // Custom Comparator (by length)
        Comparator<String> byLength = (s1, s2) -> s1.length() - s2.length();

        Collections.sort(names, byLength);

        System.out.println(names);
    }
}

[Zoya, Amit, Rohan, Bhaskar]

##  Example 2 — Sorting Custom Objects
Let’s say you have an Employee class 👇
class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return name + " - " + salary;
    }
}


Now you want to sort employees by salary.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
            new Employee("Bhaskar", 60000),
            new Employee("Rohan", 50000),
            new Employee("Amit", 70000)
        );

        // Sort by salary (ascending)
        Comparator<Employee> bySalary = (e1, e2) -> e1.salary - e2.salary;

        Collections.sort(list, bySalary);

        System.out.println(list);
    }
}
✅ Output:
[Rohan - 50000, Bhaskar - 60000, Amit - 70000]

##  Example 3 — Sort by Multiple Fields
Sort employees by salary, and if equal, then by name:
Comparator<Employee> bySalaryThenName =
    (e1, e2) -> e1.salary != e2.salary
        ? e1.salary - e2.salary
        : e1.name.compareTo(e2.name);

Collections.sort(list, bySalaryThenName);
This combines multiple sorting criteria.

## Example 4 — Using Lambda with List.sort()
Instead of using Collections.sort(), you can do:
list.sort((e1, e2) -> e1.salary - e2.salary);
Same result — simpler syntax (Java 8+).

##  Comparator Utility Methods (Java 8+)
Java 8 added powerful static methods in Comparator interface.
Method	Description
Comparator.comparing()	Builds a comparator based on key extraction
reversed()	Reverses the order
thenComparing()	Adds secondary sorting
✅ Example: Using Comparator.comparing
list.sort(Comparator.comparing(e -> e.salary));

✅ Example: Reversed order
list.sort(Comparator.comparing(e -> e.salary).reversed());

✅ Example: Multiple conditions
list.sort(Comparator.comparing((Employee e) -> e.salary)
                    .thenComparing(e -> e.name));

##  Example 5 — Anonymous Class (Old Style)
Before lambdas, we used this syntax:
Collections.sort(list, new Comparator<Employee>() {
    public int compare(Employee e1, Employee e2) {
        return e1.salary - e2.salary;
    }
});
✅ Still works, but longer and less readable.

## Time Complexity

Same as normal sorting → O(n log n)
Comparator just changes how two elements are compared.

🧠 10️⃣ Difference Between Comparable vs Comparator
Feature	Comparable	Comparator
Package	java.lang	java.util
Method	compareTo(T o)	compare(T o1, T o2)
Used for	Natural order	Custom order
Defined in	The class itself	Outside the class
Modifies class?	Yes	No
Example	Collections.sort(list)	Collections.sort(list, comparator)

✅ Example:

Comparable → “Student objects always compared by roll number.”
Comparator → “I want to sort students by name or marks — temporarily.”
💬 11️⃣ Interview-Ready Summary

“A Comparator in Java is a functional interface used to define custom sorting logic between two objects.
It has a single method compare(T o1, T o2) that returns a negative, zero, or positive value.
It’s often used when you can’t or don’t want to modify the class itself.
From Java 8 onward, we can use lambdas, Comparator.comparing(), and thenComparing() for elegant sorting.”

✅ 12️⃣ Quick Summary Table
Concept	Comparator
Type	Functional Interface
Method	int compare(T o1, T o2)
Package	java.util
Introduced	Java 1.2
Used for	Custom sorting
Lambda support	✅ Yes (Java 8+)
Example	list.sort((a,b)->a.salary-b.salary)

Would you like me to add this Comparator section (with examples & table) into your existing Java Notes document — right after the sorting section?
That way, your notes will stay complete and organized.