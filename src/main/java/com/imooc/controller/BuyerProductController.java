package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liujinqiang
 * @create 2021-08-03 12:48
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        //1.查詢所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询类目
        List<Integer> categoryTypes = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypes);
        //3.数据拼接
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory category : categoryList) {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(category, productVO);
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                ProductInfoVO productInfoVO = new ProductInfoVO();
                BeanUtils.copyProperties(productInfo, productInfoVO);
                productInfoVOList.add(productInfoVO);
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtils.success(productVOList);


    }

}
