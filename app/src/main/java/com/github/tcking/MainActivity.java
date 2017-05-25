package com.github.tcking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.github.tcking.viewquery.ViewQuery;

public class MainActivity extends AppCompatActivity {

    private ViewQuery $;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        $ = new ViewQuery(this);

        $.id(R.id.btn).clicked(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                $.id(R.id.tv).text("hello ViewQuery").textColor("#FF0000");
                $.id(R.id.btn).enabled(false).text("disabled").height(80,true);
            }
        }).view().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),$.id(R.id.tv).text(),Toast.LENGTH_SHORT).show();
                $.id(R.id.et).focus().showInputMethod(true);
            }
        },500);

        $.id(R.id.et).edit().addTextChangedListener(new ViewQuery.TextWatcher(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    $.id(R.id.tv).gone();
                } else {
                    $.id(R.id.tv).text(s).visible();
                    $.id(R.id.btn).enabled(true);
                }
            }
        });

    }
}
