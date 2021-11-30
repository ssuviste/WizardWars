package com.wizard;

import java.util.Scanner;

/**
 * Task 2:
 * Every wizard must have a name and a surname. It can have middle name as much as it can.
 * Wizard names/surnames must not contain any numbers or special characters. Punct etc. (Hint: Check the last weeks class code)
 * In case error has been detected print a meaningful error stating what is the reason of not accepting surname or name.
 * When
 */
public class CharacterCreation {
    public void requestNameFor(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print("Input first name: ");
            input = scanner.nextLine();
            if (validateName(true, input)) {
                wizard.setName(input);
                return;
            }
        }
    }

    public void requestSurnameFor(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print("Input surname: ");
            input = scanner.nextLine();
            if (validateName(false, input)) {
                wizard.setSurname(input);
                return;
            }
        }
    }

    /**
     * Responsible for
     * 1.  Validating the name or surname
     * 2.  Print error from here if it doesn't validate. (meaningful/guiding error so user knows why it was wrong)
     */
    private boolean validateName(boolean firstName, String input) {
        String regex;
        String emptyError;
        String regexError;
        if (firstName) {
            regex = "[A-Za-z]+";
            emptyError = "Invalid input! First name cannot be empty.";
            regexError = "Invalid input! First name must only consist of characters and cannot contain whitespace.";
        } else {
            regex = "[A-Za-z]+((\\s[A-Za-z]+)*)?";
            emptyError = "Invalid input! Surname cannot be empty.";
            regexError = "Invalid input! Surname (and middle name) must only consist of characters and cannot end with whitespace.";
        }
        if (input == null || input.isEmpty()) {
            System.out.println(emptyError);
            return false;
        } else if (!input.matches(regex)) {
            System.out.println(regexError);
            return false;
        }
        return true;
    }
}
