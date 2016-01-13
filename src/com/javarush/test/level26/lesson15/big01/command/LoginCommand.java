package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by sergey on 07.12.15.
 */
public class LoginCommand implements Command {
    private ResourceBundle validCreditCards =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");

    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");


    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true)
        {
            ConsoleHelper.writeMessage(validCreditCards.getString("specify.data"));

            String numCard_str = ConsoleHelper.readString().trim();
            String pinCard_str = ConsoleHelper.readString().trim();

            if(!numCard_str.matches("^[0-9]{12}$") || !pinCard_str.matches("^[0-9]{4}$"))
            {
                ConsoleHelper.writeMessage(validCreditCards.getString("not.verified.format"));
                ConsoleHelper.writeMessage(validCreditCards.getString("try.again.with.details"));
                ConsoleHelper.writeMessage(validCreditCards.getString("try.again.or.exit"));
                continue;
            }

            if (validCreditCards.containsKey(numCard_str) &&
                    validCreditCards.getString(numCard_str).equals(pinCard_str)) {

                ConsoleHelper.writeMessage(validCreditCards.getString("success.format"));
                break;
            }

        }

    }

}
