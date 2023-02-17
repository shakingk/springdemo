package org.example;

import org.example.model.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("user".equals(beanName)) {
            System.out.println("1. 调用 InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation() 方法");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("user".equals(beanName)) {
            User user = (User) bean;
            System.out.println("3. 调用 InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation() 方法");
            System.out.println(user);
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if ("user".equals(beanName)) {
            System.out.println("4. 调用 InstantiationAwareBeanPostProcessor.postProcessProperties() 方法");
        }
        return null;
    }

}
