package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sergey on 23.11.15.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    private List<Advertisement> recursiveMethod(List<Advertisement> list, List<Advertisement> temp,
                                                int index, List<Advertisement> optimalList,
                                                double optimalValue) {

        if (index > list.size())
            return optimalList;


        double thisValue = 0;
        int allTimes = 0;
        int count = 0;

        for (Advertisement ad : temp) {
            thisValue = thisValue + 1000 * ad.getAmountPerOneDisplaying();
            allTimes = allTimes + (ad.getDuration() / 60);
            count++;
        }

        if (allTimes > timeSeconds) {
            temp.clear();
            return optimalList;
        }

        if (thisValue == optimalValue && thisValue > 0) {
            int allTimeOptimal = 0;
            int countOptimal = 0;

            for (Advertisement ad : optimalList) {
                allTimeOptimal = allTimeOptimal + ad.getDuration();
                countOptimal++;
            }

            if (allTimeOptimal == allTimes) {
                if (count < countOptimal) {
                    return temp;
                } else {
                    return optimalList;
                }
            }

            if (allTimeOptimal < allTimes) {
                return temp;
            } else {
                return optimalList;
            }

        }

        if (thisValue > optimalValue) {
            optimalValue = thisValue;
            optimalList = new ArrayList<>(temp);
        }

        if (allTimes < timeSeconds && list.size() - 1 >= index && !temp.contains(list.get(index))) {
            optimalList = recursiveMethod(list, temp, index + 1, optimalList, optimalValue);

            if (list.get(index).getDuration() / 60 <= timeSeconds) {
                temp.add(list.get(index));
                optimalList = recursiveMethod(list, temp, index + 1, optimalList, optimalValue);
            }
        }



        return optimalList;
    }



    public void processVideos() throws NoVideoAvailableException {
        // Пункт 2.3: если нет рекламных видео, которые можно показать посетителю, бросаем исключение.
        if (storage.list().size() == 0||storage.list().isEmpty())
        {
            throw new NoVideoAvailableException();
        }
        //пункт 5, добавляем в список доступных видео, только если
        // количество показов у рекламного ролика - положительное число
        ArrayList<Advertisement> inputVideos = new ArrayList<>();
        for (Advertisement ad : storage.list())
        {
            if (ad.getHits() > 0)
            {
                inputVideos.add(ad);
            }
        }
        //сортировка исходных данных
        Collections.sort(inputVideos, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                if (o1.getDuration()==o2.getDuration()){
                    return 0;
                }
                if (o1.getDuration()>o2.getDuration()){
                    return 1;
                }else
                {
                    return -1;
                }
            }
        });
        List<Advertisement> list = recursiveMethod(inputVideos, new ArrayList<Advertisement>(), 0, new ArrayList<Advertisement>(), 0);
        if (list.size() == 0||list.isEmpty())
        {
            throw new NoVideoAvailableException();
        }
        // пункт 6, сортировка перед показом видео (вызывает подозрения,
        // но по идее она должна была проверится на предыдущем задании)
        //пробовал несколько других вариантов сортировки - не помогло
        Collections.sort(list, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                if (o1.getAmountPerOneDisplaying() != o2.getAmountPerOneDisplaying()) {
                    if (o1.getAmountPerOneDisplaying() > o2.getAmountPerOneDisplaying()) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    if (1000 * o1.getAmountPerOneDisplaying() / o1.getDuration() == 1000 * o2.getAmountPerOneDisplaying() / o2.getDuration()) {
                        return 0;
                    }
                    if (1000 * o1.getAmountPerOneDisplaying() / o1.getDuration() > 1000 * o2.getAmountPerOneDisplaying() / o2.getDuration()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });

        for (Advertisement advertisement : list) {
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + 1000 * advertisement.getAmountPerOneDisplaying() / advertisement.getDuration());

            advertisement.revalidate();
        }
    }
}
