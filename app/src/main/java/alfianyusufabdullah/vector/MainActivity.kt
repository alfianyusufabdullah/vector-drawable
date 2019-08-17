package alfianyusufabdullah.vector

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceWithThis(MainFragment.createdInstance(R.drawable.dicoding_drawable))

        main_tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                if (p0?.position == 0) {
                    replaceWithThis(MainFragment.createdInstance(R.drawable.dicoding_drawable))
                } else {
                    replaceWithThis(MainFragment.createdInstance(R.drawable.dicoding_vector))
                }
            }
        })

    }

    fun replaceWithThis(fragment: Fragment) {
        supportFragmentManager.commit {
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            replace(R.id.main_container, fragment)
        }
    }
}


