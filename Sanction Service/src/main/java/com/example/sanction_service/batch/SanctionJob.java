package com.example.sanction_service.batch;

import com.example.sanction_service.model.SanctionEntity;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class SanctionJob {
    private List<SanctionEntity> items = new ArrayList<>();
    public void saxmethod(){
        try
        {
            SAXParserFactory fact = SAXParserFactory.newInstance();
            SAXParser saxParser = fact.newSAXParser();

            DefaultHandler handle =  new DefaultHandler(){
                boolean bname = false, boolean bsurname = false;
                public void startElement(String uri, String localName, String qName,
                                         Attributes attributes) throws SAXException{
                    if(qName.equals("FIRST_NAME")) bname = true;
                    if(qName.equals("SECOND_NAME")) bsurname = true;
                }
                public void endElement(String uri, String localName, String qName){

                }
                public void characters(char[] ch, int start, int length) throws SAXException{
                    SanctionEntity sanctionEntity = new SanctionEntity();
                    int i = 0;
                    if(bname){
                        sanctionEntity.setName(new String(ch, start, length));
                        bname = false;
                    }
                    if(bsurname) {
                        sanctionEntity.setSurname(new String(ch, start, length));
                        bsurname = false;
                    }
                    items.add(sanctionEntity);
                    i++;
                    System.out.println(items.toString());
                }
            };
            saxParser.parse("xml/oqjp6en-dprk.xml", handle);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}