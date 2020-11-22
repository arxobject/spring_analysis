package com.ninjutsu.xml.Interface;

import com.ninjutsu.xml.context.ParserContext;
import org.w3c.dom.Element;

public interface BeanDefinitionParser {

    void parse(Element element, ParserContext parserContext);
}
