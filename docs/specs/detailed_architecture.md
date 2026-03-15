# Đặc tả Kỹ thuật Chuyên sâu: Quetma1D_2D_Smartphone

Tài liệu này cung cấp cái nhìn toàn diện về kiến trúc, tư duy thiết kế và các giải pháp kỹ thuật cụ thể được áp dụng để biến một chiếc Smartphone thành máy quét mã vạch công nghiệp chuyên dụng.

---

## 1. Tư tưởng Cốt lõi (Core Philosophy)

### "Hardware-Aware Software" (Phần mềm hiểu phần cứng)
Thiết bị Smartphone thông thường không có đầu quét Laser chuyên dụng (Scan Engine). Để đạt tốc độ tương đương máy cầm tay chuyên dụng, ứng dụng này áp dụng tư tưởng: **Thăng hoa phần mềm để bù đắp giới hạn vật lý.**
- Thay vì quét Laser, chúng ta dùng Camera độ phân giải cao.
- Thay vì phần cứng giải mã, chúng ta dùng Trí tuệ nhân tạo (AI) xử lý luồng ảnh thời gian thực.

### "Industrial UX" (Trải nghiệm người dùng công nghiệp)
Khác với các app quét mã thông thường cho người tiêu dùng, ứng dụng này được thiết kế để hoạt động bền bỉ trong nhà máy:
- **Tập trung vào hiệu suất:** Giảm thiểu các thành phần đồ họa nặng, tập trung vào tốc độ xử lý ảnh.
- **Kiểm soát tuyệt đối:** Luồng quét chủ động giúp công nhân tránh việc quét nhầm các mã ở gần nhau trên dây chuyền sản xuất.

---

## 2. Kỹ thuật Code Chi tiết & Giải pháp

### Thách thức 1: Mã vạch mật độ cao (High-Density Barcodes - SN/IMEI)
**Vấn đề:** Các mã SN/IMEI thường rất dài và các vạch đen trắng cực sát nhau. Ở chế độ 720p, AI chỉ nhìn thấy một dải mờ màu xám.
**Giải pháp:** 
- **Nâng cấp 1080p (Full HD):** Ép CameraX hoạt động ở mức 1920x1080. Điều này làm tăng độ sắc nét của các vạch đen lên gấp 2.25 lần, cho phép AI phân biệt được các vạch mịn nhất.
- **Continuous Focus:** Cấu hình `autoFocusEnabled = true` kết hợp với Metadata của thiết bị để giữ cho thấu kính luôn ở trạng thái sẵn sàng bắt nét gần (Macro).

### Thách thức 2: Luồng quét chủ động (Active Scanning Flow)
**Vấn đề:** Quét liên tục (Continuous Scan) đôi khi gây ra hiện tượng "loạn" dữ liệu khi có nhiều mã vạch đặt cạnh nhau.
**Giải pháp:**
- **Manual Trigger:** Sử dụng biến trạng thái `isScanning`. Camera vẫn chạy preview nhưng AI giải mã chỉ được kích hoạt khi người dùng nhấn giữ/nhấn nút Scan.
- **State Reset:** Nút "Xác nhận (Clear)" thực hiện nhiệm vụ reset toàn bộ chu trình, đảm bảo dữ liệu cũ không bị ghi đè nhầm vào lượt quét mới.

### Thách thức 3: Chuyển đổi ngôn ngữ trực tiếp (Live Locale Switching)
**Vấn đề:** Thay đổi ngôn ngữ thủ công trong Android thường yêu cầu restart app hoặc thay đổi cài đặt hệ thống.
**Giải pháp:**
- **Dynamic Configuration:** Sử dụng `Context.resources.updateConfiguration` kết hợp với `recreate()`.  
- **Tối ưu hóa:** Việc gọi `recreate()` đảm bảo toàn bộ View Hierarchy được nạp lại với Resource phù hợp từ thư mục `values-xx` tương ứng mà không làm mất trạng thái logic ngầm của ứng dụng.

---

## 3. Kiến trúc Hệ thống & Vận hành

### Sơ đồ luồng (Workflow) V1.0.5
1. **Source:** CameraX API lấy mẫu hình ảnh từ Sensor ở độ phân giải Full HD.
2. **Analysis Pipe:** Chuyển đổi định dạng `YUV_420_888` sang `InputImage` của ML Kit.
3. **Logic Gate:** AI Core chỉ xử lý ảnh khi `isScanning == true`.
4. **Feedback Loop:** 
   - `ToneGenerator`: Phát tiếng "Beep" chuẩn tần số công nghiệp.
   - `UI Bridge`: Dữ liệu được đẩy vào `EditText`, cho phép công nhân chỉnh sửa thủ công trước khi xác nhận.
   - `Multi-lang Provider`: Cung cấp nhãn (Label) và hướng dẫn theo ngôn ngữ đã chọn.

### Vận hành CI/CD (GitHub Actions)
Tư tưởng "Zero Local Environment":
- Toàn bộ việc build file APK được giao cho Robot (GitHub Actions).
- **Hệ điều hành Build:** Linux (Ubuntu 22.04).
- **Trình biên dịch:** Java 17, Gradle 8.2.
- **Bảo mật thư viện:** Sử dụng các Proguard rules để bảo vệ nhân AI ML Kit khỏi bị tối ưu hóa (obfuscate) gây lỗi runtime.

---

## 4. Đặc tả Giao diện (UI Specification)

- **Input Area:** Sử dụng `EditText` với nền trắng nổi bật giúp dễ đọc mã trong môi trường thiếu sáng.
- **Trigger Button:** Thiết kế dạng `ImageButton` với Icon Camera trực quan.
- **Action Button:** Nút "Xác nhận" chiếm toàn bộ bề ngang dưới cùng, giúp thao tác bằng một tay (với ngón cái) cực kỳ thuận tiện khi đang cầm máy quét.

---

## 5. Câu hỏi "Hóc búa" & Giải pháp

**Hỏi: Tại sao không dùng Zoom tự động?**
*Trả lời:* Việc Zoom cơ học trên Smartphone gây trễ. Chúng ta dùng độ phân giải 1080p để có "Digital Clarity", cho phép quét mã nhỏ từ khoảng cách xa mà không cần Zoom.

**Hỏi: Tại sao nút XÁC NHẬN lại phải Clear dữ liệu?**
*Trả lời:* Đây là tư duy "Single Cycle". Trong nhà máy, mỗi lần quét là một tác vụ độc lập. Việc xóa dữ liệu cũ sau khi xác nhận giúp ngăn chặn việc gửi nhầm dữ liệu của mã vạch trước đó vào quy trình tiếp theo.

---
*Tài liệu được soạn thảo bởi Trí tuệ nhân tạo Antigravity cho dự án Quetma1D_2D_Smartphone.*
