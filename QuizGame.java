package destination.quizeGame.Nov17;

import java.util.Scanner;

public class QuizGame {
    static Scanner scanner = new Scanner(System.in);
    static boolean phoneAFriendUsed = false;
    static boolean fiftyFiftyUsed = false;
    static int prize = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the Java Quiz Game!");

        // Taking candidate details
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("\nHello, " + name + "! Here are the rules:");
        System.out.println("1. You will be asked ten questions.");
        System.out.println("2. Each question is worth 1000 points.");
        System.out.println("3. If you answer incorrectly, the game will terminate.");
        System.out.println("4. You have two lifelines: Phone a Friend and 50-50.");
        System.out.println("5. You can use each lifeline only once.");
        System.out.println("\nLet's start the game!");

        // List of all 10 questions
        if (askQuestion("What is the correct way to declare a variable in Java?",
                "int num = 10;", "num int = 10;", "int = 10 num;", "int: num = 10;", 1)) {
            prize += 1000;
            System.out.println("Congratulations, " +name +"! You have won ₹1000 for this Quize\nYour total winiing amount is ₹"+prize);
        } else {
            endGame();
            return;
        }

        if (askQuestion("Which of these is a valid keyword in Java?",
                "interface", "default", "unsigned", "include", 1)) {
            prize += 2000;
            System.out.println("Congratulations, " +name +"! You have won ₹2000 for this Quize\nYour total winiing amount is ₹"+prize);
        } else {
            endGame();
            return;
        }

        if (askQuestion("Which method is used to start a thread in Java?",
                "start()", "run()", "begin()", "init()", 1)) {
            prize += 3000;
            System.out.println("Congratulations, " +name +"! You have won ₹3000 for this Quize\nYour total winiing amount is ₹"+prize);
        } else {
            endGame();
            return;
        }

        if (askQuestion("Which of the following data types has the highest precision?",
                "int", "float", "double", "byte", 3)) {
            prize += 4000;
            System.out.println("Congratulations, " +name +"! You have won ₹4000 for this Quize\nYour total winiing amount is ₹"+prize);
        } else {
            endGame();
            return;
        }

        if (askQuestion("What is the size of a long data type in Java?",
                "4 bytes", "8 bytes", "2 bytes", "16 bytes", 2)) {
            prize += 5000;
            System.out.println("Congratulations, " +name +"! You have won ₹5000 for this Quize\nYour total winiing amount is ₹"+prize);
        } else {
            endGame();
            return;
        }

        if (askQuestion("How do you write a multi-line comment in Java?",
                "// comment", "/* comment */", "** comment **", "<!-- comment -->", 2)) {
            prize += 6000;
            System.out.println("Congratulations, " +name +"! You have won ₹6000 for this Quize\nYour total winiing amount is ₹"+prize);
        } else {
            endGame();
            return;
        }

        if (askQuestion("Which of these is not a Java feature?",
                "Object-oriented", "Platform independent", "Use of pointers", "Robust", 3)) {
            prize += 7000;
            System.out.println("Congratulations, " +name +"! You have won ₹7000 for this Quize\nYour total winiing amount is ₹"+prize);
        } else {
            endGame();
            return;
        }

        if (askQuestion("What is the default value of a boolean variable in Java?",
                "true", "false", "0", "null", 2)) {
            prize += 8000;
            System.out.println("Congratulations, " +name +"! You have won ₹8000 for this Quize\nYour total winiing amount is ₹"+prize);
        } else {
            endGame();
            return;
        }

        if (askQuestion("What is the purpose of the final keyword in Java?",
                "To define a constant", "To mark a method that cannot be overridden",
                "To mark a class that cannot be subclassed", "All of the above", 4)) {
            prize += 9000;
            System.out.println("Congratulations, " +name +"! You have won ₹9000 for this Quize\nYour total winiing amount is ₹"+prize);
        } else {
            endGame();
            return;
        }

        if (askQuestion("Which of the following exceptions is checked in Java?",
                "NullPointerException", "ArrayIndexOutOfBoundsException", 
                "FileNotFoundException", "ArithmeticException", 3)) {
            prize += 10000;
            System.out.println("Congratulations, " +name +"! You have won ₹10,000 for this Quize\nYour total winiing amount is ₹"+prize);
        } else {
            endGame();
            return;
        }

        // If the user answers all questions correctly
        System.out.println("\n Once again A Big Congratulations, to you. You have Completed all Quize of this game  " + name + "! You have won " + prize + " points!");
    }

    public static boolean askQuestion(String question, String option1, String option2, String option3, String option4, int correctOption) {
        System.out.println("\n" + question);
        System.out.println("1. " + option1);
        System.out.println("2. " + option2);
        System.out.println("3. " + option3);
        System.out.println("4. " + option4);
        System.out.println("5. Use a lifeline (if available)");

        System.out.print("Enter your choice (1-5): ");
        int choice = scanner.nextInt();

        if (choice == 5) {
            useLifeline(question, option1, option2, option3, option4, correctOption);
            return askQuestion(question, option1, option2, option3, option4, correctOption); // Ask the question again
        } else if (choice == correctOption) {
            System.out.println("Correct answer!");
            return true;
        } else {
            System.out.println("Wrong answer!");
            return false;
        }
    }

    public static void useLifeline(String question, String option1, String option2, String option3, String option4, int correctOption) {
        if (!phoneAFriendUsed || !fiftyFiftyUsed) {
            System.out.println("\nChoose a lifeline:");
            if (!phoneAFriendUsed) System.out.println("1. Phone a Friend");
            if (!fiftyFiftyUsed) System.out.println("2. 50-50");

            int lifelineChoice = scanner.nextInt();

            if (lifelineChoice == 1 && !phoneAFriendUsed) {
                phoneAFriendUsed = true;
                System.out.println("Calling a friend... Your friend suggests the correct answer might be option " + correctOption);
            } else if (lifelineChoice == 2 && !fiftyFiftyUsed) {
                fiftyFiftyUsed = true;
                System.out.println("50-50 Lifeline used. Two incorrect options have been removed:");
                if (correctOption == 1) {
                    System.out.println("1. " + option1);
                    System.out.println("3. " + option3);
                } else if (correctOption == 2) {
                    System.out.println("2. " + option2);
                    System.out.println("4. " + option4);
                } else if (correctOption == 3) {
                    System.out.println("1. " + option1);
                    System.out.println("3. " + option3);
                } else {
                    System.out.println("2. " + option2);
                    System.out.println("4. " + option4);
                }
            } else {
                System.out.println("Invalid choice or lifeline already used.");
            }
        } else {
            System.out.println("No lifelines left!");
        }
    }

    public static void endGame() {
        System.out.println("\nGame over! You won ₹"+ prize );
    }
}

   
