package com.imooc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SellApplicationTests {

    @Test
    void contextLoads() {
        log.info("name:{},age:{}","张三",21);
        log.debug("name:{},age:{}","李四",23);
        log.error("name:{},age:{}","王五",26);

    }

}
