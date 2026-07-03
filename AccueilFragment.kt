package net.mmt_entertaiment.cynbom.ui.accueil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mmt.cynbom.R
import com.mmt.cynbom.databinding.FragmentAccueilBinding
import com.mmt.cynbom.ui.viewmodel.SerieViewModel
import kotlinx.coroutines.launch

class AccueilFragment : Fragment() {

    private var _binding: FragmentAccueilBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SerieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccueilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Load series
        lifecycleScope.launch {
            viewModel.loadSeries()
            viewModel.series.observe(viewLifecycleOwner) { series ->
                // Update UI with series
                binding.content.text = "Chargement: ${series.size} séries"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
