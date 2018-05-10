package net.javaconcurrency.chap6;

import java.util.Timer;
import java.util.TimerTask;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by zhangyue-k on 2018/5/8.
 * 错误的Timer行为：当TimerTask抛出未受检查的异常时，将终止定时线程
 */
public class OutOfTime {
    public static void main(String[] args) throws Exception{
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
        SECONDS.sleep(1);
        timer.schedule(new ThrowTask(), 1);
        SECONDS.sleep(5);


    }

    static class ThrowTask extends TimerTask {
        public void run() {
            throw new RuntimeException();
        }
    }
}
