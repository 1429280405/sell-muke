package com.imooc.util;

import com.imooc.enums.CodeEnum;

/**
 * @author liujinqiang
 * @create 2021-08-07 0:02
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
