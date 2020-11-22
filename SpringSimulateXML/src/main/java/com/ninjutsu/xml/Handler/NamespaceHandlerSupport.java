package com.ninjutsu.xml.Handler;

import com.ninjutsu.xml.Interface.BeanDefinitionParser;
import com.ninjutsu.xml.Interface.NamespaceHandler;
import com.ninjutsu.xml.context.ParserContext;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;

public class NamespaceHandlerSupport implements NamespaceHandler {

    private final Map<String, BeanDefinitionParser> parsers = new HashMap<>();

    @Override
    public void init() {

    }

    @Override
    public void parse(Element element, ParserContext parserContext) {
        BeanDefinitionParser parser = findParserForElement(element, parserContext);
        if(parser!=null){
            parser.parse(element, parserContext);
        }
    }

    private BeanDefinitionParser findParserForElement(Element element, ParserContext parserContext) {
        String localName = parserContext.getDelegate().getLocalName(element);
        BeanDefinitionParser parser = this.parsers.get(localName);
        if (parser == null) {

        }
        return parser;
    }

    protected final void registerBeanDefinitionParser(String elementName, BeanDefinitionParser parser) {
        this.parsers.put(elementName, parser);
    }
}
