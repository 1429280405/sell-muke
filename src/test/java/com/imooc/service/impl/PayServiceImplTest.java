package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.OrderService;
import com.imooc.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liujinqiang
 * @create 2021-08-05 22:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class PayServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @Test
    void create() {
        OrderDTO orderDTO = orderService.findOne("1628126312100176529");
        payService.create(orderDTO);
    }
}