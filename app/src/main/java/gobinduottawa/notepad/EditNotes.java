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
        ImageView imageNotes=(ImageView) findViewById(R.id.imageViewEdit);
        final String rowID=editableItem[0].toString();
        titleText.setText(editableItem[1]);
        notesText.setText(editableItem[2]);
        if(!editableItem[7].isEmpty())
        {
            imageNotes.setImageBitmap(BitmapFactory.decodeFile(editableItem[7]));
        }

        final String[] boldFlag = {editableItem[4]};
        final String[] italicsFlag={editableItem[5]};
        final String[] underlineFlag={editableItem[6]};

        //Bold Italics Underline Switch Logic
        final Switch boldSwitch=(Switch) findViewById(R.id.bold);
        final Switch italicsSwitch=(Switch) findViewById(R.id.italics);
        final Switch underlineSwitch=(Switch) findViewById(R.id.underline);


        if(boldFlag[0].equals("True"))
        {
            boldSwitch.setChecked(true);
        }
        if(italicsFlag[0].equals("True"))
        {
            italicsSwitch.setChecked(true);
        }
        if(underlineFlag[0].equals("True"))
        {
            underlineSwitch.setChecked(true);
        }

        //Logic for all switch possibilities
        //region
        if(boldSwitch.isChecked() && italicsSwitch.isChecked() && underlineSwitch.isChecked())
        {
            boldFlag[0] ="True";
            italicsFlag[0]="True";
            underlineFlag[0]="True";
            notesText.setTypeface(null, Typeface.BOLD_ITALIC);
            notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        }
        if(!boldSwitch.isChecked() && !italicsSwitch.isChecked() && !underlineSwitch.isChecked())
        {
            boldFlag[0] ="False";
            italicsFlag[0]="False";
            underlineFlag[0]="False";
            notesText.setBackgroundDrawable(null);
            notesText.setTypeface(null, Typeface.NORMAL);
        }
        if(boldSwitch.isChecked() && !italicsSwitch.isChecked() && !underlineSwitch.isChecked())
        {
            boldFlag[0] ="True";
            italicsFlag[0]="False";
            underlineFlag[0]="False";
            notesText.setBackgroundDrawable(null);
            notesText.setTypeface(null, Typeface.BOLD);
        }
        if(boldSwitch.isChecked() && italicsSwitch.isChecked() && !underlineSwitch.isChecked())
        {
            boldFlag[0] ="True";
            italicsFlag[0]="True";
            underlineFlag[0]="False";
            notesText.setBackgroundDrawable(null);
            notesText.setTypeface(null, Typeface.BOLD_ITALIC);

        }
        if(!boldSwitch.isChecked() && italicsSwitch.isChecked() && underlineSwitch.isChecked())
        {
            boldFlag[0] ="False";
            italicsFlag[0]="True";
            underlineFlag[0]="True";
            notesText.setTypeface(null, Typeface.ITALIC);
            notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        }
        if(!boldSwitch.isChecked() && !italicsSwitch.isChecked() && underlineSwitch.isChecked())
        {
            boldFlag[0] ="False";
            italicsFlag[0]="False";
            underlineFlag[0]="True";
            notesText.setTypeface(null, Typeface.NORMAL);
            notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        }
        if(!boldSwitch.isChecked() && italicsSwitch.isChecked() && !underlineSwitch.isChecked())
        {
            boldFlag[0] ="False";
            italicsFlag[0]="True";
            underlineFlag[0]="False";
            notesText.setBackgroundDrawable(null);
            notesText.setTypeface(null, Typeface.ITALIC);
        }
        if(boldSwitch.isChecked() && !italicsSwitch.isChecked() && underlineSwitch.isChecked())
        {
            boldFlag[0] ="True";
            italicsFlag[0]="False";
            underlineFlag[0]="True";
            notesText.setTypeface(null, Typeface.BOLD);
            notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        }
        //endregion

        boldSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                //Logic for all switch possibilities
                //region
                if(boldSwitch.isChecked() && italicsSwitch.isChecked() && underlineSwitch.isChecked())
                {
                    boldFlag[0] ="True";
                    italicsFlag[0]="True";
                    underlineFlag[0]="True";
                    notesText.setTypeface(null, Typeface.BOLD_ITALIC);
                    notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                }
                if(!boldSwitch.isChecked() && !italicsSwitch.isChecked() && !underlineSwitch.isChecked())
                {
                    boldFlag[0] ="False";
                    italicsFlag[0]="False";
                    underlineFlag[0]="False";
                    notesText.setBackgroundDrawable(null);
                    notesText.setTypeface(null, Typeface.NORMAL);
                }
                if(boldSwitch.isChecked() && !italicsSwitch.isChecked() && !underlineSwitch.isChecked())
                {
                    boldFlag[0] ="True";
                    italicsFlag[0]="False";
                    underlineFlag[0]="False";
                    notesText.setBackgroundDrawable(null);
                    notesText.setTypeface(null, Typeface.BOLD);
                }
                if(boldSwitch.isChecked() && italicsSwitch.isChecked() && !underlineSwitch.isChecked())
                {
                    boldFlag[0] ="True";
                    italicsFlag[0]="True";
                    underlineFlag[0]="False";
                    notesText.setBackgroundDrawable(null);
                    notesText.setTypeface(null, Typeface.BOLD_ITALIC);

                }
                if(!boldSwitch.isChecked() && italicsSwitch.isChecked() && underlineSwitch.isChecked())
                {
                    boldFlag[0] ="False";
                    italicsFlag[0]="True";
                    underlineFlag[0]="True";
                    notesText.setTypeface(null, Typeface.ITALIC);
                    notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                }
                if(!boldSwitch.isChecked() && !italicsSwitch.isChecked() && underlineSwitch.isChecked())
                {
                    boldFlag[0] ="False";
                    italicsFlag[0]="False";
                    underlineFlag[0]="True";
                    notesText.setTypeface(null, Typeface.NORMAL);
                    notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                }
                if(!boldSwitch.isChecked() && italicsSwitch.isChecked() && !underlineSwitch.isChecked())
                {
                    boldFlag[0] ="False";
                    italicsFlag[0]="True";
                    underlineFlag[0]="False";
                    notesText.setBackgroundDrawable(null);
                    notesText.setTypeface(null, Typeface.ITALIC);
                }
                if(boldSwitch.isChecked() && !italicsSwitch.isChecked() && underlineSwitch.isChecked())
                {
                    boldFlag[0] ="True";
                    italicsFlag[0]="False";
                    underlineFlag[0]="True";
                    notesText.setTypeface(null, Typeface.BOLD);
                    notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                }
                //endregion

            }
        });
        italicsSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                //Logic for all switch possibilities
                //region
                if(boldSwitch.isChecked() && italicsSwitch.isChecked() && underlineSwitch.isChecked())
                {
                    boldFlag[0] ="True";
                    italicsFlag[0]="True";
                    underlineFlag[0]="True";
                    notesText.setTypeface(null, Typeface.BOLD_ITALIC);
                    notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                }
                if(!boldSwitch.isChecked() && !italicsSwitch.isChecked() && !underlineSwitch.isChecked())
                {
                    boldFlag[0] ="False";
                    italicsFlag[0]="False";
                    underlineFlag[0]="False";
                    notesText.setBackgroundDrawable(null);
                    notesText.setTypeface(null, Typeface.NORMAL);
                }
                if(boldSwitch.isChecked() && !italicsSwitch.isChecked() && !underlineSwitch.isChecked())
                {
                    boldFlag[0] ="True";
                    italicsFlag[0]="False";
                    underlineFlag[0]="False";
                    notesText.setBackgroundDrawable(null);
                    notesText.setTypeface(null, Typeface.BOLD);
                }
                if(boldSwitch.isChecked() && italicsSwitch.isChecked() && !underlineSwitch.isChecked())
                {
                    boldFlag[0] ="True";
                    italicsFlag[0]="True";
                    underlineFlag[0]="False";
                    notesText.setBackgroundDrawable(null);
                    notesText.setTypeface(null, Typeface.BOLD_ITALIC);

                }
                if(!boldSwitch.isChecked() && italicsSwitch.isChecked() && underlineSwitch.isChecked())
                {
                    boldFlag[0] ="False";
                    italicsFlag[0]="True";
                    underlineFlag[0]="True";
                    notesText.setTypeface(null, Typeface.ITALIC);
                    notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                }
                if(!boldSwitch.isChecked() && !italicsSwitch.isChecked() && underlineSwitch.isChecked())
                {
                    boldFlag[0] ="False";
                    italicsFlag[0]="False";
                    underlineFlag[0]="True";
                    notesText.setTypeface(null, Typeface.NORMAL);
                    notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                }
                if(!boldSwitch.isChecked() && italicsSwitch.isChecked() && !underlineSwitch.isChecked())
                {
                    boldFlag[0] ="False";
                    italicsFlag[0]="True";
                    underlineFlag[0]="False";
                    notesText.setBackgroundDrawable(null);
                    notesText.setTypeface(null, Typeface.ITALIC);
                }
                if(boldSwitch.isChecked() && !italicsSwitch.isChecked() && underlineSwitch.isChecked())
                {
                    boldFlag[0] ="True";
                    italicsFlag[0]="False";
                    underlineFlag[0]="True";
                    notesText.setTypeface(null, Typeface.BOLD);
                    notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                }
                //endregion

            }
        });

        underlineSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Logic for all switch possibilities
                //region
                if(boldSwitch.isChecked() && italicsSwitch.isChecked() && underlineSwitch.isChecked())
                {
                    boldFlag[0] ="True";
                    italicsFlag[0]="True";
                    underlineFlag[0]="True";
                    notesText.setTypeface(null, Typeface.BOLD_ITALIC);
                    notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                }
                if(!boldSwitch.isChecked() && !italicsSwitch.isChecked() && !underlineSwitch.isChecked())
                {
                    boldFlag[0] ="False";
                    italicsFlag[0]="False";
                    underlineFlag[0]="False";
                    notesText.setBackgroundDrawable(null);
                    notesText.setTypeface(null, Typeface.NORMAL);
                }
                if(boldSwitch.isChecked() && !italicsSwitch.isChecked() && !underlineSwitch.isChecked())
                {
                    boldFlag[0] ="True";
                    italicsFlag[0]="False";
                    underlineFlag[0]="False";
                    notesText.setBackgroundDrawable(null);
                    notesText.setTypeface(null, Typeface.BOLD);
                }
                if(boldSwitch.isChecked() && italicsSwitch.isChecked() && !underlineSwitch.isChecked())
                {
                    boldFlag[0] ="True";
                    italicsFlag[0]="True";
                    underlineFlag[0]="False";
                    notesText.setBackgroundDrawable(null);
                    notesText.setTypeface(null, Typeface.BOLD_ITALIC);

                }
                if(!boldSwitch.isChecked() && italicsSwitch.isChecked() && underlineSwitch.isChecked())
                {
                    boldFlag[0] ="False";
                    italicsFlag[0]="True";
                    underlineFlag[0]="True";
                    notesText.setTypeface(null, Typeface.ITALIC);
                    notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                }
                if(!boldSwitch.isChecked() && !italicsSwitch.isChecked() && underlineSwitch.isChecked())
                {
                    boldFlag[0] ="False";
                    italicsFlag[0]="False";
                    underlineFlag[0]="True";
                    notesText.setTypeface(null, Typeface.NORMAL);
                    notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                }
                if(!boldSwitch.isChecked() && italicsSwitch.isChecked() && !underlineSwitch.isChecked())
                {
                    boldFlag[0] ="False";
                    italicsFlag[0]="True";
                    underlineFlag[0]="False";
                    notesText.setBackgroundDrawable(null);
                    notesText.setTypeface(null, Typeface.ITALIC);
                }
                if(boldSwitch.isChecked() && !italicsSwitch.isChecked() && underlineSwitch.isChecked())
                {
                    boldFlag[0] ="True";
                    italicsFlag[0]="False";
                    underlineFlag[0]="True";
                    notesText.setTypeface(null, Typeface.BOLD);
                    notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                }
                //endregion

            }
        });


        //Label Dropdown Logic
        NotepadDB noteDB=new NotepadDB(getApplicationContext());
        noteDB.open();
        final ArrayList<String> allLables=noteDB.getLabels();

        final ArrayAdapter<String> labelAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, allLables);

        labelSpinner.setAdapter(labelAdapter);
        labelSpinner.setSelection(labelAdapter.getPosition(editableItem[3]));
        final String[] selectedLabel=new String[1];
        labelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                Object item = parent.getItemAtPosition(pos);
                selectedLabel[0]=item.toString();
            }
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        //Send as Text Button Logic
        ImageButton sendAsText=(ImageButton) findViewById(R.id.sendAsTextEdit) ;
        sendAsText.setOnClickListener(new View.OnClickListener()
        {
              @Override
              public void onClick(View v)
              {
                  String message = notesText.getText().toString();
                  Intent share = new Intent(Intent.ACTION_SEND);
                  share.setType("text/plain");
                  share.putExtra(Intent.EXTRA_TEXT, titleText.getText().toString() +":- "+message);
                  startActivity(Intent.createChooser(share, "Choose Contact"));
              }
        });

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
                    NoteEntries editNote=new NoteEntries(titleText.getText().toString(),editedNote.getText().toString(),selectedLabel[0],boldFlag[0],italicsFlag[0],underlineFlag[0],editableItem[7].toString());

                    NotepadDB db=new NotepadDB(getApplicationContext());
                    db.updateNote(editNote, rowID);

                    Toast.makeText(getBaseContext(), "Changes Saved!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(EditNotes.this, NotepadHome.class));
                }

            }
        });
    }
}
