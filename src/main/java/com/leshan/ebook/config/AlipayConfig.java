package com.leshan.ebook.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092700604763";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC69YeiYN9UFOQODqnEGg3IzrLXcBISlLkpO7te2EvYyg248Kz3N18Ap4PS3b8PL7/RGOgZBlBQhUF0m+EJZxkUD79c8oZGAFkpMrqG3q6HdUsP+m+kqFcnUqrFORL2cql629doEv8/PbHQbibAKVYX5j3gwQre12lPDDmXagAupaPEH3mozGSJDoEVU5CrI3daa+I6TKishi3Q4dzFagpdx2UQfOX+kgdD/B3N3Ue6E5UFQjXtuY9fjWLc03PAE+ny6Sm67mtWbFLozziPGBQ5JDairBO6JcRSWbJyS+t7qxnyCMGjbPUt6rcJSrRK3hKeB6nqJSGwwVRhm1oxSu4rAgMBAAECggEAGSwl7v8MEs4dRqdCxFydroPmIIu+YzITHDImsEZ/L9lEr7n4D/EsoXHsld+1cd4D/atU1Mm81pqajZDPY+y1u7XDFkixO4ugdaOW6cHhzetFCAm4LntcALdottVQcE5P83LWNfUY2PL9lgq+vPDT3rPpcPGM/SQT0cjbmD91dtIrqIEacHYMId20Zv3xJDOQpT3Yi/Q/W7I5VGy4LMITL6OXimzVLR1Sedh2h0itq5/py+Hqus51hDANUXv004uBeGDktnI+a8TLpOd5Uyzy4ReNP7wphSHJGz3/iwGLZpYilX0B8C66BqvcPC0kaeuvDi52kj3ObB5tWL6LaSd/wQKBgQDciuDB1xYqWyiu8XJtIYDjAmchqYCeWMVVJijIRIWnef1JYqXukLUzN7NFgbFfFoR1Fcp/Vxs5XHqioDn9jx2xwaEQEJ0uZYYdFY93xvDOADChCrhYyXApl4C3kg4vOkodbIyji2NYwHadlFccv8gxXOpAMUYqghJGckTDmps8zQKBgQDZBGvkGpNHpK09dqtKAMuFAJASrL3JV6crkFIg/mPOw5BXJxkf/TlyINsNr8NSlMZwIUKamZnqtSj9ADfMi3gL+14AYtzRTpJw9b2ZeyXwLB2kPHdKka/aaPG7t5fVjMPTGoBP1/XRpxL/7OeBhYMrAZfSJOZfkaW6Z66p3HZW1wKBgQCUcaX20x9IQzOPDVVHv1VRdzyTm9PGwVmRhq3MntKXd7TUwGGPwjc00jkIf9MzfaSKarByJd9dLLIe5FokIUCLdRlEBurFX/B1gx2eMXnELryMqPqMSIoGdMNezCBgCYv5YicHrbqg8mrkhgRchXnqP/AsZP4lfodug1tljZsPwQKBgENXC+OMG4dvohIgcKZV+NEci5g/4eRIPqdV8SYryeyu4msoxrMWcGzppQ9qKsHFSI4iw/gVEZ2y+TUIjEf8PxP4vAKCquKH7wj+OAcYH32XMttzp9CLxHWRevE01vh85YbsAkTETpLvtQWVDYEzXLBLnkCnEpU1LKfa5Gfw8QehAoGAepwwg8xAv0a46MAMiP3f6ai8/QldWH5sRgTUhd5bu69/9IQZXcZ0KarR0bwY8TZmsVpaM2cFx0wiebZP2Up75AcsfOxRFz/HTz8SKZKxiQcSb9P+RRT8qWzIBo+RjcyEQDqhZ0u6Oc9V8Nq4zsqaoV1wxBPGjDq6rc8Ovc1dX7U=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjb9u/4FUJh10/QyWbg6UUmpOio2KDRt6gDII9BAewTMeO0ixQaAs/WSx+VoEklAHuQdtyUkkl7mMNtRqNI4MU5Ia+wtC9zhPNnyEOFYHdz1PYVO8XX4ewYeMIa410lCYOyiBL5Hz0Jx/WBb/OXz1lsLXpRwsnlbUfplfEgmvLWgni/kERD28wOPcGNfnziXmPzXn7Y0Xaa1aXPMXoCvZbYwiX0+oA+bK1RksXFKw6RzhdRzmXBIZkTX+KD1oeHW3vcYF6glxJlIOJWw1oXxCi3Nn2rXBTIrh77of0tAhR+A541y/r6daEeEVeHbsbMRFAbSF/YFXShWmvHEhdN2rEQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://learningit.free.svipss.top/order/update";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://learningit.free.svipss.top"; //localhost:8080

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
