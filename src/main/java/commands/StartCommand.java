package commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by Victor on 22.03.2017.
 */
public class StartCommand extends BotCommand {

   // public static final String LOGTAG = "STARTCOMMAND";

    public StartCommand() {super("start", "With this command you can start the Bot");}

    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        StringBuilder messageBuilder = new StringBuilder();

        String userName = user.getFirstName() + " " + user.getLastName();
        messageBuilder.append("Welcome ").append(userName).append("\n");
        messageBuilder.append("This bot can help you with learning SQL. ");
        messageBuilder.append("Execute /help to get more information.");

        SendMessage answer = new SendMessage();
        answer.setChatId(chat.getId().toString());
        answer.setText(messageBuilder.toString());

        try {
            absSender.sendMessage(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
