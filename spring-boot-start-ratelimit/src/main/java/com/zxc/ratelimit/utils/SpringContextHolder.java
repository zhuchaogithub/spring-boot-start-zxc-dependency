//package com.zxc.ratelimit.utils;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.annotation.Lazy;
//
///**
// * @author zxc
// * @date 2020/4/23 11:28
// */
//@Slf4j
//@Lazy(false)
//public class SpringContextHolder implements ApplicationContextAware, DisposableBean {
//
//    private static ApplicationContext applicationContext ;
//
//    /**
//     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
//     *
//     * @param applicationContext
//     */
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext){
//        SpringContextHolder.applicationContext = applicationContext;
//    }
//
//    /**
//     * @return ApplicationContext
//     */
//    public static ApplicationContext getApplicationContext() {
//        return applicationContext;
//    }
//
//    /**
//     * 获取对象
//     *
//     * @param name
//     * @return Object 一个以所给名字注册的bean的实例
//     */
//    @SuppressWarnings("unchecked")
//    public static <T> T getBean(String name)  {
//        return (T) applicationContext.getBean(name);
//    }
//
//    /**
//     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
//     */
//    public static <T> T getBean(Class<T> requiredType) {
//        return applicationContext.getBean(requiredType);
//    }
//
//
//    /**
//     * 获取对象 通过类型
//     *
//     * @param type
//     * @return Object 一个以所给名字注册的bean的实例
//     */
//
//    public static <T> T getBeansOfType( Class type)
//    {
//        return (T) applicationContext.getBeansOfType(type);
//    }
//
//    /**
//     * 获取类型为requiredType的对象
//     * 如果bean不能被类型转换，相应的异常将会被抛出（BeanNotOfRequiredTypeException）
//     *
//     * @param name
//     *            bean注册名
//     * @param requiredType
//     *            返回对象类型
//     * @return Object 返回requiredType类型对象
//     */
//
//    public static <T> T getBean(String name, Class requiredType)
//    {
//        return (T) applicationContext.getBean(name, requiredType);
//    }
//
//
//    /**
//     * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
//     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
//     *
//     * @param name
//     * @return boolean
//     */
//    public static boolean isSingleton(String name)
//    {
//        return applicationContext.isSingleton(name);
//    }
//    /**
//     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
//     *
//     * @param name
//     * @return boolean
//     */
//    public static boolean containsBean(String name) {
//        return applicationContext.containsBean(name);
//    }
//
//
//
//    /**
//     * @param name
//     * @return Class 注册对象的类型
//     */
//    public static <T> Class<T> getType(String name) {
//        return (Class<T>) applicationContext.getType(name);
//    }
//
//
//    /**
//     * 如果给定的bean名字在bean定义中有别名，则返回这些别名
//     *
//     * @param name
//     * @return
//     */
//    public static String[] getAliases(String name) {
//        return applicationContext.getAliases(name);
//    }
//
//    /**
//     * 清除SpringContextHolder中的ApplicationContext为Null.
//     */
//    public static void clearHolder() {
//        if (log.isDebugEnabled()) {
//            log.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
//        }
//        applicationContext = null;
//    }
//
//    /**
//     * 发布事件
//     *
//     * @param event
//     */
//    public static void publishEvent(ApplicationEvent event) {
//        if (applicationContext == null) {
//            return;
//        }
//        applicationContext.publishEvent(event);
//    }
//
//    /**
//     * 实现DisposableBean接口, 在Context关闭时清理静态变量.
//     */
//    @Override
//    public void destroy() {
//        SpringContextHolder.clearHolder();
//    }
//
//
//}
