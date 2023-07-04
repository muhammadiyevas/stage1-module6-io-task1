package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {

            String line = null;

            while ((line = reader.readLine()) != null) {

                if (line.startsWith("Name: ")) {
                    profile.setName(line.substring(6));
                } else if (line.startsWith("Age: ")) {
                    profile.setAge(Integer.parseInt(line.substring(5)));
                } else if (line.startsWith("Email: ")) {
                    profile.setEmail(line.substring(7));
                } else if (line.startsWith("Phone: ")) {
                    profile.setPhone(Long.parseLong(line.substring(7)));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return profile;

    }
}

