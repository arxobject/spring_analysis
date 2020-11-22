package com.ninjutsu.xml.Interface;

import com.ninjutsu.xml.reader.XmlReaderContext;
import org.w3c.dom.Document;

public interface BeanDefinitionDocumentReader {
    void registerBeanDefinitions(Document doc, XmlReaderContext readerContext);
}
