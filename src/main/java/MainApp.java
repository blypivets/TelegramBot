import bot.KotletkoBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by trm_cp on 3/18/17.
 */
public class MainApp {

    public static void main(String[] args) {

        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new KotletkoBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}