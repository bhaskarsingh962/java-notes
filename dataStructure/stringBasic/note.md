
# 🧵 String

Immutable: once created, it cannot be changed.
Every modification creates a new String object.
Example:
String s = "Hello";
s = s + " World";  // new object created!
So if you modify strings repeatedly in loops, it wastes memory and time.

# ⚙️ StringBuffer

Mutable: can be changed in place.
Thread-safe: all its methods are synchronized, meaning only one thread can modify it at a time.
Slightly slower due to synchronization overhead.
Example:
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");  // modifies the same object
Use it when multiple threads are updating the same string data.


“If multiple threads want to change a StringBuffer, that will change one by one.”
Yes — that’s exactly how StringBuffer works.
Because its methods are synchronized — meaning only one thread can access it at a time for modification.
So:

Thread A enters append()
Thread B must wait until A finishes
Then B can modify it
This prevents data corruption, but it’s slower because of waiting.

# 2️⃣ Why this matters
Imagine two threads trying to modify the same text:

Using StringBuilder (NOT synchronized)
StringBuilder sb = new StringBuilder("Start ");

Thread t1 = new Thread(() -> {
    for (int i = 0; i < 5; i++) sb.append("A ");
});

Thread t2 = new Thread(() -> {
    for (int i = 0; i < 5; i++) sb.append("B ");
});

t1.start();
t2.start();
t1.join();
t2.join();

System.out.println(sb);
⚠️ Output may be jumbled like:
Start A B A A B B A B A
— because both threads modify at the same time, causing race conditions.

# ✅ Using StringBuffer (synchronized)
StringBuffer sb = new StringBuffer("Start ");

Thread t1 = new Thread(() -> {
    for (int i = 0; i < 5; i++) sb.append("A ");
});

Thread t2 = new Thread(() -> {
    for (int i = 0; i < 5; i++) sb.append("B ");
});

t1.start();
t2.start();
t1.join();
t2.join();
System.out.println(sb);
⚙️ Output will always be consistent, like:

Start A A A A A B B B B B
— because synchronization ensures only one thread modifies at a time.



# ⚡ StringBuilder

Mutable like StringBuffer.
Not synchronized → not thread-safe.
Faster than StringBuffer because it doesn’t use synchronization.
Example:
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
Use it when only one thread (or the current method) is modifying the string — this is the most common case.

🧮 3️⃣ Quick Performance Example
public class Test {
    public static void main(String[] args) {
        long start, end;

        start = System.nanoTime();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb1.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder: " + (end - start));

        start = System.nanoTime();
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            sb2.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer: " + (end - start));
    }
}


⚙️ Output:
StringBuilder will generally be faster than StringBuffer.


# ✅ 4️⃣ When to Use What
Scenario	                                                  Use
Constant string values (never change)	                    String
Many string modifications in single-threaded program	    StringBuilder
Many string modifications in multi-threaded environment	    StringBuffer
💡 5️⃣ Key Tip

In modern Java code:

Prefer StringBuilder unless you’re in a synchronized (multi-threaded) context.

Would you like me to show a real-world example (like logging or string concatenation in threads) comparing StringBuilder and StringBuffer to make it even clearer?


# StringBuilder = use when only one thread touches it (faster).

# StringBuffer = use when multiple threads modify it (safe, but slower).