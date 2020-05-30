package com.phis.listview_20200530

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.phis.listview_20200530.datas.Student

class MainActivity : AppCompatActivity() {

    val students = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        students.add(Student("조경진", 1988, true))
        students.add(Student("홍길동", 1988, true))
        students.add(Student("김개똥", 1998, false))
        students.add(Student("이개똥", 1978, true))
    }
}
