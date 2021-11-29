package com.project;

import jdk.nashorn.internal.ir.ReturnNode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//定义一个functionalinterface（函数式接口）
interface MethodInvoker {
    void invokeMethod();
}


//httprequest类
class MyHttpRequest {
    public MyHttpRequest(MethodInvoker methodInvoker) {
        this.methodInvoker = methodInvoker;
    }

    MethodInvoker methodInvoker;

    public MethodInvoker getMethodInvoker() {
        return this.methodInvoker;
    }
}

//MyInterceptor类
class MyInterceptor {
    boolean beforeResult;

    public MyInterceptor(boolean b) {
        this.beforeResult = b;
    }

    public boolean before() {
        System.out.println("前置方法执行了");
        return beforeResult;
    }

    public void after() {
        System.out.println("后置方法执行了");
    }
}

//MyExecutionChain类
class MyExecutionChain {
    private List<MyInterceptor> interceptorList=new ArrayList<>();
    private MethodInvoker methodInvoker;

    public MyExecutionChain(MethodInvoker methodInvoker) {
        //初始化interceptorList
        this.interceptorList.add(new MyInterceptor(true));
        this.methodInvoker = methodInvoker;
    }

    public void invoke() {
        this.methodInvoker.invokeMethod();
    }

    public boolean preHandle() {
        boolean flag = true;
        Iterator<MyInterceptor> iterator = this.interceptorList.iterator();
        while (iterator.hasNext()) {
            flag = flag && iterator.next().before();
            if (!flag)
                return flag;
        }
        return flag;
    }

    public void postHandle() {
        boolean flag = true;
        Iterator<MyInterceptor> iterator = this.interceptorList.iterator();
        while (iterator.hasNext()) {
            iterator.next().after();
        }
    }
}

//MyHandlerMapping类
class MyHandlerMapping {
    public MyHandlerMapping() {

    }

    public MyExecutionChain getHandler(MyHttpRequest myHttpRequest) {
        //模拟假数据
        return new MyExecutionChain(myHttpRequest.getMethodInvoker());
    }
}

class MyDispatcherServlet {
    private List<MyHandlerMapping> handlerMappings = new ArrayList<>();

    public MyDispatcherServlet( ) {
        //初始化handlerMAppings
        this.handlerMappings.add(new MyHandlerMapping());
    }

    public MyExecutionChain getHandler(MyHttpRequest myHttpRequest) {
        //循环遍历handlermappings得出结果
        Iterator<MyHandlerMapping> iterator = handlerMappings.iterator();
        while (iterator.hasNext()) {
            MyExecutionChain handler = iterator.next().getHandler(myHttpRequest);
            if (handler != null) {
                return handler;
            }
        }
        return null;
    }
    public void doDispatch(MyHttpRequest myHttpRequest){
        MyExecutionChain handler=this.getHandler(myHttpRequest);
        if(handler.preHandle()){
            handler.invoke();
            handler.postHandle();
        }else{
            return;
        }
    }
}


@SpringBootTest
public class TestDispatcherServlet {
    @Test
    public void method() {

        MethodInvoker methodInvoker = () -> {
            controllerMethod();
        };
        MyHttpRequest myHttpRequest=new MyHttpRequest(methodInvoker);
        MyDispatcherServlet myDispatcherServlet=new MyDispatcherServlet();
        myDispatcherServlet.doDispatch(myHttpRequest);

        System.out.println(Character.BYTES);
    }

    void controllerMethod() {
        System.out.println("内部方法执行了");
    }
}

