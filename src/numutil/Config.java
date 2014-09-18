/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numutil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author wwt
 */
public class Config {
    private Properties prop;
    
    private Config(Properties prop){
        this.prop = prop;
    }
    
    public static Config loadConfig(String file){
        Properties pro = new Properties();
        try{
            pro.load(new BufferedInputStream(new FileInputStream(file)));           
        }catch(IOException ex){
            System.out.println("Failed to load config file. " + ex.getMessage());
        }
        return new Config(pro);
    }
    
    public String getFieldOrEmpty(String key){
        return prop.getProperty(key, "");
    }
    
    public String getField(String key) throws NoSuchFieldException {
        if(prop.containsKey(key)){
            return prop.getProperty(key);
        }else{
            throw new NoSuchFieldException("Field " + key + " is not found!");
        }
    }
    
    public void setField(String key, String value){
        prop.setProperty(key, value);
    }
    
    public void store(String file, String comment){
        try(BufferedOutputStream fw = new BufferedOutputStream(new FileOutputStream(file))){
            prop.store(fw, comment);
        } catch (IOException ex) {
            System.out.println("Failed to store config file. " + ex.getMessage());
        }
    }
}
