package ch.hegarc.ig.sda;

import ch.hegarc.ig.sda.app.AbstractPostTalk;
import ch.hegarc.ig.sda.app.PostTalkHashSet;
import ch.hegarc.ig.sda.app.PostTalkLinkedList;

public class Main {

    public static void main(String[] args) {

        AbstractPostTalk postTalkHashSet = new PostTalkHashSet();
        AbstractPostTalk postTalkLinkedList = new PostTalkLinkedList();

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("---------- HashSet ----------");
        System.out.println("-----------------------------");
        System.out.println();
        postTalkHashSet.run();

        System.out.println();
        System.out.println("----------------------------");
        System.out.println("-------- LinkedList --------");
        System.out.println("----------------------------");
        System.out.println();
        postTalkLinkedList.run();

    }
}