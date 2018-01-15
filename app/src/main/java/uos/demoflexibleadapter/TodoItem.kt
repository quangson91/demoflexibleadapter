package uos.demoflexibleadapter

import android.view.View
import android.widget.TextView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder

/**
 * Created by sondq on 1/15/18.
 */
class TodoItem(val todo: Todo) : AbstractFlexibleItem<TodoItem.ViewHolder>() {

    override fun equals(other: Any?): Boolean {
        if (other is TodoItem) {
            return other.todo == todo
        }
        return false
    }

    override fun getLayoutRes() = R.layout.item_todo

    override fun bindViewHolder(adapter: FlexibleAdapter<out IFlexible<*>>?, holder: ViewHolder?, position: Int, payloads: MutableList<Any>?) {
        holder?.bind(todo)
    }

    override fun createViewHolder(view: View, adapter: FlexibleAdapter<out IFlexible<*>>): ViewHolder {
        return ViewHolder(view, adapter)
    }

    override fun isSwipeable() = true

    override fun isDraggable() = true

    class ViewHolder(view: View, adapter: FlexibleAdapter<out IFlexible<*>>) : FlexibleViewHolder(view, adapter) {
        private val tvTitle by lazy { view.findViewById<TextView>(R.id.tvTitle) }
        private val tvDescription by lazy { view.findViewById<TextView>(R.id.tvDescription) }

        private val front by lazy { view.findViewById<View>(R.id.front) }
        private val rearLeft by lazy { view.findViewById<View>(R.id.rearLeft) }
        private val rearRight by lazy { view.findViewById<View>(R.id.rearRight) }

        fun bind(todo: Todo) {
            tvTitle.text = todo.title
            tvDescription.text = todo.description
        }

        override fun getFrontView() = front
        override fun getRearRightView() = rearRight
        override fun getRearLeftView() = rearLeft
    }
}