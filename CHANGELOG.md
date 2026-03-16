# Changelog

## [2026-03-16]
### Added
- **App-to-App Integration**: Support for implicit Intent `com.example.handyscanner.SCAN`.
- **Service Mode**: App can now automatically return scan results and close when invoked via Intent.
- **GitHub Actions**: Automated APK build workflows for both main and feature branches.
- **Intent API Spec**: Professional documentation for third-party integration.

### Changed
- **MainActivity**: Refactored to handle both standalone and service modes.
- **AndroidManifest**: Exported MainActivity with custom Intent Filter.

### Fixed
- GitHub build issue by switching to global `gradle` command.

---
## [2026-03-15]
### Initial
- Project cloned from GitHub.
- Verified CameraX and ML Kit setup.
