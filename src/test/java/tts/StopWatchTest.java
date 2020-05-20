package tts;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * Created by Max Kwon
 */
public class StopWatchTest {

    @Test
    public void start() {
        StopWatch sw = new StopWatch();
        sw.start();
    }

    @Test
    public void split() throws InterruptedException {
        StopWatch sw = new StopWatch();

        sw.start();
        Thread.sleep(1000);
        double dur1 = sw.split();
        System.out.println(dur1);
//        assertThat(dur1).isEqualTo(1000);

        Thread.sleep(3000);
        double dur2 = sw.split();
//        assertThat(dur2).isEqualTo(3000);
        System.out.println(dur2);
    }

    @Test
    public void stop() throws InterruptedException {
        StopWatch sw = new StopWatch();
        double ret = sw.stop();
        assertThat(ret).isEqualTo(-1);

        sw.start();
        Thread.sleep(3000);
        ret = sw.stop();
//        assertThat(ret).isEqualTo(3000);
        System.out.println(ret);
    }

    @Test
    public void test() throws InterruptedException {
        StopWatch sw = new StopWatch();
        assertThat(sw.split()).isEqualTo(-1);
        assertThat(sw.stop()).isEqualTo(-1);

        sw.start();

        Thread.sleep(2000);
        System.out.println(sw.split());
        System.out.println(sw.split(StopWatchUnit.NANOSECONDS));
        System.out.println(sw.split(StopWatchUnit.MICROSECONDS));
        System.out.println(sw.split(StopWatchUnit.MILLISECONDS));
        System.out.println(sw.split(StopWatchUnit.MINUTES));
        System.out.println(sw.split(StopWatchUnit.HOURS));
        System.out.println(sw.split(StopWatchUnit.DAYS));

        System.out.println("========================");

        Thread.sleep(3000);
        System.out.println(sw.stop());
//        System.out.println(sw.stop(StopWatchUnit.MILLISECONDS));
    }
}
