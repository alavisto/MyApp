package com.example.alen_sl.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import com.example.alen_sl.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    boolean isPaused = false;
    TextView status;
    EditText editTextName;

    TextView statusAge;
    EditText editTextAge;
    RadioButton radioMale;
    RadioButton radioFemale;
    CheckBox checkBox;
    Switch switch1;
    TextView textViewGender;
    GenderPerson person;
    Set<GenderPerson> uniquePersons;
    Map<String, GenderPerson> namedPersons;
    List<GenderPerson> listOfPersons;



    public void buttonClicked(View button) {
        if (isPaused) {
            ((Button) button).setText("play");
            isPaused = false;
        } else {
            ((Button) button).setText("pause");
            isPaused = true;
        }
        status.setText(String.valueOf(isPaused));
    }

    public void okClicked(View view){
        if (editTextName.length() != 0){
            status.setText("Name: " + editTextName.getText());
            person.setName(editTextName.getText().toString());
        }
        if (editTextAge.length() != 0){
            int age = Integer.parseInt(editTextAge.getText().toString());
            person.setAge(age);
            if (age > 12){
                statusAge.setText("too old");
            }else {
                statusAge.setText("too young");
            }
        }
        if (!radioMale.isChecked() && !radioFemale.isChecked())
            Toast.makeText(this, "enter your gender", Toast.LENGTH_SHORT).show();
        else {
            if (radioMale.isChecked()) {
                textViewGender.setText("Gender: Male");
                person.setGender(1);
            }
            else if (radioFemale.isChecked()) {
                textViewGender.setText("Gender: Female");
                person.setGender(2);
            }
        }
        Toast.makeText(this, person.getName() + " " + person.getGender() + " " + person.getAge(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = (TextView) findViewById(R.id.textView);
        editTextName = (EditText) findViewById(R.id.editTextName);
        statusAge = (TextView) findViewById(R.id.textViewAge);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        radioMale = (RadioButton) findViewById(R.id.radioMale);
        radioFemale = (RadioButton) findViewById(R.id.radioFemale);
        textViewGender = (TextView) findViewById(R.id.textViewGender);
        person = new GenderPerson();
        namedPersons = new HashMap<>();
        listOfPersons = new ArrayList<>();
        uniquePersons = new HashSet<>();
        Random random = new Random();
        namedPersons = new HashMap<>();
        listOfPersons = new ArrayList<>();
        uniquePersons = new HashSet<>();
        for (int i = 0; i < 20; i++){
            listOfPersons.add(
                    new GenderPerson(
                            random.nextInt(1),
                            random.nextInt(1),
                            String.valueOf(random.nextInt(5))
                    )
            );
        }

        for (int i = 0; i < listOfPersons.size(); i++){
            uniquePersons.add(listOfPersons.get(i));
            namedPersons.put(listOfPersons.get(i).getName(), listOfPersons.get(i));
        }
        person = new GenderPerson(1, 123, "Alen");
        uniquePersons.add(person);
        namedPersons.put(person.getName(), person);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private class Person{
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public Person() {

        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    enum genderTypes {
        MALE, FEMALE
    }


    private class GenderPerson extends Person{
        private int gender;

        public GenderPerson(int gender) {
            this.gender = gender;
        }

        public GenderPerson(int gender, int age, String name) {
            super(age, name);
            this.gender = gender;

        }


        public GenderPerson() {
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }
    }
}


