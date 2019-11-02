package com.example.artlet_v1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.artlet_v1.DatabaseHelper;
import com.example.artlet_v1.ExampleAdapter;
import com.example.artlet_v1.R;
import com.example.artlet_v1.SomeActivity;
import com.example.artlet_v1.TableUserProfile.TableUserProfileClass;
import com.example.artlet_v1.examplepost;

import java.util.ArrayList;

public class LeaderBoardActivity extends AppCompatActivity implements ExampleAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayout;
    ArrayList<examplepost> exampleList= new ArrayList<>();

    TextView followersTV;
    TextView followingTV;
    TextView userPostsTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        /*exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));
        exampleList.add(new examplepost("Line 1"));


        mRecyclerView= findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayout= new LinearLayoutManager(this);
        mAdapter=new ExampleAdapter(exampleList,this);

        mRecyclerView.setLayoutManager(mLayout);
        mRecyclerView.setAdapter(mAdapter);

        fetchDatabaseResults();*/
    }

    @Override
    public void onItemClick(int position) {
        exampleList.get(position);
        Intent intent=new Intent(this, SomeActivity.class);
        startActivity(intent);

    }

    private void fetchDatabaseResults() {
        String tableName = TableUserProfileClass.TABLE_User_Profile;

        DatabaseHelper dbHelper = new DatabaseHelper(this.getApplicationContext());

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String userId = getIntent().getStringExtra("key_userId");

        followersTV = findViewById(R.id.followersId);
        followingTV = findViewById(R.id.followingId);
        userPostsTV = findViewById(R.id.postsId);
        try {
            Log.d("UserProfileActivity",userId);
            String query = "SELECT "+ TableUserProfileClass.USER_FOLLOWERS + " , " + TableUserProfileClass.USER_FOLLOWING + " , "
                    + TableUserProfileClass.USER_POSTS + " FROM " + tableName + " WHERE " + TableUserProfileClass.USER_ID +" = "+userId;

            Cursor c = db.rawQuery(query,null);

            if (c != null ) {
                if  (c.moveToFirst()) {

                    String followers = c.getString(c.getColumnIndex(TableUserProfileClass.USER_FOLLOWERS));
                    String following = c.getString(c.getColumnIndex(TableUserProfileClass.USER_FOLLOWING));
                    String userPosts = c.getString(c.getColumnIndex(TableUserProfileClass.USER_POSTS));
                    followersTV.setText(followers);
                    followingTV.setText(following);
                    userPostsTV.setText(userPosts);

                    Log.d("In UserProfileActivity", "Successfully Printed followers and following");
                }
            }
            c.close();
            db.close();
        } catch (SQLiteException se ) {

            Log.e(getClass().getSimpleName(), "Couldn't open the database");

        }
    }
}
