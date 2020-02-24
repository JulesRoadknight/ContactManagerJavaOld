package com.company;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {

    public static void main(String[] args) {
    }

    public static String confirmInput(String detail) {
        String input = getInput(detail);
        Boolean validInput = validateInput(detail, input);
        if (validInput == false) {
            confirmInput(detail);
        }
        return input;
    }

    public static Integer menuChoice() {
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String getInput(String detail) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter your " + detail + ":");
        String input = userInput.nextLine();
        return input;
    }

    public static Boolean validateInput(String detail, String input) {
        switch (detail) {
            case "first name":
            case "last name":
                return validName(input);
            case "phone number": return validNumber(input);
            case "DOB in dd/mm/yy format": return validDOB(input);
            case "email": return validEmail(input);
            default: return true;
        }
    }

    public static Boolean validName(String name) {
        Pattern namePattern = Pattern.compile("^[A-Z]'?[- a-zA-Z]+$");
        return name.matches(String.valueOf(namePattern));
    }
    public static Boolean validNumber(String phoneNumber) {
        Pattern phonePattern = Pattern.compile("^[\\d]+$");
        return phoneNumber.matches(String.valueOf(phonePattern));
    }

    public static Boolean validDOB(String dOB) {
        Pattern dOBPattern = Pattern.compile("(\\d{2}\\/\\d{2}\\/\\d{4})");
        if (dOB.matches(String.valueOf(dOBPattern))) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean validEmail(String email) {
        Pattern emailPattern = Pattern.compile("^(.+@.+)$");
        return email.matches(String.valueOf(emailPattern));
    }
}
