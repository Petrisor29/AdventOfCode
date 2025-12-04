import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<char[]> inputRows = new ArrayList<>();

   
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            if (currentLine.isEmpty()) continue;  
            inputRows.add(currentLine.toCharArray());
        }

        int totalRows = inputRows.size();
        int totalCols = inputRows.get(0).length;

        char[][] grid = new char[totalRows][totalCols];

        for (int row = 0; row < totalRows; row++) {
            grid[row] = inputRows.get(row);
        }

        // 8 direcții: diagonale + sus/jos/stânga/dreapta
        int[] deltaRow = { -1, -1, -1,  0, 0, 1, 1, 1 };
        int[] deltaCol = { -1,  0,  1, -1, 1, -1, 0, 1 };

        int accessibleRolls = 0;  // răspunsul cerut

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {

                // Ne interesează DOAR rulourile de hârtie
                if (grid[row][col] != '@') continue;

                int neighborRolls = 0;

                // Numărăm vecinii '@'
                for (int d = 0; d < 8; d++) {
                    int neighborRow = row + deltaRow[d];
                    int neighborCol = col + deltaCol[d];

                    if (neighborRow >= 0 && neighborRow < totalRows &&
                        neighborCol >= 0 && neighborCol < totalCols) {

                        if (grid[neighborRow][neighborCol] == '@') {
                            neighborRolls++;
                        }
                    }
                }

                // Forklift-ul poate accesa ruloul dacă are MAI PUȚIN DE 4 vecini '@'
                if (neighborRolls < 4) {
                    accessibleRolls++;
                }
            }
        }
        
        

        System.out.println(accessibleRolls);
    }
}
