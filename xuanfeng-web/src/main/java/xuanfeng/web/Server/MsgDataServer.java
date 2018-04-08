package xuanfeng.web.Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanfeng.web.dao.MsgDataDao;
import xuanfeng.web.pojo.MsgData;
import xuanfeng.web.util.DoGET;

/**
 * @author LiaoYangJun
 * @createTime 2018/3/24.
 */
@Service
public class MsgDataServer {

    @Autowired
    @SuppressWarnings("all")
    private MsgDataDao MsgDataDao;

    public void msgDataInsert(MsgData msgData, Long tel) throws Exception {
            String msg = "";
            String voice = "";
            String url = "http://api01.monyun.cn:7901/sms/v2/std/send_single";
            String urlVoice = "http://api01.monyun.cn:7901/voice/v2/std/template_send";

            if (Integer.parseInt(msgData.getTemperature()) > 50 || Integer.parseInt(msgData.getTemperature()) < 0) {
                msg = "温度警报：温度节点" + msgData.getMsgId() + "当前温度为" + msgData.getTemperature() + "摄氏度";
                voice = "温度警报请及时去后台查看并进行处理。";
            }

            if (Integer.parseInt(msgData.getHumidity()) > 200 || Integer.parseInt(msgData.getHumidity()) < 20) {
                msg  = "湿度警报：湿度节点" +  msgData.getMsgId() + "当前湿度为" + msgData.getHumidity() ;
                voice = "湿度警报请及时到后台查看并处理。";
            }
            
            if (!msg.equals("")) {
                DoGET.doPostGetMsg(url, msg, tel);
                DoGET.doPostGetVoice(urlVoice, voice, tel);
            }
            MsgDataDao.msgDataInsert(msgData.getMsgId(), msgData.getTemperature(),
                    msgData.getHumidity(), msgData.getInsertDateTime());
    }
}
