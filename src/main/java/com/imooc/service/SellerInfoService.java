package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

/**
 * @author liujinqiang
 * @create 2021-08-09 12:29
 */
public interface SellerInfoService {
    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
