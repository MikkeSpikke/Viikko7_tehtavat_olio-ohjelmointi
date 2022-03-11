package com.example.helloust;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {

    String teksti;
    EditText nameInput;
    Button submitButton;

    TextView outputField;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        outputField = findViewById(R.id.textView);

        //harskeilya
        nameInput = (EditText) findViewById(R.id.nameInput);

        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teksti = nameInput.getText().toString();
                outputField.setText(teksti);
            }
        });


    }

    public void buttonPress (View w) {
        System.out.println("Hello World!");
        outputField.setText("Hello World!");
    }









    public void nappiWrite(View w) {
        System.out.println("Kirjoittaa...");
        writeFile();
    }

    public void nappiRead(View w) {
        System.out.println("Lukee...");
        readFile();

    }

    public void writeFile() {

        try {
            OutputStreamWriter osw = null;
            String s = "Hello this should be in the text file bingbong";
            osw = new OutputStreamWriter(context.openFileOutput("test.txt",Context.MODE_PRIVATE));
            osw.write(s);
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFile() {
        String output = "";
        try {
            InputStream ins = context.openFileInput("test.txt");
            BufferedReader br =  new BufferedReader(new InputStreamReader(ins));
            System.out.println("Reading the file");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            ins.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}