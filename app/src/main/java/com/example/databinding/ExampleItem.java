package com.example.databinding;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ExampleItem {
    String image;
    String creator;
    String likes;

    public ExampleItem(String image, String creator, String likes) {
        this.image = image;
        this.creator = creator;
        this.likes = likes;
    }

    public String getImage() {
        return image;
    }

    public String getCreator() {
        return creator;
    }

    public String getLikes() {
        return likes;
    }

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(View view, String image) {

        ImageView imageView = (ImageView) view;
        Picasso.get().load(image).fit().centerCrop().into(imageView);
    }


}
