/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilityFunctions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author nickpredey
 */
public class UtilFunctions {

    public static ApplicationContext getApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/app-context.xml");
    }
}
