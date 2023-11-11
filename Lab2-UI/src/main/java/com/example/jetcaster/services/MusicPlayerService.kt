package com.example.jetcaster.services

import android.app.DownloadManager
import android.app.Service
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import android.widget.Button
import android.widget.EditText


class MusicPlayerService : Service() {
    // declaring object of MediaPlayer

    private var m: MediaPlayer? = null

    // execution of service will start
    // on calling this method
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        var url = "https://d11untcg2uthr3.cloudfront.net/v1/variant/6a91d90c-c350-51b1-b668-9de6d4344179.mp3?session_id=3111e0c4-92d0-5ac1-88f5-ce065a91ffe8&ab=128&al=19945268&ao=2100&ct=DOWNLOAD&episode_id=8393034&show_id=5099418&user_id=US_Networth_and_Chill&organization_id=audioboom&tenant=AUDIOBOOM&timestamp=1699068780&metadata=dist%3Dgeneral_run_ads%26one_min%3D962100%26pl%3Dweb_player%26sub%3Dex&response-content-disposition=inline&media_type=dynamic&fallback_url=https%3A%2F%2Fd11untcg2uthr3.cloudfront.net%2Fattachments%2F41059632%2Fi-will-have-rich-kids.mp3%3Fab%3D128%26al%3D19945268%26ao%3D2100%26ct%3DDOWNLOAD%26episode_id%3D8393034%26show_id%3D5099418%26user_id%3DUS_Networth_and_Chill%26organization_id%3Daudioboom%26tenant%3DAUDIOBOOM%26timestamp%3D1699068780%26metadata%3Ddist%253Dgeneral_run_ads%2526one_min%253D962100%2526pl%253Dweb_player%2526sub%253Dex%26response-content-disposition%3Dinline%26media_type%3Dstatic%26Expires%3D1699241580%26Key-Pair-Id%3DK1J2BR3INU6RYD%26Signature%3Dm4RuJ9wXZDR81l4~67H-M8-spwe~WGAJZaw265T4MEvl~bnWT0u3fAgihgSeoFaB-Mn81y~Dp3FWk9SX-Zq8VWguR4YcTQEYmKoR705IhF2lQkvC~emv2RUBpLZmaZ8-Y-XdfcE-jIwOr7WATiBDe-ZLvjGA-WzwUkN-C6125yUbP3trI~EhqmjdCXlQtIUiJtcBVc4U7a2hC~OQ~jOG8Zw~QZElQ18wqBoY8VEyyG3oeOs2VAFfWGnbGY-rqTGkDKx2w~uyL4SbYXxCf-1sFELM~Yxk4CfDexnxHT-MHiXypLx6symC38tok4gbjle4al6t4Z~2DD1r0GV1rQmWjA__&Expires=1699241581&Key-Pair-Id=K1J2BR3INU6RYD&Signature=ZlMVQXRDI8t5q2GfidPJ7MGI-cW8iMtNVWt-CGzrbfYGHUCHDgrmFhq7uzu3s4NVlyXIpxHElqV9Ake2DS1McsTT~BOi86dnYSeOln-32vOdgsxwugiRt-2bQ7NZWw442CeKAB0J0grn2zP-xObdkuBRzd5Q7vHp~GBoJGSNTt2LoTmrBlzEepUWUDAxdcgax92juLGeVReqEufXysFI02qZUT5A7HrohaERM44alMDx92J1kKG~A0f67cBHcTQB6x7OLxCVboApGTIZg7JdHIX1wZBOmGWv99Bma~HPtGVsziwpMdp7ZCoRBYRZUf~B61HpjBLtOuxDmQXgGyP4pw__"

        startAudioStream(url)


        // returns the status
        // of the program
        return START_STICKY
    }

    // execution of the service will
    // stop on calling this method
    override fun onDestroy() {
        super.onDestroy()
        // stopping the process
        stopPlaying()
    }

    fun startAudioStream(url: String) {
        if (m == null) m = MediaPlayer()
        try {
            Log.d("mylog", "Playing: $url")
            m!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
            m!!.setDataSource(url)
            m!!.prepare()
            m!!.setVolume(1f, 1f)
            m!!.setLooping(false)
            m!!.start()
        } catch (e: java.lang.Exception) {
            Log.d("mylog", "Error playing in SoundHandler: $e")
        }
    }

    private fun stopPlaying() {
        if (m != null && m!!.isPlaying()) {
            m!!.stop()
            m!!.release()
            m = MediaPlayer()
            m!!.reset()
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}