# Phase 02: App Core Structure
Status: ⬜ Pending
Dependencies: Phase 01

## Objective
Khai báo cấu trúc thư mục App cơ bản, phân quyền Camera, file hằng số rỗng và Icon nếu cần.

## Requirements
### Functional
- [ ] Khai báo quyền `<uses-permission android:name="android.permission.CAMERA" />` trong `AndroidManifest.xml`.
- [ ] Khai báo App Theme và String resources.

## Implementation Steps
1. [ ] Cấu trúc thư mục: `app/src/main/java/com/example/handyscanner/` và `app/src/main/res/`
2. [ ] Tạo file `AndroidManifest.xml` (Khai báo thẻ `<application>` và `<activity>` chính).
3. [ ] Tạo file `res/values/strings.xml` (Cấu hình tên App).
4. [ ] Tạo file `res/values/colors.xml` (Design tối hạt: đen/trắng nịnh mắt).
5. [ ] Tạo file `res/values/themes.xml` (Khởi tạo App Theme cơ bản).

## Test Criteria
- [ ] Gradle Sync không báo lỗi thiếu thư mục.

---
Next Phase: Phase 03 - UI Implementation
