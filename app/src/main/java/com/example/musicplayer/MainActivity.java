package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;

    private List<String> namelist = new ArrayList<>();//歌曲名称数组
    private List<String> artistlist = new ArrayList<>();//艺术家名称数组
    private List<String> urllist = new ArrayList<>();//路径数组
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //5首歌歌名
        namelist.add("The Little Match Girl");
        namelist.add("Lonely Winter");
        namelist.add("The Hare in the Moon");
        namelist.add("Awaken");
        namelist.add("Oh Radiant One");
        //5个艺术家名
        artistlist.add("Maarten Schellekens");
        artistlist.add("Audiobinger");
        artistlist.add("Axletree");
        artistlist.add("Cretayu");
        artistlist.add("Edoy");
        //歌曲对应的url
        String url1="https://files.freemusicarchive.org/storage-freemusicarchive-org/tracks/YcKcasolCFrNfZVJtr5YaYZcS3eCv3waBC9XrTZx.mp3?download=1&name=Maarten%20Schellekens%20-%20The%20Little%20Match%20Girl%20%28ft.%20Enlia%29.mp3";
        String url2="https://files.freemusicarchive.org/storage-freemusicarchive-org/tracks/tPrcU0yvzDkE6qIrkwGTOS1gpO9BhKjgG3FE7OjD.mp3?download=1&name=Audiobinger%20-%20Lonely%20Winter.mp3";
        String url3="https://files.freemusicarchive.org/storage-freemusicarchive-org/tracks/JVO5CDYcdITUJrtlfaYKOS1JKL07HOEIBMvi4PJA.mp3?download=1&name=Axletree%20-%20The%20Hare%20in%20the%20Moon.mp3";
        String url4="https://files.freemusicarchive.org/storage-freemusicarchive-org/tracks/VXFtxygPfi8sWG5GOZe8T8xQ1qBEP8JCFNrApbaV.mp3?download=1&name=Cretayu%20-%20Awaken.mp3";
        String url5="https://files.freemusicarchive.org/storage-freemusicarchive-org/tracks/mV3CPsPAboQ1mA4Ji0P2OiKeBNCsy3nPzJGys9l8.mp3?download=1&name=Siddhartha%20Corsus%20-%20Oh%20Radiant%20One.mp3";
        //添加url到urllist
        urllist.add(url1);
        urllist.add(url2);
        urllist.add(url3);
        urllist.add(url4);
        urllist.add(url5);
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,namelist);//数组适配器，显示歌曲名
        listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);//给listview设置适配器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = namelist.get(position);
                Intent intent = new Intent(MainActivity.this,MusicPlayer.class);
                //因为intent只能不能传List，只能传String，因此需要转换
                String[] nameList={"","","","",""};
                for(int i=0;i<5;i++){
                    nameList[i]=namelist.get(i);
                }
                String[] artistList={"","","","",""};
                for(int i=0;i<5;i++){
                    artistList[i]=artistlist.get(i);
                }
                String[] urlStr = {"","","","",""};
                for(int i=0;i<5;i++){
                    urlStr[i]=urllist.get(i);
                }
                //通过intent把歌曲id、歌曲名、艺术家名和路径传给MusicPlayer
                intent.putExtra("position",position);
                intent.putExtra("artistList",artistList);
                intent.putExtra("nameList",nameList);
                intent.putExtra("urlStr",urlStr);
                startActivity(intent);//开启活动，音乐播放
            }
        });


    }
}