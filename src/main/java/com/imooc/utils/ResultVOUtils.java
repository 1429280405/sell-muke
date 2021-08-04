package com.imooc.utils;

import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;

import java.util.List;

/**
 * @author liujinqiang
 * @create 2021-08-03 13:33
 */
public class ResultVOUtils {

    public static ResultVO success(Object object) {
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO fail(Integer code,String msg){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(null);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }
}
