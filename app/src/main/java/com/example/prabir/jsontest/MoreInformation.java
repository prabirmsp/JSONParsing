package com.example.prabir.jsontest;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;


public class MoreInformation extends ActionBarActivity {

    protected TeamMember mSelectedMember;
    protected ImageView mProfileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_information);

        try {
            String JSONObjectString = getIntent().getStringExtra("PERSON");
            JSONObject person = new JSONObject(JSONObjectString);
            mSelectedMember = new TeamMember(person);
        }
        catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        mProfileImageView = (ImageView)findViewById(R.id.profileImageView);
        if (mSelectedMember.image.equals("http://www.cs.grinnell.edu/~owusumic17/img/android-round.png"))
            mProfileImageView.setImageDrawable(getResources().getDrawable(R.drawable.avatar));
        else
            Picasso.with(this).load(mSelectedMember.image).into(mProfileImageView);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_more_information, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
