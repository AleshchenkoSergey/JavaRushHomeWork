package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Admin on 10.06.2015.
 */
public class Hippodrome {
    static ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i < 101; i++) {
            move();
            print();
            Thread.sleep(500);
        }
    }

    public void move() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }
    }

    public void print() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        Horse winner = this.horses.get(0);

        for(int i = 1; i < this.horses.size(); i++){
            if(winner.getDistance() < this.horses.get(i).getDistance())
                winner = this.getHorses().get(i);
        }

        return winner;


    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }


    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();

        horses.add(new Horse("horse1", 3, 0));
        horses.add(new Horse("horse2", 3, 0));
        horses.add(new Horse("horse3", 3, 0));

        game.run();

        game.printWinner();
    }
}
