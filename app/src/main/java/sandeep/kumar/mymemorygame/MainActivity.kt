package sandeep.kumar.mymemorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //create reference for layout views element that we initialize later
    private lateinit var rvBoard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPairs: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //store the reference in variables
        rvBoard = findViewById(R.id.rvBoard)
        tvNumMoves = findViewById(R.id.tvNumMoves)
        tvNumPairs = findViewById(R.id.tvNumPairs)

        //adapter  provide binding for the data set to the view of the recyclerview
        rvBoard.adapter =MemoryBoardAdapter(this,8)
        rvBoard.setHasFixedSize(true)
        //Layout manager is used for measure and positions item view
        rvBoard.layoutManager =GridLayoutManager(this,2)

    }
}