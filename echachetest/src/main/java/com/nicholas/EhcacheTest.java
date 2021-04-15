package com.nicholas;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @Description: java类作用描述
 * @Author: denggc3
 * @CreateDate: 2021/4/12$ 23:37$
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/4/12$ 23:37$
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public class EhcacheTest {

    public static void main(String[] args){
        // 1. 创建缓存管理器
        CacheManager cacheManager = CacheManager.create("./echachetest/src/main/resources/ehcache.xml");

        // 2. 获取缓存对象
        Cache cache = cacheManager.getCache("HelloWorldCache");

        // 3. 创建元素
        Element element = new Element("key1", "value1");

        // 4. 将元素添加到缓存

        cache.put(element);

        // 5. 获取缓存
        Element value = cache.get("key1");
        System.out.println("value: " + value);
        System.out.println(value.getObjectValue());

        // 6. 删除元素
        cache.remove("key1");

        Dog dog = new Dog("xiaohei", "black", 2);
        Element element2 = new Element("dog", dog);
        cache.put(element2);
        Element value2 = cache.get("dog");
        System.out.println("value2: "  + value2);
        Dog dog2 = (Dog) value2.getObjectValue();
        System.out.println(dog2);

        System.out.println(cache.getSize());

        // 7. 刷新缓存
        cache.flush();

        // 8. 关闭缓存管理器
        cacheManager.shutdown();

    }

}
