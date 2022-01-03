package com.example.studysecond

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // 생성자 최상위
        super.onCreate(savedInstanceState)

        // 레이아웃을 보여준다는 뜻, R은 리소스 /
        setContentView(R.layout.activity_main)

        val heightEditText : EditText = findViewById(R.id.heightEditText)
        val weightEditText= findViewById<EditText>(R.id.weightEditText)

        val resultButton = findViewById<Button>(R.id.resultButton)

        resultButton.setOnClickListener {
            Log.d("MainActivity", "ResultButton Clicked")
            // 빈 값이면 if 문이 작동되여 return 한다
            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty())
            {
                Toast.makeText(this, " 비어 있는 값이 존재합니다", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // 빈 값이 아닐때
            val height: Int = heightEditText.text.toString().toInt()
            val weight : Int = weightEditText.text.toString().toInt()

            val intent = Intent(this,ResultActivity::class.java)

            intent.putExtra("height",height)
            intent.putExtra("weight",weight)

            startActivity(intent)
            Log.d("MainActivity", "height : $height weight : $weight")
        }


    }
}