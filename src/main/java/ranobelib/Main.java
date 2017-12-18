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
    public static ArrayList<Ranobe> ranobe = new ArrayList<>();
    public static void main(String[] args){
    	ranobe.add(new Ranobe("manuscript-screening-boy-and-manuscript-submitting-girl-proveryayushchiy-rukopisi-malchik-i-podayushchaya-rukopisi-devochka", "Проверяющий Рукописи Мальчик и Подающая Рукописи Девочка "));
    	ranobe.add(new Ranobe("razrushiteli-breakers", "Бог Резни"));
    	ranobe.add(new Ranobe("razrushiteli-breakers", "Разрушители"));
    	ranobe.add(new Ranobe("mir-boga-i-dyavola-sistema-bogov-i-demonov-shen-mo-xi-tong-th-n-ma-h-th-ng", "Мир Бога и Дьявола"));
    	ranobe.add(new Ranobe("pravitel-vechnoy-nochi-monarkh-vechnoy-nochi-monarch-of-evernight", "Правитель Вечной Ночи"));
    	ranobe.add(new Ranobe("u-menya-est-dom-v-mire-postapokalipsisa-i-have-a-mansion-in-the-post-apocalyptic-world", "У меня есть дом в мире постапокалипсиса! "));
    	ranobe.add(new Ranobe("letopis-voyny-v-vortenii-voennie-khroniki-vortenii-wortenia-senki-record-of-wortenia-war-wortenia-war", "Летопись войны в Вортении"));
    	ranobe.add(new Ranobe("hvala-orku-praise-the-orc-you-re-an-orc-yet-you-re-still-praiseworthy", "Хвала Орку"));
    	ranobe.add(new Ranobe("printsessa-doktor-princess-medical-doctor", "Принцесса-доктор"));
        ranobe.add(new Ranobe("master-kultivirovaniya-s-zemli", "Мастер культивирования с земли"));
        ranobe.add(new Ranobe("drevnyaya-tekhnika-usileniya-ancient-strengthening-technique", "Древняя техника усиления"));
        ranobe.add(new Ranobe("pererozhdenie-monstr-re-monster", "Перерождение монстр"));
        ranobe.add(new Ranobe("bog-zvezdnykh-boevykh-iskusstv", "Бог звездных боевых искусств"));
        ranobe.add(new Ranobe("mag-na-polnuyu-stavku-quanzhi-fashi", "Маг на полную ставку"));
        ranobe.add(new Ranobe("evolution-theory-of-the-hunter", "Теория эволюции Охотника"));
        ranobe.add(new Ranobe("god-of-cooking", "Бог кулинарии"));
        ranobe.add(new Ranobe("mir-boevykh-iskusstv-martial-world", "Мир боевых искусств"));
        ranobe.add(new Ranobe("close-combat-mage", "Маг Ближнего Боя"));
        ranobe.add(new Ranobe("tensei-shitara-slime-datta-ken", "О моём перерождении в слизь"));
        ranobe.add(new Ranobe("reincarnator", "Реинкарнатор"));
        ranobe.add(new Ranobe("against-the-gods", "Восставший против неба"));
        ranobe.add(new Ranobe("tempest-of-the-stellar-war", "Буря Звёздной Войны"));
        ranobe.add(new Ranobe("vozrozhdenie-izvestnogo-na-vsyu-podnebesnuyu-vora", "Возрождение известного на всю поднебесную вора"));
        ranobe.add(new Ranobe("arena", "Арена"));
        ranobe.add(new Ranobe("law-of-the-devil", "Закон Дьявола"));
        ranobe.add(new Ranobe("tales-of-demons-and-gods", "Сказания о Демонах и Богах"));
        ranobe.add(new Ranobe("i-shall-seal-the-heavens", "Я Запечатаю Небеса"));
        ranobe.add(new Ranobe("legendary-moonlight-sculptor", "Легендарный лунный скульптор"));
        ranobe.add(new Ranobe("world-seed", "Мировое Семя"));
        ranobe.add(new Ranobe("magic-chef-of-ice-and-fire", "Мастер льда и пламени"));
        ranobe.add(new Ranobe("reincarnated-as-a-dragon-s-egg", "Перерождение в яйцо дракона"));
        ranobe.add(new Ranobe("the-man-picked-up-by-the-gods", "Избранный Богами"));
        ranobe.add(new Ranobe("ubijtsy-drakonov", "Убийцы Драконов"));
        ranobe.add(new Ranobe("martial-movement-upheaval", "Переворот военного движения"));
        ranobe.add(new Ranobe("martial-god-asura", "Воинственный Бог Асура"));
        ranobe.add(new Ranobe("imperator-odinochnoy-igry-emperor-of-solo-play", "Император Одиночной Игры"));
        ranobe.add(new Ranobe("bozhestvenniy-mech-haosa", "Божественный Меч Хаоса"));
        ranobe.add(new Ranobe("istinniy-mir-boevykh-iskusstv-true-martial-world", "Истинный мир боевых искусств"));
        ranobe.add(new Ranobe("izvivayushchiysya-drakon-coiling-dragon", "Извивающийся дракон"));
        ranobe.add(new Ranobe("avatar-korolya", "Аватар короля"));
        ranobe.add(new Ranobe("everyone-else-is-a-returnee", "Каждый возвращается домой"));
        ranobe.add(new Ranobe("combat-continent-boevoy-kontinent", "Боевой Континент"));
        ranobe.add(new Ranobe("the-new-gate-novie-vrata", "Новые врата"));
        ranobe.add(new Ranobe("goblin-slayer-ubiytsa-goblinov", "Убийца Гоблинов"));
        ranobe.add(new Ranobe("hai-to-gensou-no-grimgar-grimgar-iz-pepla-i-illyuziy", "Гримгар из пепла и иллюзий"));
        ranobe.add(new Ranobe("altina-the-sword-princess-altina-printsessa-mecha", "Алтина принцесса меча"));
        ranobe.add(new Ranobe("maoyuu-maou-yuusha-geroy-pri-zaklyatom-vrage", "Герой при заклятом враге"));
        ranobe.add(new Ranobe("ruhun-zirehi-dospekhi-prizraka", "Доспехи призрака"));
        ranobe.add(new Ranobe("mag-zabveniya", "Маг Забвения"));
        ranobe.add(new Ranobe("posledniy-put", "Последний путь"));
        ranobe.add(new Ranobe("rebirth-of-the-heavenly-demon-pererozhdenie-nebesnogo-demona", "Перерождение Небесного Демона"));
        ranobe.add(new Ranobe("hroniki-pervobytnykh-voyn-chronicles-of-primordial-wars-hroniki-pervozdannykh-voyn", "Хроники Первобытных Войн"));
        ranobe.add(new Ranobe("v-drugom-mire-so-smartfonom-in-a-different-world-with-a-smartphone-isekai-wa-smartphone-to-tomoni", "В Другом Мире со Смартфоном"));
        ranobe.add(new Ranobe("koy-coeus", "Кой"));
        ranobe.add(new Ranobe("mag-poedayushchiy-knigi-the-book-eating-magician-bem-the-book-eating-wizard", "Маг, поедающий книги"));
        ranobe.add(new Ranobe("ya-pererodilsya-v-nichto-i-reincarnated-for-nothing", "Я переродился в ничто"));
        ranobe.add(new Ranobe("genialniy-bessmertniy-mechnik-genius-sword-immortal-gsi-ti-nc-i-jian-xi-n", "Гениальный Бессмертный Мечник"));
        ranobe.add(new Ranobe("bezumno-izbalovannaya-zhena-bozhestvenniy-doktor-pyataya-yunaya-miss-insanely-pampered-wife-divine-doctor-fifth-young-miss", "Безумно избалованная жена: Божественный доктор пятая юная мисс"));
        ranobe.add(new Ranobe("vozrozhdenie-zlobnoy-imperatritsy-iz-voennoy-dinastii-the-rebirth-of-the-malicious-empress-of-military-lineage-ch-ngsh-ng-zh-jiangmen-d-h-u", "Возрождение Злобной Императрицы из Военной Династии"));
        ranobe.add(new Ranobe("povelitel-lyubi-menya-nezhno-overlord-lyubi-menya-nezhno-overlord-love-me-tender", "Повелитель, люби меня нежно!"));
        ranobe.add(new Ranobe("bessmertniy-kotoriy-byl-izgnan-s-nebes-v-mir-smertnykh-an-immortal-from-heaven-who-got-banished-into-the-mortal-world", "Бессмертный, который был изгнан с Небес в мир смертных"));
        ranobe.add(new Ranobe("krov-treidinstva-trinity-blood", "Кровь Треидинства"));
        ranobe.add(new Ranobe("super-gen-boga-super-god-gene-sgg-super-gene", "Супер Ген Бога"));
        ranobe.add(new Ranobe("eterniya-aethernea", "Этерния"));
        ranobe.forEach((Ranobe m)->{
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