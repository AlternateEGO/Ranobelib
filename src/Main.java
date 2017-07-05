import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.jsoup.Jsoup;
public class Main{
    public static String SITE = "http://ranobelib.ru/";
    public static ArrayList<Manga> MANGA = new ArrayList<>();
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void main(String[] args){
        MANGA.add(new Manga("master-kultivirovaniya-s-zemli", "Мастер культивирования с земли"));
        MANGA.add(new Manga("drevnyaya-tekhnika-usileniya-ancient-strengthening-technique", "Древняя техника усиления"));
        MANGA.add(new Manga("pererozhdenie-monstr-re-monster", "Перерождение монстр"));
        MANGA.add(new Manga("bog-zvezdnykh-boevykh-iskusstv", "Бог звездных боевых искусств"));
        MANGA.add(new Manga("mag-na-polnuyu-stavku-quanzhi-fashi", "Маг на полную ставку"));
        MANGA.add(new Manga("evolution-theory-of-the-hunter", "Теория эволюции Охотника"));
        MANGA.add(new Manga("god-of-cooking", "Бог кулинарии"));
        MANGA.add(new Manga("mir-boevykh-iskusstv-martial-world", "Мир боевых искусств"));
        MANGA.add(new Manga("close-combat-mage", "Маг Ближнего Боя"));
        MANGA.add(new Manga("tensei-shitara-slime-datta-ken", "О моём перерождении в слизь"));
        MANGA.add(new Manga("reincarnator", "Реинкарнатор"));
        MANGA.add(new Manga("against-the-gods", "Восставший против неба"));
        MANGA.add(new Manga("tempest-of-the-stellar-war", "Буря Звёздной Войны"));
        MANGA.add(new Manga("vozrozhdenie-izvestnogo-na-vsyu-podnebesnuyu-vora", "Возрождение известного на всю поднебесную вора"));
        MANGA.add(new Manga("arena", "Арена"));
        MANGA.add(new Manga("law-of-the-devil", "Закон Дьявола"));
        MANGA.add(new Manga("tales-of-demons-and-gods", "Сказания о Демонах и Богах"));
        MANGA.add(new Manga("i-shall-seal-the-heavens", "Я Запечатаю Небеса"));
        MANGA.add(new Manga("legendary-moonlight-sculptor", "Легендарный лунный скульптор"));
        MANGA.add(new Manga("world-seed", "Мировое Семя"));
        MANGA.add(new Manga("magic-chef-of-ice-and-fire", "Мастер льда и пламени"));
        MANGA.add(new Manga("reincarnated-as-a-dragon-s-egg", "Перерождение в яйцо дракона"));
        MANGA.add(new Manga("the-man-picked-up-by-the-gods", "Избранный Богами"));
        MANGA.add(new Manga("ubijtsy-drakonov", "Убийцы Драконов"));
        MANGA.add(new Manga("martial-movement-upheaval", "Переворот военного движения"));
        MANGA.add(new Manga("martial-god-asura", "Воинственный Бог Асура"));
        MANGA.add(new Manga("imperator-odinochnoy-igry-emperor-of-solo-play", "Император Одиночной Игры"));
        MANGA.add(new Manga("bozhestvenniy-mech-haosa", "Божественный Меч Хаоса"));
        MANGA.add(new Manga("istinniy-mir-boevykh-iskusstv-true-martial-world", "Истинный мир боевых искусств"));
        MANGA.add(new Manga("izvivayushchiysya-drakon-coiling-dragon", "Извивающийся дракон"));
        MANGA.add(new Manga("avatar-korolya", "Аватар короля"));
        MANGA.add(new Manga("everyone-else-is-a-returnee", "Каждый возвращается домой"));
        MANGA.add(new Manga("combat-continent-boevoy-kontinent", "Боевой Континент"));
        MANGA.add(new Manga("the-new-gate-novie-vrata", "Новые врата"));
        MANGA.add(new Manga("goblin-slayer-ubiytsa-goblinov", "Убийца Гоблинов"));
        MANGA.add(new Manga("hai-to-gensou-no-grimgar-grimgar-iz-pepla-i-illyuziy", "Гримгар из пепла и иллюзий"));
        MANGA.add(new Manga("altina-the-sword-princess-altina-printsessa-mecha", "Алтина принцесса меча"));
        MANGA.add(new Manga("maoyuu-maou-yuusha-geroy-pri-zaklyatom-vrage", "Герой при заклятом враге"));
        MANGA.add(new Manga("ruhun-zirehi-dospekhi-prizraka", "Доспехи призрака"));
        MANGA.add(new Manga("mag-zabveniya", "Маг Забвения"));
        MANGA.add(new Manga("posledniy-put", "Последний путь"));
        MANGA.add(new Manga("rebirth-of-the-heavenly-demon-pererozhdenie-nebesnogo-demona", "Перерождение Небесного Демона"));
        MANGA.forEach((Manga m)->{
            File file = new File(m.FILE + ".json");
            String json = "";
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(m.FILE + ".json"), StandardCharsets.UTF_8));
                String line;
                while((line = reader.readLine()) != null){
                    json += line;
                }
            }catch(IOException e){}
            Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
            if(!json.equals("")) m = gson.fromJson(json, Manga.class);
            m.start();
            try{
                FileWriter writer = new FileWriter(m.FILE + ".json", false);
                writer.write(gson.toJson(m));
                writer.flush();
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            for(Glava glava : m.GLAVA){
                try{
                    glava.TEXT = glava.TEXT.substring(4);
                }catch(Exception e){}
                try{
                    glava.TEXT = glava.TEXT.substring(0, glava.TEXT.length() - 136);
                }catch(Exception e){}
            }
            try{
                FileWriter writer = new FileWriter(m.FILE + ".html", false);
                String text = "<!DOCTYPE html><html><head><title>" + m.FILE + "</title><link href='https://fonts.googleapis.com/css?family=Rubik' rel='stylesheet'></head><body><style>body{font-family: 'Rubik', sans-serif;}</style>";
                for(Glava glava : m.GLAVA){
                    text += glava.TEXT;
                }
                text += "</body></html>";
                text = Jsoup.parse(text).html();
                writer.write(text);
                writer.flush();
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        });
    }
}