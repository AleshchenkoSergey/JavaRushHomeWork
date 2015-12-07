package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by sergey on 19.09.15.
 */
class DepositCommand implements Command {
    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    public DepositCommand() {
    }

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String code = ConsoleHelper.askCurrencyCode();
        while (true) {
            try {
                String[] values = ConsoleHelper.getValidTwoDigits(code);
                CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
                int dom = Integer.valueOf(values[0]);
                int count = Integer.valueOf(values[1]);
                manipulator.addAmount(dom, count);
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), (dom * count), code));
                break;
            } catch (NumberFormatException ex) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
    }
}
