package com.project;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyMappedInterceptor implements MyHandlerInterceptor{
    boolean before;
    public MyMappedInterceptor(boolean before){
        this.before=before;
    }
    @Override
    public boolean beforeMethod() {
        System.out.println("前置方法执行了");
        return before;
    }
}

interface MyHandlerInterceptor {

    default boolean beforeMethod() {
        return true;
    }

    default void afterMethod() {
        System.out.println("后置方法执行了");
    }
}

interface MyAbstractHandler {
    void invokeMethod();
}

class MyHandler implements MyAbstractHandler {
    String path;
    String msg;

    MyHandler(String path, String msg) {
        this.path = path;
        this.msg = msg;
    }

    void method() {
        System.out.println("我是method方法" + msg);
    }

    ;

    @Override
    public void invokeMethod() {
        method();
    }
}

interface MyHandlerMapping {
    MyHandlerExecutionChain getHandler(MyHttpServletRequest myHttpServletRequest);
}

class MyRequestMappingHandlerMapping extends MyAbstractHandlerMapping {
}

abstract class MyAbstractHandlerMapping implements MyHandlerMapping {
    private final List<MyHandlerInterceptor> adaptedInterceptors = new ArrayList();

    public MyHandlerExecutionChain getHandler(MyHttpServletRequest myHttpServletRequest) {
        //模拟假数据
        MyAbstractHandler myhandler = new MyHandler("/resouce", "hello");
        MyHandlerExecutionChain chain = new MyHandlerExecutionChain(myhandler);
        Iterator<MyHandlerInterceptor> it = adaptedInterceptors.iterator();
        while (it.hasNext()) {
            chain.addInterceptor(it.next());
        }
        return chain;
    }

    protected void initInterceptors() {
        this.adaptedInterceptors.add(new MyMappedInterceptor(false));
    }
}

class MyHandlerExecutionChain {
    private List<MyHandlerInterceptor> interceptorList = new ArrayList<>();
    private final MyAbstractHandler handler;

    public MyHandlerExecutionChain(MyAbstractHandler handler) {
        this.handler = handler;
    }

    public void addInterceptor(MyHandlerInterceptor myInterceptor) {
        this.interceptorList.add(myInterceptor);
    }

    MyAbstractHandler getHandler() {
        return this.handler;
    }

    public boolean applyPreHandle() {
        boolean flag = true;
        Iterator var2 = this.interceptorList.iterator();

        while (var2.hasNext()) {
            boolean result = ((MyHandlerInterceptor) var2.next()).beforeMethod();
            flag = flag && result;
            if (!flag)
                return false;
        }
        return flag;
    }

    public void applyPostHandle() {
        Iterator var2 = this.interceptorList.iterator();

        while (var2.hasNext()) {
            ((MyHandlerInterceptor) var2.next()).afterMethod();
        }
    }
}

class MyHttpServletRequest {
    private String lookupPath;
}

class MyDispatcherServlet {
    private List<MyHandlerMapping> myhandlerMappings = new ArrayList<>();

    public void initHandlerMappings() {
        //虚假数据
        MyRequestMappingHandlerMapping myRequestMappingHandlerMapping = new MyRequestMappingHandlerMapping();
        myRequestMappingHandlerMapping.initInterceptors();
        this.myhandlerMappings.add(myRequestMappingHandlerMapping);
    }

    public MyHandlerExecutionChain getHandler(MyHttpServletRequest myHttpServletRequest) {
        //遍历myhandlerMappings
        Iterator var2 = this.myhandlerMappings.iterator();

        while (var2.hasNext()) {
            MyHandlerMapping mapping = (MyHandlerMapping) var2.next();
            MyHandlerExecutionChain handler = mapping.getHandler(myHttpServletRequest);
            if (handler != null) {
                return handler;
            }
        }
        return null;
    }

    void doDispatch(MyHttpServletRequest myHttpServletRequest) {
        MyHandlerExecutionChain myHandlerExecutionChain = null;
        myHandlerExecutionChain = this.getHandler(myHttpServletRequest);
        if (!myHandlerExecutionChain.applyPreHandle()) {
            return;
        }
        myHandlerExecutionChain.getHandler().invokeMethod();
        myHandlerExecutionChain.applyPostHandle();
    }
}

@SpringBootTest(classes ={SystemApplication.class})
public class DispatcherServletTest {
    @Test
    public void method() {
        MyDispatcherServlet myDispatcherServlet = new MyDispatcherServlet();
        myDispatcherServlet.initHandlerMappings();
        myDispatcherServlet.doDispatch(new MyHttpServletRequest());
    }
}