<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# Bfme2-idea-plugin Changelog

## `0.2.5`

### Fixed

- Add indexing for MappedImage declarations
- Improve indexing of AudioEvent declarations

## `0.2.4`

### Fixed

- Improve indexing for FXList, ModifierList, Object, Upgrade and Weapon

## `0.2.3`

### Fixed

- Improve indexing of declarations and their usages

## `0.2.2`

### Fixed

- File icon size is now correct

## `0.2.1`

### Fixed

- "Find Usages" now finds every use-site of a declaration
- "Goto Declaration" and "Find Usages" now match declaration reference names case-insensitively

## `0.2.0`

### Added

- Some declarations are now indexed to support navigating to use-sites or from use-sites to the declaration. This also enables very basic autocomplete for
  use-sites

## `0.1.5`

### Fixed

- Pressing `Enter` now keeps the cursor at the indentation level of the current Sage Engine INI block
- `#include` completion now suggests files correctly

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
