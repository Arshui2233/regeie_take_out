package com.gjl.regeie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gjl.regeie.entity.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long id);

}
