# Changelog

## [1.0.4] - 2026-03-15
### Added
- **Chế độ Quét chủ động**: Thiết kế lại luồng hoạt động mô phỏng máy scan cầm tay.
- Giao diện mới: Thêm ô nhập liệu (**Textbox**), nút **Scan** nhỏ bên cạnh và nút **Xác nhận (Clear)** lớn.
- **App Icon**: Cập nhật logo ứng dụng chuyên nghiệp hơn.

### Changed
- Thay đổi logic quét: Chỉ kích hoạt Camera Scanning khi nhấn nút.
- Tự động dừng quét sau khi nhận diện thành công để người dùng kiểm tra dữ liệu.

## [1.0.3] - 2026-03-14
### Added
- Hỗ trợ mã vạch 2D công nghiệp: **Data Matrix**, **PDF417**, **Aztec**.
- Cho phép nhận diện các tem nhãn linh kiện điện tử siêu nhỏ.

### Changed
- Cập nhật thư viện ML Kit Options để quét đồng thời cả mã vạch vạch (1D) và mã khối (2D Industrial).

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
