package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.jokedemo.JokesterActivity;

// AsyncResponse related code Reference: https://stackoverflow.com/a/12575319/10151438
public class MainActivity extends AppCompatActivity {

    private Intent mJokeIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void tellJoke(View view) {

        mJokeIntent = new Intent(this, JokesterActivity.class);
        @SuppressLint("StaticFieldLeak") JokeAsyncTask jokeAsyncTask = new JokeAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                mJokeIntent.putExtra(JokesterActivity.JOKE_KEY, result);
                startActivity(mJokeIntent);
            }
        };
        jokeAsyncTask.execute();
    }
}
