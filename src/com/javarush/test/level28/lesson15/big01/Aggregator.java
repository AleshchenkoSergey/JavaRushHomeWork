package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.model.Strategy;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by sergey on 20.10.15.
 */
public class Aggregator {
    public static void main(String[] args) {
        Provider provider = new Provider(new Strategy() {
            @Override
            public List<Vacancy> getVacancies(String searchSring) {
                return null;
            }
        });
        Controller controller = new Controller(provider);
        controller.scan();

        HHStrategy hhStrategy = new HHStrategy();
        hhStrategy.getVacancies("");

    }
}
