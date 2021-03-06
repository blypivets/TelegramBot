package bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import zhdyn.ZdynThread;

import java.io.IOException;

/**
 * Created by trm_cp on 3/18/17.
 */
public class MainApp {

    public static void main(String[] args) throws IOException {

        ZdynThread zdynThread = new ZdynThread();
        zdynThread.start();

        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new KotletkoBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}