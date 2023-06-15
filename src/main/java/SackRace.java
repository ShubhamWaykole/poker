import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SackRace {
    public static void main(String[] args) {
        System.out.println(checkIfMeet(5, 4, 7, 8));
        System.out.println(checkIfMeet(6, 4, 6, 8));
    }

    static boolean checkIfMeet(int startA, int startB, int stepsA, int stepsB) {
        int i = 0;
        while(true) {
            int posA = startA+(i*stepsA);
            int posB = startB+(i*stepsB);
            if(posA > posB && stepsA > stepsB)
                return false;
            else if(posA < posB && stepsA < stepsB)
                return false;
            else if(startA+(i*stepsA) == startB+(i*stepsB)) {
                System.out.print("i=" + i + " -> ");
                System.out.print(startA+(i*stepsA) + " ");
                System.out.println(startB+(i*stepsB));
                return true;
            }
            i++;
        }
    }
}
