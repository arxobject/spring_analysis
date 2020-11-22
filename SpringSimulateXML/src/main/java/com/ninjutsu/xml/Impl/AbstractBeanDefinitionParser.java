package com.ninjutsu.xml.Impl;

import com.ninjutsu.xml.Interface.BeanDefinitionParser;
import com.ninjutsu.xml.context.ParserContext;
import org.w3c.dom.Element;

public abstract class AbstractBeanDefinitionParser implements BeanDefinitionParser {
    @Override
    public void parse(Element element, ParserContext parserContext) {

    }

    protected abstract void parseInternal(Element element, ParserContext parserContext);
}
