package xuanfeng.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author LiaoYangJun
 */
@SpringBootApplication
public class XuanfengWebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(XuanfengWebApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(XuanfengWebApplication.class);
	}
}
