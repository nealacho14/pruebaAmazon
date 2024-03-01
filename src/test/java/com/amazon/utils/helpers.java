package com.amazon.utils;


import net.serenitybdd.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.slf4j.LoggerFactory.getLogger;

public class helpers extends PageObject {
    Logger logger = getLogger(getClass());

    public void esperaSelenium(int seconds){
        try{
            Thread.sleep(seconds*(long)1000);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
