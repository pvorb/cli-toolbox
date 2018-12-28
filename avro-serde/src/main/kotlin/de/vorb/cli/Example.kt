package de.vorb.cli

import picocli.CommandLine.Command
import picocli.CommandLine.Option
import picocli.CommandLine.Parameters
import java.io.File

@Command(name = "example", mixinStandardHelpOptions = true, version = ["Picocli example 3.0"])
class Example : Runnable {

    @Option(
        names = ["-v", "--verbose"],
        description = ["Verbose mode. Helpful for troubleshooting. Multiple -v options increase the verbosity."]
           )
    private var verbose = BooleanArray(0)

    @Parameters(arity = "1..*", paramLabel = "FILE", description = ["File(s) to process."])
    private var inputFiles: Array<File>? = null

    override fun run() {
        if (verbose.isNotEmpty()) {
            println("${inputFiles?.size} files to process...")
        }
        if (verbose.size > 1) {
            for (f in inputFiles!!) {
                println(f.absolutePath)
            }
        }
    }
}
