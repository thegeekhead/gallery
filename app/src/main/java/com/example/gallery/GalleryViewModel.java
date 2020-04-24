package com.example.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class GalleryViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<POST>> galleryList;

    //we will call this method to get the data
    public LiveData<List<POST>> getPost() {
        //if the list is null
        if (galleryList == null) {
            galleryList = new MutableLiveData<>();
            //we will load it asynchronously from server in this method
            loadPost();
        }

        //finally we will return the list
        return galleryList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadPost() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.flickr.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FlickerInterface flickerInterface = retrofit.create(FlickerInterface.class);
        Call<List<POST>> call = flickerInterface.getPost();


        call.enqueue(new Callback<List<POST>>() {
            @Override
            public void onResponse(Call<List<POST>> call, Response<List<POST>> response) {
                galleryList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<POST>> call, Throwable t) {

            }
        });


    }

}
