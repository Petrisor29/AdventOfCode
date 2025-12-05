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
  
  public static long maxJolt12(String str){
    int n = str.length();
    int toRemove = n - 12;
    
    Stack<Character> stack = new Stack<>();
    
    for(int i = 0; i < n; i++){
      char c = str.charAt(i);
      
      while(!stack.isEmpty() && toRemove > 0 && stack.peek() < c){
        stack.pop();
        toRemove--;
      }
      stack.push(c);
    }
    
    while(toRemove > 0){
      stack.pop();
      toRemove--;
    }
    
    StringBuilder sb = new StringBuilder();
    for(char c : stack) sb.append(c);
    
    String result = sb.substring(0, 12);
    
    return Long.parseLong(result);
  }
  
    public static void main(String[] args) {
      
      Scanner scanner = new Scanner(System.in);
          
      long sum = 0;
      
      while(scanner.hasNextLine()){
        String line = scanner.nextLine();
        
        sum += maxJolt12(line);
       
      }
     
      System.out.println(sum);
      
  }
}
