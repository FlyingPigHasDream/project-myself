package xuanfeng.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author LiaoYangJun
 * @createTime 2018/3/24.
 */
@Repository
public class MsgDataDao {

    @Autowired
    @SuppressWarnings("all")
    private JdbcTemplate JdbcTemplate;

    public void msgDataInsert(String msgId, String temperature, String humidity, String insertDateTime) {
        String sql = "INSERT INTO msg_data (msgId, temperature, humidity, insertDateTime) VALUES " +
                "(" + msgId + "," + temperature + "," + humidity + "," + insertDateTime  + ")";
        JdbcTemplate.execute(sql);
    }

}
