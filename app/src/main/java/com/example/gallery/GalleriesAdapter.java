package com.example.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.http.POST;

public class GalleriesAdapter extends RecyclerView.Adapter<GalleriesAdapter.GalleryViewHolder> {

    Context mCtx;
    List<POST> galleryList;

    public GalleriesAdapter(Context mCtx, List<POST> galleryList) {
        this.mCtx = mCtx;
        this.galleryList = galleryList;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        Gallery gallery = (Gallery) galleryList.get(position);

        Glide.with(mCtx)
                .load(gallery.getUrl_s())
                .into(holder.mUrl_s);

        holder.mTitle.setText(gallery.getTitle());
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {

        ImageView mUrl_s;
        TextView mTitle;

        public GalleryViewHolder(View itemView) {
            super(itemView);

            mUrl_s = itemView.findViewById(R.id.imageView);
            mTitle = itemView.findViewById(R.id.textView);
        }
    }

}
