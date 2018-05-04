package com.lbx.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2018/5/4 8:28
 */
public class Dom4jTest {
    @Test
    public void testReadWebXML() throws DocumentException {
        //创建一个解析器
        SAXReader reader = new SAXReader();
        //获取document文档对象
        Document doc = reader.read(this.getClass().getResource("/").getPath() + "com/lbx/dom4j/web.xml");
        //获取根元素
        Element rootElement = doc.getRootElement();
//        获取根元素标签
//        String name = rootElement.getName();
//        获取根元素的属性值
//        Attribute version = rootElement.attribute("version");
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            if ("servlet".equals(element.getName())) {
                Element servletName = element.element("servlet-name");
                Element servletClass = element.element("servlet-class");
                System.out.println(servletName.getText());
                System.out.println(servletClass.getText());
            }

            if ("servlet-mapping".equals(element.getName())) {
                Element servletName = element.element("servlet-name");
                Element servletClass = element.element("url-pattern");
                System.out.println(servletName.getText());
                System.out.println(servletClass.getText());
            }
        }
    }

    @Test
    public void getWEBMap() throws Exception {
        //以map数据格式存储web.xml，key是url,values是servlet-class
        Map<String, String> webMap = new HashMap<>();
        SAXReader reader = new SAXReader();
        Document doc = reader.read("src/com/lbx/dom4j/web.xml");
        Element rootElement = doc.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            if ("servlet".equals(element.getName())) {
                String servletName = element.elementText("servlet-name");
                String servletClass = element.elementText("servlet-class");
                webMap.put(servletName, servletClass);
            }
            if ("servlet-mapping".equals(element.getName())) {
                String servletName = element.elementText("servlet-name");
                String urlPattern = element.elementText("url-pattern");
                String servletClass = webMap.get(servletName);
                webMap.put(urlPattern,servletClass);
            }
        }
        System.out.println(webMap);
    }


}
