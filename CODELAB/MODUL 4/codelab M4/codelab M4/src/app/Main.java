package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        // Buku
        Buku b1 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku b2 = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");

        b1.displayInfo();
        b2.displayInfo();

        System.out.println();

        // Anggota
        Anggota a1 = new Anggota("Kiyya", "D146");
        Anggota a2 = new Anggota("Azizi", "D129");
        Anggota a3 = new Anggota("Sopi", "D126");

        a1.displayInfo();
        a2.displayInfo();
        a3.displayInfo();

        System.out.println();

        // Peminjaman
        a1.pinjamBuku("Madilog");
        a2.pinjamBuku("Hainuwele: Sang Putri Kelapa", 7);

        System.out.println();

        // Pengembalian
        a1.kembalikanBuku("Madilog");
        a2.kembalikanBuku("Hainuwele: Sang Putri Kelapa");
    }
}
