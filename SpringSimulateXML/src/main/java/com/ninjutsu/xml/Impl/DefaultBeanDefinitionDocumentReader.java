package com.ninjutsu.xml.Impl;


import com.ninjutsu.xml.Delegate.BeanDefinitionParserDelegate;
import com.ninjutsu.xml.Interface.BeanDefinitionDocumentReader;
import com.ninjutsu.xml.reader.XmlReaderContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DefaultBeanDefinitionDocumentReader implements BeanDefinitionDocumentReader {
    public static final String BEAN_ELEMENT = BeanDefinitionParserDelegate.BEAN_ELEMENT;

    public static final String NESTED_BEANS_ELEMENT = "beans";

    public static final String ALIAS_ELEMENT = "alias";

    public static final String NAME_ATTRIBUTE = "name";

    public static final String ALIAS_ATTRIBUTE = "alias";

    public static final String IMPORT_ELEMENT = "import";

    public static final String RESOURCE_ATTRIBUTE = "resource";

    public static final String PROFILE_ATTRIBUTE = "profile";

    public Logger logger = LoggerFactory.getLogger(DefaultDocumentLoader.class);

    private BeanDefinitionParserDelegate delegate = new BeanDefinitionParserDelegate();

    @Override
    public void registerBeanDefinitions(Document doc, XmlReaderContext readerContext) {
        doRegisterBeanDefinitions(doc.getDocumentElement());
    }

    protected void doRegisterBeanDefinitions(Element root){
        if (this.delegate.isDefaultNamespace(root)){
            String profileSpec = root.getAttribute(PROFILE_ATTRIBUTE);
            logger.info(profileSpec);
        }
        //啥也没干，你可以给XML树进行补充
        preProcessXml(root);
        //作为一个老猿，应该知道哪些女孩是一个男人该进的，继续
        parseBeanDefinitions(root, this.delegate);
        //啥也没干，我是不知道还能干嘛用....
        //从官方的意思是说解析dom树后，人家是自由身了，你可以修改他给后来者使用...
        postProcessXml(root);
    }

    private void parseDefaultElement(Element ele, BeanDefinitionParserDelegate delegate) {
        if (delegate.nodeNameEquals(ele, IMPORT_ELEMENT)) {
            importBeanDefinitionResource(ele);
        }
        else if (delegate.nodeNameEquals(ele, ALIAS_ELEMENT)) {
            processAliasRegistration(ele);
        }
        else if (delegate.nodeNameEquals(ele, BEAN_ELEMENT)) {
            //看看<bean>标签如何转换为Bean Definition对象
            processBeanDefinition(ele, delegate);
        }
        else if (delegate.nodeNameEquals(ele, NESTED_BEANS_ELEMENT)) {
            // recurse
            doRegisterBeanDefinitions(ele);
        }
    }

    private void importBeanDefinitionResource(Element ele) {
        String location = ele.getAttribute(RESOURCE_ATTRIBUTE);
        logger.info(location);
    }

    private void processAliasRegistration(Element ele) {
        String name = ele.getAttribute(NAME_ATTRIBUTE);
        String alias = ele.getAttribute(ALIAS_ATTRIBUTE);
        logger.info(name);
        logger.info(alias);
    }



    protected void processBeanDefinition(Element ele, BeanDefinitionParserDelegate delegate){
        delegate.parseBeanDefinitionElement(ele);
    }

    protected void preProcessXml(Element root) {
    }

    protected void parseBeanDefinitions(Element root, BeanDefinitionParserDelegate delegate){
        if (delegate.isDefaultNamespace(root)) {
            NodeList nl = root.getChildNodes();
            for (int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);
                if (node instanceof Element) {
                    Element ele = (Element) node;
                    if (delegate.isDefaultNamespace(ele)) {
                        /*default namespace 涉及到的就四个标签
                         * <import />、<alias />、<bean /> 和 <beans />
                         */
                        parseDefaultElement(ele, delegate);
                    }
                    else {
                        /*
                         * 其他的属于 custom（拓展）如我们经常会使用到的
                         * <mvc />、<task />、<context />、<aop />等
                         */
                        delegate.parseCustomElement(ele);
                    }
                }
            }
        }
        else {
            delegate.parseCustomElement(root);
        }
    }

    protected void postProcessXml(Element root) {
    }
}
