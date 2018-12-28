package de.vorb.cli

import picocli.CommandLine

fun main(vararg args: String) {
    CommandLine.run(Example(), *args)
}
