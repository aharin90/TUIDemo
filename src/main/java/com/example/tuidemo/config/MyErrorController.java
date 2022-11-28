//package com.example.tuidemo.config;
//
//import org.springframework.boot.autoconfigure.web.ErrorProperties;
//import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
//import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
//import org.springframework.boot.web.servlet.error.ErrorAttributes;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import springfox.documentation.annotations.ApiIgnore;
//
//import java.util.List;
//
//@Component
//@RequestMapping("my-error-controller")
//@ApiIgnore
//public abstract class MyErrorController extends BasicErrorController{
//
//    public MyErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
//        super(errorAttributes, errorProperties);
//    }
//
//    public MyErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
//        super(errorAttributes, errorProperties, errorViewResolvers);
//    }
//}
