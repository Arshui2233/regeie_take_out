package com.gjl.regeie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjl.regeie.entity.OrderDetail;
import com.gjl.regeie.entity.Orders;
import com.gjl.regeie.mapper.OrderDetailMapper;
import com.gjl.regeie.mapper.OrderMapper;
import com.gjl.regeie.service.OrderDetailService;
import com.gjl.regeie.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}
