package com.ninjutsu.xml.Interface;

import com.ninjutsu.xml.context.ParserContext;
import org.w3c.dom.Element;

public interface NamespaceHandler {
    void init();
    void parse(Element element, ParserContext parserContext);
}
