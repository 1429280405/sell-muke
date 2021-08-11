package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.Map;

/**
 * @author liujinqiang
 * @create 2021-08-11 22:15
 */
public interface ProductCategoryMapper {

    @Insert("insert into product_category(category_name,category_type) values(#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    public int insertByMap(Map<String,Object> map);

    @Insert("insert into product_category(category_name,category_type) values(#{categoryName},#{categoryType})")
    public int insertByObject(ProductCategory productCategory);

    @Select("select * from product_category where category_type=#{categoryType,jdbcType=INTEGER}")
    @Results({
            @Result(column="category_id",property ="categoryId" ),
            @Result(column="category_name",property ="categoryName" ),
            @Result(column = "category_type",property = "categoryType")
    })
    public ProductCategory findByCategoryType(Integer categoryType);


    @Update("update product_category set category_name=#{categoryName} where category_type = #{categoryType}")
    public int updateNameById(@Param("categoryName") String categoryName,@Param("categoryType") Integer categoryType);

}
