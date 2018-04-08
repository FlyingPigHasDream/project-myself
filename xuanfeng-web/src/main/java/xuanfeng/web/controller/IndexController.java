package xuanfeng.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author LiaoYangJun
 * @createTime 2018/3/24.
 */
@Controller
public class IndexController {

    /**
     * 控制中心入口页面跳转
     * @param map 填充时间切割数据
     * @return
     */
    @GetMapping("/index")
    public String indexPage (Map<String, Object> map) {
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String[] timeArray = StringUtils.split(df.format(day).toString(), "-");
        map.put("y", timeArray[0]);
        map.put("M", timeArray[1]);
        map.put("d", timeArray[2]);
        map.put("time", timeArray[3]);
        return "index";
    }

    /**
     * 跳入控制中心登陆界面
     * @return
     */
    @GetMapping("/index/login")
    public String indexLoginPage() {
        return "login";
    }

    /**
     * 跳转到门户主页
     * @return
     */
    @GetMapping("/indexs")
    public String indexsPage() {
        return "indexs";
    }


    /**
     * 动态图表网页
     * @return
     */
    @GetMapping("/main")
    public  String mainPage() {
        return "charts";
    }


    /**
     * 后台监测系统登陆账号校验
     * @param u
     * @param p
     * @return
     */
    @PostMapping("/indexLoginCheck")
    public String indexLoginCheck(@RequestParam("u")String u, @RequestParam("p")String p ) {

        //写死 p ： xuanfeng
        //     u : 123
        if ( !p.equals("123") || !u.equals("xuanfeng")) {
            return "login";
        }
        return "index";
    }

}
