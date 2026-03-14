# Phase 01: Setup Environment & Gradle

Status: ⬜ Pending
Dependencies: None

## Objective

Khởi tạo cấu trúc dự án Android chuẩn và cấu hình Gradle để có thể build Kotlin qua CLI/GitHub Actions mà không cần Android Studio.

## Requirements

### Functional

- [ ] Cấu trúc thư mục Android Project chuẩn (app, gradle, properties).
- [ ] Tích hợp Gradle Wrapper (v8+).
- [ ] Khai báo đúng các dependency cho ML Kit và CameraX.

## Implementation Steps

1. [ ] Tạo file `settings.gradle.kts`.
2. [ ] Tạo file `build.gradle.kts` (Project-level).
3. [ ] Tạo file `app/build.gradle.kts` (App-level) với các dependencies:
   - `org.jetbrains.kotlin:kotlin-stdlib-jdk8`
   - `androidx.camera:camera-camera2`
   - `androidx.camera:camera-lifecycle`
   - `androidx.camera:camera-view`
   - `com.google.mlkit:barcode-scanning`
4. [ ] Tạo thư mục `gradle/wrapper` và các file liên quan (properties).

## Files to Create/Modify

- `settings.gradle.kts` - Khai báo tên dự án
- `build.gradle.kts` - Cấu hình project plugins
- `app/build.gradle.kts` - Cấu hình app SDK & thư viện
- `gradle.properties` - Cấu hình JVM args

---
Next Phase: Phase 02 - App Core Structure
