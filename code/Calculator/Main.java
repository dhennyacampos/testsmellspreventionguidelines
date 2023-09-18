package ufba.br;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "read.txt";
        String outputFileName = "write.txt";

        IOHandler io = new IOHandler();
        MathOperations math = new MathOperations();

        try {
            List<String> operations = io.readOperationsFromFile(inputFileName);

            // Create a thread pool with a fixed number of threads
            int numThreads = Runtime.getRuntime().availableProcessors();
            ExecutorService executor = Executors.newFixedThreadPool(numThreads);

            List<Future<String>> results = new ArrayList<>();

            for (String operation : operations) {
                Callable<String> task = () -> {
                    try {
                        double result = math.evaluateOperation(operation);
                        return operation + " = " + result;
                    } catch (Exception e) {
                        return operation + " = Error: " + e.getMessage();
                    }
                };

                Future<String> result = executor.submit(task);
                results.add(result);
            }

            // Wait for all tasks to complete and collect results
            List<String> finalResults = new ArrayList<>();
            for (Future<String> result : results) {
                finalResults.add(result.get());
            }

            io.writeResultsToFile(finalResults, outputFileName);
            System.out.println("Results written to " + outputFileName);

            // Shutdown the executor service
            executor.shutdown();
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
