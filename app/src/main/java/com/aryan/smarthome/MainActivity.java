package com.aryan.smarthome;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;

public class MainActivity extends AppCompatActivity {
TextView text;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.Text1);
        button=(Button)findViewById(R.id.but1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new doit().execute();
            }
        });
    }
    public class doit extends AsyncTask<Void,Void,Void>{
       String words;

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                org.jsoup.nodes.Document doc = Jsoup.connect("http://porwalroadways.000webhostapp.com/gettemp.php").get();
                words=doc.text().toString();
            }catch(Exception e){e.printStackTrace();
            words="not loaded try again";}
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            text.setText(words);
        }
    }
}
