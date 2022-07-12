package ru.lihogub.sshchat.cli

import ru.lihogub.sshchat.cli.listener.CommandLineInterfaceEventListener

interface CommandLineInterface {
    fun onSymbol(symbol: Char)
    fun onText(text: String)

    interface Factory {
        fun create(commandLineInterfaceEventListener: CommandLineInterfaceEventListener): CommandLineInterface
    }
}


