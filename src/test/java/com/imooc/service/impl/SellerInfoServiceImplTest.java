package com.imooc.service.impl;

import com.imooc.dataobject.SellerInfo;
import com.imooc.service.SellerInfoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liujinqiang
 * @create 2021-08-09 12:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoServiceImplTest {

    private static String OPENID="abc";

    @Autowired
    private SellerInfoService infoService;

    @Test
    public void testFind(){
        SellerInfo sellerInfo = infoService.findSellerInfoByOpenid(OPENID);
        Assert.assertNotNull(sellerInfo);
    }


}