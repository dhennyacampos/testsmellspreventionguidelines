import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "operations.txt";
        String outputFileName = "results.txt";

        IOHandler io = new IOHandler();
        MathOperations math = new MathOperations();

        try {
            List<String> operations = io.readOperationsFromFile(inputFileName);
            List<String> results = new ArrayList<>();

            for (String operation : operations) {
                try {
                    double result = math.evaluateOperation(operation);
                    results.add(operation + " = " + result);
                } catch (Exception e) {
                    results.add(operation + " = Error: " + e.getMessage());
                }
            }

            io.writeResultsToFile(results, outputFileName);
            System.out.println("Results written to " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
