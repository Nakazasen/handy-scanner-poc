# Đặc tả Kỹ thuật Chuyên sâu: Quetma1D_2D_Smartphone

Tài liệu này cung cấp cái nhìn toàn diện về kiến trúc, tư duy thiết kế và các giải pháp kỹ thuật cụ thể được áp dụng để biến một chiếc Smartphone thành máy quét mã vạch công nghiệp chuyên dụng.

---

## 1. Tư tưởng Cốt lõi (Core Philosophy)

### "Hardware-Aware Software" (Phần mềm hiểu phần cứng)
Thiết bị Smartphone thông thường không có đầu quét Laser chuyên dụng (Scan Engine). Để đạt tốc độ tương đương máy cầm tay chuyên dụng, ứng dụng này áp dụng tư tưởng: **Thăng hoa phần mềm để bù đắp giới hạn vật lý.**
- Thay vì quét Laser, chúng ta dùng Camera độ phân giải cao.
- Thay vì phần cứng giải mã, chúng ta dùng Trí tuệ nhân tạo (AI) xử lý luồng ảnh thời gian thực.

### "Speed over Everything" (Tốc độ là trên hết)
Mọi dòng code đều hướng tới việc giảm độ trễ (Latency):
- Bỏ qua các bước xử lý ảnh màu dư thừa, nạp trực tiếp luồng byte vào AI scanner.
- Cơ chế Debounce (Chống rung/chống lặp) được tinh chỉnh để người dùng có thể quét liên tục hàng trăm mã mà không bị nghẽn.

---

## 2. Kỹ thuật Code Chi tiết & Giải pháp cho Câu hỏi hóc búa

### Thách thức 1: Mã vạch mật độ cao (High-Density Barcodes - SN/IMEI)
**Vấn đề:** Các mã SN/IMEI thường rất dài và các vạch đen trắng cực sát nhau. Ở chế độ 720p, AI chỉ nhìn thấy một dải mờ màu xám.
**Giải pháp:** 
- **Nâng cấp 1080p (Full HD):** Ép CameraX hoạt động ở mức 1920x1080. Điều này làm tăng độ sắc nét của các vạch đen lên gấp 2.25 lần, cho phép AI phân biệt được các vạch mịn nhất.
- **Continuous Focus:** Cấu hình `autoFocusEnabled = true` kết hợp với Metadata của thiết bị để giữ cho thấu kính luôn ở trạng thái sẵn sàng bắt nét gần (Macro).

### Thách thức 2: Sự khác biệt giữa QR và Data Matrix (Mã linh kiện)
**Vấn đề:** Linh kiện điện tử thường dùng mã vuông nhưng không phải QR. Nhiều người nhầm lẫn dẫn tới việc app không quét được.
**Giải pháp:** 
- **Data Matrix Integration:** Kích hoạt `Barcode.FORMAT_DATA_MATRIX`. Khác với QR có 3 mắt vuông ở góc, Data Matrix dùng khung chữ L để định hướng. AI được cấu hình để quét song song cả 2 mà không làm giảm tốc độ.

### Thách thức 3: Xử lý đa luồng & Tránh treo ứng dụng
**Kỹ thuật:** 
- Sử dụng `ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST`. Nếu máy xử lý không kịp, nó sẽ tự động bỏ qua các frame cũ để tập trung vào frame mới nhất từ Camera. Điều này cực kỳ quan trọng trên các điện thoại cấu hình thấp.

---

## 3. Kiến trúc Hệ thống & Vận hành

### Sơ đồ luồng (Workflow)
1. **Source:** CameraX API lấy mẫu hình ảnh từ Sensor.
2. **Analysis Pipe:** Chuyển đổi định dạng `YUV_420_888` (chuẩn Camera) sang `InputImage` của ML Kit.
3. **AI Core:** Google ML Kit thực hiện giải mã (Decipher).
4. **Feedback Loop:** 
   - `ToneGenerator`: Phát tiếng "Beep" tần số cao (80ms) ngay khi có kết quả.
   - `Debounce Logic`: Ngắt quét 1.5 giây để tránh việc 1 mã bị quét 10 lần.
   - `UI Update`: Hiển thị nội dung mã lên màn hình ngay lập tức.

### Vận hành CI/CD (GitHub Actions)
Tư tưởng "Zero Local Environment":
- Toàn bộ việc build file APK được giao cho Robot (GitHub Actions).
- **Hệ điều hành Build:** Linux (Ubuntu 22.04).
- **Trình biên dịch:** Java 17, Gradle 8.2.
- **Thách thức hóc búa:** Việc không có màn hình hiển thị khi build khiến việc debug lỗi đóng gói (Proguard/R8) rất khó. Chúng ta đã giải quyết bằng cách thêm các `rules` để bảo vệ thư viện ML Kit không bị xóa nhầm khi tối ưu dung lượng.

---

## 4. Câu hỏi "Hóc búa" & Giải pháp trong tương lai

**Hỏi: Tại sao không dùng Zoom tự động?**
*Trả lời:* Việc Zoom cơ học trên Smartphone gây trễ (0.5 - 1s). Thay vào đó, chúng ta dùng độ phân giải 1080p để có "Digital Clarity" (Độ nét kỹ thuật số), cho phép quét mã nhỏ từ khoảng cách xa 15-20cm mà không cần Zoom.

**Hỏi: PIN điện thoại có bị hao nhanh không?**
*Trả lời:* Có. Việc chạy AI + 1080p liên tục tiêu tốn nhiều năng lượng. Đây là cái giá phải trả cho tốc độ "Scan & Beep" tức thì.

---
*Tài liệu được soạn thảo bởi Trí tuệ nhân tạo Antigravity cho dự án Quetma1D_2D_Smartphone.*
