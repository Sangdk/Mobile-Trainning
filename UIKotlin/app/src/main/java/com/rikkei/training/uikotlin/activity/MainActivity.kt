package com.rikkei.training.uikotlin.activity

import android.content.Intent
import android.view.View
import com.rikkei.training.uikotlin.Adapter
import com.rikkei.training.uikotlin.R
import com.rikkei.training.uikotlin.base.BaseActivity
import com.rikkei.training.uikotlin.model.Image
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), View.OnClickListener {
    override fun initAct() {
        data = ArrayList()
        data!!.add(Image(R.drawable.ic_launcher_background))
        data!!.add(Image(R.drawable.ic_launcher_background))
        data!!.add(Image(R.drawable.ic_launcher_background))
        data!!.add(Image(R.drawable.ic_launcher_background))
        data!!.add(Image(R.drawable.ic_launcher_background))
        data!!.add(Image(R.drawable.ic_launcher_background))
        data!!.add(Image(R.drawable.ic_launcher_background))

        adapter = Adapter(data!!, this)
        recycler_linear!!.adapter = adapter
        recycler_grid!!.adapter = adapter
        recycler_staggered!!.adapter = adapter
        recycler_staggered!!.isNestedScrollingEnabled = false
        btn_actToolbar.setOnClickListener(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onClick(p0: View?) {
        var intent = Intent(this, ToolbarActivity::class.java)
        startActivity(intent)
    }

    private var adapter: Adapter? = null
    private var data: ArrayList<Image>? = null

}
