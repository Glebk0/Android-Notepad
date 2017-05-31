package gobinduottawa.notepad;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);

        final String[] editableItem=getIntent().getStringArrayExtra("editableItem");
        final EditText titleText=(EditText)findViewById(R.id.titleView);
        final EditText notesText=(EditText)findViewById(R.id.notesTextView) ;
        final TextView labelText=(TextView) findViewById(R.id.labelView);
        final ImageView imageNotes=(ImageView) findViewById(R.id.imageViewNotes);
        final String rowID=editableItem[0].toString();
        titleText.setText("Title:  "+editableItem[1]);
        notesText.setText("Notes:  "+editableItem[2]);
        labelText.setText("Label:  "+editableItem[3]);
        Log.d("Path from DB", editableItem[7]);
        if(!editableItem[7].isEmpty())
        {
            imageNotes.setImageBitmap(BitmapFactory.decodeFile(editableItem[7].toString()));
        }

        final String boldFlag=editableItem[4];
        final String italicsFlag=editableItem[5];
        final String underlineFlag=editableItem[6];

        //Logic for formatting notes field
        //region
        if(boldFlag.equals("True")&& italicsFlag.equals("True") && underlineFlag.equals("True"))
        {
            notesText.setTypeface(null, Typeface.BOLD_ITALIC);
            notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        }

        if(boldFlag.equals("True")&& italicsFlag.equals("False") && underlineFlag.equals("False"))
        {
            notesText.setTypeface(null, Typeface.BOLD);
        }
        if(boldFlag.equals("True")&& italicsFlag.equals("True") && underlineFlag.equals("False"))
        {
            notesText.setTypeface(null, Typeface.BOLD_ITALIC);
        }
        if(boldFlag.equals("False")&& italicsFlag.equals("True") && underlineFlag.equals("True"))
        {
            notesText.setTypeface(null, Typeface.ITALIC);
            notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        }
        if(boldFlag.equals("False")&& italicsFlag.equals("False") && underlineFlag.equals("True"))
        {
            notesText.setTypeface(null, Typeface.NORMAL);
            notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        }
        if(boldFlag.equals("False")&& italicsFlag.equals("True") && underlineFlag.equals("False"))
        {
            notesText.setTypeface(null, Typeface.ITALIC);
        }
        if(boldFlag.equals("True")&& italicsFlag.equals("False") && underlineFlag.equals("True"))
        {
            notesText.setTypeface(null, Typeface.BOLD);
            notesText.setPaintFlags(notesText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        }

        //endregion

        //Logic for making Title and Notes Field Un-Editable
        KeyListener titleListener;
        titleListener = titleText.getKeyListener();
        titleText.setKeyListener(null);
        KeyListener notesListener;
        notesListener=notesText.getKeyListener();
        notesText.setKeyListener(null);

        //Delete Button Logic
        ImageButton deleteNote=(ImageButton) findViewById(R.id.deleteNoteView) ;
        deleteNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                NotepadDB db=new NotepadDB(getApplicationContext());
                db.deleteNote(editableItem[1].toString());
                startActivity(new Intent(ViewNote.this, NotepadHome.class));
                Toast.makeText(getBaseContext(), "Note Deleted!!", Toast.LENGTH_SHORT).show();

            }
        });

        //Edit Button Logic
        ImageButton editNote=(ImageButton) findViewById(R.id.editNoteView) ;
        editNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(ViewNote.this, EditNotes.class).putExtra("editableItem",editableItem));
            }
        });

        //Send as Text Button Logic
        ImageButton sendasTextNote=(ImageButton) findViewById(R.id.sendAsTextView) ;
        sendasTextNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editableItem[1] +":- "+editableItem[2];
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, message);

                startActivity(Intent.createChooser(share, "Choose Contact"));
            }
        });

        //Email Button Logic
        ImageButton emailNote=(ImageButton) findViewById(R.id.sendEmail) ;
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

    }
}
