/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fadhlan_todolist;

/**
 *
 * @author MUKTAMAR IX (268)
 */
public class Fadhlan_TodoList {

    /**
     * @param args the command line arguments
     */
   
        // TODO code application logic here
    public static String[]model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * @param args the command line arguments
     */

  public static void main(String[] args) {
    //testshowtodolist();
    //testaddtodolist();
    //testremovetodolist();
    testinput();
    testviewshowtodolist();
  }


  //Menampilkan Todo List
  public static void showtodolist() {
    for (int i = 0; i<model.length;i++){
      String todo = model[i];
      int no = i+1;

      if(todo!= null){
        System.out.println(no+"."+todo);
      }
    }
  }

  public static void testshowtodolist() {
    showtodolist();
  }
  
  //Menampilkan todo ke list
  public static void addtodolist(String todo) {
    //Cek Apakah Model Penuh
    boolean isFull = true;
          for (String model1 : model) {
              if (model1 == null) {
                  //Model Masih Ada Yang Kosong
                  isFull = false;
                  break;}
          }
  //Jika penuh, kita resize ukuran array 2x lipat
     if (isFull) {
        String[] temp = model;
      model = new String[model.length * 2];

        System.arraycopy(temp, 0, model, 0, temp.length);
    }  
  //Tambahkan ke posisi yang dara array nya NULL
     for (int i = 0; i < model.length; i++) {
      if(model[i] == null){
        model[i] = todo;
        break;
      }
    }
  }

    public static void testaddtodolist() {
      for (int i = 0; i < 20; i++) {
        addtodolist("Contoh Todo Ke " + i);
      }
      showtodolist();
     }
      
  //Menghapus todo dari list
  public static boolean removetodolist(Integer number) {
    if  ( (number - 1) >= model.length) {
      return false;
    } else if (model[number - 1] == null){
      return false;
    } else {
      for (int i = (number - 1); i < model.length; i++){
        if (i == (model.length - 1)){
          model[i] = null;
        } else {
          model[i] = model[i + 1];
        }
      }
      return true;
    }
  }
    public static void testremovetodolist() {
      addtodolist("Satu");
      addtodolist("Dua");
      addtodolist("Tiga");
      addtodolist("Empat");
      addtodolist("Lima");

    boolean result = removetodolist(20);
      System.out.println(result);

      result = removetodolist(7);
      System.out.println(result);

      result = removetodolist(2);
      System.out.println(result);

      showtodolist();
    }
      public static String input(String Info) {
        System.out.print(Info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testinput() {
      String nama = input("Nama");
      System.out.println("Haii " + nama);

      String channel = input("Instagram");
      System.out.println(channel);
    }
  
  //Menampilkan todo dari list
  public static void viewshowtodolist() {
    while (true) {
      showtodolist();

      System.out.println("Menu : ");
      System.out.println("1. Tambah ");
      System.out.println("2. Hapus ");
      System.out.println("x. Keluar ");

        String input = input("Pilih");
      if (input.equals("1")) {
        viewaddtodolist();
      } else if (input.equals("2")) {
        viewremovetodolist();
      } else if (input.equals("x")) {
        break;
      } else {
        System.out.println("Pilihan Tidak Dimengerti");
      }
    }
  }

     public static void testviewshowtodolist() {
      addtodolist("Satu");
      addtodolist("Dua");
      addtodolist("Tiga");
      addtodolist("Empat");
      addtodolist("Lima");
      viewshowtodolist();
      
     }

  //Menampilkan view menambahkan todo list
  public static void viewaddtodolist() {
      System.out.println("Menambah  TodoList");
      
          String todo = input("Todo (x Jika Batal)");
      
      if  (todo.equals("x")) {
      //Batal
    } else {
        addtodolist(todo);
    }
  }
  
    public static void testviewaddtodolist() {
       
      addtodolist("Satu");
      addtodolist("Dua");
      
      viewaddtodolist();
      showtodolist();
    }
  
  //Menampilkan view menghapus todo list
  public static void viewremovetodolist() {
      System.out.println("Menghapus TodoList");
      
      String number = input("Nomor Yang Dihapus (x Jika Batal)");
      
      if (number.equals("x")) {
       //Batal   
    } else {
       boolean success = removetodolist(Integer.valueOf(number));
       if (!success) {
           System.out.println("Gagal Menghapus TodoList ; " + number);
       }
       
     }
  }
  
    public static void testviewremovetodolist() {
        
      addtodolist("Satu");
      addtodolist("Dua");
      addtodolist("Tiga");
      
      showtodolist();
      
      viewremovetodolist();
      
      showtodolist();
    }
}

