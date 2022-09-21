package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        for (int i = 1; i <= 128; i *= 2) {
            Ns.addLast(i * 1000);
        }
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        for (int i = 0; i < Ns.size(); i++) {
            SLList<Integer> testList = new SLList<>();
            int n = Ns.get(i);
            for (int j = 0; j < n - 1; j++) {
                testList.addLast(1);
            }
            Stopwatch sw = new Stopwatch();
            int M = 10000;
            int op = 0;
            for (int j = 0; j < M; j++) {
                testList.getLast();
                op += 1;
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            opCounts.addLast(op);
        }
        printTimingTable(Ns, times, opCounts);
    }

}
