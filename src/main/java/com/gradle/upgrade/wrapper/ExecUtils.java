package com.gradle.upgrade.wrapper;

import org.gradle.process.ExecOperations;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;

final class ExecUtils {

    // todo (etst) make more generic
    static void execGradleCmd(ExecOperations execOperations, Path workingDir, Object... args) {
        execCmd(execOperations, workingDir, "./gradlew", args);
    }

    static void execGitCmd(ExecOperations execOperations, Path workingDir, Object... args) {
        execCmd(execOperations, workingDir, "git", args);
    }

    private static void execCmd(ExecOperations execOperations, Path workingDir, String cmd, Object... args) {
        var cmdLine = new LinkedList<>();
        cmdLine.add(cmd);
        cmdLine.addAll(Arrays.asList(args));
        execOperations.exec(
            execSpec -> {
                execSpec.workingDir(workingDir);
                execSpec.commandLine(cmdLine);
            });
    }

    private ExecUtils() {
    }

}
