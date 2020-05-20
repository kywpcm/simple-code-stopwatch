package tts;

import java.util.concurrent.TimeUnit;

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
 * StopWatch time unit class based on TimeUnit
 * <br><br>
 * Created by Max Kwon
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
