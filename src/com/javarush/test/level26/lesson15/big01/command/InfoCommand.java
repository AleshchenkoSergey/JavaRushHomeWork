package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by sergey on 19.09.15.
 */
class InfoCommand implements Command {
    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");


    public InfoCommand() {
    }

    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        Collection<CurrencyManipulator> map = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (map.size() == 0) ConsoleHelper.writeMessage(res.getString("no.money"));
        else {
            int count = 0;
            for (CurrencyManipulator cur : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
                if (cur.getTotalAmount() > 0) {
                    count++;
                    ConsoleHelper.writeMessage(cur.getCurrencyCode() + " - " + cur.getTotalAmount());
                }
            }
            if (count == 0) ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
