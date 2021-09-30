package com.leshan.ebook.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016100100639421";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDBQ/bVvKP0NUeMRCcqko0rIKVAsAg3c8C0Fy4haptgOCNshS2P8AQEfVstTcbEhuGQvqOCi2rJ5xzPWeCHHgudoIugxERd16SSTQODklIjz3lUc6EGKLoAh2AzYEGST5Ib6UFlyVG6Trk8UFYRkDGgsV6/bNE6F8ewb81xrZ0Cw5V+FtbmMT+UzaUipZFgqopMD8FBOHZmpLFtaHLAjYisihgI2mP5WPnBoPPB4LjTw2SYKxlnPpeuwBPUZCfGyi2ViE4OitKUnsTvxJ0oEfJD+2PGDK8ZKwcsESikTid5YOBnDg8KCpzIIv7E5fJTUJ+Yb5nbtkhfTSHUq38SnSE/AgMBAAECggEAVeWnJ4gYNsoXarg/0CQiqjBwQjf67up7k49Z6XBAbpuE4w6uGXNL1dMBWzleRqrMRlD0y2i7pdEadO41ZNhtwTlB1cpluG/HrV6dWTUHXPMxsd9SijI/uUxx7WOywRysi8s4Tc0UjgG/QpdSKaw04n7y5ZGvzGoVTs3iOcw4JKmTZWWh/0mdLBrZ9k9O6HISmU1tnjXhbraZ+CRmsqwW5R5c3FJmYkh6DrrBgaQLpN/99UNwRDDTZarVYxeb1Ywt9pJ4tVDyyZxwAJMwFG8TBVpv3AossbRLf6MXwX4G+PltfNOfsQAIBgjW34Um4rlN5c4mBQofpFFMDX6r7F1mQQKBgQDgCXlkxt6IVQqCpuvyY24XSad/zdcfAphRg3We8jttJuxhfp7vD5N2p0fqes9ExVADtW/qdEwNypci+y778IUVEfQSUlKZR5LuyKs0MSVSEXOVh3kayWz7ViBm0v+PuyfyWtHZT62QF01634U7RXQtaENDpoM1TdUEvDtivBsAUwKBgQDc1p5demnhCJGDOFtJ/HQ/uTbERCvWnLfbCdA+r5ITfvXvZb9ny1ZQNIgAYT7Bz8Wv3koTY/8yuDtD1Tn2NxZO+vZSloTKeCc+TwHrrMEbw5pkXtTAJqwkROcPQmKyikJvbybvuoGsGfDApBgrNTu2C6WEp6nbm2jsYYlo8xPt5QKBgHrVNvWGA6SD28tecabn1Qh3nZp45SVfatvmU6rd7K8f1CJwJfu0colvlgJ9av6tn/0okT/em4REOzE2vr/rU0wGF+ejsx3PHERHSXbIK0ofv1uQd1m0bkgvJHy72tqXJoO+P6gCA4so+5YOzyF8JwJuU9LXjMDA97Ys7fJoZ/V5AoGAQBZ8kO40idzdtbIGNBtydQfAEAcknbyPUp6vc3GqN8QxhQ8HFA0beF02Vr3h44bzfM1KvAPaDJMQh+f6USy9aaBFGcSattNVuCxfh1B0HiWOybAHl9fhPwlL8M64K84Z55LfPtTmStagWpeEeA2TzYnlt/CcR6H7OhY4NV/Nmc0CgYEAw6nKzwHpMQ4R4jI3cb9QfduuRV9C6A0lmDTzJOeg0KCjwbBcDTFYE5JpIrd19b4m8+e2pJXKrNOZmIj7QYKls7ea0USbCxplBSJ/wooUTyQOFnbrF0B3CXaoDCtlZ03CTfL4f19AnR68jFlC0k6lBvcjlAj0uxXlR14BEPAMThk=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjb9u/4FUJh10/QyWbg6UUmpOio2KDRt6gDII9BAewTMeO0ixQaAs/WSx+VoEklAHuQdtyUkkl7mMNtRqNI4MU5Ia+wtC9zhPNnyEOFYHdz1PYVO8XX4ewYeMIa410lCYOyiBL5Hz0Jx/WBb/OXz1lsLXpRwsnlbUfplfEgmvLWgni/kERD28wOPcGNfnziXmPzXn7Y0Xaa1aXPMXoCvZbYwiX0+oA+bK1RksXFKw6RzhdRzmXBIZkTX+KD1oeHW3vcYF6glxJlIOJWw1oXxCi3Nn2rXBTIrh77of0tAhR+A541y/r6daEeEVeHbsbMRFAbSF/YFXShWmvHEhdN2rEQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://xiangwei.free.svipss.top/order/update";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://xiangwei.free.svipss.top"; //localhost:8080

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
