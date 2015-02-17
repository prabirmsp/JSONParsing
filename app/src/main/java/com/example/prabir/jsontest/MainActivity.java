package com.example.prabir.jsontest;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

    /*
    * FROM TUTORIAL:
    * http://www.newthinktank.com/2013/07/android-development-15/
    *
    * */

    // The JSON REST Service I will pull from
    static final String teamMemberInfo = "http://www.cs.grinnell.edu/~owusumic17/android.json";

    // Will hold the values I pull from the JSON
    TeamMember [] mAppDevTeam;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Get any saved data
        super.onCreate(savedInstanceState);

        // Point to the name for the layout xml file used
        setContentView(R.layout.activity_main);

        // Call for doInBackground() in MyAsyncTask to be executed
        new MyAsyncTask().execute();

    }
    // Use AsyncTask if you need to perform background tasks, but also need
    // to change components on the GUI. Put the background operations in
    // doInBackground. Put the GUI manipulation code in onPostExecute

    private class MyAsyncTask extends AsyncTask<String, String, String> {

        protected String doInBackground(String... arg0) {

            // HTTP Client that supports streaming uploads and downloads
            DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());

            // Define that I want to use the POST method to grab data from
            // the provided URL
            HttpPost httppost = new HttpPost(teamMemberInfo);

            // Web service used is defined
            httppost.setHeader("Content-type", "application/json");

            // Used to read data from the URL
            InputStream inputStream = null;

            // Will hold the whole all the data gathered from the URL
            String result = null;

            try {

                // Get a response if any from the web service
                HttpResponse response = httpclient.execute(httppost);

                // The content from the requested URL along with headers, etc.
                HttpEntity entity = response.getEntity();

                // Get the main content from the URL
                inputStream = entity.getContent();

                // JSON is UTF-8 by default
                // BufferedReader reads data from the InputStream until the Buffer is full
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);

                // Will store the data
                StringBuilder theStringBuilder = new StringBuilder();

                String line = null;

                // Read in the data from the Buffer untilnothing is left
                while ((line = reader.readLine()) != null) {

                    // Add data from the buffer to the StringBuilder
                    theStringBuilder.append(line + "\n");
                }

                // Store the complete data in result
                result = theStringBuilder.toString();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                // Close the InputStream when you're done with it
                try {
                    if (inputStream != null) inputStream.close();
                } catch (Exception e) {
                }
            }

            // Holds Key Value pairs from a JSON source
            JSONObject jsonObject;
            try {


                // Print out all the data read in
                // Log.v("JSONParser RESULT ", result);

                // Get the root JSONObject
                jsonObject = new JSONObject(result);

                JSONArray members = jsonObject.getJSONArray("members");

                // Get the JSON Strings in the quote object

                mAppDevTeam = new TeamMember[members.length()];

                for (int i = 0; i < members.length(); i++) {
                    JSONObject person = members.getJSONObject(i);
                    // name += person.getString("name") + ", ";

                    mAppDevTeam[i] = new TeamMember(person);
                }

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return result;

        }

        protected void onPostExecute(String result) {

    // Construct the data source
                ArrayList<TeamMember> arrayOfUsers = new ArrayList<TeamMember>();

    // Create the adapter to convert the array to views
                MembersAdapter adapter = new MembersAdapter(MainActivity.this, arrayOfUsers);



            for (int i = 0; i < mAppDevTeam.length; i++) {
                adapter.add(mAppDevTeam[i]);
            }
    // Attach the adapter to a ListView
                ListView listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(adapter);




        }

    }

}