package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author liujinqiang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void findOne() {
        ProductInfo one = productService.findOne("1234");
        log.info("productInfo:{}",one);
    }

    @Test
    void findUpAll() {
        List<ProductInfo> all = productService.findUpAll();
        log.info("findUpAll:{}",all);
    }

    @Test
    void findAll() throws Exception{
        PageRequest request = PageRequest.of(0, 2);
        Page<ProductInfo> page = productService.findAll(request);
        List<ProductInfo> list = page.getContent();
        log.info("list:{}",list);

    }

    @Test
    void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1234");
        productInfo.setProductName("肠粉");
        productInfo.setProductPrice(new BigDecimal(6));
        productInfo.setProductStock(99);
        productInfo.setProductDescription("很好吃的肠粉");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(1);

        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}