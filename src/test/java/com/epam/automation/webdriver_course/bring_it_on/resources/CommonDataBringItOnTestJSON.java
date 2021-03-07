package com.epam.automation.webdriver_course.bring_it_on.resources;

import com.epam.automation.webdriver_course.enums.ExpirationTime;
import com.epam.automation.webdriver_course.enums.SyntaxHighlighting;

import java.util.ArrayList;
import java.util.List;

public final class CommonDataBringItOnTestJSON {
    private final String typeSyntax = SyntaxHighlighting.BASH.getType();
    private final String expirationTime = ExpirationTime.MINUTES_10.getExpiration();
    private final String titleName = "how to gain dominance among developers";
    private final List<String> sampleBashCode = new ArrayList<>(List.of(
            "git config --global user.name \"New Sheriff in Town\"",
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")",
            "git push origin master --force")
    );

    private final List<String> commandsGitBash = new ArrayList<>(List.of(
            "git config",
            "git reset",
            "git commit-tree",
            "git push",
            "tree")
    );

    private final List<String> characterBashWrap = new ArrayList<>(List.of(
            "(",
            ")",
            "{",
            "}")
    );

    public List<String> getCommandsGitBash() {
        return commandsGitBash;
    }

    public List<String> getCharacterBashWrap() {
        return characterBashWrap;
    }

    public String getTypeSyntax() {
        return typeSyntax;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public String getTitleName() {
        return titleName;
    }

    public List<String> getSampleBashCode() {
        return sampleBashCode;
    }
}
