# Phase 06: Final Review & Validation
Status: ⬜ Pending
Dependencies: Phase 05

## Objective
Kiểm tra chéo lại toàn bộ cấu trúc dự án và chuẩn bị push code lên GitHub.

## Requirements
### Functional
- [ ] Code không còn báo lỗi syntax (qua Lint trơn tru).
- [ ] Chạy lệnh `./gradlew assembleDebug` thành công tại local (nếu test được) hoặc ít nhất Action trên GitHub không crash.
- [ ] Ứng dụng khi cài trên máy có đủ quyền Camera, hiển thị màn hình preview và kêu "Bíp" khi nhận diện được đúng QR Code hoặc Code 39.

## Implementation Steps
1. [ ] Rà soát lại dependency version.
2. [ ] Rà soát lại `AndroidManifest.xml`.
3. [ ] Đẩy code lên branch `main`.
4. [ ] Theo dõi log trên tab Actions của GitHub.
5. [ ] Download file `app-debug.apk` và cài file vào máy Handy Terminal.

## Test Criteria
- [ ] Artifact `app-debug.apk` xuất hiện trên GitHub.
- [ ] Cài đặt thành công trên máy Android.
- [ ] Quét mã vạch Code 39 trên hóa đơn và QR code trên hóa đơn EDI nhận diện < 0.5s.

---
End of Plan
