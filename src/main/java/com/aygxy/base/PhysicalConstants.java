package com.aygxy.base;


/**
 * @Description: 常量抽象类
 * @Author: xmf
 * @Date: 2019/1/21-15:16
 */
@SuppressWarnings("rawtypes")
public interface PhysicalConstants  {
    /**********************************WebService服务常量**********************************/
    /**
     * @Fields WebService目标命名空间
     */
    String TARGET_NAMESPACE = "http://service.web.custom.baiwang.com";
    /**
     * @Fields endpoint接口路径
     */
    String BASE_ENDPOINT_INTERFACE = "com.baiwang.custom.web.service.";
    /**
     /**
     * @Fields 响应头部信息
     */
     String RESPONSE_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";

    /**
     * @Fields 接收超时时间
     */
    int RECEIVETIMEOUT = 3000;

    /**
     * @Fields 连接超时时间
     */
    int CONNECTIONTIMEOUT = 3000;

    /**********************************响应状态信息**********************************/
    /**
     * 0	执行成功
     */
    String OPERATER_SUCCESS = "0";
    String OPERATER_SUCCESS_CN = "执行成功";

    /**
     * 1	更新状态
     */
    String UPDATE_SUCCESS = "1";
    String UPDATE_SUCCESS_CN = "更新成功";
    String UPDATE_UNSUCCESS_CN = "更新失败";

    /**
     * 2	删除状态
     */
    String DELETE_SUCCESS = "2";
    String DELETE_SUCCESS_CN = "删除成功";
    String DELETE_UNSUCCESS_CN = "删除失败";

    /**
     * 3	查询状态
     */
    String REQUE_SUCCESS = "3";
    String REQUE_SUCCESS_CN = "查询成功";
    String REQUE_UNSUCCESS_CN = "未查询到结果";

    /**
     * 4	添加状态
     */
    String ADD_SUCCESS = "4";
    String ADD_SUCCESS_CN = "添加成功";
    String ADD_UNSUCCESS_CN = "添加失败";


    /**
     * -1	未知错误
     */
    String UN_ERROR = "-1";
    String UN_ERROR_CN = "未知错误";

    /**
     * 004	请求参数不正确
     */
    String PARAM_NULL = "002";
    String PARAM_NULL_EN = "传入参数为空";


    String AUTH_SUCCESS = "200";
    String AUTH_ERROR = "401";

    /**
     * 005	请求参数不正确
     */
    String REQ_PARAMS_ERROR = "005";
    String REQ_PARAMS_ERROR_CN = "请求参数不正确";

    /**********************************业务状态信息**********************************/



}
