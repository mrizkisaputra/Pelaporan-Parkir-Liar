# Web API Pelaporan Parkir Liar

Ini adalah aplikasi Web API dengan implementasi REST API

## Cara Menjalankan Projek Ini

### 1. Setup Database dengan Docker

```shell
    docker run --rm\
    --name pelaporan-parkir-liar\
    -p 5050:5432\
    -e POSTGRES_USER=parkirliar\
    -e POSTGRES_PASSWORD=GOIQ91tDMgYLP6ZzTIy4eazb32ZxyEtE \
    -e POSTGRES_DB=parkirliardb\
    postgres:16
```

### 2. Buka Projek dan Jalankan Perintah Ini

```shell
    mvn clean spring-boot:run
```

## API yang tersedia untuk si user pelapor

* User manajemen informasi
    * registrasi user
    * login user
    * get user
    * create laporan parkir liar
    * update laporan parkir liar
    * get laporan parkir liar
    * search laporan parkir liar
    * remove laporan parkir liar
    * list laporan parkir liar

## API yang tersedia untuk si user pengawas

* list laporan parkir liar

## Sebelum Request ke resource API sebagai user pelapor

1. Agar bisa melakukan request ke _resource_ sebagai user pelapor, silahkan registrasi terlebih dahulu. Dengan cara
   seperti ini.

   ```http request
     POST http://localhost:port_number/auth/register
   ```
   request body (json)
   ```json
       {
         "username": "user",
         "password": "user"
       }
   ```

   response body (json)
   ```json
   {
    "status": "CREATED",
    "message": "registrasi berhasil",
    "data": {
      "username": "user",
      "password": "$2a$10$mkfHZ2WzZP1XOa6mDC57fuVtkMCnCdKODP99IZUxUhNLy2dBlmGee",
      "authorities": {
          "id": "057e162c-2e97-4830-8f45-333732c2cced",
          "authority": "USER_PELAPOR"
      },
      "accountNonExpired": true,
      "accountNonLocked": true,
      "credentialsNonExpired": true,
      "enabled": true         
      }
   }
    ```

2.  Kemudian silahkan request ke endpoint berikut untuk mendapatkan token _JWT_. Dengan cara seperti ini
    ```http request
    POST localhost:8080/api/v1/auth/login
    ```

    request body (json)
    ```json
    {
      "username": "user",
      "password": "user"
    }
    ```
    
    response body (json)
    ```json
    {
      "status": "OK",
      "message": "Login berhasil",
      "data": {
        "user": {
            "username": "user",
            "password": "$2a$10$zA4FAmBU69SDrbd7/0fl4.47LqCtbPg1.rKkUG6c/3rVkmwnWDYtu",
            "authorities": {
                "id": "sBmDMUHZUTnIaK3pMxtV",
                "authority": "USER_PELAPOR"
            },
            "accountNonExpired": true,
            "accountNonLocked": true,
            "credentialsNonExpired": true,
            "enabled": true
        },
        "jwt": "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoidXNlciIsImlhdCI6MTcwODI1NDMxMiwicm9sZXMiOiJVU0VSX1BFTEFQT1IifQ.kmHKFSN3dl0IS8K1YiYl2Lo6tPvZpCZcT5uUIsfLOnA3Uc2Oxtv3J8T1KWs4vdXpVn0Y4R9es9jM35RAFMzpPTEH_WikavMyolD_-_jW_iRwwv958wGFahVOSuJL2w1ywRRAtoekTs16FI3L1GyjkcZCtOqVPPA_E2H5D9zUEcSHbVphwRvokHPXHofz5VoeuufE7XCwX4bc2PBi8VT7IBahcjuOgq4cMkA3kaSCVGeXFjTEzJ8JKu7pnhHudwef5krQxxv8Nzy7L4etFXz_hD-DlOc4Z81IxtCDVeqOGwL_kkr2KeENEX8DZXUEtJnqCNJFw2R98i3EngZ_BDN4RA"
      }
    }
    ```
    
## Api pengaduan parkir liar

1.  Untuk membuat laporan terhadap pelanggaran parkir liar. Dengan cara seperti ini

    ```http request
    POST localhost:8080/api/v1/users/parking/report
    ```

    request header
    ```http request
    authorization: Bearer token
    ```
    request body (form-data)
    ```text
    file: photo
    platNumber: BG7688YAP
    longitude: -jshY78skSs
    latitude: -8IjdnIU82Kh
    description: kendaraan ini membuat macet jalan karena parkir di bahu jalan
    ```
    
    response body (json)
    ```json
    {
        "status": "CREATED",
        "message": "a report on illegal parking was successfully made"
    }
    ```

   2.   Untuk mengambil semua daftar pengaduan yang dibuat. Dengan cara seperti ini
    
    ```http request
    GET localhost:8080/api/v1/users/parking/report
    ```

    request header
    ```http request
    authorization: Bearer token
    ```

    response body (json)
    ```json
    {
        "status": "OK",
        "message": "berhasil mengambil semua pengaduan laporan parkir liar",
        "data": [
            {
                "id": "6f057522-f6db-4992-b14f-8f36c4678ec5",
                "photoUrl": "https://firebasestorage.googleapis.com/v0/b/parking-report.appspot.com/o/3f7d7baa-3020-4159-a7c6-2a9c10efe3af.jpeg?alt=media",
                "platNumber": "BG7696YAP",
                "longitude": "-8982h3rr9hsj",
                "latitude": "-jduk8202fn",
                "description": "mobil ini parkir di bahu jalan"
            },
            {
                "id": "361c1270-4f60-41af-a869-fae4a50fa1d2",
                "photoUrl": "https://firebasestorage.googleapis.com/v0/b/parking-report.appspot.com/o/02a34d6f-4cc1-4f18-ba89-e5d087753748.jpeg?alt=media",
                "platNumber": "BG7688YAP",
                "longitude": "-8982h3rr9hsj",
                "latitude": "-jduk8202fn",
                "description": "mobil ini parkir di bahu jalan"
            },
            {
                "id": "3d28cd7d-a675-4c64-a653-93b4e11a0206",
                "photoUrl": "https://firebasestorage.googleapis.com/v0/b/parking-report.appspot.com/o/78dea8cc-123e-4fc3-a2f2-7aa2c5f57528.jpeg?alt=media",
                "platNumber": "BG123YAP",
                "longitude": "-8982h3rr9hsj",
                "latitude": "-jduk8202fn",
                "description": "mobil ini parkir di bahu jalan"
            }
        ],
        "paging": {
            "totalElement": 3,
            "totalPages": 1,
            "size": 10
        }
    }
    ```

















