package com.example.lev.first_test;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedHashMap;
import java.util.Map;

public class main extends AppCompatActivity {

    public String songTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String Outputz = "";


        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N)
        {
            Outputz = "! UPDATE REQUIRED !";
        }
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        {
            //message_box.setText(Outputz);
            //Toaster
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            { Toast.makeText(main.this,"LANDSCAPE", Toast.LENGTH_SHORT).show();        }
            else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            { Toast.makeText(main.this,"PORTRAIT", Toast.LENGTH_SHORT).show();         }

            Button about = findViewById(R.id.buttonA);
            ScrollView scrollView = findViewById(R.id.menu);

            LinearLayout subMenu = new LinearLayout(this);

            subMenu.setOrientation(LinearLayout.VERTICAL);

            //map holder for songs
            Map< Integer, Map> songlist = new LinkedHashMap<>();

            //individual song creation
            //
            Map<String,String> id0001 = new LinkedHashMap<>();
            id0001.put("title", "Sandstorm");
            id0001.put("author", "Darude");
            id0001.put("length", "3:45");
            id0001.put("rating","5");
            //add it
            songlist.put(1,id0001);


            Map<String,String> id0002 = new LinkedHashMap<>();
            id0002.put("title", "Man Machine");
            id0002.put("author", "Kraftwerk");
            id0002.put("length", "5:04");
            id0002.put("rating","5");
            //add it
            songlist.put(2,id0002);


            Map<String,String> id0003 = new LinkedHashMap<>();
            id0003.put("title", "Insurrection");
            id0003.put("author", "PPK");
            id0003.put("length", "4:06");
            id0003.put("rating","5");
            //add it
            songlist.put(3,id0003);

            ////
            Map<String,String> id0004 = new LinkedHashMap<>();
            id0004.put("title", "Better Off Alone");
            id0004.put("author", "Alice Deejay");
            id0004.put("length", "3:39");
            id0004.put("rating","5");
            //add it
            songlist.put(4,id0004);


            Map<String,String> id0005 = new LinkedHashMap<>();
            id0005.put("title", "Exploration of Space");
            id0005.put("author", "Cosmic Gate");
            id0005.put("length", "3:41");
            id0005.put("rating","5");
            //add it
            songlist.put(5,id0005);


            Map<String,String> id0006 = new LinkedHashMap<>();
            id0006.put("title", "Adagio for Strings");
            id0006.put("author", "Dj Tiesto");
            id0006.put("length", "7:23");
            id0006.put("rating","5");
            //add it
            songlist.put(6,id0006);

            ///
            Map<String,String> id0007 = new LinkedHashMap<>();
            id0007.put("title", "Cafe del Mar");
            id0007.put("author", "Energy 52");
            id0007.put("length", "3:08");
            id0007.put("rating","5");
            //add it
            songlist.put(7,id0007);


            Map<String,String> id0008 = new LinkedHashMap<>();
            id0008.put("title", "Voodoorave");
            id0008.put("author", "Madras");
            id0008.put("length", "5:06");
            id0008.put("rating","5");
            //add it
            songlist.put(8,id0008);


            Map<String,String> id0009 = new LinkedHashMap<>();
            id0009.put("title", "One More Time ");
            id0009.put("author", "Daft Puk");
            id0009.put("length", "5:21");
            id0009.put("rating","5");
            //add it
            songlist.put(9,id0009);


            for (Map.Entry<Integer, Map> entry : songlist.entrySet() )
             {
                 int id = entry.getKey();
                 Map<String,String> title = entry.getValue();
                 songTitle = title.get("title");

                 final Button b = new Button(this);
                 b.setHeight(100);
                 b.setText(songTitle);
                 b.setOnClickListener(
                         new View.OnClickListener() {
                             public void onClick(View v) {
                                 Intent i = new Intent( main.this, Rating.class);
                                 i.putExtra("song",b.getText());
                                 startActivityForResult(i, 1);
                                    }
                                 }
                             );
                 //add the button to the layout
                 subMenu.addView(b);
             }

            scrollView.addView(subMenu);

             about.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent a = new Intent( main.this, About.class);
                        startActivity(a);
                    }
                }
            );
        }//end of version check

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        TextView message_box = findViewById(R.id.textView);

        if (requestCode == 1 && resultCode == RESULT_OK)
        {
            String rated = data.getStringExtra("rating");
            String returned = data.getStringExtra("songName");
            message_box.setText("The rating for " + returned + " was " + rated + " out of 5 stars!");
            message_box.setTextSize(20);
        }
    }





}

// Test Code
/*


            //Map<String,Integer>map_songList = new HashMap<>();
            //map_songList.put("Darude - Sandstorm", 5);
            //map_songList.put("Kraftwerk - Man Machine", 5);
            //map_songList.put("GO2 - Spitfire", 5);



            //b.setText(songlist.get(1). );
            //Map<String, String> specificSong = songlist.get(1);
            //String title = specificSong.get("title");


//            songlist.forEach((song, rating) -> {
//                Map<String, String> specificSong = songlist.get(1);
//                String title = specificSong.get("title");
//            });
//            music.add(song);
//


            );


            //make a scrollview object
            ScrollView menu = new ScrollView(this);

            //make a layout constraint
            LinearLayout _menu = new LinearLayout(this);

            //set that layout constraint to vertical
            _menu.setOrientation(LinearLayout.VERTICAL);
            _menu.getLayoutParams().height = 400;
            _menu.getLayoutParams().width = 400 ;

            //set the layout width and
            menu.getLayoutParams().height = 401;
            menu.getLayoutParams().width = 401;

            menu.addView(_menu);

            Button b = new Button(this);

            for (int i = 0; i < 5; i++) {

                b.setWidth(400);
                b.setHeight(100);
                b.setText("Button "+i);
                b.setId(100+i);

                _menu.addView(b);
            }

*/