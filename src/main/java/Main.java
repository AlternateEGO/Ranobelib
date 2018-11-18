import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.jsoup.Jsoup;

public class Main{
    static String SITE = "https://xn--80ac9aeh6f.xn--p1ai/";
    private static ArrayList<Ranobe> ranobe = new ArrayList<>();

    public static void main(String[] args){
        String uri = "https://xn--80ac9aeh6f.xn--p1ai/v1/book/list/?country=&limit=999";
        StringBuilder site_ = new StringBuilder();
        GetJson(uri, site_);
        Gson jgson = new GsonBuilder().serializeNulls().create();
        JsonMain gjson = jgson.fromJson(site_.toString(), JsonMain.class);
        gjson.result.books.forEach((PartMain p)->{
            //https://xn--80ac9aeh6f.xn--p1ai/v1/part/get/?bookAlias=mir-boevykh-iskusstv-martial-world&partAlias=noindex-prolog-magicheskiy-kub
            String str = p.url.replaceAll("https://xn--80ac9aeh6f.xn--p1ai/", "").replaceAll("/", "");
            ranobe.add(new Ranobe(p.title.replaceAll("[\\\\/:*?\"<>|]", ""), str));
        });
        ranobe.forEach((Ranobe m)->{
            new File("C:/Users/admin/Desktop/ranobe/json/" + m.FILE + ".json");
            StringBuilder json = new StringBuilder();
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:/Users/admin/Desktop/ranobe/json/" + m.FILE + ".json")));
                String line;
                while((line = reader.readLine()) != null){
                    json.append(line);
                }
            }catch(IOException ignored){}
            Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
            if(!json.toString().equals("")) m = gson.fromJson(json.toString(), Ranobe.class);
            m.start();
            try{
                FileWriter writer = new FileWriter("C:/Users/admin/Desktop/ranobe/json/" + m.FILE + ".json", false);
                writer.write(gson.toJson(m));
                writer.flush();
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            try{
                FileWriter writer = new FileWriter("C:/Users/admin/Desktop/ranobe/html/" + m.FILE + ".html", false);
                StringBuilder text = new StringBuilder("<!DOCTYPE html><html><head><title>" + m.FILE + "</title>");
                for(Glava glava : m.GLAVA){
                    try {
                        text.append(glava.TEXT);
                    }catch(Exception ignored){ }
                }
                text.append("</body></html>");
                text = new StringBuilder(Jsoup.parse(text.toString()).html());
                writer.write(text.toString());
                writer.flush();
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        });
    }

    static void GetJson(String uri, StringBuilder site_) {
        try {
            URL url = new URL(uri);
            try {
                LineNumberReader reader = new LineNumberReader(new InputStreamReader(url.openStream()));
                String string = reader.readLine();
                while (string != null) {
                    assert false;
                    site_.append(string);
                    string = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }
}