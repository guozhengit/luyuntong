package com.aygxy.mybatis.mapper;

import com.aygxy.mybatis.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 财务统计数据持久化接口
 * @Author: Guoyongzheng
 * @Date: 2019/5/9-0:58
 */
@Mapper
public interface FinanceMapper {
    /*工资成本*/
     List<SalaryMode> salaryManage(SalaryMode salaryMode);
    /*运营支出*/
     List<OperationModel> operationManage(OperationModel operationModel);
    /*客户管理*/
     List<CustomerModel>  customerManage (CustomerModel customerModel);
    /*盈利统计*/
     List<ProfitModel> profitManage (ProfitModel profitModel);
}
