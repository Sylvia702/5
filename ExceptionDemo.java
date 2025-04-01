import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

class ExceptionDemo {
    private double divisor;
    private double dividend;
    private double result;
    private final Scanner input = new Scanner(System.in);

    public void divide() {
        try {
            System.out.print("Enter a number for divisor: ");
            divisor = input.nextDouble();
            System.out.print("Enter a number for dividend: ");
            dividend = input.nextDouble();
            result = divisor / dividend;
            System.out.println("The result of division is: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Exception " + e + " occurred. A number was expected, but wasn't provided");
        } catch (ArithmeticException e) {
            System.out.println("Exception " + e + " occurred. Division by zero was attempted");
        } finally {
            try (input) {
                System.out.println("Closing all the resources");
            }
        }
    }

    public void divideThrows() throws InputMismatchException, ArithmeticException {
        System.out.print("Enter a number for divisor: ");
        divisor = input.nextDouble();
        System.out.print("Enter a number for dividend: ");
        dividend = input.nextDouble();
        result = divisor / dividend;
        System.out.println("The result of division is: " + result);
    }

    public void goToDivideMethod() throws InputMismatchException, ArithmeticException {
        divideThrows();
    }

    public void displayChoices() {
        Scanner choiceInput = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("1. Divide");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = choiceInput.nextInt();
                switch (choice) {
                    case 1:
                        try {
                            goToDivideMethod();
                        } catch (InputMismatchException e) {
                            System.out.println("Exception " + e + " occurred. A number was expected, but wasn't provided");
                        } catch (ArithmeticException e) {
                            System.out.println("Exception " + e + " occurred. Division by zero was attempted");
                        } finally {
                            System.out.println("Closing all the resources");
                            choiceInput.close();
                        }   break;
                    case 2:
                        System.out.println("Exiting the program...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                choiceInput.nextLine(); 
            }
        }
    }

    public void readAFile() throws IOException {
        Scanner fileInput = new Scanner(System.in);
        System.out.print("Enter the path to the file: ");
        String filePath = fileInput.nextLine();
        if (!filePath.contains(".")) {
            throw new MissingExtensionException("File path is missing an extension");
        }
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            String line = br.readLine();
            System.out.println("Content of the file: " + line);
        } finally {
            fileInput.close();
        }
    }

    public Scanner getInput() {
        return input;
    }

    static class MissingExtensionException extends IOException {
        public MissingExtensionException(String message) {
            super(message);
        }
    }
}
