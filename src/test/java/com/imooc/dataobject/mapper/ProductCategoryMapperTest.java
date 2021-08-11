package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liujinqiang
 * @create 2021-08-11 22:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    void insertByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("categoryName","蒙牛");
        map.put("categoryType",1001);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    void insertByObj() {
        ProductCategory category = new ProductCategory();
        category.setCategoryName("tws耳机");
        category.setCategoryType(1002);
        int result = mapper.insertByObject(category);
        Assert.assertEquals(1,result);
    }

    @Test
    void findByType(){
        ProductCategory byCategoryType = mapper.findByCategoryType(1002);
        log.info("result:{}",byCategoryType);
        Assert.assertNotNull(byCategoryType);
    }

    @Test
    void updateNameById(){
        int result = mapper.updateNameById("电脑", 1001);
        Assert.assertEquals(1,result);
    }
}