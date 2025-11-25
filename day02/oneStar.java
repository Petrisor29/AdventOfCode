import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int count = 0;

while (sc.hasNextLine()) {
    String line = sc.nextLine().trim();

    // daca linia e goala, o ignora sau întrerupe
    if (line.isEmpty()) continue;

    // imparte numerele după spatiu
    String[] parts = line.split("\\s+");

    // transforma in numere
    int[] nums = new int[parts.length];
    for (int i = 0; i < parts.length; i++) {
        nums[i] = Integer.parseInt(parts[i]);
        }

        
      if((isIncreasing(nums) || isDecreasing(nums)) && isLevel(nums)){
        count++;
      }
}
System.out.println(count);
  }
  
  
  
  static boolean isIncreasing(int[] nums){
    for(int i = 0; i < nums.length - 1; i++){
      if(nums[i] >= nums[i + 1]){
        return false;
      }
    }
    return true;
  }
  
  
  static boolean isDecreasing(int[] nums){
    for(int i = 0; i < nums.length - 1; i++){
      if(nums[i] <= nums[i + 1]){
        return false;
      }
    }
    return true;
  }
  
  
  static boolean isLevel(int[] nums){
    for(int i = 0; i < nums.length - 1; i++){
      int diff = Math.abs(nums[i] - nums[i + 1]);
      if(diff < 1 || diff > 3){
        return false;
      }
    }
    return true;
  }
  
}
