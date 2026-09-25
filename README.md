# ArtVista - Project Skeleton (with login, upload, dashboards)

This repository is a ready-to-run skeleton for the ArtVista project (Frontend: HTML/CSS, Backend: Java Spring Boot, Database: PostgreSQL).

## New features
- Session-based login for Admin/Artist/Customer (simple form at /login.html).
- Separate dashboards: /admin_dashboard.html, /artist_dashboard.html, /customer_dashboard.html.
- Image upload endpoint: POST /api/arts/upload (multipart form-data). Uploaded files are saved in `uploads/` and served at `/api/arts/image/{filename}`.
- Dummy payment page at /payment.html that posts to /api/payments.

## Build & Run
1. Install JDK 17+ and Maven.
2. Install PostgreSQL and create DB/user (or update application.properties).
3. From project root:
   ```
   mvn clean package
   mvn spring-boot:run
   ```
4. Open `http://localhost:8080`.

