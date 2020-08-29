package org.example;

import java.io.*;
import java.util.Scanner;

public class RandomTextFilesGenerator {

    int numberOfFiles = 10, numberOfLines = 10, lineLength = 100;
    String directoryName = "Random Files";

    void generateTextFiles(){
        System.out.println("Программа сгенерирует папку, наполнив её файлами в формате .txt");
        System.out.println("По умолчанию в рабочей папке программы будет созданап папка Random Files,");
        System.out.println("В которой будет размещено 10 файлов, содержащих по 10 строк из 100 символов");
        System.out.println("Вы хотите использовать настройки по умолчанию? (Y/N, Д/Н)");

        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {

            while (true){
                String answer = in.nextLine().trim();
                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("д")) break;
                else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("н")){
                    System.out.println("Введите имя папки. Чтобы оставить значение по умолчанию, просто нажмите ввод");
                    answer = in.nextLine();
                    if (!answer.trim().equals("")) directoryName = answer;
                    System.out.println("Введите количество файлов. Чтобы оставить значение по умолчанию, просто нажмите ввод");
                    answer = in.nextLine();
                    if (!answer.trim().equals("")) numberOfFiles = Integer.parseInt(answer.trim());
                    System.out.println("Введите количество строк в файле. Чтобы оставить значение по умолчанию, просто нажмите ввод");
                    answer = in.nextLine();
                    if (!answer.trim().equals("")) numberOfLines = Integer.parseInt(answer.trim());
                    System.out.println("Введите количество симаолов в строке. Чтобы оставить значение по умолчанию, просто нажмите ввод");
                    answer = in.nextLine();
                    if (!answer.trim().equals("")) lineLength = Integer.parseInt(answer.trim());
                    break;
                }
                System.out.println("Ответ может быть Y, N, Д, Н, регистр неважен.");
            }

        }

        catch (Exception e){
            System.out.println(e.getMessage());
        }

        File directory = new File(directoryName);
        if (!directory.exists()) directory.mkdir();
        for (int i = 0; i < numberOfFiles; i++){
            File file = new File(directory, "RandomTextFile" + i + ".txt"); //creating a file
            try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
                for (int j = 0; j < numberOfLines; j++) {
                    StringBuilder line = new StringBuilder();                       //creating a line
                    for (int k = 0; k < lineLength; k++) {
                        line.append((char) (Math.random() * (126 - 33) + 33));      //filling the line
                    }
                    out.println(line);
                }
            }

            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}
