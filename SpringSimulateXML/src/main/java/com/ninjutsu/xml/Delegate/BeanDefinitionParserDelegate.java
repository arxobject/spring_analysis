package com.ninjutsu.xml.Delegate;

import com.ninjutsu.xml.Handler.ContextNamespaceHandler;
import com.ninjutsu.xml.Impl.DefaultDocumentLoader;
import com.ninjutsu.xml.Interface.NamespaceHandler;
import com.ninjutsu.xml.context.ParserContext;
import com.ninjutsu.xml.util.StringUtils;
import com.sun.istack.internal.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class BeanDefinitionParserDelegate {
    public static final String BEANS_NAMESPACE_URI = "http://www.springframework.org/schema/beans";
    public static final String BEAN_ELEMENT = "bean";

    public static final String ID_ATTRIBUTE = "id";
    public static final String NAME_ATTRIBUTE = "name";

    public Logger logger = LoggerFactory.getLogger(DefaultDocumentLoader.class);

    @Nullable
    public String getNamespaceURI(Node node) {
        String url = node.getNamespaceURI();
        return url;
    }

    public boolean isDefaultNamespace(@Nullable String namespaceUri) {

        return (!StringUtils.hasLength(namespaceUri) || BEANS_NAMESPACE_URI.equals(namespaceUri));
    }

    public boolean nodeNameEquals(Node node, String desiredName) {
        return desiredName.equals(node.getNodeName()) || desiredName.equals(getLocalName(node));
    }

    public String getLocalName(Node node) {
        return node.getLocalName();
    }

    public boolean isDefaultNamespace(Node node) {
        return isDefaultNamespace(getNamespaceURI(node));
    }

    public void parseCustomElement(Element ele) {
        //xml解析的第二路，需要引入命名空间的解析（命名空间）
        String namespaceUri = getNamespaceURI(ele);
        if (namespaceUri == null) {
            return ;
        }
        //NamespaceHandler 策略模式 NamespaceHandler接口多态实现策略
        //比如我想分析 <context:component-scan base-package="****"/> 的实现原理，
        // 就应该到 ContextNamespaceHandler 中找答案
        NamespaceHandler handler = new ContextNamespaceHandler();
        if (handler == null) {
            logger.error("Unable to locate Spring NamespaceHandler for XML schema namespace [" + namespaceUri + "]   "+ele);
            return ;
        }
        handler.init();
        handler.parse(ele, new ParserContext(this));
    }

    public void parseBeanDefinitionElement(Element ele){
        String id = ele.getAttribute(ID_ATTRIBUTE);
        String nameAttr = ele.getAttribute(NAME_ATTRIBUTE);
        logger.info("id : "+id);
        logger.info("name : "+nameAttr);
    }
}
