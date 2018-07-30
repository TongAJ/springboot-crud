package com.atguigu.springbootcrud.config;

import com.atguigu.springbootcrud.filter.MyFilter;
import com.atguigu.springbootcrud.listener.MyListener;
import com.atguigu.springbootcrud.servlet.MyServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {

    /*
    * 修改内置Servlet服务器的port
    * public class ServerProperties implements EmbeddedServletContainerCustomizer
    * 同application.properties中配置server.port=8081
    * */
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new EmbeddedServletContainerCustomizer(){
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                /*
                * 修改tomcat的port属性
                * */
                container.setPort(8081);
            }
        };
    }

    @Bean
    public ServletRegistrationBean myServlet(){
        /*
        * public ServletRegistrationBean(Servlet servlet, String... urlMappings)
        * 所有映射的请求都由MyServlet执行
        * */
        ServletRegistrationBean registrationBean =
                new ServletRegistrationBean(new MyServlet(),"/","/hello");
        return registrationBean;
    }

    /*
    * public FilterRegistrationBean
    *   (Filter filter, ServletRegistrationBean... servletRegistrationBeans)
    *
    * */
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        /* setFilter */
        registrationBean.setFilter(new MyFilter());
        /* setUrlPatterns */
        registrationBean.setUrlPatterns(Arrays.asList("/","/hello"));
        return registrationBean;
    }

    /*
    * public ServletListenerRegistrationBean(T listener)
    * */
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean =
                new ServletListenerRegistrationBean(new MyListener());
        return registrationBean;
    }
}
