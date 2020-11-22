package com.ninjutsu.xml.parser;

import com.ninjutsu.xml.Impl.AbstractSingleBeanDefinitionParser;
import com.ninjutsu.xml.context.ParserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

public class SpringConfiguredBeanDefinitionParser extends AbstractPropertyLoadingBeanDefinitionParser {

    public Logger logger = LoggerFactory.getLogger(PropertyPlaceholderBeanDefinitionParser.class);

    @Override
    public void parse(Element element, ParserContext parserContext) {
        super.doParse(element);
        logger.info("SpringConfiguredBeanDefinitionParser");
    }
}
