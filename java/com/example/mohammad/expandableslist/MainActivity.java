package com.example.mohammad.expandableslist;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout container;
    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<ArrayList<String>> sub_titles = new ArrayList<>();
    private Typeface typeface;

    private String TITLE_COLOR = "#000000";
    private int TITLE_FONT_SIZE = 20;
    private int TITLE_PADDING_LEFT = 25;
    private int TITLE_PADDING_TOP = 12;
    private int TITLE_PADDING_RIGHT = 45;
    private int TITLE_PADDING_BOTTOM = 12;
    private boolean TITLE_CLICKABLE = true;

    private String SUB_TITLE_COLOR = "#000000";
    private int SUB_TITLE_FONT_SIZE = 30;
    private int SUB_TITLE_PADDING_LEFT = 25;
    private int SUB_TITLE_PADDING_TOP = 12;
    private int SUB_TITLE_PADDING_RIGHT = 90;
    private int SUB_TITLE_PADDING_BOTTOM = 12;
    private boolean SUB_TITLE_CLICKABLE = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.container);
        typeface = Typeface.createFromAsset(getAssets(), "font/iransans.ttf");
        prepareData();


        for (int j = 0; j < titles.size(); j++) {
            TextView title = new TextView(MainActivity.this);
            title.setText(titles.get(j));
            title.setTextColor(Color.parseColor(TITLE_COLOR));
            title.setGravity(Gravity.RIGHT);
            title.setTextSize(TITLE_FONT_SIZE);
            title.setTypeface(typeface);
            title.setPadding(TITLE_PADDING_LEFT, TITLE_PADDING_TOP, TITLE_PADDING_RIGHT, TITLE_PADDING_BOTTOM);
            title.setBackgroundResource(R.drawable.expandable_list_mgh_title_style);
            title.setClickable(TITLE_CLICKABLE);
            container.addView(title);

            final LinearLayout sub_title_linear_layout = new LinearLayout(MainActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.gravity = Gravity.RIGHT;
            sub_title_linear_layout.setOrientation(LinearLayout.VERTICAL);
            sub_title_linear_layout.setVisibility(View.GONE);

            ArrayList<String> tmp = sub_titles.get(j);
            for (int i = 0; i < tmp.size(); i++) {
                TextView textView = new TextView(MainActivity.this);
                textView.setTextColor(Color.parseColor(SUB_TITLE_COLOR));
                textView.setGravity(Gravity.RIGHT);
                textView.setPadding(SUB_TITLE_PADDING_LEFT, SUB_TITLE_PADDING_TOP, SUB_TITLE_PADDING_RIGHT, SUB_TITLE_PADDING_BOTTOM);
                textView.setTypeface(typeface);
                textView.setText(tmp.get(i));
                sub_title_linear_layout.addView(textView);
            }
            container.addView(sub_title_linear_layout, params);


            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (sub_title_linear_layout.getVisibility() == View.VISIBLE)
                        sub_title_linear_layout.setVisibility(View.GONE);
                    else
                        sub_title_linear_layout.setVisibility(View.VISIBLE);
                }
            });

            View divider = new View(MainActivity.this);
            divider.setBackgroundColor(Color.parseColor("#dddddd"));
            container.addView(divider, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1));
        }

    }


    private void prepareData() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("->یک");
        arrayList.add("->دو");
        arrayList.add("->سه");
        arrayList.add("->چهار");
        titles.add("یک");
        titles.add("دو");
        titles.add("سه");
        titles.add("چهار");
        titles.add("پنج");
        titles.add("شش");
        titles.add("هفت");
        titles.add("هشت");
        titles.add("نه");
        titles.add("ده");

        sub_titles.add(arrayList);
        sub_titles.add(arrayList);
        sub_titles.add(arrayList);
        sub_titles.add(arrayList);
        sub_titles.add(arrayList);
        sub_titles.add(arrayList);
        sub_titles.add(arrayList);
        sub_titles.add(arrayList);
        sub_titles.add(arrayList);
        sub_titles.add(arrayList);


    }
}
