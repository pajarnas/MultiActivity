package edu.ucmo.sxz45880.android.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button mMainButton;
    private EditText mMainEditText;
    private static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainEditText = (EditText)findViewById(R.id.mainEditText);
        mMainButton = (Button)findViewById(R.id.mainButton);
        mMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SubActivity.class);

                intent.putExtra("main_edit_text",mMainEditText.getText().toString());
                startActivityForResult(intent, REQUEST_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        if(resultCode != Activity.RESULT_OK){
            return ;
        }
        if(requestCode == REQUEST_CODE){
            if(intent == null){
                return ;
            }
            String data = intent.getStringExtra("sub_edit_text");
            mMainEditText.setText(data);
        }
        super.onActivityResult(requestCode,resultCode,intent);
    }
}
