package com.inkenka.devdemos.SpannableString;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.inkenka.devdemos.R;
import com.inkenka.devdemos.utils.Utils;

public class SpannableStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spannable_string_demo);

        TextView textView = (TextView) findViewById(R.id.tv_content);

        SpannableStringBuilder sb = new SpannableStringBuilder();

        sb.append("  "); // 占位
        Drawable drawable = getResources().getDrawable(R.drawable.ic_question);
        drawable.setBounds(0, 0, Utils.covertDp2Px(this, 12), Utils.covertDp2Px(this, 12));   // 关键这句，没有就显示不了
        sb.setSpan(new VerticalImageSpan(drawable), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        sb.append("Hello World!");

        sb.append("  "); // 占位
        drawable = getResources().getDrawable(R.drawable.ic_arrow);
        drawable.setBounds(0, 0, Utils.covertDp2Px(this, 8), Utils.covertDp2Px(this, 8));    // 关键这句，没有就显示不了
        sb.setSpan(new VerticalImageSpan(drawable), sb.length()-1, sb.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(sb);
    }

}
