package storages.loaders;

import documents.Item;
import documents.Lecture;
import documents.Practice;
import storages.database.OneTimeConnectionToDB;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by user on 24.09.17.
 */
public class DocLoader implements DocumentInitializerInterface {

    private OneTimeConnectionToDB connection = null;

    public DocLoader(OneTimeConnectionToDB connection) {
        this.connection = connection;
    }

    @Override
    public Practice initializePractice(int numberOfPractice) {

        return new Practice();
    }

    @Override
    public Lecture initializeLecture(int numberOfLecture) {

        return new Lecture();
    }

    @Override
    public Item initializeAdditionalItem(int numberOfItem) {

        return new Item();
    }
}
