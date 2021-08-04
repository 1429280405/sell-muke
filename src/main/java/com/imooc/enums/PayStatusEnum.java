package com.imooc.enums;

import lombok.Getter;

/**
 * @author liujinqiang
 * @create 2021-08-03 22:19
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付完成")
    ;
    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
