package service;

import com.github.ltsopensource.core.json.JSON;
import com.hc.henghuirong.server.common.bytecode.Proxy;
import com.hc.henghuirong.server.common.bytecode.Wrapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wenzhiwei on 17-5-3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ProxyTest {


    interface HelloService { String hello(String ...str); }

    static class HelloServiceImpl implements HelloService {

        @Override
        public String hello(String ...str) {
            return JSON.toJSONString(str);
        }
    }

    @Test
    public void testClassProxy() throws NoSuchMethodException, InvocationTargetException {
        HelloService helloService = (HelloService) Proxy.getProxy(HelloService.class).newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(this,args);
            }
        });
        Assert.assertEquals("wocc",helloService.hello("wocc"));
        Wrapper wrapper = Wrapper.getWrapper(HelloService.class);
        HelloService helloService1 = new HelloServiceImpl();
        String res = (String) wrapper.invokeMethod(helloService1,wrapper.getDeclaredMethodNames()[0],new Class<?>[]{String.class},new Object[]{"fasfsdafa"});
        Assert.assertEquals("fasfsdafa",res);
    }


}
