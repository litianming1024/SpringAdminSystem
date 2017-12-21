package cn.godbol.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.io.Serializable;

/**
 * Created by li on 17-3-22.
 */
@Aspect
@Slf4j
public class FindAspect {

    @Pointcut("execution(* cn.godbol.service.api.FindService.findOne(*)) && args(id)")
    public void findOnePointcut(Serializable id){

    }

    @Around("findOnePointcut(id)")
    public void findOneAround(ProceedingJoinPoint joinPoint, Serializable id) throws Throwable {
        try {
            log.info("Find:{}", joinPoint.getThis().toString());
            Object result = joinPoint.proceed();

        } catch (Throwable e) {
            throw e;
        }
    }
}
