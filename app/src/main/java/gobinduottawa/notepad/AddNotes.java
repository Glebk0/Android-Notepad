package gobinduottawa.notepad;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class AddNotes extends AppCompatActivity {
    private static int RESULT_LOAD_IMAGE = 1;
    private String imageDecode="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        final EditText notesText=(EditText)findViewById(R.id.notesText) ;
        final EditText titleText=(EditText)findViewById(R.id.titleView);






        /*ToggleButton boldButton1= (ToggleButton)findViewById(R.id.bold1);
        ToggleButton italicsButton1= (ToggleButton)findViewById(R.id.italics1);
        ToggleButton underlineButton1= (ToggleButton)findViewById(R.id.underline1);
        italicsButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    buttonView.setBackgroundColor(Color.parseColor("#FF4052B5"));
                    notesText.setTypeface(null,Typeface.BOLD);
                }
                else buttonView.setBackgroundColor(Color.parseColor("#FFA5B0EC"));

            }
        });

        underlineButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                    buttonView.setBackgroundColor(Color.parseColor("#FF4052B5"));
                else buttonView.setBackgroundColor(Color.parseColor("#FFA5B0EC"));
            }
        });

        boldButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                    buttonView.setBackgroundColor(Color.parseColor("#FF4052B5"));
                else buttonView.setBackgroundColor(Color.parseColor("#FFA5B0EC"));
            }
        });*/







        //Save Button Logic
        ImageButton saveChanges=(ImageButton) findViewById(R.id.saveChangesAdd) ;
        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(titleText.getText().toString().isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Please Enter Title" , Toast.LENGTH_SHORT ).show();
                }
                else if(notesText.getText().toString().isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Please Add Some Notes" , Toast.LENGTH_SHORT ).show();
                }
                else
                {
                    NoteEntries newNote=new NoteEntries(titleText.getText().toString(),notesText.getText().toString());
                    NotepadDB db=new NotepadDB(getApplicationContext());
                    db.addNote(newNote);
                    Toast.makeText(getBaseContext(), "Note Saved!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddNotes.this, NotepadHome.class));
                }

            }
        });


    }




}
