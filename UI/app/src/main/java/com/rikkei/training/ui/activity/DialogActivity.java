package com.rikkei.training.ui.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.rikkei.training.ui.R;
import com.rikkei.training.ui.base.BaseActivity;
import com.rikkei.training.ui.databinding.ActivityDialogBinding;
import com.rikkei.training.ui.dialog.BrightnessDialogFragment;
import com.rikkei.training.ui.dialog.EraseDialogFragment;
import com.rikkei.training.ui.dialog.MultiChoiceDialog;
import com.rikkei.training.ui.dialog.NumberPickerDialog;

import java.util.Calendar;


public class DialogActivity extends BaseActivity<ActivityDialogBinding> implements View.OnClickListener {
    private BrightnessDialogFragment mBrightnessDialog;
    private EraseDialogFragment mEraseDialog;
    private MultiChoiceDialog mMultiChoiceDialog;
    private NumberPickerDialog mNumberPickerDialog;
    private TimePickerDialog mTimePicker;
    private DatePickerDialog mDatePicker;


    @Override
    protected void initAct() {
        binding.btnBrightness.setOnClickListener(this);
        binding.btnErase.setOnClickListener(this);
        binding.btnMultiChoice.setOnClickListener(this);
        binding.btnPickerDialog.setOnClickListener(this);
        binding.btnTimePicker.setOnClickListener(this);
        binding.btnDatePicker.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dialog;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_brightness:
                mBrightnessDialog = new BrightnessDialogFragment(this);
                mBrightnessDialog.show(getSupportFragmentManager(), "show Dialog");
                break;
            case R.id.btn_erase:
                mEraseDialog = new EraseDialogFragment(this);
                mEraseDialog.show(getSupportFragmentManager(), "show Dialog");
                break;
            case R.id.btn_multi_choice:
                mMultiChoiceDialog = new MultiChoiceDialog(this);
                mMultiChoiceDialog.show(getSupportFragmentManager(), "show Dialog");
                break;
            case R.id.btn_picker_dialog:
                mNumberPickerDialog = new NumberPickerDialog(this);
                mNumberPickerDialog.show(getSupportFragmentManager(), "show Dialog");
                break;
            case R.id.btn_time_picker:
                createTimePickerDialog();
                break;
            case R.id.btn_date_picker:
                createDatePickerDialog();
                break;
        }
    }
    private void createTimePickerDialog(){
        Calendar mCurrentTime = Calendar.getInstance();
        int hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mCurrentTime.get(Calendar.MINUTE);
        mTimePicker = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        Toast.makeText(DialogActivity.this,i+"h : "+i1+"m",Toast.LENGTH_SHORT).show();
                    }
                }, hour, minute, true
        );
        mTimePicker.show();
    }

    private void createDatePickerDialog(){
        Calendar mCurrentTime = Calendar.getInstance();
        int year = mCurrentTime.get(Calendar.YEAR);
        int month = mCurrentTime.get(Calendar.MONTH);
        int day = mCurrentTime.get(Calendar.DAY_OF_MONTH);
        mDatePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(DialogActivity.this,i2+", "+i1+", "+i,Toast.LENGTH_SHORT).show();
            }
        },year,month,day);
        mDatePicker.show();
    }
}
