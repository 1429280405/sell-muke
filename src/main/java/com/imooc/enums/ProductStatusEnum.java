package com.imooc.enums;

import lombok.Getter;

/**
 * @author liujinqiang
 * @create 2021-08-03 9:02
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
