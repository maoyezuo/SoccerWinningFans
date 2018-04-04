package com.jiaoluokeji.games.soccerwinningfans.mode_login;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.jiaoluokeji.games.soccerwinningfans.MainActivity;
import com.jiaoluokeji.games.soccerwinningfans.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018\3\14 0014.
 */

public class GameStartActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private ConstraintLayout layout;
    private ListView favorite_player_list;
    private ListView mListView;
    List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("");//有内容的页面隐藏title R.string.title_home
                    layout.setBackgroundColor(R.color.mediumslateblue);//R.color.mediumslateblue
                    lv.setVisibility(View.VISIBLE);


                    return true;
                case R.id.navigation_transfer:
//                    String title_transfer = R.string.title_transfer;
//                    findViewById(R.string.title_transfer);

                    mTextMessage.setText(getString(R.string.title_transfer) +" 敬请期待");
                    layout.setBackgroundColor(Color.YELLOW);
                    lv.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_me:

                    mTextMessage.setText(getString(R.string.title_me) +" 敬请期待");
                    layout.setBackgroundColor(Color.YELLOW);
                    lv.setVisibility(View.INVISIBLE);
                    return true;

            }
            return false;
        }
    };
    private TextView tv1;//item.xml里的TextView：Textviewname
    private TextView tv2;//item.xml里的TextView：Textviewage
    private Button bt;//activity_main.xml里的Button
    private ListView lv;//activity_main.xml里的ListView
    private BaseAdapter adapter;//要实现的类
    private List<User> userList = new ArrayList<User>();//实体类




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);
        mTextMessage = findViewById(R.id.gs_message);
        mTextMessage.setText("");
        layout = findViewById(R.id.game_start_container);
//        mListView = (ListView)findViewById(R.id.favorite_player_list);



        //模拟数据库
        for (int i = 0; i < 50; i++) {
            User ue = new User();//给实体类赋值
            ue.setName("小米"+i);
            ue.setAge("18"+i);
            userList.add(ue);
        }
//        bt = (Button) findViewById(R.id.Button);
        lv = (ListView) findViewById(R.id.favorite_player_list);
        adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return userList.size();//数目
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = GameStartActivity.this.getLayoutInflater();
                View view;

                if (convertView==null) {
                    //因为getView()返回的对象，adapter会自动赋给ListView
                    view = inflater.inflate(R.layout.item, null);
                }else{
                    view=convertView;
                    Log.i("info","有缓存，不需要重新生成"+position);
                }
                tv1 = (TextView) view.findViewById(R.id.Textviewname);//找到Textviewname
                tv1.setText(userList.get(position).getName());//设置参数

                tv2 = (TextView) view.findViewById(R.id.Textviewage);//找到Textviewage
                tv2.setText(userList.get(position).getAge());//设置参数
                return view;
            }
            @Override
            public long getItemId(int position) {//取在列表中与指定索引对应的行id
                Log.d("getItemId: ", ""+position);
                return 0;
            }
            @Override
            public Object getItem(int position) {//获取数据集中与指定索引对应的数据项
                return null;
            }
        };
        lv.setAdapter(adapter);



//        int lengh = mListTitle.length;
//        for(int i =0; i < lengh; i++) {
//            Map<String,Object> item = new HashMap<String,Object>();
//            item.put("title", mListTitle[i]);
//            item.put("text", mListStr[i]);
//            mData.add(item);
//        }
//        SimpleAdapter adapter = new SimpleAdapter(this,mData,android.R.layout.simple_list_item_2,
//                new String[]{"title","text"},new int[]{android.R.id.text1,android.R.id.text2});
//        mListView.setAdapter(adapter);
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),"列表"+i, Toast.LENGTH_SHORT);
//            }
//        }
//        );



        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }






}
