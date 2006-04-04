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


/**
 * this class adds type of elements to the parser
 *
 * @author Didier Donsez (didier.donsez@imag.fr)
 */
public class MappingProcessingInstructionHandler {

	private XmlCommonHandler handler;
	private String name;
	private String classname;

	public MappingProcessingInstructionHandler(XmlCommonHandler handler) {
		this.handler = handler;
	}

	public void process() throws Exception {
		if(name==null) {
			throw new Exception("element is missing");
		}
		if(classname==null) {
			throw new Exception("class is missing");
		}
		handler.addType(name,this.getClass().getClassLoader().loadClass(classname),null);
	}

	public void setElement(String element) {
		this.name=element;
	}

	public void setClass(String classname) {
		this.classname=classname;
	}
}