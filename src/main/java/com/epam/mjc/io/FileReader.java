package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {
    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        String str = null;
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {

            while ((str=bufferedReader.readLine()) != null){
                if(str.startsWith("Name:")){
                    profile.setName(str.substring(6));
                }else if (str.startsWith("Age: ")){
                    profile.setAge(Integer.valueOf(str.substring(5)));
                }else if (str.startsWith("Email: ")){
                    profile.setEmail(str.substring(7));
                }else if (str.startsWith("Phone: ")){
                    profile.setPhone(Long.valueOf(str.substring(7)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return profile;

    }
}

