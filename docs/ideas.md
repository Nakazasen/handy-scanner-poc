# Ý tưởng Dự án

- Ứng dụng Android build bằng Kotlin không dùng Android Studio trên máy (do ổ cứng đầy).
- Build file APK qua GitHub Actions.
- Ứng dụng để chứng minh phần cứng camera thiết bị Handy Terminal có thể quét siêu nhanh và chính xác.
- Hỗ trợ định dạng: QR code (2D) và CODE 39 (1D).
- Dùng thư viện: Google ML Kit Barcode Scanning (hỗ trợ đọc định dạng cực nhanh, tự quản lý autofocus).
- Giao diện: Camera full màn hình, TextView phía dưới hiển thị nội dung mã (Data) và định dạng (Format).
- Có âm thanh "Beep" khi quét thành công.
