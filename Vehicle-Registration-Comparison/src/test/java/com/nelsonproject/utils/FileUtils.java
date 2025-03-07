package com.nelsonproject.utils;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class FileUtils {
    public static List<String> readVehicleNumbers(String filePath) {
        List<String> regNumbers = new ArrayList<>();
        String pattern = "[A-Z]{2}[0-9]{2} ?[A-Z]{3}";  // Example: AB12 XYZ

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = Pattern.compile(pattern).matcher(line);
                while (matcher.find()) {
                    regNumbers.add(matcher.group());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return regNumbers;
    }

    public static Map<String, String> readExpectedResults(String filePath) {
        Map<String, String> expectedResults = new HashMap<>();
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                line = line.trim();
                System.out.println("Reading line: " + line);
                String[] parts = line.split(",");
                System.out.println("Parts: " + Arrays.toString(parts));

                if (parts.length == 4) {
                    String regNumber = parts[0].trim();
                    String expectedDetails = String.join(",", Arrays.copyOfRange(parts, 1, parts.length));  // Join make, model, and year
                    expectedResults.put(regNumber, expectedDetails);
                } else {
                    System.out.println("Skipping line, incorrect format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expectedResults;
    }

}
