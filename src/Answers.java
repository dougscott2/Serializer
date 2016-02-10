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
    boolean isItGood;

    void askQuestions() {
        String userAnswer;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your favorite movie?");
        title = scanner.nextLine();
        System.out.println("Who's the main actor?");
        mainActor =  scanner.nextLine();
        System.out.println("Who's the main actress?");
        mainActress =  scanner.nextLine();
        System.out.println("What year did it come out?");
        userAnswer = scanner.nextLine();
        int year = Integer.valueOf(userAnswer);
        this.year = year;
        System.out.println("Is it good?");
        isItGood = Boolean.valueOf(scanner.nextLine());
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

    public Boolean getIsItGood() {
        return isItGood;
    }
}


