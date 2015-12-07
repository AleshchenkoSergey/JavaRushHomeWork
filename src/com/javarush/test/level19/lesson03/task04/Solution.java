package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {

            Person person = null;

            if(scanner.hasNext())
            {
                scanner.useDelimiter("\\s+");
                String lastname = scanner.next();
                String firstName = scanner.next();
                String middleName = scanner.next();
                int day = scanner.nextInt();
                int month = scanner.nextInt();
                int year = scanner.nextInt();

                Calendar calendar = new GregorianCalendar(year, --month, day);
                person = new Person(firstName, middleName, lastname, calendar.getTime());
            }
            return person;

        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }


        public static void main(String[] args) throws IOException {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            PersonScannerAdapter adapter = new PersonScannerAdapter(scanner);

            System.out.println(adapter.read());
            System.out.println(adapter.read());
            adapter.close();
        }
    }
}
