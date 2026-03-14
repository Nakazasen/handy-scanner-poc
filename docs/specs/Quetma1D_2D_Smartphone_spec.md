# Spec: Quetma1D_2D_Smartphone (Handy Scanner)

## 1. Executive Summary
Ứng dụng Android Native tối giản, chuyên dụng cho mục đích quét barcode (1D) và QR code (2D) trên các thiết bị Handy Terminal công nghiệp. Điểm mấu chốt là tốc độ phản hồi cực nhanh, chính xác cao và âm thanh thông báo rõ ràng để làm Proof of Concept (PoC) cho đối tác. Ứng dụng được thiết kế để build tự động qua GitHub Actions, giải quyết vấn đề không thể cài Android Studio tại client.

## 2. User Stories
- Là người trình diễn PoC, tôi muốn mở app lên là camera hoạt động ngay lập tức để không mất thời gian thao tác.
- Là nhân viên scan mã trên hóa đơn EDI, tôi muốn ứng dụng tự động nhận diện cả mã QR và mã Code 39 (1D) mà không cần chuyển đổi chế độ.
- Là người dùng trong môi trường công nghiệp ồn ào, tôi cần nghe thấy tiếng "Beep" rõ ràng ngay khi quét thành công để biết đã nhận diện được mã.
- Là lập trình viên không có Android Studio, tôi cần cấu trúc dự án chuẩn để push code lên GitHub là có ngay file APK tải về.

## 3. Tech Stack
- **Platform:** Android Native (Min SDK 24, Target SDK 34)
- **Language:** Kotlin
- **Core Library:** 
  - `com.google.mlkit:barcode-scanning` (Siêu tốc độ, chính xác cao, nhận diện Offline)
  - `androidx.camera:camera-camera2` (CameraX - Tự động quản lý vòng đời và autofocus cực tốt)
- **CI/CD:** GitHub Actions (Ubuntu latest, Java 17, Gradle)

## 4. Giao diện (UI Components)
- **Camera Preview:** Chiếm toàn bộ màn hình (Full Screen).
- **Overlay View (Tùy chọn):** Một khung ngắm (viewfinder) đơn giản ở giữa để người dùng dễ căn chỉnh (có thể bỏ qua nếu muốn cực kỳ tối giản).
- **Result TextView:** Nằm ở cạnh dưới màn hình, hiển thị luân phiên hoặc cả 2 dòng:
   - `Data: [Nội dung giải mã]`
   - `Format: [Định dạng, VD: FORMAT_CODE_39]`
   - Font chữ to, màu nổi bật (VD: chữ trắng viền đen hoặc nền đen mờ) để dễ đọc.

## 5. Logic Flow
1. Khởi chạy App -> Xin quyền Camera.
2. Khởi tạo CameraX, bind lifecycle của Camera vào Activity.
3. Đưa luồng hình ảnh từ CameraX vào `ImageAnalysis` use case.
4. Truyền Image vào cấu hình của `BarcodeScanner` (ML Kit).
   - *Tối ưu hóa:* Cấu hình ML Kit CHỈ nhận diện định dạng `FORMAT_CODE_39` và `FORMAT_QR_CODE` để tăng tốc độ xử lý lên tối đa.
5. Khi nhận diện thành công:
   - Phát âm thanh Beep bằng `ToneGenerator`.
   - Update text lên `Result TextView`.
   - Delay một khoảng ngắn (VD: 1.5s) trước khi quét mã tiếp theo để tránh spam.

## 6. Cấu trúc thư mục (Chuẩn Gradle cho GitHub Actions)
```text
/
├── .github/
│   └── workflows/
│       └── build.yml
├── app/
│   ├── build.gradle.kts
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/com/example/handyscanner/
│           │   └── MainActivity.kt
│           └── res/
│               ├── layout/
│               │   └── activity_main.xml
│               └── values/
│                   ├── colors.xml
│                   └── strings.xml
├── build.gradle.kts
├── settings.gradle.kts
└── gradle/wrapper/
    ├── gradle-wrapper.jar
    └── gradle-wrapper.properties
```

## 7. Build Checklist (GitHub Actions)
- [x] Trigger: `on: push` vào nhánh `main`
- [x] Môi trường: `ubuntu-latest`
- [x] Java Setup: SDK version 17
- [x] Setup Gradle: Caching enabled
- [x] Make gradlew executable: `chmod +x ./gradlew`
- [x] Build command: `./gradlew assembleDebug`
- [x] Upload Artifact: `app/build/outputs/apk/debug/app-debug.apk`

## 8. Tối ưu hóa đặc biệt cho thiết bị công nghiệp (Handy Terminal)
- **Focus Mode:** Sử dụng `ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST` trong CameraX để luôn lấy frame mới nhất, bỏ qua frame bị nghẽn.
- **ML Kit Configuration:** Khai báo đích danh 2 format cần thiết qua `BarcodeScannerOptions.Builder().setBarcodeFormats(...)` để MLKit không tốn CPU quét các format thừa.
- **Audio Feedback:** Dùng `ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100)` để tạo tiếng beep mà không cần file mp3 đi kèm, tiết kiệm tài nguyên.
