package ranobelib;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.jsoup.Jsoup;
public class Main{
    public static String SITE = "http://ranobelib.ru/";
    public static ArrayList<Ranobe> RANOBE = new ArrayList<>();
    public static void main(String[] args){
    	RANOBE.add(new Ranobe("manuscript-screening-boy-and-manuscript-submitting-girl-proveryayushchiy-rukopisi-malchik-i-podayushchaya-rukopisi-devochka", "Проверяющий Рукописи Мальчик и Подающая Рукописи Девочка "));
    	RANOBE.add(new Ranobe("razrushiteli-breakers", "Бог Резни"));
    	RANOBE.add(new Ranobe("razrushiteli-breakers", "Разрушители"));
    	RANOBE.add(new Ranobe("mir-boga-i-dyavola-sistema-bogov-i-demonov-shen-mo-xi-tong-th-n-ma-h-th-ng", "Мир Бога и Дьявола"));
    	RANOBE.add(new Ranobe("pravitel-vechnoy-nochi-monarkh-vechnoy-nochi-monarch-of-evernight", "Правитель Вечной Ночи"));
    	RANOBE.add(new Ranobe("u-menya-est-dom-v-mire-postapokalipsisa-i-have-a-mansion-in-the-post-apocalyptic-world", "У меня есть дом в мире постапокалипсиса! "));
    	RANOBE.add(new Ranobe("letopis-voyny-v-vortenii-voennie-khroniki-vortenii-wortenia-senki-record-of-wortenia-war-wortenia-war", "Летопись войны в Вортении"));
    	RANOBE.add(new Ranobe("hvala-orku-praise-the-orc-you-re-an-orc-yet-you-re-still-praiseworthy", "Хвала Орку"));
    	RANOBE.add(new Ranobe("printsessa-doktor-princess-medical-doctor", "Принцесса-доктор"));
        RANOBE.add(new Ranobe("master-kultivirovaniya-s-zemli", "Мастер культивирования с земли"));
        RANOBE.add(new Ranobe("drevnyaya-tekhnika-usileniya-ancient-strengthening-technique", "Древняя техника усиления"));
        RANOBE.add(new Ranobe("pererozhdenie-monstr-re-monster", "Перерождение монстр"));
        RANOBE.add(new Ranobe("bog-zvezdnykh-boevykh-iskusstv", "Бог звездных боевых искусств"));
        RANOBE.add(new Ranobe("mag-na-polnuyu-stavku-quanzhi-fashi", "Маг на полную ставку"));
        RANOBE.add(new Ranobe("evolution-theory-of-the-hunter", "Теория эволюции Охотника"));
        RANOBE.add(new Ranobe("god-of-cooking", "Бог кулинарии"));
        RANOBE.add(new Ranobe("mir-boevykh-iskusstv-martial-world", "Мир боевых искусств"));
        RANOBE.add(new Ranobe("close-combat-mage", "Маг Ближнего Боя"));
        RANOBE.add(new Ranobe("tensei-shitara-slime-datta-ken", "О моём перерождении в слизь"));
        RANOBE.add(new Ranobe("reincarnator", "Реинкарнатор"));
        RANOBE.add(new Ranobe("against-the-gods", "Восставший против неба"));
        RANOBE.add(new Ranobe("tempest-of-the-stellar-war", "Буря Звёздной Войны"));
        RANOBE.add(new Ranobe("vozrozhdenie-izvestnogo-na-vsyu-podnebesnuyu-vora", "Возрождение известного на всю поднебесную вора"));
        RANOBE.add(new Ranobe("arena", "Арена"));
        RANOBE.add(new Ranobe("law-of-the-devil", "Закон Дьявола"));
        RANOBE.add(new Ranobe("tales-of-demons-and-gods", "Сказания о Демонах и Богах"));
        RANOBE.add(new Ranobe("i-shall-seal-the-heavens", "Я Запечатаю Небеса"));
        RANOBE.add(new Ranobe("legendary-moonlight-sculptor", "Легендарный лунный скульптор"));
        RANOBE.add(new Ranobe("world-seed", "Мировое Семя"));
        RANOBE.add(new Ranobe("magic-chef-of-ice-and-fire", "Мастер льда и пламени"));
        RANOBE.add(new Ranobe("reincarnated-as-a-dragon-s-egg", "Перерождение в яйцо дракона"));
        RANOBE.add(new Ranobe("the-man-picked-up-by-the-gods", "Избранный Богами"));
        RANOBE.add(new Ranobe("ubijtsy-drakonov", "Убийцы Драконов"));
        RANOBE.add(new Ranobe("martial-movement-upheaval", "Переворот военного движения"));
        RANOBE.add(new Ranobe("martial-god-asura", "Воинственный Бог Асура"));
        RANOBE.add(new Ranobe("imperator-odinochnoy-igry-emperor-of-solo-play", "Император Одиночной Игры"));
        RANOBE.add(new Ranobe("bozhestvenniy-mech-haosa", "Божественный Меч Хаоса"));
        RANOBE.add(new Ranobe("istinniy-mir-boevykh-iskusstv-true-martial-world", "Истинный мир боевых искусств"));
        RANOBE.add(new Ranobe("izvivayushchiysya-drakon-coiling-dragon", "Извивающийся дракон"));
        RANOBE.add(new Ranobe("avatar-korolya", "Аватар короля"));
        RANOBE.add(new Ranobe("everyone-else-is-a-returnee", "Каждый возвращается домой"));
        RANOBE.add(new Ranobe("combat-continent-boevoy-kontinent", "Боевой Континент"));
        RANOBE.add(new Ranobe("the-new-gate-novie-vrata", "Новые врата"));
        RANOBE.add(new Ranobe("goblin-slayer-ubiytsa-goblinov", "Убийца Гоблинов"));
        RANOBE.add(new Ranobe("hai-to-gensou-no-grimgar-grimgar-iz-pepla-i-illyuziy", "Гримгар из пепла и иллюзий"));
        RANOBE.add(new Ranobe("altina-the-sword-princess-altina-printsessa-mecha", "Алтина принцесса меча"));
        RANOBE.add(new Ranobe("maoyuu-maou-yuusha-geroy-pri-zaklyatom-vrage", "Герой при заклятом враге"));
        RANOBE.add(new Ranobe("ruhun-zirehi-dospekhi-prizraka", "Доспехи призрака"));
        RANOBE.add(new Ranobe("mag-zabveniya", "Маг Забвения"));
        RANOBE.add(new Ranobe("posledniy-put", "Последний путь"));
        RANOBE.add(new Ranobe("rebirth-of-the-heavenly-demon-pererozhdenie-nebesnogo-demona", "Перерождение Небесного Демона"));
        RANOBE.forEach((Ranobe m)->{
            @SuppressWarnings("unused")
			File file = new File("./save/json/" + m.FILE + ".json");
            String json = "";
            try{
                @SuppressWarnings("resource")
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./save/json/" + m.FILE + ".json")));
                String line;
                while((line = reader.readLine()) != null){
                    json += line;
                }
            }catch(IOException e){}
            Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
            if(!json.equals("")) m = gson.fromJson(json, Ranobe.class);
            m.start();
            try{
                @SuppressWarnings("resource")
				FileWriter writer = new FileWriter("./save/json/" + m.FILE + ".json", false);
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
                @SuppressWarnings("resource")
				FileWriter writer = new FileWriter("./save/html/" + m.FILE + ".html", false);
                String text = "<!DOCTYPE html><html><head><title>" + m.FILE + "</title>";
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