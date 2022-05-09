package com.company;

public class Main {

    public static void main(String[] args) {
        int counter1 = 0;
        int counter2 = 0;

        BTree t1 = new BTree(3);
        BTree t2 = new BTree(3);
        long timeToInsert1 = System.nanoTime();
        while(counter1 < 10000){
            t1.insert(counter1);
            counter1++;
            counter2++;
        }
        System.out.println("Time to insert in B-tree with consecutive elements: " +
                (System.nanoTime() - timeToInsert1) + "ns");

        long timeToInsert2 = System.nanoTime();
        counter1 = 0;
        while(counter1 < 10000){
            t2.insert((int) (Math.random()* 1000000));
            counter1++;
        }
        System.out.println("Time to insert in B-tree with random elements: " +
                (System.nanoTime() - timeToInsert2) + "ns");



        long toSearch1 = System.nanoTime();
        counter1 =  0;
        while(counter1 < 10000){
            t1.Contain((int) (Math.random() * 1000000));
            counter1++;
        }
        System.out.println("Time to search in B-tree with consecutive elements: " +
                (System.nanoTime() - toSearch1) + "ns");

        long toSearch2 = System.nanoTime();
        counter1 =  0;
        while(counter1 < 10000){
            t2.Contain((int) (Math.random() * 1000000));
            counter1++;
        }
        System.out.println("Time to search in B-tree with random elements: " +
                (System.nanoTime() - toSearch2) + "ns");

        long toDelete1 = System.nanoTime();
        while(counter2 > 0){
            t1.remove((int) (Math.random() * 1000000));
            counter2--;
        }
        System.out.println("Time to delete in B-tree with consecutive elements: " +
                (System.nanoTime() - toDelete1) + "ns");


        long toDelete2 = System.nanoTime();
        while(counter1 > 0){
            t2.remove((int) (Math.random() * 1000000));
            counter1--;
        }
        System.out.println("Time to delete in B-tree with random elements: " +
                (System.nanoTime() - toDelete2) + "ns");



    }
}
