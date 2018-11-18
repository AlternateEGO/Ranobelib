import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

class Glava{
    int NUMBER;
    String TEXT;
    Glava(String uri, int number, Ranobe ranobe, JsonRanobe jsonRanobe){
        uri = uri.replaceAll("/" + ranobe.NAME + "/", "").replaceAll("/", "");
        uri = Main.SITE + "v1/part/get/?bookAlias=" + ranobe.NAME + "&partAlias=" + uri;
        NUMBER = number;
        StringBuilder site = new StringBuilder();
        try {
            URL url = new URL(uri);
            try {
                LineNumberReader reader = new LineNumberReader(new InputStreamReader(url.openStream()));
                String string = reader.readLine();
                while (string != null) {
                    assert false;
                    site.append(string);
                    string = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonGlava json = gson.fromJson(site.toString(), JsonGlava.class);
        TEXT += "<p align='center'>" + json.result.part.title + "</p>";
        System.out.println(ranobe.FILE + "    " + json.result.part.title + "    " + (NUMBER + 1) + "/" + jsonRanobe.result.parts.size());
        Document doc = Jsoup.parse(json.result.part.content);
        doc.select("img").remove();
        TEXT += doc.html();
    }
}