package storages.loaders;

import documents.Item;
import documents.Lecture;
import documents.Practice;
import storages.database.BotDatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by user on 24.09.17.
 */

public class DocLoader implements DocumentInitializerInterface {

    private BotDatabaseConnection connection = null;

    public DocLoader(BotDatabaseConnection connection) {
        this.connection = connection;
    }

    @Override
    public Practice initializePractice(int numberOfPractice) {

        Practice tempPractice = new Practice();

        String taskLinks[] = new String[2];
        String telegraphTaskLink = "";
        int i = 0;


        try {
            ResultSet resultSetOfLinks = connection.runSqlQuery("SELECT ptk.partno, ptk.task_link FROM practices p\n" +
                                   "JOIN practice_tasks ptk USING (practice_id)\n" +
                                   "WHERE p.practiceno =" + numberOfPractice + "\n" +
                                   "ORDER BY ptk.partno;");

            ResultSet resultSetOfTelegraphLinks = connection.runSqlQuery("SELECT ptl.task_link FROM practices p\n" +
                                    "JOIN practice_telegraph ptl USING (practice_id)\n" +
                                    "WHERE p.practiceno =" + numberOfPractice + ";");


            while (resultSetOfLinks.next()){
                taskLinks[i] = resultSetOfLinks.getString("task_link");
                i++;
            }

            while (resultSetOfTelegraphLinks.next()){
                telegraphTaskLink = resultSetOfTelegraphLinks.getString("task_link");
            }

            tempPractice.setTaskLinks(taskLinks);
            tempPractice.setTelegraphTaskLink(telegraphTaskLink);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempPractice;
    }

    @Override
    public Lecture initializeLecture(int numberOfLecture) {

        return new Lecture();
    }

    @Override
    public Item initializeAdditionalItem(int numberOfItem) {

        return new Item();
    }

    @Override
    public int getCountOfPractices() {

        int countOfPractices = 0;

        try {
            ResultSet resultSet = connection.runSqlQuery("SELECT COUNT(practiceno) FROM practices;");

            while (resultSet.next()){

                countOfPractices = resultSet.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countOfPractices;
    }
}
