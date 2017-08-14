package service;

import com.hc.henghuirong.server.App;
import com.hc.henghuirong.server.service.IdService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.google.common.base.Stopwatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by Wu.Kang on 2017/4/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class IdTest {
    @Autowired
    IdService idService;

    @Test
    public void testIdGeneration() throws Exception
    {
        Stopwatch stopWatch = Stopwatch.createStarted();
        for(int i = 0; i < 100; ++ i) {
            System.out.println(idService.getId());
        }
        System.out.println(stopWatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
//        final CyclicBarrier cdl = new CyclicBarrier(100);
//        final CyclicBarrier cdl2 = new CyclicBarrier(101);
//
//        Stopwatch stopWatch = Stopwatch.createStarted();
//        for(int i = 0; i < 100; i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        cdl.await();
//                        System.out.println(idService.getId());
//                        cdl2.await();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (BrokenBarrierException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }
//        cdl2.await();
//        System.out.println(stopWatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }
}
