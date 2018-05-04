package com.lbx.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

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
            if("servlet".equals(element.getName())){
                Element servletName = element.element("servlet-name");
                Element servletClass = element.element("servlet-class");
                System.out.println(servletName.getText());
                System.out.println(servletClass.getText());
            }

            if("servlet-mapping".equals(element.getName())){
                Element servletName = element.element("servlet-name");
                Element servletClass = element.element("url-pattern");
                System.out.println(servletName.getText());
                System.out.println(servletClass.getText());
            }
        }
    }

    @Test
    public void showURL() {
        File file = new File(this.getClass().getResource("/").getPath());
        System.out.println(file);
    }

}
