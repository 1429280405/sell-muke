package com.imooc.exception;

import com.imooc.enums.ResultEnum;
import lombok.Getter;

/**
 * @author liujinqiang
 * @create 2021-08-03 23:24
 */
@Getter
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
