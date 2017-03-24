package bot;

import commands.*;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.SortedMap;

/**
 * Created by trm_cp on 3/18/17.
 */
public class KotletkoBot extends TelegramLongPollingCommandBot {

//    private static final String LOGTAG = "KOTLETKOBOT";

    public KotletkoBot() {
        register(new LectureCommand(this));
        register(new StartCommand());
        register(new FeedbackCommand());
        register(new PracticeCommand());
        HelpCommand helpCommand = new HelpCommand(this);
        register(helpCommand);
    }


    public void processNonCommandUpdate(Update update) {

        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                SendMessage echoMessage = new SendMessage();
                echoMessage.setChatId(message.getChatId());
                echoMessage.setText("Дядьку, введи команду!!!\n");

                try {
                    sendMessage(echoMessage);
                } catch (TelegramApiException e) {
                    System.err.println("Victor, log doesn't work!!!");
                }
            }
        }

        if (update.hasCallbackQuery()) {
            String callback = update.getCallbackQuery().getData();

            switch (callback.split(" ")[0]) {
                case "lecture":
                    int lectureId = Integer.parseInt(callback.split(" ")[1]);

                    ArrayList<String> linksToSend = new ArrayList<>();
                    SortedMap<Integer, String> lectureNames = LectureCommand.getLectureNames();
                    SortedMap<Integer, ArrayList<String>> lectureLinks = LectureCommand.getLectureLinks();

                    for (String link : lectureLinks.get(lectureId)) {
                        linksToSend.add("<a href=\"" + link + "\">" + lectureNames.get(lectureId) + "</a>");
                    }

                    ArrayList<SendMessage> linksMessages = new ArrayList<>();
                    for (String link : linksToSend) {
                        SendMessage message = new SendMessage();
                        message.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
                        message.enableHtml(true);
                        message.setText(link);
                        linksMessages.add(message);
                    }

                    try {
                        for (SendMessage message : linksMessages) {
                            sendMessage(message);
                        }
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;


                default:

                    break;
            }


        }
    }

    public String getBotUsername() {
        return "KotletkoBot";
    }

    public String getBotToken() {
        return "377951187:AAH1KVvP69jTRyK_0GFwx9SjLEda02lSktc";
    }
}
