package com.javarush.test.level31.lesson02.home01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла,
который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1.
Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    private static File path;


    public static void main(String[] args) throws IOException {
        String stringPath = args[0];
        String fileName = args[1];

//        String stringPath = "/home/sergey/Загрузки/1";
//        String fileName = "/home/sergey/Загрузки/1/resultFileAbsolutePath.txt";

        path = new File(stringPath);
        File resultFileAbsolutePath = new File(fileName);
        List<File> filesList = new ArrayList<>();

        for (File file : filesList) {
            if (file.length() > 50)
                file.delete();

        }

        Collections.sort(filesList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (File file : filesList) {
            if (file.isDirectory())
                file.delete();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(resultFileAbsolutePath);
        for (int i = 0; i < filesList.size(); i++) {
            if (filesList.get(i).exists() && !filesList.get(i).isDirectory()) {
                FileInputStream fileInputStream = new FileInputStream(filesList.get(i));
                byte[] buffer = new byte[fileInputStream.available()];

                fileInputStream.read(buffer);
                fileOutputStream.write(buffer);

                if (i != filesList.size() - 1)
                    fileOutputStream.write('\n');

            }
        }

        String newName = resultFileAbsolutePath.getParent() + "/allFilesContent.txt";
        resultFileAbsolutePath.renameTo(new File(newName));

    }

    public static void removeEmptyFolders(String root) {

    }

    public static void removeEmptyParents(File parentDirectory) {

    }

    public static void writeFileContent(File resultFileAbsolutePath, List<File> files) {

    }

    public static List<File> getFileTree(String root, File resultFileAbsolutePath) {
        return null;
    }
}
