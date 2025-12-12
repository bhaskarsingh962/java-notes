🧠 Inner Classes in Java — Complete Notes with Examples

Inner classes are classes defined inside another class.
They are mainly used for better encapsulation, logical grouping, and event handling (UI, Threads, etc.).

There are 4 types of inner classes:
Non-static (Member) Inner Class
Static Nested Class
Local Inner Class
Anonymous Inner Class
🧩 1️⃣ Non-static (Member) Inner Class
➡️ Defined inside a class, outside any method, without static keyword.
🧠 Realistic Example
Let’s imagine we are building an app that tracks User and their Address.

class User {
    private String name;
    private int age;

    // Inner class - logically belongs to User
    class Address {
        private String city;
        private String country;

        public Address(String city, String country) {
            this.city = city;
            this.country = country;
        }

        public void showAddress() {
            System.out.println(name + " lives in " + city + ", " + country);
        }
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("Bhaskar", 22);
        User.Address addr = user.new Address("Jamshedpur", "India"); // ✅ Requires outer object
        addr.showAddress();
    }
}

📘 Output:
Bhaskar lives in Jamshedpur, India

📌 Key Points:
Feature	Description
Belongs to	Instance of outer class
Access outer class variables	✅ Yes (even private)
Requires outer class object	✅ Yes
Declared as static	❌ Not allowed
Common use	When inner class logically depends on outer class instance


🧩 2️⃣ Static Nested Class

➡️ Declared inside another class, but with static keyword.

Used when inner class does not depend on outer class instance.

🧠 Realistic Example

In an E-commerce system, we can have a Product class with a static nested class for Utility operations.

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    static class Utils {
        public static double applyDiscount(double price, double percent) {
            return price - (price * percent / 100);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        double discounted = Product.Utils.applyDiscount(1000, 10); // ✅ No outer object required
        System.out.println("Discounted Price: " + discounted);
    }
}

📘 Output:
Discounted Price: 900.0

📌 Key Points:
Feature	Description
Belongs to	Class (not instance)
Access outer class variables	❌ Only static ones
Requires outer class object	❌ No
Can be static	✅ Yes
Common use	Helper / utility classes within outer class
🧩 3️⃣ Local Inner Class

➡️ Declared inside a method of another class.
Used when class is needed only within that method.

🧠 Realistic Example
In a banking system, inside a method for transaction, we might have a local class for generating temporary receipt.
class Bank {
    public void processTransaction(int amount) {
        class Receipt { // Local inner class
            void print() {
                System.out.println("Transaction of ₹" + amount + " successful!");
            }
        }

        Receipt receipt = new Receipt();
        receipt.print();
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.processTransaction(5000);
    }
}

📘 Output:
Transaction of ₹5000 successful!

📌 Key Points:
Feature	Description
Scope	Only within the method
Access outer class variables	✅ Yes
Access local variables	✅ Only if they are effectively final
Use case	Short-lived helper classes (like receipts, validations)
🧩 4️⃣ Anonymous Inner Class

➡️ Class without a name, declared and instantiated at the same time.
Commonly used for event handling, threads, and interfaces.

🧠 Realistic Example

In a button click event or Runnable thread, you can use anonymous inner class.

interface ButtonClickListener {
    void onClick();
}

public class Main {
    public static void main(String[] args) {
        // Anonymous inner class implementing interface
        ButtonClickListener listener = new ButtonClickListener() {
            @Override
            public void onClick() {
                System.out.println("Button clicked! Submitting form...");
            }
        };

        listener.onClick();
    }
}


🧾 Output:

Button clicked! Submitting form...


Or with a thread example:

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running in a new thread...");
            }
        });
        t.start();
    }
}

📌 Key Points:
Feature	Description
Has name	❌ No
Can extend class / implement interface	✅ Yes
Used for	One-time use implementation
Access outer variables	✅ Yes (if effectively final)
🔥 Summary Table
Type	Static	Access Outer Instance?	Where Defined	Use Case	Syntax
Member Inner	❌	✅ Yes	Inside class	When inner depends on outer	Outer.Inner in = outer.new Inner();
Static Nested	✅	❌ Only static members	Inside class	Utility/helper	Outer.Inner in = new Outer.Inner();
Local Inner	❌	✅ Yes	Inside method	Temporary helper	Defined inside method
Anonymous Inner	❌	✅ Yes	Inline (inside method)	One-time use	new InterfaceName() { ... };
🧩 Real-Life Usage Summary
Real Example	Inner Class Type	Why Used
Map.Entry<K,V> in Java Collections	Static Nested	Helper class inside Map
Event listener in GUI (ActionListener)	Anonymous Inner	One-time button handling
Address class inside User	Member Inner	Logically belongs to User
Temporary Receipt generator	Local Inner	Used only inside a method