package edu.aku.hassannaqvi.matiari_cohorts.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.aku.hassannaqvi.matiari_cohorts.R
import edu.aku.hassannaqvi.matiari_cohorts.databinding.ItemChildLayoutBinding
import edu.aku.hassannaqvi.matiari_cohorts.models.ChildModel
import java.lang.String

/*
* @author Ali Azaz Alam dt. 12.18.20
* */
class ChildViewHolder(private val bi: ItemChildLayoutBinding) :
        RecyclerView.ViewHolder(bi.root) {

    fun bind(item: ChildModel) {
//        bi.setVariable(BR.item, item)
        bi.childID.text = String.format("Child-ID: %s", item.childId)
        bi.motherName.text = String.format("Mother: %s", item.motherName)
        bi.name.text = item.childName
        val imageRes: Int = R.drawable.mem_icon
        var hhStatusText = "NULL"
        var hhStatusColor = ContextCompat.getColor(this.itemView.context, R.color.white)
        when (item.formFlag) {
            0 -> {
                hhStatusText = "OPEN"
                hhStatusColor = ContextCompat.getColor(this.itemView.context, R.color.black_overlay)
            }
            1 -> {
                bi.parentLayout.isEnabled = false
                bi.parentLayout.setBackgroundColor(ContextCompat.getColor(this.itemView.context, R.color.gray))
                hhStatusText = "CLOSED"
                hhStatusColor = ContextCompat.getColor(this.itemView.context, R.color.red_overlay)
            }
        }
        /*else {
            bi.parentLayout.isEnabled = true
            bi.parentLayout.setBackgroundColor(ContextCompat.getColor(this.itemView.context, R.color.white))
            if (flagType == 8 || flagType == 5 || flagType == 2) {
                hhStatusText = "RE-VISIT"
                hhStatusColor = ContextCompat.getColor(this.itemView.context, R.color.green_overlay)
            }
        }*/
        bi.hhStatus.text = hhStatusText
        bi.hhStatus.setBackgroundColor(hhStatusColor)
        Glide.with(this.itemView.context)
                .asBitmap()
                .load(imageRes)
                .into(bi.houseImg)
        bi.executePendingBindings()
    }


    companion object {
        fun create(parent: ViewGroup): ChildViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_child_layout, parent, false)
            val binding = ItemChildLayoutBinding.bind(view)
            return ChildViewHolder(binding)
        }

    }

    class ChildViewDiffUtils(
            private val oldList: ArrayList<ChildModel>,
            private val newList: ArrayList<ChildModel>
    ) :
            DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].childId == newList[newItemPosition].childId
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}