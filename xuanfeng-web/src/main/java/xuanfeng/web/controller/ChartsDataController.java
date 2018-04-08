package xuanfeng.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xuanfeng.web.dao.ChartsDataDao;
import xuanfeng.web.Server.ChartsDataServer;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author LiaoYangJun
 * @createTime 2018/3/25.
 */
@Controller
public class ChartsDataController {

    @Autowired
    private ChartsDataServer chartsDataServer;

    @Autowired
    private ChartsDataDao chartsDataDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private AtomicInteger atomicInteger = new AtomicInteger();;

    /**
     * 温湿度展示页面异步请求 当前温湿度
     * @param msgId (1 - 3 代表1 - 3节点温度; 4 - 6代表 4 - 6 节点湿度)
     * @return
     */
    @PostMapping("charts/data")
    @ResponseBody
    public String queryChartsData(@RequestParam("msgid")int msgId) {
        String msg = chartsDataServer.queryChartsData(msgId);
        System.out.println(msgId);
        System.out.println(chartsDataServer.queryChartsData(msgId));
        return chartsDataServer.queryChartsData(msgId);
    }

}
