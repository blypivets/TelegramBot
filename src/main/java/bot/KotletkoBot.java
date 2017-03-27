package bot;

import com.vdurmont.emoji.EmojiParser;
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

//    private static final String LOGTAG = "KOTLETKOBOT";

    public KotletkoBot() {
        register(new LectureCommand());
        register(new StartCommand());
        register(new FeedbackCommand());
        register(new PracticeCommand());
        HelpCommand helpCommand = new HelpCommand(this);
        register(helpCommand);
    }

    public void processNonCommandUpdate(Update update) {

        ArrayList<String> helloList = new ArrayList<>();

        helloList.add("Hi!");
        helloList.add("Hello!");
        helloList.add("Hail!");
        helloList.add("Cheer!");
        helloList.add(EmojiParser.parseToUnicode("Don't worry be happy:smile::smile::smile:"));
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

                if (EmojiParser.parseToUnicode(message.getText()).equals(EmojiParser.parseToUnicode(":muscle:"))){
                    echoMessage.setText("Воу воу полегче!");
                }else if (EmojiParser.parseToUnicode(message.getText()).equals(EmojiParser.parseToUnicode(":man_with_turban:"))){
                    echoMessage.setText("@b_Lip");
                }else if (EmojiParser.parseToUnicode(message.getText()).equals(EmojiParser.parseToUnicode(":baby:"))){
                    echoMessage.setText("@vshurig");
                }else {
                    echoMessage.setText(helloList.get(random.nextInt(9))+"\n");
                }
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

                    List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
                    List<InlineKeyboardButton> row1 = new ArrayList<>();

                    InlineKeyboardButton button1 = new InlineKeyboardButton();
                    button1.setText("Следующее");
                    button1.setCallbackData("next " + practiceId + " 1");

                    row1.add(button1);
                    keyboard.add(row1);
                    markup.setKeyboard(keyboard);

                    SortedMap<Integer, ArrayList<String>> practice = PracticeCommand.getPractice();

                    SendMessage echoMessage = new SendMessage();
                    echoMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    echoMessage.setText(practice.get(practiceId).get(0));
                    echoMessage.setReplyMarkup(markup);
                    try {
                        sendMessage(echoMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "next":

                  /*  String[] callbackArr = callback.split(" ");

                    InlineKeyboardMarkup currentMarcup = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> currentKeyboard = new ArrayList<>();
                    List<InlineKeyboardButton> currentRow = new ArrayList<>();
                    InlineKeyboardButton currentButton = new InlineKeyboardButton();
                    currentButton.setText("Следующее");
                    currentButton.setCallbackData(callback);
                    currentRow.add(currentButton);
                    currentKeyboard.add(currentRow);
                    currentMarcup.setKeyboard(currentKeyboard);

                    SortedMap<Integer, ArrayList<String>> currentPractice = PracticeCommand.getPractice();
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    editMessageText.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
                    editMessageText.setText(currentPractice.get(Integer.parseInt(callbackArr[1])).get(Integer.parseInt(callbackArr[2]) - 1));
                    editMessageText.setReplyMarkup(currentMarcup);

                    try {
                        editMessageText(editMessageText);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }*/

                    int nextPracticeId = Integer.parseInt(callback.split(" ")[1]);
                    int taskId = Integer.parseInt(callback.split(" ")[2]);
                    int tmpTask = taskId+1;

                    InlineKeyboardMarkup nextMarkup = new InlineKeyboardMarkup();

                    List<List<InlineKeyboardButton>> nextKeyboard = new ArrayList<>();
                    List<InlineKeyboardButton> nextRow1 = new ArrayList<>();

                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("Следующее");
                    button2.setCallbackData("next " + nextPracticeId + " " + tmpTask);

                    nextRow1.add(button2);
                    nextKeyboard.add(nextRow1);
                    nextMarkup.setKeyboard(nextKeyboard);

                    SortedMap<Integer, ArrayList<String>> nextPractice = PracticeCommand.getPractice();

                    SendMessage nextEchoMessage = new SendMessage();
                    nextEchoMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    nextEchoMessage.setText(nextPractice.get(nextPracticeId).get(taskId));
                    nextEchoMessage.setReplyMarkup(nextMarkup);
                    try {
                        sendMessage(nextEchoMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
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