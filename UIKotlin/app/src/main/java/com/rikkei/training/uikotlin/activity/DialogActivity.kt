package com.rikkei.training.uikotlin.activity

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import com.rikkei.training.ui.dialog.EraseDialogFragment
import com.rikkei.training.uikotlin.R
import com.rikkei.training.uikotlin.base.BaseActivity
import com.rikkei.training.uikotlin.dialog.BrightnessDialogFragment
import com.rikkei.training.uikotlin.dialog.MultiChoiceDialog
import com.rikkei.training.uikotlin.dialog.NumberPickerDialog
import kotlinx.android.synthetic.main.activity_dialog.*
import java.util.*

class DialogActivity : BaseActivity(), View.OnClickListener, (TimePicker, Int, Int) -> Unit {
    override fun invoke(p1: TimePicker, p2: Int, p3: Int) {
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btn_brightness -> showBrightnessDialog()
            R.id.btn_erase -> showEraseDialog()
            R.id.btn_multi_choice -> showMultiChoiceDialog()
            R.id.btn_picker_dialog -> showNumberPickerDialog()
            R.id.btn_time_picker -> createTimePickerDialog()
            R.id.btn_date_picker -> createDatePickerDialog()
        }
    }

    private fun showNumberPickerDialog() {
        mNumberPickerDialog = NumberPickerDialog(this)
        mNumberPickerDialog!!.show(supportFragmentManager, "show Dialog")
    }

    private fun showMultiChoiceDialog() {
        mMultiChoiceDialog = MultiChoiceDialog(this)
        mMultiChoiceDialog!!.show(supportFragmentManager, "show Dialog")
    }

    private fun showEraseDialog() {
        mEraseDialogFragment = EraseDialogFragment(this)
        mEraseDialogFragment!!.show(supportFragmentManager, "show Dialog")
    }

    private fun showBrightnessDialog() {
        mBrightnessDialog = BrightnessDialogFragment(this)
        mBrightnessDialog!!.show(supportFragmentManager, "show Dialog")
    }

    private fun createTimePickerDialog() {
        var mCurrentTime: Calendar = Calendar.getInstance()
        var hour: Int = mCurrentTime.get(Calendar.HOUR_OF_DAY)
        var minute: Int = mCurrentTime.get(Calendar.MINUTE)
        mTimePicker = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { _, i, i1 ->
                Toast.makeText(
                    this,
                    "$i" + "h" + " : " + "$i1" + "m", Toast.LENGTH_SHORT
                ).show()
            },
            hour, minute, true
        )
        mTimePicker!!.show()
    }

    private fun createDatePickerDialog() {
        val mCurrentTime = Calendar.getInstance()
        val year = mCurrentTime.get(Calendar.YEAR)
        val month = mCurrentTime.get(Calendar.MONTH)
        val day = mCurrentTime.get(Calendar.DAY_OF_MONTH)
        mDatePicker = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, i, i1, i2 ->
                Toast.makeText(
                    this@DialogActivity,
                    "$i2, $i1, $i", Toast.LENGTH_SHORT
                ).show()
            }, year, month, day
        )
        mDatePicker!!.show()
    }

    private var mBrightnessDialog: BrightnessDialogFragment? = null
    private var mEraseDialogFragment: EraseDialogFragment? = null
    private var mMultiChoiceDialog: MultiChoiceDialog? = null
    private var mNumberPickerDialog: NumberPickerDialog? = null
    private var mTimePicker: TimePickerDialog? = null
    private var mDatePicker: DatePickerDialog? = null
    override fun initAct() {
        btn_brightness.setOnClickListener(this)
        btn_erase.setOnClickListener(this)
        btn_multi_choice.setOnClickListener(this)
        btn_picker_dialog.setOnClickListener(this)
        btn_time_picker.setOnClickListener(this)
        btn_date_picker.setOnClickListener(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_dialog
    }
}