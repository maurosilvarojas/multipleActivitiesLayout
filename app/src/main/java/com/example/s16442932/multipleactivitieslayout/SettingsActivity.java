package com.example.s16442932.multipleactivitieslayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTitle("Settings");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final Button backButton = (Button)findViewById(R.id.backButton);
        final EditText portField = (EditText)findViewById(R.id.portField);
        final EditText qualityField = (EditText)findViewById(R.id.qualityField);
        final EditText brokerField = (EditText)findViewById(R.id.brokerField);
        final Connection connection=new Connection(qualityField.getText().toString(),portField.getText().toString(),brokerField.getText().toString());
        final Intent ii = new Intent(this,HomeActivity.class);

        backButton.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View view) {

                                               System.out.println("Settings msg"+ portField.getText());
                                              ii.putExtra("quality", connection.getQuality());
                                              ii.putExtra("port", connection.getPort());
                                              ii.putExtra("quality", "newTemperature");
                                              ii.putExtra("broker", connection.getBroker());
                                              startActivity(ii);
                                              //shared  https://developer.android.com/training/basics/data-storage/shared-preferences.html 
                                              //onSaveInstanceState-- bundle
                                          }
                                      }
        );

        //final TextView newTopic = (TextView)findViewById(R.id.topicText);
        //Connection connection = new Connection(newTopic.getText().toString());

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem item1 = menu.add(0,0,Menu.NONE,"Settings");
        MenuItem item2 = menu.add(0,1,Menu.NONE,"Home");
        MenuItem item3 = menu.add(0,2,Menu.NONE,"Help");
        MenuItem item4 = menu.add(0,3,Menu.NONE,"Credits");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case 0:
                Intent i0 = new Intent(this,SettingsActivity.class);
                startActivity(i0);
                return true;
            case 1:
                Intent i1 = new Intent(this,HomeActivity.class);
                i1.putExtra("main", "mqtt ");
                i1.putExtra("port", "1883");
                i1.putExtra("quality", "newTemperature");
                i1.putExtra("broker", "192.168.0.1");
                startActivity(i1);
                return true;
            case 2:
                Intent i2 = new Intent(this,HelpActivity.class);
                startActivity(i2);
                return true;
            case 3:
                Intent i3 = new Intent(this,CreditsActivity.class);
                startActivity(i3);
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }
    }



}
