package com.survey.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
@Configuration
public class FileConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
                /*可以让前端访问到这个文件路径，也可以兼容其他系统*/
                //朋友圈图片地址
                registry.addResourceHandler("/img/circlePic/**")
                        .addResourceLocations("file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
                                + System.getProperty("file.separator") + "circlePic" + System.getProperty("file.separator")
                        );
        }
}
