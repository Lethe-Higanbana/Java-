package com.summersky.springboottimingtsk.shortmessage;

/**
 * @Authur:zengfanbin
 * @Date:2019-9-25
 * @Time:12:13
 * @Description:
 */

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 短信下发服务，这里使用的是阿里云的短信服务（免费测试版），腾讯云的不好申请
 * 备注:Demo工程编码采用UTF-8
 * 国际短信发送请勿参照此DEMO
 * 工程依赖了2个jar包
 *   1:aliyun-java-sdk-core.jar
 *   2:aliyun-java-sdk-dysmsapi.jar
 */
public class messages {

    //产品名称：云通信短信API产品，开发者无需替换
    static final String product="Dysmsapi";

    //产品域名，开发者无需替换
    static final String domain="dysmsapi.aliyuncs.com";

    //这两个参数需要自行去阿里云申请，在阿里云访问控制台查看，详情参考官网
    //AccessKey ID LTAI4Fx2bRoJaPbMxvFmBoE9
    //AccessKeySecret exFokbpFmiZigolFfkkqzFxQKOGQcR
    static final String accessKeyId="LTAI4Fx2bRoJaPbMxvFmBoE9";
    static final String accessKeySecret="exFokbpFmiZigolFfkkqzFxQKOGQcR";

    /**
     * 发送短信
     * @return
     * @throws ClientException
     */
    public static SendSmsResponse sendSms() throws ClientException{

        //设置超时时间 设置指定键对值的系统属性
        // setProperty (String prop, String value);
        System.setProperty("sun.net.client.defaultConnectTimeout","10000");
        System.setProperty("sun.net.client.defaultReadTimeout","10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers("13879612624");
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("SummerSky");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_174811811");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"123\"}");

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }

    public static QuerySendDetailsResponse querySendDetails(String bizId) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber("13879612624");
        //可选-流水号
        request.setBizId(bizId);
        //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(new Date()));
        //必填-页大小
        request.setPageSize(10L);
        //必填-当前页码从1开始计数
        request.setCurrentPage(1L);

        //hint 此处可能会抛出异常，注意catch
        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);

        return querySendDetailsResponse;
    }
}
