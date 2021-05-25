package com.c;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File f1 = new File("data\\out.txt");
        File f2 = new File ("data\\input.txt");
        try (FileReader reader = new FileReader(f2);
             BufferedReader bufferedReader = new BufferedReader(reader);
             FileWriter writer = new FileWriter(f1,true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            String[] line = new String[3];
            String[] lineMedium = new String[3];
            String[] lineResult = new String[3];
            for(int i = 0; i < 3 ; i++){
                line[i] = bufferedReader.readLine();
            }
            for(int i = 0; i < 3; i++){
                if((line[i].indexOf("/*") != -1) && (line[i].indexOf("*/") != -1)) {
                    lineMedium[i] = line[i].replace((line[i].substring(line[i].indexOf("/*"), line[i].indexOf("*/"))), "");
                }else{
                    lineMedium[i] = line[i];
                }
            }
            for(int i = 0; i < 3; i++ ){
                if(lineMedium[i].indexOf("*/") != -1){
                    lineResult[i] = lineMedium[i].replace("*/", "");
                }else{
                    lineResult[i] = lineMedium[i];
                }
            }
            for (int i = 0; i < 3; i++){
                bufferedWriter.write(lineResult[i]);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Все комментарии удалены!");
    }
}
