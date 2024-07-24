package org.example;
import java.util.Scanner;
import java.time.Year;

public class Main {
    public static void main(String[] args) {
        greetUser();
        // Store User's Name
        String userName = askForName();
        // Store User's Age
        int userAge = guessAge();
        count();
        testing();
        tellAStory(userName, userAge);
        daysOfTheWeek();
        System.out.println("Well, its been fun " + userName + " but I've got to go- bye!");
    }

    public static void greetUser(){
        System.out.println("Hello User!");
    }

    public static String askForName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = sc.nextLine();
        System.out.printf("Hello, %s!\n", name);
        return name;
    }

    public static int guessAge(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Now I am going to guess your age!");
        System.out.println("First question: Have you graduated high school? y/n");
        String answer = sc.nextLine();
        if(answer.equals("y")){
            System.out.println("What year did you graduate High School?");
            int year = sc.nextInt();
            int currentYear = Year.now().getValue();
            int age = currentYear - year + 18;
            System.out.println("Your age is..." + age + " correct? y/n");
            sc.nextLine(); // Consume leftover newline
            answer = sc.nextLine();
            if(answer.equals("y")){
                System.out.println("Woohoo! I am a good guesser!");
                return age;
            }
            else{
                System.out.println("Hmmm...I should only be a year or two off\n");
                age = currentYear - year + 17;
                System.out.println("Your age is..." + age + " correct? y/n");
                sc.nextLine(); // Consume leftover newline
                answer = sc.nextLine();
                if(answer.equals("y")){
                    System.out.println("Woohoo! I am a good guesser!");
                    return age;
                }
                else{
                    return bruteForce();
                }
            }
        }
        else{
            System.out.println("Hm...what year will you graduate? [Ex. 2025]");
            int year = sc.nextInt();
            int currentYear = Year.now().getValue();
            int ageCalc = 18 - (year - currentYear);
            System.out.println("Your age is..." + ageCalc + " correct? y/n \n");
            sc.nextLine(); // Consume leftover newline
            answer = sc.nextLine();
            if(answer.equals("y")){
                System.out.println("Woohoo! I am a good guesser!");
                return ageCalc;
            }
            else{
                return bruteForce();
            }
        }
    }

    public static void count(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Here- let me show you that I can count!");
        System.out.println("Give me a number: ");
        int number = sc.nextInt();
        for(int i = 1; i <= number; i++){
            System.out.println(i);
        }
    }

    public static void testing(){
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Next I am going to test you on your programming knowledge!\n");
            System.out.println("Answer with the corresponding letter of the answer you think is correct! [A, B , C, D]\n");
            System.out.println("Which of these 4 is not a primitive Java datatype?");
            System.out.println("[A]: int");
            System.out.println("[B]: float");
            System.out.println("[C]: String");
            System.out.println("[D]: char");
            String answer = sc.next().toUpperCase();
            if(answer.equals("C")){
                System.out.println("You've got it!\n");
                break;
            }
            else{
                System.out.println("Incorrect answer. Try again!");
            }
        }
    }

    public static void tellAStory(String name, int age){
        System.out.println("Next I am going to tell you a story about my favorite user- you!");
        System.out.printf("There once was a user named %s- they were %d years old and they loved hanging out with their chatbot.\n\n" , name, age);
    }

    public static int bruteForce(){
        Scanner sc = new Scanner(System.in);
        System.out.println("That's it- we're brute forcing it.\n");
        for (int i = 1; i < 100; i++) {
            System.out.printf("Are you %d years old? y/n\n", i);
            String answer = sc.nextLine();
            if(answer.equals("y")){
                System.out.println("Finally...making me use my CPU here.");
                return i;
            }
        }
        return 0;
    }

    public static void daysOfTheWeek(){
        Scanner sc = new Scanner(System.in);
        int day;
        do {
            System.out.println("Alright user- before we go I want to tell you some of my favorite things of a day of the week");
            System.out.println("Give me a number 1-7 and I'll tell you about my favorite part of the day!");
            day = sc.nextInt();
        } while (day != 1 && day != 2 && day != 3 && day != 4 && day != 5 && day != 6 && day != 7);
        switch(day){
            case 1:
                System.out.println("Monday: I enjoy the fresh start and planning ahead for the week, setting goals and priorities.\n");
                break;
            case 2:
                System.out.println("Tuesday: It’s when I often have engaging discussions and brainstorming sessions, which invigorate my creativity.\n");
                break;
            case 3:
                System.out.println("Wednesday: This mid-week point is great for checking progress on ongoing projects and catching up with colleagues.\n");
                break;
            case 4:
                System.out.println("Thursday: I look forward to winding down with some quiet time to reflect on achievements and lessons learned.\n");
                break;
            case 5:
                System.out.println("Friday: The anticipation of the weekend begins, and I love the collaborative energy as we wrap up tasks.\n");
                break;
            case 6:
                System.out.println("Saturday: It’s my favorite day to indulge in hobbies, read books, and spend quality time with loved ones.\n");
                break;
            case 7:
                System.out.println("Sunday: I cherish the tranquility, taking moments to recharge, plan for the upcoming week, and appreciate the little joys in life.\n");
                break;
        }
    }
}