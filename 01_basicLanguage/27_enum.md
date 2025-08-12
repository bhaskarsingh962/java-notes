# Enum in Java

## 1. Introduction
An **enum** (short for *enumeration*) in Java is a special data type used to define a **fixed set of constants**.  
Enums were introduced in **Java 5** as part of the `java.lang` package.

- Enums are **type-safe**.
- They can have **fields, methods, and constructors**.
- They are more powerful and structured than using `final static` constants.

---

## 2. Why Use Enum Instead of Constants?
Without `enum`:
```java
public class DayExample {
    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
}
❌ Not type-safe — Any integer can be assigned.
❌ Constants are not grouped under one type.

With enum:

java
Copy
Edit
enum Day { MONDAY, TUESDAY }
✅ Type-safe — Only valid enum constants can be assigned.
✅ Grouped logically in one type.
✅ Can have methods, fields, and constructors.

3. Syntax
java
Copy
Edit
enum EnumName {
    CONSTANT1, CONSTANT2, CONSTANT3;
}
4. Basic Enum Example
java
Copy
Edit
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumExample {
    public static void main(String[] args) {
        Day today = Day.FRIDAY;

        switch (today) {
            case MONDAY:
                System.out.println("Start of the work week!");
                break;
            case FRIDAY:
                System.out.println("Almost weekend!");
                break;
            case SUNDAY:
                System.out.println("Relax, it's Sunday!");
                break;
            default:
                System.out.println("Midweek day!");
        }
    }
}
Output:

nginx
Copy
Edit
Almost weekend!
5. Enum with Fields and Methods
java
Copy
Edit
enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6);

    private final double mass;   // in kilograms
    private final double radius; // in meters

    // Constructor
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double getMass() { return mass; }
    public double getRadius() { return radius; }

    public double surfaceGravity() {
        final double G = 6.67300E-11;
        return G * mass / (radius * radius);
    }
}

public class EnumWithMethods {
    public static void main(String[] args) {
        for (Planet p : Planet.values()) {
            System.out.printf("%s: gravity = %f%n", p, p.surfaceGravity());
        }
    }
}
6. Useful Enum Methods
Method	Description
values()	Returns array of all enum constants.
valueOf(String name)	Returns enum constant with the given name.
ordinal()	Returns position of constant (0-based).

7. Diagram: Enum Concept
sql
Copy
Edit
Enum Day
+------------------+
| MONDAY           |
| TUESDAY          |
| WEDNESDAY        |
| THURSDAY         |
| FRIDAY           |
| SATURDAY         |
| SUNDAY           |
+------------------+
(Only these fixed values are valid for the Day type)

8. Iterating Over Enum
java
Copy
Edit
enum Direction { NORTH, EAST, SOUTH, WEST }

public class EnumIteration {
    public static void main(String[] args) {
        for (Direction dir : Direction.values()) {
            System.out.println(dir + " at index " + dir.ordinal());
        }
    }
}
Output:

perl
Copy
Edit
NORTH at index 0
EAST at index 1
SOUTH at index 2
WEST at index 3
9. Advantages of Enum
Type safety — Only valid constants allowed.

Readability — Constants grouped logically.

Maintainability — Easy to modify/add constants.

Extra features — Can have fields, methods, and constructors.

10. Interview Questions and Answers
Q1: What is an enum in Java?
Answer:
A special Java type used to define a fixed set of constants. It is type-safe and can have fields, methods, and constructors.

Q2: Why use enums instead of constants?
Answer:
Enums provide type safety, better readability, and can include methods and fields, unlike final static constants.

Q3: Can enums have constructors?
Answer:
Yes, but enum constructors are private by default and cannot be called directly.

Q4: Can enums implement interfaces?
Answer:
Yes, enums can implement interfaces but cannot extend classes (because they implicitly extend java.lang.Enum).

Q5: Can we use enums in a switch statement?
Answer:
Yes, enums can be used in switch statements to improve readability.

Q6: What methods are available in all enums?
Answer:
values(), ordinal(), and valueOf().

Q7: Can enums be compared using ==?
Answer:
Yes, because each enum constant is a singleton instance.

Q8: Can we override methods in enums?
Answer:
Yes, enums can override methods (including toString()).