package com.aygxy;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.TimeZone;

/**
 * @Description: SpringBoot启动类
 * @Author: 夏明凤
 * @Date: 2019/1/3-9:44
 */
@SpringBootApplication
//定时任务
@EnableScheduling
@MapperScan(basePackages = {"com.aygxy.dao"})
//过滤器
@ServletComponentScan
public class LuYunTongApplication extends SpringBootServletInitializer {
    private static Logger logger = LoggerFactory.getLogger(LuYunTongApplication.class.getName());
    /**
     * 实现SpringBootServletInitializer可以让spring-boot项目在web容器中运行
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(LuYunTongApplication.class);
    }

    @PostConstruct
    void setDefaultTimezone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        logger.info("当前时区消息{}",TimeZone.getTimeZone("Asia/Shanghai"));
    }
    //让Spring管理JPAQueryFactory
    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }

    public static void main(String[] args){
        SpringApplication.run(LuYunTongApplication.class,args);
        logger.info("[---------陆运物流管理系统启动成功！----------]");
    }
}
