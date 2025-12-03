import java.util.*;

public class Main {
  
  public static int maxJolt(String str){
    int max = 0;
    for(int i = 0; i < str.length(); i++){
      for(int j = i + 1; j < str.length(); j++){
        int d1 = str.charAt(i) - '0';
        int d2 = str.charAt(j) - '0';
        int num = d1 * 10 + d2;
        if(num > max) max = num;
      }
    }
    
    return max;
  }
  
    public static void main(String[] args) {
      
      Scanner scanner = new Scanner(System.in);
          
      int sum = 0;
      
      while(scanner.hasNextLine()){
        String line = scanner.nextLine();
        
        sum += maxJolt(line);
       
      }
     
      System.out.println(sum);
      
  }
}
