package net.mmt_entertaiment.cynbom.ui.parametres

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mmt.cynbom.databinding.FragmentParametresBinding

class ParametresFragment : Fragment() {

    private var _binding: FragmentParametresBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentParametresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.itemTos.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://mmt-entertaiment.github.io/Cynbom/tos.html"))
            startActivity(intent)
        }

        binding.itemCredits.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://mmt-entertaiment.github.io/Cynbom/credit.html"))
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
