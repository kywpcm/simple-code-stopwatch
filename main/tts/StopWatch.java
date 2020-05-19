package tts;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/*
Copyright [2020] [Total service & Information System Co.]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

/**
 * Simple stopwatch for code.
 * A class that can measure elapsed time in code in a simple way.
 * <br><br>
 * Created by Max Kwon
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
