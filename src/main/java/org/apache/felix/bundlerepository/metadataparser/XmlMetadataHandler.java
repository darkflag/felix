/*
 *   Copyright 2006 The Apache Software Foundation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package org.apache.felix.bundlerepository.metadataparser;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * handles the metadata in XML format
 *
 * @version 1.00 18 May 2003
 * @author 	Didier Donsez
 */
public class XmlMetadataHandler extends MetadataHandler {

	public XmlMetadataHandler() {
	}
	
	/**
	* Called to parse the InputStream and set bundle list and package hash map
	*/
	public void parse(InputStream istream) throws ParserConfigurationException, IOException, SAXException {
     // Parse the Meta-Data

	 	ContentHandler contenthandler = (ContentHandler) handler;

		InputSource is = new InputSource(istream);

        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setValidating(false);

        SAXParser saxParser = spf.newSAXParser();
		
        XMLReader xmlReader = null;
        xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(contenthandler);
        xmlReader.parse(is);
    }
}
