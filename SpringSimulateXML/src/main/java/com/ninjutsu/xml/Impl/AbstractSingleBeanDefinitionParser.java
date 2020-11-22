package com.ninjutsu.xml.Impl;

import com.ninjutsu.xml.context.ParserContext;
import org.w3c.dom.Element;

public abstract class AbstractSingleBeanDefinitionParser extends AbstractBeanDefinitionParser {

    @Override
    protected void parseInternal(Element element, ParserContext parserContext) {

    }

    protected void doParse(Element element, ParserContext parserContext) {
        doParse(element);
    }

    protected void doParse(Element element) {

    }
}
