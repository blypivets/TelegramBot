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
public class FeedbackCommand extends BotCommand {

    public FeedbackCommand() { super("feedback", "KotletkoBot welcomes your feedback");}

    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        //TODO Realize a feedback command

        SendMessage answer = new SendMessage();
        answer.setChatId(chat.getId().toString());
        answer.setText("Sorry, this feature come soon");

        try {
            absSender.sendMessage(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
