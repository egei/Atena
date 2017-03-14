package com.atena.atenatest;

import android.content.Context;
import android.database.Observable;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.atena.atenatest.api.FlickrController;
import com.atena.atenatest.data.FlickrAdapter;
import com.atena.atenatest.data.FlickrBase;
import com.atena.atenatest.data.FlickrResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button searchButton;
    EditText searchText;
    Context myContext;
    ListView photoList;
    ArrayList<FlickrBase> photoData;
    FlickrAdapter flickrAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchButton = (Button)findViewById(R.id.search_button);
        searchText = (EditText) findViewById(R.id.search_string);
        photoList = (ListView) findViewById(R.id.photo_list);
        myContext = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search_value = searchText.getText().toString();
                if (search_value.isEmpty()) {
                    Toast.makeText(myContext,R.string.search_no_value, Toast.LENGTH_SHORT).show();
                } else {
                    FlickrController flickrController = new FlickrController();
                    flickrController.start();
                    Call<FlickrResult> call = flickrController.getFlickrResult(search_value);
                    call.enqueue(new Callback<FlickrResult>() {
                        @Override
                        public void onResponse(Call<FlickrResult> call, Response<FlickrResult> response) {
                            int statusCode = response.code();
                            FlickrResult user = response.body();
                            photoData = user.getFlickArray();
                            if (flickrAdapter == null) {
                                flickrAdapter = new FlickrAdapter(myContext, photoData);
                                photoList.setAdapter(flickrAdapter);
                            }
                            flickrAdapter.notifyDataSetChanged();
                            Log.d("***EGG****", "Response:" + user.toString());
                        }

                        @Override
                        public void onFailure(Call<FlickrResult> call, Throwable t) {
                            Log.d("***EGG***", "Error on call to Flickr:" + t.toString());
                            // Log error here since request failed
                        }
                    });
                     flickrController.getFlickrResult(search_value);

                }
            }
        });
        photoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
