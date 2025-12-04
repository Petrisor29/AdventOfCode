import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<char[]> inputRows = new ArrayList<>();

        // Citim toate liniile din input
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

        // 8 direcții (inclusiv diagonale)
        int[] deltaRow = { -1, -1, -1,  0, 0, 1, 1, 1 };
        int[] deltaCol = { -1,  0,  1, -1, 1, -1, 0, 1 };

        int totalRemovedRolls = 0;

        // Repetăm până când într-o iterație nu mai eliminăm nimic
        while (true) {
            // marcăm ce celule vor fi eliminate în această rundă
            boolean[][] toRemove = new boolean[totalRows][totalCols];
            int removedThisRound = 0;

            // 1. găsim toate celulele '@' valide în acest pas
            for (int row = 0; row < totalRows; row++) {
                for (int col = 0; col < totalCols; col++) {
                    if (grid[row][col] != '@') continue;

                    int neighborCount = 0;

                    for (int d = 0; d < 8; d++) {
                        int neighborRow = row + deltaRow[d];
                        int neighborCol = col + deltaCol[d];

                        if (neighborRow >= 0 && neighborRow < totalRows &&
                            neighborCol >= 0 && neighborCol < totalCols) {

                            if (grid[neighborRow][neighborCol] == '@') {
                                neighborCount++;
                            }
                        }
                    }

                    // valid = mai puțin de 4 vecini '@'
                    if (neighborCount < 4) {
                        toRemove[row][col] = true;
                        removedThisRound++;
                    }
                }
            }

            // dacă în runda asta nu mai eliminăm nimic, ne oprim
            if (removedThisRound == 0) {
                break;
            }

            // 2. transformăm toate celulele marcate în '.'
            for (int row = 0; row < totalRows; row++) {
                for (int col = 0; col < totalCols; col++) {
                    if (toRemove[row][col]) {
                        grid[row][col] = '.';
                    }
                }
            }

            totalRemovedRolls += removedThisRound;
        }

        // Răspuns: câte rulouri au putut fi accesate/eliminate în total
        System.out.println(totalRemovedRolls);

    }
}
