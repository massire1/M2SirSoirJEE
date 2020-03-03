package sn.ucad.master2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jboss.logging.Logger;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class DroitAccesAspect {
	static final Logger logger = Logger.getLogger(DroitAccesAspect.class);

	@Before("execution(* sn.ucad.master2.service.*.*(..))")
	public void before(JoinPoint joinPoint) {
		// Advice
		logger.info(" Verification de l'acces utilisateur ");
		logger.info(" Autorisation d'executer  {}" + joinPoint.toString());
	}
}
