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
        final String[] boldFlag = {"False"};
        final String[] italicsFlag={"False"};
        final String[] underlineFlag={"False"};

        //Bold Italics Underline Switch Logic
        final Switch boldSwitch=(Switch) findViewById(R.id.bold);
        final Switch italicsSwitch=(Switch) findViewById(R.id.italics);
        final Switch underlineSwitch=(Switch) findViewById(R.id.underline);
        final ImageView imageView=(ImageView) findViewById(R.id.imageView4);

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

        //Label Dropdown Logic
        final Spinner labelSpinner=(Spinner) findViewById(R.id.labelAdd) ;
        final NotepadDB noteDB=new NotepadDB(getApplicationContext());
        noteDB.open();
        final ArrayList<String> allLables=noteDB.getLabels();
        if(allLables.contains("Add New"))
        {
            allLables.remove("Add New");
        }
        final ArrayAdapter<String> labelAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, allLables);
        labelSpinner.setAdapter(labelAdapter);
        labelSpinner.setSelection(labelAdapter.getPosition("Select Label"));
        final String[] selectedLabel = new String[1];
        labelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                Object item = parent.getItemAtPosition(pos);
                if(!item.toString().equals("Select Label") )
                {
                    selectedLabel[0]=item.toString();
                }
                else
                {
                    selectedLabel[0]="None";

                }
            }
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        //Add Label Floating Button Logic
        FloatingActionButton addLabelFLoating=(FloatingActionButton) findViewById(R.id.addLabelButton) ;
        addLabelFLoating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(AddNotes.this, AddLabel.class));
            }
        });


        //Send Text Button Logic
        ImageButton sendText=(ImageButton) findViewById(R.id.sendText) ;
        sendText.setOnClickListener(new View.OnClickListener() {
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
                    NoteEntries newNote=new NoteEntries(titleText.getText().toString(),notesText.getText().toString(),selectedLabel[0],boldFlag[0],italicsFlag[0],underlineFlag[0],imageDecode.toString());
                    NotepadDB db=new NotepadDB(getApplicationContext());
                    db.addNote(newNote);
                    String message = titleText.getText().toString() + ":- " + notesText.getText().toString();
                    Intent share = new Intent(Intent.ACTION_SEND);
                    share.setType("text/plain");
                    share.putExtra(Intent.EXTRA_TEXT, message);
                    startActivity(Intent.createChooser(share, "Choose Contact"));
                    Toast.makeText(getBaseContext(), "Note Saved and sending as text!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Send Email Button Logic
        ImageButton sendEmail=(ImageButton) findViewById(R.id.emailNote) ;
        sendEmail.setOnClickListener(new View.OnClickListener() {
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
                    NoteEntries newNote=new NoteEntries(titleText.getText().toString(),notesText.getText().toString(),selectedLabel[0],boldFlag[0],italicsFlag[0],underlineFlag[0],imageDecode.toString());
                    NotepadDB db=new NotepadDB(getApplicationContext());
                    db.addNote(newNote);
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/html");
                    intent.putExtra(Intent.EXTRA_EMAIL, "gobindnitj@gmail.com");
                    intent.putExtra(Intent.EXTRA_SUBJECT, titleText.getText());
                    intent.putExtra(Intent.EXTRA_TEXT, notesText.getText());

                    startActivity(Intent.createChooser(intent, "Send Email"));
                    Toast.makeText(getBaseContext(), "Note Saved and sending as email!!", Toast.LENGTH_SHORT).show();


                }
            }
        });

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
                    NoteEntries newNote=new NoteEntries(titleText.getText().toString(),notesText.getText().toString(),selectedLabel[0],boldFlag[0],italicsFlag[0],underlineFlag[0],imageDecode.toString());
                    NotepadDB db=new NotepadDB(getApplicationContext());
                    db.addNote(newNote);
                    Toast.makeText(getBaseContext(), "Note Saved!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddNotes.this, NotepadHome.class));
                }

            }
        });

        //Add Image Button Logic
        ImageButton addImage=(ImageButton) findViewById(R.id.addImage) ;
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) findViewById(R.id.imageView4);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            imageDecode=picturePath.toString();
            Log.d("ImagePath", imageDecode);

        }
    }


}
