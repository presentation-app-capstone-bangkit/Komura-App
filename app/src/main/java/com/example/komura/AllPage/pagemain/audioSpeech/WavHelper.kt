package com.example.komura.AllPage.pagemain.audioSpeech

import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object WavHelper {
    fun writeWavHeader(
        file: File,
        pcmDataSize: Long,
        sampleRate: Int = 44100,
        channels: Int = 1,
        bitsPerSample: Int = 16
    ) {
        val fileOutputStream = FileOutputStream(file, true)
        val byteRate = sampleRate * channels * bitsPerSample / 8
        val totalDataLength = pcmDataSize + 36

        val header = byteArrayOf(
            'R'.code.toByte(), 'I'.code.toByte(), 'F'.code.toByte(), 'F'.code.toByte(),
            (totalDataLength and 0xff).toByte(), ((totalDataLength shr 8) and 0xff).toByte(),
            ((totalDataLength shr 16) and 0xff).toByte(), ((totalDataLength shr 24) and 0xff).toByte(),
            'W'.code.toByte(), 'A'.code.toByte(), 'V'.code.toByte(), 'E'.code.toByte(),
            'f'.code.toByte(), 'm'.code.toByte(), 't'.code.toByte(), ' '.code.toByte(),
            16, 0, 0, 0, 1, 0,
            channels.toByte(), 0,
            (sampleRate and 0xff).toByte(), ((sampleRate shr 8) and 0xff).toByte(),
            ((sampleRate shr 16) and 0xff).toByte(), ((sampleRate shr 24) and 0xff).toByte(),
            (byteRate and 0xff).toByte(), ((byteRate shr 8) and 0xff).toByte(),
            ((byteRate shr 16) and 0xff).toByte(), ((byteRate shr 24) and 0xff).toByte(),
            (channels * bitsPerSample / 8).toByte(), 0,
            bitsPerSample.toByte(), 0,
            'd'.code.toByte(), 'a'.code.toByte(), 't'.code.toByte(), 'a'.code.toByte(),
            (pcmDataSize and 0xff).toByte(), ((pcmDataSize shr 8) and 0xff).toByte(),
            ((pcmDataSize shr 16) and 0xff).toByte(), ((pcmDataSize shr 24) and 0xff).toByte()
        )

        fileOutputStream.write(header, 0, header.size)
        fileOutputStream.close()
    }
}