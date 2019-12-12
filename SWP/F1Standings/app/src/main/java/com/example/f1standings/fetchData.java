package com.example.f1standings;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask <Void,Void,Void> {

    String data ="";
    String dataParsed = "";
    String singleParsed = "";


    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("https://ergast.com/api/f1/current/driverStandings.json");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line =" ";

            while (line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            /*JSONArray JA = new JSONArray(data);

            JSONObject jsonObj = new JSONObject(data);*/

            //JSONArray driverStandings = jsonObj.getJSONArray("DriverStandings");
            JSONObject JO = new JSONObject(data);

            JSONObject OBJECT;
            OBJECT = (JSONObject) JO.getJSONObject("MRData").getJSONObject("StandingsTable").getJSONArray("StandingsLists").get(0);

            JSONArray Array;
            Array = (JSONArray) OBJECT.getJSONArray("DriverStandings");


            for (int i = 0; i < Array.length(); i++){
                JSONObject ob = (JSONObject) Array.get(i);

                singleParsed = "First name: " + ob.getJSONObject("Driver").get("givenName") + "\n" +
                                "Last name: " + ob.getJSONObject("Driver").get("familyName") + "\n" +
                                "Nationality: " + ob.getJSONObject("Driver").get("nationality") +"\n" +
                                "Points: "  + ob.get("points") +"\n" +
                                "Position: " + ob.get("position");

                dataParsed = dataParsed + singleParsed + "\n\n";
                Log.d("testing", dataParsed);
            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.data.setText(this.dataParsed);
    }
}
