package com.example.coincap1.ui.assetsDetails

import androidx.lifecycle.ViewModel
import com.example.coincap1.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DAssetsViewModel @Inject constructor(
    repository: Repository
) :ViewModel() {


}