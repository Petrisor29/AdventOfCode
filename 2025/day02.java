import java.util.*;

public class Main {
  
  static boolean isInvalid(long n){
    String s = Long.toString(n);
    int len = s.length();
    
    if(len % 2 != 0)
    return false;
    
    int mid = len / 2;
    String first = s.substring(0, mid);
    String second = s.substring(mid);
    
    return first.equals(second);
  }
  
  
    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
          long sum = 0;

        String[] parts = line.split(",");

        List<long[]> intervals = new ArrayList<>();

        for (String part : parts) {
            part = part.trim();
            String[] numbers = part.split("-");

            if (numbers.length != 2) {
                System.out.println("Format invalid: " + part);
                continue;
            }

            long start = Long.parseLong(numbers[0].trim());
            long end = Long.parseLong(numbers[1].trim());
            
            for(long i = start; i <= end; i++){
          if(isInvalid(i)) sum += i;
        }
              intervals.add(new long[]{start, end});
        }
        
      
        
        
            
        

        System.out.println("Intervale citite:");
        for (long[] interval : intervals) {
            System.out.println(interval[0] + "-" + interval[1]);
        }
        
        System.out.println("Suma = " + sum);
    }
}

