package room106.app.fetchhiring.jsontask

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

@SuppressLint("ViewConstructor")
class ItemView(context: Context, item: Item): ConstraintLayout(context) {

    // Views
    private var idTextView: TextView
    private var listIdTextView: TextView
    private var nameTextView: TextView

    init {
        inflate(context, R.layout.item_layout, this)

        // Connect view
        idTextView = findViewById(R.id.idTextView)
        listIdTextView = findViewById(R.id.listIdTextView)
        nameTextView = findViewById(R.id.nameTextView)

        attachData(item.id!!, item.listId!!, item.name!!)
    }

    @SuppressLint("SetTextI18n")
    fun attachData(id: Int, listID: Int, name: String) {
        idTextView.text = "#$id"
        listIdTextView.text = "#$listID"
        nameTextView.text = name
    }
}