package com.imooc.controller;

import com.imooc.VO.ResultVO;
import com.imooc.convert.OrderForm2OrderDTOConverter;
import com.imooc.dataobject.OrderMaster;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import com.imooc.utils.ResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liujinqiang
 * @create 2021-08-04 23:36
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确！");
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        if (result == null) {
            log.error("【创建订单】保存订单失败");
        }
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("orderId", result.getBuyerOpenid());
        return ResultVOUtils.success(resultMap);
    }


    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderMaster>> list(@RequestParam("openid") String openid,
                                            @RequestParam(name = "page",defaultValue = "0") Integer page,
                                            @RequestParam(name = "size",defaultValue = "10") Integer size){
        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】，openid不能为空！");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<OrderDTO> dtoPage = orderService.findList(openid, pageRequest);
        return ResultVOUtils.success(dtoPage.getContent());
    }

    //查询订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(String openid,String orderId){
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtils.success(orderDTO);
    }


    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(String openid,String orderId){
        OrderDTO orderDTO=buyerService.cancelOrder(openid,orderId);
        return ResultVOUtils.success();
    }
}
