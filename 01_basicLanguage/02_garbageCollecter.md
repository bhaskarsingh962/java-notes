## What is Garbage Collector in Java?
Definition:
The Garbage Collector (GC) in Java is a part of the Java Virtual Machine (JVM) that automatically removes unused or unreferenced objects from memory to free up space and prevent memory leaks.
## 🧠 Why is it Important?
Java manages memory automatically, so developers don’t have to manually free memory like in C/C++ (free() or delete).
This reduces bugs like:
Memory leaks
Dangling pointers
Crashes due to freeing memory wrongly

## 💡 How Does It Work?
Object Creation:
Objects are stored in heap memory.
Reference Checking:
If an object has no active references, it becomes eligible for garbage collection.
GC Runs:
JVM runs the Garbage Collector, which deletes those unreferenced objects and reclaims memory.
🧪 Java Example:
public class Demo {
    public static void main(String[] args) {
        Demo obj1 = new Demo();
        Demo obj2 = new Demo();

        obj1 = null;   // Eligible for GC
        obj2 = null;   // Also eligible

        // Suggest GC to run (not guaranteed)
        System.gc();
    }

    @Override
    protected void finalize() {
        System.out.println("Object is garbage collected!");
    }
}
📌 Output (may vary):
vbnet
Copy code
Object is garbage collected!
Object is garbage collected!
🧠 System.gc() vs Runtime.getRuntime().gc()
Both request the JVM to run GC, but it’s not guaranteed to execute immediately.
JVM decides when it's optimal to run GC.


## Q: How does GC know which objects to collect?
A: It uses techniques like:
Reference counting
Reachability analysis from GC roots
Generational GC (Young, Old generation)

## Q: What are types of Garbage Collectors in JVM?
Serial GC – simple, for small applications
Parallel GC – uses multiple threads
CMS (Concurrent Mark-Sweep) – for low-pause apps
G1 (Garbage First) – default in modern Java, balances throughput and pause time

## Q: Can you force garbage collection in Java?
A: No. You can only request it via System.gc(), but the JVM may ignore it.

## ✅ When does Garbage Collector run?
When JVM decides memory is low
If heap memory is filling up, JVM triggers GC to reclaim unused memory.
When objects become unreachable
Example:
String s = new String("Hello");
s = null;  // "Hello" object becomes unreachable → eligible for GC


When you call System.gc() or Runtime.getRuntime().gc()
This is only a request, not a guarantee. JVM may ignore it.
During idle time of CPU / JVM optimization
If the JVM notices the system is idle, it may run GC to clean up memory.