package com.stronger.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  9:58 2018/7/16
 * @ModefiedBy:
 */
public class RequestUtil {
    public static Map<String, Object> getParamMap(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, String[]> paramMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue()[0];
            map.put(key, value);
        }
        return map;
    }
}
