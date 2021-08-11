package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import org.apache.ibatis.annotations.Insert;

/**
 * @author liujq
 * @create 2021-08-11 17:20
 */
public interface ProductCategoryMapper {

    @Insert("INSERT INTO product_category(category_name,category_type) VALUES(#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    public int insertByProductCategory(ProductCategory productCategory);
}
