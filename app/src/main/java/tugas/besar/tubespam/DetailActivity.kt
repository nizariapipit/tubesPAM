package tugas.besar.tubespam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import tugas.besar.tubespam.databinding.ActivityDetailBinding
import tugas.besar.tubespam.retrofit.Detail
import tugas.besar.tubespam.retrofit.Photos
import tugas.besar.tubespam.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Pexels Detail"

        val findPic = intent.getParcelableExtra<Photos>(DETAIL_USER) as Photos

        detailViewModel = ViewModelProvider(this@DetailActivity).get(DetailViewModel::class.java)
        detailViewModel.isloading.observe(this, {
            showLoading(it)
        })
        detailViewModel.setDetailPhotos(findPic.ava)
        detailViewModel.getDetailPhotos().observe(this, {
            binding.apply {
                Glide.with(this@DetailActivity)
                    .load(it.ava)
                    .error(R.drawable.ic_baseline_android_24)
                    .into(binding.imgItemPhoto)
                title.text = it.alt
                fotografer.text = it.fotografer
                idFotografer.text = it.id_fotografer

            }
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        }
        else{
            binding.progressBar.visibility = View.GONE
        }
    }

    companion object {
        const val DETAIL_USER = "detail_user"
    }
}