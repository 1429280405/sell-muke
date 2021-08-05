package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * @author liujinqiang
 * @create 2021-08-05 9:45
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openid, String orderId);

    OrderDTO cancelOrder(String openid, String orderId);
}
