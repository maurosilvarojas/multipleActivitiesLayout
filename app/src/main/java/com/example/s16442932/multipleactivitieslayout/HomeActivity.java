package com.example.s16442932.multipleactivitieslayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView maintext =(TextView)findViewById(R.id.mainText);
        TextView topicText = (TextView)findViewById(R.id.topicText);
        TextView portText = (TextView)findViewById(R.id.portText);
        TextView brokerText = (TextView)findViewById(R.id.brokerText);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final Connection connection=new Connection();
            connection.setBroker(extras.getString("broker"));
            connection.setPort(extras.getString("port"));
            connection.setQuality(extras.getString("quality"));
            System.out.println("WHAT********"+connection.getBroker().toString());


            maintext.setText(connection.getBroker());
            topicText.setText("Some topic");
            portText.setText(connection.getPort());
            brokerText.setText(connection.getBroker());

            //The key argument here must match that used in the other activity
        }



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
