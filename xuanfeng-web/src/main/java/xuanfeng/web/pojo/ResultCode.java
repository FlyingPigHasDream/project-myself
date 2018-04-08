package xuanfeng.web.pojo;

/**
 * @author LiaoYangJun
 * @createTime 2018/3/24.
 * Http返回状态封装类
 */
public class ResultCode {

    private String code;
    private String msg;

    public ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
