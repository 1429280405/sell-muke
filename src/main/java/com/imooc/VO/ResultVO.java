package com.imooc.VO;

import lombok.Data;

/**
 * @author liujinqiang
 * @create 2021-08-03 13:02
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
}
