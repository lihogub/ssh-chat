package ru.lihogub.sshchat.cli.listener

interface CommandLineInterfaceEventListener {
    fun onPrintSymbolEvent(symbol: String) {}
    fun onSendTextEvent(text: String) {}
}
