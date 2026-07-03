package net.mmt_entertaiment.cynbom.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mmt.cynbom.data.api.CynbomApi
import com.mmt.cynbom.data.model.Serie
import com.mmt.cynbom.data.repository.SerieRepository
import kotlinx.coroutines.launch

class SerieViewModel : ViewModel() {

    private val repository = SerieRepository()

    private val _series = MutableLiveData<List<Serie>>()
    val series: LiveData<List<Serie>> = _series

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun loadSeries() {
        viewModelScope.launch {
            _loading.value = true
            try {
                val result = repository.getSeries()
                _series.value = result
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }

    fun searchSeries(query: String) {
        viewModelScope.launch {
            _series.value = repository.getSeries().filter { serie ->
                serie.titre.contains(query, ignoreCase = true) ||
                serie.studio?.contains(query, ignoreCase = true) == true
            }
        }
    }
}
