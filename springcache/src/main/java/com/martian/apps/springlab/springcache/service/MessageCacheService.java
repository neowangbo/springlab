/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.springlab.springcache.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Cacheable注解负责将方法的返回值加入到缓存中 CacheEvict注解负责清除缓存(它的三个参数与@Cacheable的意思是一样的)
 *
 * @see ----------------------------------------------------------------------------------------------------------
 * @see value------缓存位置的名称,不能为空,若使用EHCache则其值为ehcache.xml中的<cache name="myCache"/>
 * @see key--------缓存的Key,默认为空(表示使用方法的参数类型及参数值作为key),支持SpEL
 * @see condition--只有满足条件的情况才会加入缓存,默认为空(表示全部都加入缓存),支持SpEL
 * @see ----------------------------------------------------------------------------------------------------------
 * @see 该注解的源码位于spring-context-3.2.4.RELEASE-sources.jar中
 * @see Spring针对Ehcache支持的Java源码位于spring-context-support-3.2.4.RELEASE-sources.jar中
 * @see ----------------------------------------------------------------------------------------------------------
 * @author Wang Bo
 */
@Service
public class MessageCacheService {

    private static final Logger LOG = LoggerFactory.getLogger(MessageCacheService.class);

    private final Map<Integer, String> messages = new ConcurrentHashMap<>();

    public MessageCacheService() {
        LOG.info("Adding data...Start");
        messages.put(1, "Hello, world!");
        messages.put(2, "Hello!");
        messages.put(3, "Good morning!");
        messages.put(4, "Good afternoon!");
        messages.put(5, "Good evening!");
        messages.put(6, "Good night!");
        LOG.info("Adding data...End");
    }

    
    public void add(Integer id, String msg){
        LOG.info("===> Add a new message...");
        messages.put(id, msg);
    }
    
    //将查询到的数据缓存到myCache中,并使用方法名称加上参数中的userNo作为缓存的key  
    //通常更新操作只需刷新缓存中的某个值,所以为了准确的清除特定的缓存,故定义了这个唯一的key,从而不会影响其它缓存值  
    @Cacheable(value = "msgCache", key = "#id")
    public String get(Integer id) {
        String msg = messages.get(id);
        LOG.info("===> Get id=[" + id + "], message=[" + msg + "], this record is added into cache.");
        return msg;
    }

    @CacheEvict(value = "msgCache", key = "#id")
    public void update(Integer id, String msg) {
        LOG.info("===> Remove id=[" + id + "] from cache because its value has been updated.");
        messages.put(id, msg);
    }

    //allEntries为true表示清除value中的全部缓存,默认为false  
    @CacheEvict(value = "msgCache", allEntries = true)
    public void removeAll() {
        LOG.info("===> Remove all records from cache.");
    }

}
