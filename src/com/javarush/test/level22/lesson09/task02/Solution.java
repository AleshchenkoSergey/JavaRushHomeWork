package com.javarush.test.level22.lesson09.task02;

import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static void main (String[] args) throws Exception{
        Map<String, String> map = new LinkedHashMap<>();
//        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanich");
        map.put("country", "Rashka");
        map.put("city", "Moscow");
        map.put("city3", null);
        map.put("city4", null);
        map.put("city5", null);
        System.out.println(getCondition(map));
        System.out.println(map.size());

    }


    public static StringBuilder getCondition(Map<String, String> params) {
        if (params.isEmpty()) {
            return new StringBuilder();
        }

        int count = 0;
        boolean isLast = false;
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, String> pair : params.entrySet()) {
            count++;
            String key = pair.getKey();
            String value = pair.getValue();

            if (!(value == null)) {
                if (stringBuilder.toString().equals("")) {
                    stringBuilder.append(pair.getKey()).append(" = '").append(pair.getValue()).append("'");
                } else {
                    stringBuilder.append(" and ").append(pair.getKey()).append(" = '").append(pair.getValue()).append("'");
                }


            }
        }
        return stringBuilder;
    }
}
