package com.gjl.regeie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gjl.regeie.dto.DishDto;
import com.gjl.regeie.entity.Dish;

public interface DishService extends IService<Dish> {
    //新增菜品，同时插入口味数据，需要操作两张表
    public void saveWithFlavor(DishDto dishDto);
    //根据id查询菜品信息和对应的口味信息
    public DishDto getByIdWithFlavor(Long id);
    //更新菜品信息，同时更新对应的口味信息
    public void updateWithFlavor(DishDto dishDto);

}