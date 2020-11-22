package com.ninjutsu.xml.Impl;

import com.ninjutsu.xml.Interface.DocumentLoader;
import com.ninjutsu.xml.Interface.Resource;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    private DocumentLoader documentLoader = new DefaultDocumentLoader();

    @Override
    public int loadBeanDefinitions(String location) {
        return super.loadBeanDefinitions(location);
    }

    @Override
    public int loadBeanDefinitions(String... locations) {
        return super.loadBeanDefinitions(locations);
    }

    public int loadBeanDefinitions(InputSource inputSource){

        return 0;
    }

    protected int doLoadBeanDefinitions(InputSource inputSource, Resource resource){
        //得到文档对象DOM树
        Document doc = doLoadDocument(inputSource, resource);
        //count为当前配置文件加载了多少数量的Bean（BeanDefinition）继续跟进
        int count = registerBeanDefinitions(doc, resource);
        return count;
    }

    protected Document doLoadDocument(InputSource inputSource, Resource resource){
       /* return this.documentLoader.loadDocument(inputSource, getEntityResolver(), this.errorHandler,
                getValidationModeForResource(resource), isNamespaceAware());*/
       return null;
    }

    public int registerBeanDefinitions(Document doc, Resource resource){
        return 0;
    }
}
