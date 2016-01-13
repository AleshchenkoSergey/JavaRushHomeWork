package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by sergey on 07.12.15.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");


    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() throws InterruptOperationException {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ("EXIT".equalsIgnoreCase(line))
            throw new InterruptOperationException();
        return line;
    }

    public static Operation askOperation() throws InterruptOperationException {
        Operation operation = null;

        writeMessage(res.getString("choose.operation"));

        writeMessage("0-Login, " + res.getString("operation.INFO") + ", "
                + res.getString("operation.DEPOSIT") + ", "
                + res.getString("operation.WITHDRAW") + ", "
                + res.getString("operation.EXIT"));

        while (operation == null) {
            try {
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            } catch (IllegalArgumentException e) {
                writeMessage(res.getString("invalid.data"));
            }
        }

        return operation;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.currency.code"));

            String str = readString();
            if (str.length() != 3) {
                writeMessage(res.getString("invalid.data"));
            } else {
                return str.toUpperCase();
            }
        }
    }


    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.denomination.and.count.format"));
            String userInput = readString();
            String[] strmas = userInput.split(" ");
            try {
                if (strmas.length == 2 && Integer.parseInt(strmas[0]) >= 0 && Integer.parseInt(strmas[1]) >= 0) {
                    return strmas;
                } else {
                    writeMessage(res.getString("invalid.data"));
                }
            }catch (NumberFormatException ex) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }

}
