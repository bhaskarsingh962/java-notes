# Vector in Java

## 1. Introduction
A **Vector** in Java is a part of the `java.util` package and represents a **dynamic array** that can grow or shrink in size as needed.  
It is **thread-safe** (synchronized) and can store duplicate elements.

---

## 2. Key Features of Vector
- **Resizable**: Automatically increases capacity when needed.
- **Ordered**: Maintains insertion order.
- **Allows duplicates**: Same elements can be added multiple times.
- **Thread-safe**: Methods are synchronized (safe for multi-threaded use but slower than `ArrayList`).
- Can store **heterogeneous objects** (if not using generics).

---

## 3. Syntax
```java
Vector<Type> vectorName = new Vector<>();



10. Interview Questions and Answers
Q1: What is a Vector in Java?
Answer:
Vector is a legacy class in java.util that implements a dynamic array with synchronized methods, allowing thread-safe operations.

Q2: How is Vector different from ArrayList?
Answer:
Vector is synchronized (thread-safe) but slower; ArrayList is not synchronized (faster). Vector doubles capacity when full; ArrayList grows by 50%.

Q3: When should you prefer Vector over ArrayList?
Answer:
When multiple threads modify the collection simultaneously and you need thread-safety without manually synchronizing.

Q4: Is Vector part of the Collection Framework?
Answer:
Yes. Although Vector existed before the Collection Framework, it was retrofitted to implement the List interface in Java 2.

Q5: Can Vector store different types of objects?
Answer:
Yes, if you don’t use generics. But with generics, it can store only one type for type safety.

Q6: Why is Vector considered a legacy class?
Answer:
Because it was introduced in Java 1.0 before the Collection Framework and has been mostly replaced by newer classes like ArrayList.

Q7: How does Vector increase its capacity?
Answer:
When full, it doubles its current capacity by default.

Q8: Is Vector fail-fast?
Answer:
Yes. Iterators over a Vector are fail-fast and will throw ConcurrentModificationException if modified during iteration by another thread.

Tip: In modern applications, prefer ArrayList for single-threaded use and