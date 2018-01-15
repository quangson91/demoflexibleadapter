package uos.demoflexibleadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import eu.davidea.flexibleadapter.FlexibleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
        FlexibleAdapter.OnItemMoveListener,
        FlexibleAdapter.OnItemClickListener,
        FlexibleAdapter.OnItemSwipeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = mutableListOf<TodoItem>().also {
            it.add(TodoItem(Todo("1", "One")))
            it.add(TodoItem(Todo("2", "Two")))
            it.add(TodoItem(Todo("3", "Three")))
        }
        val adapter = FlexibleAdapter<TodoItem>(items)
        rvTodo.layoutManager = LinearLayoutManager(this)
        rvTodo.adapter = adapter
        adapter.setLongPressDragEnabled(true)
                .setHandleDragEnabled(true)
                .setSwipeEnabled(true)
                .addListener(this)
    }


    override fun onActionStateChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {

    }

    override fun shouldMoveItem(fromPosition: Int, toPosition: Int): Boolean {
        return fromPosition != toPosition
    }

    override fun onItemClick(position: Int): Boolean {
        return true
    }

    override fun onItemSwipe(position: Int, direction: Int) {
    }
}
