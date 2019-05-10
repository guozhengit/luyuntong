package com.aygxy.service.impl;

import com.aygxy.mybatis.entity.*;
import com.aygxy.mybatis.mapper.FinanceMapper;
import com.aygxy.model.*;
import com.aygxy.service.FinanceService;
import com.aygxy.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: Guoyongzheng
 * @Date: 2019/5/9-0:55
 */
@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    FinanceMapper financeMapper;

    @Override
    public Page<SalaryMode> salaryManage(Pageable pageable, SalaryMode salaryMode) {
        //List<SalaryMode> salaryModeList = financeMapper.salaryManage(salaryMode);
        //todo:暂造假数据测试
        int[] status = new int[]{1,2};
        List<SalaryMode> salaryModeList = new ArrayList<>();
        for(int i = 0;i<50;i++){
            SalaryMode model = new SalaryMode();
            model.setOfficeCode(RandomUtil.generateZeroString(5).concat(String.valueOf(i+1)));
            if ("1".equals(RandomUtil.getStringBumber(status,1))){
                model.setIdType("司机");
            }else{
                model.setIdType("员工");
            }
            model.setBalanceDate(RandomUtil.randomBirth());
            model.setSalary(new BigDecimal(RandomUtil.getDesAreaRandomNumber(8000,10000)));
            model.setBonus(new BigDecimal(RandomUtil.getStringBumber(4)));
            model.setSubsidy(new BigDecimal(RandomUtil.getStringBumber(3)));
            model.setTotalSalary(model.getSalary().add(model.getBonus()).add(model.getSubsidy()));
            salaryModeList.add(model);
        }
        Page<SalaryMode> returnPage = new PageImpl<>(salaryModeList, pageable, salaryModeList.size());
        return returnPage;
    }

    @Override
    public Page<OperationModel> operationManage(Pageable pageable,OperationModel operationModel) {
        //List<OperationModel> operationModelList = financeMapper.operationManage(operationModel);
        //todo:暂造假数据测试
        List<OperationModel> operationModelList = new ArrayList<>();
        for(int i = 0;i<50;i++){
            OperationModel model = new OperationModel();
            model.setElectricFee(new BigDecimal(RandomUtil.getStringBumber(5)));
            model.setRent(new BigDecimal(RandomUtil.getStringBumber(5)));
            model.setTelephoneFee(new BigDecimal(RandomUtil.getStringBumber(5)));
            model.setWaterFee(new BigDecimal(RandomUtil.getStringBumber(5)));
            model.setTotalFee(model.getElectricFee().add(model.getRent()).add(model.getTelephoneFee()).add(model.getWaterFee()));
            model.setMonth(RandomUtil.randomBirth(10,20,"yyyyMM"));
            model.setQuarter(RandomUtil.randomBirth());
            operationModelList.add(model);
        }
        Page<OperationModel> returnPage = new PageImpl<>(operationModelList, pageable, operationModelList.size());
        return returnPage;
    }

    @Override
    public Page<CustomerModel> customerManage(Pageable pageable, CustomerModel customerModel) {
        //List<CustomerModel> customerModelList = financeMapper.customerManage(customerModel);
        //todo:暂造假数据测试
        int[] status = new int[]{1,2,3};
        List<CustomerModel> customerModelList = new ArrayList<>();
        for(int i = 0;i<50;i++){
            CustomerModel model = new CustomerModel();
            model.setAccountAmount(new BigDecimal(RandomUtil.getStringBumber(6)));
            model.setUnAccountAmount(new BigDecimal(RandomUtil.getStringBumber(5)));
            model.setAccountTime(RandomUtil.randomBirth());
            model.setCustomerCode("CT".concat(RandomUtil.getStringBumber(8)));
            model.setCustomerName(RandomUtil.getChineseName());
            model.setAccountStatus(RandomUtil.getStringBumber(status,1));
            model.setAccountType(RandomUtil.getStringBumber(status,1));
            customerModelList.add(model);
        }
        Page<CustomerModel> returnPage = new PageImpl<>(customerModelList, pageable, customerModelList.size());
        return returnPage;
    }

    @Override
    public Page<ProfitModel> profitManage(Pageable pageable,ProfitModel profitModel) {
        //List<ProfitModel> profitModelList = financeMapper.profitManage(profitModel);
        //todo:暂造假数据测试
        int[] status = new int[]{1,2,3};
        List<ProfitModel> profitModelList = new ArrayList<>();
        for(int i = 0;i<50;i++){
            ProfitModel model = new ProfitModel();
            model.setSettlementAmount(new BigDecimal(RandomUtil.getStringBumber(7)));
            model.setOutstandingAmount(new BigDecimal(RandomUtil.getStringBumber(6)));
            model.setPayrollCost(new BigDecimal(RandomUtil.getStringBumber(6)));
            model.setAmountPaid(new BigDecimal(RandomUtil.getStringBumber(6)));
            model.setActualProfitAmount(model.getSettlementAmount().subtract(model.getPayrollCost()).subtract(model.getAmountPaid()).add(model.getOutstandingAmount()));
            model.setExpectedProfitAmount(model.getSettlementAmount().subtract(model.getPayrollCost()).subtract(model.getAmountPaid()));
            model.setProfitTime(RandomUtil.randomBirth());
            profitModelList.add(model);
        }
        Page<ProfitModel> returnPage = new PageImpl<>(profitModelList, pageable, profitModelList.size());
        return returnPage;
    }

}
