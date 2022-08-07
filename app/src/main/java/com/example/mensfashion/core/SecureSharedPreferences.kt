package com.example.mensfashion.core

import android.R.attr.password
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.google.gson.GsonBuilder
import java.io.UnsupportedEncodingException
import java.lang.StringBuilder
import java.security.InvalidAlgorithmParameterException
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.spec.InvalidKeySpecException
import java.security.spec.InvalidParameterSpecException
import javax.crypto.*
import javax.crypto.spec.SecretKeySpec
import kotlin.Boolean as Boolean

private const val PREFERENCES_FILE_NAME = "PREFERENCES_FILE_NAME"

// random key with size of 32 for AES Encryption
private const val PREFERENCES_SECRET_KEY = "BVFDH6UROEN0JD898D1VTWWEHDR4GJ6S"

object SecureSharedPreferences {

     lateinit var preferences: SharedPreferences
    private lateinit var refrance: SecureSharedPreferences

    fun initPreferences(context: Context): SecureSharedPreferences {
        val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        preferences =
            EncryptedSharedPreferences.create(
                context,
                PREFERENCES_FILE_NAME,
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        refrance = this
        return refrance
    }

    private fun String.encryptMsg(secret: SecretKey?): String? {
        /* Encrypt the message. */
        return try {
            val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
            cipher.init(Cipher.ENCRYPT_MODE, secret)
            val stringValue = StringBuilder()
            val cipherArr = cipher.doFinal(this.toByteArray(charset("UTF-8")))
            for (i in cipherArr) {
                stringValue.append("${i}#")
            }
            return stringValue.toString()
        } catch (e: Throwable) {
            this
        }
    }


    public fun ByteArray.decryptMsg(secret: SecretKey?): String {
        return try {
            /* Decrypt the message, given derived encContentValues and initialization vector. */
            var cipher: Cipher? = null
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
            cipher.init(Cipher.DECRYPT_MODE, secret)
            String(cipher.doFinal(this), charset("UTF-8"))
        } catch (e: Throwable) {
            Log.e("Empty", "$e")

            this.toString()
        }

    }


    /*get secret key for security */
    @Throws(NoSuchAlgorithmException::class, InvalidKeySpecException::class)
    fun generateKey(): SecretKey {
        return SecretKeySpec(PREFERENCES_SECRET_KEY.toByteArray(charset("UTF-8")), "AES")
    }

    /**
     * Used to remove object from the Preferences.
     *
     * @param key Shared Preference key with which object was removed.
     **/
    fun clear(key: String) {
        preferences.edit().remove(key).apply()
    }


    /**
     * Saves object into the Preferences.
     *
     * @param objectToSave Object of model class (of type [T]) to save
     * @param key Key with which Shared preferences to
     **/
    fun <T> save(objectToSave: T, key: String) {
        //Convert object to JSON String.
        val jsonString = GsonBuilder().create().toJson(objectToSave)
        //Save that String in SharedPreferences
        val finalValue = jsonString.encryptMsg(generateKey())
        preferences.edit().putString(key, finalValue).apply()
    }


    /**
     * Used to retrieve object from the Preferences.
     *
     * @param key Shared Preference key with which object was saved.
     **/
    inline fun <reified T> retrieve(key: String): T? {
        //We read JSON String which was saved.
        val value = preferences.getString(key, "empty")
        //JSON String was found which means object can be read.
        //We convert this JSON String to model object. Parameter "c" (of
        //type Class < T >" is used to cast.
        Log.e("Type=", T::class.java.simpleName)
        return if (value == "empty") {
            returnDefaultForEmptyValues()
        } else {
            // get value of decrypted String to convert it to json
            val finalValue = value!!.fromCipherToByteArray().decryptMsg(generateKey())
            GsonBuilder().create().fromJson(finalValue, T::class.java)
        }
    }

    fun String.fromCipherToByteArray(): ByteArray {
        val arr = this.split("#")
        val byteArray = mutableListOf<Byte>()
        for (i in arr) {
            if (i.isNotEmpty()) {
                byteArray.add(i.toByte())
                Log.e("Empty", "${i.toByte()}")
            }
        }
        return byteArray.toByteArray()
    }


    inline fun <reified T> returnDefaultForEmptyValues(): T {
        return when (T::class.java.simpleName) {
            "Boolean" -> false as T
            "Int" -> 0 as T
            "Double" -> 0.0 as T
            "Float" -> 0f as T
            "Long" -> 0L as T
            else -> {
                GsonBuilder().create().fromJson("", T::class.java)  // null value
            }
        }
    }


}