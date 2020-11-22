package com.ninjutsu.xml.parser;

import com.ninjutsu.xml.context.ParserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

public class PropertyOverrideBeanDefinitionParser extends AbstractPropertyLoadingBeanDefinitionParser {

    public Logger logger = LoggerFactory.getLogger(PropertyOverrideBeanDefinitionParser.class);
    @Override
    public void parse(Element element, ParserContext parserContext) {
        super.doParse(element);

        if (element.hasAttribute("location")) {
            logger.info("location : "+element.getAttribute("location"));
        }

        if (element.hasAttribute("ignore-unresolvable")) {
            logger.info(element.getAttribute("ignore-unresolvable"));
        }
    }
}
