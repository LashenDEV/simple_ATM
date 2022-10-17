import java.util.Scanner;

public class ATMmachine {
    public static void main(String[] args) {
        String cardNum = "a1234b";
        String pinNum = "4321";
        double balance = 1000;
        int pinRemains = 3;

        Scanner transaction;
        transaction = new Scanner(System.in);

        System.out.println("Please Enter Your Card Number");
        String enteredCardNum = transaction.nextLine();

        if (enteredCardNum.equalsIgnoreCase(cardNum)) {
            System.out.println("Please Enter Your Pin Number");
            String enteredPinNum = transaction.nextLine();
            StringBuilder enteredReversedPinNum = new StringBuilder(enteredPinNum);
            StringBuilder reversedPinNum = new StringBuilder(pinNum);
            while (pinRemains > 0) {
                if (enteredPinNum.equalsIgnoreCase(pinNum)) {
                    if (enteredPinNum.equalsIgnoreCase(pinNum)) {
                        System.out.println("1 - Check the Balance\n2 - Money Withdraw\n3 - Cancel");
                        int userChoice = transaction.nextInt();

                        if (userChoice == 1) {
                            System.out.println("Your Current Account Balance is Rs" + balance);
                        } else if (userChoice == 2) {
                            System.out.println("Please Enter the Amount to Withdraw");
                            double withdrawAmount = transaction.nextDouble();
                            if (withdrawAmount <= balance) {
                                System.out.println("Please Enter Your Pin Number Again");
                                String reenteredPinNum = transaction.next();

                                int count = 1;
                                try {
                                    while (true) {
                                        Thread.sleep(500);

                                        for (int i = 0; i < count; i++)
                                            System.out.print("*");
                                        System.out.print("\r");

                                        count++;
                                        if (count >= 5)
                                            break;
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                if (reenteredPinNum.equalsIgnoreCase(pinNum)) {
                                    balance -= withdrawAmount + 5;
                                    System.out.println(
                                            "You have successfully withdraw Rs." + withdrawAmount
                                                    + " Processing fee Rs."
                                                    + 5
                                                    + "\nNow your balance is Rs." + balance);
                                } else {
                                    System.out.println("Oops... Incorrect Pin Number!");
                                }
                            } else {
                                System.out.println("Insufficient Balance. Please Try again!");
                            }

                        } else if (userChoice == 3) {
                            System.out.println("Transaction has been canceled, Thank You!");
                            System.exit(userChoice);
                        }
                    }
                } else if (reversedPinNum.reverse().toString().equals(enteredReversedPinNum.toString())) {
                    System.out.println("Card has been blocked !!!");
                    System.exit(pinRemains);
                } else {
                    System.out.println("Wrong Pin Number!, Please Enter Your Pin Number Again." + reversedPinNum
                            + enteredReversedPinNum);
                    enteredPinNum = transaction.nextLine();
                    pinRemains--;
                }
            }
            if (pinRemains == 0) {
                System.out.println("You have entered wrong pin number three times");
            }
        } else {
            System.out.println("Please double check the account Number");
        }
    }
}
