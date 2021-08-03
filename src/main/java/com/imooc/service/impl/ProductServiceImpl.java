package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.repository.ProductInfoRepository;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author liujinqiang
 * @create 2021-08-03 8:43
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) {
        Optional<ProductInfo> productInfo = productInfoRepository.findById(productId);
        return productInfo.get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        List<ProductInfo> list = productInfoRepository.findAll();
        return list;
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {

        Page<ProductInfo> page = productInfoRepository.findAll(pageable);
        return page;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }
}
