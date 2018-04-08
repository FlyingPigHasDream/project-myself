package xuanfeng.web.pojo;

/**
 * @author LiaoYangJun
 * @createTime 2018/3/24.
 * 温湿度信息封装类
 */
public class MsgData {

    private String msgId;
    private String temperature;
    private String humidity;
    private String insertDateTime;

    public MsgData() {
    }

    @Override
    public String toString() {
        return "MsgData{" +
                "msgId='" + msgId + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", insertDateTime='" + insertDateTime + '\'' +
                '}';
    }

    public MsgData(String msgId, String temperature, String humidity, String insertDateTime) {
        this.msgId = msgId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.insertDateTime = insertDateTime;
    }

    public String getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(String insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
