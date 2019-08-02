package interceptor;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import util.LogUtil;

@Aspect//aop 切面 的注解
@Component//组件 注解
public class LogInterceptor {
				 // 第一个* 代表任意的返回类型 (..) 所有参数
	@Pointcut("execution(* biz.impl.*.*(..))")//表示要拦截biz.impl包下 的所有类 的所有方法 (两个小点..代表任意参数)
	private void anyMethod11() {
	}; // 声明一个切入点

	//环绕通知
	@Around("anyMethod11()")
	public Object doAround111(ProceedingJoinPoint pjp) throws Throwable {
		System.out.print("环绕通知,类："+pjp.getTarget().getClass().getName()+";");
		System.out.print("方法："+pjp.getSignature().getName()+";");
		System.out.print("参数："+pjp.getArgs()[0]+"-->");//参数 为一个数组，这里只有一个，取0位置上的
		System.out.println();
		LogUtil.logBegin();
		Object obj = pjp.proceed();//程序接着往下走
		System.out.println("环绕通知-->");
		LogUtil.logEnd();
		return obj;
	}
	//前置通知
	@Before("anyMethod11()")
	public void doBefore(JoinPoint jp){
		System.out.print("前置通知,类："+jp.getTarget().getClass().getName()+";");
		System.out.print("方法："+jp.getSignature().getName()+";");
		System.out.println("参数："+jp.getArgs()[0]+"-->");
		LogUtil.logBegin();
		
	}
	//后置通知
	@After("anyMethod11()")
	public void doAfter(JoinPoint jp){
		System.out.print("后置通知,类："+jp.getTarget().getClass().getName()+";");
		System.out.print("方法："+jp.getSignature().getName()+";");
		System.out.println("参数："+jp.getArgs()[0]+"-->");
		LogUtil.logEnd();
	}
	//返回通知
	@AfterReturning("anyMethod11()")
	public void doAfterReturning(JoinPoint jp){
		System.out.println("返回通知");
	}
	//异常通知
	@AfterThrowing(value="execution(* biz.impl.*.*(..))",throwing="ex")
	public void doAfterThrowing(JoinPoint jp,Exception ex){//发生异常才通知
		System.out.println("异常通知");
		System.out.println("异常信息："+ex.getMessage());
	}
}
