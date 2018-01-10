package com.cuisongliu.beetl.autoconfigure;
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 cuisongliu@qq.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import com.cuisongliu.beetl.autoconfigure.properties.BeetlProperties;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

/**
 * beetl配置(如果需要配置别的配置可参照这个形式自己添加)
 *
 * @author cuijinrui
 */
@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
@EnableConfigurationProperties(BeetlProperties.class)
public class BeetlAutoConfig {

    @Autowired
    private BeetlProperties beetlProperties;

    @Bean(name = "beetlConfig",initMethod = "init")
    @ConditionalOnMissingBean(name="beetlConfig")
    public BeetlGroupUtilConfiguration beetlConfig() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        ResourcePatternResolver patternResolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
        try {
            ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader(beetlProperties.getRoot());
            beetlGroupUtilConfiguration.setResourceLoader(resourceLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        beetlGroupUtilConfiguration.setConfigProperties(beetlProperties.getProperties());
        //读取配置文件信息
        return beetlGroupUtilConfiguration;
    }

    @Bean(name = "beetlViewResolver")
    @ConditionalOnMissingBean(name="beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(BeetlGroupUtilConfiguration beetlConfig) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setSuffix(beetlProperties.getSuffix());
        beetlSpringViewResolver.setContentType(beetlProperties.getContentType());
        beetlSpringViewResolver.setOrder(beetlProperties.getOrder());
        beetlSpringViewResolver.setConfig(beetlConfig);
        return beetlSpringViewResolver;
    }

    @Bean
    @ConditionalOnMissingBean(name="groupTemplate")
    public GroupTemplate groupTemplate(BeetlGroupUtilConfiguration beetlGroupUtilConfiguration){
        return beetlGroupUtilConfiguration.getGroupTemplate();
    }
}
