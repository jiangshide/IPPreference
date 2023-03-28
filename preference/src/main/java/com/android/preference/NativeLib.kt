package com.android.preference

class NativeLib {

    /**
     * A native method that is implemented by the 'preference' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'preference' library on application startup.
        init {
            System.loadLibrary("preference")
        }
    }
}