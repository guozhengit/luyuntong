package com.aygxy.jpa.entity;

import com.aygxy.jpa.BaseNamedJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Description: 时间司机信息实体
 * @Author: xmf
 * @Date: 2019/4/6-22:41
 */
@Getter
@Setter
@Entity
@Table(name = "physical_driver_info")
public class Driver extends BaseNamedJpaEntity {
    //司机id //司机名称
    //司机编号
    @Column(name = "driver_code",columnDefinition = "varchar(100)")
    private String code;

    @Column(name = "driver_name",columnDefinition = "varchar(100)")
    private String driverName;
    //身份证号
    @Column(name = "id_card",columnDefinition = "varchar(200)")
    private String idCard;
    //籍贯
    @Column(name = "native_place",columnDefinition = "varchar(200)")
    private String nativePlace;
    //站点编号 --StationEntity
    @Column(name = "station_code",columnDefinition = "varchar(200)")
    private String stationCode;
    //电话
    @Column(name = "phone",columnDefinition = "varchar(200)")
    private String phone;
    //性别
    @Column(name = "gender",columnDefinition = "varchar(200)")
    private String gender;
    //生日
    @Column(name = "birthday",columnDefinition = "varchar(200)")
    private String birthday;
    //地址
    @Column(name = "address",columnDefinition = "varchar(200)")
    private String address;
    //驾驶证
    @Column(name = "drive_licence",columnDefinition = "varchar(200)")
    private String driveLicence;
    //行驶证
    @Column(name = "run_licence",columnDefinition = "varchar(200)")
    private String runLicence;
    //运营证
    @Column(name = "biz_licence",columnDefinition = "varchar(200)")
    private String bizLicence;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_code",insertable = false,updatable = false)//Driver中的id字段参考Vehicle表中的id字段
    private Vehicle vehicle;


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Driver{");
        sb.append("code='").append(code).append('\'');
        sb.append(", idCard='").append(idCard).append('\'');
        sb.append(", nativePlace='").append(nativePlace).append('\'');
        sb.append(", stationCode='").append(stationCode).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", birthday='").append(birthday).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", driveLicence='").append(driveLicence).append('\'');
        sb.append(", runLicence='").append(runLicence).append('\'');
        sb.append(", bizLicence='").append(bizLicence).append('\'');
        sb.append(", vehicle=").append(vehicle);
        sb.append('}');
        return sb.toString();
    }
}
