# Changelog

## [1.0.0] - 2026-03-14
### Added
- Khởi tạo dự án Android Mobile (Kotlin) cho thiết bị Handy Terminal.
- Tích hợp chuẩn CameraX API để hiển thị preview.
- Tích hợp Google ML Kit Barcode Scanning để nhận diện mã vạch và QR code.
- Cơ chế âm thanh báo hiệu (ToneGenerator) khi quét thành công.
- Cấu hình GitHub Actions (`build.yml`) để tự động đóng gói file APK.
- Giao diện người dùng tối giản hiển thị Data và Format mã.

### Fixed
- Lỗi build trên GitHub Actions do không khớp version Gradle (đã cố định về Gradle 8.2).
- Bổ sung Proguard rules để tránh lỗi đóng gói thư viện ML Kit.
