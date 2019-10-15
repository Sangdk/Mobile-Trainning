package com.rikkei.training.livedatakotlin.viewmodel

import androidx.lifecycle.LiveData
import com.rikkei.training.livedatakotlin.database.WordDao
import com.rikkei.training.livedatakotlin.model.Word

class WordRepository(private val wordDao: WordDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    // The suspend modifier tells the compiler that this must be called from a
    // coroutine or another suspend function.
    suspend fun insert(word: Word){
        wordDao.insert(word)
    }
}