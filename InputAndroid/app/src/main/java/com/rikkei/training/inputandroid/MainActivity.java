package com.rikkei.training.inputandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.rikkei.training.inputandroid.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Key keyFocus;
    private ArrayList<TextView> arrText = new ArrayList<>();

    private ArrayList<Key> arrKey = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initAct();
    }

    private void initAct() {
        arrText.add(binding.textQ);
        arrText.add(binding.textW);
        arrText.add(binding.textE);
        arrText.add(binding.textR);
        arrText.add(binding.textP);
        createKey();
        setFocus(binding.num1, arrKey.get(1));
    }

    protected void createKey() {

        Key k_0 = new Key(binding.num0, "0", KeyEvent.KEYCODE_0, null, null, null, null);
        Key k_1 = new Key(binding.num1, "1", KeyEvent.KEYCODE_1, null, null, null, null);
        Key k_2 = new Key(binding.num2, "2", KeyEvent.KEYCODE_2, null, null, null, null);
        Key k_3 = new Key(binding.num3, "3", KeyEvent.KEYCODE_3, null, null, null, null);
        Key k_4 = new Key(binding.num4, "4", KeyEvent.KEYCODE_4, null, null, null, null);
        Key k_5 = new Key(binding.num5, "5", KeyEvent.KEYCODE_5, null, null, null, null);
        Key k_6 = new Key(binding.num6, "6", KeyEvent.KEYCODE_6, null, null, null, null);
        Key k_7 = new Key(binding.num7, "7", KeyEvent.KEYCODE_7, null, null, null, null);
        Key k_8 = new Key(binding.num8, "8", KeyEvent.KEYCODE_8, null, null, null, null);
        Key k_9 = new Key(binding.num9, "9", KeyEvent.KEYCODE_9, null, null, null, null);
        Key k_q = new Key(binding.textQ, "Q", KeyEvent.KEYCODE_Q, null, null, null, null);
        Key k_w = new Key(binding.textW, "W", KeyEvent.KEYCODE_W, null, null, null, null);
        Key k_e = new Key(binding.textE, "E", KeyEvent.KEYCODE_E, null, null, null, null);
        Key k_r = new Key(binding.textR, "R", KeyEvent.KEYCODE_R, null, null, null, null);
        Key k_t = new Key(binding.textT, "T", KeyEvent.KEYCODE_T, null, null, null, null);
        Key k_y = new Key(binding.textY, "Y", KeyEvent.KEYCODE_Y, null, null, null, null);
        Key k_u = new Key(binding.textU, "U", KeyEvent.KEYCODE_U, null, null, null, null);
        Key k_i = new Key(binding.textI, "I", KeyEvent.KEYCODE_I, null, null, null, null);
        Key k_o = new Key(binding.textO, "O", KeyEvent.KEYCODE_O, null, null, null, null);
        Key k_p = new Key(binding.textP, "P", KeyEvent.KEYCODE_P, null, null, null, null);
        Key k_a = new Key(binding.textA, "A", KeyEvent.KEYCODE_A, null, null, null, null);
        Key k_s = new Key(binding.textS, "S", KeyEvent.KEYCODE_S, null, null, null, null);
        Key k_d = new Key(binding.textD, "D", KeyEvent.KEYCODE_D, null, null, null, null);
        Key k_f = new Key(binding.textF, "F", KeyEvent.KEYCODE_F, null, null, null, null);
        Key k_g = new Key(binding.textG, "G", KeyEvent.KEYCODE_G, null, null, null, null);
        Key k_h = new Key(binding.textH, "H", KeyEvent.KEYCODE_H, null, null, null, null);
        Key k_j = new Key(binding.textJ, "J", KeyEvent.KEYCODE_J, null, null, null, null);
        Key k_k = new Key(binding.textK, "K", KeyEvent.KEYCODE_K, null, null, null, null);
        Key k_l = new Key(binding.textL, "L", KeyEvent.KEYCODE_L, null, null, null, null);
        Key k_z = new Key(binding.textZ, "Z", KeyEvent.KEYCODE_Z, null, null, null, null);
        Key k_x = new Key(binding.textX, "X", KeyEvent.KEYCODE_X, null, null, null, null);
        Key k_c = new Key(binding.textC, "C", KeyEvent.KEYCODE_C, null, null, null, null);
        Key k_v = new Key(binding.textV, "V", KeyEvent.KEYCODE_V, null, null, null, null);
        Key k_b = new Key(binding.textB, "P", KeyEvent.KEYCODE_B, null, null, null, null);
        Key k_n = new Key(binding.textN, "N", KeyEvent.KEYCODE_N, null, null, null, null);
        Key k_m = new Key(binding.textM, "M", KeyEvent.KEYCODE_M, null, null, null, null);

        k_0.setKey_down(k_p);
        k_1.setKey_down(k_q);
        k_2.setKey_down(k_w);
        k_3.setKey_down(k_e);
        k_4.setKey_down(k_r);
        k_5.setKey_down(k_t);
        k_6.setKey_down(k_y);
        k_7.setKey_down(k_u);
        k_8.setKey_down(k_i);
        k_9.setKey_down(k_o);

        k_0.setKey_left(k_p);
        k_2.setKey_left(k_1);
        k_3.setKey_left(k_2);
        k_4.setKey_left(k_3);
        k_5.setKey_left(k_4);
        k_6.setKey_left(k_5);
        k_7.setKey_left(k_6);
        k_8.setKey_left(k_7);
        k_9.setKey_left(k_8);

        k_1.setKey_right(k_2);
        k_2.setKey_right(k_3);
        k_3.setKey_right(k_4);
        k_4.setKey_right(k_5);
        k_5.setKey_right(k_6);
        k_6.setKey_right(k_7);
        k_7.setKey_right(k_8);
        k_8.setKey_right(k_9);
        k_9.setKey_right(k_0);

        k_q.setKey_up(k_1);
        k_w.setKey_up(k_2);
        k_e.setKey_up(k_3);
        k_r.setKey_up(k_4);
        k_t.setKey_up(k_5);
        k_y.setKey_up(k_6);
        k_u.setKey_up(k_7);
        k_i.setKey_up(k_8);
        k_o.setKey_up(k_9);
        k_p.setKey_up(k_0);

        k_q.setKey_down(k_a);
        k_w.setKey_down(k_s);
        k_e.setKey_down(k_d);
        k_r.setKey_down(k_f);
        k_t.setKey_down(k_g);
        k_y.setKey_down(k_h);
        k_u.setKey_down(k_j);
        k_i.setKey_down(k_k);
        k_o.setKey_down(k_l);

        k_w.setKey_left(k_q);
        k_e.setKey_left(k_w);
        k_r.setKey_left(k_e);
        k_t.setKey_left(k_r);
        k_y.setKey_left(k_t);
        k_u.setKey_left(k_y);
        k_i.setKey_left(k_u);
        k_o.setKey_left(k_i);
        k_p.setKey_left(k_o);

        k_q.setKey_right(k_w);
        k_w.setKey_right(k_e);
        k_e.setKey_right(k_r);
        k_r.setKey_right(k_t);
        k_t.setKey_right(k_y);
        k_y.setKey_right(k_u);
        k_u.setKey_right(k_i);
        k_i.setKey_right(k_o);
        k_o.setKey_left(k_p);

        k_a.setKey_up(k_q);
        k_s.setKey_up(k_w);
        k_d.setKey_up(k_e);
        k_f.setKey_up(k_r);
        k_g.setKey_up(k_t);
        k_h.setKey_up(k_y);
        k_j.setKey_up(k_u);
        k_k.setKey_up(k_i);
        k_l.setKey_up(k_o);

        k_a.setKey_down(k_z);
        k_s.setKey_down(k_x);
        k_d.setKey_down(k_c);
        k_f.setKey_down(k_v);
        k_g.setKey_down(k_b);
        k_h.setKey_down(k_n);
        k_j.setKey_down(k_m);

        k_s.setKey_left(k_a);
        k_d.setKey_left(k_s);
        k_f.setKey_left(k_d);
        k_g.setKey_left(k_f);
        k_h.setKey_left(k_g);
        k_j.setKey_left(k_h);
        k_k.setKey_left(k_j);
        k_l.setKey_left(k_k);


        k_a.setKey_right(k_s);
        k_s.setKey_right(k_d);
        k_d.setKey_right(k_f);
        k_f.setKey_right(k_g);
        k_g.setKey_right(k_h);
        k_h.setKey_right(k_j);
        k_j.setKey_right(k_k);
        k_k.setKey_right(k_l);

        k_z.setKey_up(k_a);
        k_x.setKey_up(k_s);
        k_c.setKey_up(k_d);
        k_v.setKey_up(k_f);
        k_b.setKey_up(k_g);
        k_n.setKey_up(k_h);
        k_m.setKey_up(k_j);

        k_x.setKey_left(k_z);
        k_c.setKey_left(k_x);
        k_v.setKey_left(k_c);
        k_b.setKey_left(k_v);
        k_n.setKey_left(k_b);
        k_m.setKey_left(k_n);

        k_z.setKey_right(k_x);
        k_x.setKey_right(k_c);
        k_c.setKey_right(k_v);
        k_v.setKey_right(k_b);
        k_b.setKey_right(k_n);
        k_n.setKey_right(k_m);

        arrKey.add(k_0);
        arrKey.add(k_1);
        arrKey.add(k_2);
        arrKey.add(k_3);
        arrKey.add(k_4);
        arrKey.add(k_5);
        arrKey.add(k_6);
        arrKey.add(k_7);
        arrKey.add(k_8);
        arrKey.add(k_9);
        arrKey.add(k_q);
        arrKey.add(k_w);
        arrKey.add(k_e);
        arrKey.add(k_r);
        arrKey.add(k_t);
        arrKey.add(k_y);
        arrKey.add(k_u);
        arrKey.add(k_i);
        arrKey.add(k_o);
        arrKey.add(k_p);
        arrKey.add(k_a);
        arrKey.add(k_s);
        arrKey.add(k_d);
        arrKey.add(k_f);
        arrKey.add(k_g);
        arrKey.add(k_h);
        arrKey.add(k_j);
        arrKey.add(k_k);
        arrKey.add(k_l);
        arrKey.add(k_z);
        arrKey.add(k_x);
        arrKey.add(k_c);
        arrKey.add(k_v);
        arrKey.add(k_b);
        arrKey.add(k_n);
        arrKey.add(k_m);
        arrKey.add(k_p);
    }

    private void setFocus(TextView text, Key keyFocus) {
        if (keyFocus != null) {
            setNormalState(binding.num1);
        }
        text.setBackgroundColor(getResources().getColor(R.color.color_focus));
        setKeyFocus(keyFocus);
    }

    public void setKeyFocus(Key keyFocus) {
        this.keyFocus = keyFocus;
    }

    private void setNormalState(TextView text) {
        text.setBackgroundResource(R.color.color_normal_state);

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            for (Key k : arrKey
            ) {
                if (k.getKeyCode() == event.getKeyCode()) {
                    setFocus(k.getView(), k);
                }
            }
            if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                setText(keyFocus.getName());
            }
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_DPAD_UP:
                    if (keyFocus.getKey_up() != null) {
                        Key k_up = keyFocus.getKey_up();
                        setKeyFocus(k_up);
                        setFocus(k_up.getView(), k_up);
                    }
                    break;
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    if (keyFocus.getKey_down() != null) {
                        Key k_down = keyFocus.getKey_down();
                        setKeyFocus(k_down);
                        setFocus(k_down.getView(), k_down);
                    }
                    break;
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    if (keyFocus.getKey_left() != null) {
                        Key k_left = keyFocus.getKey_left();
                        setKeyFocus(k_left);
                        setFocus(k_left.getView(), k_left);
                    }
                    break;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    if (keyFocus.getKey_right() != null) {
                        Key k_right = keyFocus.getKey_right();
                        setKeyFocus(k_right);
                        setFocus(k_right.getView(), k_right);
                    }
                    break;
                case KeyEvent.KEYCODE_DEL:
                    setText("");
                    break;
            }
        } else if (event.getAction() == KeyEvent.ACTION_UP) {
            for (Key k : arrKey
            ) {
                if (k.getKeyCode() == event.getKeyCode()) {
                    setNormalState(k.getView());
                }
            }
            if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_UP || event.getKeyCode() == KeyEvent.KEYCODE_DPAD_DOWN
                    || event.getKeyCode() == KeyEvent.KEYCODE_DPAD_LEFT || event.getKeyCode() == KeyEvent.KEYCODE_DPAD_RIGHT) {
                setNormalState(keyFocus.getView());
            }
            for (Key k : arrKey
            ) {
                setNormalState(k.getView());
            }
        }
        return super.dispatchKeyEvent(event);
    }

    private void setText(String text) {
        binding.screen.setText(text);
    }
}
