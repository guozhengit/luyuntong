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
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    @Override
    public Result add(Bill bill) {
        try {
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
        predicate = StringUtils.isBlank(bill.getConSignMan())?predicate:ExpressionUtils.and(predicate,qBill.conSignMan.eq(bill.getConSignMan()));
        predicate = StringUtils.isBlank(bill.getGatherType())?predicate:ExpressionUtils.and(predicate,qBill.gatherType.eq(bill.getGatherType()));
        predicate = StringUtils.isBlank(bill.getSalesMan())?predicate:ExpressionUtils.and(predicate,qBill.salesMan.eq(bill.getSalesMan()));
        predicate = StringUtils.isBlank(bill.getType())?predicate:ExpressionUtils.and(predicate,qBill.type.eq(bill.getType()));
        predicate = StringUtils.isBlank(bill.getCustomerCode())?predicate:ExpressionUtils.and(predicate,qBill.customerCode.eq(bill.getCustomerCode()));
        predicate = StringUtils.isBlank(bill.getVehicleCode())?predicate:ExpressionUtils.and(predicate,qBill.vehicleCode.eq(bill.getVehicleCode()));
        predicate = StringUtils.isBlank(bill.getServiceType())?predicate:ExpressionUtils.and(predicate,qBill.serviceType.eq(bill.getServiceType()));
        predicate = StringUtils.isBlank(bill.getSalesStation())?predicate:ExpressionUtils.and(predicate,qBill.salesStation.eq(bill.getSalesStation()));
        predicate = StringUtils.isBlank(bill.getDepartVehicleStatus())?predicate:ExpressionUtils.and(predicate,qBill.DepartVehicleStatus.eq(bill.getDepartVehicleStatus()));

        predicate = ExpressionUtils.and(predicate,qBill.conSignMan.eq(bill.getConSignMan()));
        predicate = StringUtils.isBlank(bill.getConSignMan())?predicate:ExpressionUtils.and(predicate,qBill.conSignMan.eq(bill.getConSignMan()));
        predicate = StringUtils.isBlank(bill.getConSignMan())?predicate:ExpressionUtils.and(predicate,qBill.conSignMan.eq(bill.getConSignMan()));
        predicate = StringUtils.isBlank(bill.getConSignMan())?predicate:ExpressionUtils.and(predicate,qBill.conSignMan.eq(bill.getConSignMan()));
        predicate = StringUtils.isBlank(bill.getConSignMan())?predicate:ExpressionUtils.and(predicate,qBill.conSignMan.eq(bill.getConSignMan()));
        predicate = StringUtils.isBlank(bill.getConSignMan())?predicate:ExpressionUtils.and(predicate,qBill.conSignMan.eq(bill.getConSignMan()));
        predicate = StringUtils.isBlank(bill.getConSignMan())?predicate:ExpressionUtils.and(predicate,qBill.conSignMan.eq(bill.getConSignMan()));
        predicate = StringUtils.isBlank(bill.getConSignMan())?predicate:ExpressionUtils.and(predicate,qBill.conSignMan.eq(bill.getConSignMan()));
        predicate = StringUtils.isBlank(bill.getConSignMan())?predicate:ExpressionUtils.and(predicate,qBill.conSignMan.eq(bill.getConSignMan()));
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
