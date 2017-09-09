package bot;

import commands.*;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.*;

public class KotletkoBot extends TelegramLongPollingCommandBot {

    public KotletkoBot() {
        register(new LectureCommand());
        register(new StartCommand());
        register(new FeedbackCommand());
        register(new PracticeCommand());
        register(new ProLevel());
        HelpCommand helpCommand = new HelpCommand(this);
        register(helpCommand);
    }

    public void processNonCommandUpdate(Update update) {

        ArrayList<String> helloList = new ArrayList<>();

        helloList.add("Hi!");
        helloList.add("Hello!");
        helloList.add("Hail!");
        helloList.add("Cheer!");
        helloList.add("Cheer!");
        helloList.add("Hola");
        helloList.add("Salut!");
        helloList.add("Ciao!");
        helloList.add("Buenos dias!");

        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                SendMessage echoMessage = new SendMessage();
                echoMessage.setChatId(message.getChatId());
                Random random = new Random();

                echoMessage.setText(helloList.get(random.nextInt(7))+"\n");

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

                    ArrayList<EditMessageText> linksMessages = new ArrayList<>();
                    for (String link : linksToSend) {

                        EditMessageText editMessage = new EditMessageText();
                        editMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                        editMessage.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
                        editMessage.enableHtml(true);
                        editMessage.setText(link);
                        linksMessages.add(editMessage);
                    }
                    try {
                        for (EditMessageText messageText : linksMessages) {
                            editMessageText(messageText);
                        }
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                    break;

                case "practice":

                    int practiceId = Integer.parseInt(callback.split(" ")[1]);
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

                    SortedMap<Integer, String> practiceInURL = PracticeCommand.getPracticeURl();
                    SortedMap<Integer, ArrayList<String>> practiceInPDF = PracticeCommand.getPracticePDF();

                    List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
                    List<InlineKeyboardButton> row = new ArrayList<>();

                    if (practiceInPDF.get(practiceId).size() > 1) {
                        InlineKeyboardButton button1 = new InlineKeyboardButton();
                        button1.setText("Скачать PDF ч.1");
                        button1.setUrl(practiceInPDF.get(practiceId).get(0));
                        InlineKeyboardButton button2 = new InlineKeyboardButton();
                        button2.setText("Скачать PDF ч.2");
                        button2.setUrl(practiceInPDF.get(practiceId).get(1));
                        row.add(button1);
                        row.add(button2);
                        keyboard.add(row);
                        markup.setKeyboard(keyboard);

                        SendMessage echoMessage = new SendMessage();
                        echoMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                        echoMessage.setText(practiceInURL.get(practiceId));
                        echoMessage.setReplyMarkup(markup);
                        try {
                            sendMessage(echoMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    } else {
                        InlineKeyboardButton button1 = new InlineKeyboardButton();
                        button1.setText("Скачать в PDF");
                        button1.setUrl(practiceInPDF.get(practiceId).get(0));
                        row.add(button1);
                        keyboard.add(row);
                        markup.setKeyboard(keyboard);

                        SendMessage echoMessage = new SendMessage();
                        echoMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                        echoMessage.setText(practiceInURL.get(practiceId));
                        echoMessage.setReplyMarkup(markup);
                        try {
                            sendMessage(echoMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                default:
            }
        }
    }

    public String getBotUsername() {
        return "EagleBot";
    }

    public String getBotToken() {
        return System.getenv("PRODUCTION_BOT_TOKEN");
    }
}