package com.kforkojo;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static final int MONTHS_IN_YEAR = 12;
    static final int PERCENT = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int principal = getPrincipal(scanner);
        double annualInterestRate = getAnnualInterestRate(scanner);
        int period = getPeriodInYears(scanner);

        int numberOfPayments = period * MONTHS_IN_YEAR;
        double monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + mortgageFormatted);
    }

    private static int getPrincipal(Scanner scanner) {
        while (true) {
            System.out.print("Principal (1,000 - 1,000,000): ");
            String line = scanner.nextLine();
            try {
                int principal = Integer.parseInt(line);
                if (principal < 1000 || principal > 1_000_000) {
                    throw new Exception();
                }
                return principal;
            } catch (Exception e) {
                System.out.print("* Enter a valid whole number from 1,000 to 1,000,000: ");
            }
        }
    }

    private static double getAnnualInterestRate(Scanner scanner) {
        while (true) {
            System.out.print("Annual Interest Rate (0 - 100): ");
            String line = scanner.nextLine();
            try {
                double annualInterestRate = Double.parseDouble(line);
                if (annualInterestRate < 0 || annualInterestRate > 100) {
                    throw new Exception();
                }
                return annualInterestRate;
            } catch (Exception e) {
                System.out.print("* Enter a valid percentage from 0 to 100: ");
            }
        }
    }

    private static int getPeriodInYears(Scanner scanner) {
        while (true) {
            System.out.print("Period (in years): ");
            String line = scanner.nextLine();
            try {
                int period = Integer.parseInt(line);
                if (period < 0) {
                    throw new Exception();
                }
                return period;
            } catch (Exception e) {
                System.out.print("* Enter a valid period in years: ");
            }
        }
    }
}