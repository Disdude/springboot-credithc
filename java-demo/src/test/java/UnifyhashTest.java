import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hu.cong.cong on 2017/4/13.
 */
public class UnifyhashTest<T> {
    // 真实节点对应的虚拟节点数量
    private int length = 100;
    // 虚拟节点信息  
    private TreeMap<Long, T> virtualNodes;
    // 真实节点信息  
    private List<T> realNodes;

    public UnifyhashTest(List<T> realNodes) {
       this.realNodes = realNodes;
        init();
    }


    public List<T> getReal() {
        return realNodes;
    }

    /**
     * 初始化虚拟节点
     */
    private void init() {
        virtualNodes = new TreeMap<Long, T>();
        for (int i = 0; i < realNodes.size(); i++) {
            for (int j = 0; j < length; j++) {
                //虚拟节点
                virtualNodes.put(hash("aa" + i + j), realNodes.get(i));
            }
        }
    }

    /**
     * 获取一个结点
     *
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public T getNode(String key) {
        Long hashedKey = hash(key);
        // 获取大于等于给定键的一个映射
        Map.Entry en = virtualNodes.ceilingEntry(hashedKey);
        if (en == null) {
            //如果为空 分配给第一个节点
            return (T) virtualNodes.firstEntry().getValue();
        }
        System.out.println("传入的key："+hashedKey+" 所分配的节点："+(T) en.getValue());
        return (T) en.getValue();
    }

    /**
     * MurMurHash算法，是非加密HASH算法，性能很高，
     * 比传统的CRC32,MD5，SHA-1（这两个算法都是加密HASH算法，复杂度本身就很高，带来的性能上的损害也不可避免）
     * 等HASH算法要快很多，而且据说这个算法的碰撞率很低. http://murmurhash.googlepages.com/
     */
    private Long hash(String key) {
        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        int seed = 0x1234ABCD;

        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);

        long m = 0xc6a4a7935bd1e995L;
        int r = 47;

        long h = seed ^ (buf.remaining() * m);

        long k;
        while (buf.remaining() >= 8) {
            k = buf.getLong();

            k *= m;
            k ^= k >>> r;
            k *= m;

            h ^= k;
            h *= m;
        }

        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
            // for big-endian version, do this first:  
            // finish.position(8-buf.remaining());  
            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }

        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;

        buf.order(byteOrder);
        return h;
    }

    /**
     * 测试内部类
     *
     * @author shiguiming
     */
    static public class Node {
        private int name;
        private int count = 0;

        public Node() {

        }

        public Node(int i) {
            this.name = i;
        }

        public int getName() {
            return name;
        }

        public void setName(int name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        // 同步方法，防止并发  
        synchronized public void inc() {
            count++;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name=" + name +
                    ", count=" + count +
                    '}';
        }
    }

    /**
     * 测试方法
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        //真实节点
        List<Node> ndList = new ArrayList<Node>();
        int i = 0;
        while (true) {
            ndList.add(new Node(i));
            if (i++ == 9)
                break;
        }

        final UnifyhashTest<Node> sh = new UnifyhashTest<Node>(ndList);
        //线程池
        ExecutorService es = Executors.newCachedThreadPool();
        //锁存器 同步辅助工具
        final CountDownLatch cdl = new CountDownLatch(10);
        // 10个线程
        for (int j = 0; j < 10; j++) {
            es.execute(new Runnable() {

                @Override
                public void run() {
                    //每个线程匹配5次节点
                    for (int k = 0; k < 5; k++) {
                        //获取节点 同步方法
                        sh.getNode(String.valueOf(Math.random())).inc();
                    }
                    //递减锁存器的计数，如果计数到达零，则释放所有等待的线程。
                    cdl.countDown();
                }
            });
        }

        // 使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断。
        cdl.await();
        List<Node> nodeList = sh.getReal();
        for (Node node : nodeList) {
            System.out.println("node" + node.getName() + ":" + node.getCount());
        }

    }
}  
