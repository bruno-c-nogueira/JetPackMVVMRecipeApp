package com.example.jetpackcodingwithmitch

import android.content.Context
import co.infinum.retromock.BodyFactory
import java.io.IOException
import java.io.InputStream


internal class ResourceBodyFactory(private val context: Context) : BodyFactory {
    @Throws(IOException::class)
    override fun create(input: String): InputStream {
        return  context.assets.open(input)
    }
}