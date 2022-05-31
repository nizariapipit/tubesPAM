# tubesPAM

## Deskripsi Singkat 
aplikasi akan menampilkan list berupa gambar dan nama gambar yang sesuai dengan pencarian dari API : https://api.pexels.com/v1/ berdasarkan end point : https://api.pexels.com/v1/search?query=String. aplikasi dapat menuju ke halaman detail dari daftar list yang tersedia dengan menampilkan gambar, judul gambar, nama fotografer, dan id dari fotografer.
- terdapat dua activity : MainActivity dan DetailActivity.
- terdapat dua viewmodel : MainViewModel dan DetailViewModel. keduanya berguna untuk mempertahankan bentuk UI agar tidak berantakan ketika aplikasi mengalamai rotasi.
- terdapat sebuah ListAdapter untuk menampung list dari hasil pencarian dengan menggunakan RecyclerView.
- retrofit digunakan sebagai networking.

## Dependensi
    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.4.1'
    implementation 'com.google.android.material:material:1.6.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    implementation 'de.hdodenhof:circleimageview:3.1.0'
    implementation 'com.github.bumptech.glide:glide:4.13.1'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"
    implementation "com.squareup.okhttp3:logging-interceptor:4.9.0"
    implementation 'com.google.code.gson:gson:2.8.9'
    implementation 'com.loopj.android:android-async-http:1.4.11'
    
## Cara Running
1. pertama import file ke Android Studio.
2. kemudian project harus dibagun terlebih dahulu dengan menekan tombol "build gradle".
3. buka handphone android, aktifkan mode developer.
4. kemudian izinkan install apk via USB.
5. jika proses telah selesai, aplikasi dapat dijalankan dengan menekan tombol "run app" pada Android Studio 
