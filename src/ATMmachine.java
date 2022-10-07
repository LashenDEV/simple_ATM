import java.util.Scanner;

public class ATMmachine {
    public static void main(String[] args) {
        String cardNum = "a1234b";
        String pinNum = "4321";
        double balance = 1000;
        int pinremains = 0;

        Scanner transaction = new Scanner(System.in);

        System.out.println("Please Enter Your Card Number");
        String enteredCardNum = transaction.nextLine();

        if (enteredCardNum.equalsIgnoreCase(cardNum)) {
            System.out.println("Please Enter Your Pin Number ");
            String enteredPinNum = transaction.nextLine();
            while (pinremains < 3) {
                if (enteredPinNum.equalsIgnoreCase(pinNum)) {
                    if (enteredPinNum.equalsIgnoreCase(pinNum)) {
                        System.out.println("1 - Check the Balance\n2 - Money Withdraw\n3 - Cancel");
                        int userChoice = transaction.nextInt();

                        if (userChoice == 1) {
                            System.out.println("Your Current Account Balance is Rs" + balance);
                        } else if (userChoice == 2) {
                            System.out.println("Please Enter the Amount to Withdraw");
                            double withdrawAmount = transaction.nextDouble();
                            if (withdrawAmount < balance) {
                                System.out.println("Please Enter Your Pin Number Again");
                                String reenteredPinNum = transaction.next();
                                if (reenteredPinNum.equalsIgnoreCase(pinNum)) {
                                    balance -= withdrawAmount;
                                    System.out.println("You have successfully withdraw Rs." + withdrawAmount + "\nNow your balance is Rs." + balance);
                                } else {
                                    System.out.println("Oops... Incorrect Pin Number!");
                                }
                            } else {
                                System.out.println("Insufficient  Balance. Please Try again!");
                            }

                        } else if (userChoice == 3) {
                            System.out.println("Transaction has been canceled, Thank You!");
                        }
                    }
                } else {
                    System.out.println("Wrong Pin Number! ,Please Enter Your Pin Number Again.");
                    enteredPinNum = transaction.nextLine();
                    pinremains++;
                }
            }
        } else {
            System.out.println("Please double check the account Number");
        }
    }
}

