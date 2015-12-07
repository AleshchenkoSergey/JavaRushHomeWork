package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            String filePath = "input.txt";
            OutputStream outputStream = new FileOutputStream(filePath);


            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);

            User user1 = new User();
            user1.setFirstName("Иван");
            user1.setLastName("Иванов");
            user1.setBirthDate(sdf.parse("11 03 1985"));
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);

            User user2 = new User();
            user2.setFirstName("Петр");
            user2.setLastName("Петров");
            user2.setBirthDate(sdf.parse("01 12 1980"));
            user2.setMale(false);
            user2.setCountry(User.Country.RUSSIA);

            User user3 = new User();
            user3.setFirstName("Семен");                      // commented for test null values
            user3.setLastName("Сидоров");
            user3.setBirthDate(sdf.parse("25 09 1965"));      // commented for test null values
            user3.setMale(true);
            user3.setCountry(User.Country.OTHER);



            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.users.add(user3);

            javaRush.save(outputStream);
            outputStream.flush();
            outputStream.close();

            InputStream inputStream = new FileInputStream(filePath);
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            inputStream.close();
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println(javaRush.users.size() + " <> " + loadedObject.users.size());
            for (User user : javaRush.users) {
                System.out.println(user.getLastName() + " " + user.getFirstName() + " " + user.getBirthDate() + " " +  user.isMale() + " " + user.getCountry());
            }
            System.out.println("============");
            for (User user : loadedObject.users) {
                System.out.println(user.getLastName() + " " + user.getFirstName() + " " + user.getBirthDate() + " " +  user.isMale() + " " + user.getCountry());
            }

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

            if (users.size() > 0) {
                for (User user : users) {
                    writer.println("yes");
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());
                    writer.println(format.format(user.getBirthDate()));
                    writer.println(user.isMale());
                    writer.println(user.getCountry().getDisplayedName());

                }
                writer.close();
            }

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

            while (reader.ready()) {
                if(reader.readLine().equals("yes")){
                    User user = new User();

                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    String d = reader.readLine();
                    Date date =  format.parse(d);
                    user.setBirthDate(date);
                    user.setMale(Boolean.valueOf(reader.readLine()));
                    String s = reader.readLine();
                    if (s.equals("Ukraine")) {
                        user.setCountry(User.Country.UKRAINE);
                    } else if (s.equals("Russia")) {
                        user.setCountry(User.Country.RUSSIA);
                    } else if (s.equals("Other")) {
                        user.setCountry(User.Country.OTHER);
                    }
                    users.add(user);
                }
                else{
                    break;
                }
            }
            reader.close();

        }
    }
}
