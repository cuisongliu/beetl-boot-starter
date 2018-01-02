package com.cuisongliu.beetl.autoconfigure.properties;
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

import org.beetl.core.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * @author cuisongliu [cuisongliu@qq.com]
 * @since 2017-12-05 20:14
 */
@ConfigurationProperties(prefix = BeetlProperties.BEETL_PREFIX)
public class BeetlProperties {

    public static final String BEETL_PREFIX = "spring.beetl";

    /**
     * Set the suffix that gets appended to view names when building a URL.
     */
    private String suffix = ".btl";

    /**
     * Set the content type for all views.
     * <p>May be ignored by view classes if the view itself is assumed
     * to set the content type, e.g. in case of JSPs.
     */
    private String contentType = "text/html;charset=UTF-8";

    /**
     * classpath 根路径
     */
    private String root = "classpath:/templates";

    /**
     * Set the order in which this {@link org.springframework.web.servlet.ViewResolver}
     * is evaluated.
     */
    private int order = 0;

    /**
     * 自定义脚本方法文件的Root目录, 针对root根目录的相对路径
     */
    private String functionRoot = "/functions";
    /**
     * 自定义脚本方法文件的Root后缀, 针对root根目录的相对路径
     */
    private String functionSuffix = "fn";
    /**
     * 自定义标签文件Root目录
     */
    private String tagRoot = "/tags";
    /**
     * 自定义标签文件Root后缀
     */
    private String tagSuffix = "tag";

    /**
     * 模板占位起始符号
     */
    private String placeholderStart = "${";
    /**
     * 模板占位结束符号
     */
    private String placeholderEnd = "}";

    /**
     * 控制语句起始符号
     */
    private String statementStart = "<%";
    /**
     * 控制语句结束符号
     */
    private String statementEnd = "%>";

    /**
     * 是否检测文件变化,开发用true合适，但线上要改为false
     */
    private Boolean autoCheck = false;


    private Properties properties= new Properties();


    public Properties getProperties() {
        if (statementStart.startsWith("\\")) {
            statementStart = statementStart.substring(1);
        }
        properties.setProperty(Configuration.DELIMITER_PLACEHOLDER_START, placeholderStart);
        properties.setProperty(Configuration.DELIMITER_PLACEHOLDER_END, placeholderEnd);
        properties.setProperty(Configuration.DELIMITER_STATEMENT_START, statementStart);
        properties.setProperty(Configuration.DELIMITER_STATEMENT_END, statementEnd);
        properties.setProperty("RESOURCE.functionRoot", functionRoot);
        properties.setProperty("RESOURCE.functionSuffix", functionSuffix);
        properties.setProperty("RESOURCE.tagRoot", tagRoot);
        properties.setProperty("RESOURCE.tagSuffix", tagSuffix);
        properties.setProperty("RESOURCE.autoCheck", autoCheck.toString());

        return properties;
    }

    public void setProperties(Properties properties){
        this.properties=properties;
    }


    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getFunctionRoot() {
        return functionRoot;
    }

    public void setFunctionRoot(String functionRoot) {
        this.functionRoot = functionRoot;
    }

    public String getFunctionSuffix() {
        return functionSuffix;
    }

    public void setFunctionSuffix(String functionSuffix) {
        this.functionSuffix = functionSuffix;
    }

    public String getTagRoot() {
        return tagRoot;
    }

    public void setTagRoot(String tagRoot) {
        this.tagRoot = tagRoot;
    }

    public String getTagSuffix() {
        return tagSuffix;
    }

    public void setTagSuffix(String tagSuffix) {
        this.tagSuffix = tagSuffix;
    }

    public String getPlaceholderStart() {
        return placeholderStart;
    }

    public void setPlaceholderStart(String placeholderStart) {
        this.placeholderStart = placeholderStart;
    }

    public String getPlaceholderEnd() {
        return placeholderEnd;
    }

    public void setPlaceholderEnd(String placeholderEnd) {
        this.placeholderEnd = placeholderEnd;
    }

    public String getStatementStart() {
        return statementStart;
    }

    public void setStatementStart(String statementStart) {
        this.statementStart = statementStart;
    }

    public String getStatementEnd() {
        return statementEnd;
    }

    public void setStatementEnd(String statementEnd) {
        this.statementEnd = statementEnd;
    }

    public Boolean getAutoCheck() {
        return autoCheck;
    }

    public void setAutoCheck(Boolean autoCheck) {
        this.autoCheck = autoCheck;
    }
}
