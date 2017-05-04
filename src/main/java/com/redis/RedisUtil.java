package com.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

/**
 * @DESCRIPTION redis相关操作
 * @AUTHER Administrator zhangna
 * @create 2017-05-02
 */
@Repository
public class RedisUtil {

    @Resource
    private RedisTemplate redisTemplatete;

    /**
     * 删除缓存中key指定的所有对象
     */
    public int delCache(Object key){
        if(key != null){
            redisTemplatete.delete(key);
            return 0;
        }else{
            return -1;
        }
    }

    /**
     * 单个缓存对象 增加/修改
     */
    public int updateSingleCache(Object key,Object val){
        if(key != null && val != null){
            redisTemplatete.opsForValue().set(key,val);
            return 0;
        }else{
            return -1;
        }
    }

    /**
     * 单个缓存对象 查询
     */
    public Object getSingleCache(Object key){
        if(key != null){
            return redisTemplatete.opsForValue().get(key);
        }else{
            return null;
        }
    }

    /**
     * 多个缓存对象 Hash形式保存 增加/修改
     */
    public int  updateCacheHash(Object key,Map<Object,Object> map){
        if(key == null || map == null){
            return -1;
        }
        Set<Object> keySet = map.keySet();
        for (Object obj :
                keySet) {
            redisTemplatete.opsForHash().put(key,obj,map.get(obj));
        }
        return 0;
    }

    /**
     *多个缓存对象 Hash形式保存 删除
     */
    public int delCacheHash(Object key,Object[] hashKeys){
        if( key != null && hashKeys != null && hashKeys.length > 0){
            redisTemplatete.opsForHash().delete(key,hashKeys);
            return 0;
        }else{
            return -1;
        }
    }

    /**
     * 多个缓存对象 Hash形式保存 查询
     */
    public Map getCacheHash(Object key){
        if(key == null ){
            return new HashMap<Object,Object>();
        }
        return redisTemplatete.opsForHash().entries(key);
    }

    /**
     * 多个缓存对象 List形式保存 增加（右进）
     */
    public int addCacheList(Object key,Object[] values){
        if(key != null && values != null && values.length > 0){
            for (Object obj : values) {
                redisTemplatete.opsForList().rightPush(key,obj);
            }
            return 0;
        }
        return -1;
    }

    /**
     * 多个缓存对象 List形式保存 删除
     */
    public int delCacheList(Object key,Map<Object,Object> map){
        if(key != null && map != null){
            Set<Object> keySet = map.keySet();
            for (Object index: keySet) {
                Object obj = map.get(index);
                redisTemplatete.opsForList().remove(key,((Number)index).longValue(),obj);
            }
            return 0;
        }
        return -1;
    }

    /**
     * 多个缓存对象 List形式保存 修改
     * @param key
     * @param map key修改内容的下标  value 修改的内容
     * @return
     */
    public int modifyCacheList(Object key,Map<Object,Object> map){
        if(key != null && map != null){
            Set<Object> keySet = map.keySet();
            for (Object index: keySet) {
                Object obj = map.get(index);
                redisTemplatete.opsForList().set(key,((Number)index).longValue(),obj);
            }
            return 0;
        }
        return -1;
    }

    /**
     * 多个缓存对象 List形式保存 查询
     */
    public List getCacheList(Object key,long start,long end){
        List result = null;
        if(key == null){
            return result;
        }
        if(end < start){
            result = redisTemplatete.opsForList().range(key,0L,-1L);
        }else{
            result = redisTemplatete.opsForList().range(key,start,end);
        }
        return result;
    }

    /**
     * 多个缓存对象 Set形式保存 增加
     */
    public int addCacheSet(Object key,Object[] values){
        if(key == null || values == null ){
            return -1;
        }
        redisTemplatete.opsForSet().add(key,values);
        return 0;
    }

    /**
     * 多个缓存对象 Set形式保存 删除
     */
    public int delCacheSet(Object key,Object[] values){
        if(key == null || values == null){
            return -1;
        }
        redisTemplatete.opsForSet().remove(key,values);
        return 0;
    }

    /**
     * 多个缓存对象 Set形式保存 修改
     * @param key 缓存key
     * @param map key 待修改内容,value 修改后内容
     * @return
     */
    public int modifyCacheSet(Object key,Map<Object,Object> map){
        if(key == null || map == null){
            return -1;
        }
        Set<Object> keySet = map.keySet();
        for (Object obj :
                keySet) {
            //删除旧的值
            redisTemplatete.opsForSet().remove(key,obj);
            //添加新的值
            redisTemplatete.opsForSet().add(key,map.get(obj));
        }
        return 0;
    }
    /**
     * 多个缓存对象 Set形式保存 查询
     */
    public Set getCacheSet(Object key){
        Set result = null;
        if(key == null){
            return result;
        }
        result = redisTemplatete.opsForSet().members(key);
        return result;
    }
}
