package com.rikkei.training.input

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.rikkei.training.input.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var keyFocus: Key? = null
    private val arrText = ArrayList<TextView>()

    private val arrKey = ArrayList<Key>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initAct()
    }

    private fun initAct() {
        arrText.add(binding!!.textQ)
        arrText.add(binding!!.textW)
        arrText.add(binding!!.textE)
        arrText.add(binding!!.textR)
        arrText.add(binding!!.textP)
        createKey()
        setFocus(binding!!.num1, arrKey[1])
    }

    private fun createKey() {

        val k_0 = Key(binding!!.num0, "0", KeyEvent.KEYCODE_0, null, null, null, null)
        val k_1 = Key(binding!!.num1, "1", KeyEvent.KEYCODE_1, null, null, null, null)
        val k_2 = Key(binding!!.num2, "2", KeyEvent.KEYCODE_2, null, null, null, null)
        val k_3 = Key(binding!!.num3, "3", KeyEvent.KEYCODE_3, null, null, null, null)
        val k_4 = Key(binding!!.num4, "4", KeyEvent.KEYCODE_4, null, null, null, null)
        val k_5 = Key(binding!!.num5, "5", KeyEvent.KEYCODE_5, null, null, null, null)
        val k_6 = Key(binding!!.num6, "6", KeyEvent.KEYCODE_6, null, null, null, null)
        val k_7 = Key(binding!!.num7, "7", KeyEvent.KEYCODE_7, null, null, null, null)
        val k_8 = Key(binding!!.num8, "8", KeyEvent.KEYCODE_8, null, null, null, null)
        val k_9 = Key(binding!!.num9, "9", KeyEvent.KEYCODE_9, null, null, null, null)
        val k_q = Key(binding!!.textQ, "Q", KeyEvent.KEYCODE_Q, null, null, null, null)
        val k_w = Key(binding!!.textW, "W", KeyEvent.KEYCODE_W, null, null, null, null)
        val k_e = Key(binding!!.textE, "E", KeyEvent.KEYCODE_E, null, null, null, null)
        val k_r = Key(binding!!.textR, "R", KeyEvent.KEYCODE_R, null, null, null, null)
        val k_t = Key(binding!!.textT, "T", KeyEvent.KEYCODE_T, null, null, null, null)
        val k_y = Key(binding!!.textY, "Y", KeyEvent.KEYCODE_Y, null, null, null, null)
        val k_u = Key(binding!!.textU, "U", KeyEvent.KEYCODE_U, null, null, null, null)
        val k_i = Key(binding!!.textI, "I", KeyEvent.KEYCODE_I, null, null, null, null)
        val k_o = Key(binding!!.textO, "O", KeyEvent.KEYCODE_O, null, null, null, null)
        val k_p = Key(binding!!.textP, "P", KeyEvent.KEYCODE_P, null, null, null, null)
        val k_a = Key(binding!!.textA, "A", KeyEvent.KEYCODE_A, null, null, null, null)
        val k_s = Key(binding!!.textS, "S", KeyEvent.KEYCODE_S, null, null, null, null)
        val k_d = Key(binding!!.textD, "D", KeyEvent.KEYCODE_D, null, null, null, null)
        val k_f = Key(binding!!.textF, "F", KeyEvent.KEYCODE_F, null, null, null, null)
        val k_g = Key(binding!!.textG, "G", KeyEvent.KEYCODE_G, null, null, null, null)
        val k_h = Key(binding!!.textH, "H", KeyEvent.KEYCODE_H, null, null, null, null)
        val k_j = Key(binding!!.textJ, "J", KeyEvent.KEYCODE_J, null, null, null, null)
        val k_k = Key(binding!!.textK, "K", KeyEvent.KEYCODE_K, null, null, null, null)
        val k_l = Key(binding!!.textL, "L", KeyEvent.KEYCODE_L, null, null, null, null)
        val k_z = Key(binding!!.textZ, "Z", KeyEvent.KEYCODE_Z, null, null, null, null)
        val k_x = Key(binding!!.textX, "X", KeyEvent.KEYCODE_X, null, null, null, null)
        val k_c = Key(binding!!.textC, "C", KeyEvent.KEYCODE_C, null, null, null, null)
        val k_v = Key(binding!!.textV, "V", KeyEvent.KEYCODE_V, null, null, null, null)
        val k_b = Key(binding!!.textB, "P", KeyEvent.KEYCODE_B, null, null, null, null)
        val k_n = Key(binding!!.textN, "N", KeyEvent.KEYCODE_N, null, null, null, null)
        val k_m = Key(binding!!.textM, "M", KeyEvent.KEYCODE_M, null, null, null, null)

        k_0.key_down = k_p
        k_1.key_down = k_q
        k_2.key_down = k_w
        k_3.key_down = k_e
        k_4.key_down = k_r
        k_5.key_down = k_t
        k_6.key_down = k_y
        k_7.key_down = k_u
        k_8.key_down = k_i
        k_9.key_down = k_o

        k_0.key_left = k_p
        k_2.key_left = k_1
        k_3.key_left = k_2
        k_4.key_left = k_3
        k_5.key_left = k_4
        k_6.key_left = k_5
        k_7.key_left = k_6
        k_8.key_left = k_7
        k_9.key_left = k_8

        k_1.key_right = k_2
        k_2.key_right = k_3
        k_3.key_right = k_4
        k_4.key_right = k_5
        k_5.key_right = k_6
        k_6.key_right = k_7
        k_7.key_right = k_8
        k_8.key_right = k_9
        k_9.key_right = k_0

        k_q.key_up = k_1
        k_w.key_up = k_2
        k_e.key_up = k_3
        k_r.key_up = k_4
        k_t.key_up = k_5
        k_y.key_up = k_6
        k_u.key_up = k_7
        k_i.key_up = k_8
        k_o.key_up = k_9
        k_p.key_up = k_0

        k_q.key_down = k_a
        k_w.key_down = k_s
        k_e.key_down = k_d
        k_r.key_down = k_f
        k_t.key_down = k_g
        k_y.key_down = k_h
        k_u.key_down = k_j
        k_i.key_down = k_k
        k_o.key_down = k_l

        k_w.key_left = k_q
        k_e.key_left = k_w
        k_r.key_left = k_e
        k_t.key_left = k_r
        k_y.key_left = k_t
        k_u.key_left = k_y
        k_i.key_left = k_u
        k_o.key_left = k_i
        k_p.key_left = k_o

        k_q.key_right = k_w
        k_w.key_right = k_e
        k_e.key_right = k_r
        k_r.key_right = k_t
        k_t.key_right = k_y
        k_y.key_right = k_u
        k_u.key_right = k_i
        k_i.key_right = k_o
        k_o.key_right = k_p

        k_a.key_up = k_q
        k_s.key_up = k_w
        k_d.key_up = k_e
        k_f.key_up = k_r
        k_g.key_up = k_t
        k_h.key_up = k_y
        k_j.key_up = k_u
        k_k.key_up = k_i
        k_l.key_up = k_o

        k_a.key_down = k_z
        k_s.key_down = k_x
        k_d.key_down = k_c
        k_f.key_down = k_v
        k_g.key_down = k_b
        k_h.key_down = k_n
        k_j.key_down = k_m

        k_s.key_left = k_a
        k_d.key_left = k_s
        k_f.key_left = k_d
        k_g.key_left = k_f
        k_h.key_left = k_g
        k_j.key_left = k_h
        k_k.key_left = k_j
        k_l.key_left = k_k


        k_a.key_right = k_s
        k_s.key_right = k_d
        k_d.key_right = k_f
        k_f.key_right = k_g
        k_g.key_right = k_h
        k_h.key_right = k_j
        k_j.key_right = k_k
        k_k.key_right = k_l

        k_z.key_up = k_a
        k_x.key_up = k_s
        k_c.key_up = k_d
        k_v.key_up = k_f
        k_b.key_up = k_g
        k_n.key_up = k_h
        k_m.key_up = k_j

        k_x.key_left = k_z
        k_c.key_left = k_x
        k_v.key_left = k_c
        k_b.key_left = k_v
        k_n.key_left = k_b
        k_m.key_left = k_n

        k_z.key_right = k_x
        k_x.key_right = k_c
        k_c.key_right = k_v
        k_v.key_right = k_b
        k_b.key_right = k_n
        k_n.key_right = k_m

        arrKey.add(k_0)
        arrKey.add(k_1)
        arrKey.add(k_2)
        arrKey.add(k_3)
        arrKey.add(k_4)
        arrKey.add(k_5)
        arrKey.add(k_6)
        arrKey.add(k_7)
        arrKey.add(k_8)
        arrKey.add(k_9)
        arrKey.add(k_q)
        arrKey.add(k_w)
        arrKey.add(k_e)
        arrKey.add(k_r)
        arrKey.add(k_t)
        arrKey.add(k_y)
        arrKey.add(k_u)
        arrKey.add(k_i)
        arrKey.add(k_o)
        arrKey.add(k_p)
        arrKey.add(k_a)
        arrKey.add(k_s)
        arrKey.add(k_d)
        arrKey.add(k_f)
        arrKey.add(k_g)
        arrKey.add(k_h)
        arrKey.add(k_j)
        arrKey.add(k_k)
        arrKey.add(k_l)
        arrKey.add(k_z)
        arrKey.add(k_x)
        arrKey.add(k_c)
        arrKey.add(k_v)
        arrKey.add(k_b)
        arrKey.add(k_n)
        arrKey.add(k_m)
        arrKey.add(k_p)
    }

    private fun setFocus(text: TextView, keyFocus: Key?) {
        if (keyFocus != null) {
            setNormalState(binding!!.num1)
        }
        text.setBackgroundColor(resources.getColor(R.color.color_focus))
        setKeyFocus(keyFocus)
    }

    private fun setKeyFocus(keyFocus: Key?) {
        this.keyFocus = keyFocus
    }

    private fun setNormalState(text: TextView) {
        text.setBackgroundResource(R.color.color_normal_state)

    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {

        if (event.action == KeyEvent.ACTION_DOWN) {
            for (k in arrKey) {
                if (k.keyCode == event.keyCode) {
                    setFocus(k.view!!, k)
                }
            }
            if (event.keyCode == KeyEvent.KEYCODE_ENTER) {
                setText(keyFocus!!.name!!)
            }
            when (event.keyCode) {
                KeyEvent.KEYCODE_DPAD_UP -> if (keyFocus!!.key_up != null) {
                    val k_up = keyFocus!!.key_up
                    setKeyFocus(k_up)
                    setFocus(k_up!!.view!!, k_up)
                }
                KeyEvent.KEYCODE_DPAD_DOWN -> if (keyFocus!!.key_down != null) {
                    val k_down = keyFocus!!.key_down
                    setKeyFocus(k_down)
                    setFocus(k_down!!.view!!, k_down)
                }
                KeyEvent.KEYCODE_DPAD_LEFT -> if (keyFocus!!.key_left != null) {
                    val k_left = keyFocus!!.key_left
                    setKeyFocus(k_left)
                    setFocus(k_left!!.view!!, k_left)
                }
                KeyEvent.KEYCODE_DPAD_RIGHT -> if (keyFocus!!.key_right != null) {
                    val k_right = keyFocus!!.key_right
                    setKeyFocus(k_right)
                    setFocus(k_right!!.view!!, k_right)
                }
                KeyEvent.KEYCODE_DEL -> setText("")
            }
        } else if (event.action == KeyEvent.ACTION_UP) {
            for (k in arrKey) {
                if (k.keyCode == event.keyCode) {
                    setNormalState(k.view!!)
                }
            }
            if (event.keyCode == KeyEvent.KEYCODE_DPAD_UP || event.keyCode == KeyEvent.KEYCODE_DPAD_DOWN
                || event.keyCode == KeyEvent.KEYCODE_DPAD_LEFT || event.keyCode == KeyEvent.KEYCODE_DPAD_RIGHT
            ) {
                setNormalState(keyFocus!!.view!!)
            }
            for (k in arrKey) {
                setNormalState(k.view!!)
            }
        }
        return super.dispatchKeyEvent(event)
    }

    private fun setText(text: String) {
        binding!!.screen.text = text
    }
}
