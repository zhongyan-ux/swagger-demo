package com.example.swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;

@Configuration//将配置配置到springboot
@EnableSwagger2//开启swagger2
public class SwaggerConfig {
//   配置了Swagger的Docket的bean实例
    @Bean
    public Docket docket1(){
        return new Docket ( DocumentationType.SWAGGER_2 ).groupName ( "A" );

    }
    @Bean
    public Docket docket2(){
        return new Docket ( DocumentationType.SWAGGER_2 ).groupName ( "B" );

    }
    @Bean
    public Docket docket3(){
        return new Docket ( DocumentationType.SWAGGER_2 ).groupName ( "C" );

    }
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的swagger环境
        Profiles profiles= Profiles.of ("dev");
        //通过environment.acceptsProfiles 判断是否处在自己设定的环境中获取项目的环境
       boolean flag=environment.acceptsProfiles (  profiles);

        return new Docket ( DocumentationType.SWAGGER_2 )
                .apiInfo ( apiInfo () )
               //配置分组
                .groupName ( "zhongyan" )
                //enable是否启用swagger，if为false，则swagger不能在浏览器中访问
                .enable ( flag )
                .select ()
                //RequestHandlerSelectors,配置要扫描的接口的方式
                //basePackage：指定要扫描的包
                //any():扫描全部
                //none():不扫描
                //withClassAnnotation:扫描类上的注解
                //withMethodAnnotation:扫描方法上的注解
                //一般用的basePackage
                .apis ( RequestHandlerSelectors.basePackage ( "com.example.swaggerdemo.controller" ) )
                //过滤什么路径
               // .paths ( PathSelectors.ant (  "/swaggerdemo/**") )
                .build ();//
    }
    //配置swagger信息的apiInfo信息
    private ApiInfo apiInfo(){
        //作者信息
Contact contact=new Contact (  "应孑","https://blog.csdn.net/qq_44647596?spm=1001.2101.3001.5343","1324232975@qq.com");
        return new ApiInfo(
                "应孑的swaggerAPI文档", //文档标题
                "Api Documentation", //文档描述
                "1.0", //版本号
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList ());

    }
}
