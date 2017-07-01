import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class Glava{
    public int NUMBER;
    public String TEXT;
    public Glava(String uri, int number){
        NUMBER = number;
        Document doc = null;
        try{
            doc = Jsoup.connect(uri).get();
        }catch(IOException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(doc != null){
            Elements elementTitle = doc.select(".title");
            String title = elementTitle.get(0).text();
            TEXT += title + "\n";
            System.out.println("    " + title);
            Elements elementText = doc.select(".text");
            elementText.get(0).select("p").forEach((element)->{
                TEXT += element.text() + "\n";
            });
            TEXT += "\n\n";
        }
    }
}