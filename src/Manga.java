import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Manga{
    public String NAME;
    public String FILE;
    public ArrayList<Glava> GLAVA = new ArrayList<>();
    public Manga(String name, String file){
        NAME = name;
        FILE = file;
    }
    void start(){
        Document doc = null;
        try{
            doc = Jsoup.connect(Main.SITE + NAME).get();
        }catch(IOException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(doc != null){
            ArrayList<Element> elements = new ArrayList<>();
            Elements elementGlava = doc.select("li.display-none");
            Collections.reverse(elementGlava);
            elementGlava.forEach((Element e)->{
                elements.add(e);
            });
            elementGlava = doc.select("li.display");
            Collections.reverse(elementGlava);
            elementGlava.forEach((Element e)->{
                elements.add(e);
            });
            for(int i = 0; i < elements.size(); i++){
                if(!isGlava(i)) GLAVA.add(new Glava(elements.get(i).select("a").get(0).attr("href"), i));
            }
        }
        Collections.sort(GLAVA, CompareGlava);
    }
    public boolean isGlava(int number){
        return GLAVA.stream().anyMatch((g)->(g.NUMBER == number));
    }
    public static final Comparator<Glava> CompareGlava = (Glava glava_0, Glava glava_1)->((Integer)glava_0.NUMBER).compareTo((Integer)glava_1.NUMBER);
}
