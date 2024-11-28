package com.kodeman.composestudy.qr

interface QrScannerInterface {
    fun scanCode()
}

class QrScannerKit : QrScannerInterface {
    companion object {
        private const val TAG = "QrScanner"
    }

    fun startScanning() {}

    fun initializeScanner() {}
    override fun scanCode() {

    }


}