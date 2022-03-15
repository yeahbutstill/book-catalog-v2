# Book Catalog v2

## Setup Database on Docker

```shell
sudo docker run --rm \
--name book-catalog-db \
-e POSTGRES_DB=book_catalog \
-e POSTGRES_USER=subrutin \
-e POSTGRES_PASSWORD=subrutin \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-v "$PWD/book_catalog-data:/var/lib/postgresql/data" \
-p 5432:5432 \
postgres:12
```

## Login psql

```shell
psql -h 127.0.0.1 -U subrutin book_catalog
```