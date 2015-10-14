import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by DrScott on 10/14/15.
 */
public class Answers extends Serializer{
    String title;
    String mainActor;
    int year;
    String mainActress;
    String isItGood;
    public Answers (){
    }
    void askQuestions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your favorite movie?");
        String userAnswer = scanner.nextLine();
        answer.title = userAnswer;
        System.out.println("Who's the main actor?");
        userAnswer = scanner.nextLine();
        answer.mainActor = userAnswer;
        System.out.println("Who's the main actress?");
        userAnswer = scanner.nextLine();
        answer.mainActress = userAnswer;
        System.out.println("What year did it come out?");
        userAnswer = scanner.nextLine();
        int year = Integer.valueOf(userAnswer);
        answer.year = year;
        System.out.println("Is it good?");
        userAnswer = scanner.nextLine();
        answer.isItGood = userAnswer;
    }
    public String getTitle() {
        return title;
    }

    public String getMainActor() {
        return mainActor;
    }

    public int getYear() {
        return year;
    }

    public String getMainActress() {
        return mainActress;
    }

    public String getIsItGood() {
        return isItGood;
    }
}


