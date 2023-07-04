package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {
    public Profile getDataFromFile(File file) {
        String name = null;
        String email = null;
        int age = 0;
        Long phone = 0L;

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];

                    switch (key) {
                        case "Name" -> name = value;
                        case "Age" -> age = Integer.parseInt(value);
                        case "Email" -> email = value;
                        case "Phone" -> phone = Long.valueOf(value);

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(name, age, email, phone);
    }
}

