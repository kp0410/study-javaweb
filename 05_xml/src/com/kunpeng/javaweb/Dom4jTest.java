package com.kunpeng.javaweb;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class Dom4jTest {

    /**
     * 读取books.xml文件
     *
     * @throws DocumentException
     */
    @Test
    public void test1() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/books.xml");
        System.out.println(document);
    }

    @Test
    public void test2() throws DocumentException {
        //1.读取books.xml文件
        SAXReader reader = new SAXReader();
        //2.通过Document对象获取元素
        Document document = reader.read("src/books.xml");
        Element element = document.getRootElement();
//        System.out.println(element);
        //3.通过根元素获取book标签对象
        List<Element> books = element.elements("book");
        //4.遍历，处理每个book标签转换为Book类
        for (Element book : books) {
//            Element name = book.element("name");
            String name = book.elementText("name");
            String price = book.elementText("price");
            String author = book.elementText("author");
            String sn = book.attributeValue("sn");
            Book book1 = new Book(sn, name, new BigDecimal(price), author);
            System.out.println(book1);
        }

    }
}
