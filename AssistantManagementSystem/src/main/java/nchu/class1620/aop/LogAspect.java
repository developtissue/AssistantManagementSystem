package nchu.class1620.aop;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	//AOP是方法级别
	
	@Pointcut("execution( * nchu.class1620.repository.QueryRepository.*(..))")
	public void pointcut() {}
	
	@Before("pointcut()")
	public void log(JoinPoint jp){
		//可以通过连接点拿到方法名和参数
		String methodName = jp.getSignature().getName();
		System.out.println("the method [" + methodName + "] "
				+ "begins with " + Arrays.asList(jp.getArgs()));
	}
		
}