package com.hackuva.globetalk;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Abhilaash on 03/25/2018.
 */

public class getDataFromURL extends AsyncTask<String, Void, getDataFromURL.Result> {
    static class Result {
        String mResultValue;
        Exception mException;
        Result(String resultValue) {
            mResultValue = resultValue;
        }
        Result(Exception exception) {
            mException = exception;
        }
    }

    @Override
    protected Result doInBackground(String... urls) {
        Result result = null;
        if(urls.length > 0) {
            String urlString = urls[0];
            try {
                URL url = new URL(urlString);
                String resultString = downloadUrl(url);
                if(resultString != null){
                    result = new Result(resultString);
                }

                else{
                    throw new IOException("No response received.");
                }
            } catch (Exception e) {
                result = new Result(e);
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    protected void onPostExecute(Result result) {
        if (result != null) {
            if (result.mResultValue != null) {
//                Log.e("Data", result.mResultValue);
            } else if (result.mException != null) {
                result.mException.getMessage();
            }
            else{
                Log.e("Failed", "There was no data in the url");
            }
        }
    }


    private String downloadUrl(URL url) throws IOException {
        InputStream stream = null;
        URLConnection connection = null;
        String result = null;
        try {
            connection = url.openConnection();
            // Timeout for reading InputStream set to 10000ms.
            connection.setReadTimeout(10000);
            // Timeout for connection.connect() set to 10000ms.
            connection.setConnectTimeout(10000);
            // Already true by default but setting just in case; needs to be true since this request
            // is carrying an input (response) body.
            connection.setDoInput(true);
            // Open communications link (network traffic occurs here).
            connection.connect();
            // Retrieve the response body as an InputStream.
            stream = connection.getInputStream();
            try {
                BufferedReader bReader = new BufferedReader(new InputStreamReader(stream, "utf-8"), 8);
                StringBuilder sBuilder = new StringBuilder();

                String line;
                while ((line = bReader.readLine()) != null) {
                    sBuilder.append(line).append("\n");
                }
                result = sBuilder.toString();

            } catch (Exception e) {
                Log.e("ERROR: ", "Error converting result " + e.toString());
            }
        }
        finally {
            // Close Stream and disconnect HTTP connection.
            if (stream != null) {
                stream.close();
            }
        }
        return result;
    }
}
