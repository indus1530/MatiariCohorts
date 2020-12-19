package edu.aku.hassannaqvi.matiari_cohorts.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import edu.aku.hassannaqvi.matiari_cohorts.models.ChildModel
import edu.aku.hassannaqvi.matiari_cohorts.viewholder.ChildViewHolder

/*
 * @author Ali Azaz Alam dt. 12.18.20
 * */
class ChildListAdapter(private val clickListener: OnItemClickListener) : RecyclerView.Adapter<ChildViewHolder>() {

    var childItems: ArrayList<ChildModel> = ArrayList()
        set(value) {
            field = value
            val diffCallback = ChildViewHolder.ChildViewDiffUtils(filteredChildItems, childItems)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            if (filteredChildItems.size > 0)
                filteredChildItems.clear()
            filteredChildItems.addAll(value)
            diffResult.dispatchUpdatesTo(this)
        }

     var filteredChildItems: ArrayList<ChildModel> = ArrayList()
         set(value) {
             field = value
             val diffCallback = ChildViewHolder.ChildViewDiffUtils(filteredChildItems, childItems)
             val diffResult = DiffUtil.calculateDiff(diffCallback)
             diffResult.dispatchUpdatesTo(this)
         }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ChildViewHolder {
        return ChildViewHolder.create(viewGroup)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, i: Int) {
        val item = filteredChildItems[i]
        holder.bind(item)
        holder.itemView.setOnClickListener { clickListener.onItemClick(item, i) }
    }

    override fun getItemCount(): Int = filteredChildItems.size

    interface OnItemClickListener {
        fun onItemClick(item: ChildModel, position: Int)
    }
}