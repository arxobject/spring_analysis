package com.ninjutsu.xml.parser;

import com.ninjutsu.xml.context.ParserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

public class MBeanExportBeanDefinitionParser extends AbstractPropertyLoadingBeanDefinitionParser {

    private static final String MBEAN_EXPORTER_BEAN_NAME = "mbeanExporter";

    private static final String DEFAULT_DOMAIN_ATTRIBUTE = "default-domain";

    private static final String SERVER_ATTRIBUTE = "server";

    private static final String REGISTRATION_ATTRIBUTE = "registration";

    private static final String REGISTRATION_IGNORE_EXISTING = "ignoreExisting";

    private static final String REGISTRATION_REPLACE_EXISTING = "replaceExisting";

    public Logger logger = LoggerFactory.getLogger(MBeanExportBeanDefinitionParser.class);

    @Override
    public void parse(Element element, ParserContext parserContext) {
        super.doParse(element);

        if (element.hasAttribute(MBEAN_EXPORTER_BEAN_NAME)) {
            logger.info(MBEAN_EXPORTER_BEAN_NAME+" : "+element.getAttribute(MBEAN_EXPORTER_BEAN_NAME));
        }

        if (element.hasAttribute(DEFAULT_DOMAIN_ATTRIBUTE)) {
            logger.info(DEFAULT_DOMAIN_ATTRIBUTE+" : "+element.getAttribute(DEFAULT_DOMAIN_ATTRIBUTE));
        }

        if (element.hasAttribute(SERVER_ATTRIBUTE)) {
            logger.info(SERVER_ATTRIBUTE+" : "+element.getAttribute(SERVER_ATTRIBUTE));
        }
        if (element.hasAttribute(REGISTRATION_ATTRIBUTE)) {
            logger.info(REGISTRATION_ATTRIBUTE+" : "+element.getAttribute(REGISTRATION_ATTRIBUTE));
        }
        if (element.hasAttribute(REGISTRATION_IGNORE_EXISTING)) {
            logger.info(REGISTRATION_IGNORE_EXISTING+" : "+element.getAttribute(REGISTRATION_IGNORE_EXISTING));
        }
        if (element.hasAttribute(REGISTRATION_REPLACE_EXISTING)) {
            logger.info(REGISTRATION_REPLACE_EXISTING+" : "+element.getAttribute(REGISTRATION_REPLACE_EXISTING));
        }
    }
}
