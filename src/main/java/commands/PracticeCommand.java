package commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Victor on 22.03.2017.
 */
public class PracticeCommand extends BotCommand {
    public PracticeCommand() {super("practice", "practic.." );}

    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        SendMessage message = new SendMessage();
        message.setText("Выбери практику по которой хочешь получить задание");
        message.setChatId(chat.getId());
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        List<InlineKeyboardButton> row4 = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Практика 1");
        button1.setCallbackData("practice 1");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Практика 2");
        button2.setCallbackData("practice 2");
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("Практика 3");
        button3.setCallbackData("practice 3");
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setText("Практика 4");
        button4.setCallbackData("practice 4");
        InlineKeyboardButton button5 = new InlineKeyboardButton();
        button5.setText("Практика 5");
        button5.setCallbackData("practice 5");
        InlineKeyboardButton button6 = new InlineKeyboardButton();
        button6.setText("Практика 6");
        button6.setCallbackData("practice 6");
        InlineKeyboardButton button7 = new InlineKeyboardButton();
        button7.setText("Практика 7");
        button7.setCallbackData("practice 7");
        InlineKeyboardButton button8 = new InlineKeyboardButton();
        button8.setText("Практика 8");
        button8.setCallbackData("practice 8");

        row1.add(button1);
        row1.add(button2);
        row2.add(button3);
        row2.add(button4);
        row3.add(button5);
        row3.add(button6);
        row4.add(button7);
        row4.add(button8);

        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);

        markup.setKeyboard(keyboard);
        message.setReplyMarkup(markup);

        try {
            absSender.sendMessage(message);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    public static SortedMap<Integer,ArrayList<String>> getPractice (){
        SortedMap<Integer, ArrayList<String>> practiceLinks = new TreeMap<>();

        practiceLinks.put(4,new ArrayList<String>());
        practiceLinks.get(4).add("Сформулируйте запрос, выводящий имена всех подчиненных King.");
        practiceLinks.get(4).add("Сформулируйте запрос, выводящий имена сотрудников работающих в одном отделе со Smith.");
        practiceLinks.get(4).add("* Сформулируйте запрос, выводящий имена сотрудников, нанятых после Smith в его отдел.");
        practiceLinks.get(4).add("Сформируйте запрос, выводящий фамилии руководителей, у которых все подчиненные получают больше $2500");
        practiceLinks.get(4).add("Сформулируйте запрос, выводящий имена сотрудников нанятых после служащих отдела №30");
        practiceLinks.get(4).add("Сформировать запрос, выводящий фамилию, номер подразделения и зарплату работников которые работают в отделах, где некоторым сотрудником выплачивают премию.");
        practiceLinks.get(4).add("* Сформируйте запрос, выводящий информацию о работниках, зарплата которых больше зарплаты любого из клерков.");

      return  practiceLinks;
    }
}