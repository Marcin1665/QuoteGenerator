package com.example.quotegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public TextView quotes_textview;
    public Button generate;
    public Button share;
    public ArrayList<Quote> quoteArrayList;
    public int index;

    public void addToQuoteArrayList(String[] allQuotes, String[] allAuthors) {
        for(int i = 0;i <allQuotes.length - 1;i++){
            String quote = allQuotes[i];
            String author = allAuthors[i];
            Quote newQuote = new Quote(quote, author);
            quoteArrayList.add(newQuote);
        }

    }

    public int getRandomQuote(int length){
        return (int) (Math.random() * length) + 1;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quotes_textview = (TextView) findViewById(R.id.quotes_textview);
        generate = (Button) findViewById(R.id.generate);
        share = (Button) findViewById(R.id.share);

        Resources resources = getResources();
        String[] allQuotes = resources.getStringArray(R.array.quotes);
        String[] allAuthors = resources.getStringArray(R.array.authors);
        quoteArrayList = new ArrayList<>();;
        addToQuoteArrayList(allQuotes, allAuthors);

        final int quotesLength = quoteArrayList.size();

        index = getRandomQuote(quotesLength - 1);

        quotes_textview.setText(quoteArrayList.get(index).toString());

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = getRandomQuote(quotesLength - 1);
                quotes_textview.setText(quoteArrayList.get(index).toString());
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, quoteArrayList.get(index).toString());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

            }
        });



    }
}
