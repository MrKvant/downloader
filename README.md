# Downloader
Консольное приложение для загрузки файлов по HTTP протоколу.

### Параметры:
```-l``` -ссылка на файл.

```-f``` -путь к файлу, содержащиму ссылки.

```-p``` -путь на файловой системе, куда нужно сохранить файл.

```-t``` -количество потоков.

```-n``` -имя, под которым сохраняется файл(используется с параметром ```-l```).

### Приложение поддерживает 3 типа файлов:
+ CSV
+ JSON
+ XML

#### Пример входного CSV:

```csv
http://mathus.ru/math/isogonal.pdf isogonal.pdf
http://mathus.ru/math/kasokr.pdf kasokr.pdf
http://docs.wixstatic.com/ugd/7aa9d6_60f12e05eb0b4a319a2aefef97df6090.pdf ryb1.pdf
http://docs.wixstatic.com/ugd/7aa9d6_dbedbe46e204469bba3aeb810104cd92.pdf ryb2.pdf
http://docs.wixstatic.com/ugd/7aa9d6_02f5f1a4f32747049fb6ba515e303ae6.pdf ryb3.pdf
http://docs.wixstatic.com/ugd/7aa9d6_4c69aaeb1e9547c29c8660ee16b5e909.pdf ryb4.pdf
```
#### Пример входного JSON:

```java
[
        {
            "url": "http://mathus.ru/math/isogonal.pdf",
            "savingName": "isogonal.pdf"
        },
        {
            "url": "http://mathus.ru/math/kasokr.pdf",
            "savingName": "kasokr.pdf" 
        }
]
```

#### Пример входного XML:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Links>
<Link>
    <url>http://mathus.ru/math/isogonal.pdf</url>
    <savingName>isogonal.pdf</savingName>
</Link>

<Link>
    <url>http://mathus.ru/math/kasokr.pdf</url>
    <savingName>kasokr.pdf</savingName>
</Link>
</Links>
```


