import java.util.*;

public class Main {

    static class Interval {
        long start;
        long end;

        Interval(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + "-" + end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Interval> intervals = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;  

            String[] parts = line.split("-");
            long start = Long.parseLong(parts[0].trim());
            long end = Long.parseLong(parts[1].trim());

            intervals.add(new Interval(start, end));
        }

        intervals.sort((a, b) -> Long.compare(a.start, b.start));

        List<Interval> merged = new ArrayList<>();
        Interval current = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);

            if (next.start <= current.end) {
                current.end = Math.max(current.end, next.end);
            } else {
                merged.add(current);
                current = next;
            }
        }
        merged.add(current);

        long totalFresh = 0;
        for (Interval in : merged) {
            totalFresh += (in.end - in.start + 1);  
        }

        System.out.println(totalFresh); 
    }
}
