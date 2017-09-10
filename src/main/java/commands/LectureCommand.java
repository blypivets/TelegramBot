package commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class LectureCommand extends BotCommand {

    public LectureCommand() {
        super("lecture", "Get list of lectures or lecture specified by id");
    }


    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {

        Properties properties = new Properties();
        FileInputStream fis;

        //StringBuilder lectureMessageBuilder = new StringBuilder("<b>Список лекций:\n\n</b>\n");

        SortedMap<Integer,String> lectureNames = getLectureNames();
        SortedMap<Integer,ArrayList<String>> lectureLinks = getLectureLinks();

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        for (Integer id : lectureNames.keySet()) {

            for (int i = 0; i < lectureLinks.get(id).size(); i++){
                List<InlineKeyboardButton> row = new ArrayList<>();
                InlineKeyboardButton button = new InlineKeyboardButton();

                String lectureLabel = lectureNames.get(id);
                if (lectureLinks.get(id).size() > 1){
                    String[] lectureLabelArray = lectureLabel.split(" ");
                    lectureLabelArray[1] = lectureLabelArray[1] + (i + 1);
                    lectureLabel = " ";
                    for (String partOfLabel : lectureLabelArray){
                        lectureLabel += partOfLabel + " ";
                    }
                }

                button.setUrl(lectureLinks.get(id).get(i));
                button.setText(lectureLabel);
//            button.setUrl(url.toString());
//            button.setText(lectureNames.get(id));
                //button.setCallbackData("lecture " + id);

                row.add(button);
                keyboard.add(row);
            }

        }
        markup.setKeyboard(keyboard);

        try {

            fis = new FileInputStream("src/main/resources/descriptionCommand.properties");
            properties.load(fis);

            String description = new String(properties.getProperty("lectureCommand").getBytes("ISO8859-1"));

            SendMessage lectureMessage = new SendMessage();
            lectureMessage.setChatId(chat.getId().toString());
            lectureMessage.enableHtml(true);
            lectureMessage.setText(description);
            lectureMessage.setReplyMarkup(markup);

            absSender.sendMessage(lectureMessage);
            fis.close();

        } catch (TelegramApiException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static SortedMap<Integer,String> getLectureNames(){
        SortedMap<Integer,String> lectureNames = new TreeMap<>();
        lectureNames.put(1,"Лекция 1-2. Вступление. Табличная модель");
        lectureNames.put(2,"Лекция 3. Простые запросы");
        lectureNames.put(3,"Лекция 4. Ограничение объемов выборки");
        lectureNames.put(4,"Лекция 5. Функции одной строки (домашнее чтение)");
        lectureNames.put(5,"Лекция 6. Подзапросы");
        lectureNames.put(6,"Лекция 7. DML, Виды, SET-операции");
        lectureNames.put(7,"Лекция 8. Выборки из нескольких таблиц");
        lectureNames.put(8,"Лекция 9. Агрегатные функции");
        lectureNames.put(9,"Лекция 10. Транзакции");
        lectureNames.put(10,"Лекция 11. Индексы. Триггеры");
        lectureNames.put(11,"Лекция 12. Иерархические запросы");
        lectureNames.put(12,"Лекция 13. Мета-моделирование");

        return lectureNames;
    }

    public static SortedMap<Integer,ArrayList <String>> getLectureLinks() {
        SortedMap<Integer, ArrayList<String>> lectureLinks = new TreeMap<>();

        lectureLinks.put(1, new ArrayList<String>());
        lectureLinks.get(1).add("http://dl.sumdu.edu.ua/e-pub/db-in/523092/4.1_%D0%A1%D0%BE%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5_%D1%82%D0%B0%D0%B1%D0%BB%D0%B8%D1%86.pdf?1487840405");
        lectureLinks.get(1).add("http://dl.sumdu.edu.ua/e-pub/db-in/523093/4.2_%D0%A1%D1%81%D1%8B%D0%BB%D0%BE%D1%87%D0%BD%D0%B0%D1%8F_%D1%86%D0%B5%D0%BB%D0%BE%D1%81%D0%BD%D0%BE%D1%81%D1%82%D1%8C.pdf?1487840405");

        lectureLinks.put(2, new ArrayList<String>());
        lectureLinks.get(2).add("http://dl.sumdu.edu.ua/e-pub/db-in/523103/5_SQL_plus.pdf?1487840405");

        lectureLinks.put(3, new ArrayList<String>());
        lectureLinks.get(3).add("http://dl.sumdu.edu.ua/e-pub/db-in/523105/6_WHERE.pdf?1487840405");

        lectureLinks.put(4, new ArrayList<String>());
        lectureLinks.get(4).add("http://dl.sumdu.edu.ua/e-pub/db-in/523107/7_%D0%A4%D1%83%D0%BD%D0%BA%D1%86%D0%B8%D0%B8_%D0%BE%D0%B4%D0%BD%D0%BE%D0%B9_%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B8.pdf?1487840405");

        lectureLinks.put(5, new ArrayList<String>());
        lectureLinks.get(5).add("http://dl.sumdu.edu.ua/e-pub/db-in/523109/8_1_%D0%92%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%BD%D1%8B%D0%B5_%D0%B7%D0%B0%D0%BF%D1%80%D0%BE%D1%81%D1%8B.pdf?1487840405");
        lectureLinks.get(5).add("http://dl.sumdu.edu.ua/e-pub/db-in/523110/8_2_part_or_ordered_query.pptx?1487840405");

        lectureLinks.put(6, new ArrayList<String>());
        lectureLinks.get(6).add("http://dl.sumdu.edu.ua/e-pub/db-in/523128/9_DML.pdf?1487840405");
        lectureLinks.get(6).add("http://dl.sumdu.edu.ua/e-pub/db-in/523133/9_2_%D0%92%D0%B8%D0%B4%D1%8B.pdf?1487840405");
        lectureLinks.get(6).add("http://dl.sumdu.edu.ua/e-pub/db-in/523132/8_2_SET.pdf?1487840405");

        lectureLinks.put(7, new ArrayList<String>());
        lectureLinks.get(7).add("http://dl.sumdu.edu.ua/e-pub/db-in/523130/10_JOIN.pdf?1487840405");

        lectureLinks.put(8, new ArrayList<String>());
        lectureLinks.get(8).add("http://dl.sumdu.edu.ua/e-pub/db-in/523145/11_Group.pdf?1487840405");

        lectureLinks.put(9, new ArrayList<String>());
        lectureLinks.get(9).add("http://dl.sumdu.edu.ua/e-pub/db-in/523147/12_tranastion.pdf?1487840405");

        lectureLinks.put(10, new ArrayList<String>());
        lectureLinks.get(10).add("http://dl.sumdu.edu.ua/e-pub/db-in/523149/13_Index_Sequence_Triggers.pdf?1487840405");

        lectureLinks.put(11, new ArrayList<String>());
        lectureLinks.get(11).add("http://dl.sumdu.edu.ua/e-pub/db-in/523151/14_%D0%98%D0%B5%D1%80%D0%B0%D1%80%D1%85%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B5_%D0%B0%D0%B4%D0%BC%D0%B8%D0%BD%D0%B8%D1%81%D1%82%D1%80%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5.pdf?1487840405");
        lectureLinks.get(11).add("http://dl.sumdu.edu.ua/e-pub/db-in/536995/lecture.pdf?1487840405");

        lectureLinks.put(12, new ArrayList<String>());
        lectureLinks.get(12).add("http://dl.sumdu.edu.ua/e-pub/db-in/523155/15_%D0%9C%D0%B5%D1%82%D0%B0%D0%BC%D0%BE%D0%B4%D0%B5%D0%BB%D1%8C.pdf?1487840405");
        lectureLinks.get(12).add("http://dl.sumdu.edu.ua/e-pub/db-in/523157/280-263.pdf?1487840405");

        return lectureLinks;
    }
}
