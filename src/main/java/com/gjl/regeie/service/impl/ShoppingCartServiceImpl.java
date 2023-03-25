package com.gjl.regeie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjl.regeie.entity.ShoppingCart;
import com.gjl.regeie.mapper.ShoppingCartMapper;
import com.gjl.regeie.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
