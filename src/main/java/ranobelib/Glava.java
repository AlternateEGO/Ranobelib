package ranobelib;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class Glava{
    public int NUMBER;
    public String TEXT;
    public Glava(String uri, int number, Ranobe ranobe){
        NUMBER = number;
        Document doc = null;
        try{
            doc = Jsoup.connect(uri).get();
        }catch(IOException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(doc != null){
        	doc.select("iframe").remove();
            Elements elementTitle = doc.select(".title");
            String title = elementTitle.get(0).text();
            TEXT += "<p align='center'>" + title + "</p>";
            System.out.println(ranobe.FILE + "    " + title + "    " + (NUMBER + 1) + "/" + ranobe.MAX);
            Elements elementText = doc.select(".text");
            elementText.select("a").remove();
            TEXT += elementText.html();
        }
    }
}