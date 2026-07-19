# Sage Engine INI IntelliJ Plugin

IntelliJ Platform language support for Sage Engine `.ini` files used by games such as The Lord of the Rings: The Battle for Middle-earth II.

Get it from the [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/32514-sage-engine-ini).

## Features

- Sage Engine INI file type registration for `.ini` files
- Syntax highlighting for blocks, properties, values, numbers, strings, comments, macros, operators, and script bodies
- Formatting for nested blocks, aligned property assignments, comments, and script sections
- Include-file navigation for `#include "path/to/file.inc"` macros
- Include path completion from the current file directory
- Lightweight PSI structure for blocks, property assignments, macro statements, comments, and script blocks

## Project Structure

- `src/main/kotlin/de/darkatra/bfme2/ini` contains the language implementation
- `src/main/kotlin/de/darkatra/bfme2/ini/formatting` contains formatter and pre-format processing code
- `src/main/kotlin/de/darkatra/bfme2/ini/navigation` contains include references, goto declaration, and completion
- `src/main/kotlin/de/darkatra/bfme2/ini/psi` contains token, element, and PSI wrapper types
- `src/main/resources/META-INF/plugin.xml` registers IntelliJ Platform extension points
- `src/test/kotlin/de/darkatra/bfme2/ini` contains tests

## Development

Use the Gradle wrapper from the project root:

```shell
./gradlew test
./gradlew check
./gradlew runIde
```

Run `./gradlew check` before submitting changes. Formatter, parser, lexer, and include behavior are covered by automated tests and should remain compatible
unless behavior is intentionally changed.

## AI-Assisted Development

This project was built mostly with AI assistance. The code is not perfect, but it has been a useful starting point for implementing Sage Engine INI support and
learning how to work with AI coding tools more effectively.

So far, AI assistance has been useful for:

- exploring unfamiliar APIs
- drafting implementation plans
- generating tests
- refactoring repetitive code
- documenting project behavior

However, it is still important to review every change carefully, keep the scope small, and verify behavior with automated tests. AI can easily miss edge cases,
misunderstand existing conventions, or introduce subtle regressions.

When contributing, treat AI output as a starting point rather than a final authority:

- Prefer small, reviewable changes with clear intent
- Add or update tests for behavior that AI-generated code touches
- Run `./gradlew check` before submitting changes
- Update `AGENTS.md` when you learn useful workflow lessons or discover AI limitations

## Useful Links

- [Blog Post](https://darkatra.dev/2026/06/27/jetbrains-idea-plugin-for-sage-ini-files.html)
- [IntelliJ Platform SDK Documentation](https://plugins.jetbrains.com/docs/intellij/)
- [IntelliJ Platform Gradle Plugin](https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html)
- [Plugin Configuration File](https://plugins.jetbrains.com/docs/intellij/plugin-configuration-file.html)
