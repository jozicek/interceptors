package jozinko.interceptors.boundary;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.time.Duration;
import java.time.LocalTime;

@Interceptor
@Measure
@Priority(1000)
public class MeasureInterceptor {

    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        System.out.println("Measure START");
        LocalTime start = LocalTime.now();
        Object result = context.proceed();
        LocalTime end = LocalTime.now();
        System.out.println("Execution time: " + Duration.between(start, end).getSeconds() + "s");
        return result;
    }

}
