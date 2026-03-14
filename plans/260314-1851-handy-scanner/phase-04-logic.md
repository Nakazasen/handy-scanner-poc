# Phase 04: Scanner Logic (Kotlin)
Status: ⬜ Pending
Dependencies: Phase 03

## Objective
Viết logic điều khiển CameraX và xử lý luồng Frame qua ML Kit để nhận diện Barcode.

## Requirements
### Functional
- [ ] Xin quyền truy cập Camera runtime.
- [ ] Khởi tạo CameraX (Preview & ImageAnalysis).
- [ ] Thiết lập ML Kit BarcodeScanner với cấu hình chỉ đọc QR_CODE và CODE_39.
- [ ] Cập nhật kết quả text format `FORMAT_CODE_39` và `QR_CODE` lên giao diện.
- [ ] Thêm Beep Audio bằng `ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100)`.
- [ ] Cơ chế Delay/Lock (VD 1.5s) ngay sau khi quét thành công để không bị spam Beep và nhảy chữ liên tục.

## Implementation Steps
1. [ ] Check Camera Permission trong `onCreate()`.
2. [ ] Viết hàm `startCamera()`.
3. [ ] Khởi tạo biến `barcodeScanner = BarcodeScanning.getClient(options)`.
4. [ ] Khởi tạo `ImageAnalysis` và truyền ảnh qua hàm `processImageProxy()`.
5. [ ] Cập nhật UI trong block `.addOnSuccessListener`.

## Files to Create/Modify
- `java/com/example/handyscanner/MainActivity.kt`

---
Next Phase: Phase 05 - GitHub Actions Setup
