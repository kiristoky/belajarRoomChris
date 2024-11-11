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

package com.example.inventory.data


import kotlinx.coroutines.flow.Flow

// `ItemsRepository` adalah interface untuk mengelola operasi data terkait entitas `Item`.
// Interface ini mendefinisikan fungsi-fungsi untuk mendapatkan, memasukkan, menghapus, dan memperbarui item.

interface ItemsRepository {

    // Mengembalikan aliran (`Flow`) daftar semua item dari database secara real-time.
    fun getAllItemsStream(): Flow<List<Item>>

    // Mengembalikan aliran (`Flow`) untuk item tertentu berdasarkan ID, atau `null` jika item tidak ditemukan.
    fun getItemStream(id: Int): Flow<Item?>

    // Menyisipkan item baru ke dalam database. Fungsi ini bersifat `suspend` sehingga dapat berjalan secara asinkron.
    suspend fun insertItem(item: Item)

    // Menghapus item tertentu dari database. Juga bersifat `suspend` untuk mendukung operasi asinkron.
    suspend fun deleteItem(item: Item)

    // Memperbarui data item yang ada dalam database. Fungsi ini juga `suspend` untuk operasi asinkron.
    suspend fun updateItem(item: Item)
}

