package xuanfeng.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author LiaoYangJun
 * @createTime 2018/3/25.
 */
@Mapper
public interface ChartsDataMapper {

    /**
     * 查找最新的温度
     * @param msgId
     * @return
     */
    @Select("select temperature from msg_data where msgId = #{0} order by insertDateTime  desc limit 1")
    String queryChartTemperatureData(int msgId);

    /**
     * 查找最新的湿度
     * @param msgId
     * @return
     */
    @Select("select humidity from msg_data where msgId = #{0} order by insertDateTime  desc limit 1")
    String queryChartHumidityData(int msgId);
}
