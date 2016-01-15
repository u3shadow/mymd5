package com.globalroam.mymd5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText ed = (EditText)findViewById(R.id.et);

        final EditText ed1 = (EditText)findViewById(R.id.et1);
        final Button sendButton = (Button)findViewById(R.id.send);
        final Button copyButton = (Button)findViewById(R.id.copy);
        Button createButton = (Button)findViewById(R.id.create);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = ed.getText().toString()+"";
                s1 = md5.strMD5(s1);
                ed1.setText(s1);
                ClipboardManager cmb = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                cmb.setText(s1.trim());
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, s1);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = ed.getText().toString()+"";
                s1 = md5.strMD5(s1);
                ed1.setText(s1);
                ClipboardManager cmb = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                cmb.setText(s1.trim());
                Toast.makeText(MainActivity.this, "复制成功", Toast.LENGTH_SHORT).show();
            }
        });
        sendButton.setEnabled(false);
        copyButton.setEnabled(false);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = ed.getText().toString() + "";
                s1 = md5.strMD5(s1);
                ed1.setText(s1);
                sendButton.setEnabled(true);
                copyButton.setEnabled(true);
                Toast.makeText(MainActivity.this, "生成成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
