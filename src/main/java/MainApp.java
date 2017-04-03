import bot.KotletkoBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by trm_cp on 3/18/17.
 */
public class MainApp {

    public static void main(String[] args) throws IOException {

        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();

        ServerSocket ss = new ServerSocket(2234);
        Socket accept = ss.accept();

        try {
            botsApi.registerBot(new KotletkoBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}