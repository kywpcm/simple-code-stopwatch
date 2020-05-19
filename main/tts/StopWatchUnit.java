package tts;

import java.util.concurrent.TimeUnit;

/**
 * StopWatch time unit class based on TimeUnit
 * <br><br>
 * Created by Max Kwon on 2020 2Q
 */
public enum StopWatchUnit {

    NANOSECONDS() {
        @Override
        long getTime(long time) {
            return time;
        }
    },
    MICROSECONDS() {
        @Override
        long getTime(long time) {
            return TimeUnit.NANOSECONDS.toMicros(time);
        }
    },
    MILLISECONDS() {
        @Override
        long getTime(long time) {
            return TimeUnit.NANOSECONDS.toMillis(time);
        }
    },
    MINUTES() {
        @Override
        long getTime(long time) {
            return TimeUnit.NANOSECONDS.toMinutes(time);
        }
    },
    HOURS() {
        @Override
        long getTime(long time) {
            return TimeUnit.NANOSECONDS.toHours(time);
        }
    },
    DAYS() {
        @Override
        long getTime(long time) {
            return TimeUnit.NANOSECONDS.toDays(time);
        }
    };

    abstract long getTime(long time);
}
