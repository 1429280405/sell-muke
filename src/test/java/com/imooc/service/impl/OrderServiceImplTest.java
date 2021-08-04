package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liujinqiang
 * @create 2021-08-04 20:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "1101110";

    private final String ORDER_ID = "1628080926923223137";


    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("廖师兄");
        orderDTO.setBuyerAddress("幕课网");
        orderDTO.setBuyerPhone("123456789012");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("1234");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    void findOne() {
        OrderDTO one = orderService.findOne(ORDER_ID);
        log.info("result={}",one);
        Assert.assertEquals(ORDER_ID,one.getOrderId());
    }

    @Test
    void findList() {
        PageRequest request = PageRequest.of(1,2);
        Page<OrderDTO> list = orderService.findList(BUYER_OPENID, request);
        log.info("list:{}",list);
        Assert.assertNotNull(list);
    }

    @Test
    void cancel() {
        OrderDTO one = orderService.findOne(ORDER_ID);
        OrderDTO cancel = orderService.cancel(one);
        log.info("订单取消：{}",cancel);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),cancel.getOrderStatus());

    }

    @Test
    void finish() {
        OrderDTO one = orderService.findOne(ORDER_ID);
        OrderDTO finish = orderService.finish(one);
        log.info("订单完结：{}",finish);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),one.getOrderStatus());
    }

    @Test
    void paid() {
        OrderDTO one = orderService.findOne(ORDER_ID);
        OrderDTO paid = orderService.paid(one);
        log.info("完成支付：{}",paid);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),one.getPayStatus());
    }

    @Test
    void testFindList() {
    }
}