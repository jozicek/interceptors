package jozinko.interceptors.boundary;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Log
@Priority(2000)
public class LoggingInterceptor {


    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        System.out.println("START " + context.getMethod().getName());
        Object result = context.proceed();
        System.out.println("END " + context.getMethod().getName());
        return result;
    }


}
