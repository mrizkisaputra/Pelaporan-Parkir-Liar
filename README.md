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
    * logout user
* User manajemen pelaporan
    * create laporan parkir liar
    * update laporan parkir liar
    * get laporan parkir liar
    * search laporan parkir liar
    * remove laporan parkir liar
    * list laporan parkir liar

## API yang tersedia untuk si user pengawas

* list laporan parkir liar

## Cara Request API user pelapor

1. Agar bisa melakukan request ke _endpoint_ user sebagai pelapor, silahkan registrasi terlebih dahulu. Dengan cara
   seperti ini.

   ```http request
     POST http://localhost:port_number/auth/register
   ```
   request http body
   ```json
       {
         "username": "example",
         "password": "example"
       }
   ```

   response http body
   ```json
   {
    "status": "CREATED",
    "message": "registrasi berhasil",
    "data": {
      "username": "rizki",
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





















