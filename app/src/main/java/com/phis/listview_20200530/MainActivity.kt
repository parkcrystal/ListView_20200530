package com.phis.listview_20200530

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.phis.listview_20200530.adapters.StudentAdapter
import com.phis.listview_20200530.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val students = ArrayList<Student>()
    //onCreate 실행된 이후에 내용을 채워야 함.
    //변수는 멤버변수로 만들어두면 차후에 편리함.

    lateinit var studentAdapter:StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        students.add(Student("조경진", 1988, true))
        students.add(Student("홍길동", 1988, true))
        students.add(Student("김개똥", 1998, false))
        students.add(Student("이개똥", 1978, true))


        studentAdapter = StudentAdapter(this, R.layout.student_list_item, students)


        studentListView.adapter = studentAdapter
    }
}
