package learn.nbcc.therickandmortyquizapp
// @author: Erica Moisei

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var questionIndex = 0
    private lateinit var questionView: TextView
    private lateinit var nextButton: ImageButton
    private lateinit var prevButton: ImageButton
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    /**
     * List of Questions
     */
    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true))


    /**
     * on Create
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variables of controls
        questionView = findViewById(R.id.question_view)
        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.previous_btn)
        trueButton = findViewById(R.id.true_btn)
        falseButton = findViewById(R.id.false_btn)

        questionView.setText(questionBank[questionIndex].textResId)

        //Next question
        nextButton.setOnClickListener {
            questionIndex = (questionIndex + 1) % 20
            questionView.setText(questionBank[questionIndex].textResId)
        }

        //previous question
        prevButton.setOnClickListener {
            questionIndex = (questionIndex + 19) % 20
            questionView.setText(questionBank[questionIndex].textResId)
        }

        //true btn, shows toast message with the result
        trueButton.setOnClickListener {
            //if the answer == true - Correct
            var answer = if (questionBank[questionIndex].answer) "Correct" else "Incorrect"
            Toast.makeText(applicationContext, answer, Toast.LENGTH_SHORT).show()
        }

        //false btn, shows toast message with the result
        falseButton.setOnClickListener {
            //if the answer == false - Correct
            var answer = if (!questionBank[questionIndex].answer) "Correct" else "Incorrect"
            Toast.makeText(applicationContext, answer, Toast.LENGTH_SHORT).show()
        }
    }

}
