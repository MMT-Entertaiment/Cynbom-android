package net.mmt_entertaiment.cynbom.ui.recherche

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mmt.cynbom.databinding.FragmentRechercheBinding
import com.mmt.cynbom.ui.viewmodel.SerieViewModel
import kotlinx.coroutines.launch

class RechercheFragment : Fragment() {

    private var _binding: FragmentRechercheBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SerieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRechercheBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchBar.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    viewModel.searchSeries(it)
                }
                return true
            }
        })

        viewModel.series.observe(viewLifecycleOwner) { series ->
            binding.searchResults.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = SerieAdapter(series) { serie ->
                    // Open serie detail
                }
            }
            binding.emptyMessage.visibility = if (series.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
