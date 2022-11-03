package com.example.apkalg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
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
                findViewById<TextView>(R.id.text2lbl).text = "Element deleted: " + stek.lastElement().toString();
                stek.pop();
                findViewById<TextView>(R.id.textlbl).text = stek.toString();
            }

        }
        findViewById<Button>(R.id.emptybtn).setOnClickListener {
            findViewById<TextView>(R.id.textlbl).text = "Stack is empty: " + stek.isEmpty();
        }
        findViewById<Button>(R.id.sizebtn).setOnClickListener {
            findViewById<TextView>(R.id.textlbl).text = "Size: " + stek.size.toString();
        }

        //KOLEJKA MF

        val kolejka: Queue<Int> = LinkedList<Int>();
        val butt_dodaj_do_kolejki = findViewById<Button>(R.id.dodaj_kolejka);
        val butt_usun_z_kolejki = findViewById<Button>(R.id.usun_kolejka);
        val butt_pierw_i_ost_w_kolejce = findViewById<Button>(R.id.kto_w_kolejce);
        val txt_ile_w_kolejce = findViewById<TextView>(R.id.ile_w_kolejce);
        val txt_pierwszy_w_kolejce = findViewById<TextView>(R.id.pierwszy_w_kolejce);
        val txt_ostatni_w_kolejce = findViewById<TextView>(R.id.ostatni_w_kolejce);
        val length = Toast.LENGTH_SHORT;
        var numer = 1;
        var ilosc_osob_w_kolejce = 0;

        butt_dodaj_do_kolejki.setOnClickListener {
            Toast.makeText(applicationContext, "Twój numer to: " + numer, length).show();
            kolejka.add(numer);
            numer += 1;
            ilosc_osob_w_kolejce += 1;
            txt_ile_w_kolejce.text = ilosc_osob_w_kolejce.toString();
        }

        butt_usun_z_kolejki.setOnClickListener {
            if (!kolejka.isEmpty()) {
                Toast.makeText(applicationContext, "Usunieto numer: " + kolejka.element() + " z kolejki", length).show()
                kolejka.remove();
                ilosc_osob_w_kolejce -= 1;
                txt_ile_w_kolejce.text = ilosc_osob_w_kolejce.toString();
            }
            else {
                Toast.makeText(applicationContext, "Brak osob w kolejce", length).show();
            }
        }

        butt_pierw_i_ost_w_kolejce.setOnClickListener {
            if(!kolejka.isEmpty()) {
                val pierw = kolejka.element();
                val ost = kolejka.last();
                txt_pierwszy_w_kolejce.text = pierw.toString();
                txt_ostatni_w_kolejce.text = ost.toString();
            }
            else {
                Toast.makeText(applicationContext, "Brak osob w kolejce", length).show();
                txt_pierwszy_w_kolejce.text = "Brak osob w kolejce";
                txt_ostatni_w_kolejce.text = "Brak osob w kolejce";
            }
        }
    }
}