## 1. What is an Exception?

Exception = Runtime error that disrupts the normal flow of a program.

✅ Error → something serious (can’t be recovered) → e.g., OutOfMemoryError
✅ Exception → can be handled using try-catch to prevent program crash.

## ⚡ 2. When Exception Occurs

An exception occurs when something unexpected happens at runtime, e.g.:

int a = 10 / 0;  // ArithmeticException
int[] arr = new int[3];
System.out.println(arr[5]);  // ArrayIndexOutOfBoundsException
String s = null;
System.out.println(s.length());  // NullPointerException

🧠 3. Types of Exceptions (Hierarchy)
Throwable
 ├── Error               (Serious issues, not handled)
 └── Exception
      ├── Checked Exception (compile-time)
      └── Unchecked Exception (runtime)

# ✅ Example Classes:
Type	             Examples	                                            Checked at
Checked	IOException, SQLException, FileNotFoundException	Compile-time
Unchecked	ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException	Runtime

# 📘 4. Difference: Checked vs Unchecked Exceptions
Feature	                   Checked	                                         Unchecked
Checked by compiler	        ✅ Yes	                                     ❌ No
Handling required	 Must handle with try-catch or throws	               Optional
Examples	IOException, SQLException	ArithmeticException, NullPointerException
Example:
// Checked Exception
try {
    FileReader fr = new FileReader("abc.txt");
} catch (IOException e) {
    e.printStackTrace();
}

// Unchecked Exception
int x = 10 / 0; // No compiler error, but runtime crash

## why unckecked exception handling is optional
Represent programmer mistakes or logical errors.
Example: divide by zero, null pointer, index out of range.
int a = 10 / 0;  // ArithmeticException (unchecked)

💡 These are not predictable from outside input —
they’re bugs in your code logic, not external environment.
So, compiler doesn’t force you to handle them.
Because you’re expected to fix the code, not “handle” the bug.



# 🎯 5. Handling Exceptions
🔹 Using try-catch
try {
    int a = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero!");
}

# 🔹 Multiple catch blocks
try {
    int[] arr = new int[3];
    arr[5] = 10;
} catch (ArithmeticException e) {
    System.out.println("Arithmetic error");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Index out of range");
} catch (Exception e) {
    System.out.println("Generic exception");
}


# 💡 Order matters: more specific → more general (else compile-time error)

# 🔹 Using finally
try {
    int a = 10 / 0;
} catch (Exception e) {
    System.out.println("Handled: " + e);
} finally {
    System.out.println("Finally block always runs");
}


# 💡 finally always executes — even if exception occurs or return executes.

# ⚙️ 6. throw vs throws
Keyword	Use	Example
throw	Used to throw an exception manually	throw new ArithmeticException("Div by 0")
throws	Used in method signature to declare exception	void readFile() throws IOException
Example:
void checkAge(int age) throws Exception {
    if(age < 18)
        throw new Exception("Not eligible");
    else
        System.out.println("Eligible");
}

public static void main(String[] args) {
    try {
        new main().checkAge(15);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

# 🔧 7. Custom Exception (User-defined)
Example:
class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}

# public class Main {
    static void validate(int age) throws InvalidAgeException {
        if (age < 18)
            throw new InvalidAgeException("Not eligible for vote");
        else
            System.out.println("Welcome to vote");
    }

    public static void main(String[] args) {
        try {
            validate(15);
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e);
        }
    }
}


💡 Used when you need domain-specific exceptions (e.g., InsufficientBalanceException).

# 🪜 8. Exception Hierarchy in Java
Object
 └── Throwable
      ├── Error
      │    ├── StackOverflowError
      │    ├── OutOfMemoryError
      │    └── VirtualMachineError
      └── Exception
           ├── RuntimeException
           │    ├── ArithmeticException
           │    ├── NullPointerException
           │    └── ArrayIndexOutOfBoundsException
           └── IOException

# 🧩 9. Stack Trace

When exception occurs, Java prints a stack trace = list of method calls that led to exception.

Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Demo.method2(Demo.java:5)
    at Demo.method1(Demo.java:9)
    at Demo.main(Demo.java:13)


This helps debug where the problem started.

# 🧰 10. toString() and getMessage()
try {
    int a = 10 / 0;
} catch (Exception e) {
    System.out.println(e.toString());     // java.lang.ArithmeticException: / by zero
    System.out.println(e.getMessage());   // / by zero
    e.printStackTrace();                  // full stack trace
}

# ⚡ 11. Best Practices for Interview

✅ Always handle specific exceptions first, then generic.
✅ Don’t catch exceptions you can’t handle.
✅ Use custom exceptions for business logic.
✅ Always clean up resources in finally or use try-with-resources.
✅ Don’t ignore exceptions silently (empty catch blocks).

# 💬 12. Common Interview Questions
Question	Key Point
What is difference between Error and Exception?	Error → serious system issue; Exception → recoverable
What’s difference between throw and throws?	throw = throw object; throws = declare
Why finally block is used?	To clean up resources
Can finally block be skipped?	Yes, only with System.exit(0) or JVM crash
What’s difference between checked and unchecked exceptions?	Checked: compile-time, must handle; Unchecked: runtime
Can we rethrow an exception?	Yes, using throw again in catch
Can we have multiple catch blocks?	Yes, from specific → general
⚙️ 13. Try-with-Resources (Advanced, Important)

## this is impotent 

Used for auto-closing resources like File, DB, etc.

try (FileReader fr = new FileReader("test.txt")) {
    // use file
} catch (IOException e) {
    e.printStackTrace();
}


# 💡 Java automatically calls close() on fr.

🧾 Summary Mind Map
Exception Handling
 ├── try / catch / finally
 ├── throw / throws
 ├── Checked vs Unchecked
 ├── Custom Exception
 ├── Multiple catch
 ├── Stack Trace
 ├── Try-with-resources
 └── Best Practices



## complete code
package oops.exceptionHandling;

import java.io.*;

// ✅ 1. Custom Exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class ExceptionDemo {

    // ✅ 2. Checked Exception (throws declaration)
    static void readFile() throws IOException {
        FileReader fr = new FileReader("abc.txt");  // Checked Exception
        System.out.println("File opened successfully");
        fr.close();
    }

    // ✅ 3. Unchecked Exception (no need to handle)
    static void divide(int a, int b) {
        int result = a / b; // may throw ArithmeticException
        System.out.println("Result = " + result);
    }

    // ✅ 4. Custom Exception + throw
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Not eligible to vote!");
        } else {
            System.out.println("Eligible to vote!");
        }
    }

    public static void main(String[] args) {

        // ✅ 5. Multiple catch + finally block
        try {
            divide(10, 0);  // Unchecked
            readFile();     // Checked
            validateAge(15); // Custom

        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());

        } catch (FileNotFoundException e) {
            System.out.println("Caught Checked Exception: File not found");

        } catch (InvalidAgeException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Caught General Exception: " + e.toString());
            e.printStackTrace(); // ✅ stack trace

        } finally {
            System.out.println("Finally block always executes (cleanup here)");
        }

        System.out.println("Program ended gracefully");
    }
}





# Checked exception - extends Exception
IOException, 
SQLException, 
InvalidAgeException - this is also a checked exception

# uncehcked exception - extends RuntimeException
ArithmeticException, 
NullPointerException, ArrayIndexOutOfBoundsException
