package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public static Profile getDataFromFile(File file) {
        StringBuilder data = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int ch;
            while((ch = fileInputStream.read()) != -1) {
                data.append((char) ch);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO exception");
        }
        return getProfileFromString(data.toString());
    }

    public static Profile getProfileFromString(String data) {
        String[] rows = data.split("\n");
        String name = rows[0].split(": ")[1].trim();
        String age = rows[1].split(": ")[1].trim();
        String email = rows[2].split(": ")[1].trim();
        String phone = rows[3].split(": ")[1].trim();
        return new Profile(name, Integer.parseInt(age), email, Long.parseLong(phone));
    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/Profile.txt");
        getDataFromFile(file);
    }
}
