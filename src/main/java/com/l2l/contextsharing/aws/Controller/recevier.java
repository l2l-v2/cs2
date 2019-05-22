package com.l2l.contextsharing.aws.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.l2l.contextsharing.aws.bean.*;

import java.io.IOException;

@RestController//处理http请求，返回json格式
@RequestMapping//配置url，让该类下的所有接口url都映射在/users下
public class recevier {
    receiver re = new receiver();

    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    @ResponseBody
    public void receive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        re.doPost(request,response);
    }

}
