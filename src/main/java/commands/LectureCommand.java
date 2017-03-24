package commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.bots.commands.ICommandRegistry;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.*;

/**
 * Created by trm_cp on 3/22/17.
 */
public class LectureCommand extends BotCommand {

    //private static final String LOGTAG = "LECTURECOMMAND";

    private final ICommandRegistry commandRegistry;

    public LectureCommand(ICommandRegistry commandRegistry) {
        super("lecture", "Get list of lectures or lecture specified by id");
        this.commandRegistry = commandRegistry;
    }


    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {

        StringBuilder lectureMessageBuilder = new StringBuilder("<b>Lectures</b>\n");
        ArrayList<String> linksToSend = new ArrayList<>();

        SortedMap<Integer,String> lectureNames = getLectureNames();
        SortedMap<Integer,ArrayList<String>> lectureLinks = getLectureLinks();


        if (arguments != null && arguments.length > 0) {
            for (String id: arguments){
                int lectureID = Integer.parseInt(id);
                for (String link: lectureLinks.get(lectureID)){
                    linksToSend.add("<a href=\"" +link +"\">" + lectureNames.get(lectureID) + "</a>");
                }


            }
        }else{
            lectureMessageBuilder.append("Бе бе бе, введи id.\n");
            lectureMessageBuilder.append("These are the list of lectures:\n\n");
            for (Integer id : lectureNames.keySet()) {
                lectureMessageBuilder.append(lectureNames.get(id)).append("\n");
            }
        }

        SendMessage lectureMessage = new SendMessage();
        lectureMessage.setChatId(chat.getId().toString());
        lectureMessage.enableHtml(true);
        lectureMessage.setText(lectureMessageBuilder.toString());

        ArrayList<SendMessage> linksMessages = new ArrayList<>();
        for (String link: linksToSend){
            SendMessage message = new SendMessage();
            message.setChatId(chat.getId().toString());
            message.enableHtml(true);
            message.setText(link);
            linksMessages.add(message);
        }

        try {
            absSender.sendMessage(lectureMessage);
            for (SendMessage message: linksMessages){
                absSender.sendMessage(message);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    private  SortedMap<Integer,String> getLectureNames(){
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

    private SortedMap<Integer,ArrayList <String>> getLectureLinks() {
        SortedMap<Integer, ArrayList<String>> lectureLinks = new TreeMap<>();
        lectureLinks.put(1, new ArrayList<String>());

        lectureLinks.get(1).add("http://dl.sumdu.edu.ua/e-pub/db-in/523092/4.1_%D0%A1%D0%BE%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5_%D1%82%D0%B0%D0%B1%D0%BB%D0%B8%D1%86.pdf?1487840405");
        lectureLinks.get(1).add("http://dl.sumdu.edu.ua/e-pub/db-in/523093/4.2_%D0%A1%D1%81%D1%8B%D0%BB%D0%BE%D1%87%D0%BD%D0%B0%D1%8F_%D1%86%D0%B5%D0%BB%D0%BE%D1%81%D0%BD%D0%BE%D1%81%D1%82%D1%8C.pdf?1487840405");

        lectureLinks.put(2, new ArrayList<String>());
        lectureLinks.put(3, new ArrayList<String>());
        lectureLinks.put(4, new ArrayList<String>());
        lectureLinks.put(5, new ArrayList<String>());
        lectureLinks.put(6, new ArrayList<String>());
        lectureLinks.put(7, new ArrayList<String>());
        lectureLinks.put(8, new ArrayList<String>());
        lectureLinks.put(9, new ArrayList<String>());
        lectureLinks.put(10, new ArrayList<String>());
        lectureLinks.put(11, new ArrayList<String>());
        lectureLinks.put(12, new ArrayList<String>());
        return lectureLinks;
    }
}
