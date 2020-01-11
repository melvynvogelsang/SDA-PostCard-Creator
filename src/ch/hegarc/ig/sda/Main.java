package ch.hegarc.ig.sda;

import ch.hegarc.ig.sda.app.TestHashSet;
import ch.hegarc.ig.sda.app.TestLinkedList;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        TestHashSet testHashSet = new TestHashSet();
        TestLinkedList testLinkedList = new TestLinkedList();

        testHashSet.run();
        testLinkedList.run();

    }
}