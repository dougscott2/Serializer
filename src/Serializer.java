import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.*;
import java.util.Scanner;

/**
 * Created by DrScott on 10/14/15.
 */
public class Serializer {
    static Answers answer;
    public static void main(String[] args) {
        answer = loadAnswers();
        if (answer == null) {
            answer = new Answers();
            answer.askQuestions();
        } else {
            JsonSerializer serializer = new JsonSerializer();
            String contentToSave = serializer.serialize(answer);
            File f = new File("save.json");
            FileWriter fw = null;
            try {
                fw = new FileWriter(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.write(contentToSave);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int fileSize = (int) f.length();
            char[] contents = new char[fileSize];
            FileReader fr = null;
            try {
                fr = new FileReader(f);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                fr.read(contents);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String fileContents = new String(contents);
            JsonParser parser = new JsonParser();
            Answers newAnswers = parser.parse(fileContents, Answers.class);
            System.out.println(String.format("Your favorite movie is %s, starring %s and %s. It came out in %d, and when asked if it was good you replied '" +
                    " %s", answer.title, answer.mainActor, answer.mainActress, answer.year, answer.isItGood));
            System.out.println("Want to change your answers?");
            Scanner scanner = new Scanner(System.in);
            String userAnswer = scanner.nextLine();
            if (userAnswer.equals("Yes") || userAnswer.equals("yes")){
                answer = new Answers();
                answer.askQuestions();
                saveAnswers();
            }
        }
        saveAnswers();
    }
    static void saveAnswers() {
        File f = new File("save.json");
        JsonSerializer serializer = new JsonSerializer();
        String contentToSave = serializer.serialize(answer);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(contentToSave);
            fw.close();
        } catch (Exception e) {
            System.out.println("Something went wrong...sorry!");
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
            return parser.parse(fileContents, Answers.class);
        } catch (Exception e) {
            System.out.println("Something went wrong...sorry!");
            return null;
        }
    }


}
