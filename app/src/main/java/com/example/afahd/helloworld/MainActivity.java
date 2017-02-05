package com.example.afahd.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_info=(Button)findViewById(R.id.button_info);
        Button button_quit=(Button)findViewById(R.id.button_quit);

        /**
         * Method which is triggered when the user clicks on the
         * information button
         */
        button_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //We get the login typed by the user
                EditText login=(EditText) findViewById(R.id.edit_login);
                String loginValue=login.getText().toString();

                //we get the hour given by the user
                TimePicker time=(TimePicker) findViewById(R.id.timepicker_theHour);
                Integer hour=time.getCurrentHour();
                Integer min=time.getCurrentMinute();
                String time_string=hour.toString()+":"+min.toString();

                TextView info=(TextView)findViewById(R.id.text_auth_login_data);
                TextView infoHour=(TextView)findViewById(R.id.text_auth_hour_data);

                //If the typed login is not null we print it,plus the current hour
                // next to the information button
                //otehrwise we print Error
                if(loginValue!=null){

                    info.setText(loginValue);
                    infoHour.setText(time_string);
                }
                else {
                    info.setText("ERROR! Login is Null");
                }
                if(hour!=null&&min!=null){
                    infoHour.setText(time_string);
                }
                else{
                    infoHour.setText("Error!! Hour is Null");
                }
            }
        });

        /**
         * Metchod to quit the application by clicking on the exit button
         */
        button_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }

}
