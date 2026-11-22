<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# Bfme2-idea-plugin Changelog

## `1.0.1`

### Added

- Support for `Options.ini`: the game settings it contains are completed and validated
- Support for the `MissionObjectiveList` block of `map.ini` and the `MapCache` block of `mapcache.ini`, both are reported in any other file

### Fixed

- A `Description` without `=` inside a `CommandMap` is reported as missing its `=` instead of as an unknown block
- Declarations with numeric or quoted names, such as `Rank 1` or `FontSubstitution "Albertus MT"`, are recognized as declarations
- "Find Usages" only highlights the declaration name of values like `EVA:GenericBuildingComplete-Builder-Elf`
- Clearing the content of a `BeginScript` block no longer fails
- Reformatting a selection no longer removes empty comments right next to it

## `1.0.0`

### Added

- Formatting for `#define` statements: their values are aligned and expressions like `#ADD( A 25 )` are spaced consistently
- Comments like `; @formatter:align=all` and `; @formatter:align-column=65` that change how the values of the `defines` below them are aligned
- Lua highlighting and inspections inside `BeginScript` blocks when a Lua plugin is installed

### Fixed

- Formatting only aligns the values of consecutive properties of the same block

## `0.5.0`

### Added

- Inspections for missing values, empty value lists, properties outside of blocks, missing or forbidden `=` in object properties and special
  characters in declaration names
- Support for more blocks, modules and properties that the base game and mods like Age of the Ring use
- Notification when files are too large for the IDE to parse and index, with a hint on how to raise the limit

### Changed

- Block keywords and property names are case-sensitive, like in the game
- Standard `.ini` files with `[section]` headers are ignored by this plugin

### Fixed

- Navigation, completion and "Find Usages" only treat the words of a value that reference a declaration as references
- Declaration lookups are much faster in large files
- Script blocks end at the first `EndScript`

## `0.4.0`

### Added

- Allow specifying directories that contain files from the base game or any other files that should be indexed for linting and autocompletion

## `0.3.0`

### Added

- Models for all known Sage Engine INI blocks, modules and their properties
- Completion for block, module and property names based on the INI models
- Contextual syntax highlighting based on the INI models
- Inspections and quick fixes for unknown blocks or modules, unknown properties, invalid property values, repeated properties and ignored `=` in block
  headers
- Indexing, completion and "Goto Declaration" for macros

### Fixed

- Threading issue when accessing documents

## `0.2.6`

- Improve indexing of CommandSet, MappedImage, ObjectCreationList and Science

## `0.2.5`

### Fixed

- Add indexing for MappedImage declarations
- Improve indexing of AudioEvent declarations
- Improve indexing of CommandButton declarations

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
