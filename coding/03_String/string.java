

public class string {
    public static void main(String[] args) {
        String a = "bhaskar";
        String b = "bhaskar";

        String c = new String("bhaskar");
        String d = new String("bhaskar");

        System.out.println(a==b);
        System.out.println(a.compareTo(b));

        System.out.println(c==d);
        System.out.println(c.compareTo(d));
    }
}
