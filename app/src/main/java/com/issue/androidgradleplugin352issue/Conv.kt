package com.issue.androidgradleplugin352issue

import androidx.databinding.InverseMethod

object Conv {

    @JvmStatic
    @InverseMethod("stringToInt")
    fun intToString(value: Int?): String? = value?.toString()

    @JvmStatic
    fun stringToInt(value: String?): Int? = if (value?.matches(Regex(pattern = """\d+""")) == true) Integer.parseInt(value) else 0
}