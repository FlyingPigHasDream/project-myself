package xuanfeng.web.Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanfeng.web.dao.ChartsDataDao;

/**
 * @author LiaoYangJun
 * @createTime 2018/3/25.
 */
@Service
public class ChartsDataServer {

    @Autowired
    private ChartsDataDao chartsDataDao;

    public String queryChartsData(int msgId) {
        if ( msgId > 0 && msgId < 4) {
            return chartsDataDao.queryChartTemperatureData(msgId);
        }else if (msgId > 3 && msgId < 7){
            return chartsDataDao.queryChartHumidityData(msgId -3);
        }
        return String.valueOf(0);
    }
}
