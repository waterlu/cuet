package cn.lu.cuet.data.loader.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lu on 16-10-8.
 */
@Configuration
@AutoConfigureAfter(MybatisConfiguration.class)
public class MybatisMapperScannerConfiguration {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("cn.lu.cuet.data.loader.mapper");
        return mapperScannerConfigurer;
    }
}
