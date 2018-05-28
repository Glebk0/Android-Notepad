package gobinduottawa.notepad;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EditNotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_notes);
        final String[] editableItem=getIntent().getStringArrayExtra("editableItem");
        final EditText titleText=(EditText)findViewById(R.id.titleView);
        final EditText notesText=(EditText)findViewById(R.id.notesText) ;
        final Spinner labelSpinner=(Spinner) findViewById(R.id.labelEdit);

        final String rowID=editableItem[0].toString();
        titleText.setText(editableItem[1]);
        notesText.setText(editableItem[2]);









        //Delete Button Logic
        ImageButton deleteNote=(ImageButton) findViewById(R.id.deleteNoteEdit) ;
        deleteNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                NotepadDB db=new NotepadDB(getApplicationContext());
                db.deleteNote(editableItem[1].toString());
                startActivity(new Intent(EditNotes.this, NotepadHome.class));
                Toast.makeText(getBaseContext(), "Note Deleted!!", Toast.LENGTH_SHORT).show();

            }
        });

        //Email Button Logic
        ImageButton emailNote=(ImageButton) findViewById(R.id.sendAsEmailEdit) ;
        emailNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "gobindnitj@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, titleText.getText());
                intent.putExtra(Intent.EXTRA_TEXT, notesText.getText());

                startActivity(Intent.createChooser(intent, "Send Email"));

            }
        });


        //Save Button Logic
        ImageButton saveChanges=(ImageButton) findViewById(R.id.saveChangesEdit) ;
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
                    EditText editedNote=(EditText) findViewById(R.id.notesText) ;
                    NoteEntries editNote=new NoteEntries(titleText.getText().toString(),editedNote.getText().toString());

                    NotepadDB db=new NotepadDB(getApplicationContext());
                    db.updateNote(editNote, rowID);

                    Toast.makeText(getBaseContext(), "Changes Saved!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(EditNotes.this, NotepadHome.class));
                }

            }
        });
    }
}
