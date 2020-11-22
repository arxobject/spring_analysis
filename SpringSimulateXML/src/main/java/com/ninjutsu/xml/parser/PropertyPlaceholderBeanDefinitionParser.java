package com.ninjutsu.xml.parser;

import com.ninjutsu.xml.Impl.AbstractSingleBeanDefinitionParser;
import com.ninjutsu.xml.Impl.DefaultDocumentLoader;
import com.ninjutsu.xml.context.ParserContext;
import com.ninjutsu.xml.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

public class PropertyPlaceholderBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    private static final String SYSTEM_PROPERTIES_MODE_ATTRIBUTE = "system-properties-mode";

    private static final String SYSTEM_PROPERTIES_MODE_DEFAULT = "ENVIRONMENT";

    public Logger logger = LoggerFactory.getLogger(PropertyPlaceholderBeanDefinitionParser.class);

    @Override
    public void parse(Element element, ParserContext parserContext) {
        super.doParse(element);

        if (element.hasAttribute("location")) {
            logger.info("location : "+element.getAttribute("location"));
        }

        if (element.hasAttribute("ignore-unresolvable")) {
            logger.info(element.getAttribute("ignore-unresolvable"));
        }

        if (element.hasAttribute(SYSTEM_PROPERTIES_MODE_ATTRIBUTE)) {
            logger.info(element.getAttribute(SYSTEM_PROPERTIES_MODE_ATTRIBUTE));
        }

        if (element.hasAttribute("value-separator")) {
            logger.info(element.getAttribute("value-separator"));
        }
        if (element.hasAttribute("trim-values")) {
            logger.info(element.getAttribute("trim-values"));
        }
        if (element.hasAttribute("null-value")) {
            logger.info(element.getAttribute("null-value"));
        }
    }
}
