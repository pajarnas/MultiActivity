package edu.ucmo.sxz45880.android.multiactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    private Button mSubButton;
    private EditText mSubEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        mSubEditText = (EditText)findViewById(R.id.subEditText);
        mSubButton = (Button)findViewById(R.id.subButton);

        String data2 = getIntent().getStringExtra("main_edit_text");
        mSubEditText.setText(data2);

        mSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity.this,MainActivity.class);
                intent.putExtra("sub_edit_text",mSubEditText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();

            }
        });

    }
}
