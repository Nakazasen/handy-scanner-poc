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

## [1.0.2] - 2026-03-14
### Changed
- Nâng độ phân giải CameraX ImageAnalysis lên **Full HD (1080p)**.
- Tối ưu hóa lấy nét liên tục (Continuous Focus) cho mã vạch mật độ cao.

### Added
- Hỗ trợ thêm các định dạng mã vạch công nghiệp: `Code 128`, `EAN-13`, `EAN-8`, `ITF`, `UPC-A`, `UPC-E`.
- Thêm đường kẻ đỏ (Viewfinder guide) hỗ trợ ngắm mã chính xác.

## [1.0.1] - 2026-03-14
### Changed
- Nâng độ phân giải phân tích hình ảnh lên 720p.
- Mở rộng hỗ trợ định dạng `Code 128`, `EAN`, `ITF`.
