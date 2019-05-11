package com.aygxy.service.impl;

import com.aygxy.jpa.entity.*;
import com.aygxy.util.RandomUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 造假数据
 * @Author: xmf
 * @Date: 2019/5/11-20:44
 */
@Service
public class MockDataService {
    private static Date date = new Date();

    public User mockUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        user.setBirthDay(RandomUtil.randomBirth(20, 40, "yyyy-MM-dd"));
        user.setEmail(RandomUtil.getEmail(6, 10));
        user.setPhone(RandomUtil.getTel());
        user.setAge(String.valueOf(RandomUtil.getNum(20, 40)));
        user.setPassword(encode);
        user.setCode("15031010".concat(RandomUtil.getStringBumber(3)));
        user.setName(user.getCode());
        return user;
    }

    public City mockCity(City city) {
        city.setName(RandomUtil.getCity());
        city.setCreateTime(date);
        city.setDistrict(String.valueOf(RandomUtil.getNum(100, 800)).concat("Km"));
        city.setLocation(RandomUtil.getStation());
        return city;
    }

    public Route mockRoute(Route route) {
        route.setCreateTime(date);
        route.setCityDistance(String.valueOf(RandomUtil.getNum(100, 800)).concat("Km"));
        route.setRouteName(RandomUtil.getStation().concat("线"));
        route.setStartCity(RandomUtil.getCity());
        route.setStationDistance(String.valueOf(RandomUtil.getNum(100, 800)).concat("Km"));
        route.setTargetStation(RandomUtil.getStation());
        route.setTransferCity(RandomUtil.getCity());
        route.setTransferStation(RandomUtil.getStation());
        route.setTargetCity(RandomUtil.getCity());
        route.setStartStation(RandomUtil.getStation());
        return route;

    }

    public Driver mockDriver(Driver driver) {
        driver.setName(RandomUtil.getChineseName());
        driver.setCreateTime(date);
        driver.setDriverName(RandomUtil.getChineseName());
        //身份证号
        driver.setIdCard(RandomUtil.getRandomID());
        //籍贯
        driver.setNativePlace(RandomUtil.getRoad());
        //电话
        driver.setPhone(RandomUtil.getTel());
        //性别
        driver.setGender(RandomUtil.getSex());
        //生日
        driver.setBirthday(RandomUtil.randomBirth(20, 30, "yyyy-MM-dd"));
        //地址
        driver.setAddress(RandomUtil.getRoad());
        //驾驶证
        driver.setDriveLicence(RandomUtil.getStringBumber(10).concat(RandomUtil.getStringBumber(8)));
        //行驶证
        driver.setRunLicence(RandomUtil.getStringBumber(4).concat(RandomUtil.getStringBumber(8)));
        //运营证
        driver.setBizLicence(RandomUtil.getStringBumber(4).concat(RandomUtil.getStringBumber(8)));
        return driver;
    }

    public Customer mockCoutomer(Customer customer) {
        customer.setName(RandomUtil.getChineseName());
        customer.setCreateTime(date);
        //详细地址
        customer.setDetailAddress(RandomUtil.getRoad());

        //邮编
        customer.setPostCode(RandomUtil.getStringBumber(6));

        //联系电话
        customer.setLinkMobile(RandomUtil.getTel());

        //客户类型
        customer.setType(RandomUtil.getStringBumber((new int[]{1,2,3}), 1));

        //企业性质
        customer.setEnterpriseProperty(RandomUtil.getStringBumber((new int[]{1, 2}), 1));

        //企业规模
        customer.setEnterpriseSize(RandomUtil.getStringBumber(3));

        //电子邮箱
        customer.setEMail(RandomUtil.getEmail(6,10));
        return customer;
    }

    public Vehicle mockVehicle(Vehicle vehicle) {

        vehicle.setCreateTime(date);
        //车辆所属人
        vehicle.setOwner(RandomUtil.getChineseName());
        //车辆类型
        vehicle.setType(RandomUtil.getStringBumber((new int[]{1, 2, 3, 4}), 1));
        //车辆型号
        vehicle.setModel(RandomUtil.getStringBumber(6));
        //车身长度
        vehicle.setLength(RandomUtil.getStringBumber((new int[]{4, 5, 6, 7, 8}), 1) + "M");
        //车身高度
        vehicle.setHigh(RandomUtil.getStringBumber((new int[]{4,5}), 1) + "M");
        //车身宽度
        vehicle.setWidth(RandomUtil.getStringBumber((new int[]{2,3,4}), 1) + "M");
        //车辆准载体积
        vehicle.setAllowCarryVolume(RandomUtil.getStringBumber(3).concat("L"));
        //车辆准载重量
        vehicle.setAllowCarryWeight(RandomUtil.getStringBumber(3).concat("T"));
        //测量准载高度
        vehicle.setAllowCarryHigh(RandomUtil.getStringBumber((new int[]{4, 5}), 1).concat("M"));
        //车辆使用年限
        vehicle.setUseAge(RandomUtil.getStringBumber(1));
        //车辆车架编号
        vehicle.setFrameNo(RandomUtil.getStringBumber(6));
        //车辆发动机型号
        vehicle.setEngineNo(RandomUtil.getStringBumber(6));
        //保险卡号
        vehicle.setInsuranceCard(RandomUtil.getStringBumber(8));

        vehicle.setDetailGoodCode(RandomUtil.getStringBumber(6));

        return vehicle;
    }

    public Station mockStation(Station station) {
        station.setCreateTime(date);
        //站点负责人
        station.setPrincipal(RandomUtil.getChineseName());
        //联系电话
        station.setLinkPhone(RandomUtil.getTel());
        //详细地址
        station.setDetailAddress(RandomUtil.getRoad());
        //邮编
        station.setPostCode(RandomUtil.getStringBumber(6));
        return station;
    }

    public Employee mockEmployee(Employee employee) {

        employee.setName(RandomUtil.getChineseName());
        employee.setCreateTime(date);

        employee.setEmployeeName(RandomUtil.getChineseName());
        //生日
        employee.setBirthday(RandomUtil.randomBirth(20, 50, "yyyy-MM-dd"));
        //年龄
        employee.setAge(RandomUtil.getStringBumber(2));
        //职位
        employee.setPosition("员工");
        //性别
        employee.setGender(RandomUtil.getSex());
        //薪资
        employee.setSalary(new BigDecimal(RandomUtil.getStringBumber(4)));
        //奖金
        employee.setBonus(new BigDecimal(RandomUtil.getStringBumber(4)));
        return employee;
    }

    //填装合法数据
    public Bill setMockBill(Bill bill) {
        bill.setCreateTime(date);
        bill.setCode(StringUtils.isEmpty(bill.getCode())?"TY".concat(RandomUtil.getStringBumber(6)):bill.getCode());
        bill.setType(RandomUtil.getStringBumber(new int[]{1, 2,3}, 1));
        bill.setSalesMan(RandomUtil.getChineseName());
        bill.setConSignMan(RandomUtil.getChineseName());
        bill.setConSignPhone(RandomUtil.getTel());
        bill.setStartAddress(RandomUtil.getRoad());
        bill.setStartRegion(RandomUtil.getStation());
        bill.setStartPostCode(RandomUtil.getStringBumber(6));
        bill.setStartDate(RandomUtil.randomBirth());
        bill.setStartStation(RandomUtil.getStation());
        bill.setReceiveMan(RandomUtil.getChineseName());
        bill.setReceivePhone(RandomUtil.getTel());
        bill.setReceiveAddress(RandomUtil.getRoad());
        bill.setReceiveDate(RandomUtil.randomBirth());
        bill.setTargetStation(RandomUtil.getStation());
        bill.setServiceType(RandomUtil.getStringBumber((new int[]{1, 2, 3}), 1));
        bill.setTransportationType(RandomUtil.getStringBumber((new int[]{1, 2, 3}), 1));
        bill.setOtherCost(new BigDecimal(RandomUtil.getStringBumber(4)));
        bill.setLogisticsCost(new BigDecimal(RandomUtil.getStringBumber(4)));
        bill.setTransportCost(new BigDecimal(RandomUtil.getStringBumber(4)));
        bill.setPaymentType(RandomUtil.getStringBumber((new int[]{1, 2, 3}), 1));
        bill.setAccountPayable(new BigDecimal(RandomUtil.getStringBumber(4)));
        bill.setRealityPayable(new BigDecimal(RandomUtil.getStringBumber(4)));
        bill.setUnReceivedPayable(new BigDecimal(RandomUtil.getStringBumber(3)));
        bill.setAllowancePayable(new BigDecimal(RandomUtil.getStringBumber(3)));
        bill.setArriveVehicleStatus(RandomUtil.getStringBumber((new int[]{1, 2, 3}), 1));
        bill.setDepartVehicleStatus(RandomUtil.getStringBumber((new int[]{1, 2, 3}), 1));
        bill.setVehicleCode(RandomUtil.generateCarID());
        bill.setVehicleType(RandomUtil.getStringBumber((new int[]{1, 2, 3}), 1));
        bill.setDriverName(RandomUtil.getChineseName());
        bill.setDriverPhone(RandomUtil.getTel());
        bill.setIncomePayable(new BigDecimal(RandomUtil.getStringBumber(4)));
        bill.setExpendPayable(new BigDecimal(RandomUtil.getStringBumber(4)));
        bill.setPaymentsTotal(new BigDecimal(RandomUtil.getStringBumber(5)));
        bill.setPaymentsDate(RandomUtil.randomBirth());
        bill.setVehicleBillCode("VB".concat(RandomUtil.getStringBumber(6)));
        bill.setVehicelBillType(RandomUtil.getStringBumber((new int[]{1, 2, 3, 4}), 1));
        bill.setVehicleBillDate(RandomUtil.randomBirth());
        bill.setAccountBillCode("BD".concat(RandomUtil.getStringBumber(6)));
        bill.setAccountBillType(RandomUtil.getStringBumber((new int[]{1, 2, 3, 4}), 1));
        bill.setAccountBillDate(RandomUtil.randomBirth());
        bill.setPaymentCode("PAY".concat(RandomUtil.getStringBumber(6)));
        bill.setCustomerName(RandomUtil.getChineseName());
        bill.setTargetPostCode(RandomUtil.getStringBumber(6));
        bill.setTargetRegion(RandomUtil.getStation());
        bill.setCustomerCode(RandomUtil.getStringBumber(5));
        bill.setDetailGoodsCustomerCode("DC".concat(RandomUtil.getStringBumber(6)));
        bill.setDetailPaymentCustomerCode("PC".concat(RandomUtil.getStringBumber(6)));
        bill.setSalesStation(RandomUtil.getStation());
        bill.setGatherType(RandomUtil.getStringBumber((new int[]{1, 2, 3}), 1));
        return bill;
    }
}
