package randomizedtest;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correctAList = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        correctAList.addLast(4);
        buggyAList.addLast(4);
        correctAList.addLast(5);
        buggyAList.addLast(5);
        correctAList.addLast(6);
        buggyAList.addLast(6);
        assertEquals(correctAList.size(), buggyAList.size());

        assertEquals(correctAList.removeLast(), buggyAList.removeLast());
        assertEquals(correctAList.removeLast(), buggyAList.removeLast());
        assertEquals(correctAList.removeLast(), buggyAList.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int sizeL = L.size();
                System.out.println("L size: " + sizeL);
                int sizeB = B.size();
                System.out.println("B size: " + sizeB);
                assertEquals(sizeL, sizeB);
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() > 0) {
                    int lastL = L.getLast();
                    System.out.println("getLast(" + lastL + ")");
                    int lastB = B.getLast();
                    System.out.println("getLast(" + lastB + ")");
                    assertEquals(lastL, lastB);
                }
            } else if (operationNumber == 3) {
                // removeLast
                if (L.size() > 0) {
                    int lastL = L.removeLast();
                    System.out.println("removeLast(" + lastL + ")");
                    int lastB = B.removeLast();
                    System.out.println("removeLast(" + lastB + ")");
                    assertEquals(lastL, lastB);
                }
            }
        }
    }
}
