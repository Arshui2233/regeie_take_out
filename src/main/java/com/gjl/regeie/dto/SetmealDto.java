package com.gjl.regeie.dto;

import com.gjl.regeie.entity.Setmeal;
import com.gjl.regeie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends com.gjl.regeie.entity.Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
