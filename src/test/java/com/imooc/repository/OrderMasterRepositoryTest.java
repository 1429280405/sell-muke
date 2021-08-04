package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liujinqiang
 * @create 2021-08-03 22:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "1102313";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234995");
        orderMaster.setBuyerName("小师妹");
        orderMaster.setBuyerPhone("12343217899123");
        orderMaster.setBuyerAddress("腾讯视频");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(99.99));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest request = PageRequest.of(1, 3);

        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);

        Assert.assertNotEquals(0, result.getTotalElements());
    }
}