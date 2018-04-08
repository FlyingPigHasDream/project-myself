package xuanfeng.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import xuanfeng.web.Server.MsgDataServer;
import xuanfeng.web.pojo.MsgData;

import java.util.Random;

/**
 * @author LiaoYangJun
 * @createTime 2018/3/24.
 */
@Controller
public class MsgDataController {

    @Autowired
    @SuppressWarnings("all")
    private MsgDataServer dataServer;

    /**
     * 硬件端发过来的数据
     * @param msgId 数据id
     * @param temperature 温度
     * @param humidity 湿度
     *      http://120.79.221.135:8081/xuanfeng-web/msgInsert/{msgId}/{temperature}/{humidity}/{insertDateTime}
     */
    @GetMapping("/msgInsert/{msgId}/{temperature}/{humidity}/{insertDateTime}")
    @ResponseBody
    public String insertMsg(@PathVariable("msgId")String msgId, @PathVariable("temperature")String temperature,
                          @PathVariable("humidity")String humidity, @PathVariable("insertDateTime")String insertDteTime) throws Exception {
        MsgData msgData = new MsgData();
        msgData.setMsgId(msgId);
        msgData.setTemperature(temperature);
        msgData.setHumidity(humidity);
        msgData.setInsertDateTime(insertDteTime);

        dataServer.msgDataInsert(msgData,17689600017L);
        return msgData.toString();
    }

    @GetMapping("/insert")
    @ResponseBody
    public String testGet() {
        System.out.println("inner testGet Method");
        return "inner testGet Method Success!";
    }

    /**
     * 数据跳动
     * @param count
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/insert/{count}")
    @ResponseBody
    public String testManyGet(@PathVariable("count")int count) throws Exception {
        MsgData msgData = new MsgData();
        /*for (int i = 1; i <= count; i++) {
            msgData.setTemperature(String.valueOf(new Random().nextInt(40)));
            msgData.setHumidity(String.valueOf(new Random().nextInt(40)));
            msgData.setMsgId(String.valueOf(i/3));
            msgData.setInsertDateTime(String.valueOf(System.currentTimeMillis()));
           dataServer.msgDataInsert(msgData);
        }*/
        //int i = 0;
        while (true) {
          //  i++;
            for (int i = 1; i <= 3; i++) {
            msgData.setTemperature(String.valueOf(23 + new Random().nextInt(2)));
            msgData.setHumidity(String.valueOf(70 + new Random().nextInt(5)));
            msgData.setMsgId(String.valueOf(i));
            msgData.setInsertDateTime(String.valueOf(System.currentTimeMillis()));
           dataServer.msgDataInsert(msgData, 17689600017L);
            }
            Thread.sleep(3000);
        }
        /*return "inner testGet Method Success!";*/
    }

    @GetMapping("/insert/{point}/{temperaturemax}/{humiditymax}/{tel}")
    @ResponseBody
    public String testWarnGet(@PathVariable("point")int point, @PathVariable("temperaturemax")int temperaturemax,
                              @PathVariable("humiditymax")int humiditymax, @PathVariable("tel")Long tel) throws Exception {
        MsgData msgData = new MsgData();
            msgData.setTemperature(String.valueOf(temperaturemax));
            msgData.setHumidity(String.valueOf(humiditymax));
            msgData.setMsgId(String.valueOf(point));
            msgData.setInsertDateTime(String.valueOf(System.currentTimeMillis()));
           dataServer.msgDataInsert(msgData, tel);

        return "inner testGet Method Success!";
    }



}
