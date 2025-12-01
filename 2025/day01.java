import java.util.*;

public class Main{
  
   static int update(int x, int delta) {
        x = (x + delta) % 100;
        if (x < 0) x += 100;
        return x;
    }
  
  public static void main(String[] args){
    
    int password = 0;
    int start = 50;
  
Scanner sc = new Scanner(System.in);

while (sc.hasNextLine()) {
    String s = sc.nextLine().trim();
    if (s.isEmpty()) break;

    
    char letter = s.charAt(0);
    String numberPart = s.substring(1);
    int number = Integer.parseInt(numberPart);
    
    if(letter == 'L'){
      start = update(start, -number);
      
    }else if(letter == 'R'){
      start = update(start, +number);
    }
    
    if(start == 0) password++;

}
 
 System.out.println(password);



}
}
