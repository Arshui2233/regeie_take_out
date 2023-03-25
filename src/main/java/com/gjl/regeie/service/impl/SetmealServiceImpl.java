package com.gjl.regeie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjl.regeie.common.CustomException;
import com.gjl.regeie.dto.SetmealDto;
import com.gjl.regeie.entity.SetmealDish;
import com.gjl.regeie.mapper.SetmealMapper;
import com.gjl.regeie.service.SetmealDishService;
import com.gjl.regeie.service.SetmealService;
import com.gjl.regeie.entity.Setmeal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {

   @Autowired
    private SetmealDishService setmealDishService;
    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     */
    @Transactional
    @Override
    public void saveWithDish(SetmealDto setmealDto) {
        //保存套餐的基本信息，操作Setmeal,执行insert操作
        this.save(setmealDto);

        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();


        setmealDishes.stream().map((item)->{
            item.setSetmealId(setmealDto.getId());
            return item;
        }).collect(Collectors.toList());


        //保存套餐和菜品的关联信息，操作Setmeal_dish,执行insert操作
        setmealDishService.saveBatch(setmealDishes);

    }


    /**
     * 删除套餐，同时需要删除套餐和菜品的关联数据
     */
    @Override
    @Transactional
    public void removeWithDish(List<Long> ids) {

        //查询套餐状态，查询是否可以删除
        LambdaQueryWrapper<Setmeal> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.in(Setmeal::getId,ids);
        queryWrapper.eq(Setmeal::getStatus,1);
        int count = this.count(queryWrapper);
        if (count>0){
            //如果不能删除，抛出一个业务异常
            throw new CustomException("套餐正在售卖中，不能删除");
        }

        //如果可以删除，先删除套餐表中的数据
        this.removeByIds(ids);



        LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper =new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(SetmealDish::getSetmealId,ids);
        //删除关系表中的数据
        setmealDishService.remove(lambdaQueryWrapper);
    }
}
