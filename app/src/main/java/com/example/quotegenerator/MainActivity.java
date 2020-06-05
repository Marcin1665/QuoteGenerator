package com.example.quotegenerator;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView forMarcin;
    private TextView forJustyna;
    private TextView forEdyta;
    private Button generate;
    private Button marcin;
    private Button justyna;
    private Button edyta;
    private ArrayList<Quote> quoteArrayList;
    private int index;

    public void addToQuoteArrayList(String[] allQuotes, String[] allAuthors) {
        for (int i = 0; i < allQuotes.length - 1; i++) {
            String quote = allQuotes[i];
            String author = allAuthors[i];
            Quote newQuote = new Quote(quote, author);
            quoteArrayList.add(newQuote);
        }

    }

    public int getRandomQuote(int length) {
        return (int) (Math.random() * length) + 1;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        marcin = (Button) findViewById(R.id.marcin);
        justyna = (Button) findViewById(R.id.justyna);
        edyta = (Button) findViewById(R.id.edyta);

        forMarcin = (TextView) findViewById(R.id.forMarcin);
        forJustyna = (TextView) findViewById(R.id.forJustyna);
        forEdyta = (TextView) findViewById(R.id.forEdyta);


        Resources resources = getResources();
        String[] allQuotes = resources.getStringArray(R.array.quotes);
        String[] allAuthors = resources.getStringArray(R.array.authors);
        quoteArrayList = new ArrayList<>();

        addToQuoteArrayList(allQuotes, allAuthors);

        final int quotesLength = quoteArrayList.size();

        index = getRandomQuote(quotesLength - 1);

        marcin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = getRandomQuote(quotesLength - 1);
                forMarcin.setText(quoteArrayList.get(index).toString());
                if (forMarcin.getText() == forJustyna.getText() || forMarcin.getText() == forEdyta.getText()){
                    forMarcin.setText(quoteArrayList.get(index).toString());
                }
            }
        });
        justyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = getRandomQuote(quotesLength - 1);
                forJustyna.setText(quoteArrayList.get(index).toString());
                if (forMarcin.getText() == forJustyna.getText() || forJustyna.getText() == forEdyta.getText()){
                    forJustyna.setText(quoteArrayList.get(index).toString());
                }
            }
        });
        edyta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = getRandomQuote(quotesLength - 1);
                forEdyta.setText(quoteArrayList.get(index).toString());
                if (forEdyta.getText() == forJustyna.getText() || forMarcin.getText() == forEdyta.getText()){
                    forEdyta.setText(quoteArrayList.get(index).toString());
                }
            }
        });




    }
}
