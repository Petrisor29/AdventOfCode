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
        
        int diff = 0;
  
        for(int i = 0; i < listA.size(); i++){
          diff += Math.abs(listA.get(i) - listB.get(i));

        }
        
      System.out.println(diff);

    }
}
