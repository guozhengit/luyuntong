package com.aygxy.base;


/**
 * @Description: 常量抽象类
 * @Author: xmf
 * @Date: 2019/1/21-15:16
 */
@SuppressWarnings("rawtypes")
public abstract class PhysicalConstants  {
    /**********************************WebService服务常量**********************************/
    /**
     * @Fields WebService目标命名空间
     */
    @SuppressWarnings("rawtypes")
    public final static String TARGET_NAMESPACE = "http://service.web.custom.baiwang.com";
    /**
     * @Fields endpoint接口路径
     */
    @SuppressWarnings("rawtypes")
    public final static String BASE_ENDPOINT_INTERFACE = "com.baiwang.custom.web.service.";
    /**
     /**
     * @Fields 响应头部信息
     */
    @SuppressWarnings("rawtypes")
    public final static String RESPONSE_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";

    /**
     * @Fields 接收超时时间
     */
    public static final int RECEIVETIMEOUT = 3000;

    /**
     * @Fields 连接超时时间
     */
    public static final int CONNECTIONTIMEOUT = 3000;

    /**********************************响应状态信息**********************************/
    /**
     * 0	执行成功
     */
    public static final String OPERATER_SUCCESS = "0";
    public static final String OPERATER_SUCCESS_CN = "执行成功";

    /**
     * 1	更新状态
     */
    public static final String UPDATE_SUCCESS = "1";
    public static final String UPDATE_SUCCESS_CN = "更新成功";
    public static final String UPDATE_UNSUCCESS_CN = "更新失败";

    /**
     * 2	删除状态
     */
    public static final String DELETE_SUCCESS = "2";
    public static final String DELETE_SUCCESS_CN = "删除成功";
    public static final String DELETE_UNSUCCESS_CN = "删除失败";

    /**
     * 3	查询状态
     */
    public static final String REQUE_SUCCESS = "3";
    public static final String REQUE_SUCCESS_CN = "查询成功";
    public static final String REQUE_UNSUCCESS_CN = "未查询到结果";

    /**
     * 4	添加状态
     */
    public static final String ADD_SUCCESS = "4";
    public static final String ADD_SUCCESS_CN = "添加成功";
    public static final String ADD_UNSUCCESS_CN = "添加失败";


    /**
     * -1	未知错误
     */
    public final static  String UN_ERROR = "-1";
    public  final static  String UN_ERROR_CN = "未知错误";

    /**
     * 004	请求参数不正确
     */
    public final static String PARAM_NULL = "002";
    public final static String PARAM_NULL_EN = "传入参数为空";

    /**
     * 005	请求参数不正确
     */
    public static final String REQ_PARAMS_ERROR = "005";
    public static final String REQ_PARAMS_ERROR_CN = "请求参数不正确";

    /**********************************业务状态信息**********************************/



}
