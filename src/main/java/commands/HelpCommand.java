package commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.bots.commands.ICommandRegistry;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class HelpCommand extends BotCommand {

    private final ICommandRegistry commandRegistry;

    public HelpCommand(ICommandRegistry commandRegistry) {
        super("help", "Get all the commands this bot provides");
        this.commandRegistry = commandRegistry;
    }

    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        //TODO: Create new SUPER PUPER help message.

        StringBuilder helpMessageBuilder = new StringBuilder("<b>Help</b>\n");
        char[] smile = Character.toChars(0x1F601);
        helpMessageBuilder.append("\u263A");
        helpMessageBuilder.append(smile);
        helpMessageBuilder.append("Эти команды помогут тебе в управлении ботом:\n\n");

        helpMessageBuilder.append("/start - Начать использовать бота.\n\n");
        helpMessageBuilder.append("/init - Здесь доступны все файлы и инструкции необходимые тебе для установки БД и выполнения практик.\n\n");
        helpMessageBuilder.append("/lecture - Вызвав эту команду ты получишь список лекций, " +
                "которые доступны для изучения и скачивания в формате PDF.\n\n");
        helpMessageBuilder.append("/practice - Вызвав эту команду ты получишь список практических заданий " +
                "которые нужно выполнить, также есть возможность загрузки в формате PDF\n\n");
        helpMessageBuilder.append("/feedback - Хочешь связаться с нами? Тогда тебе сюда.\n\n");

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
