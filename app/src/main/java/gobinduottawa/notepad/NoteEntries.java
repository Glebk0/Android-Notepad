package gobinduottawa.notepad;

/**
 * Created by Gobind on 2016-10-06.
 */

public class NoteEntries {


    //private variables
    int _id;
    String _title;
    String _notes;

    public NoteEntries() {}

    public NoteEntries(int id, String title, String notes) {
        this._id = id;
        this._title = title;
        this._notes = notes;

    }

    // constructor
    public NoteEntries(String title, String notes) {
        this._title = title;
        this._notes = notes;

    }


    public int getID() {
        return this._id;
    }


    public void setID(int id) {
        this._id = id;
    }


    public String getTitle() {
        return this._title;
    }

    // setting name
    public void setTitle(String title) {
        this._title = title;
    }


    public String getNotes() {
        return this._notes;
    }


    public void setNotes(String notes) {
        this._notes = notes;
    }}


