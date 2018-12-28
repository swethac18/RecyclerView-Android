package swetha.samplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ArrayList<String> mImages = new ArrayList<String>();
    private ArrayList<String> mTexts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"Inside-onCreate");
        prepareImageBitmaps();
    }

    private void prepareImageBitmaps(){
        Log.d(TAG,"inside-prepareImages");

        mImages.add("https://i.imgur.com/ZcLLrkY.jpg");
        mTexts.add("Washington");

        mImages.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mTexts.add("Havasu Falls");

        mImages.add("https://i.redd.it/j6myfqglup501.jpg");
        mTexts.add("Rocky Mountain National Park");

        mImages.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mTexts.add("Portugal");

        mImages.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mTexts.add("Trondheim");

        mImages.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mTexts.add("Mahahual");

        mImages.add("https://i.redd.it/k98uzl68eh501.jpg");
        mTexts.add("Frozen Lake");


        mImages.add("https://i.redd.it/glin0nwndo501.jpg");
        mTexts.add("White Sands Desert");

        mImages.add("https://i.redd.it/obx4zydshg601.jpg");
        mTexts.add("Austrailia");
        setRecyclerView();
    }

    private void setRecyclerView(){
        Log.d(TAG,"inside-setRecyclerView");
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ListAdapter listAdapter = new ListAdapter(mTexts,mImages,MainActivity.this);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}
