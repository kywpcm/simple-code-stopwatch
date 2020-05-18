package tts;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Simple stopwatch for code.
 * A class that can measure elapsed time in code in a simple way.
 * <br><br>
 * Created by Max Kwon on 2020 2Q
 */
public class StopWatch {

    private AtomicLong time = new AtomicLong(0L);

    /**
     * Start the stopwatch. Time is measured from the time this method is called.
     */
    public void start() {
        time.set(System.nanoTime());
    }

    /**
     * Get the time(ms) that has passed since start. Time is not reset.
     * @return time(ms) that has passed since start. If split without starting, -1 is returned.
     */
    public long split() {
        if (time.get() <= 0) {
            return -1;
        }

        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - time.get());
    }

    /**
     * Get the duration time(ms) between start and end. Time is reset.
     *
     * @return Total duration time(ms). If stop without starting, -1 is returned.
     */
    public long stop() {
        if (time.get() <= 0) {
            return -1;
        }

        long duration = System.nanoTime() - time.get();
        time.set(0L);

        return TimeUnit.NANOSECONDS.toMillis(duration);
    }
}
