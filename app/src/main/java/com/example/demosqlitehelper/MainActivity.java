package com.example.demosqlitehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestThread tt = new TestThread();
        tt.start();
    }

    class TestThread extends Thread {
        @Override
        public void run() {
            super.run();

            DatabaseConnector dbConnector = new DatabaseConnector(MainActivity.this);

            dbConnector.insert("Felix Karapetyan", 345000);
            dbConnector.insert("Ruben Danielyan", 645000);

            List<Employee> employees = dbConnector.selectAll();
            employees.forEach(employee -> {
                Log.i("UWC", employee.getName());
            });
        }
    }
}