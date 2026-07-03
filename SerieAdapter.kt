package net.mmt_entertaiment.cynbom.ui.recherche

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mmt.cynbom.data.model.Serie
import com.mmt.cynbom.databinding.ItemSerieBinding

class SerieAdapter(
    private val series: List<Serie>,
    private val onItemClick: (Serie) -> Unit
) : RecyclerView.Adapter<SerieAdapter.SerieViewHolder>() {

    inner class SerieViewHolder(private val binding: ItemSerieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(serie: Serie) {
            binding.apply {
                serieTitle.text = serie.titre
                serieStudio.text = serie.studio ?: ""
                serieYear.text = serie.annee?.toString() ?: ""
                serieGenre.text = serie.genre ?: ""

                if (!serie.image.isNullOrEmpty()) {
                    Glide.with(itemView)
                        .load(serie.image)
                        .into(serieImage)
                }

                root.setOnClickListener { onItemClick(serie) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerieViewHolder {
        val binding = ItemSerieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SerieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SerieViewHolder, position: Int) {
        holder.bind(series[position])
    }

    override fun getItemCount(): Int = series.size
}
