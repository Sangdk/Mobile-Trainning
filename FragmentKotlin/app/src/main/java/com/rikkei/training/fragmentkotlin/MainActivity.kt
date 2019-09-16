package com.rikkei.training.fragmentkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.rikkei.training.fragmentkotlin.fragment.AFragment
import com.rikkei.training.fragmentkotlin.fragment.BFragment

class MainActivity : AppCompatActivity() {
    private var mFragA: AFragment = AFragment()
    private var mFragB: BFragment = BFragment()
    private val mISRUNNING_KEY = "isRunning"

    override fun onCreate(outState: Bundle?) {
        super.onCreate(outState)
        setContentView(R.layout.activity_main)
        if (outState == null) {
            addFragment(mFragA)
        }
    }

    fun addFragment(mFrag: Fragment) {
        var transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (mFrag == mFragA) {
            transaction.remove(mFragB)
        } else {
            transaction.remove(mFragA)
        }
        transaction.setCustomAnimations(
            android.R.anim.slide_in_left,
            android.R.anim.slide_out_right
        )
        transaction.add(R.id.panel, mFrag)
        transaction.addToBackStack("add")
        transaction.commit()
    }

    fun getFragA(): Fragment {
        return mFragA
    }

    fun getFragB(): Fragment {
        return mFragB
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(mISRUNNING_KEY, true)
    }

}
