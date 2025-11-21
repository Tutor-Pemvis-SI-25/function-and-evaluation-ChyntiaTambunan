//Rivaldo Siagian - 12S25002
// Chyntia Lovenia Tambunan - 12S25015

import java.util.*;
import java.lang.Math;

public class TLAST {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] judul = new String[10], kode = new String[10], matkul = new String[10], dosen = new String[10], waktu = new String[10], nim = new String[10], status = new String[10], hasil1 = new String[10], show = new String[10], perintah = new String[10];
        double[] prioritas = new double[10], deadline = new double[10], tingkat = new double[10];
        int p, a, c, x, k, a1, a2, a3, temp1, temp2, tempp, dx, c1, c2;
        double tempz;
        String temp21, temp3, temp4, temp5, temp6, temp7, temp8, tempx;
        double temp;

        k = 0;
        x = 0;
        p = 0;
        a2 = 0;
        a = 0;
        temp1 = 0;
        tempp = 0;
        temp2 = 0;
        dx = 0;
        for (dx = 0; dx <= 9; dx++) {
            perintah[dx] = "";
            judul[dx] = "";
            kode[dx] = "";
            matkul[dx] = "";
            dosen[dx] = "";
            waktu[dx] = "";
            nim[dx] = "";
            tingkat[dx] = 0;
            deadline[dx] = 0;
            show[dx] = "";
            status[dx] = "";
        }
        for (p = 0; p <= 9; p++) {
            perintah[p] = input.nextLine();
            if (perintah[p].equals("---")) {
                p = 10;
                a = 0;
            } else {
                if (perintah[p].equals("Add task")) {
                    judul[p] = input.nextLine();
                    kode[p] = input.nextLine();
                    matkul[p] = input.nextLine();
                    dosen[p] = input.nextLine();
                    waktu[p] = input.nextLine();
                    nim[p] = input.nextLine();
                    tingkat[p] = Double.parseDouble(input.nextLine());
                    deadline[p] = Double.parseDouble(input.nextLine());
                    prioritas[p] = tingkat[p] * 1.0 / deadline[p];
                    if (prioritas[p] > 3.0) {
                        hasil1[p] = "Penting! Anda harus mengerjakan tugas ini segera";
                    } else {
                        if (prioritas[p] >= 1.5 && prioritas[p] <= 3.0) {
                            hasil1[p] = "Tugas ini memiliki prioritas menengah";
                        } else {
                            if (prioritas[p] < 1.5) {
                                hasil1[p] = "Tugas ini relatif ringan, namun jangan tunda terlalu lama";
                            }
                        }
                    }
                    status[p] = input.nextLine();
                    a1 = p;
                } else {
                    if (perintah[p].equals("Update task status")) {
                        kode[p] = input.nextLine();
                        a = p;
                        for (a2 = 0; a2 <= a; a2++) {
                            for (a3 = 1; a3 <= a; a3++) {
                                if (kode[a2].equals(kode[a3])) {
                                    status[a2] = input.nextLine();
                                    show[a2] = input.nextLine();
                                    temp1 = a3;
                                    a3 = a;
                                    tempp = a2;
                                    a2 = a;
                                }
                            }
                        }
                    }
                    a = p - 1;
                    p = a;
                    a3 = temp1;
                    a2 = tempp;
                }
                temp2 = p;
            }
            a = temp2;
        }
        for (c1 = 0; c1 <= a; c1++) {
            for (c2 = 0; c2 <= a; c2++) {
                if (prioritas[c1] > prioritas[c2]) {
                    tempz = prioritas[c1];
                    prioritas[c1] = prioritas[c2];
                    prioritas[c2] = tempz;
                    tempx = judul[c1];
                    judul[c1] = judul[c2];
                    judul[c2] = tempx;
                    temp21 = kode[c1];
                    kode[c1] = kode[c2];
                    kode[c2] = temp21;
                    temp3 = matkul[c1];
                    matkul[c1] = matkul[c2];
                    matkul[c2] = temp3;
                    temp4 = dosen[c1];
                    dosen[c1] = dosen[c2];
                    dosen[c2] = temp4;
                    temp5 = waktu[c1];
                    waktu[c1] = waktu[c2];
                    waktu[c2] = temp5;
                    temp6 = nim[c1];
                    nim[c1] = nim[c2];
                    nim[c2] = temp6;
                    temp7 = status[c1];
                    status[c1] = status[c2];
                    status[c2] = temp7;
                    temp8 = hasil1[c1];
                    hasil1[c1] = hasil1[c2];
                    hasil1[c2] = temp8;
                }
            }
        }
        for (c = 0; c <= a; c++) {
            if (status[c].equals("Selesai")) {
                System.out.println("Prioritas: " + toFixed(prioritas[c],2));
                System.out.println(judul[c] + "|" + kode[c] + "|" + matkul[c] + "|" + dosen[c] + "|" + nim[c] + "|" + status[c]);
            } else {
                System.out.println("Prioritas: " + toFixed(prioritas[c],2));
                System.out.println(judul[c] + "|" + kode[c] + "|" + matkul[c] + "|" + dosen[c] + "|" + waktu[c] + "|" + nim[c] + "|" + status[c] + "|" + hasil1[c]);
            }
        }
    }
    
    private static String toFixed(double value, int digits) {
        return String.format("%." + digits + "f", value);
    }
}


