package org.bonnyfone.vectalignsamples;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.wnafee.vector.MorphButton;

public class ActivityMainActivity extends AppCompatActivity {

    private ViewGroup parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);
        parent = (ViewGroup) findViewById(R.id.base_view);

        //Default image
        handleMenu(R.id.action_droid_to_apple);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        handleMenu(item.getItemId());
        return true;
    }

    private void handleMenu(int id){
        switch (id){
            case R.id.action_github:
                final String url = "https://github.com/bonnyfone/vectalign";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;

            case R.id.action_droid_to_apple:
                swapView(createMorphableView(R.drawable.animated_vector_droid_for_apple, R.drawable.animated_vector_apple, Color.parseColor("#4CAF50")));
                break;

            case R.id.action_heart:
                swapView(createMorphableView(R.drawable.animated_vector_twitter, R.drawable.animated_vector_heart, Color.parseColor("#039BE5")));
                break;

            case R.id.action_cart_to_droid:
                swapView(createMorphableView(R.drawable.animated_vector_cart, R.drawable.animated_vector_droid_for_cart, Color.parseColor("#FF5252")));
                break;

            case R.id.action_icons:
                swapView(createMorphableView(R.drawable.animated_vector_icon_a, R.drawable.animated_vector_icon_b, Color.parseColor("#311B92")));
                break;

            case R.id.action_wifi_to_retwwet:
                swapView(createMorphableView(R.drawable.animated_vector_wifi, R.drawable.animated_vector_retweet, Color.parseColor("#607D8B")));
                break;

            case R.id.action_base:
                swapView(createMorphableView(R.drawable.strategy_base_animated_vector_drawable_start_to_end, R.drawable.strategy_base_animated_vector_drawable_end_to_start, Color.parseColor("#607D8B")));
                break;

            case R.id.action_linear:
                swapView(createMorphableView(R.drawable.strategy_linear_animated_vector_drawable_start_to_end, R.drawable.strategy_linear_animated_vector_drawable_end_to_start, Color.parseColor("#01579B")));
                break;

            case R.id.action_sub_base:
                swapView(createMorphableView(R.drawable.strategy_sub_base_animated_vector_drawable_start_to_end, R.drawable.strategy_sub_base_animated_vector_drawable_end_to_start, Color.parseColor("#558B2F")));
                break;

            case R.id.action_sub_linear:
                swapView(createMorphableView(R.drawable.strategy_sub_linear_animated_vector_drawable_start_to_end, R.drawable.strategy_sub_linear_animated_vector_drawable_end_to_start, Color.parseColor("#E65100")));
                break;

            // Add your test here!
            //case R.id.action_yout_morph:
            //    swapView(createMorphableView(R.drawable.vectalign_animated_vector_drawable_start_to_end, vectalign_animated_vector_drawable__end_to_start, Color.parseColor("#E65100")));
            //    break;
        }
    }

    private void swapView(View newView){
        View toRemove = parent.findViewById(R.id.morph_id);
        parent.removeView(toRemove);
        newView.setId(R.id.morph_id);
        parent.addView(newView, toRemove.getLayoutParams());
    }

    private View createMorphableView(int startDrawable, int endDrawable, int color){
        MorphButton mb = new MorphButton(this);
        mb.setForegroundTintList(ColorStateList.valueOf(color));
        mb.setForegroundTintMode(PorterDuff.Mode.MULTIPLY);
        mb.setBackgroundColor(Color.TRANSPARENT);
        mb.setStartDrawable(startDrawable);
        mb.setEndDrawable(endDrawable);
        mb.setState(MorphButton.MorphState.START);
        return  mb;
    }

}
