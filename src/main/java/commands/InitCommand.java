package commands;

import com.vdurmont.emoji.EmojiParser;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by user on 10.09.17.
 */
public class InitCommand extends BotCommand {
    public InitCommand() {
        super("init", "With this command you can watch lectures");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        Properties properties = new Properties();
        FileInputStream fis;

        try {

            fis = new FileInputStream("src/main/resources/descriptionCommand.properties");
            properties.load(fis);

            String description = new String(properties.getProperty("initCommand").getBytes("ISO8859-1"));
            SendMessage answer = new SendMessage();
            answer.setChatId(chat.getId().toString());
            answer.setReplyMarkup(addButtons());
            answer.setText(description);

            absSender.sendMessage(answer);
            fis.close();

        } catch (TelegramApiException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InlineKeyboardMarkup addButtons(){

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        List<InlineKeyboardButton> row4 = new ArrayList<>();
        List<InlineKeyboardButton> row5 = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        InlineKeyboardButton button5 = new InlineKeyboardButton();

        button1.setText("Инструкция по установке БД");
        button1.setUrl("https://drive.google.com/open?id=0B7e8YlQA9NpyUkNmUGZpcFREdG8");
        button2.setText("init_script.sql");
        button2.setUrl("https://drive.google.com/open?id=0B7e8YlQA9NpyY0pBRE5zZnZKdU0");
        button3.setText("sql.bat");
        button3.setUrl("https://drive.google.com/open?id=0B7e8YlQA9NpyS2lZQnVNenExbFE");
        button4.setText("Типы данных в СУБД Oracle");
        button4.setUrl("https://drive.google.com/open?id=0B7e8YlQA9NpyUVh3dmEzWUFRdE0");
        button5.setText("Case Studio");
        button5.setUrl("https://drive.google.com/open?id=0B7e8YlQA9NpyLTFqSGF6MlQ1TnM");

        row1.add(button1);
        row2.add(button2);
        row3.add(button3);
        row4.add(button4);
        row5.add(button5);

        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);
        keyboard.add(row5);

        markup.setKeyboard(keyboard);

        return markup;
    }
}
