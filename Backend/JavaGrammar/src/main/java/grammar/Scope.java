package grammar;

public class Scope {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("#1 : " + a);        // 10

        {
            int b = 20;
            System.out.println("#2 : " + a);    // 10
            System.out.println("#3 : " + b);    // 20
        }

        {
            int b = 30;
            System.out.println("#4 : " + a);    // 10
            System.out.println("#5 : " + b);    // 30
        }

        System.out.println("#6 : " + a);        // 10
//      System.out.println("#7 : " + b);		// b cannot be resolved to a variable
    }

}

