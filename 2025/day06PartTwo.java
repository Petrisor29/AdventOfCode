import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CephalopodMathPartTwoClean {

    private static class Problem {
        int startIndex;
        String operator;
        List<String> rawColumns = new ArrayList<>();
        List<Long> numbers = new ArrayList<>();
    }

    private static long evaluateProblem(List<Long> numbers, String operator) {
        long result;

        if (operator.equals("+")) {
            result = 0;
            for (long num : numbers) {
                result += num;
            }
        } else {
            result = 1;
            for (long num : numbers) {
                result *= num;
            }
        }
        return result;
    }

    public static long solveCephalopodMath(String input) {
        String[] lines = input.split("\n");

        String operatorLine = lines[lines.length - 1];
        List<Problem> problems = new ArrayList<>();

        for (int i = 0; i < operatorLine.length(); i++) {
            char c = operatorLine.charAt(i);
            if (c == '+' || c == '*') {
                Problem p = new Problem();
                p.operator = String.valueOf(c);
                p.startIndex = i;
                problems.add(p);
            }
        }

        for (int pIndex = 0; pIndex < problems.size(); pIndex++) {
            Problem currentProblem = problems.get(pIndex);
            
            int endIndex;
            if (pIndex + 1 < problems.size()) {
                endIndex = problems.get(pIndex + 1).startIndex;
            } else {
                endIndex = lines[0].length();
            }

            for (int r = 0; r < lines.length - 1; r++) {
                String line = lines[r];

                int actualEnd = Math.min(endIndex, line.length());
                String subString = line.substring(currentProblem.startIndex, actualEnd);
                
                currentProblem.rawColumns.add(subString);
            }
            
            if (!currentProblem.rawColumns.isEmpty()) {
                int columnWidth = currentProblem.rawColumns.get(0).length();
                
                for (int c = 0; c < columnWidth; c++) {
                    StringBuilder numberBuilder = new StringBuilder();
                    
                    for (String row : currentProblem.rawColumns) {
                        if (c < row.length()) {
                            char digit = row.charAt(c);
                            if (Character.isDigit(digit)) {
                                numberBuilder.append(digit);
                            }
                        }
                    }
                    
                    if (numberBuilder.length() > 0) {
                        currentProblem.numbers.add(Long.parseLong(numberBuilder.toString()));
                    }
                }
            }
        }
        
        long grandTotal = 0;
        
        for (int i = problems.size() - 1; i >= 0; i--) {
            Problem problem = problems.get(i);
            
            long result = evaluateProblem(problem.numbers, problem.operator);
            grandTotal += result;
        }

        return grandTotal;
    }

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            inputBuilder.append(scanner.nextLine()).append("\n");
        }
        scanner.close();

        String input = inputBuilder.toString().trim();

        long grandTotal = solveCephalopodMath(input);

        System.out.println("Totalul este: " + grandTotal);
    
    }
}
