import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class AOPProxyFactory{
    public static Object createProxy(Object target,MethodBeforeAdvice mbAdvice){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler(){//拦截器
                    public Object invoke()(Object proxy,Method m,Object[] args) throws Throwable{
                        mbAdvice.before(m,args,target);//方法执行前增强
                        return m.invoke(target,args);//方法调用
                    }
                });
    }
//    然后定义before增强
    MethodBeforeAdvice mbAdvice =new MethodBeforeAdvice(){
        public before(Method m,Object[] args,Object target){
            do something;
        }
    };