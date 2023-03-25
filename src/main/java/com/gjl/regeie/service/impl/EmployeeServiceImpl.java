package com.gjl.regeie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjl.regeie.entity.Employee;
import com.gjl.regeie.mapper.EmployeeMapper;
import com.gjl.regeie.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
