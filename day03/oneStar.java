import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // citeste tot input-ul
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }
        String text = sb.toString();

        // regex strict: mul(numar,numar)
        String pattern = "mul\\((\\d+),(\\d+)\\)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);

        int total = 0;

        while (m.find()) {
            int a = Integer.parseInt(m.group(1)); // primul nr
            int b = Integer.parseInt(m.group(2)); // al doilea nr

            int prod = a * b;
            total += prod;

        }

        System.out.println("Suma tuturor produselor = " + total);
    }
}
