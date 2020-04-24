package com.example.gallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GalleriesAdapter adapter;

    List<POST> galleryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        GalleryViewModel model =new GalleryViewModel();

        model.getPost().observe(this, new Observer<List<POST>>() {
            @Override
            public void onChanged(@Nullable List<POST> galleryList) {
                adapter = new GalleriesAdapter(MainActivity.this, galleryList);
                recyclerView.setAdapter(adapter);
            }
        });

    }
}
