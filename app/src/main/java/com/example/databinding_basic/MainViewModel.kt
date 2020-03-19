package com.example.databinding_basic

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    val currentRandomFruitName: LiveData<String>
        get() = FakeRepository.currentRandomFruitName

    fun onChangeRandomFruitClick() = FakeRepository.changeCurrentRandomFruitName()

    @Bindable
    val editTextContent = MutableLiveData<String>()

    private val _displayedEditTextContent = MutableLiveData<String>()
    val displayedEditTextContent: LiveData<String>
        get() = _displayedEditTextContent // Nhan gia tri tu event click

    fun onDisplayEditTextContentClick() {
        _displayedEditTextContent.value = editTextContent.value // Tra gia tri cho textview
    }

    fun onSelectRandomEditTextFruit() {
        //Gan g.tri lai cho edtext
        editTextContent.value = FakeRepository.getRandomFruitName()
    }
}