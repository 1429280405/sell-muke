package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author liujq
 * @create 2021-08-11 17:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    void insertByProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("喜茶");
        productCategory.setCategoryType(1001);
        int result = mapper.insertByProductCategory(productCategory);
        Assert.assertEquals(1,result);
    }
}