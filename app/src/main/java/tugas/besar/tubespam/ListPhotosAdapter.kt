package tugas.besar.tubespam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tugas.besar.tubespam.databinding.ItemRowUserBinding
import tugas.besar.tubespam.retrofit.Photos

class ListPhotosAdapter(private val data : List<Photos>) : RecyclerView.Adapter<ListPhotosAdapter.ListViewHolder>(){

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val(ava,_,_,alt) = data[position]
        holder.apply {
            Glide.with(itemView.context)
                .load(ava)
                .error(R.drawable.ic_baseline_android_24)
                .into(binding.imgItemPhoto)
            binding.tvItemName.text = alt
            itemView.setOnClickListener { onItemClickCallback?.onItemClicked(data[adapterPosition]) }
        }
    }

    override fun getItemCount(): Int = data.size

    class ListViewHolder(val binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data : Photos)
    }
}