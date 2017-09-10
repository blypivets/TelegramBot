package commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;

import java.io.FileInputStream;
import java.util.*;

public class PracticeCommand extends BotCommand {
    public PracticeCommand() {super("practice", "practic.." );
    }

    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        Properties properties = new Properties();
        FileInputStream fis;

        try {

            fis = new FileInputStream("src/main/resources/descriptionCommand.properties");
            properties.load(fis);

            String description = new String(properties.getProperty("practiceCommand").getBytes("ISO8859-1"));
            SendMessage message = new SendMessage();
            message.setChatId(chat.getId());
            message.setReplyMarkup(addButtons());
            message.setText(description);

            absSender.sendMessage(message);
            fis.close();

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static SortedMap<Integer, ArrayList<String>> getPracticePDF () {

        SortedMap<Integer,ArrayList<String>> practiceLinks = new TreeMap<>();

        practiceLinks.put(1, new ArrayList<String>());
        practiceLinks.get(1).add("https://drive.google.com/open?id=0B7e8YlQA9NpybmtwZzhXcnc0U2c");
        practiceLinks.get(1).add("https://drive.google.com/open?id=0B7e8YlQA9NpyX3llam0xaG1NaVE");

        practiceLinks.put(2, new ArrayList<String>());
        practiceLinks.get(2).add("https://drive.google.com/open?id=0B7e8YlQA9NpyNGhvMmFoRGctVzA");

        practiceLinks.put(3, new ArrayList<String>());
        practiceLinks.get(3).add("https://drive.google.com/open?id=0B7e8YlQA9NpycjRoVjNOemxNakU");

        practiceLinks.put(4, new ArrayList<String>());
        practiceLinks.get(4).add("https://drive.google.com/open?id=0B7e8YlQA9Npyc2NnZ3hIVnRvQkE");

        practiceLinks.put(5, new ArrayList<String>());
        practiceLinks.get(5).add("https://drive.google.com/open?id=0B7e8YlQA9NpyTmdpLWZ3UkFnVHc");

        practiceLinks.put(6, new ArrayList<String>());
        practiceLinks.get(6).add("https://drive.google.com/open?id=0B7e8YlQA9Npya2lTV1lFUUVFMFU");

        practiceLinks.put(7, new ArrayList<String>());
        practiceLinks.get(7).add("https://drive.google.com/open?id=0B7e8YlQA9NpyTlFYdGcwYVM0NlE");
        practiceLinks.get(7).add("https://drive.google.com/open?id=0B7e8YlQA9NpyQkJqbXB4VDE3NW8");

        practiceLinks.put(8, new ArrayList<String>());
        practiceLinks.get(8).add("https://drive.google.com/open?id=0B7e8YlQA9NpyRFphclhTQ3ZfdVE");

        practiceLinks.put(9, new ArrayList<String>());
        practiceLinks.get(9).add("https://drive.google.com/open?id=0B7e8YlQA9NpybDVMRy1wdWhFWVU");

        practiceLinks.put(10, new ArrayList<String>());
        practiceLinks.get(10).add("https://drive.google.com/open?id=0B7e8YlQA9NpybENmZUdsR0I1alE");

        practiceLinks.put(11, new ArrayList<String>());
        practiceLinks.get(11).add("https://drive.google.com/open?id=0B7e8YlQA9NpyZGpXbF9TMzZRZDA");

        practiceLinks.put(12, new ArrayList<String>());
        practiceLinks.get(12).add("https://drive.google.com/open?id=0B7e8YlQA9NpyX0IyYjFUMTFzQms");

        practiceLinks.put(13, new ArrayList<String>());
        practiceLinks.get(13).add("https://drive.google.com/open?id=0B7e8YlQA9NpyaU5rWlQwQnBiSHM");

        practiceLinks.put(14, new ArrayList<String>());
        practiceLinks.get(14).add("https://drive.google.com/open?id=0B7e8YlQA9NpybGNxeGhlVWg4cFE");

        practiceLinks.put(15, new ArrayList<String>());
        practiceLinks.get(15).add("https://drive.google.com/open?id=0B7e8YlQA9NpyWGVXUkNOVWlWUGs");

        practiceLinks.put(16, new ArrayList<String>());
        practiceLinks.get(16).add("https://drive.google.com/open?id=0B7e8YlQA9NpycXhmaUlDc3FmWXc");

        return  practiceLinks;
    }

    public static SortedMap<Integer, String> getPracticeURl () {
        SortedMap<Integer,String> practiceLinks = new TreeMap<>();

        practiceLinks.put(1,"http://telegra.ph/Praktika-1--SQL-sozdanie-tablic-Ispolzovanie-SQLplus-06-25");
        practiceLinks.put(2,"http://telegra.ph/Praktika-2--Ogranichenie-v-rezultatah-zaprosa-06-23");
        practiceLinks.put(3,"http://telegra.ph/Praktika-3--Funkcii-odnoj-stroki-06-23");
        practiceLinks.put(4,"http://telegra.ph/Praktika-4--Ispolzovanie-podzaprosov-06-23");
        practiceLinks.put(5,"http://telegra.ph/Praktika-5--Insert-Update-Delete-06-23");
        practiceLinks.put(6,"http://telegra.ph/Praktika-6--Zaprosy-k-neskolkim-tablicam-06-23");
        practiceLinks.put(7,"http://telegra.ph/Praktika-7--Ispolzovanie-Join-06-25");
        practiceLinks.put(8,"http://telegra.ph/Praktika-8--Operacii-nad-mnozhestvami-06-23");
        practiceLinks.put(9,"http://telegra.ph/Praktika-9--Agregatnye-funkcii-06-25");
        practiceLinks.put(10,"http://telegra.ph/Praktika-10--Semi-unique-data-06-25");
        practiceLinks.put(11,"http://telegra.ph/Praktika-11--Ierarhicheskie-zaprosy-06-25");
        practiceLinks.put(12,"http://telegra.ph/Praktika-12--Metamodel-BD-06-25");
        practiceLinks.put(13,"http://telegra.ph/Praktika-13--Upravlenie-pravami-polzovatelej-06-25");
        practiceLinks.put(14,"http://telegra.ph/Praktika-14--Tranzakcii-06-25");
        practiceLinks.put(15,"http://telegra.ph/Praktika-15--Ispolzovanie-triggerov-06-25");
        practiceLinks.put(16,"http://telegra.ph/Praktika-16--Indeksy-06-25");

        return  practiceLinks;
    }

    public static InlineKeyboardMarkup addButtons(){

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        List<InlineKeyboardButton> row4 = new ArrayList<>();
        List<InlineKeyboardButton> row5 = new ArrayList<>();
        List<InlineKeyboardButton> row6 = new ArrayList<>();
        List<InlineKeyboardButton> row7 = new ArrayList<>();
        List<InlineKeyboardButton> row8 = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Практика 1");
        button1.setCallbackData("practice 1");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Практика 2");
        button2.setCallbackData("practice 2");
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("Практика 3");
        button3.setCallbackData("practice 3");
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setText("Практика 4");
        button4.setCallbackData("practice 4");
        InlineKeyboardButton button5 = new InlineKeyboardButton();
        button5.setText("Практика 5");
        button5.setCallbackData("practice 5");
        InlineKeyboardButton button6 = new InlineKeyboardButton();
        button6.setText("Практика 6");
        button6.setCallbackData("practice 6");
        InlineKeyboardButton button7 = new InlineKeyboardButton();
        button7.setText("Практика 7");
        button7.setCallbackData("practice 7");
        InlineKeyboardButton button8 = new InlineKeyboardButton();
        button8.setText("Практика 8");
        button8.setCallbackData("practice 8");
        InlineKeyboardButton button9 = new InlineKeyboardButton();
        button9.setText("Практика 9");
        button9.setCallbackData("practice 9");
        InlineKeyboardButton button10 = new InlineKeyboardButton();
        button10.setText("Практика 10");
        button10.setCallbackData("practice 10");
        InlineKeyboardButton button11 = new InlineKeyboardButton();
        button11.setText("Практика 11");
        button11.setCallbackData("practice 11");
        InlineKeyboardButton button12 = new InlineKeyboardButton();
        button12.setText("Практика 12");
        button12.setCallbackData("practice 12");
        InlineKeyboardButton button13 = new InlineKeyboardButton();
        button13.setText("Практика 13");
        button13.setCallbackData("practice 13");
        InlineKeyboardButton button14 = new InlineKeyboardButton();
        button14.setText("Практика 14");
        button14.setCallbackData("practice 14");
        InlineKeyboardButton button15 = new InlineKeyboardButton();
        button15.setText("Практика 15");
        button15.setCallbackData("practice 15");
        InlineKeyboardButton button16 = new InlineKeyboardButton();
        button16.setText("Практика 16");
        button16.setCallbackData("practice 16");

        row1.add(button1);
        row1.add(button2);
        row2.add(button3);
        row2.add(button4);
        row3.add(button5);
        row3.add(button6);
        row4.add(button7);
        row4.add(button8);
        row5.add(button9);
        row5.add(button10);
        row6.add(button11);
        row6.add(button12);
        row7.add(button13);
        row7.add(button14);
        row8.add(button15);
        row8.add(button16);

        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);
        keyboard.add(row5);
        keyboard.add(row6);
        keyboard.add(row7);
        keyboard.add(row8);

        markup.setKeyboard(keyboard);

        return markup;
    }
}