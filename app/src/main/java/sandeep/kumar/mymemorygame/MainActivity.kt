package sandeep.kumar.mymemorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sandeep.kumar.mymemorygame.models.BoardSize
import sandeep.kumar.mymemorygame.models.MemoryCard
import sandeep.kumar.mymemorygame.utils.DEFAULT_ICONS

class MainActivity : AppCompatActivity() {

    //create reference for layout views element that we initialize later
    private lateinit var rvBoard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPairs: TextView

    private var boardSize= BoardSize.HARD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //store the reference in variables
        rvBoard = findViewById(R.id.rvBoard)
        tvNumMoves = findViewById(R.id.tvNumMoves)
        tvNumPairs = findViewById(R.id.tvNumPairs)

        val chosenImages = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        val randomImages =(chosenImages +chosenImages).shuffled()

        val memoryCards =  randomImages.map {
           MemoryCard(it)
        }


        //adapter  provide binding for the data set to the view of the recyclerview
        rvBoard.adapter =MemoryBoardAdapter(this,boardSize,memoryCards)
        rvBoard.setHasFixedSize(true)
        //Layout manager is used for measure and positions item view
        rvBoard.layoutManager =GridLayoutManager(this,boardSize.getWidth())

    }
}