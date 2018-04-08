package xuanfeng.web.pojo;

/**
 * @author LiaoYangJun
 * @createTime 2018/3/30.
 */
public class VoicePostMsg {

    private String mobile;
    private String userid;
    private String pwd;
    private String content;
    private String apikey;
    private String msgtype;

    @Override
    public String toString() {
        return "VoicePostMsg{" +
                "mobile='" + mobile + '\'' +
                ", userid='" + userid + '\'' +
                ", pwd='" + pwd + '\'' +
                ", content='" + content + '\'' +
                ", apikey='" + apikey + '\'' +
                ", msgtype='" + msgtype + '\'' +
                '}';
    }

    public VoicePostMsg() {
    }

    public VoicePostMsg(String mobile, String userid, String pwd, String content, String apikey, String msgtype) {
        this.mobile = mobile;
        this.userid = userid;
        this.pwd = pwd;
        this.content = content;
        this.apikey = apikey;
        this.msgtype = msgtype;
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

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
}
