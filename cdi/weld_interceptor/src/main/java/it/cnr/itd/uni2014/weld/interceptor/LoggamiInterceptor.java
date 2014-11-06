package it.cnr.itd.uni2014.weld.interceptor;

import java.util.Arrays;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Loggami
@Interceptor
public class LoggamiInterceptor {
	@Inject
	Logger logger;

	@AroundInvoke
	public Object manageTransaction(InvocationContext ctx) throws Exception {
		logger.info("before call to " + ctx.getMethod() + " with args " + Arrays.toString(ctx.getParameters()));
        Object returnMe = ctx.proceed();
        logger.info("after call to " + ctx.getMethod() + " returned " + returnMe);
        return returnMe;
	}
}