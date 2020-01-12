package ch.hegarc.ig.sda;

import ch.hegarc.ig.sda.test.AbstractTest;
import ch.hegarc.ig.sda.test.TestHashSet;
import ch.hegarc.ig.sda.test.TestLinkedList;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        AbstractTest testHashSet = new TestHashSet();
        AbstractTest testLinkedList = new TestLinkedList();
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("---------- HashSet ----------");
        System.out.println("-----------------------------");
        System.out.println();
        testHashSet.run();

        System.out.println();
        System.out.println("----------------------------");
        System.out.println("-------- LinkedList --------");
        System.out.println("----------------------------");
        System.out.println();
        testLinkedList.run();

    }
}