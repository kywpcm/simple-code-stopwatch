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
     * Get the time(sec) that has passed since start. Time is not reset.
     *
     * @return time(sec) that has passed since start. If split without starting, -1.0 is returned.
     */
    public double split() {
        if (isInvalidTime())
            return -1.0;

        long durationTime = System.nanoTime() - time.get();

        return TimeUnit.NANOSECONDS.toMillis(durationTime) / 1000.0;
    }

    /**
     * Get the time by unit that has passed since start. Time is not reset.
     *
     * @param unit StopWatchUnit.NANOSECONDS, StopWatchUnit.MICROSECONDS, StopWatchUnit.MILLISECONDS, ...
     * @return time by unit that has passed since start. If split without starting, -1 is returned.
     */
    public long split(StopWatchUnit unit) {
        if (isInvalidTime())
            return -1;

        long durationTime = System.nanoTime() - time.get();

        return unit.getTime(durationTime);
    }

    /**
     * Get the duration time(sec) between start and end. Time is reset.
     *
     * @return Total duration time(sec). If stop without starting, -1.0 is returned.
     */
    public double stop() {
        if (isInvalidTime())
            return -1.0;

        long durationTime = System.nanoTime() - time.get();
        time.set(0L);

        return TimeUnit.NANOSECONDS.toMillis(durationTime) / 1000.0;
    }

    /**
     * Get the duration time by unit between start and end. Time is reset.
     *
     * @param unit StopWatchUnit.NANOSECONDS, StopWatchUnit.MICROSECONDS, StopWatchUnit.MILLISECONDS, ...
     * @return Total duration time by unit. If stop without starting, -1 is returned.
     */
    public long stop(StopWatchUnit unit) {
        if (isInvalidTime())
            return -1;

        long durationTime = System.nanoTime() - time.get();
        time.set(0L);

        return unit.getTime(durationTime);
    }

    private boolean isInvalidTime() {
        return time.get() <= 0;
    }
}
