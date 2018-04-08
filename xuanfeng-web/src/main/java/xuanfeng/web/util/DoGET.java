package xuanfeng.web.util;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import xuanfeng.web.pojo.EmailPostMsg;
import xuanfeng.web.pojo.MsgData;
import xuanfeng.web.pojo.VoicePostMsg;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DoGET {

  /*  public static void main(String[] args) throws Exception {

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 创建http GET请求
        HttpGet httpGet = new HttpGet("http://www.baidu.com/");

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("内容长度："+content.length());
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }

    }*/

    public static void dogetSentMsg(String url, String msg) throws Exception {
        System.out.println("doget");
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 创建http GET请求
        HttpGet httpGet = new HttpGet(url+ "?mobile=17689600017&userid=E102NO&pwd=b5hCjD&content=" +msg +"&apikey=5e1137b2f52f7e65ee4bf6a8ee4a4fa8");

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("内容长度："+content.length());
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
    }

    public static void doPostGetMsg(String url, String msg, Long tel) throws Exception{
        System.out.println("dopost");
        System.out.println(msg);
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);

        httpPost.addHeader("Content-type","application/json; charset=utf-8");
        httpPost.setHeader("Accept", "application/json");
        // 设置2个post参数，一个是scope、一个是q
      /*  List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        parameters.add(new BasicNameValuePair("mobile",String.valueOf(tel) ));
        parameters.add(new BasicNameValuePair("userid", "E102NO"));
        parameters.add(new BasicNameValuePair("pwd", "b5hCjD"));
        parameters.add(new BasicNameValuePair("content", msg));
        parameters.add(new BasicNameValuePair("apikey", "5e1137b2f52f7e65ee4bf6a8ee4a4fa8"));
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
*/

        EmailPostMsg emailPostMsg = new EmailPostMsg();
        emailPostMsg.setMobile(String.valueOf(tel));
        emailPostMsg.setUserid("E102NO");
        emailPostMsg.setPwd("b5hCjD");
        emailPostMsg.setApikey("5e1137b2f52f7e65ee4bf6a8ee4a4fa8");
        emailPostMsg.setContent(msg);
        System.out.println(JSON.toJSONString(emailPostMsg));

        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(new StringEntity(JSON.toJSONString(emailPostMsg), Charset.forName("UTF-8")));

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
    }


    public static void doPostGetVoice(String url, String msg, Long tel) throws Exception{
        System.out.println("dopost");
        System.out.println(msg);
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);

        httpPost.addHeader("Content-type","application/json; charset=utf-8");
        httpPost.setHeader("Accept", "application/json");

        VoicePostMsg voicePostMsg = new VoicePostMsg();
        voicePostMsg.setMobile(String.valueOf(tel));
        voicePostMsg.setUserid("E102NO");
        voicePostMsg.setPwd("b5hCjD");
        voicePostMsg.setApikey("5e1137b2f52f7e65ee4bf6a8ee4a4fa8");
        voicePostMsg.setContent(msg);
        voicePostMsg.setMsgtype(String.valueOf(1));
        System.out.println(JSON.toJSONString(voicePostMsg));

        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(new StringEntity(JSON.toJSONString(voicePostMsg), Charset.forName("UTF-8")));

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
    }
}
