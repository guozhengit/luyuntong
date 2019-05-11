package com.aygxy.service.impl;

import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import com.aygxy.jpa.entity.Bill;
import com.aygxy.jpa.entity.Bill;
import com.aygxy.jpa.entity.QBill;
import com.aygxy.jpa.repository.BillRepository;
import com.aygxy.service.BillService;
import com.aygxy.util.BeanUtils;
import com.aygxy.util.RandomUtil;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
@Service
public class BillServiceimpl implements BillService {

    @Autowired
    JPAQueryFactory jpaQueryFactory;
    @Autowired
    BillRepository billRepository;
    @Autowired
    MockDataService mockDataService;

    @Override
    public Result add(Bill bill) {
        try {
            bill.setCreateTime(new Date());
            //填装合法数据
            //mockDataService.setMockBill(bill);
            return new Result<>(PhysicalConstants.ADD_SUCCESS,PhysicalConstants.ADD_SUCCESS_CN,billRepository.save(bill));
        }catch (BusinessException e){
            throw new BusinessException(PhysicalConstants.ADD_UNSUCCESS_CN);
        }
    }

    @Override
    public Result delete(String id) {
        try {
            billRepository.deleteById(id);
            return new Result<>(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
        }catch (Exception e){
            e.getStackTrace();
            throw new BusinessException(PhysicalConstants.DELETE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result deleteBatch(List<String> ids) {
        billRepository.deleteAll(ids);
        return new Result(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
    }

    @Override
    public Result update(String id, Bill bill) {
        Optional<Bill> optional = billRepository.findById(id);
        if (optional.isPresent()) {
            Bill entity = optional.get();
            entity.setUpdateTime(new Date());
            BeanUtils.copyProperties(bill, entity);
            Bill bills = billRepository.save(entity);
            return new Result<>(PhysicalConstants.UPDATE_SUCCESS,PhysicalConstants.UPDATE_SUCCESS_CN,bills);
        } else {
            throw new BusinessException(PhysicalConstants.UPDATE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result dynamicQuery(Pageable pageable, Bill bill) {
        QBill qBill = QBill.bill;
        Predicate predicate = qBill.isNotNull().or(qBill.isNull());
        predicate = StringUtils.isBlank(bill.getCode()) ? predicate:ExpressionUtils.and(predicate,qBill.code.eq(bill.getCode()));
        predicate = StringUtils.isBlank(bill.getType())?predicate:ExpressionUtils.and(predicate,qBill.type.eq(bill.getType()));
        predicate = StringUtils.isBlank(bill.getStartDate())?predicate:ExpressionUtils.and(predicate,qBill.startDate.eq(bill.getStartDate()));
        predicate = StringUtils.isBlank(bill.getReceiveDate())?predicate:ExpressionUtils.and(predicate,qBill.receiveDate.eq(bill.getReceiveDate()));
        predicate = StringUtils.isBlank(bill.getConSignMan())?predicate:ExpressionUtils.and(predicate,qBill.conSignMan.eq(bill.getConSignMan()));
        predicate = StringUtils.isBlank(bill.getSalesMan())?predicate:ExpressionUtils.and(predicate,qBill.salesMan.eq(bill.getSalesMan()));
        predicate = StringUtils.isBlank(bill.getGatherType())?predicate:ExpressionUtils.and(predicate,qBill.gatherType.eq(bill.getGatherType()));
        predicate = StringUtils.isBlank(bill.getPaymentType())?predicate:ExpressionUtils.and(predicate,qBill.paymentType.eq(bill.getPaymentType()));
        predicate = StringUtils.isBlank(bill.getServiceType())?predicate:ExpressionUtils.and(predicate,qBill.serviceType.eq(bill.getServiceType()));
        predicate = StringUtils.isBlank(bill.getSalesStation())?predicate:ExpressionUtils.and(predicate,qBill.salesStation.eq(bill.getSalesStation()));
        predicate = StringUtils.isBlank(bill.getArriveVehicleStatus())?predicate:ExpressionUtils.and(predicate,qBill.arriveVehicleStatus.eq(bill.getArriveVehicleStatus()));
        predicate = StringUtils.isBlank(bill.getPaymentCode())?predicate:ExpressionUtils.and(predicate,qBill.paymentCode.eq(bill.getPaymentCode()));
        predicate = StringUtils.isBlank(bill.getAccountBillCode())?predicate:ExpressionUtils.and(predicate,qBill.accountBillCode.eq(bill.getAccountBillCode()));
        predicate = StringUtils.isBlank(bill.getAccountBillType())?predicate:ExpressionUtils.and(predicate,qBill.accountBillType.eq(bill.getAccountBillType()));
        predicate = StringUtils.isBlank(bill.getAccountBillDate())?predicate:ExpressionUtils.and(predicate,qBill.accountBillDate.eq(bill.getAccountBillDate()));

        predicate = StringUtils.isBlank(bill.getVehicleCode())?predicate:ExpressionUtils.and(predicate,qBill.vehicleCode.eq(bill.getVehicleCode()));
        predicate = StringUtils.isBlank(bill.getVehicelBillType())?predicate:ExpressionUtils.and(predicate,qBill.vehicelBillType.eq(bill.getVehicelBillType()));
        predicate = StringUtils.isBlank(bill.getVehicleBillDate())?predicate:ExpressionUtils.and(predicate,qBill.vehicleBillDate.eq(bill.getVehicleBillDate()));

        predicate = StringUtils.isBlank(bill.getPaymentsDate())?predicate:ExpressionUtils.and(predicate,qBill.paymentsDate.eq(bill.getPaymentsDate()));
        predicate = StringUtils.isBlank(bill.getCustomerCode())?predicate:ExpressionUtils.and(predicate,qBill.customerCode.eq(bill.getCustomerCode()));
        predicate = StringUtils.isBlank(bill.getCustomerName())?predicate:ExpressionUtils.and(predicate,qBill.customerName.eq(bill.getCustomerName()));
        List<Bill> list = jpaQueryFactory.selectFrom(qBill).where(predicate).offset(pageable.getOffset()).orderBy(qBill.createTime.desc())
                .limit(pageable.getPageSize()).fetch();
        //查询条数
        Long count = jpaQueryFactory
                .selectFrom(qBill)
                .where(predicate)
                .fetchCount();
        Page<Bill> page = new PageImpl<>(list, pageable, count);
        return new Result(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,page);
    }


}
