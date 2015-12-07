package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    Solution() {}
    Solution(int i) {}
    Solution(int i, int j) {}

    public Solution(int i, double j) {}
    public Solution(double j, int i) {}
    public Solution(int i, short j) {}

    private Solution(char ch) {}
    private Solution(char ch, int i) {}
    private Solution(int i, char ch) {}

    protected Solution(long l) {}
    protected Solution(long l, int i) {}
    protected Solution(int i, long l) {}
}

