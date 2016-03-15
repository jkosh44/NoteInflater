package hu.ait.android.noteinflater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutConatiner;
    private EditText etNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutConatiner = (LinearLayout) findViewById(R.id.layoutContainer);
        etNote = (EditText) findViewById(R.id.etNote);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnSave) {
            if (!"".equals(etNote.getText().toString())) {
                //save the note
                final View noteRow = getLayoutInflater().inflate(R.layout.note_row, null);

                TextView tvNote = (TextView) noteRow.findViewById(R.id.tvNote);
                tvNote.setText(etNote.getText().toString());
                layoutConatiner.addView(noteRow, 0);

                etNote.setText("");

                Button btnDelRow = (Button) noteRow.findViewById(R.id.btnDeleteCurrent);
                btnDelRow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        layoutConatiner.removeView(noteRow);
                    }
                });

            } else {
                etNote.setError(getString(R.string.empty_error));
            }
        } else if (v.getId() == R.id.btnDeleteAll) {
            layoutConatiner.removeAllViews();
        }

    }

}
