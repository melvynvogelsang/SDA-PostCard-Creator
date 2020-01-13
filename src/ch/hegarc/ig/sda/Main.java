package ch.hegarc.ig.sda;

import ch.hegarc.ig.sda.app.AbstractPostTalk;
import ch.hegarc.ig.sda.app.PostTalkHashSet;
import ch.hegarc.ig.sda.app.PostTalkLinkedList;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        AbstractPostTalk testHashSet = new PostTalkHashSet();
        AbstractPostTalk testLinkedList = new PostTalkLinkedList();
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