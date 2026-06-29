<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# Bfme2-idea-plugin Changelog

## `0.1.4`

### Added

- Target IDEA `2026.1.3`

## `0.1.3`

### Added

- Support for folding blocks

## `0.1.2`

### Added

- Registered `.inc` files as Sage Engine INI files
- Support for additional block starts used by Sage Engine INI files

### Fixed

- Property keys ending with numbers are now lexed as properties

## `0.1.1`

### Added

- Dependency on `com.intellij.modules.platform` was added

## `0.1.0`

### Added

- Initial IntelliJ Platform plugin support for Sage Engine `.ini` files used by games such as The Lord of the Rings: The Battle for Middle-earth II.
- File type registration and lightweight PSI structure for Sage Engine INI blocks, property assignments, macro statements, comments, and script blocks.
- Syntax highlighting for blocks, properties, values, numbers, strings, comments, macros, operators, and script bodies.
- Formatter support for nested blocks, aligned property assignments, comments, and script sections.
- Include-file navigation and path completion for `#include "path/to/file.inc"` macros.
