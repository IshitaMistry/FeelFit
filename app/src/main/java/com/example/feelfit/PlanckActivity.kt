package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.feelfit.databinding.ActivityPlanckBinding

class PlanckActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlanckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPlanckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.planckBtn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,StopwatchActivity::class.java))
        })
    }
}