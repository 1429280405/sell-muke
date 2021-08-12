package com.imooc.service.impl;

import com.imooc.dataobject.SellerInfo;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.repository.SellerInfoRepository;
import com.imooc.service.SellerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author liujinqiang
 * @create 2021-08-09 12:30
 */
@Service
@Slf4j
public class SellerInfoServiceImpl implements SellerInfoService {

    @Autowired
    private SellerInfoRepository infoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询卖家端信息错误】,openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        SellerInfo sellerInfo = infoRepository.findByOpenid(openid);
        if (sellerInfo == null) {
            log.error("【查询卖家端信息错误】,未查询到数据，openid:{}", openid);
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        return sellerInfo;
    }
}
