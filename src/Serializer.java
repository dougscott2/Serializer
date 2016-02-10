import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.*;
import java.util.Scanner;

/**
 * Created by DrScott on 10/14/15.
 */
public class Serializer {
    static Answers answer;  //static object that can be used almost anywhere in the program
    public static void main(String[] args) {
        //answer = loadAnswers(); //not sure why i couldn't just say loadAnswers();
        while (true) {
            answer.loadAnswers();
            if (answer  == null) {
                answer = new Answers();
                answer.askQuestions(); //askQuestions will put data into answer object
            } else {
                System.out.println("Want to change your answers?");
                Scanner scanner = new Scanner(System.in);  //creating scanner
                String userAnswer = scanner.nextLine();
                if (userAnswer.equalsIgnoreCase("Yes") || userAnswer.equalsIgnoreCase("Y")) {
                    answer.askQuestions();
                } else {
                    System.out.println("K, bye.");
                    System.exit(0);
                }
            }
            saveAnswers();
        }
    }
    static void saveAnswers() {
        File f = new File("save.json");
        JsonSerializer serializer = new JsonSerializer();  //json serializer
        String contentToSave = serializer.serialize(answer);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(contentToSave);
            fw.close();
        } catch (Exception e) {
            System.out.println("Something went wrong with saveAnswers()...sorry!");
        }
    }
    static Answers loadAnswers() {
        try {
            File f = new File("save.json");
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] contents = new char[fileSize];
            fr.read(contents);
            String fileContents = new String(contents);
            JsonParser parser = new JsonParser();
            System.out.println(fileContents);
            return parser.parse(fileContents, Answers.class);
        } catch (Exception e) {
            System.out.println("Something went wrong with loadAnswers()...sorry!");
            return null;
        }
    }


}
