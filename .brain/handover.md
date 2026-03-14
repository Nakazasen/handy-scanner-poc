━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
📋 HANDOVER DOCUMENT - PROJECTS: Handy Scanner PoC
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

📍 Đang làm: Đã hoàn thành hỗ trợ mã 2D công nghiệp (Data Matrix) - Phiên bản V1.0.3.
🔢 Đến bước: Chờ phản hồi tổng thể về khả năng quét đa năng (1D & 2D).

✅ ĐÃ XONG:
   - Phase 01-07: Setup và Fix lỗi IMEI/SN (1080p).
   - Phase 08: Kích hoạt Data Matrix, PDF417, Aztec cho linh kiện điện tử.
   - Toàn bộ flow nhận diện mã vạch công nghiệp đã được tối ưu.

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
