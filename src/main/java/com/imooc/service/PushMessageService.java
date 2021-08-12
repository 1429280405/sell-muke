package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * @author liujinqiang
 * @create 2021-08-10 9:05
 */
public interface PushMessageService {
    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
