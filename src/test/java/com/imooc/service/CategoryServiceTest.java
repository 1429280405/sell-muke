package com.imooc.service;

import com.imooc.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liujinqiang
 * @create 2021-08-03 13:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void findOne() {
        ProductCategory category = categoryService.findOne(1);
        log.info("category:{}",category);
    }

    @Test
    void findAll() {
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertNotNull(list);
    }

    @Test
    void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<ProductCategory> categories = categoryService.findByCategoryTypeIn(list);
        Assert.assertNotNull(categories);
    }

    @Test
    void save() {
        ProductCategory productCategory = new ProductCategory("虾", 2);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}