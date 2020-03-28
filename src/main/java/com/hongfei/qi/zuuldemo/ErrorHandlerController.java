package com.hongfei.qi.zuuldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ErrorHandlerController implements ErrorController {
    @Autowired
    private ErrorAttributes errorAttributes;
    @Override
    public String getErrorPath() {
        System.out.println("enter error path");
        return "/error";
    }

    @RequestMapping("/error")
    @ResponseBody
    public Object error(HttpServletRequest request){
        return "500";
    }
}
