package com.example.calculator_with_operator

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textoutput: TextView
    lateinit var prev_num: TextView
    lateinit var next_num: TextView
    lateinit var operator: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textoutput = findViewById(R.id.text_result)
        prev_num = findViewById(R.id.prev_num)
        next_num = findViewById(R.id.next_num)
        operator = findViewById(R.id.operator)

        findViewById<Button>(R.id.btn0).setOnClickListener(this)
        findViewById<Button>(R.id.btn1).setOnClickListener(this)
        findViewById<Button>(R.id.btn2).setOnClickListener(this)
        findViewById<Button>(R.id.btn3).setOnClickListener(this)
        findViewById<Button>(R.id.btn4).setOnClickListener(this)
        findViewById<Button>(R.id.btn5).setOnClickListener(this)
        findViewById<Button>(R.id.btn6).setOnClickListener(this)
        findViewById<Button>(R.id.btn7).setOnClickListener(this)
        findViewById<Button>(R.id.btn8).setOnClickListener(this)
        findViewById<Button>(R.id.btn9).setOnClickListener(this)

        findViewById<Button>(R.id.btn_add).setOnClickListener(this)
        findViewById<Button>(R.id.btn_sub).setOnClickListener(this)
        findViewById<Button>(R.id.btn_mul).setOnClickListener(this)
        findViewById<Button>(R.id.btn_div).setOnClickListener(this)

        findViewById<Button>(R.id.btn_clear).setOnClickListener(this)
        findViewById<Button>(R.id.btn_del).setOnClickListener(this)

        findViewById<Button>(R.id.btn_calc).setOnClickListener(this)
    }

    var op: Int = 0
    var num1: Int = 0
    var num2: Int = 0
    var count_num: Int = 1
    var get_num1: Int = 0
    var get_num2: Int = 0

    override fun onClick(p0: View?) {
        val id = p0?.id
        if (id == R.id.btn0) {
            addDigit(0, count_num)
        } else if (id == R.id.btn1) {
            addDigit(1, count_num)
        } else if (id == R.id.btn2) {
            addDigit(2, count_num)
        } else if (id == R.id.btn3) {
            addDigit(3,count_num)
        } else if (id == R.id.btn4) {
            addDigit(4, count_num)
        } else if (id == R.id.btn5) {
            addDigit(5,count_num)
        } else if (id == R.id.btn6) {
            addDigit(6, count_num)
        } else if (id == R.id.btn7) {
            addDigit(7,count_num)
        } else if (id == R.id.btn8) {
            addDigit(8, count_num)
        } else if (id == R.id.btn9) {
            addDigit(9,count_num)
        }

        if (id == R.id.btn_add) {
            switch(1)
        } else if (id == R.id.btn_sub) {
            switch(2)
        } else if (id == R.id.btn_mul) {
            switch(3)
        } else if (id == R.id.btn_div) {
            switch(4)
        } else if (id == R.id.btn_calc) {
            if((get_num2==1)&&(op!=0)) {
                calc(num1, num2, op)
                printOutput(num1.toString())
                num2=0
                get_num2=0
                op=0
            }
        }
        if(id == R.id.btn_clear){
            clear()
        }
        if(id == R.id.btn_del){
            del()
        }
    }

    fun calc(num_1: Int, num_2: Int, o_p: Int ){
        if(o_p==1) operator.text= "+"
        else if (o_p==2) operator.text= "-"
        else if(o_p==3) operator.text= "*"
        else if(o_p==4) operator.text= "/"
        next_num.text=num_2.toString()
        if(o_p==1) {
            if(get_num2!=0) num1= num_1+num_2
        }
        if(o_p==2){
            if(get_num2!=0) num1= num_1-num_2
        }
        if(o_p==3){
            if(get_num2!=0) num1= num_1*num_2
        }
        if(o_p==4){
            if((num_2!=0)&&(get_num2!=0)) num1= num_1/num_2
        }

    }

    fun switch(ope: Int){
        count_num=2
        prev_num.text= num1.toString()
        if((op!=0)) {
            calc(num1, num2, op)
            prev_num.text= num1.toString()
            next_num.text=""
            printOutput("")
            num2=0
            get_num2=0
            op = ope
            printOperator()
        }
        if((get_num1==1)&&(get_num2==0)){
            if (op==0) {
                op = ope
                printOperator()
                textoutput.text=""
                next_num.text=""
            }
        }
    }
    fun addDigit(c: Int, get_num: Int) {
        if (get_num == 1) {
            num1 = num1 * 10 + c
            get_num1=1
            printOutput(num1.toString())
        } else if (get_num==2) {
            num2 = num2 * 10 + c
            get_num2=1
            printOutput(num2.toString())
        }
    }
    fun printOutput(num: String){
        textoutput.text = num
    }
    fun printOperator(){
        if(op==1) operator.text= "+"
        else if (op==2) operator.text= "-"
        else if(op==3) operator.text= "*"
        else if(op==4) operator.text= "/"
    }
    fun clear(){
        num1=0
        num2=0
        op=0
        count_num=1
        get_num2=0
        get_num1=0
        textoutput.text="0"
        operator.text= ""
        prev_num.text=""
        next_num.text=""
        printOutput(num1.toString())
    }
    fun del(){
        if(count_num==1){
            num1 = (num1-( num1 % 10 ))/10
            printOutput(num1.toString())
        }else if(count_num==2){
            num2 = (num2-( num2 % 10 ))/10
            printOutput(num2.toString())
        }
    }
}