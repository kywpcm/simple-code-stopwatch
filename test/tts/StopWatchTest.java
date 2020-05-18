package tts;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Created by Kwon Youngwoo on 2020.05.18 5:39 오후
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
        long dur1 = sw.split();
        System.out.println(dur1);
//        assertThat(dur1).isEqualTo(1000);

        Thread.sleep(3000);
        long dur2 = sw.split();
//        assertThat(dur2).isEqualTo(3000);
        System.out.println(dur2);
    }

    @Test
    public void stop() throws InterruptedException {
        StopWatch sw = new StopWatch();
        long ret = sw.stop();
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
        System.out.println(sw.split());
        System.out.println(sw.split());
        System.out.println(sw.split());
        Thread.sleep(1500);
        System.out.println(sw.split());
        Thread.sleep(1000);
        System.out.println(sw.stop());

        sw.start();
        System.out.println(sw.split());
        System.out.println(sw.split());
        System.out.println(sw.split());
        Thread.sleep(2200);
        System.out.println(sw.split());
        Thread.sleep(4700);
        System.out.println(sw.split());
        System.out.println(sw.split());
        System.out.println(sw.split());
        Thread.sleep(100);
        System.out.println(sw.stop());
        System.out.println(sw.stop());
    }
}
