package xuanfeng.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanfeng.web.mapper.ChartsDataMapper;

/**
 * @author LiaoYangJun
 * @createTime 2018/3/25.
 */
@Repository
public class ChartsDataDao {

    @Autowired
    @SuppressWarnings("all")
    private ChartsDataMapper chartsDataMapper;

    public String queryChartTemperatureData(int msgId) {
        return chartsDataMapper.queryChartTemperatureData(msgId);
    }

    public String queryChartHumidityData(int msgId) {
        return chartsDataMapper.queryChartHumidityData(msgId);
    }
}
