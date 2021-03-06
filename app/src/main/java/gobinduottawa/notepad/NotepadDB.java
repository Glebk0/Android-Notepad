package gobinduottawa.notepad;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gobind on 2016-10-03.
 */

public class NotepadDB  extends  SQLiteOpenHelper
{
    public static final String Column_Title="title";
    public static final String Column_notes="notes";
    public static final String Column_Id="id";


    private static final String Database_Name="notes.db";
    private static final String Datatable_Name="notes";
    private static final int Database_Version=1;
    SQLiteDatabase db;
    public static final String Tag= NotepadDB.class.getSimpleName();
    public static final String CreateDatabase="create table notes (id integer primary key autoincrement, title text not null, notes text not null, label text, bold text, italics text,underline text, imagepath text)";


    public NotepadDB(Context context)
    {
        super(context,Database_Name,null,Database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CreateDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS notes");
        onCreate(db);
    }

    public void open()
    {
        db = getWritableDatabase();
    }

    public void close(){
        db.close();
    }




    public ArrayList<String> getItemsOfThisLabel(String selectedLabel) {
        ArrayList<String> labelItems=new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + Datatable_Name + " where label= '"+ selectedLabel +"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst())
        {
            do
            {
                labelItems.add(cursor.getString(1));
            }
            while (cursor.moveToNext());
        }
        db.close();
        return labelItems;
    }

    public ArrayList<String> getLabels() {
        ArrayList<String> allLabels=new ArrayList<String>();
        String getLabelQuery="select * from labels";
        db=getReadableDatabase();
        Cursor cursor = db.rawQuery(getLabelQuery, null);
        if(cursor.moveToFirst())
        {
          do
          {
              allLabels.add(cursor.getString(1));
          }
          while(cursor.moveToNext());
        }
        else
        {
            allLabels.add("Select Label");
        }
        db.close();
        return allLabels;
    }

    public void addNote(NoteEntries note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Column_Title, note.getTitle());
        values.put(Column_notes, note.getNotes());
        Log.d("Query",CreateDatabase);
        Log.d("Details",Database_Name +" " +Datatable_Name+" "+Column_Title+" "+Column_notes+" "+Column_Id);
        db.insert(Datatable_Name, null, values);
        db.close(); // Closing database connection
    }

    public NoteEntries getNote(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Datatable_Name, new String[] { Column_Id,
                        Column_Title, Column_notes}, Column_Id + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        NoteEntries note = new NoteEntries(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        db.close();
        return note;
    }

    public String[] getThisNoteDetails(String noteTitle) {
        String[] thisNote=new String[8];
        String selectQuery = "SELECT  * FROM " + Datatable_Name + " where title='"+ noteTitle +"'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst())
        {
            thisNote[0]=(cursor.getString(0));
            thisNote[1]=(cursor.getString(1));
            thisNote[2]=(cursor.getString(2));


        }
        cursor.close();
        db.close();
        return thisNote;
    }

    public List<NoteEntries> getAllNotes() {
        List<NoteEntries> noteList = new ArrayList<NoteEntries>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + Datatable_Name;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                NoteEntries note = new NoteEntries();
                note.setID(Integer.parseInt(cursor.getString(0)));
                note.setTitle(cursor.getString(1));
                note.setNotes(cursor.getString(2));
                noteList.add(note);
            } while (cursor.moveToNext());
        }
        db.close();
        return noteList;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + Datatable_Name;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        db.close();
        return cursor.getCount();
    }

    public ArrayList<String> getSearchItems(String query) {
        ArrayList<String> searchItems=new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + Datatable_Name + " where title like '%"+ query +"%' OR notes like '%" +query+"%'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst())
        {
            do
            {
                searchItems.add(cursor.getString(1));
            }
            while (cursor.moveToNext());
        }
        db.close();
        return searchItems;
    }

    public void updateNote(NoteEntries note, String rowID) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Column_Title, note.getTitle());
        values.put(Column_notes, note.getNotes());
        db.update(Datatable_Name, values, Column_Id+ "= "+ rowID,null);
        db.close();
    }

    public void deleteNote(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        String deleteQuery="Delete from notes where title='"+title+"'";
        db.execSQL(deleteQuery);
        db.close();
    }
}

