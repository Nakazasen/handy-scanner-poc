# Phase 05: GitHub Actions Setup
Status: ⬜ Pending
Dependencies: Phase 04

## Objective
Tự động hóa toàn bộ quá trình build ứng dụng Android thành file APK bằng Gradle trên GitHub Actions.

## Requirements
### Functional
- [ ] Workflow trigger khi có push lên branch `main`.
- [ ] Môi trường build `ubuntu-latest`, JDK 17.
- [ ] Cấp quyền execution cho `./gradlew`.
- [ ] Lưu trữ và đóng gói kết quả build (APK) vào mục Artifacts trên phiên bản GitHub để tải về.

## Implementation Steps
1. [ ] Tạo file `.github/workflows/build.yml`.
2. [ ] Khai báo cấu hình YAML chuẩn mực:
```yaml
name: Build Android APK
on:
  push:
    branches: [ "main" ]
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - set up JDK 17
      - Setup Gradle
      - Make gradlew executable
      - Build with Gradle (assembleDebug)
      - Upload Artifact
```

## Files to Create/Modify
- `.github/workflows/build.yml`

---
Next Phase: Phase 06 - Final Review
