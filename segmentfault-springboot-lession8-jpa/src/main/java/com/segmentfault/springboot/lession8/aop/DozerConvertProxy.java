package com.segmentfault.springboot.lession8.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.dozer.DozerBeanMapper;
import org.dozer.metadata.ClassMappingMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class DozerConvertProxy {

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Pointcut(value = "execution(* com.segmentfault.springboot.lession8.web.controller..*.*(..))")
    public void controller(){}

    @Around(value = "controller()")
    public Object convert(ProceedingJoinPoint point) throws Throwable {

        Object source = point.proceed();
        return source;
//        System.out.println(source);
//        List<ClassMappingMetadata> sourceClasses = dozerBeanMapper.getMappingMetadata().getClassMappingsBySource(source.getClass());
//        if (sourceClasses.size() > 0) {
//            Class<?> destinationClass = sourceClasses.get(0).getDestinationClass();
//            Object dest = dozerBeanMapper.map(source, destinationClass);
//            return dest;
//        } else {
//            return source;
//        }
    }
}
