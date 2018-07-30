package com.atguigu.springbootcrud.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
        /*取出MyExceptionHandler放进request域的ext，并放进errorAttributes中*/
        errorAttributes.put("ext",requestAttributes.getAttribute("ext",RequestAttributes.SCOPE_REQUEST));
        return errorAttributes;
    }
}
