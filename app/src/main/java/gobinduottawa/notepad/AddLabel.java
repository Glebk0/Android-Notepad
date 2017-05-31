package gobinduottawa.notepad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddLabel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_label);
        final NotepadDB dbObj=new NotepadDB(AddLabel.this);

        Button saveLabel=(Button) findViewById(R.id.saveLabel);
        final EditText labelText=(EditText) findViewById(R.id.LabelView);
        saveLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(labelText.getText().toString().isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Please Add Label Name", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    dbObj.addLabel(labelText.getText().toString());
                    Toast.makeText(getBaseContext(), "Label Added", Toast.LENGTH_SHORT).show();
                }

            }
        });

        ImageButton goHome=(ImageButton) findViewById(R.id.goHomeLabel);
        ImageButton goAddNotes=(ImageButton) findViewById(R.id.addNotesScreen);
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(AddLabel.this, NotepadHome.class));
            }
        });

        goAddNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(AddLabel.this, AddNotes.class));
            }
        });



    }
}
