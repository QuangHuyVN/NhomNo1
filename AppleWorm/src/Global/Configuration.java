package Global;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Configuration {

    private  static Configuration instance = null;
    Properties prop;
    public Logger logger;

    public static InputStream charge(String name){
        return ClassLoader.getSystemClassLoader().getResourceAsStream(name);
    }

    public Configuration(){
        prop = new Properties();
        try {
            InputStream propIn = charge("default.cfg");
            prop.load(propIn);
            String home = System.getProperty("user.home");
            FileInputStream f = new FileInputStream(home + "/.sokoban");
            prop = new Properties(prop);
            prop.load(f);
        }catch (Exception e){
            System.err.println("Error while reading configuration: " + e);
        }
    }

    public static Configuration instance(){
        if (instance == null)
            instance = new Configuration();
        return instance;
    }

    public String read(String key){
        String res = prop.getProperty(key);
        if(res == null)
            throw new NoSuchElementException("Property " + key +" not defined");
        return res;
    }

    public Logger logger(){
        if(logger == null){
            System.setProperty("java.util.logging.SimpleFormatter", "%4$s : %5$s%n");
            logger = Logger.getLogger("Sokoban.Logger");
            logger.setLevel(Level.parse(read("LogLevel")));
        }
        return logger;
    }
}