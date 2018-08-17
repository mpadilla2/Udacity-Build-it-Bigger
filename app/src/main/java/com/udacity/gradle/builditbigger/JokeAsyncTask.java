package com.udacity.gradle.builditbigger;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

// Reference: https://goo.gl/2Adjir
public class JokeAsyncTask extends AsyncTask<Void, Void, String> {

    private static final String JOKE_ASYNTASK_EXCEPTION_NOTICE = "Something went wrong. Check the logs.";
    // pc ip address for testing with phone
    private static final String LOCAL_IP = "http://192.168.1.72:8080/_ah/api/";
    // localhost's IP address in Android emulator
    //private static final String LOCAL_IP = "http://10.0.2.2:8080/_ah/api/";
    private static MyApi myApiService = null;

    @Override
    protected final String doInBackground(Void... voids) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(LOCAL_IP)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            Log.d("JokeAsyncTask", e.getMessage());
            return JOKE_ASYNTASK_EXCEPTION_NOTICE;
        }
    }
}
