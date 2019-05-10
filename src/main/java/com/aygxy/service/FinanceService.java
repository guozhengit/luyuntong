package com.aygxy.service;

import com.aygxy.mybatis.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Description: 报务统计
 * @Author: Guoyongzheng
 * @Date: 2019/5/9-0:33
 */
@Service
public interface FinanceService {
    /*工资成本*/
     Page<SalaryMode> salaryManage(Pageable pageable, SalaryMode salaryMode);
    /*运营支出*/
     Page<OperationModel> operationManage(Pageable pageable, OperationModel operationModel);
    /*客户管理*/
     Page<CustomerModel> customerManage (Pageable pageable, CustomerModel customerModel);
    /*盈利统计*/
     Page<ProfitModel> profitManage (Pageable pageable, ProfitModel profitModel);
}
