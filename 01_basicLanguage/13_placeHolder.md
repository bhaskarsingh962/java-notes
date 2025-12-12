✅ Where are placeholders used?
Most commonly, in:
String.format()
System.out.printf()
Logging frameworks (%s, %d, etc.)
SQL queries (like PreparedStatement with ?)
✅ Example: Using String.format()
String name = "Bhaskar";
int age = 22;
String result = String.format("My name is %s and I am %d years old.", name, age);
System.out.println(result);

My name is Bhaskar and I am 22 years old.
✅ Common Placeholders:
Placeholder	Meaning
%s	String
%d	Integer (decimal)
%f	Floating-point number
%c	Character
%n	New line (platform-independent)

✅ Why are placeholders used?
✅ Cleaner code — instead of using string concatenation (+)

✅ Dynamic value insertion — you can plug in values at runtime

✅ Better formatting — especially with numbers and alignment

✅ Localization support — useful for formatting in different languages

✅ Prepared SQL statements — prevent SQL injection

✅ Bonus: System.out.printf()

System.out.printf("Hello %s, your score is %d%n", "Bhaskar", 95);
Output:
csharp
Copy code
Hello Bhaskar, your score is 95
