package sandeep.kumar.mymemorygame

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import sandeep.kumar.mymemorygame.models.BoardSize
import sandeep.kumar.mymemorygame.models.MemoryCard
import kotlin.math.min

class MemoryBoardAdapter(
    private val context: Context,
    private val boardSize: BoardSize,
    private val cards: List<MemoryCard>
) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {

    companion object{
        private const val MARGIN_SIZE = 10
        private const val TAG ="MemoryBoardAdapter"
    }

        inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
            private val imageButton =itemView.findViewById<ImageButton>(R.id.imageButton)

            fun bind(position: Int) {

                val memoryCard =cards[position]

                imageButton.setImageResource(if(
                    memoryCard.isFaceUp) memoryCard.identifier else R.drawable.ic_launcher_background)
                imageButton.setOnClickListener {
                    Log.i(TAG,"Clicked on position $position")
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardWidth =parent.width/boardSize.getWidth() -(2* MARGIN_SIZE)
        val cardHeight =parent.height/boardSize.getHeight() -(2* MARGIN_SIZE)
        val cardSideLength = min(cardWidth,cardHeight)


        val view= LayoutInflater.from(context).inflate(R.layout.memory_card,parent,false)

        val layoutParms = view.findViewById<CardView>(R.id.cardView)
            .layoutParams as ViewGroup.MarginLayoutParams
        layoutParms.width =cardSideLength
        layoutParms.height =cardSideLength
        layoutParms.setMargins(MARGIN_SIZE,MARGIN_SIZE,MARGIN_SIZE,MARGIN_SIZE)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = boardSize.numCards
}