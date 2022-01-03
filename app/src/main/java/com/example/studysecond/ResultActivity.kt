package com.example.studysecond

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height",0)
        val weight = intent.getIntExtra("weight",0)

        Log.d("ResultActivity", "height : $height , weight : $weight")

        val bmi = weight / (height/100.0).pow(2.0)
        val resultText = when {
            bmi >=35.0 -> " 고도 비만 입니다 정신 차려요 닝겐 다이어트 ㄱㄱ"
            bmi >=30.0 -> "중정도 비만 입니다 식습관 조절 ㄱㄱ"
            bmi >= 25.0 -> "경도 비만 입니다 좀만 운동하면 돌아오겟군요"
            bmi >=23.0 -> "과체중 입니다 뭐 이럴때도 잇는거죠 좀만 조절해요"
            bmi >= 18.5 -> "정상체중이네요 하지만 자칫하면 훅 가시는거 아시죠?"
            else -> "저체중이에요 정신차려요 닝겐 영양섭취 ㄱㄱ"
        }

        val resultValueTextView = findViewById<TextView>(R.id.bmiResultTextView)
        val resultStringTextView = findViewById<TextView>(R.id.resultTextView)

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText
    }
}