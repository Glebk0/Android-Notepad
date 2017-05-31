package gobinduottawa.notepad;

/**
 * Created by Gobind on 2016-10-06.
 */

public class NoteEntries {


    //private variables
    int _id;
    String _title;
    String _notes;
    String _label;
    String _bold;
    String _italics;
    String _underline;
    String _imagepath;

    public NoteEntries() {}

    public NoteEntries(int id, String title, String notes, String Label,String bold, String italics, String underline, String imagepath) {
        this._id = id;
        this._title = title;
        this._notes = notes;
        this._label=Label;
        this._bold=bold;
        this._italics=italics;
        this._underline=underline;
        this._imagepath=imagepath;
    }

    // constructor
    public NoteEntries(String title, String notes, String label,String bold, String italics, String underline, String imagepath) {
        this._title = title;
        this._notes = notes;
        this._label=label;
        this._bold=bold;
        this._italics=italics;
        this._underline=underline;
        this._imagepath=imagepath;
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
    }

    public String getLabel() {
        return this._label;
    }


    public void setLabel(String label) {
        this._label = label;
    }
    public String getBold() {
        return this._bold;
    }


    public void setBold(String bold) {
        this._bold = bold;
    }
    public String getItalics() {
        return this._italics;
    }


    public void setItalics(String italics) {
        this._italics = italics;
    }

    public String getUnderline() {
        return this._underline;
    }

    public void setUnderline(String underline) {
        this._label = underline;
    }

    public String getImagePath() {
        return this._imagepath;
    }

    public void setImagePath(String imagepath) {
        this._imagepath = imagepath;
    }


}