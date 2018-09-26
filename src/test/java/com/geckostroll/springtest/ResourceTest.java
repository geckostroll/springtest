package com.geckostroll.springtest;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.InputStream;
import java.nio.charset.Charset;

/**
 *
 * @author yanhuai
 * @version $Id: ResourceTest.java, v 0.1 2018年09月25日 上午11:49 yanhuai Exp $
 */
public class ResourceTest {

    // 测试Resource接口的不同实现类
    @Test
    public void test1() {
        try {
            String filePath = "/Users/yanhuai/Documents/workspace/java_workspace/springtest/src/main/resources/test.txt";
            // 使用系统文件路径方式加载
            Resource resource1 = new FileSystemResource(filePath);
            // 使用类路径方式加载文件
            Resource resource2 = new ClassPathResource("test.txt");

            InputStream is1 = resource1.getInputStream();
            InputStream is2 = resource2.getInputStream();
            System.out.println(resource1.getFilename());
            String content1 = IOUtils.toString(is1, Charset.forName("utf-8"));
            System.out.println(content1);
            String content2 = IOUtils.toString(is2, Charset.forName("utf-8"));
            Assert.assertEquals(content1, content2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 测试ResourcePatternResolver
    @Test
    public void test2() throws Exception {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resources[] = resolver.getResources("classpath*:test*.txt");
        for (Resource res:resources) {
            System.out.println(res.getFilename());
        }
    }
}
