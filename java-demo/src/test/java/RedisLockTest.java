import com.hc.henghuirong.server.App;
import com.hc.henghuirong.server.redis.IBillIdentify;
import com.hc.henghuirong.server.redis.RedisBillLockHandler;
import com.hc.henghuirong.server.redis.RedisLocked;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hu.cong.cong on 2017/4/14.
 */
//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = App.class)
@WebAppConfiguration
@Transactional
public class RedisLockTest {

    private static final Logger logger = LoggerFactory.getLogger(RedisLockTest.class);

    @Autowired
    private RedisBillLockHandler redisBillLockHandler;

    @Test
    public void testTwo() {
        Jedis jedis = new Jedis("10.100.19.228");
        jedis.auth("caifu");
        System.out.println("Connection to server sucessfully");
        // 查看服务是否运行
        System.out.println("Server is running: " + jedis.ping());
    }
    @Test
    public void test01() throws InterruptedException {
        //线程池
        ExecutorService es = Executors.newCachedThreadPool();
        //锁存器 同步辅助工具
        final CountDownLatch cdl = new CountDownLatch(50);
        // 10个线程
        for (int j = 0; j < 50; j++) {
            es.execute(new Runnable() {

                @Override
                public void run() {
                    RedisLocked redisLocked = redisBillLockHandler.tryLock(new IBillIdentify("hanWei"));
                    // redisBillLockHandler.lock(new IBillIdentify("hanWei"));

                    if (redisLocked.isLocked()){

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            logger.error(e.getMessage(),e);
                        }
                        redisBillLockHandler.unLock(new IBillIdentify("hanWei"),redisLocked);
                    }
                    cdl.countDown();
                }
            });
        }
        // 使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断。
        cdl.await();
        System.out.println("结束。。。。。。");

    }
}
