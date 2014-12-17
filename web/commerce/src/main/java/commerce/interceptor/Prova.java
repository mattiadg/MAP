package commerce.interceptor;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.UserTransaction;

@Interceptor
@Loggami
@Dependent
public class Prova {
	@Inject
	UserTransaction tx;

	@AroundInvoke
	public Object pippo(InvocationContext ctx) throws Exception {
		tx.begin();
		
		Object returnMe = ctx.proceed();
		tx.commit();
		return returnMe;
	}
}