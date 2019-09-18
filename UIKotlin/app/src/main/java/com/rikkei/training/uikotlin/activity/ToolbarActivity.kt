package com.rikkei.training.uikotlin.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.Menu
import android.view.MenuItem
import androidx.palette.graphics.Palette
import com.google.android.material.appbar.AppBarLayout
import com.rikkei.training.uikotlin.Adapter
import com.rikkei.training.uikotlin.R
import com.rikkei.training.uikotlin.base.BaseActivity
import com.rikkei.training.uikotlin.model.Image
import kotlinx.android.synthetic.main.activity_toolbar.*
import kotlin.math.abs

class ToolbarActivity : BaseActivity() {
    private var mAdapter: Adapter? = null
    private var data: ArrayList<Image>? = null
    private var mAppBarExpanded: Boolean? = true
    private var mCollapseMenu: Menu? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_toolbar
    }

    override fun initAct() {
        data = ArrayList()
        data!!.add(Image(R.drawable.image))
        data!!.add(Image(R.drawable.image))
        data!!.add(Image(R.drawable.image))
        data!!.add(Image(R.drawable.image))
        data!!.add(Image(R.drawable.image))
        data!!.add(Image(R.drawable.image))
        mAdapter = Adapter(data!!, this)
        recycler.adapter = mAdapter

        appbar.addOnOffsetChangedListener(AppBarLayout
            .OnOffsetChangedListener { _,
                                       verticalOffset ->
                if (abs(verticalOffset) > 200) {
                    mAppBarExpanded = false
                    invalidateOptionsMenu()
                } else {
                    mAppBarExpanded = true
                    invalidateOptionsMenu()
                }
            }
        )
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
        var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.bg_header)
        Palette.from(bitmap)
            .generate { palette ->
                var vibrantColor: Int =
                    palette!!.getVibrantColor(resources.getColor(R.color.primary_500))
                collapsing_toolbar.setContentScrimColor(vibrantColor)
                collapsing_toolbar.setStatusBarScrimColor(resources.getColor(R.color.black_trans80))
            }
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (mCollapseMenu != null && (!mAppBarExpanded!! || mCollapseMenu!!.size() != 1)) {
            mCollapseMenu!!.add("Add")
                .setIcon(R.drawable.ic_fab_add)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        }

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_show_dialog -> showActDialog()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun showActDialog() {
        var intent = Intent(this,DialogActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        mCollapseMenu = menu
        return true
    }
}