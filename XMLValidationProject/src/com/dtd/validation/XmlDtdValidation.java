package com.dtd.validation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XmlDtdValidation {

	public static void main(String[] args) {
		String flag="true";
		try {
			validate("movies.xml");
		} catch (ParserConfigurationException e) {
			
			flag="false1";
		}
catch (FileNotFoundException e) {
			
			flag="false2";
		}
catch (SAXException e) {
			
			flag="falset";
		}
catch (IOException e) {
			
			flag="falsea";
		}
		System.out.println("xml file is valid: " +flag);	
	}
public static void validate(String xmlFile) throws ParserConfigurationException,FileNotFoundException,SAXException,IOException {
DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
documentBuilderFactory.setValidating(true);
DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
documentBuilder.setErrorHandler(new org.xml.sax.ErrorHandler() {
	public void error(SAXParseException exception) throws SAXException{
		throw exception;
	}
	public void fatalError(SAXParseException exception)throws SAXException{
		throw exception;
	}
	@Override
	public void warning(SAXParseException exception) throws SAXException {
		throw exception;
	}
	
});
documentBuilder.parse(new FileInputStream(xmlFile));
}
	
}
