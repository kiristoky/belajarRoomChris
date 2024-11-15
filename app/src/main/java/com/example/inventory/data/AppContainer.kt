/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// `AppContainer` adalah interface yang berfungsi sebagai tempat untuk menyediakan `itemsRepository`,
// memungkinkan injeksi dependensi dalam aplikasi.
//
// `AppDataContainer` adalah implementasi dari `AppContainer` yang menyediakan instance `itemsRepository`.
// Dengan menggunakan `OfflineItemsRepository`, kelas ini bertanggung jawab untuk menginisialisasi
// database dan DAO yang diperlukan, lalu menyediakan repositori sebagai singleton.

package com.example.inventory.data

import android.content.Context

interface AppContainer {
    // Repository untuk mengelola item dalam aplikasi.
    val itemsRepository: ItemsRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    // Menginisialisasi `itemsRepository` secara lazy, agar hanya diinisialisasi ketika dibutuhkan.
    override val itemsRepository: ItemsRepository by lazy {
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
    }
}
