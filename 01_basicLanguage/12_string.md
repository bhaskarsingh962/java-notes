String is a class in java

String name = "bhaskar";
data-tyope refrence = object;

## 1. What is a String in Java?
In Java, a String is a sequence of characters, like "hello", "bhaskar".

It is an object of the String class.

Strings are immutable in Java (once created, they cannot be changed).

## 🔸 2. Creating Strings in Java
✅ Two Ways:
👉 (A) Using String Literal:

String a = "bhaskar";
String b = "bhaskar";
🧠 Behind the scenes:

Both a and b refer to the same object in the String pool (in heap memory).

Java optimizes memory by using a String pool, so "bhaskar" is stored once.

👉 (B) Using new keyword:

String c = new String("bhaskar");
String d = new String("bhaskar");
🧠 Here:

c and d are different objects in heap memory.

Even though the value is same ("bhaskar"), they are not pointing to the same memory.

🔸 3. Comparing Strings
📌 Use .equals() to compare values

System.out.println(a.equals(c)); // true ✅ compares characters
❌ Don’t use == to compare values

System.out.println(a == c); // false ❌ compares memory reference
🔸 4. Why are Strings Immutable?
Once a String object is created, its value cannot be changed. For example:


String name = "bhaskar";
name.concat(" singh");
System.out.println(name); // still "bhaskar"
🔎 Reason: Any method like .concat() creates a new String, doesn’t change the original.

## 🔸 5. Useful String Methods
Method	What It Does	Example Output
length()	Gets the number of characters	"bhaskar".length() → 7
charAt(index)	Gets char at given index	"bhaskar".charAt(0) → 'b'
substring(2)	From index 2 to end	"bhaskar".substring(2) → "askar"
toUpperCase()	Converts to uppercase	"bhaskar".toUpperCase() → "BHASKAR"
equals(str)	Compares content	"a".equals("a") → true
==	Compares references (memory address)	"a" == "a" → true, but not always

🔸 6. Example with Diagram (Mentally Visualize):

String a = "bhaskar";
String b = "bhaskar";
String c = new String("bhaskar");
🧠 Memory Concept:

✅ String Pool:

Copy code
[ String Pool ]
"bhaskar"  <--- a, b
🟨 Heap Memory:
csharp

[Heap]
new String("bhaskar") --> c
🔸 7. Best Practices
✅ Always use .equals() to compare string values
✅ Use string literals where possible (memory efficient)
✅ Use StringBuilder if you're doing many changes (like in loops)






Awesome, Bhaskar! Let's now do this in 3 parts to fully master Strings in Java like a pro:

✅ PART 1: Visual Diagram — String Memory Behavior
Here’s a markdown-style diagram  visualize how String works:


String a = "bhaskar";
String b = "bhaskar";
String c = new String("bhaskar");
String d = new String("bhaskar");

Memory Representation:
----------------------

     [ String Pool ]           [ Heap Memory ]
   ------------------        -----------------------
   | "bhaskar"       | <---- | new String("bhaskar") | <- c
   |     ↑          ↑ |       | new String("bhaskar") | <- d
   |     |          | |
   |     a          b |
   ------------------

   a == b         --> true   (same reference in pool)
   a == c         --> false  (different objects)
   a.equals(c)    --> true   (same content)

## why it happence 
## 🔹 What is String Pool?

In Java, String is a special class because it is immutable.

To optimize memory, Java maintains a special memory area called the String Constant Pool (SCP) inside the heap.

Whenever you create a string literal like:

String str1 = "bhaskar";


Java checks if that string already exists in the pool:

✅ If it exists → the same object reference is reused.

❌ If it does not exist → a new object is created in the pool.   


## importent 
## 🔹 Interview Note (Short Answer):

String Pool is a memory optimization technique where Java stores string literals.

"bhaskar" is stored once in the pool, and reused when needed.

str1 == str2 → true for literals (because they share same object).

With new String(), == → false (different objects), but .equals() → true.

## 🔹 Important Interview Point

All string literals (inside double quotes) are stored in the String Pool, which is inside the Heap.

If you use 
## new String("aman"), then:

A new object is created inside Heap (outside the pool).

But "aman" (the literal) will still go to the pool.

Example:




String str = "Hello";
str = str + 'A';  // This creates a new string "HelloA" and assigns it to str
"Hello" is stored in memory.

'A' is added.

A new String "HelloA" is created.

The reference str now points to "HelloA", and the old "Hello" is still in memory (might be garbage collected later).

🧠 Think of it like:
You're not changing the original paper ("Hello"), you're copying it to a new paper, adding "A", and keeping the new version.

📌 Why is this done?
Thread safety (no accidental change by multiple threads)

Memory efficiency (uses String pool)

Security and reliability (commonly used in passwords, URLs, etc.)



## If you need a mutable alternative:
Use StringBuilder or StringBuffer for frequent modifications:

StringBuilder sb = new StringBuilder("Hello");
sb.append('A'); // Modifies original object
System.out.println(sb); // HelloA



System.out.println('a' + 'b');
👉 What's happening?
'a' and 'b' are char literals.

In Java, char is a primitive type (not a String).

When you use + with two char values, Java adds their Unicode (ASCII) values.

🔢 Unicode Values:
'a' = 97

'b' = 98

✅ Result:
java
Copy code
97 + 98 = 195
➡ Output:
195

✅ Code 2:

System.out.println("a" + "b");
👉 What's happening?
"a" and "b" are String literals.

The + operator concatenates strings (i.e., joins them).



"a" + "b" = "ab"
➡ Output:

ab
✅ Code 3:

System.out.println('a' + 3);
👉 What's happening?
'a' is a char (97)

3 is an int

Adding a char and an int performs numeric addition

✅ Result:

97 + 3 = 100
➡ Output:

100
✅ Summary Table:
Code	Type of Operation	Output
'a' + 'b'	char + char → int	195
"a" + "b"	String concat	ab
'a' + 3	char + int → int	100

 

 System.out.println("a" + 1);

✅ 1. System.out.println("a" + 1);
🔍 Step-by-step:
"a" is a String

1 is an int

When you use + between a String and another type (int, char, Object, etc.), Java automatically converts the non-String value into a String using .toString() or direct conversion.

So:

java
Copy code
"a" + 1 → becomes → "a1"
✅ Output:

a1
✅ 2. System.out.println("bhaskar" + new ArrayList<>());
🔍 Step-by-step:
"bhaskar" is a String

new ArrayList<>() creates an empty ArrayList object.

When + is used between a String and an Object, the Object’s toString() method is called automatically.

The default toString() of an empty ArrayList returns: "[]"

So:

java
Copy code
"bhaskar" + new ArrayList<>() → "bhaskar" + "[]" → "bhaskar[]"
✅ Output:
css

bhaskar[]
🧠 Key Concept:
Whenever a String is added to anything using +, Java:

Converts the other thing to a string (via .toString())

Then performs String concatenation

