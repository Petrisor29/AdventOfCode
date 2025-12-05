import java.util.*;

public class Main {
    public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      List<Interval> intervals = new ArrayList<>();
      
      while(sc.hasNextLine()){
        String line = sc.nextLine().trim();
        
        if(line.isEmpty()){
          break;
        }
        
        String[] parts = line.split("-");
        long start = Long.parseLong(parts[0]);
        long end = Long.parseLong(parts[1]);
        
        intervals.add(new Interval(start, end));
      }
      
      List<Long> nums = new ArrayList<>();
      int count = 0;
      
      while(sc.hasNextLine()){
        String line = sc.nextLine().trim();
        
        if(line.isEmpty()) continue;
        nums.add(Long.parseLong(line));

        }
        
       for(long x : nums){
        for(Interval in : intervals){
 
            if(in.contains(x)){
          count++;
          break;
            }
          }
        }
        
      System.out.println(count);
      
      
   
  }
}

class Interval{
  long start;
  long end;
  
  public Interval(long start, long end){
    this.start = start;
    this.end = end;
  }
  
  public boolean contains(long x){
    return(x >= start && x <= end);
  }
}

