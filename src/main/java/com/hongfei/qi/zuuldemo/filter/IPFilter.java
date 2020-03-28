package com.hongfei.qi.zuuldemo.filter;

import com.google.common.collect.Lists;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.tomcat.util.net.IPv6Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class IPFilter extends ZuulFilter {
    List<String> blackList = Lists.newArrayList( "0:0:0:0:0:0:0:1");
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String localAddr = request.getLocalAddr();
        int i= 1/0;
        currentContext.set("msg","ip6");
        if(localAddr != null && blackList.contains(localAddr)){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("black ip list");
            return null;
        }



        return null;
    }


}
