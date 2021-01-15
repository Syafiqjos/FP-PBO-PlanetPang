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
![PlanetPang - Main Menu](/Images/PlanetPangMainMenu.png) ![PlanetPang - Gameplay](/Images/PlanetPangGameplayNew.png) ![PlanetPang - Achievement](/Images/PlanetPangAchievement.png)

Berikut merupakan video trailer dan penjelasan dari kami berdasarkan commit dan feature yang kami kerjakan.
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
Permainan Planet Pang menggunakan game asli yang berjudul Jungle Pang, yaitu merupakan permainan yang dibuat oleh LINE yang menggunakan system LIFF pada pengaplikasiannya. Berikut merupakan video dari permainan Jungle Pang dan screenshot gameplay-nya.
![JunglePang - Main Menu](/Images/JunglePang.png)
[GAMEPLAY JUNGLE PANG LINE - YOUTUBE](https://www.youtube.com/watch?v=XhqDXo1EDyo)

# Dokumentasi
Setelah membahas gambaran awal pada game Planet Pang, berikut merupakan dokumentasi tentang class dan code - code yang digunakan dan diimplementasikan pada game Planet Pang.

## A. UML Screenshot
Meskipun agak tidak jelas karena mungkin gambar terlalu banyak sehingga hanya muat kecil, tetapi berikut gambarannya.
![Gambar UML](/Images/UMLMe.png)

## B. List Class dan Interface Planet Pang
### Class
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

### Interface
### 1. IScene

## B. Penjelasan List Class dan Interface Planet Pang
### Class
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

### Interface
### 1. IScene

# Terima Kasih
