package xuanfeng.web.pojo;

/**
 * @author LiaoYangJun
 * @createTime 2018/3/30.
 */
public class EmailPostMsg {
    /*
            List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        parameters.add(new BasicNameValuePair("mobile",String.valueOf(tel) ));
        parameters.add(new BasicNameValuePair("userid", "E102NO"));
        parameters.add(new BasicNameValuePair("pwd", "b5hCjD"));
        parameters.add(new BasicNameValuePair("content", msg));
        parameters.add(new BasicNameValuePair("apikey", "5e1137b2f52f7e65ee4bf6a8ee4a4fa8"));
    */
    private String mobile;
    private String userid;
    private String pwd;
    private String content;
    private String apikey;

    public EmailPostMsg() {
    }

    @Override
    public String toString() {
        return "EmailPostMsg{" +
                "mobile='" + mobile + '\'' +
                ", userid='" + userid + '\'' +
                ", pwd='" + pwd + '\'' +
                ", content='" + content + '\'' +
                ", apikey='" + apikey + '\'' +
                '}';
    }

    public EmailPostMsg(String mobile, String userid, String pwd, String content, String apikey) {
        this.mobile = mobile;
        this.userid = userid;
        this.pwd = pwd;
        this.content = content;
        this.apikey = apikey;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}
