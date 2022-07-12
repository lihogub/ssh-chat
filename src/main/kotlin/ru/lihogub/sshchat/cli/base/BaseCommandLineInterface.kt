package ru.lihogub.sshchat.cli.base

import ru.lihogub.sshchat.cli.CommandLineInterface
import ru.lihogub.sshchat.cli.listener.CommandLineInterfaceEventListener

class BaseCommandLineInterface(
    private val commandLineInterfaceEventListener: CommandLineInterfaceEventListener
) : CommandLineInterface {
    private val buffer = mutableListOf<String>()

    override fun onSymbol(symbol: Char) {
        when (symbol.code) {
            13 -> {
                onEnterPressed()
            }
            in 32..126 -> {
                onKeyPressed(symbol)
            }
            127 -> {
                onBackspacePressed()
            }
        }
    }

    override fun onText(text: String) {
        clearInputField()
        commandLineInterfaceEventListener.onPrintSymbolEvent("$text\n\r")
        renderInputField()
    }

    private fun onEnterPressed() {
        commandLineInterfaceEventListener.onSendTextEvent(getInputText())
        clearInputField()
        buffer.clear()
        renderInputField()
    }

    private fun onKeyPressed(key: Char) {
        buffer.add(key.toString())
        clearInputField()
        renderInputField()
    }

    private fun onBackspacePressed() {
        if (buffer.size > 0) {
            clearInputField()
            buffer.removeLast()
            renderInputField()
        }
    }

    private fun clearInputField() = commandLineInterfaceEventListener.onPrintSymbolEvent("\b \b".repeat(buffer.size))

    private fun renderInputField() = commandLineInterfaceEventListener.onPrintSymbolEvent(getInputText())

    private fun getInputText(): String = buffer.joinToString(separator = "")
}
