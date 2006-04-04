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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.felix.bundlerepository.metadataparser.kxmlsax.KXml2SAXParser;

/**
 * handles the metadata in XML format
 * (use kXML (http://kxml.enhydra.org/) a open-source very light weight XML parser
 * @version 	1.00 11 Nov 2003
 * @author 	Didier Donsez
 */
public class KXml2MetadataHandler extends MetadataHandler {

	public KXml2MetadataHandler() {}

	/**
	* Called to parse the InputStream and set bundle list and package hash map
	*/
	public void parse(InputStream is) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		KXml2SAXParser parser;
		parser = new KXml2SAXParser(br);
		parser.parseXML(handler);
	}
}
