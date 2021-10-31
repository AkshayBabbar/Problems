package corejava.oops;

import java.util.*;

/**
 * Java Program to demonstrate difference between PriorityQueue
 * and TreeSet.
 *
 * @author WINDOWS 8
 */
public class App {

    public static void main(String[] args) {

        Set setOfNumbers = new TreeSet<>();
        Queue queueOfNumbers = new PriorityQueue<>();

        // inserting elements into TreeSet and PriorityQueue
        setOfNumbers.add(202);
        setOfNumbers.add(102);
        setOfNumbers.add(503);
        setOfNumbers.add(33);

        queueOfNumbers.add(202);
        queueOfNumbers.add(102);
        queueOfNumbers.add(503);
        queueOfNumbers.add(33);

        // Iterating over TreeSet
        System.out.println("Iterating over TreeSet in Java");
        Iterator itr = setOfNumbers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Iterating over PriorityQueue
        System.out.println("Iterating over PriorityQueue in Java");
        itr = queueOfNumbers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Consuming numbers using from head in PriorityQueue
        System.out.println("polling a PriorityQueue in Java");
        while (!queueOfNumbers.isEmpty()) {
            System.out.println(queueOfNumbers.poll());
        }
    }


}