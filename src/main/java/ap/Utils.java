package ap;

public class Utils {
    public static double timeit(NoArgFunction f) {
        double sumTime = 0;
        for (int i = 0; i < 20; i++) {
            double startTime = System.nanoTime();
            f.op();
            double endTime = System.nanoTime();
            double totalTime = (endTime - startTime) / 1000000;
            sumTime += totalTime;
        }
        return sumTime / 20.0;
    }

    public interface NoArgFunction {
        public void op();
    }
}
