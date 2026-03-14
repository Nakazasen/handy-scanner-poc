━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
📋 HANDOVER DOCUMENT - PROJECTS: Handy Scanner PoC
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

📍 Đang làm: Đã hoàn thành xử lý lỗi quét mã vạch mật độ cao (IMEI/SN) - Phiên bản V1.0.2.
🔢 Đến bước: Chờ phản hồi kiểm thử thực địa từ người dùng với bản build 1080p.

✅ ĐÃ XONG:
   - Phase 01-06: Khởi tạo và build app cơ bản.
   - Phase 07: Debug & Fix lỗi không quét được mã vạch IMEI (V1.0.1 & V1.0.2).
   - Nâng cấp độ phân giải camera lên 1080p.
   - Tối ưu lấy nét và mở rộng định dạng mã (Code 128, EAN, UPC).

⏳ CÒN LẠI:
   - Kiểm tra hiệu năng thực tế trên thiết bị Handy Terminal chuyên dụng.
   - (Tương lai) Tích hợp gửi dữ liệu lên Server qua API.

🔧 QUYẾT ĐỊNH QUAN TRỌNG:
   - **Mã vạch công nghiệp (IMEI)**: Bắt buộc dùng 1080p vì 720p bị mờ các vạch mảnh.
   - **ML Kit Options**: Bật full định dạng 1D để tránh sót mã.
   - **UI**: Giữ đường vạch đỏ tĩnh để người dùng dễ căn chỉnh tâm mã vạch.

⚠️ LƯU Ý CHO SESSION SAU:
   - Luôn dùng file `MainActivity.kt` hiện tại làm gốc vì đã tối ưu Focus và Resolution.
   - Nếu máy Handy Terminal đời cũ yếu, có thể phải cân nhắc hạ xuống 720p và dùng thuật toán làm nét ảnh thủ công.

📁 FILES QUAN TRỌNG:
   - `app/src/main/java/com/example/handyscanner/MainActivity.kt` (Scanner Logic)
   - `.brain/brain.json` (Project Knowledge Base)
   - `.brain/session.json` (Current Progress)

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
📍 Đã lưu kiến thức dự án! Để tiếp tục: Gõ /recap
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
