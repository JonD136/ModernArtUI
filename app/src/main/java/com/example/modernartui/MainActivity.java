package com.example.modernartui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public SeekBar seekBar;
    public RelativeLayout img, txtBtn;
    public ImageView purple, green, red, white, blue;
    public TextView moreInformationTxt;
    public Button vistMOMABtn, notNowBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        img = (RelativeLayout) findViewById(R.id.relativeLayout);
        txtBtn = (RelativeLayout) findViewById(R.id.txtBtn);

        purple = (ImageView) findViewById(R.id.purple);
        green = (ImageView) findViewById(R.id.green);
        red = (ImageView) findViewById(R.id.red);
        white = (ImageView) findViewById(R.id.white);
        blue = (ImageView) findViewById(R.id.blue);

        moreInformationTxt = (TextView) findViewById(R.id.moreInformationTxt);

        vistMOMABtn = (Button)  findViewById(R.id.vistMOMABtn);
        notNowBtn = (Button)  findViewById(R.id.notNowBtn);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                  purple.setBackgroundColor(Color.rgb(103 + progress,58,183));
                  green.setBackgroundColor(Color.rgb(74 ,195,139 + progress));
                  red.setBackgroundColor(Color.rgb(255, progress,0));
                  white.setBackgroundColor(Color.rgb(255 - progress,255 - progress,255 - progress));
                  blue.setBackgroundColor(Color.rgb(0,progress,181));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        notNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtBtn.setVisibility(View.INVISIBLE);

            }

        });

        vistMOMABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://www.moma.org/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                txtBtn.setVisibility(View.INVISIBLE);
                startActivity(intent);

            }

        });

    }


    // Three dots Option Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
            case R.id.moreInformation:

                txtBtn.setVisibility(View.VISIBLE);
                moreInformationTxt.setText("  Inspired by the works of artists such as Piet Mondrian and Ben Nicholson. \n " +
                        "\n" +
                        "Click below to learn more! \n");
                //Toast.makeText(this, "More Information clicked", Toast.LENGTH_SHORT).show();
                break;
        }


        return true;
    }




}