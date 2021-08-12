package com.imooc.service;

import com.imooc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

/**
 * @author liujinqiang
 * @create 2021-08-05 22:22
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    void notify(String notifyData);
}
