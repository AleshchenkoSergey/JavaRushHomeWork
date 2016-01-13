package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.NavigableMap;
import java.util.ResourceBundle;

/**
 * Created by sergey on 07.12.15.
 */
public class WithdrawCommand implements Command {
    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");



    public WithdrawCommand() {
    }

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCoode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCoode);
        int cash;
        do {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String sum = ConsoleHelper.readString();
            try {
                cash = Integer.parseInt(sum);
            } catch (NumberFormatException e) //ловим некорректные данные
            {
                continue;
            }
            if (currencyManipulator.isAmountAvailable(cash)) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                break;
            }
            ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
        } while (true);

        try {
            //вывод банкнот для запрашиваемой суммы
            NavigableMap<Integer, Integer> withdrawMap = (NavigableMap<Integer, Integer>) currencyManipulator.withdrawAmount(cash);
            for (Map.Entry<Integer, Integer> pair : withdrawMap.entrySet()) {
                ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
            }
        } catch (NotEnoughMoneyException e) {
            ConsoleHelper.writeMessage(res.getString("not.enough.money"));
        }

        ConsoleHelper.writeMessage(res.getString("success.format"));
    }

}
