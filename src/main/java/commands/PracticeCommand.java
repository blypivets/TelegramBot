package commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 22.03.2017.
 */
public class PracticeCommand extends BotCommand {
    public PracticeCommand() {super("practice",
    "practic.." );}

    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        SendMessage message = new SendMessage();
        message.setText("Выбери практику по которой хочешь получить задание");
        message.setChatId(chat.getId());
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> keyboard = new ArrayList();

        List<InlineKeyboardButton> row1 = new ArrayList();
        List<InlineKeyboardButton> row2 = new ArrayList();
        List<InlineKeyboardButton> row3 = new ArrayList();
        List<InlineKeyboardButton> row4 = new ArrayList();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Практика 1");
        button1.setCallbackData("1");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Практика 2");
        button2.setCallbackData("2");
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("Практика 3");
        button3.setCallbackData("3");
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setText("Практика 4");
        button4.setCallbackData("4");
        InlineKeyboardButton button5 = new InlineKeyboardButton();
        button5.setText("Практика 5");
        button5.setCallbackData("5");
        InlineKeyboardButton button6 = new InlineKeyboardButton();
        button6.setText("Практика 6");
        button6.setCallbackData("6");
        InlineKeyboardButton button7 = new InlineKeyboardButton();
        button7.setText("Практика 7");
        button7.setCallbackData("7");
        InlineKeyboardButton button8 = new InlineKeyboardButton();
        button8.setText("Практика 8");
        button8.setCallbackData("8");

        Update update = new Update();

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

        CallbackQuery callbackQuery = new CallbackQuery();

        try {
            absSender.sendMessage(message);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        
        /*if (strings != null && strings.length > 0) {

            if(Integer.parseInt(strings[0]) == 3){
                try {
                    SendMessage answer = new SendMessage();
                    answer.setChatId(chat.getId().toString());

                    answer.setText("Вот тебе задания практики "+ strings[0]);

                    absSender.sendMessage(answer);

                    answer.setText( "1) Отделу кадров требуется отчет, который содержит " +
                            "имя сотрудника, текущую зарплату и зарплату " +
                            "увеличенную на 21,33%. Значения последнего " +
                            "столбца должны быть округлены до целого.");
                    absSender.sendMessage(answer);

                    answer.setText("2) Сравните результаты, которые возвращают запросы:\n" +
                            "1. SELECT TRUNC(55.52,2) FROM DUAL;\n" +
                            "2. SELECT TRUNC(55.52) FROM DUAL;\n" +
                            "3. SELECT TRUNC(55.52,-1) FROM DUAL;\n" +
                            "4. SELECT ROUND(55.52,2) FROM DUAL;\n" +
                            "5. SELECT ROUND(55.52) FROM DUAL;\n" +
                            "6. SELECT ROUND(55.52,-1) FROM DUAL;");
                    absSender.sendMessage(answer);

                    answer.setText("3) * Выберите имя и длину имени всех сотрудников, имя которых " +
                            "начинается с «J», «A» или «M». Дайте столбцам понятные" +
                            "имена.");
                    absSender.sendMessage(answer);

                    answer.setText("4) Выведите подразделения, в местоположении которых 4-я " +
                            "буква — «С» (CHICAGO)");
                    absSender.sendMessage(answer);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if(Integer.parseInt(strings[0]) == 4){
                try {
                SendMessage answer = new SendMessage();
                answer.setChatId(chat.getId().toString());

                answer.setText("Вот тебе задания практики "+ strings[0]);

                absSender.sendMessage(answer);

                answer.setText( "1) Сформулируйте запрос, выводящий имена всех " +
                        "подчиненных King.\n");
                absSender.sendMessage(answer);

                answer.setText("2) Сформулируйте запрос, выводящий имена " +
                        "сотрудников работающих в одном отделе со Smith.");
                absSender.sendMessage(answer);

                answer.setText("3) Сформулируйте запрос, выводящий имена " +
                    "сотрудников, нанятых после Smith в его отдел.");
                absSender.sendMessage(answer);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }
}
