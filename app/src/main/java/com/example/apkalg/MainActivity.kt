package com.example.apkalg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var stek =  Stack<Int>();
        findViewById<TextView>(R.id.textlbl).text = stek.toString();

        findViewById<Button>(R.id.pushbtn).setOnClickListener {
            var nowy = findViewById<EditText>(R.id.edit1).text.toString().toInt();
            stek.push(nowy);
            findViewById<TextView>(R.id.textlbl).text = stek.toString();
        }
        findViewById<Button>(R.id.popbtn).setOnClickListener {
            if(stek.isEmpty())
            {
                findViewById<TextView>(R.id.textlbl).text = "Stack is Empty!";
            }
            else
            {
                stek.pop();
                findViewById<TextView>(R.id.textlbl).text = stek.toString();
            }

        }
        findViewById<Button>(R.id.emptybtn).setOnClickListener {
            val isempty: Boolean = stek.isEmpty();
            findViewById<TextView>(R.id.textlbl).text = "Stack is empty: " + isempty.toString();
        }
    }
}