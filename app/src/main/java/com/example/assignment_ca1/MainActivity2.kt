package com.example.assignment_ca1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.setTitle("ToolBar")
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Home Page", Toast.LENGTH_LONG).show()
        }

        val btnToast = findViewById<Button>(R.id.btnToast)
        btnToast.setOnClickListener {
            val vg: ViewGroup? = findViewById(R.id.custom_toast)
            val inflater = layoutInflater
            val layout: View = inflater.inflate(R.layout.custom_toast_layout, vg)
            val tv = layout.findViewById<TextView>(R.id.txtVw)
            tv.text = "Thank you for Visiting Our Page Have a Good Day!!"

            val toast = Toast(applicationContext)

            toast.setGravity(Gravity.FILL, 0, 0)
            toast.duration = Toast.LENGTH_SHORT
            toast.setView(layout)
            toast.show()
        }
        val simpleRatingBar = findViewById<RatingBar>(R.id.simpleRatingBar)
        val simpleRating = findViewById<RatingBar>(R.id.simpleRating)

        simpleRatingBar.setOnRatingBarChangeListener{ ratingBar, rating, fromUser ->
            Toast.makeText(this, "Product Quality Rating $rating",
                Toast.LENGTH_LONG).show()
        }

        simpleRating.setOnRatingBarChangeListener{ ratingBar, rating, fromUser ->
            Toast.makeText(this, "Price Rating $rating",
                Toast.LENGTH_LONG).show()
        }

    }
    private fun setSupportActionBar(toolbar: Toolbar?) {
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id:Int = item.itemId
        if(id==R.id.action_settings)
        {

            Toast.makeText(applicationContext, "Settings Menu", Toast.LENGTH_LONG).show()
            return true
        }
        else if(id==R.id.alarm) {
            val intent = Intent(this, Alarm_Manager::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext, "Alarm Manager", Toast.LENGTH_LONG).show()
            return true
        }
        else if(id == R.id.action_email)
        {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://gmail.com/"))
            startActivity(intent)
            Toast.makeText(applicationContext, "Email", Toast.LENGTH_LONG).show()
            return true
        }
        else if (id == R.id.action_search)
        {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.google.com/"))
            startActivity(intent)
            Toast.makeText(applicationContext, "User", Toast.LENGTH_LONG).show()
            return true
        }
        else if (id == R.id.notification)
        {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext, "Notification", Toast.LENGTH_LONG).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}