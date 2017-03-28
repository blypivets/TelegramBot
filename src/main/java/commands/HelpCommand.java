package commands;

import com.vdurmont.emoji.EmojiParser;
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

        StringBuilder helpMessageBuilder = new StringBuilder();
        helpMessageBuilder.append(EmojiParser.parseToUnicode("Вот список команд, которые помогут тебе управлять ботом:\n\n"));

        helpMessageBuilder.append(EmojiParser.parseToUnicode("/start - Начать использование бота:rocket:\n\n"));
        helpMessageBuilder.append( EmojiParser.parseToUnicode("/init - Скачать необходимые файлы для установки и настройки БД, создания таблиц :arrow_down::white_check_mark:\n\n"));
        helpMessageBuilder.append( EmojiParser.parseToUnicode("/lecture - Здесь ты можешь скачать лекции:book::mag:\n\n"));
        helpMessageBuilder.append( EmojiParser.parseToUnicode("/practice - Получить задания по интересующей тебя практике:scream_cat::fire:\n\n"));
        helpMessageBuilder.append(EmojiParser.parseToUnicode("/prolevel - Скучно и одиноко? Сделал все задания? Тогда тебе сюда, смельчак:hugging::nerdy:\n\n "));
        helpMessageBuilder.append(EmojiParser.parseToUnicode("/feedback - Возможность высказаться:loudspeaker::phone::mailbox_with_mail:\n "));

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