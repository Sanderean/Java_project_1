/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andru
 */
public final class RepositoryFactory {

    private static final Properties properties = new Properties();
    private static final String PATH = "/config/repository.properties";
    private static final String CLASS_NAME = "CLASS_NAME";
    
    private RepositoryFactory(){}
    
    private static Repository repository;

    static {
        try (InputStream is = RepositoryFactory.class.getResourceAsStream(PATH)) {
            properties.load(is);
            repository = (Repository) Class
                    .forName(properties.getProperty(CLASS_NAME))
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception ex) {
            Logger.getLogger(RepositoryFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Repository getRepository() {
        return repository;
    }
}