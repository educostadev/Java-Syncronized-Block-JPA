# How to use Java synchronized to lock a block of code for concurrent access
See [MyService.java](src/main/java/dev/educosta/locking/MyService.java)
```java
final Object lock = new Object();

    public void saveOne() {
        synchronized (lock) {
            var maxId = repository.findMax();
            var entity = MyEntity.create(maxId + 1);
            repository.save(entity);
        }
    }
```

# Testing

Run the application and...

Create 10 Threads and save 100 records each

```bash
curl --location --request POST 'localhost:8080/create'
```

Count the number of records created

```bash
curl --location --request GET 'localhost:8080/records'
```

Return only duplicate records if exists

```bash
curl --location --request GET 'localhost:8080/all-duplicates'
```

Return all records created

```bash
curl --location --request GET 'localhost:8080/all'
```





