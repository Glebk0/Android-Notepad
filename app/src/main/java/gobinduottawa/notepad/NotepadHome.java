package gobinduottawa.notepad;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.SearchManager;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class NotepadHome extends AppCompatActivity
{
    private NotepadDB notepadDB;
    ArrayList<String> listItems=new ArrayList<String>();
    private ArrayAdapter<String> listAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED)
        {
            String[] permissions = { Manifest.permission.WRITE_EXTERNAL_STORAGE };
            //We don't have permission so prompt the user
            ActivityCompat.requestPermissions(this, permissions, 1);
        }
        setContentView(R.layout.activity_notepad_home);
        notepadDB=new NotepadDB(this);
        notepadDB.open();
        final ListView noteListView=(ListView) findViewById(R.id.notesList) ;




        //Gettnig all notes in DB into ListView
        List<NoteEntries> listNotes= notepadDB.getAllNotes();
        for (NoteEntries note:listNotes)
        {
            listItems.add(note.getTitle());
        }

        listAdapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, listItems);
        noteListView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();

        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Object o = noteListView.getItemAtPosition(position);
                String itemTitle=(String) o;
                Object[] thisNote=notepadDB.getThisNoteDetails(itemTitle);
                startActivity(new Intent(NotepadHome.this,ViewNote.class).putExtra("editableItem",thisNote));
            }
        });


        //SearchView Logic
        SearchView searchBarHome=(SearchView) findViewById(R.id.searchBar);
        searchBarHome.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                callSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                callSearch(newText);
                return true;
            }

            public void callSearch(String query)
            {
                ArrayList<String> searchItems=new ArrayList<String>();
                ArrayAdapter<String> listAdapter ;
                NotepadDB noteDB=new NotepadDB(getApplicationContext());
                searchItems= noteDB.getSearchItems(query);
                listAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, searchItems);
                noteListView.setAdapter(listAdapter);
                listAdapter.notifyDataSetChanged();
            }
        });

        //Floating Button Logic
        FloatingActionButton addButton = (FloatingActionButton)findViewById(R.id.add_notes);
        addButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(NotepadHome.this, AddNotes.class));
            }
        });
    }

    public void onResume()
    {
        super.onResume();
        setContentView(R.layout.activity_notepad_home);
        notepadDB=new NotepadDB(this);
        notepadDB.open();
        final ListView noteListView=(ListView) findViewById(R.id.notesList) ;


        //Gettnig all notes in DB into ListView
        List<NoteEntries> listNotes= notepadDB.getAllNotes();
        for (NoteEntries note:listNotes)
        {
            listItems.add(note.getTitle());
        }

        listAdapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, listItems);
        noteListView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();

        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Object o = noteListView.getItemAtPosition(position);
                String itemTitle=(String) o;
                Object[] thisNote=notepadDB.getThisNoteDetails(itemTitle);
                startActivity(new Intent(NotepadHome.this,ViewNote.class).putExtra("editableItem",thisNote));
            }
        });


        //SearchView Logic
        SearchView searchBarHome=(SearchView) findViewById(R.id.searchBar);
        searchBarHome.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                callSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                callSearch(newText);
                return true;
            }

            public void callSearch(String query)
            {
                ArrayList<String> searchItems=new ArrayList<String>();
                ArrayAdapter<String> listAdapter ;
                NotepadDB noteDB=new NotepadDB(getApplicationContext());
                searchItems= noteDB.getSearchItems(query);
                listAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, searchItems);
                noteListView.setAdapter(listAdapter);
                listAdapter.notifyDataSetChanged();
            }
        });

        //Floating Button Logic
        FloatingActionButton addButton = (FloatingActionButton)findViewById(R.id.add_notes);
        addButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(NotepadHome.this, AddNotes.class));
            }
        });

    }
}
