package com.github.binarywang.demo.wx.cp;

import com.mhc.framework.support.session.base.GwAppAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@ComponentScan(basePackages = {"com.github.binarywang.demo.wx.cp", "com.mhc.framework.support"}, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
    GwAppAutoConfiguration.class}))
@SpringBootApplication
public class WxCpDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(WxCpDemoApplication.class, args);
  }
}
