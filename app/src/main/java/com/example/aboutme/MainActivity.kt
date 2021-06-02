package com.example.aboutme

import android.annotation.SuppressLint
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private val  myName:MyName = MyName("Aleks Haecky")





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName





         //findViewById<Button>(R.id.done_button).setOnClickListener {
        // addNickname(it)
       //}
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

}

    private fun addNickname(view: View) {
       binding.apply {
           //nickname.text = binding.nicknameEdit.text
           myName?.nickname = nicknameEdit.text.toString()
           invalidateAll()
           nicknameEdit.visibility = View.GONE
           doneButton.visibility = View.GONE
           nicknameText.visibility = View.VISIBLE
       }

    //Hide the keyboard
    val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken,0)
}
}


