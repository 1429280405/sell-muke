package com.imooc.constans;

/** redis常量
 * @author liujinqiang
 * @create 2021-08-09 17:01
 */
public interface RedisConstant {
    String TOKEN_PREFIX = "token_%s";
    Integer EXPIRE = 7200;//2小時
}
