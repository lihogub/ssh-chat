package ru.lihogub.sshchat.cli.base

import ru.lihogub.sshchat.cli.CommandLineInterface
import ru.lihogub.sshchat.cli.listener.CommandLineInterfaceEventListener

class BaseCommandLineInterfaceFactory : CommandLineInterface.Factory {
    override fun create(commandLineInterfaceEventListener: CommandLineInterfaceEventListener): CommandLineInterface {
        return BaseCommandLineInterface(commandLineInterfaceEventListener)
    }
}