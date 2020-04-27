package com.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by acer i5 on 08.04.2020.
 */
public class TestUtil {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "Product%7Bid=1,%20name='PRODUCT_NAME_001',%20brand='PRODUCT_BRAND_002',%20madeIn='PRODUCT_MADE_003',%20price=100.0%7D";
        System.out.println(paramJson(str));
        String jsonString = "{\"aNumber\":2}";
        String url = "editTest.jsp?details=" + URLEncoder.encode(str + jsonString, "UTF-8");
        System.out.println("url " + url);
    }

        public static  byte[] convertObjectToJsonByte(Object object) throws IOException{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return objectMapper.writeValueAsBytes(object);
        }

    public static String paramJson(String paramIn) {
        paramIn = paramIn.replaceAll("=", "\":\"");
        paramIn = paramIn.replaceAll("&", "\",\"");
        return "{\"" + paramIn + "\"}";
    }

}
