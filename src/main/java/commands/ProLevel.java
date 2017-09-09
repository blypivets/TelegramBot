package commands;

import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by user on 09.09.17.
 */
public class ProLevel extends BotCommand {


    public ProLevel() {
        super("prolevel", "Command with difficult tasks");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {


        Properties properties = new Properties();
        FileInputStream fis;

        try {

            fis = new FileInputStream("src/main/resources/descriptionCommand.properties");
            properties.load(fis);

            String description = new String(properties.getProperty("proLevelCommand").getBytes("ISO8859-1"));
            SendMessage answer = new SendMessage();
            answer.setChatId(chat.getId().toString());
            answer.setText(EmojiParser.parseToUnicode(description));
            absSender.sendMessage(answer);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
