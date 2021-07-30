package com.juliakorolko.fantasticfour.comicOverview

import android.util.Log
import androidx.lifecycle.*
import com.juliakorolko.fantasticfour.BuildConfig
import com.juliakorolko.fantasticfour.comicOverview.model.Comic
import com.juliakorolko.fantasticfour.network.ComicApi
import kotlinx.coroutines.launch
import java.lang.Exception

val MARVEL_API_HASH: String = "9e9036e30c6d8258e998e1a9a27898fa"
val TS: String = "1234"
val COMIC_ID: Int = 17

enum class MarvelApiStatus { LOADING, ERROR, DONE }

class ComicOverviewViewModel : ViewModel() {

    private val _comic = MutableLiveData<Comic>()
    val comic: LiveData<Comic>
        get() = _comic

    private val _status = MutableLiveData<MarvelApiStatus>()
    val status: LiveData<MarvelApiStatus>
        get() = _status

    init {
        showComicInfo()
    }

    private fun showComicInfo() {
        viewModelScope.launch {
            _status.value = MarvelApiStatus.LOADING
            try {
                _comic.value = ComicApi.retrofitService.getComicById(
                    COMIC_ID, TS, BuildConfig.MARVEL_API_KEY, MARVEL_API_HASH)
                _status.value = MarvelApiStatus.DONE
            } catch (e: Exception) {
                Log.d("Error", e.message.toString())
                _status.value = MarvelApiStatus.ERROR
            }
        }
    }

    val displayBook = Transformations.map(_comic) {
        it.data.results.get(0)
    }

    val imageUrl = Transformations.map(displayBook) {
        it.thumbnail.path.plus('.').plus(it.thumbnail.extension)
    }
}