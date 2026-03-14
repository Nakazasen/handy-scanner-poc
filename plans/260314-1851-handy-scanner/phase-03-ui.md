# Phase 03: UI Implementation
Status: ⬜ Pending
Dependencies: Phase 02

## Objective
Xây dựng giao diện quét mã tối giản, full màn hình camera và có chỗ trống hiển thị kết quả.

## Requirements
### Functional
- [ ] Màn hình chính (activity_main.xml) chứa `PreviewView` của CameraX.
- [ ] TextView hiển thị dòng chữ `Data: [Nội dung]` và `Format: [Định dạng]`, nền đen chữ trắng, nổi bật.

## Implementation Steps
1. [ ] Tạo file `res/layout/activity_main.xml`.
2. [ ] Thêm thẻ `<androidx.camera.view.PreviewView>` fill parent.
3. [ ] Thêm một thẻ `<TextView>` ở phía dưới màn hình (thuộc `ConstraintLayout` hoặc `FrameLayout`).

## Files to Create/Modify
- `res/layout/activity_main.xml`

---
Next Phase: Phase 04 - Scanner Logic
