package com.gjl.regeie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gjl.regeie.entity.Orders;


public interface OrderService extends IService<Orders> {
    //用户下单
    public void submit(Orders orders);
}
