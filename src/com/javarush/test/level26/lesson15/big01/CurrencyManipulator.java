package com.javarush.test.level26.lesson15.big01;



import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;


/**
 * Created by sergey on 17.09.15.
 */
public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }

    public int getTotalAmount() {
        int summ = 0;

        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            summ += key*value;
        }

        return summ;
    }


    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {

            denominations.put(denomination, count);

    }

    public boolean hasMoney() {
        if (denominations.size() == 0 || getTotalAmount() == 0)
        {
            return false;
        }
        return true;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }



    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        int sum = expectedAmount;
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.putAll(denominations);
        ArrayList<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> pair : temp.entrySet())
            list.add(pair.getKey());

        Collections.sort(list);
        Collections.reverse(list);

        TreeMap<Integer, Integer> result = new TreeMap<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });

        for (Integer aList : list) {
            int key = aList;
            int value = temp.get(key);
            while (true) {
                if (sum < key || value <= 0) {
                    temp.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (result.containsKey(key))
                    result.put(key, result.get(key) + 1);
                else
                    result.put(key, 1);
            }
        }

        if (sum > 0)
            throw new NotEnoughMoneyException();
        else
        {
            for (Map.Entry<Integer, Integer> pair : result.entrySet())
                ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());

            denominations.clear();
            denominations.putAll(temp);
            ConsoleHelper.writeMessage("Транзакция прошла успешно!");
        }
        return result;
    }
}
