package storages.loaders;

import documents.Item;
import documents.Lecture;
import documents.Practice;

import java.sql.ResultSet;

public interface DocumentInitializerInterface  {

    public Practice initializePractice (int numberOfPractice);

    public Lecture initializeLecture (int numberOfLecture);

    public Item initializeAdditionalItem (int numberOfItem);
}
