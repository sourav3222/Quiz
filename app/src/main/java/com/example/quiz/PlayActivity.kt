package com.example.quiz

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import com.example.quiz.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {
    lateinit var binding: ActivityPlayBinding
    var updateQuestion = 1
    val quizlist = listOf<Quiz>(

        Quiz("victory day of Bangladesh", "15 september", "13 october", "16 December","18 january","16 December"),
        Quiz("How many minutes are in a full work", "12,211 minutes", "10,210 minutes", "10,311 minutes","10,080 minutes","10,080 minutes"),
        Quiz("Aureolin is shape of what a color?","Green","Yellow","Red","White","Yellow"),
        Quiz("What software company is headquatered in redmoned, whasington?","mycrosoft","google","facebook","jaba","mycrosoft"),
        Quiz("How many dots appear on a pair of dice?","32","31","52","42","42"),
        Quiz("What is acrophobia a fear of?","Height","Weight","age","name","Height"),
        Quiz(" What phone company produced the 3310? ","  Nokia","ViVo","MIUI","Readme","Nokia")
    )
    var index = 0
    var Finished = false
    var skip = -1
    var carrect = 0
    var wrong = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initquestion()
        binding.nextbtn.setOnClickListener{
            showOnclick()
        }


    }

    private fun initquestion() {
        val quizQuestion = quizlist[index]

        binding.apply {
            questionTV.text = quizQuestion.question
            option1.text = quizQuestion.option1
            option2.text = quizQuestion.option2
            option3.text = quizQuestion.option3
            option4.text = quizQuestion.option4

        }


    }
    private fun showOnclick (){

        carrectAnswer()
        binding.apply {

            if (updateQuestion < quizlist.size){
                updateQuestion++
                initquestion()
            }else if (index<= quizlist.size -1){
                index++
            }else{
                Finished = true
            }
            rediogroup.clearCheck()
        }
    }

    private fun carrectAnswer() {
        binding.apply {

            if (rediogroup.checkedRadioButtonId == -1) {
                skip++
            } else {
                var chekedButton = findViewById<RadioButton>(rediogroup.checkedRadioButtonId)
                var chakedanswer = chekedButton.text.toString()


                if (chakedanswer == quizlist[index].Answer) {
                    carrect++
                    ShowalartDiloag("Carrect Answer")
                } else {
                    wrong++
                    ShowalartDiloag("worng Answer")
                }
            }
            if (index<= quizlist.size -1){
                index++
            }else{
              ShowalartDiloag  ("Finished")
            }




        }
    }

        fun ShowalartDiloag(massage: String){
            val builder =AlertDialog.Builder(this)

            builder.setTitle(massage)

            builder.setPositiveButton("Ok", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {

                    if (massage == "Finished") {
                        val intent = Intent(this@PlayActivity, MainActivity2::class.java)
                        intent.putExtra("skip", skip)
                        intent.putExtra("carrect", carrect)
                        intent.putExtra("wrong", wrong)



                        startActivity(intent)

                    }

                    }


            })

            var alart = builder.create()
            alart.show()
        }




}


