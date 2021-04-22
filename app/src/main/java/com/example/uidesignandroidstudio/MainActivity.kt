package com.example.uidesignandroidstudio

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TableLayout
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.uidesignandroidstudio.fragments.*
import com.example.uidesignandroidstudio.resources.Contributors
import com.example.uidesignandroidstudio.resources.DebitCards
import com.google.android.material.bottomnavigation.BottomNavigationView
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {

    val CHANNEL_ID = "ID"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val btn = findViewById<ImageView>(R.id.btn)

        createNotificationChannel()

        btn.setOnClickListener{
            myNotification()
        }


        /**
         * INSTANTIATE EACH FRAGMENTS
         * */
        val productsFragment = ProductsFragment()
        val supportFragment = SupportFragment()
        val paymentsFragment = PaymentsFragment()
        val moreFragment = MoreFragment()
        val historyFragment = HistoryFragment()

        /**
         * CALL THE CURRENTFRAGMENT METHOD
         * */
        currentFragment(productsFragment)

        /**
         * BOTTOM NAVIGATION
         * */
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_products -> currentFragment(productsFragment)
                R.id.ic_support -> currentFragment(supportFragment)
                R.id.ic_payments -> currentFragment(paymentsFragment)
                R.id.ic_more -> currentFragment(moreFragment)
                R.id.ic_history -> currentFragment(historyFragment)
            }
            true
        }

    }

    /**
     * NOTIFICATION
     * */

    fun myNotification(){
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            putExtra("MESSAGE", "ACTIVE")
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)


        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
            .setContentTitle("My notification")
            .setContentText("This notification is from my assignment on monday!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        with(NotificationManagerCompat.from(this)) {
            notify( 0, builder.build())
        }

    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = "this is a description"
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    /***/

    /**
     * DISPLAYS THE CURRENT FRAGMENT
     * */
    private fun currentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame, fragment)
            commit()
        }
    }


