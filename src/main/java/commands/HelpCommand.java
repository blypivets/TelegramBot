package commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.bots.commands.ICommandRegistry;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class HelpCommand extends BotCommand {

    private final ICommandRegistry commandRegistry;

    public HelpCommand(ICommandRegistry commandRegistry) {
        super("help", "Get all the commands this bot provides");
        this.commandRegistry = commandRegistry;
    }

    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        Properties properties = new Properties();
        FileInputStream fis;

        try {

            fis = new FileInputStream("src/main/resources/descriptionCommand.properties");
            properties.load(fis);
            String description = new String(properties.getProperty("helpCommand").getBytes("ISO8859-1"));

            SendMessage helpMessage = new SendMessage();
            helpMessage.setChatId(chat.getId().toString());
            helpMessage.enableHtml(true);
            helpMessage.setText(description);

            absSender.sendMessage(helpMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}