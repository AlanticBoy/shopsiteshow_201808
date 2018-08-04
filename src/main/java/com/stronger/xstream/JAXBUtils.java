package com.stronger.xstream;

import javax.xml.bind.JAXB;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  13:58 2018/6/29
 * @ModefiedBy:
 */
public class JAXBUtils {

    public static String object2Xml(Object obj) {
        StringWriter sw = new StringWriter();
        JAXB.marshal(obj, sw);
        return sw.toString();
    }

    public static <T> T xml2Object(String xml, Class<T> clazz) {
        return JAXB.unmarshal(new StringReader(xml),clazz);
    }


}
