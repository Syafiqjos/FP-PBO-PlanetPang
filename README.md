# Final Project - Planet Pang
Merupakan sebuah Final Project dari mata kuliah Pemrograman Berbasis Objek, yaitu membuat aplikasi atau game, dengan referensi atau ide sendiri yang ditambahkan suatu fitur baru, sebagai penilaian pemahaman mahasiswa dalam mengerjakan suatu project.

# Pemrograman Berbasis Objek E
## Anggota Kelompok :
- Richard Asmarakandi - 05111940000017 - [@soraasmarakandi](https://github.com/soraasmarakandi)
- Ahmad Syafiq Aqil Wafi - 05111940000089 - [@Syafiqjos](https://github.com/Syafiqjos)
- Afifan Syafaqi Yahya - 05111940000234 - [@anakpayah](https://github.com/anakpayah)

# Tentang Planet Pang

### 1. Deskripsi
Planet pang adalah sebuah game fast-paced yang melatih kecepatan berpikir serta ketangkasan pemain dalam membedakan 2 planet yang ada dengan kecepatan tinggi untuk meraih score setinggi - tingginya.

### 2. Gameplay

![PlanetPang - Main Menu](/Images/PlanetPangMainMenu.png)

![PlanetPang - Gameplay](/Images/PlanetPangGameplayNew.png)

![PlanetPang - Achievement](/Images/PlanetPangAchievement.png)

Berikut merupakan video trailer Planet Pang.
[TRAILER PLANET PANG - YOUTUBE](https://www.youtube.com/watch?v=AUuyBHIhfu0)

Berikut merupakan penjelasan dari kami berdasarkan commit dan feature yang kami kerjakan.
[PRESENTASI VIDEO - YOUTUBE](https://youtu.be/9oP2mYigOMM)

Pemain akan disuguhkan oleh dua planet imut yang memiliki perlakuan berbeda. Planet tersebut adalah planet biru dan juga planet orange. Pemain diharuskan memilih dan membedakan planet yang ada dengan menggunakan anak panah pada keyboard, yaitu tombol arrow kiri dan tombol arrow kanan.

Sistem yang digunakan disini mirip dengan antrian atau queue, dengan antrian depan berada pada bagian paling bawah yang berarti harus diberi perlakuan terlebih dahulu. Jika planet paling bawah adalah planet berwarna biru, maka player harus menggeser ke kiri dengan cara menekan tombol arrow kiri, sedangkan jika planet paling bawah adalah planet berwarna oranye, maka pemain harus menggeser ke kanan dengan cara menekan tombol arrow kanan. Setelah planet tersebut diberlakukan dengan benar, maka planet yang ada diatasnya(antrian sebelumnya) akan turun ke bawah menjadi antrian terdepan. Planet inilah yang harus diberi perlakuan selanjutnya.

Namun perlu diperhatikan, jika pemain memberikan perlakuan yang salah pada planet(Misalnya pemain menggeser ke kiri planet berwarna oranye), maka pemain tidak akan bisa memberikan perlakuan selama 3 detik pada waktu tertentu, sehingga waktu yang dapat dimanfaatkan pun berkurang.

Pada dasarnya satu permainan dibatasi waktu sebesar 60 detik atau 1 menit, oleh karena itu pemain harus menjaga dan berhati - hati dalam memilih, karena jika melakukan kesalahan maka pemain akan kehilangan banyak waktu untuk melanjutkan permainannya.

Terdapat sistem achievement yang dapat membuat game Planet Pang tidak membosankan. Terdapat achievement yang dapat dibuka melalui permainan sehingga pemain memiliki target untuk bermain.

### 3. Kontrol
Pemain dapat memberikan perlakuan pada planet berupa menggeser ke kiri atau ke kanan. Untuk menggeser ke kiri, player dapat menekan tombol panah kiri (arrow left)pada keyboard, sedangkan untuk menggeser ke kanan, player dapat menekan tombol panah kanan (arrow right) pada keyboard.

### 4. Scoring
Pemain dapat menambah skor dengan memberikan perlakuan yang benar pada setiap planet pada antrian terdepan. Terdapat system unik untuk scoring, jadi semakin tinggi combo pemain maka jumlah score yang ditambahkan akan bertambah. Jika planet tidak diberi perlakuan benar, maka skor tidakakan berkurang, namun pemain tidak akan dapat memberi perlakuan untuk beberapa waktu, sehingga skor yang didapat tidak dapat maksimal. Setelah game selesai, jika skor melebihi Highscore, maka Highscore akan diperbarui.

### 5. Referensi

![JunglePang - Main Menu](/Images/JunglePang.png)

Permainan Planet Pang menggunakan game asli yang berjudul Jungle Pang, yaitu merupakan permainan yang dibuat oleh LINE yang menggunakan system LIFF pada pengaplikasiannya. Berikut merupakan video dari permainan Jungle Pang dan screenshot gameplay-nya.
[GAMEPLAY JUNGLE PANG LINE - YOUTUBE](https://www.youtube.com/watch?v=XhqDXo1EDyo)

# Dokumentasi
Setelah membahas gambaran awal pada game Planet Pang, berikut merupakan dokumentasi tentang class dan code - code yang digunakan dan diimplementasikan pada game Planet Pang.

## A. UML Screenshot
Meskipun agak tidak jelas karena mungkin gambar terlalu banyak sehingga hanya muat kecil, tetapi berikut gambarannya.

![Gambar UML](/Images/UMLMe.png)

## B. List Class dan Interface Planet Pang
## Class
### 1. MainApp
### 2. SceneManager
### 3. AssetManager
### 4. AchievementSystem
### 5. HighscoreSystem
### 6. GameMaster
### 7. Scene
### 8. SceneMainMenu
### 9. SceneGameplay
### 10. SceneHighscore
### 11. SceneAchievement
### 12. SceneCredits
### 13. Sprite
### 14. Ball
### 15. Button

## Interface
### 1. IScene

## C. Penjelasan List Class dan Interface Planet Pang
## Class
### 1. MainApp
Merupakan badan utama dan letak fungsi static `main()` yang ada pada game kami. Meskipun begitu kami juga menggunakan prinsip singleton pattern sehingga class `MainApp` memiliki beberapa static method dan static field yang digunakan agar class lain dapat menggunakannya tanpa menginisiasi class `MainApp` yang baru.

### 2. SceneManager
Merupakan class static yang memiliki fungsi untuk mengeload class `Scene` dimanapun kita berada (di scene manapun kita berada). Hal ini digunakan untuk mempermudah perubahan level atau scene kami. Di inisialisasi pada `mainApp` yang juga menggunakan prinsip singleton pattern.

### 3. AssetManager
Merupakan class static yang memiliki fungsi untuk menyimpan asset berupa sprite image agar class `Sprite` tidak perlu mengeload ulang. Hal ini dilakukan untuk menghemat performa game. Di inisialisasi pada `mainApp` yang juga menggunakan prinsip singleton pattern.

### 4. AchievementSystem
Merupakan class static yang memiliki fungsi untuk save dan load suatu achievement. Class ini mengimplementasikan serialization agar mempermudah save dan load suatu achievement. Setiap kali masuk gameplay akan di load dan setiap selesai gameplay achievement akan disimpan. Di inisialisasi pada `mainApp` yang juga menggunakan prinsip singleton pattern.

### 5. HighscoreSystem
Merupakan class static yang memiliki fungsi untuk save dan load suatu highscore. Class ini mengimplementasikan serialization agar mempermudah save dan load suatu highscore. Setiap kali masuk gameplay akan di load dan setiap selesai gameplay achievement akan disimpan. Di inisialisasi pada `mainApp` yang juga menggunakan prinsip singleton pattern.

### 6. GameMaster
Merupakan class yang sangat penting pada game ini. `GameMaster` merupakan class yang mengatur gameplay pada permainan pada `SceneGameplay`. Pada dasarnya `GameMaster` melakukan seluruh pekerjaan tentang mekanisme game yang terjadi. Sebagai contohnya adalah tempat `Ball` untuk di populasi dan generate, tempat untuk menyimpan `score`, `combo`, `miss` dan lain sebagainya. Terdapat method untuk memilih planet yang benar atau salah sehingga game dapat dimainkan.

### 7. Scene
Merupakan inhertance dari JPanel. Merupakan class yang digunakan untuk menggambar suatu scene. Class `Scene` telah didesain sedemikian rupa agar dapat digunakan sebagai superclass dari scene - scene yang lainnya. Karena class `Scene` terdapat 2 method yang dapat di override yaitu `DrawObjects` dan `ClearObjects`.

### 8. SceneMainMenu
Merupakan inhertance dari class `Scene` yang memiliki fungsi untuk menggambar scene Main Menu Game. Memiliki internal class bernama `TAdapter` yang digunakan sebagai key listener suatu scene pada JPanel yang merupakan superclass dari class `Scene`.

### 9. SceneGameplay
Merupakan inhertance dari class `Scene` yang memiliki fungsi untuk menggambar scene Gameplay Game. Memiliki internal class bernama `TAdapter` yang digunakan sebagai key listener suatu scene pada JPanel yang merupakan superclass dari class `Scene` yang digunakan untuk memainkan game.

### 10. SceneHighscore
Merupakan inhertance dari class `Scene` yang memiliki fungsi untuk menggambar scene Highscore Game. Memiliki internal class bernama `TAdapter` yang digunakan sebagai key listener suatu scene pada JPanel yang merupakan superclass dari class `Scene`.

### 11. SceneAchievement
Merupakan inhertance dari class `Scene` yang memiliki fungsi untuk menggambar scene Achievement Game. Memiliki internal class bernama `TAdapter` yang digunakan sebagai key listener suatu scene pada JPanel yang merupakan superclass dari class `Scene`.

### 12. SceneCredits
Merupakan inhertance dari class `Scene` yang memiliki fungsi untuk menggambar scene Credits Game. Memiliki internal class bernama `TAdapter` yang digunakan sebagai key listener suatu scene pada JPanel yang merupakan superclass dari class `Scene`.

### 13. Sprite
Merupakan class utama yang digunakan untuk menampung `Image` gambar pada AssetManager. Sprite memiliki property posX dan posY, dan behaviour draw, sehingga `Sprite` dapat digambar dengan mudah pada class `Scene`

### 14. Ball
Merupakan inhertance dari class Sprite. Ball merupakan planet pada Gameplay, kami menggunakan nama ball tidak planet dengan alasan agar dapat dipahami dengan lebih universal. Terdapat behaviour yang digunakan untuk mengatur animation yaitu `Animating()`, dengan behaviour ini menggambar planet dan mengatur posisi planet dapat dilakukan dengan mudah.

### 15. Button
Merupakan suatu class button yang menampung banyak sprite, sehingga kami dapat membuat sesuatu seperti animasi standard, hover dan clicked pada button. Memiliki behaviour yang digunakan untuk mengganti state sekarang pada class `Button` ini.

## Interface
### 1. IScene
Sebuah interface yang mengandung beberapa action dan behaviour mengenai perilaku yang digunakan oleh class `Scene`.

## D. Perubahan dari adaptasi Referensi
Seperti yang telah dibahas sebelumnya, bahwa game Planet Pang mengadaptasi dari game Jungle Pang milik LINE. Berikut merupakan fitur - fitur yang kami tambahkan pada game Planet Pang yang tidak ada pada game Jungle Pang.
- Frenzy System - merupakan gameplay yang dinamis, setiap melakukan combo, seluruh planet berpindah ke kiri atau ke kanan sesuai dengan kondisi sekarang.
- Achievement System - merupakan penambahan sistem pencapaian hasil dari pemain atau player sehingga dapat bermain dan memiliki tujuan untuk bermain.
- Menggunakan Planet bukan Binatang - merupakan tema yang kami pikirkan dan sprite hasil buatan sendiri, sehingga dapat dikatakan bahwa kami mengubah gameplay dari binatang menjadi planet.

# Terima Kasih
