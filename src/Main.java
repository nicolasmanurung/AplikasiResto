// import java.util.List;

// public class Main {

//     private Integer sumPeople;

//     private String nameBuyer;

//     private final Integer MAX_ORDER = 10;

//     //TODO("Create List Menu Variabel - Use List into this and @MenuSpecial.java")

//     //TODO("Create List Menu Order Here")

//     public static void main(String[] args) {
//         System.out.println("Hello world!");
//     }


//     private void setSumPeople(Integer sumPeople) {
//         this.sumPeople = sumPeople;
//     }

//     private void setNameBuyer(String nameBuyer) {
//         this.nameBuyer = nameBuyer;
//     }

//     //TODO("Initialize list default menu here")

//     //TODO("Create function to list Menu Order here, we can using looping like 'for' to input order menu")

//     //TODO("Create function to counting menu * qty")

//     //TODO("showing final output")

// }

import java.util.Scanner;
import java.io.IOException;
import java.text.DecimalFormat;

public class MenuSpecial {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int
            JumlahPesanan,
            PorsiNasi,
            PorsiAyam,
            PorsiSteak,
            PorsiKwetiaw,
            PorsiKambing
        ;
        String NamaPemesan;
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Aplikasi Resto");
        System.out.println("===============================\n");
        System.out.println("\t Selamat Siang...\n");
        System.out.print("\t Pesan untuk berapa orang \t: ");
        JumlahPesanan = input.nextInt();
        System.out.println();
        System.out.print("\t Pesanan atas nama \t\t: ");
        NamaPemesan = input.nextLine();
        input.nextLine();
        System.out.println("\n");

        System.out.println("\t Menu Spesial Hari ini");
        System.out.println("\t ===============================\n");
        System.out.println("\t\t 1. Nasi Goreng Spesial \t\t @ Rp. 9999.99");
        System.out.println("\t\t 2. Ayam Bakar Spesial \t\t\t @ Rp. 12345.67");
        System.out.println("\t\t 3. Steak Sirloin Spesial \t\t @ Rp. 21108.40");
        System.out.println("\t\t 4. Nasi Goreng Spesial \t\t @ Rp. 13579.13");
        System.out.println("\t\t 5. Nasi Goreng Spesial \t\t @ Rp. 98765.43");

        System.out.println("");
        System.out.println("Pesanan Anda (Batas Pesanan 0 - 10 porsi");
        System.out.print("Nasi Goreng Spesial \t= ");
        PorsiNasi = input.nextInt();
        System.out.print("Ayam Bakar Spesial \t= ");
        PorsiAyam = input.nextInt();
        System.out.print("Steak Sirloin Spesial \t= ");
        PorsiSteak = input.nextInt();
        System.out.print("Kwetiaw Siram Spesial \t= ");
        PorsiKwetiaw = input.nextInt();
        System.out.print("Kambing Guling Spesial \t= ");
        PorsiKambing = input.nextInt();
        System.out.println("\n");

        breakConsule();
        System.out.println("Selamat menikmati pesanan anda...");
        System.out.println("");
        
        double NasiGoreng = PorsiNasi*9999.99;
        double AyamBakar = PorsiAyam*12345.67;
        double SteakSirloin = PorsiSteak*21108.40;
        double KwetiawSiram = PorsiKwetiaw*13579.13;
        double KambingGuling = PorsiKambing*98765.43;
        double TotalPembelian = NasiGoreng+AyamBakar+SteakSirloin+KwetiawSiram+KambingGuling;
        double DiskonPembelian = TotalPembelian*0.1;
        double TotalPembayaran = TotalPembelian - DiskonPembelian;
        double PembagianPembayaran = TotalPembayaran/JumlahPesanan;

        System.out.println("Pembelian :\n");
        System.out.println("1. Nasi Goreng Spesial \t\t" +PorsiNasi+ " porsi * Rp. 9999,99  = \t Rp. "+df.format(NasiGoreng));
        System.out.println("2. Ayam Bakar Spesial \t\t" +PorsiAyam+ " porsi * Rp. 12345,67 = \t Rp. "+df.format(AyamBakar));
        System.out.println("3. Steak Sirloin Spesial \t" +PorsiSteak+ " porsi * Rp. 21108,40 = \t Rp. "+df.format(SteakSirloin));
        System.out.println("4. Kwetiaw Siram Spesial \t" +PorsiKwetiaw+ " porsi * Rp. 13579,13 = \t Rp. "+df.format(KwetiawSiram));
        System.out.println("5. Kambing Guling Spesial \t" +PorsiKambing+ " porsi * Rp. 98765,45 = \t Rp. "+df.format(KambingGuling));
        System.out.println("============================================================================== +");
        System.out.println("Total Pembelian \t\t\t\t       = \t Rp. "+df.format(TotalPembelian));
        System.out.println("Disc. 10% (Masa Promosi) \t\t\t       = \t Rp. "+df.format(DiskonPembelian));
        System.out.println("============================================================================== -");
        System.out.println("Total Pembelian setelah disc 10% \t\t\t=\tRp. "+df.format(TotalPembayaran));
        System.out.println();
        System.out.println("Pembelian per orang (untuk "+JumlahPesanan+ " orang)\t\t\t= \tRp. "+df.format(PembagianPembayaran));
        System.out.println();
        System.out.println("Terima Kasih atas Kunjungan Anda....");
        System.out.println("...Tekan Enter untuk keluar....");
        breakConsule();
    }

    private static void breakConsule() {
        try{
            System.in.read();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
