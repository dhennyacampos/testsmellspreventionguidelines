package ufba.br;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IOHandler {
    public List<String> readOperationsFromFile(String fileName) throws IOException {
        List<String> operations = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                operations.add(line);
            }
        }
        return operations;
    }

    public void writeResultsToFile(List<String> results, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String result : results) {
                writer.write(result);
                writer.newLine();
            }
        }
    }
}

