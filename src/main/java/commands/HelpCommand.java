package commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.bots.commands.ICommandRegistry;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by Victor on 22.03.2017.
 */
public class HelpCommand extends BotCommand {

    //private static final String LOGTAG = "HELPCOMMAND";

    private final ICommandRegistry commandRegistry;

    public HelpCommand(ICommandRegistry commandRegistry) {
        super("help", "Get all the commands this bot provides");
        this.commandRegistry = commandRegistry;
    }

    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        //TODO: Create new SUPER PUPER help message.

        StringBuilder helpMessageBuilder = new StringBuilder("<b>Help</b>\n");
        helpMessageBuilder.append("These are the registered commands for this Bot:\n\n");

        helpMessageBuilder.append("/start - With this command you can start the bot.\n");
        helpMessageBuilder.append("/lecture - Get list of lectures or lecture specified by id\n");
        helpMessageBuilder.append("/practice - Get list of practice and tasks\n");
        helpMessageBuilder.append("/feedback - KotletkoBot welcomes your feedback\n");

        SendMessage helpMessage = new SendMessage();
        helpMessage.setChatId(chat.getId().toString());
        helpMessage.enableHtml(true);
        helpMessage.setText(helpMessageBuilder.toString());

        try {
            absSender.sendMessage(helpMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
