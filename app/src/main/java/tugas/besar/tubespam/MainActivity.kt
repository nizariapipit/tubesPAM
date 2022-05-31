package tugas.besar.tubespam

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ListAdapter
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import tugas.besar.tubespam.databinding.ActivityMainBinding
import tugas.besar.tubespam.retrofit.Photos
import tugas.besar.tubespam.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showLoading(false)

        supportActionBar?.title = "Pexels Pics"

        val layoutManager = LinearLayoutManager(this)
        binding.rvUser.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvUser.addItemDecoration(itemDecoration)

        mainViewModel = ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)

        mainViewModel.photoGet().observe(this, { photoItems ->
            setListPhotosAdapter(photoItems)
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        }
        else {
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView =  menu.findItem(R.id.search).actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                getDataPhotosFromApi(query)
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        return true
    }

    private fun setListPhotosAdapter(ava: List<Photos>) {
        val list2Photos = ArrayList<Photos>()
        for (zero in ava) {
            val listAdapter = Photos(zero.ava, zero.fotografer, zero.id_fotografer, zero.alt)
            list2Photos.add(listAdapter)
        }
        val adapter = ListPhotosAdapter(list2Photos)
        binding.rvUser.adapter = adapter
        adapter.setOnItemClickCallback(object :ListPhotosAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Photos) {
                detailPhotos(data)
            }
        })
        showLoading(false)
    }

    private fun detailPhotos(pho: Photos) {
        val detailPhotos = Intent(this@MainActivity, DetailActivity::class.java)
        detailPhotos.putExtra(DetailActivity.DETAIL_USER, pho)
        startActivity(detailPhotos)
    }

    private fun getDataPhotosFromApi(query: String) {
        if(query.isEmpty()) return
        showLoading(true)
        mainViewModel.photoSet(query)
    }

    companion object{
        private const val TAG ="MainActivity"
    }
}