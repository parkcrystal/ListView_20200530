package com.phis.listview_20200530

import android.content.DialogInterface
import android.content.Intent
import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        
//        몇번 줄이 눌렸는지 확인  = position이 몇?
        studentListView.setOnItemClickListener { parent, view, position, id ->
            Log.d("!!리스트뷰 아이템 클릭!!", "${position}번 줄 클릭")

            
//            position으로 배열(ArrayList)에서 학생정보 출력
            val clickedStudent = students.get(position)

            
//          빼낸 학생정보를 토스트로 출력.
            Toast.makeText(this, clickedStudent.name, Toast.LENGTH_SHORT).show()



            val myIntent = Intent(this, ViewStudentActivity::class.java)
            myIntent.putExtra("student", clickedStudent)
            startActivity(myIntent)


        }


        studentListView.setOnItemLongClickListener { parent, view, position, id ->

//            Toast.makeText(this,"${position}번 줄 롱클릭", Toast.LENGTH_LONG).show()
            
            val alert = AlertDialog.Builder(this)
            alert.setTitle("수강생 삭제")
            alert.setMessage("정말 이 수강생을 삭제 하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                students.removeAt(position)
                studentAdapter.notifyDataSetChanged()
            })
            alert.setNegativeButton("취소", null)
            alert.show()




//        Long 클릭은 boolean 값을 리턴해줘야 함. =>  롱클릭 전용 : True, 클릭도 같이: False
            return@setOnItemLongClickListener true

        }


    }
}
