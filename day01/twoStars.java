import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            listA.add(Integer.parseInt(parts[0]));
            listB.add(Integer.parseInt(parts[1]));
        }
        Collections.sort(listA);
        Collections.sort(listB);
        
       Map<Integer, Integer> freqB = new HashMap<>();
       
       for(int n : listB){
         freqB.put(n, freqB.getOrDefault(n, 0) + 1);
       }
       
       int sum = 0;
       
       for(int a : listA){
         int count = freqB.getOrDefault(a, 0);
         sum += a * count;
       }
       
       System.out.println(sum);
   
    }
}
