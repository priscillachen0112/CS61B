package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList Ns = new AList();
        for (int i = 1; i <= 128; i *= 2) {
            Ns.addLast(i * 1000);
        }
        AList times = new AList();
        AList opCounts = new AList();
        for (int i = 0; i < Ns.size(); i++) {
            Stopwatch sw = new Stopwatch();
            AList testList = new AList();
            int n = (int) Ns.get(i);
            int op = 0;
            for (int j = 0; j < n; j++) {
                testList.addLast(1);
                op += 1;
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            opCounts.addLast(op);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
