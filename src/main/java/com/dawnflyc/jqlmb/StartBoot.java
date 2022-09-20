package com.dawnflyc.jqlmb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 启动类
 */
@Configuration
@ComponentScan(basePackages = {"com.dawnflyc.jqlmb","com.dawnflyc.jql"})
@MapperScan(basePackages = {"com.dawnflyc.jqlmb"})
public class StartBoot {
}
