package com.summersky.mybatispluspage.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Authur:zengfanbin
 * @Date:2019-9-10
 * @Time:12:50
 * @Description:
 */
@Configuration
@MapperScan("com.summersky.mybatispluspage.page.mapper")
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
    /**
     * 打印SQL
     */

    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor interceptor=new PerformanceInterceptor();
        //格式化SQL
        Properties properties =new Properties();

        properties.setProperty("format", "faalse");

        interceptor.setProperties(properties);

        return interceptor;
    }
}
