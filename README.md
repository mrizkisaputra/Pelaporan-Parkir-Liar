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