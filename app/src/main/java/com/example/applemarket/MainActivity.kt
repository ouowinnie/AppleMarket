package com.example.applemarket

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applemarket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.sample1, "산지 한달된 선풍기 팝니다", "서울 서대문구 창천동", "1,000원", 13, 25))
        dataList.add(MyItem(R.drawable.sample2, "김치냉장고", "인천 계양구 귤현동", "20,000원", 8, 28))
        dataList.add(MyItem(R.drawable.sample3, "샤넬 카드지갑", "수성구 범어동", "10,000원", 23, 5))
        dataList.add(MyItem(R.drawable.sample4, "금고", "해운대구 우제2동", "10,000원", 14, 17))
        dataList.add(MyItem(R.drawable.sample5, "갤럭시Z플립3 팝니다", "연제구 연산제8동", "150,000원", 22, 9))
        dataList.add(MyItem(R.drawable.sample6, "프라다 복조리백", "수원시 영통구 원천동", "50,000원", 25, 16))
        dataList.add(MyItem(R.drawable.sample7, "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장", "남구 옥동", "150,000원", 142, 54))
        dataList.add(MyItem(R.drawable.sample8, "샤넬 탑핸들 가방", "동래구 온천제2동", "180,000원", 31, 7))
        dataList.add(MyItem(R.drawable.sample9, "4행정 엔진분무기 판매합니다.", "원주시 명륜2동", "30,000원", 7, 28))
        dataList.add(MyItem(R.drawable.sample10, "셀린느 버킷 가방", "중구 동화동", "190,000원", 40, 6))

        val adapter = MyAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Spinner list
        val adList =  resources.getStringArray(R.array.spinnerArray)
        val adAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, adList)
        binding.spinner.adapter = adAdapter

//        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//            }
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//            }
//        }

        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val name: String = dataList[position].listTitle
                Toast.makeText(this@MainActivity," $name 선택!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    // 뒤로가기 버튼 클릭 시 종료 다이얼로그
    override fun onBackPressed() {
        showExitConfirmationDialog()
    }
    private fun showExitConfirmationDialog() {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("종료")
            .setMessage("정말로 종료하시겠습니까?")
            .setPositiveButton("확인") { dialog, which ->
                finish()
            }
            .setNegativeButton("취소", null)
            .create()
            alertDialog.show()
    }

}